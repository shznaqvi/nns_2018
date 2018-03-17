package edu.aku.hassannaqvi.nns_2018.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import net.glxn.qrgen.android.QRCode;
import net.glxn.qrgen.core.image.ImageType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionA2QrgenBinding;

public class SectionA2QRgenActivity extends AppCompatActivity {

    static int progress = 0;
    ActivitySectionA2QrgenBinding binding;
    DatabaseHelper db;
    List<String> membersList;
    Map<String, FamilyMembersContract> membersListMap;
    List<FamilyMembersContract> selectedChildrens;
    FamilyMembersContract selectedMember;
    int progressStatus = 0;
    Handler handler = new Handler();
    int mwraCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_a2_qrgen);
        binding.setCallback(this);

//        Initialize db
        db = new DatabaseHelper(this);

//        Working for QR-GENERATOR

        // Initializing
        membersListMap = new HashMap<>();
        membersList = new ArrayList<>();
        membersList.add("....");

//        Setup Spinner

        for (FamilyMembersContract famMwra : MainApp.mwra) {
            if (!famMwra.getMaritialStatus().equals("5")) {
                membersList.add(famMwra.getName() + "_" + famMwra.getSerialNo());
                membersListMap.put(famMwra.getName() + "_" + famMwra.getSerialNo(), famMwra);
                mwraCount++;
            }
        }

        for (FamilyMembersContract famChild : MainApp.childNA) {
            membersList.add(famChild.getName() + "_" + famChild.getSerialNo());
            membersListMap.put(famChild.getName() + "_" + famChild.getSerialNo(), famChild);
        }

        binding.spMembers.setAdapter(new ArrayAdapter<>(this, R.layout.item_style, membersList));

        binding.spMembers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selectedChildrens = new ArrayList<>();

                if (binding.spMembers.getSelectedItemPosition() != 0) {

                    selectedMember = membersListMap.get(binding.spMembers.getSelectedItem());

                    if (position <= mwraCount) {

                        for (FamilyMembersContract fam : MainApp.familyMembersList) {
                            if (fam.getMotherId().equals(selectedMember.getSerialNo())) {
                                selectedChildrens.add(fam);
                            }
                        }

                        new GenerateQRTask(SectionA2QRgenActivity.this, selectedMember, selectedChildrens, 1).execute(); // 1 means mother
                    } else {
                        new GenerateQRTask(SectionA2QRgenActivity.this, selectedMember, selectedChildrens, 2).execute(); // 2 means child NA
                    }
                } else {
                    binding.imgQRcode.setImageBitmap(null);
                    binding.getData.setText(null);
                    binding.fldGrp01.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void BtnContinue() {
        binding.progress.setVisibility(View.VISIBLE);

        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus = doSomeWork();
                    handler.post(new Runnable() {
                        public void run() {
                            binding.progress.setProgress(progressStatus);
                        }
                    });
                }
                handler.post(new Runnable() {
                    public void run() {

                        progress = 0;
                        finish();
                        startActivity(new Intent(SectionA2QRgenActivity.this, SectionA4Activity.class));
                    }
                });
            }

            private int doSomeWork() {
                try {
                    // ---simulate doing some work---
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return ++progress;
            }
        }).start();
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }

    public JSONObject CreateJSON(FamilyMembersContract fmc) throws JSONException {
        JSONObject sA2 = new JSONObject();
        sA2.put("_UID ", fmc.get_UID());
        sA2.put("name ", fmc.getName());
        sA2.put("_UUID ", fmc.get_UUID());
        sA2.put("serialNo ", fmc.getSerialNo());
        sA2.put("enmNo ", fmc.getEnmNo());
        sA2.put("hhNo ", fmc.getHhNo());
        return sA2;
    }

    public class GenerateQRTask extends AsyncTask<Void, Void, Void> {

        ProgressDialog Asycdialog;
        Context mContext;
        Bitmap bitmap;
        private FamilyMembersContract selectedMem;
        private List<FamilyMembersContract> selectedSubMem;
        private int type;
        private String ScannedInfo = "";

        public GenerateQRTask(Context mContext, FamilyMembersContract selectedMem, List<FamilyMembersContract> selectedSubMem, int type) {
            this.mContext = mContext;
            this.selectedMem = selectedMem;
            this.selectedSubMem = selectedSubMem;
            this.type = type;
        }

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            Asycdialog = new ProgressDialog(mContext);
            Asycdialog.setTitle("GENERATING QR");
            Asycdialog.setMessage("Loading...");
            Asycdialog.setCancelable(false);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Asycdialog.show();
                }
            }, 500); // starting it in 1 second
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            JSONArray jsonSync = new JSONArray();
            JSONArray childJsonSync = null;
            // do the task you want to do. This will be executed in background.
            try {

                JSONObject sA = new JSONObject();
                sA.put("_UID ", selectedMem.get_UID());
                sA.put("name ", selectedMem.getName());
                sA.put("_UUID ", selectedMem.get_UUID());
                sA.put("serialNo ", selectedMem.getSerialNo());
                sA.put("enmNo ", selectedMem.getEnmNo());
                sA.put("hhNo ", selectedMem.getHhNo());
                sA.put("type ", String.valueOf(type));
                sA.put("sA2 ", "");


                // Setting in string
                ScannedInfo += (type == 1 ? "Mother" : "Child (N/A)") + ":\nSerial:" + selectedMem.getSerialNo() + "\nNAME:" + selectedMem.getName().toUpperCase() + "\nEnumeration No:" + selectedMem.getEnmNo() + "\nHHNo:" + selectedMem.getHhNo();

                if (selectedSubMem.size() > 0) {
                    childJsonSync = new JSONArray();

                    ScannedInfo += "\nChildrens:\n";
                    int i = 0;
                    for (FamilyMembersContract fmc : selectedSubMem) {
                        childJsonSync.put(CreateJSON(fmc));

                        i++;

                        ScannedInfo += i + "):Serial:" + fmc.getSerialNo() + "\nNAME:" + fmc.getName().toUpperCase() + "\n";

                    }
                    sA.put("sA2", childJsonSync);
                }
                jsonSync.put(sA);

                bitmap = QRCode.from(String.valueOf(jsonSync)).withCharset("UTF-8").to(ImageType.JPG).withSize(216, 216).bitmap();

                if (selectedSubMem.size() < 20) {
                    Thread.sleep(3000);
                }
//                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            super.onPostExecute(result);
            binding.imgQRcode.setImageBitmap(bitmap);
            binding.getData.setText(ScannedInfo);

            binding.fldGrp01.setVisibility(View.VISIBLE);

            Asycdialog.dismiss();
            Toast.makeText(mContext, "Copying done!!", Toast.LENGTH_SHORT).show();
        }
    }
}
