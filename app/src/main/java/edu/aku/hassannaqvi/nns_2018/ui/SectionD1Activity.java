package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
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
import java.util.TimerTask;

import edu.aku.hassannaqvi.nns_2018.JSONModels.JSONModelClass;
import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.EligibleMembersContract;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionD1Binding;
import edu.aku.hassannaqvi.nns_2018.other.JSONUtilClass;
import edu.aku.hassannaqvi.nns_2018.validation.clearClass;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionD1Activity extends Menu2Activity implements TextWatcher, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    static List<String> members;
    static Map<String, SelectedMem> membersMap;
    static String name;
    static int counter = 1;
    private final long DELAY = 1000;
    ActivitySectionD1Binding binding;
    DatabaseHelper db;
    int slc_type;
    JSONModelClass json;
    FamilyMembersContract slecMem;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_d1);
        db = new DatabaseHelper(this);

        this.setTitle(getResources().getString(R.string.nd1heading));

//        Assigning data to UI binding
        binding.setCallback(this);
        json = new JSONModelClass();


        setupViews();

        Log.d("Mem", String.valueOf(MainApp.members_f_m));
        Log.d("Mem", String.valueOf(MainApp.childUnder2));
        Log.d("Mem", String.valueOf(MainApp.childUnder5));
        Log.d("Mem", String.valueOf(MainApp.mwra));

//        Validation Boolean
        MainApp.validateFlag = false;

    }

    public void setupViews() {

//        Setup spinner

        //  Getting Extra
        if (getIntent().getBooleanExtra("flag", false)) {
            members.remove(getIntent().getStringExtra("name"));
            counter++;
        } else {
            members = new ArrayList<>();
            membersMap = new HashMap<>();

            members.add("....");

            familyMembersSetting(MainApp.mwra, 1);  // 1 for Mwra
            familyMembersSetting(MainApp.childUnder5, 2);  // 2 for Under 5
            familyMembersSetting(MainApp.adolescents, 3);  // 3 for Adolescents
        }
        slecMem = new FamilyMembersContract();
        binding.nd101.setAdapter(new ArrayAdapter<>(this, R.layout.item_style, members));

//        Spinner setting
        binding.nd101.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i != 0) {

                    SelectedMem mem = membersMap.get(binding.nd101.getSelectedItem().toString());
                    slc_type = mem.getType();
                    slecMem = mem.getFmc();

                    switch (slc_type) {
                        case 1: // MWRA

//                            binding.fldGrpbcgScar.setVisibility(View.GONE);
                            clearClass.ClearAllFields(binding.fldGrpbcgScar, false);

//                            binding.fldGrpgoiter.setVisibility(View.VISIBLE);
                            clearClass.ClearAllFields(binding.fldGrpgoiter, true);

//                            binding.fldGrpca.setVisibility(View.VISIBLE);
                            clearClass.ClearAllFields(binding.fldGrpca, true);

//                            binding.fldGrpode.setVisibility(View.GONE);
                            clearClass.ClearAllFields(binding.fldGrpode, false);
                            break;

                        case 2: // U5

//                            binding.fldGrpbcgScar.setVisibility(View.VISIBLE);
                            clearClass.ClearAllFields(binding.fldGrpbcgScar, true);

//                            binding.fldGrpgoiter.setVisibility(View.VISIBLE);
                            clearClass.ClearAllFields(binding.fldGrpgoiter, true);

//                            binding.fldGrpca.setVisibility(View.VISIBLE);
                            clearClass.ClearAllFields(binding.fldGrpca, true);

//                            binding.fldGrpode.setVisibility(View.VISIBLE);
                            clearClass.ClearAllFields(binding.fldGrpode, true);
                            break;

                        case 3: // Adolescent

//                            binding.fldGrpbcgScar.setVisibility(View.GONE);
                            clearClass.ClearAllFields(binding.fldGrpbcgScar, false);

//                            binding.fldGrpgoiter.setVisibility(View.VISIBLE);
                            clearClass.ClearAllFields(binding.fldGrpgoiter, true);

//                            binding.fldGrpca.setVisibility(View.VISIBLE);
                            clearClass.ClearAllFields(binding.fldGrpca, true);

//                            binding.fldGrpode.setVisibility(View.GONE);
                            clearClass.ClearAllFields(binding.fldGrpode, false);
                            break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // setup head
        binding.txtCounter.setText("Count " + counter + " out of " + MainApp.all_members.size());

//        Listener
        binding.nd1w.addTextChangedListener(this);
        binding.nd1h.addTextChangedListener(this);
        binding.nd1muac.addTextChangedListener(this);
        binding.nd1bcgscar.setOnCheckedChangeListener(this);
        binding.nd1g.setOnCheckedChangeListener(this);
        binding.nd1ca.setOnCheckedChangeListener(this);
        binding.nd1o.setOnCheckedChangeListener(this);

    }

    public void familyMembersSetting(List<FamilyMembersContract> family, int type) {

        for (FamilyMembersContract fmc : family) {
            json = JSONUtilClass.getModelFromJSON(fmc.getsA2(), JSONModelClass.class);
            membersMap.put(json.getName() + "_" + json.getSerialNo(), new SelectedMem(type, fmc));
            members.add(json.getName() + "_" + json.getSerialNo());
        }


    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }


    public void BtnContinue() {

//        Validation Boolean
        MainApp.validateFlag = true;

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

/*
                if (counter == MainApp.all_members.size()) {

                    counter = 1;

                    startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));

                } else {

                    members.remove(binding.nd101.getSelectedItem().toString());

                    startActivity(new Intent(this, SectionD1Activity.class)
                            .putExtra("flag", true));
                }
*/

                startActivity(new Intent(this, AnthroEndingActivity.class).putExtra("complete", true));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            //Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

            //finish();

            MainApp.endAnthroActivity(this, this);

        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean formValidation() {

        //Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptySpinner(this, binding.nd101, getString(R.string.nd1w))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.nd1w, getString(R.string.nd1w))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.nd1h, getString(R.string.nd1h))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.nd1muac, getString(R.string.nd1muac))) {
            return false;
        }


        if (slc_type == 2) {
            if (!validatorClass.EmptyRadioButton(this, binding.nd1bcgscar, binding.nd1bcgscara, getString(R.string.nd1bcgscar))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, binding.nd1g, binding.nd1ga, getString(R.string.nd1g))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.nd1ca, binding.nd1caa, getString(R.string.nd1ca))) {
            return false;
        }

        if (slc_type == 2) {
            return validatorClass.EmptyRadioButton(this, binding.nd1o, binding.nd1oa, getString(R.string.nd1o));
        }


        return true;
    }

    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        MainApp.emc = new EligibleMembersContract();

        MainApp.emc.setDevicetagID(MainApp.getTagName(this));
        MainApp.emc.setFormDate(slecMem.getFormDate());
        MainApp.emc.setUser(MainApp.userName);
        MainApp.emc.setDeviceId(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.emc.setApp_ver(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.emc.set_UUID(MainApp.fc.getUID());
        MainApp.emc.setFmuid(slecMem.get_UID());
        MainApp.emc.setEnm_no(AntrhoInfoActivity.enm_no);
        MainApp.emc.setHh_no(AntrhoInfoActivity.hh_no);

        JSONObject sA3 = new JSONObject();

        name = binding.nd101.getSelectedItem().toString();
        sA3.put("nd101", binding.nd101.getSelectedItem().toString());
        sA3.put("nd101Serial", json.getSerialNo());

        sA3.put("nd1Serial", String.valueOf(counter));

        sA3.put("nd1w", binding.nd1w.getText().toString());

        sA3.put("nd1h", binding.nd1h.getText().toString());

        sA3.put("nd1muac", binding.nd1muac.getText().toString());

        sA3.put("nd1bcgscar", binding.nd1bcgscara.isChecked() ? "1"
                : binding.nd1bcgscarb.isChecked() ? "2" : "0");

        sA3.put("nd1g", binding.nd1ga.isChecked() ? "1"
                : binding.nd1gb.isChecked() ? "2" : "0");

        sA3.put("nd1g", binding.nd1caa.isChecked() ? "1"
                : binding.nd1cab.isChecked() ? "2" : "0");

        sA3.put("nd1o", binding.nd1oa.isChecked() ? "1"
                : binding.nd1ob.isChecked() ? "2" : "0");


        MainApp.emc.setsA3(String.valueOf(sA3));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        Long updcount = db.addEligibleMember(MainApp.emc);
        MainApp.emc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.emc.set_UID(
                    (MainApp.emc.getDeviceId() + MainApp.emc.get_ID()));
            db.updateEligibleMemberID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        timer.cancel();
        timer = new Timer();
        timer.schedule(
                new TimerTask() {
                    @Override
                    public void run() {

                        runOnUiThread(new Runnable() {
                            public void run() {
                                formValidation();
                            }
                        });

                    }
                },
                DELAY
        );
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        formValidation();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        formValidation();
    }

    public class SelectedMem {
        int type;
        FamilyMembersContract fmc;


        public SelectedMem(int type, FamilyMembersContract fmc) {
            this.type = type;
            this.fmc = fmc;
        }

        public int getType() {
            return type;
        }


        public FamilyMembersContract getFmc() {
            return fmc;
        }
    }


}
