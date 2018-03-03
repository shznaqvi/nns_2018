package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
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
    List<String> mothersSerials, fathersSerials;
    Map<String, String> mothersMap, fathersMap;

    int Age = 0, position = 0;

    Boolean flag = false;

    FamilyMembersContract family;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_a2);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_a2);
        binding.setCallback(this);

        setupViews();
    }


    public void setupViews() {

//        Getting Intent
        flag = getIntent().getBooleanExtra("flag", false);

        if (flag) {
            binding.fldGrpA201.setVisibility(View.VISIBLE);
            binding.fldGrpA202.setVisibility(View.GONE);
            //family = (FamilyMembersContract) getIntent().getSerializableExtra("data");
        } else {

            family = (FamilyMembersContract) getIntent().getSerializableExtra("data");
            position = getIntent().getIntExtra("pos", 0);

            binding.selectedName.setText(family.getName().toUpperCase());

            binding.fldGrpA201.setVisibility(View.GONE);
            binding.fldGrpA202.setVisibility(View.VISIBLE);
            //binding.fldGrpA20101.setVisibility(View.VISIBLE);
        }

//        Listeners
        binding.na20598.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    binding.na2dob.setEnabled(false);
                    binding.na2dob.setText(null);
                    binding.na2aged.setEnabled(true);
                    binding.na2agem.setEnabled(true);
                    binding.na2agey.setEnabled(true);

                    binding.na2agem.setVisibility(View.VISIBLE);
                    binding.na2aged.setVisibility(View.VISIBLE);
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

        binding.na2agey.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!binding.na2agey.getText().toString().isEmpty()) {
                    if (Integer.valueOf(binding.na2agey.getText().toString()) >= 5) {
                        binding.fldGrpmonths.setVisibility(View.GONE);
                        binding.fldGrpdays.setVisibility(View.GONE);
                        binding.na2agem.setText("0");
                        binding.na2aged.setText("0");
                    } else {
                        binding.fldGrpmonths.setVisibility(View.VISIBLE);
                        binding.fldGrpdays.setVisibility(View.VISIBLE);
                    }

                    Age = Integer.valueOf(binding.na2agey.getText().toString());
                    if (Age < 5) {
                        binding.fldGrpna2edu.setVisibility(View.GONE);
                        binding.fldGrpna2ms.setVisibility(View.GONE);
                        binding.fldGrpna2occ.setVisibility(View.GONE);
                        binding.na2edu.clearCheck();
                        binding.na2ms.clearCheck();
                        binding.na2occ.clearCheck();


                        binding.na2edua.setChecked(true);
                        binding.na2occa.setChecked(true);
                        binding.na2mse.setChecked(true);
                    } else if (Age >= 5 && Age <= 12) {
                        //  binding.na2edua.setEnabled(false);
                        binding.fldGrpna2edu.setVisibility(View.VISIBLE);
                        binding.fldGrpna2ms.setVisibility(View.GONE);
                        binding.fldGrpna2occ.setVisibility(View.GONE);
                        binding.na2edu.clearCheck();
                        binding.na2ms.clearCheck();
                        binding.na2occ.clearCheck();


                        binding.na2occa.setChecked(true);
                        binding.na2mse.setChecked(true);

                        binding.na2edua.setEnabled(true);
                        binding.na2edub.setEnabled(true);
                        binding.na2educ.setEnabled(true);
                        binding.na2edud.setEnabled(true);
                        binding.na2edue.setEnabled(true);

                        binding.na2eduf.setEnabled(false);
                        binding.na2edug.setEnabled(false);
                        binding.na2eduh.setEnabled(false);
                        binding.na2edui.setEnabled(false);
                    } else if (Age > 12) {
                        binding.fldGrpna2edu.setVisibility(View.VISIBLE);
                        binding.fldGrpna2ms.setVisibility(View.VISIBLE);
                        binding.fldGrpna2occ.setVisibility(View.VISIBLE);

                        binding.na2edu.clearCheck();
                        binding.na2ms.clearCheck();
                        binding.na2occ.clearCheck();

                        binding.na2msa.setEnabled(true);
                        binding.na2msb.setEnabled(true);
                        binding.na2msc.setEnabled(true);
                        binding.na2msd.setEnabled(true);
                        binding.na2mse.setEnabled(true);

                        binding.na2edua.setEnabled(true);
                        binding.na2edub.setEnabled(true);
                        binding.na2educ.setEnabled(true);
                        binding.na2edud.setEnabled(true);
                        binding.na2edue.setEnabled(true);
                        binding.na2eduf.setEnabled(true);
                        binding.na2edug.setEnabled(true);
                        binding.na2eduh.setEnabled(true);
                        binding.na2edui.setEnabled(true);
                    }

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.na2dob.setManager(getSupportFragmentManager());

        binding.na2dob.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));

        binding.na2dob.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!binding.na2dob.getText().toString().isEmpty()) {
                    Age = (int) MainApp.ageInYearByDOB(binding.na2dob.getText().toString());
                    //here

                    if (Age < 5) {
                        binding.fldGrpna2edu.setVisibility(View.GONE);
                        binding.fldGrpna2ms.setVisibility(View.GONE);
                        binding.fldGrpna2occ.setVisibility(View.GONE);
                        binding.na2edu.clearCheck();
                        binding.na2ms.clearCheck();
                        binding.na2occ.clearCheck();
                        binding.na2edua.setChecked(true);
                        binding.na2occa.setChecked(true);
                        binding.na2mse.setChecked(true);
                    } else if (Age >= 5 && Age <= 12) {
                        //  binding.na2edua.setEnabled(false);
                        binding.fldGrpna2edu.setVisibility(View.VISIBLE);
                        binding.fldGrpna2ms.setVisibility(View.GONE);
                        binding.fldGrpna2occ.setVisibility(View.GONE);

                        binding.na2edu.clearCheck();
                        binding.na2ms.clearCheck();
                        binding.na2occ.clearCheck();

                        binding.na2occa.setChecked(true);
                        binding.na2mse.setChecked(true);

                        binding.na2edua.setEnabled(true);
                        binding.na2edub.setEnabled(true);
                        binding.na2educ.setEnabled(true);
                        binding.na2edud.setEnabled(true);
                        binding.na2edue.setEnabled(true);

                        binding.na2eduf.setEnabled(false);
                        binding.na2edug.setEnabled(false);
                        binding.na2eduh.setEnabled(false);
                        binding.na2edui.setEnabled(false);
                    } else if (Age > 12) {
                        binding.fldGrpna2edu.setVisibility(View.VISIBLE);
                        binding.fldGrpna2ms.setVisibility(View.VISIBLE);
                        binding.fldGrpna2occ.setVisibility(View.VISIBLE);
                        binding.na2edu.clearCheck();
                        binding.na2ms.clearCheck();
                        binding.na2occ.clearCheck();
                        binding.na2msa.setEnabled(true);
                        binding.na2msb.setEnabled(true);
                        binding.na2msc.setEnabled(true);
                        binding.na2msd.setEnabled(true);
                        binding.na2mse.setEnabled(true);

                        binding.na2edua.setEnabled(true);
                        binding.na2edub.setEnabled(true);
                        binding.na2educ.setEnabled(true);
                        binding.na2edud.setEnabled(true);
                        binding.na2edue.setEnabled(true);
                        binding.na2eduf.setEnabled(true);
                        binding.na2edug.setEnabled(true);
                        binding.na2eduh.setEnabled(true);
                        binding.na2edui.setEnabled(true);
                    }

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

//        Getting Members with types
        mem = MainApp.membersCount.getMembers();

//        Setting Dropdowns
        mothersList = new ArrayList<>();
        mothersSerials = new ArrayList<>();
        mothersMap = new HashMap<>();

        mothersList.add("....");
        mothersList.add("N/A");
        mothersSerials.add("0");
        mothersMap.put("N/A_0", "00");

        fathersList = new ArrayList<>();
        fathersSerials = new ArrayList<>();
        fathersMap = new HashMap<>();

        fathersList.add("....");
        fathersList.add("N/A");
        fathersSerials.add("0");
        fathersMap.put("N/A_0", "00");

        for (FamilyMembersContract mem : MainApp.members_f_m) {
            if (mem.getna204().equals("1")) {
                fathersList.add(mem.getName());
                fathersSerials.add(mem.getSerialNo());
                fathersMap.put(mem.getName() + "_" + mem.getSerialNo(), mem.getSerialNo());
            } else {
                mothersList.add(mem.getName());
                mothersSerials.add(mem.getSerialNo());
                mothersMap.put(mem.getName() + "_" + mem.getSerialNo(), mem.getSerialNo());
            }
        }

        binding.na211.setAdapter(new ArrayAdapter<>(this, R.layout.item_style, fathersList));
        binding.na212.setAdapter(new ArrayAdapter<>(this, R.layout.item_style, mothersList));

//        Visibility for isHead
        if (MainApp.IsHead) {
            binding.na203a.setEnabled(false);
        } else {
            binding.na203a.setEnabled(true);
        }

        if (MainApp.IsResp) {
            binding.fldGrpA20101.setVisibility(View.GONE);
        }
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

                //if (flag) {
                //  startActivity(new Intent(this, SectionA2ListActivity.class));
                //} else {
                    startActivity(new Intent(this, SectionA2ListActivity.class)
                            .putExtra("respChecking", binding.respa.isChecked())
                            .putExtra("respLineNo", MainApp.fmc.getSerialNo()));
                //}


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

        if (flag) {

            if (!validatorClass.EmptyTextBox(this, binding.na202, getString(R.string.na202Info))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, binding.na204, binding.na204a, getString(R.string.na204))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, binding.na203, binding.na20396, getString(R.string.na203))) {
                return false;
            }


            if (!validatorClass.EmptyRadioButton(this, binding.na203, binding.na20396, getString(R.string.na203))) {
                return false;
            }

            if (!MainApp.IsResp) {
                if (!validatorClass.EmptyRadioButton(this, binding.resp, binding.respb, getString(R.string.resp))) {
                    return false;
                }
            }

        } else {

            if (!validatorClass.EmptySpinner(this, binding.na211, getString(R.string.na211))) {
                return false;
            }

            if (!validatorClass.EmptySpinner(this, binding.na212, getString(R.string.na212))) {
                return false;
            }

            if (binding.na20598.isChecked()) {

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

                if (!validatorClass.RangeTextBox(this, binding.na2agey, 0, 99, getString(R.string.na2age), " years")) {
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

            if (!validatorClass.EmptyRadioButton(this, binding.na210, binding.na210a, getString(R.string.na210))) {
                return false;
            }
        }

        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        if (flag) {
            MainApp.serial_no++;

            MainApp.fmc = new FamilyMembersContract();

            MainApp.fmc.setDevicetagID(MainApp.getTagName(this));
            MainApp.fmc.setFormDate(dtToday);
            MainApp.fmc.setUser(MainApp.userName);
            MainApp.fmc.setDeviceId(Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID));
            MainApp.fmc.setApp_ver(MainApp.versionName + "." + MainApp.versionCode);
            MainApp.fmc.set_UUID(MainApp.fc.getUID());

            MainApp.fmc.setSerialNo(String.valueOf(MainApp.serial_no));
            MainApp.fmc.setna204(binding.na204a.isChecked() ? "1" : binding.na204b.isChecked() ? "2" : "0");
            MainApp.fmc.setName(binding.na202.getText().toString());
            MainApp.fmc.setRealtionHH(binding.na203a.isChecked() ? "1" : binding.na203b.isChecked() ? "2" : binding.na203c.isChecked() ? "3" : binding.na203d.isChecked() ? "4"
                    : binding.na203e.isChecked() ? "5" : binding.na203f.isChecked() ? "6" : binding.na203g.isChecked() ? "7" : binding.na203h.isChecked() ? "8"
                    : binding.na203i.isChecked() ? "9" : binding.na203j.isChecked() ? "10" : binding.na203k.isChecked() ? "11" : binding.na203l.isChecked() ? "12"
                    : binding.na203m.isChecked() ? "13" : binding.na20398.isChecked() ? "98" : binding.na20396.isChecked() ? "96" : "0");

            MainApp.fmc.setResp(binding.respa.isChecked() ? "1" : "0"); //respondent


            MainApp.familyMembersList.add(MainApp.fmc);

//        Checking IsHead
            if (!MainApp.IsHead && binding.na203a.isChecked()) {
                MainApp.IsHead = true;
            }

            if (!MainApp.IsResp && binding.respa.isChecked()) {
                MainApp.IsResp = true;
            }


        } else {

            family.setDob(binding.na2dob.getText().toString());
            family.setAge(binding.na2agey.getText().toString() + "/" + binding.na2agem.getText().toString() + "/" + binding.na2aged.getText().toString());
            if (Age < 5) {
                family.setMotherId(mothersMap.get(binding.na212.getSelectedItem().toString() + "_" + mothersSerials.get(mothersList.indexOf(binding.na212.getSelectedItem().toString()) - 1)));
            }

            JSONObject sA2 = new JSONObject();

            sA2.put("resp", family.getResp().equals("0") ? "" : family.getResp());
            sA2.put("na2SerialNo", family.getSerialNo());
            sA2.put("na202", family.getName());
            sA2.put("na203", family.getRealtionHH());
            sA2.put("na204", family.getna204());

            sA2.put("na2dob", binding.na2dob.getText().toString());
            sA2.put("na20598", binding.na20598.getText().toString());

            sA2.put("na206y", binding.na2agey.getText().toString());
            sA2.put("na206m", binding.na2agem.getText().toString());
            sA2.put("na206d", binding.na2aged.getText().toString());

            sA2.put("na207", binding.na2msa.isChecked() ? "1" : binding.na2msb.isChecked() ? "2" : binding.na2msc.isChecked() ? "3" : binding.na2msd.isChecked() ? "4"
                    : binding.na2mse.isChecked() ? "5" : "0");

            sA2.put("na208", binding.na2edua.isChecked() ? "1" : binding.na2edub.isChecked() ? "2" : binding.na2educ.isChecked() ? "3" : binding.na2edud.isChecked() ? "4"
                    : binding.na2edue.isChecked() ? "5" : binding.na2eduf.isChecked() ? "6" : binding.na2edug.isChecked() ? "7" : binding.na2eduh.isChecked() ? "8"
                    : binding.na2edui.isChecked() ? "9" : "0");

            sA2.put("na209", binding.na2occa.isChecked() ? "1" : binding.na2occb.isChecked() ? "2" : binding.na2occc.isChecked() ? "3" : binding.na2occd.isChecked() ? "4"
                    : binding.na2occe.isChecked() ? "5" : binding.na2occf.isChecked() ? "6" : binding.na2occg.isChecked() ? "7" : binding.na2occh.isChecked() ? "8"
                    : binding.na2occ96.isChecked() ? "96" : "0");

            sA2.put("na20996x", binding.na2occ96x.getText().toString());

            sA2.put("na210", binding.na210a.isChecked() ? "1" : binding.na210b.isChecked() ? "2" : "0");

            sA2.put("na211", fathersMap.get(binding.na211.getSelectedItem().toString() + "_" + fathersSerials.get(fathersList.indexOf(binding.na211.getSelectedItem().toString()) - 1)));
            sA2.put("na212", mothersMap.get(binding.na212.getSelectedItem().toString() + "_" + mothersSerials.get(mothersList.indexOf(binding.na212.getSelectedItem().toString()) - 1)));



            family.setsA2(String.valueOf(sA2));

            //Setting for FamilyMembers List
            family.setMaritialStatus(binding.na2msa.isChecked() ? "1" : binding.na2msb.isChecked() ? "2" : binding.na2msc.isChecked() ? "3" : binding.na2msd.isChecked() ? "4"
                    : binding.na2mse.isChecked() ? "5" : "0");
            family.setFatherName(binding.na211.getSelectedItem().toString().toUpperCase());
            family.setMotherName(binding.na212.getSelectedItem().toString().toUpperCase());

        /*Functionality Setting*/

//        Calculation
            Map<Integer, Integer> memType = new HashMap<>();

            //Total
            if (family.getna204().equals("1")) {
                memType.put(1, Integer.valueOf(mem.get(1).get(1).toString()) + 1);
                memType.put(2, Integer.valueOf(mem.get(1).get(2).toString()));
            } else {
                memType.put(2, Integer.valueOf(mem.get(1).get(2).toString()) + 1);
                memType.put(1, Integer.valueOf(mem.get(1).get(1).toString()));
            }

            MainApp.membersCount.setMembers(1, memType);

            //MWRA
            if ((Age >= 15 && Age <= 49) && family.getna204().equals("2")) {
                if (!binding.na2mse.isChecked()) {
                    MainApp.membersCount.setMwra(MainApp.membersCount.getMwra() + 1);
                }
                MainApp.mwra.add(family);
                MainApp.adolescents.add(family);
            }
            //Adolescent
            if ((Age >= 10 && Age <= 19) && binding.na2mse.isChecked()) {
                memType = new HashMap<>();
                if (family.getna204().equals("1")) {
                    memType.put(1, Integer.valueOf(mem.get(2).get(1).toString()) + 1);
                    memType.put(2, Integer.valueOf(mem.get(2).get(2).toString()));
                } else {
                    memType.put(2, Integer.valueOf(mem.get(2).get(2).toString()) + 1);
                    memType.put(1, Integer.valueOf(mem.get(2).get(1).toString()));
                }
                MainApp.membersCount.setMembers(2, memType);

                // Add data in list
                MainApp.adolescents.add(family);
            }
            //Children < 5
            else if (Age < 5) {
                memType = new HashMap<>();
                if (family.getna204().equals("1")) {
                    memType.put(1, Integer.valueOf(mem.get(3).get(1).toString()) + 1);
                    memType.put(2, Integer.valueOf(mem.get(3).get(2).toString()));
                } else {
                    memType.put(2, Integer.valueOf(mem.get(3).get(2).toString()) + 1);
                    memType.put(1, Integer.valueOf(mem.get(3).get(1).toString()));
                }
                MainApp.membersCount.setMembers(3, memType);

                // Add data in list
                if (Age < 2) {
                    MainApp.childUnder2.add(family);
                    MainApp.childUnder5.add(family);
                } else {
                    MainApp.childUnder5.add(family);
                    MainApp.adolescents.add(family);
                }

                if (Age < 5 && family.getMotherId().equals("00")) {
                    MainApp.childNA.add(family);
                }
            }

            if (Age >= 15) {
                // Add data in list
                if (!binding.na2mse.isChecked()) {
                    MainApp.members_f_m.add(family);
                }

                MainApp.respList.add(family);
            }

            // Add data in list for all members
            MainApp.all_members.add(family);

        /*End*/

            family.setAgeInYear(String.valueOf(Age));

            MainApp.familyMembersList.set(position, family);
        }

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        if (flag) {

            long updcount = db.addFamilyMembers(MainApp.fmc);

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
            }
        } else {
            int updcount = db.updateFamilyMember(family);

            if (updcount == 1) {
                Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
                return true;
            } else {
                Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }
}