package edu.aku.hassannaqvi.nns_2018.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
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

    ActivitySectionA2QrgenBinding binding;
    DatabaseHelper db;

    List<String> mothersList;
    Map<String, FamilyMembersContract> mothersListMap;

    List<FamilyMembersContract> selectedChildrens;
    FamilyMembersContract selectedMother;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_a2_qrgen);
        binding.setCallback(this);

//        Initialize db
        db = new DatabaseHelper(this);

//        Working for QR-GENERATOR

        mothersListMap = new HashMap<>();
        mothersList = new ArrayList<>();
        mothersList.add("....");

//        Setup Spinner
        for (FamilyMembersContract fam : MainApp.mwra) {
            if (!fam.getMaritialStatus().equals("5")) {
                mothersList.add(fam.getName() + "_" + fam.getSerialNo());
                mothersListMap.put(fam.getName() + "_" + fam.getSerialNo(), fam);
            }
        }

        binding.spMembers.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, mothersList));

        binding.spMembers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selectedChildrens = new ArrayList<>();

                if (binding.spMembers.getSelectedItemPosition() != 0) {

                    selectedMother = mothersListMap.get(binding.spMembers.getSelectedItem());

                    for (FamilyMembersContract fam : MainApp.familyMembersList) {
                        if (fam.getMotherId().equals(selectedMother.getSerialNo())) {
                            selectedChildrens.add(fam);
                        }
                    }


                    new GenerateQRTask(SectionA2QRgenActivity.this, selectedMother, selectedChildrens).execute();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
        private FamilyMembersContract selectedMother;
        private List<FamilyMembersContract> selectedChildrens;

        public GenerateQRTask(Context mContext, FamilyMembersContract selectedMother, List<FamilyMembersContract> selectedChildrens) {
            this.mContext = mContext;
            Asycdialog = new ProgressDialog(mContext);
            this.selectedMother = selectedMother;
            this.selectedChildrens = selectedChildrens;
        }

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            Asycdialog.setTitle("GENERATING QR");
            Asycdialog.setMessage("Loading...");
            Asycdialog.setCancelable(false);
            Asycdialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            JSONArray jsonSync = null;
            JSONArray childJsonSync = null;
            // do the task you want to do. This will be executed in background.
            try {

                JSONObject sA = new JSONObject();
                sA.put("_UID ", selectedMother.get_UID());
                sA.put("name ", selectedMother.getName());
                sA.put("_UUID ", selectedMother.get_UUID());
                sA.put("serialNo ", selectedMother.getSerialNo());
                sA.put("enmNo ", selectedMother.getEnmNo());
                sA.put("hhNo ", selectedMother.getHhNo());

                if (selectedChildrens.size() > 0) {
                    childJsonSync = new JSONArray();
                    for (FamilyMembersContract fmc : selectedChildrens) {
                        childJsonSync.put(CreateJSON(fmc));
                    }
                    sA.put("sA2", childJsonSync);
                }
                jsonSync.put(sA);

                bitmap = QRCode.from(String.valueOf(jsonSync)).withCharset("UTF-8").to(ImageType.JPG).withSize(700, 700).bitmap();

                if (selectedChildrens.size() < 20) {
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
            Asycdialog.dismiss();
            Toast.makeText(mContext, "Copying done!!", Toast.LENGTH_SHORT).show();
        }
    }
}
