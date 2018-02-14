package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

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
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionA3Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionA3Activity extends AppCompatActivity {

    static List<String> members;
    static int counter = 1;
    ActivitySectionA3Binding binding;
    DatabaseHelper db;
    int position;

    Map<String, Map<Integer, FamilyMembersContract>> membersMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_a3);
        db = new DatabaseHelper(this);

//        Assigning data to UI binding
        binding.setCallback(this);

        setupViews();

        Log.d("Mem", String.valueOf(MainApp.members_f_m));
        Log.d("Mem", String.valueOf(MainApp.childUnder2));
        Log.d("Mem", String.valueOf(MainApp.childUnder5));
        Log.d("Mem", String.valueOf(MainApp.mwra));

//        Getting Extra
        if (getIntent().getBooleanExtra("flag", false)) {
            members.remove(getIntent().getExtras().getInt("serial"));
            counter++;
        }

    }

    public void setupViews() {

//        Setup spinner
        members = new ArrayList<>();
        membersMap = new HashMap<>();

        familyMembersSetting(MainApp.mwra, 1);
        familyMembersSetting(MainApp.childUnder5, 2);
        familyMembersSetting(MainApp.adolescents, 3);

        binding.na301.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, members));

//        Spinner setting
        binding.na301.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                position = i;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void familyMembersSetting(List<FamilyMembersContract> family, int type) {

        for (FamilyMembersContract fmc : family) {
            membersMap.put(fmc.getName() + "_" + fmc.getSerialNo(), (Map<Integer, FamilyMembersContract>) new HashMap<Integer, FamilyMembersContract>().put(type, fmc));
            members.add(fmc.getName() + "_" + fmc.getSerialNo());
        }

    }

    public void BtnContinue() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                if (counter == MainApp.membersCount.getEligibleCount()) {

                    counter = 1;

                    startActivity(new Intent(this, SectionA4Activity.class));
                } else {
                    startActivity(new Intent(this, SectionA3Activity.class)
                            .putExtra("flag", true).putExtra("serial", position));
                }

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }


    private boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyTextBox(this, binding.na3w, getString(R.string.na3w))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na3h, getString(R.string.na3h))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na3muac, getString(R.string.na3muac))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, binding.na3bcgscar, binding.na3bcgscara, getString(R.string.na3bcgscar))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na3g, binding.na3ga, getString(R.string.na3g))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na3ca, binding.na3caa, getString(R.string.na3ca))) {
            return false;
        }

        return validatorClass.EmptyRadioButton(this, binding.na3o, binding.na3oa, getString(R.string.na3o));
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sA3 = new JSONObject();

        sA3.put("na3Serial", String.valueOf(counter));

        sA3.put("na3w", binding.na3w.getText().toString());

        sA3.put("na3h", binding.na3h.getText().toString());

        sA3.put("na3muac", binding.na3muac.getText().toString());

        sA3.put("na3bcgscar", binding.na3bcgscara.isChecked() ? "1"
                : binding.na3bcgscarb.isChecked() ? "2" : "0");

        sA3.put("na3g", binding.na3ga.isChecked() ? "1"
                : binding.na3gb.isChecked() ? "2" : "0");

        sA3.put("na3g", binding.na3caa.isChecked() ? "1"
                : binding.na3cab.isChecked() ? "2" : "0");

        sA3.put("na3o", binding.na3oa.isChecked() ? "1"
                : binding.na3ob.isChecked() ? "2" : "0");


        //MainApp.cc.setsB(String.valueOf(sB));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        /*Long updcount = db.addChildForm(MainApp.cc);
        MainApp.cc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.cc.setUID(
                    (MainApp.cc.getDeviceID() + MainApp.cc.get_ID()));
            db.updateFormChildID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/

        return true;

    }

}
