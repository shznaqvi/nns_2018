package edu.aku.hassannaqvi.nns_2018.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.BLRandom;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.FormContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper_DBFlow;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionA1Binding;
import edu.aku.hassannaqvi.nns_2018.other.MembersCount;
import edu.aku.hassannaqvi.nns_2018.validation.clearClass;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionA1Activity extends AppCompatActivity {

    private static final String TAG = SectionA1Activity.class.getName();
    static int progress = 0;
    ActivitySectionA1Binding binding;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    DatabaseHelper_DBFlow db;
    Collection<BLRandom> selected;
    int progressStatus = 0;
    Handler handler = new Handler();
    Boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_a1);
        db = new DatabaseHelper_DBFlow(this);
        binding.setCallback(this);

        SetupViewFunctionality();

        String strEnglish = "LED";
        String LRM = String.valueOf(((char) 0x200E));  // This is a LRM
        //getString(R.string.nw301b);
        // binding.testview.setText(getString(R.string.nh313ca)+ " \\u200E"+strEnglish +" \\u200E"+  getString(R.string.nh313c)  );

        SkipPatterns();
    }

    private void SkipPatterns() {

        binding.na11801.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.na11801a) {
                    clearClass.ClearAllFields(binding.fldGrpna113, false);
                } else {
                    clearClass.ClearAllFields(binding.fldGrpna113, true);
                }
            }
        });

    }

    public void SetupViewFunctionality() {

        //  Members Initialization
        MainApp.membersCount = new MembersCount();

        //  Setting members in map for Section A2
        Map<Integer, Map<Integer, Integer>> mem = new HashMap<>();
        Map<Integer, Integer> memType = new HashMap<>();
        memType.put(1, 0);
        memType.put(2, 0);

        mem.put(1, memType);
        mem.put(2, memType);
        mem.put(3, memType);

        MainApp.membersCount.setMembers(mem);
        MainApp.membersCount.setMwra(0);
        MainApp.membersCount.setWra(0);

        MainApp.members_f_m = new ArrayList<>();
        MainApp.respList = new ArrayList<>();
        MainApp.all_members = new ArrayList<>();
        MainApp.childUnder2 = new ArrayList<>();
        MainApp.childUnder5 = new ArrayList<>();
        MainApp.childUnder5 = new ArrayList<>();
        MainApp.childNA = new ArrayList<>();
        MainApp.mwra = new ArrayList<>();
        MainApp.adolescents = new ArrayList<>();
        MainApp.serial_no = 0;

//        Checking IsHead
        MainApp.IsHead = false;
        MainApp.IsResp = false;

//        Checking B6 Section
        MainApp.B6Flag = true;
        MainApp.B2B6Flag = false;

//        Listener

        binding.nh102.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.nh108.setText(null);
                binding.fldGrpnh101.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


//        FamilyMembersList initialization
        MainApp.familyMembersList = new ArrayList<>();
        MainApp.hhClicked = new ArrayList<>();

//        HH Checkbox validate
        /* binding.checkHHHeadpresent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    binding.fldGrpnh110a.setVisibility(View.GONE);
                    binding.newHHheadname.setText(null);
                } else {
                    binding.fldGrpnh110a.setVisibility(View.VISIBLE);
                }
            }
        });*/

//        HH listener
        binding.nh108.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                clearFields();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void clearFields() {
        binding.fldGrpnh110.setVisibility(View.GONE);

        binding.hhName.setText(null);
        binding.newHHheadname.setText(null);
        binding.checkHHHeadpresent.setChecked(false);
        // binding.nh110.setText(null);
        binding.nh113.setText(null);
        binding.nh115.setText(null);
        binding.nh213.setText(null);
        binding.na11801.clearCheck();
        binding.na11802.clearCheck();
    }

    public void BtnContinue() {

        //Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {

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
                                startActivity(new Intent(SectionA1Activity.this, SectionA2ListActivity.class));
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


            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {

        flag = true;
        //Toast.makeText(this, "Processing End Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    SectionA1Activity.this);
            alertDialogBuilder
                    .setMessage("Do you want to Exit??")
                    .setCancelable(false)
                    .setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    try {
                                        SaveDraft();
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    if (UpdateDB()) {

                                        finish();

                                        startActivity(new Intent(SectionA1Activity.this, EndingActivity.class).putExtra("complete", false));

                                    } else {
                                        Toast.makeText(SectionA1Activity.this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
            alertDialogBuilder.setNegativeButton("No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = alertDialogBuilder.create();
            alert.show();
        }
    }

    public boolean formValidation() {

        //Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//        nh101
        if (!validatorClass.EmptyTextBox(this, binding.nh101, getString(R.string.nh101))) {
            return false;
        }

//        nh102
        if (!validatorClass.EmptyTextBox(this, binding.nh102, getString(R.string.nh102))) {
            return false;
        }

//        nh108

        if (binding.nh108.getText().toString().length() == 6) {
            String[] str = binding.nh108.getText().toString().split("-");
            if (str.length > 2 || binding.nh108.getText().toString().charAt(4) != '-' || !str[0].matches("[0-9]+") || !str[1].matches("[a-zA-Z]")) {
                binding.nh108.setError("Wrong presentation!!");
                return false;
            }
        } else {
            Toast.makeText(this, "Invalid length: " + getString(R.string.nh108), Toast.LENGTH_SHORT).show();
            binding.nh108.setError("Invalid length");
            return false;
        }

//        New HHHead

        if (!binding.checkHHHeadpresent.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, binding.newHHheadname, "New head name.")) {
                return false;
            }
        }

//        nh110
       /* if (!validatorClass.EmptyTextBox(this, binding.nh110, getString(R.string.nh110))) {
            return false;
        }*/
//        nh113
        if (!flag) {
            if (!validatorClass.EmptyTextBox(this, binding.nh113, getString(R.string.nh113))) {
                return false;
            }
//        nh115
            if (!validatorClass.EmptyTextBox(this, binding.nh115, getString(R.string.nh115))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, binding.nh115, 18, 99, getString(R.string.nh115), "age")) {
                return false;
            }

//        nh213
            if (!validatorClass.EmptyTextBox(this, binding.nh213, getString(R.string.nh213))) {
                return false;
            }

//        na11801
            if (!validatorClass.EmptyRadioButton(this, binding.na11801, binding.na11801b, getString(R.string.na11801))) {
                return false;
            }
//        na11802
            if (!validatorClass.EmptyRadioButton(this, binding.na11802, binding.na11802b, getString(R.string.na11802))) {
                return false;
            }

            if (MainApp.selectedHead.getHh_selec_stru().equals("1") && !binding.na11802a.isChecked()) {
                binding.na11802a.setError("Wrong Selection");
                Toast.makeText(this, "Wrong Selection", Toast.LENGTH_SHORT).show();
                return false;
            }

//        na113
            if (binding.na11801b.isChecked()) {
                if (!validatorClass.EmptyCheckBox(this, binding.fldGrpna113, binding.na11996, binding.na11996x, String.valueOf(R.string.na113))) {
                    return false;
                }
            }
        }

        return true;
    }

    private void SaveDraft() throws JSONException {

        MainApp.fc = new FormContract();

        MainApp.fc.setDevicetagid(MainApp.getTagName(this));
        MainApp.fc.setFormdate(dtToday);
        MainApp.fc.setUser(MainApp.userName);
        MainApp.fc.setDeviceid(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.fc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.fc.setResp_lno(MainApp.lineNo);
        MainApp.fc.setEnm_no(binding.nh102.getText().toString());
        MainApp.fc.setHh_no(binding.nh108.getText().toString().toUpperCase());


        MainApp.fc.setRndid(MainApp.selectedHead.get_id() + "");

        MainApp.fc.setLuid(MainApp.selectedHead.getLUID());
        MainApp.fc.setRandDT(MainApp.selectedHead.getRandDT());
        MainApp.fc.setHh03(MainApp.selectedHead.getStruc_no());
        MainApp.fc.setHh07(MainApp.selectedHead.getFamily_ext());
        MainApp.fc.setHhhead(MainApp.selectedHead.getHh_head());
        MainApp.fc.setHh09(MainApp.selectedHead.getContact_no());
        MainApp.fc.setHhss(MainApp.selectedHead.getHh_selec_stru());
        MainApp.fc.setHhheadpresent(binding.checkHHHeadpresent.isChecked() ? "1" : "2");
        MainApp.fc.setHhheadpresentnew(binding.newHHheadname.getText().toString());
        MainApp.fc.setNh101(binding.nh101.getText().toString());
        MainApp.fc.setNh103(binding.nh103.getText().toString());

        MainApp.fc.setNh104(binding.nh104.getText().toString());
        MainApp.fc.setNh105(binding.nh105.getText().toString());
        MainApp.fc.setNh106(binding.nh106.getText().toString());
        MainApp.fc.setNh113(binding.nh113.getText().toString());
        MainApp.fc.setNh115(binding.nh115.getText().toString());
        MainApp.fc.setNh213(binding.nh213.getText().toString());

        MainApp.fc.setNh115(binding.nh213.getText().toString());
        MainApp.fc.setNh11701blood(MainApp.selectedHead.getHh_selec_stru());
        MainApp.fc.setNh11702urine(MainApp.selectedHead.getHh_selec_stru());
        MainApp.fc.setNh11703water(MainApp.selectedHead.getHh_selec_stru());
        MainApp.fc.setNh11801(binding.na11801a.isChecked() ? "1"
                : binding.na11801b.isChecked() ? "2" : "0");
        MainApp.fc.setNh11802(binding.na11802a.isChecked() ? "1"
                : binding.na11802b.isChecked() ? "2" : "0");

        MainApp.fc.setNh119a(binding.na119a.isChecked() ? "1" : "0");
        MainApp.fc.setNh119b(binding.na119b.isChecked() ? "1" : "0");
        MainApp.fc.setNh119c(binding.na119c.isChecked() ? "1" : "0");
        MainApp.fc.setNh119d(binding.na119d.isChecked() ? "1" : "0");
        MainApp.fc.setNh119e(binding.na119e.isChecked() ? "1" : "0");
        MainApp.fc.setNh119f(binding.na119f.isChecked() ? "1" : "0");
        MainApp.fc.setNh119g(binding.na119g.isChecked() ? "1" : "0");
        MainApp.fc.setNh11996(binding.na11996.isChecked() ? "1" : "0");
        MainApp.fc.setNh11996x(binding.na11996x.getText().toString());


        setGPS(); // Set GPS

//        JSONObject sA1 = new JSONObject();


        //MainApp.fc.setSA1(String.valueOf(sA1));

    }

    public void setGPS() {
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);
        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");
            String elevation = GPSPref.getString("Elevation", "0");

            if (lat == "0" && lang == "0") {
                Toast.makeText(this, "Could not obtained GPS points", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();
            }

            String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

           /* MainApp.fc.setGpsLat(lat);
            MainApp.fc.setGpsLng(lang);
            MainApp.fc.setGpsAcc(acc);
            MainApp.fc.setGpsDT(date); // Timestamp is converted to date above
            MainApp.fc.setGpsElev(elevation);
*/
            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }

    private boolean UpdateDB() {


        long updCount = MainApp.fc.insert();

        if (updCount != 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            MainApp.fc.set_uid(
                    (MainApp.fc.getDeviceid() + MainApp.fc._id));
            return true;

        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

        /*DatabaseHelper_DBFlow db = new DatabaseHelper_DBFlow(this);

        long updcount = db.addForm(MainApp.fc);

        MainApp.fc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.fc.setUID(
                    (MainApp.fc.getDeviceID() + MainApp.fc.get_ID()));
            db.updateFormID();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/
    }

    public void BtnCheckHH() {

        if (!binding.nh102.getText().toString().trim().isEmpty() && !binding.nh108.getText().toString().trim().isEmpty()) {

            selected = db.getAllBLRandom(binding.nh102.getText().toString(), binding.nh108.getText().toString().toUpperCase());

            if (selected.size() != 0) {

                Toast.makeText(this, "Household head found!", Toast.LENGTH_SHORT).show();

                for (BLRandom rnd : selected) {
                    MainApp.selectedHead = new BLRandom(rnd);
                }

                binding.hhName.setText(MainApp.selectedHead.getHh_head().toUpperCase());

                binding.fldGrpnh110.setVisibility(View.VISIBLE);

            } else {

                clearFields();

                Toast.makeText(this, "No Household head found!", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Not found.", Toast.LENGTH_SHORT).show();
        }

    }

    public void BtnCheckEnm() {

        if (validatorClass.EmptyTextBox(this, binding.nh102, getString(R.string.nh102))) {

            String selected = db.getEnumBlock(binding.nh102.getText().toString());
            if (!selected.equals("")) {

                String[] selSplit = selected.split("\\|");

                binding.nh103.setText(selSplit[0]);
                binding.nh104.setText(selSplit[1].equals("") ? "----" : selSplit[1]);
                binding.nh105.setText(selSplit[2].equals("") ? "----" : selSplit[2]);
                binding.nh106.setText(selSplit[3]);

                binding.fldGrpnh101.setVisibility(View.VISIBLE);

            } else {
                binding.nh108.setText(null);
                Toast.makeText(this, "Sorry not found any block", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
