package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionA1Binding;
import edu.aku.hassannaqvi.nns_2018.other.MembersCount;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionA1Activity extends AppCompatActivity {

    ActivitySectionA1Binding binding;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_a1);
        db = new DatabaseHelper(this);
        binding.setCallback(this);

//        Members Initialization
        MainApp.membersCount = new MembersCount();

        //Setting members in map
        Map<Integer, Map<Integer, Integer>> mem = new HashMap<>();
        Map<Integer, Integer> memType = new HashMap<>();
        memType.put(1, 0);
        memType.put(2, 0);

        mem.put(1, memType);
        mem.put(2, memType);
        mem.put(3, memType);

        MainApp.membersCount.setMembers(mem);
        MainApp.membersCount.setMwra(0);

        MainApp.members_f_m = new ArrayList<>();
        MainApp.childUnder2 = new ArrayList<>();
        MainApp.childUnder5 = new ArrayList<>();
        MainApp.childUnder5 = new ArrayList<>();
        MainApp.mwra = new ArrayList<>();
        MainApp.serial_no = 1;
    }

    public void BtnContinue() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        /*if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, ChildAssessmentActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }*/

        startActivity(new Intent(this, SectionA2Activity.class));
    }

    public void BtnEnd() {

        Toast.makeText(this, "Processing End Section", Toast.LENGTH_SHORT).show();
        /*if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, ChildAssessmentActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }*/
    }

    public boolean formValidation() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

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
        if (!validatorClass.EmptyTextBox(this, binding.na103, getString(R.string.na103))) {
            return false;
        }

        String[] str = binding.na103.getText().toString().split("-");
        if (str.length > 2 || binding.na103.getText().toString().charAt(3) != '-' || !str[0].matches("[0-9]+")) {
            binding.na103.setError("Wrong presentation!!");
            return false;
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
//        na11101blood
        if (!validatorClass.EmptyRadioButton(this, binding.na11101blood, binding.na11101bloodb, getString(R.string.na11101blood))) {
            return false;
        }
//        na11102water
        if (!validatorClass.EmptyRadioButton(this, binding.na11102water, binding.na11102waterb, getString(R.string.na11102water))) {
            return false;
        }
//        na11201
        if (!validatorClass.EmptyRadioButton(this, binding.na11201, binding.na11201b, getString(R.string.na11201))) {
            return false;
        }
//        na11202
        if (!validatorClass.EmptyRadioButton(this, binding.na11202, binding.na11202b, getString(R.string.na11202))) {
            return false;
        }

//        na113
        if (binding.na11201a.isChecked()) {
            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpna113, binding.na11396, binding.na11396x, String.valueOf(R.string.na113))) {
                return false;
            }
        }

        return true;
    }

    public void BtnCheckHH() {

    }

    public void BtnCheckEnm() {

    }
}
