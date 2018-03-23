package edu.aku.hassannaqvi.nns_2018.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.ChildContract;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionC1Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionC1Activity extends AppCompatActivity {

    public static int counter = 1;
    public static int counterPerMom = 0;
    public static int counterPerNA = 0;
    public static String selectedChildName = "";
    public static boolean isNA;
    public static int Childsize = 0;
    public static int NAChildsize = 0;
    static List<String> childU5;
    static Map<String, FamilyMembersContract> childMap;
    private final long DELAY = 1000;
    Map<String, String> respMap;
    ArrayList<String> respName;
    ActivitySectionC1Binding binding;
    DatabaseHelper db;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_c1);
        db = new DatabaseHelper(this);
        respName = new ArrayList<>();
        respName.add("....");
        respMap = new HashMap<>();
        //childMap = new HashMap<>();

//        Assigning data to UI binding
        binding.setCallback(this);


//        Setup views
        if (getIntent().getBooleanExtra("reBackComing", true)) {
            if (getIntent().getBooleanExtra("childFlag", false)) {
                childU5.remove(getIntent().getStringExtra("name"));
                counter++;
            } else {

                counter = 1;
                counterPerMom = 0;
                counterPerNA = 0;

                childU5 = new ArrayList<>();
                childMap = new HashMap<>();

                childU5.add("....");

                if (isNA) {
                    for (FamilyMembersContract fmc : MainApp.childNA) {
                        childMap.put(fmc.getName() + "-" + fmc.getSerialNo(), fmc);
                        childU5.add(fmc.getName() + "-" + fmc.getSerialNo());
                        counterPerNA++;
                    }

                    NAChildsize = MainApp.childNA.size();

                } else {
                    for (FamilyMembersContract fmc : MainApp.childUnder5) {
                        if (fmc.getMotherId().equals(MainApp.mc.getB1SerialNo())) {
                            childMap.put(fmc.getName() + "-" + fmc.getSerialNo(), fmc);
                            childU5.add(fmc.getName() + "-" + fmc.getSerialNo());
                            counterPerMom++;
                        }
                    }

                    Childsize = MainApp.childUnder5.size();
                }
            }
        } else {

            if (isNA) {
                for (int i = NAChildsize; i < MainApp.childNA.size(); i++) {
                    childMap.put(MainApp.childNA.get(i).getName() + "-" + MainApp.childNA.get(i).getSerialNo(), MainApp.childNA.get(i));
                    childU5.add(MainApp.childNA.get(i).getName() + "-" + MainApp.childNA.get(i).getSerialNo());
                    counterPerNA++;
                }
                NAChildsize = MainApp.childNA.size();
            } else {
                for (int i = Childsize; i < MainApp.childUnder5.size(); i++) {
                    childMap.put(MainApp.childUnder5.get(Childsize).getName() + "-" + MainApp.childUnder5.get(Childsize).getSerialNo(), MainApp.childUnder5.get(Childsize));
                    childU5.add(MainApp.childUnder5.get(Childsize).getName() + "-" + MainApp.childUnder5.get(Childsize).getSerialNo());
                    counterPerMom++;
                }
                Childsize = MainApp.childUnder5.size();
            }
        }

        for (FamilyMembersContract fmc : MainApp.respList) {
            respName.add(fmc.getName() + "-" + fmc.getSerialNo());
            respMap.put(fmc.getName() + "-" + fmc.getSerialNo(), fmc.getSerialNo());
        }

        // setup head
        if (!isNA) {
            binding.txtCounter.setText("Count " + counter + " out of " + counterPerMom);
        } else {
            binding.txtCounter.setText("Count " + counter + " out of " + counterPerNA);
        }

        // setup spinner
        binding.nc101.setAdapter(new ArrayAdapter<>(this, R.layout.item_style, childU5));
        binding.resp.setAdapter(new ArrayAdapter<>(this, R.layout.item_style, respName));
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }

    public void BtnContinue() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                //Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                if (Integer.valueOf(childMap.get(binding.nc101.getSelectedItem().toString()).getAgeInYear()) < 2) {
                    startActivity(new Intent(this, SectionC2Activity.class)
                            .putExtra("selectedChild", childMap.get(binding.nc101.getSelectedItem().toString())));
                } else {
                    startActivity(new Intent(this, SectionC3Activity.class)
                            .putExtra("selectedChild", childMap.get(binding.nc101.getSelectedItem().toString())));
                }

               /* startActivity(new Intent(this, SectionC5Activity.class)
                        .putExtra("selectedChild", childMap.get(binding.nc101.getSelectedItem().toString())));*/
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {

        //if (formValidation()) {
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            //Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

            //finish();

            MainApp.endChildActivity(this, this, false);

        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
        //}
    }

    private boolean formValidation() {
        //Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//        nc101
        if (!validatorClass.EmptySpinner(this, binding.nc101, getString(R.string.nc101))) {
            return false;
        }
//        nc103
        if (!validatorClass.EmptyRadioButton(this, binding.nc103, binding.nc10398, getString(R.string.nc103))) {
            return false;
        }
//        nc104
        return validatorClass.EmptyRadioButton(this, binding.nc104, binding.nc10498, getString(R.string.nc104));
    }

    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        selectedChildName = binding.nc101.getSelectedItem().toString();

        MainApp.cc = new ChildContract();

        MainApp.cc.setDevicetagID(MainApp.getTagName(this));
        MainApp.cc.setFormDate(dtToday);
        MainApp.cc.setUser(MainApp.userName);
        MainApp.cc.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.cc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);

        if (childMap.get(binding.nc101.getSelectedItem().toString()).getMotherId().equals("00")) {
            MainApp.cc.setUUID(MainApp.fmc.get_UID());
        } else {
            MainApp.cc.setUUID(MainApp.mc.get_UID());
        }

        JSONObject sC1 = new JSONObject();

        sC1.put("respName", binding.resp.getSelectedItem().toString());
        sC1.put("respSerial", respMap.get(binding.resp.getSelectedItem().toString()));

//       nc101
        sC1.put("nc101", binding.nc101.getSelectedItem().toString());
//        nc103
        sC1.put("nc103", binding.nc103a.isChecked() ? "1"
                : binding.nc103b.isChecked() ? "2"
                : binding.nc103c.isChecked() ? "3"
                : binding.nc10398.isChecked() ? "98"
                : "0");

//        nc104
        sC1.put("nc104", binding.nc104a.isChecked() ? "1"
                : binding.nc104b.isChecked() ? "2"
                : binding.nc10498.isChecked() ? "98"
                : "0");

        MainApp.cc.setsC1(String.valueOf(sC1));

        //Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        Long updcount = db.addChildForm(MainApp.cc);
        MainApp.cc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.cc.setUID(
                    (MainApp.cc.getDeviceID() + MainApp.cc.get_ID()));
            db.updateFormChildID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    public void BtnAddMember() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                SectionC1Activity.this);
        alertDialogBuilder
                .setMessage("Are you sure to add missing member?")
                .setCancelable(false)
                .setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                startActivity(new Intent(SectionC1Activity.this, SectionA2ListActivity.class)
                                        .putExtra("reBack", true)
                                        .putExtra("reBackChild", isNA)
                                );
                            }
                        });
        alertDialogBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

}
