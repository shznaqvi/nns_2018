package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
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
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionA1Activity extends AppCompatActivity {

    private static final String TAG = SectionA1Activity.class.getName();
    ActivitySectionA1Binding binding;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    DatabaseHelper db;
    Collection<BLRandomContract> selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_a1);
        db = new DatabaseHelper(this);
        binding.setCallback(this);

        SetupViewFunctionality();
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

        binding.na102.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.na103.setText(null);
                binding.fldGrpna101.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


//        FamilyMembersList initialization
        MainApp.familyMembersList = new ArrayList<>();
        MainApp.hhClicked = new ArrayList<>();

//        HH Checkbox validate
        binding.checkHHHeadpresent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    binding.fldGrpna105a.setVisibility(View.GONE);
                    binding.newHHheadname.setText(null);
                } else {
                    binding.fldGrpna105a.setVisibility(View.VISIBLE);
                }
            }
        });

//        HH listener
        binding.na103.addTextChangedListener(new TextWatcher() {
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
        binding.fldGrpna105.setVisibility(View.GONE);

        binding.hhName.setText(null);
        binding.newHHheadname.setText(null);
        binding.checkHHHeadpresent.setChecked(false);
        binding.na105.setText(null);
        binding.na107.setText(null);
        binding.na108.setText(null);
        binding.na213.setText(null);
        binding.na11201.clearCheck();
        binding.na11202.clearCheck();
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
                //Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, SectionA2ListActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {

        Toast.makeText(this, "Processing End Section", Toast.LENGTH_SHORT).show();
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

//        na101
        if (!validatorClass.EmptyTextBox(this, binding.na101, getString(R.string.na101))) {
            return false;
        }

//        na102
        if (!validatorClass.EmptyTextBox(this, binding.na102, getString(R.string.na102))) {
            return false;
        }
/*

//        na101a
        if (!validatorClass.EmptySpinner(this, binding.na101a, "Province")) {
            return false;
        }
//        na101b
        if (!validatorClass.EmptySpinner(this, binding.na101b, "District")) {
            return false;
        }
//        na101c
        if (!validatorClass.EmptySpinner(this, binding.na101c, "Tehsil/Taluka")) {
            return false;
        }
//        na101d
        if (!validatorClass.EmptySpinner(this, binding.na101d, "City/Village")) {
            return false;
        }
*/

//        na103

        if (binding.na103.getText().toString().length() == 6) {
            String[] str = binding.na103.getText().toString().split("-");
            if (str.length > 2 || binding.na103.getText().toString().charAt(4) != '-' || !str[0].matches("[0-9]+") || !str[1].matches("[a-zA-Z]")) {
                binding.na103.setError("Wrong presentation!!");
                return false;
            }
        } else {
            Toast.makeText(this, "Invalid length: " + getString(R.string.na103), Toast.LENGTH_SHORT).show();
            binding.na103.setError("Invalid length");
            return false;
        }

//        New HHHead

        if (!binding.checkHHHeadpresent.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, binding.newHHheadname, "New head name.")) {
                return false;
            }
        }

//        na105
        if (!validatorClass.EmptyTextBox(this, binding.na105, getString(R.string.na105))) {
            return false;
        }
//        na107
        if (!validatorClass.EmptyTextBox(this, binding.na107, getString(R.string.na107))) {
            return false;
        }
//        na108
        if (!validatorClass.EmptyTextBox(this, binding.na108, getString(R.string.na108))) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, binding.na108, 15, 99, getString(R.string.na108), "age")) {
            return false;
        }

//        na213
        if (!validatorClass.EmptyTextBox(this, binding.na213, getString(R.string.na213))) {
            return false;
        }
/*
//        na11101blood
        if (!validatorClass.EmptyRadioButton(this, binding.na11101blood, binding.na11101bloodb, getString(R.string.na11101blood))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na11101urine, binding.na11101urinea, getString(R.string.na11101urine))) {
            return false;
        }
//        na11102water
        if (!validatorClass.EmptyRadioButton(this, binding.na11102water, binding.na11102waterb, getString(R.string.na11102water))) {
            return false;
        }
*/

//        na11201
        if (!validatorClass.EmptyRadioButton(this, binding.na11201, binding.na11201b, getString(R.string.na11201))) {
            return false;
        }
//        na11202
        if (!validatorClass.EmptyRadioButton(this, binding.na11202, binding.na11202b, getString(R.string.na11202))) {
            return false;
        }

        if (MainApp.selectedHead.getSelStructure().equals("1") && !binding.na11202a.isChecked()) {
            binding.na11202a.setError("Wrong Selection");
            Toast.makeText(this, "Wrong Selection", Toast.LENGTH_SHORT).show();
            return false;
        }

//        na113
        if (binding.na11201b.isChecked()) {
            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpna113, binding.na11396, binding.na11396x, String.valueOf(R.string.na113))) {
                return false;
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
        MainApp.fc.setEnmNo(binding.na102.getText().toString());
        MainApp.fc.setHhNo(binding.na103.getText().toString());


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

        sA1.put("nh101", binding.na101.getText().toString());
        //sA1.put("nw102", binding.na102.getText().toString());
        sA1.put("nh103", binding.na101a.getText().toString());
        sA1.put("nh104", binding.na101b.getText().toString());
        sA1.put("nh105", binding.na101c.getText().toString());
        sA1.put("nh106", binding.na101d.getText().toString());
        //sA1.put("nh107", binding.na103.getText().toString());
        sA1.put("nh110", binding.na105.getText().toString());
        sA1.put("nh113", binding.na107.getText().toString());
        sA1.put("nh115", binding.na108.getText().toString());

/*        sA1.put("nw11501blood", binding.na11101blooda.isChecked() ? "1"
                : binding.na11101bloodb.isChecked() ? "2" : "0");

        sA1.put("nw11501urine", binding.na11101urinea.isChecked() ? "1"
                : binding.na11101urineb.isChecked() ? "2" : "0");

        sA1.put("nw11502water", binding.na11102watera.isChecked() ? "1"
                : binding.na11102waterb.isChecked() ? "2" : "0");
*/

        sA1.put("nh11701blood", MainApp.selectedHead.getSelStructure());

        sA1.put("nh11702urine", MainApp.selectedHead.getSelStructure());

        sA1.put("nh11703water", MainApp.selectedHead.getSelStructure());

        sA1.put("nh11801", binding.na11201a.isChecked() ? "1"
                : binding.na11201b.isChecked() ? "2" : "0");

        sA1.put("nh11802", binding.na11202a.isChecked() ? "1"
                : binding.na11202b.isChecked() ? "2" : "0");

//        na117
        sA1.put("nh119a", binding.na113a.isChecked() ? "1" : "0");
        sA1.put("nw117b", binding.na113b.isChecked() ? "2" : "0");
        sA1.put("nw117c", binding.na113c.isChecked() ? "3" : "0");
        sA1.put("nw117d", binding.na113d.isChecked() ? "4" : "0");
        sA1.put("nw117e", binding.na113e.isChecked() ? "5" : "0");
        sA1.put("nw117f", binding.na113f.isChecked() ? "6" : "0");
        sA1.put("nw117g", binding.na113g.isChecked() ? "7" : "0");
        sA1.put("nw11796", binding.na11396.isChecked() ? "96" : "0");
        sA1.put("nw11796x", binding.na11396x.getText().toString());

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

        if (!binding.na102.getText().toString().trim().isEmpty() && !binding.na103.getText().toString().trim().isEmpty()) {

            selected = db.getAllBLRandom(binding.na102.getText().toString(), binding.na103.getText().toString().toUpperCase());

            if (selected.size() != 0) {

                Toast.makeText(this, "Head found in this HH.", Toast.LENGTH_SHORT).show();

                for (BLRandomContract rnd : selected) {
                    MainApp.selectedHead = new BLRandomContract(rnd);
                }

                binding.hhName.setText(MainApp.selectedHead.getHhhead().toUpperCase());

                binding.fldGrpna105.setVisibility(View.VISIBLE);

            } else {

                clearFields();

                Toast.makeText(this, "No Head found in this HH.", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Not found.", Toast.LENGTH_SHORT).show();
        }

    }

    public void BtnCheckEnm() {

        if (validatorClass.EmptyTextBox(this, binding.na102, getString(R.string.na102))) {

            String selected = db.getEnumBlock(binding.na102.getText().toString());
            if (!selected.equals("")) {

                String[] selSplit = selected.split("\\|");

                binding.na101a.setText(selSplit[0]);
                binding.na101b.setText(selSplit[1].equals("") ? "----" : selSplit[1]);
                binding.na101c.setText(selSplit[2].equals("") ? "----" : selSplit[2]);
                binding.na101d.setText(selSplit[3]);

                binding.fldGrpna101.setVisibility(View.VISIBLE);

            } else {
                binding.na103.setText(null);
                Toast.makeText(this, "Sorry not found any block", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
