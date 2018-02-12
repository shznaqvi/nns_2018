package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionA2Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;


public class SectionA2Activity extends AppCompatActivity {

    ActivitySectionA2Binding binding;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    Map<Integer, Map<Integer, Integer>> mem;
    List<String> mothersList, fathersList;
    Map<String, FamilyMembersContract> mothersMap, fathersMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_a2);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_a2);
        binding.setCallback(this);

        setupViews();
    }


    public void setupViews() {
        binding.na20798.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    binding.na2dob.setEnabled(false);
                    binding.na2dob.setText(null);
                    binding.na2aged.setEnabled(true);
                    binding.na2agem.setEnabled(true);
                    binding.na2agey.setEnabled(true);
                } else {
                    binding.na2dob.setEnabled(true);
                    binding.na2aged.setEnabled(false);
                    binding.na2aged.setText(null);
                    binding.na2agem.setEnabled(false);
                    binding.na2agem.setText(null);
                    binding.na2agey.setEnabled(false);
                    binding.na2agey.setText(null);
                }
            }
        });

        binding.na2dob.setManager(getSupportFragmentManager());

//        Setting Counts
        mem = MainApp.membersCount.getMembers();

        // Total
        binding.na2tm.setText(mem.get(1).get(1).toString());
        binding.na2tf.setText(mem.get(1).get(2).toString());
        // Adolescents
        binding.na2adm.setText(mem.get(2).get(1).toString());
        binding.na2adf.setText(mem.get(2).get(2).toString());
        // Children < 5
        binding.na2u5b.setText(mem.get(3).get(1).toString());
        binding.na2u5g.setText(mem.get(3).get(2).toString());

        binding.na2mw.setText(String.valueOf(MainApp.membersCount.getMwra()));

//        Setting Dropdowns
        mothersList = new ArrayList<>();
        mothersMap = new HashMap<>();

        mothersList.add("....");
        mothersList.add("N/A");
        mothersMap.put("N/A", new FamilyMembersContract());

        fathersList = new ArrayList<>();
        fathersMap = new HashMap<>();

        fathersList.add("....");
        fathersList.add("N/A");
        fathersMap.put("N/A", new FamilyMembersContract());

        for (FamilyMembersContract mem : MainApp.members_f_m) {
            if (mem.getGender().equals("1")) {
                fathersList.add(mem.getName() + "_" + mem.getSerialNo());
                fathersMap.put(mem.getName() + "_" + mem.getSerialNo(), mem);
            } else {
                mothersList.add(mem.getName() + "_" + mem.getSerialNo());
                mothersMap.put(mem.getName() + "_" + mem.getSerialNo(), mem);
            }
        }

        binding.na204.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, mothersList));
        binding.na205.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, fathersList));

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
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, SectionA3Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnAddMore() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, SectionA2Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }

    private boolean formValidation() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyTextBox(this, binding.na202, getString(R.string.na202Info))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na203, binding.na203a, getString(R.string.na203))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na203, binding.na20396, binding.na20396x, getString(R.string.na203) + " - " + getString(R.string.other))) {
            return false;
        }


        if (!validatorClass.EmptySpinner(this, binding.na204, getString(R.string.na204))) {
            return false;
        }

        if (!validatorClass.EmptySpinner(this, binding.na205, getString(R.string.na205))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na206, binding.na206a, getString(R.string.na206))) {
            return false;
        }

        if (binding.na20798.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, binding.na2aged, getString(R.string.na2age))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, binding.na2aged, 0, 29, getString(R.string.na2age), " days")) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, binding.na2agem, getString(R.string.na2age))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, binding.na2agem, 0, 11, getString(R.string.na2age), " months")) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, binding.na2agey, getString(R.string.na2age))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, binding.na2aged, 0, 99, getString(R.string.na2age), " years")) {
                return false;
            }

            if (binding.na2aged.getText().toString().equals("0") && binding.na2agem.getText().toString().equals("0") && binding.na2agey.getText().toString().equals("0")) {
                Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.na2age), Toast.LENGTH_LONG).show();
                binding.na2agey.setError("All can not be zero");
                binding.na2agem.setError("All can not be zero");
                binding.na2aged.setError("All can not be zero");
                Log.i(SectionA2Activity.class.getSimpleName(), "na2age" + ": This data is Required!");
            } else {
                binding.na2agey.setError(null);
                binding.na2agem.setError(null);
                binding.na2aged.setError(null);
            }


        } else {
            if (!validatorClass.EmptyTextBox(this, binding.na2dob, getString(R.string.na2dob))) {
                return false;
            }

        }

        if (!validatorClass.EmptyRadioButton(this, binding.na2edu, binding.na2edua, getString(R.string.na2edu))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, binding.na2occ, binding.na2occa, getString(R.string.na2occ))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na2occ, binding.na2occ96, binding.na2occ96x, getString(R.string.na2occ) + " - " + getString(R.string.other))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na2ms, binding.na2msa, getString(R.string.na2ms))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na212, binding.na212a, getString(R.string.na212))) {
            return false;
        }

        return validatorClass.EmptyTextBox(this, binding.na213, getString(R.string.na213));
    }


    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        MainApp.fmc = new FamilyMembersContract();

        MainApp.fmc.setDevicetagID(MainApp.getTagName(this));
        MainApp.fmc.setFormDate(dtToday);
        MainApp.fmc.setUser(MainApp.userName);
        MainApp.fmc.setDeviceId(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.fmc.setApp_ver(MainApp.versionName + "." + MainApp.versionCode);
//        MainApp.fmc.set_UUID(MainApp.fc.getUID());

        MainApp.fmc.setSerialNo(String.valueOf(MainApp.serial_no + 1));
        MainApp.fmc.setName(binding.na202.getText().toString());
        MainApp.fmc.setDob(binding.na2dob.getText().toString());
        MainApp.fmc.setAge(binding.na2agey.getText().toString() + "-" + binding.na2agem.getText().toString() + "-" + binding.na2aged.getText().toString());
        MainApp.fmc.setGender(binding.na206a.isChecked() ? "1" : binding.na206b.isChecked() ? "2" : "0");

        JSONObject sA2 = new JSONObject();

        /*sB.put("toicb01", binding.toicb01.getText().toString());
        sB.put("toicb03", binding.toicb03a.isChecked() ? "1" : binding.toicb03b.isChecked() ? "2" : "0");*/

        MainApp.fmc.setsA2(String.valueOf(sA2));


        /*Functionality Setting*/

        int Age;
//        Get Age in year
        if (binding.na20798.isChecked()) {
            Age = Integer.valueOf(binding.na2agey.getText().toString());
        } else {
            Age = (int) MainApp.ageInYearByDOB(binding.na2dob.getText().toString());
        }

//        Calculation
        Map<Integer, Integer> memType = new HashMap<>();

        //Total
        if (binding.na206a.isChecked()) {
            memType.put(1, Integer.valueOf(binding.na2tm.getText().toString()) + 1);
            memType.put(2, Integer.valueOf(binding.na2tf.getText().toString()));
        } else {
            memType.put(2, Integer.valueOf(binding.na2tf.getText().toString()) + 1);
            memType.put(1, Integer.valueOf(binding.na2tm.getText().toString()));
        }

        MainApp.membersCount.setMembers(1, memType);

        //MWRA
        if ((Age >= 15 && Age <= 49) && binding.na206b.isChecked() && !binding.na2mse.isChecked()) {
            MainApp.membersCount.setMwra(MainApp.membersCount.getMwra() + 1);

            // Add data in list
            MainApp.mwra.add(MainApp.fmc);
        }
        //Adolescent
        else if ((Age >= 10 && Age <= 19) && binding.na2mse.isChecked()) {
            if (binding.na206a.isChecked()) {
                memType.put(1, Integer.valueOf(binding.na2adm.getText().toString()) + 1);
                memType.put(2, Integer.valueOf(binding.na2adf.getText().toString()));
            } else {
                memType.put(2, Integer.valueOf(binding.na2adf.getText().toString()) + 1);
                memType.put(1, Integer.valueOf(binding.na2adm.getText().toString()));
            }
            MainApp.membersCount.setMembers(2, memType);
        }
        //Children < 5
        else if (Age < 5) {
            if (binding.na206a.isChecked()) {
                memType.put(1, Integer.valueOf(binding.na2u5b.getText().toString()) + 1);
                memType.put(2, Integer.valueOf(binding.na2u5g.getText().toString()));
            } else {
                memType.put(2, Integer.valueOf(binding.na2u5g.getText().toString()) + 1);
                memType.put(1, Integer.valueOf(binding.na2u5b.getText().toString()));
            }
            MainApp.membersCount.setMembers(3, memType);

            // Add data in list
            if (Age < 5 && Age > 2) {
                MainApp.childUnder5.add(MainApp.fmc);
            } else {
                MainApp.childUnder2.add(MainApp.fmc);
            }
        }

        if (Age >= 15 && !binding.na2mse.isChecked()) {
            // Add data in list
            MainApp.members_f_m.add(MainApp.fmc);
        }

        /*End*/

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        /*long updcount = db.addFamilyMembers(MainApp.fmc);

        MainApp.fmc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.fmc.set_UID(
                    (MainApp.fmc.getDeviceId() + MainApp.fmc.get_ID()));
            db.updateFamilyMemberID();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/

        return true;
    }


}