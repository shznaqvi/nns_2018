package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Context;
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
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.BLRandomContract;
import edu.aku.hassannaqvi.nns_2018.contracts.FormsContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
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
    DatabaseHelper db;
    Collection<BLRandomContract> selected;
    int progressStatus = 0;
    Handler handler = new Handler();
    Boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_a1);
        db = new DatabaseHelper(this);
        binding.setCallback(this);

        SetupViewFunctionality();

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
        binding.nh110.setText(null);
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
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                //Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
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
        if (!validatorClass.EmptyTextBox(this, binding.nh110, getString(R.string.nh110))) {
            return false;
        }
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

            if (MainApp.selectedHead.getSelStructure().equals("1") && !binding.na11802a.isChecked()) {
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
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();


        MainApp.fc = new FormsContract();

        MainApp.fc.setDevicetagID(MainApp.getTagName(this));
        MainApp.fc.setFormDate(dtToday);
        MainApp.fc.setUser(MainApp.userName);
        MainApp.fc.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.fc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.fc.setRespLineNo(MainApp.lineNo);
        MainApp.fc.setEnmNo(binding.nh102.getText().toString());
        MainApp.fc.setHhNo(binding.nh108.getText().toString().toUpperCase());


        setGPS(); // Set GPS

        JSONObject sA1 = new JSONObject();

        sA1.put("rndid", MainApp.selectedHead.get_ID());
        sA1.put("luid", MainApp.selectedHead.getLUID());
        sA1.put("randDT", MainApp.selectedHead.getRandomDT());
        sA1.put("hh03", MainApp.selectedHead.getStructure());
        sA1.put("hh07", MainApp.selectedHead.getExtension());
        sA1.put("hhhead", MainApp.selectedHead.getHhhead());
        sA1.put("hh09", MainApp.selectedHead.getContact());
        sA1.put("hhss", MainApp.selectedHead.getSelStructure());
        sA1.put("hhheadpresent", binding.checkHHHeadpresent.isChecked() ? "1" : "2");
        sA1.put("hhheadpresentnew", binding.newHHheadname.getText().toString());

        sA1.put("nh101", binding.nh101.getText().toString());

        sA1.put("nh103", binding.nh103.getText().toString());
        sA1.put("nh104", binding.nh104.getText().toString());
        sA1.put("nh105", binding.nh105.getText().toString());
        sA1.put("nh106", binding.nh106.getText().toString());

        sA1.put("nh110", binding.nh110.getText().toString());
        sA1.put("nh113", binding.nh113.getText().toString());
        sA1.put("nh115", binding.nh115.getText().toString());

        sA1.put("nh213", binding.nh213.getText().toString());

        sA1.put("nh11701blood", MainApp.selectedHead.getSelStructure());
        sA1.put("nh11702urine", MainApp.selectedHead.getSelStructure());
        sA1.put("nh11703water", MainApp.selectedHead.getSelStructure());

        sA1.put("nh11801", binding.na11801a.isChecked() ? "1"
                : binding.na11801b.isChecked() ? "2" : "0");

        sA1.put("nh11802", binding.na11802a.isChecked() ? "1"
                : binding.na11802b.isChecked() ? "2" : "0");

//        na117
        sA1.put("nh119a", binding.na119a.isChecked() ? "1" : "0");
        sA1.put("nh119b", binding.na119b.isChecked() ? "2" : "0");
        sA1.put("nh119c", binding.na119c.isChecked() ? "3" : "0");
        sA1.put("nh119d", binding.na119d.isChecked() ? "4" : "0");
        sA1.put("nh119e", binding.na119e.isChecked() ? "5" : "0");
        sA1.put("nh119f", binding.na119f.isChecked() ? "6" : "0");
        sA1.put("nh119g", binding.na119g.isChecked() ? "7" : "0");
        sA1.put("nh11996", binding.na11996.isChecked() ? "96" : "0");
        sA1.put("nh11996x", binding.na11996x.getText().toString());

        MainApp.fc.setsA1(String.valueOf(sA1));

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

            MainApp.fc.setGpsLat(lat);
            MainApp.fc.setGpsLng(lang);
            MainApp.fc.setGpsAcc(acc);
            MainApp.fc.setGpsDT(date); // Timestamp is converted to date above
            MainApp.fc.setGpsElev(elevation);

            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

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
        }
    }

    public void BtnCheckHH() {

        if (!binding.nh102.getText().toString().trim().isEmpty() && !binding.nh108.getText().toString().trim().isEmpty()) {

            selected = db.getAllBLRandom(binding.nh102.getText().toString(), binding.nh108.getText().toString().toUpperCase());

            if (selected.size() != 0) {

                Toast.makeText(this, "Head found in this HH.", Toast.LENGTH_SHORT).show();

                for (BLRandomContract rnd : selected) {
                    MainApp.selectedHead = new BLRandomContract(rnd);
                }

                binding.hhName.setText(MainApp.selectedHead.getHhhead().toUpperCase());

                binding.fldGrpnh110.setVisibility(View.VISIBLE);

            } else {

                clearFields();

                Toast.makeText(this, "No Head found in this HH.", Toast.LENGTH_SHORT).show();
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
