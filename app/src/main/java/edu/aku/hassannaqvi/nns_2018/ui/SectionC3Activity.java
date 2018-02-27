package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionC3Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionC3Activity extends AppCompatActivity {

    ActivitySectionC3Binding binding;
    FamilyMembersContract selectedChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_c3);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_c3);
        binding.setCallback(this);
        binding.nc3bcgdt.setManager(getSupportFragmentManager());
        binding.nc3bcgdt.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));

        binding.nc3opv0dt.setManager(getSupportFragmentManager());
        binding.nc3opv0dt.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));

        binding.nc3opv1dt.setManager(getSupportFragmentManager());
        binding.nc3opv1dt.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));

        binding.nc3p1dt.setManager(getSupportFragmentManager());
        binding.nc3p1dt.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));

        binding.nc3pcv1dt.setManager(getSupportFragmentManager());
        binding.nc3pcv1dt.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));

        binding.nc3opv2dt.setManager(getSupportFragmentManager());
        binding.nc3opv2dt.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));

        binding.nc3p2dt.setManager(getSupportFragmentManager());
        binding.nc3p2dt.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));

        binding.nc3pcv2dt.setManager(getSupportFragmentManager());
        binding.nc3pcv2dt.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));

        binding.nc3opv3dt.setManager(getSupportFragmentManager());
        binding.nc3opv3dt.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));

        binding.nc3p3dt.setManager(getSupportFragmentManager());
        binding.nc3p3dt.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));

        binding.nc3pcv3dt.setManager(getSupportFragmentManager());
        binding.nc3pcv3dt.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));

        binding.nc3ipvdt.setManager(getSupportFragmentManager());
        binding.nc3ipvdt.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));

        binding.nc3m1dt.setManager(getSupportFragmentManager());
        binding.nc3m1dt.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));

        binding.nc3m2dt.setManager(getSupportFragmentManager());
        binding.nc3m2dt.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));

//        Skip Patterns
//        binding.nc312.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                if (i == R.id.nc312b) {
//                    binding.nc313.clearCheck();
//                }
//            }
//        });

        binding.nc303.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nc303d) {
                    binding.nc3bcg.clearCheck();
                    binding.nc3opv0.clearCheck();
                    binding.nc3opv1.clearCheck();
                    binding.nc3p1.clearCheck();
                    binding.nc3pcv1.clearCheck();
                    binding.nc3opv2.clearCheck();
                    binding.nc3p2.clearCheck();
                    binding.nc3pcv2.clearCheck();
                    binding.nc3opv3.clearCheck();
                    binding.nc3p3.clearCheck();
                    binding.nc3pcv3.clearCheck();
                    binding.nc3ipv.clearCheck();
                    binding.nc3m1.clearCheck();
                    binding.nc3m2.clearCheck();
                }
            }
        });
        binding.nc306.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.nc306b) {
                    binding.fldGrnc307.setVisibility(View.GONE);
                    binding.nc307.clearCheck();
                    binding.nc308.clearCheck();
                } else {
                    binding.fldGrnc307.setVisibility(View.VISIBLE);

                }
            }
        });

        //Get Intent
        selectedChild = (FamilyMembersContract) getIntent().getSerializableExtra("selectedChild");

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

                startActivity(new Intent(this, SectionC4Activity.class)
                        .putExtra("selectedChild", selectedChild));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void BtnEnd() {

        MainApp.endActivityMotherChild(this, this, false, false);

    }

    private boolean formValidation() {
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//       nc302
        if (!validatorClass.EmptyRadioButton(this, binding.nc302, binding.nc302b, getString(R.string.nc302))) {
            return false;
        }

//        nc303
        if (!validatorClass.EmptyRadioButton(this, binding.nc303, binding.nc303d, getString(R.string.nc303))) {
            return false;
        }


        if (!binding.nc303d.isChecked()) {
//        nc3bcg
            if (!validatorClass.EmptyRadioButton(this, binding.nc3bcg, binding.nc3bcga, binding.nc3bcgdt, getString(R.string.nc3bcg))) {
                return false;
            }
//        nc3opv0
            if (!validatorClass.EmptyRadioButton(this, binding.nc3opv0, binding.nc3opv0a, binding.nc3opv0dt, getString(R.string.nc3opv0))) {
                return false;
            }

//        nc3opv1
            if (!validatorClass.EmptyRadioButton(this, binding.nc3opv1, binding.nc3opv1a, binding.nc3opv1dt, getString(R.string.nc3opv1))) {
                return false;
            }
//        nc3p1
            if (!validatorClass.EmptyRadioButton(this, binding.nc3p1, binding.nc3p1a, binding.nc3p1dt, getString(R.string.nc3p1))) {
                return false;
            }
//        nc3pcv1
            if (!validatorClass.EmptyRadioButton(this, binding.nc3pcv1, binding.nc3pcv1a, binding.nc3pcv1dt, getString(R.string.nc3pcv1))) {
                return false;
            }


//        nc3opv2
            if (!validatorClass.EmptyRadioButton(this, binding.nc3opv2, binding.nc3opv2a, binding.nc3opv2dt, getString(R.string.nc3opv2))) {
                return false;
            }
//        nc3p2
            if (!validatorClass.EmptyRadioButton(this, binding.nc3p2, binding.nc3p2a, binding.nc3p2dt, getString(R.string.nc3p2))) {
                return false;
            }
//        nc3pcv2
            if (!validatorClass.EmptyRadioButton(this, binding.nc3pcv2, binding.nc3pcv2a, binding.nc3pcv2dt, getString(R.string.nc3pcv2))) {
                return false;
            }


//        nc3opv3
            if (!validatorClass.EmptyRadioButton(this, binding.nc3opv3, binding.nc3opv3a, binding.nc3opv3dt, getString(R.string.nc3opv3))) {
                return false;
            }
//        nc3p3
            if (!validatorClass.EmptyRadioButton(this, binding.nc3p3, binding.nc3p3a, binding.nc3p3dt, getString(R.string.nc3p3))) {
                return false;
            }
//        nc3pcv3
            if (!validatorClass.EmptyRadioButton(this, binding.nc3pcv3, binding.nc3pcv3a, binding.nc3pcv3dt, getString(R.string.nc3pcv3))) {
                return false;
            }
//        nc3ipv3
            if (!validatorClass.EmptyRadioButton(this, binding.nc3ipv, binding.nc3ipva, binding.nc3ipvdt, getString(R.string.nc3ipv))) {
                return false;
            }

//        nc3m1dt
            if (!validatorClass.EmptyRadioButton(this, binding.nc3m1, binding.nc3m1a, binding.nc3m1dt, getString(R.string.nc3m1))) {
                return false;
            }

//        nc3m2dt
            if (!validatorClass.EmptyRadioButton(this, binding.nc3m2, binding.nc3m2a, binding.nc3m2dt, getString(R.string.nc3m2))) {
                return false;
            }

        }

//        nc305
        if (!validatorClass.EmptyRadioButton(this, binding.nc305, binding.nc305b, getString(R.string.nc305))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.nc306, binding.nc306a, getString(R.string.nc306))) {
            return false;
        }

        if (!binding.nc306b.isChecked()) {
//        nc307
            if (!validatorClass.EmptyRadioButton(this, binding.nc307, binding.nc307b, getString(R.string.nc307))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, binding.nc308, binding.nc308b, getString(R.string.nc308))) {
                return false;
            }
        }
//        nc309
        if (!validatorClass.EmptyRadioButton(this, binding.nc309, binding.nc309b, getString(R.string.nc309))) {
            return false;
        }

        if (!binding.nc309b.isChecked()) {
//        nc310
            if (!validatorClass.EmptyTextBox(this, binding.nc310, getString(R.string.nc310))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.nc310, 1, 99, getString(R.string.nc310), "DPT/COMBO/PENT")) {
                return false;
            }
        }

//        nc311
        if (!validatorClass.EmptyRadioButton(this, binding.nc311, binding.nc311b, getString(R.string.nc311))) {
            return false;
        }

        if (!binding.nc311b.isChecked()) {
//        nc312
            if (!validatorClass.EmptyTextBox(this, binding.nc312, getString(R.string.nc312))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.nc312, 1, 99, getString(R.string.nc312), "PCV")) {
                return false;
            }
        }

//        nc312
//        if (!validatorClass.EmptyRadioButton(this, binding.nc312, binding.nc312b, getString(R.string.nc312))) {
//            return false;
//        }
////        nc313
//        if (!validatorClass.EmptyRadioButton(this, binding.nc313, binding.nc31398, getString(R.string.nc313))) {
//            return false;
//        }
//        nc313
        if (!validatorClass.EmptyRadioButton(this, binding.nc313, binding.nc31398, getString(R.string.nc313))) {
            return false;
        }

        if (!binding.nc313b.isChecked()) {

//        nc314
            if (!validatorClass.EmptyTextBox(this, binding.nc314, getString(R.string.nc314))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.nc314, 1, 99, getString(R.string.nc314), "Mesasles / MMR")) {
                return false;
            }

//        nc316
            if (!validatorClass.EmptyRadioButton(this, binding.nc315, binding.nc31598, getString(R.string.nc315))) {
                return false;
            }

        }
//        nc315
        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sC3 = new JSONObject();

//        nc301
        sC3.put("nc301", selectedChild.getName());
//        nc302
        sC3.put("nc302Serial", selectedChild.getSerialNo());

//        nc302
        sC3.put("nc302", binding.nc302a.isChecked() ? "1"
                : binding.nc302b.isChecked() ? "2"
                : "0");

//        nc303
        sC3.put("nc303", binding.nc303a.isChecked() ? "1"
                : binding.nc303b.isChecked() ? "2"
                : binding.nc303c.isChecked() ? "3"
                : binding.nc303d.isChecked() ? "4"
                : "0");
//at birth
//          nc3bcg
        sC3.put("nc3bcg", binding.nc3bcga.isChecked() ? "1"
                : binding.nc3bcgb.isChecked() ? "2"
                : "0");
        sC3.put("nc3bcgdt", binding.nc3bcgdt.getText().toString());

//          nc3opv0
        sC3.put("nc3opv0", binding.nc3opv0a.isChecked() ? "1"
                : binding.nc3opv0b.isChecked() ? "2"
                : "0");
        sC3.put("nc3opv0dt", binding.nc3opv0dt.getText().toString());

//       at age of 6

//          nc3opv1
        sC3.put("nc3opv1", binding.nc3opv1a.isChecked() ? "1"
                : binding.nc3opv1b.isChecked() ? "2"
                : "0");
        sC3.put("nc3opv1dt", binding.nc3opv1dt.getText().toString());

//          nc3p1
        sC3.put("nc3p1", binding.nc3p1a.isChecked() ? "1"
                : binding.nc3p1b.isChecked() ? "2"
                : "0");
        sC3.put("nc3p1dt", binding.nc3p1dt.getText().toString());

//          nc3pcv1
        sC3.put("nc3pcv1", binding.nc3pcv1a.isChecked() ? "1"
                : binding.nc3pcv1b.isChecked() ? "2"
                : "0");
        sC3.put("nc3pcv1dt", binding.nc3pcv1dt.getText().toString());

//       at age of 10 weeks

//          nc3opv2
        sC3.put("nc3opv2", binding.nc3opv2a.isChecked() ? "1"
                : binding.nc3opv2b.isChecked() ? "2"
                : "0");
        sC3.put("nc3opv2dt", binding.nc3opv2dt.getText().toString());

//          nc3p2
        sC3.put("nc3p2", binding.nc3p2a.isChecked() ? "1"
                : binding.nc3p2b.isChecked() ? "2"
                : "0");
        sC3.put("nc3p2dt", binding.nc3p2dt.getText().toString());

//          nc3pcv2
        sC3.put("nc3pcv2", binding.nc3pcv2a.isChecked() ? "1"
                : binding.nc3pcv2b.isChecked() ? "2"
                : "0");
        sC3.put("nc3pcv2dt", binding.nc3pcv2dt.getText().toString());


//       at age of 14 weeks

//          nc3opv3
        sC3.put("nc3opv3", binding.nc3opv3a.isChecked() ? "1"
                : binding.nc3opv3b.isChecked() ? "2"
                : "0");
        sC3.put("nc3opv3dt", binding.nc3opv3dt.getText().toString());

//          nc3p3
        sC3.put("nc3p3", binding.nc3p3a.isChecked() ? "1"
                : binding.nc3p3b.isChecked() ? "2"
                : "0");
        sC3.put("nc3p3dt", binding.nc3p3dt.getText().toString());

//          nc3pcv3
        sC3.put("nc3pcv3", binding.nc3pcv3a.isChecked() ? "1"
                : binding.nc3pcv3b.isChecked() ? "2"
                : "0");
        sC3.put("nc3pcv3dt", binding.nc3pcv3dt.getText().toString());

//          nc3ipv
        sC3.put("nc3ipv", binding.nc3ipva.isChecked() ? "1"
                : binding.nc3ipvb.isChecked() ? "2"
                : "0");
        sC3.put("nc3ipvdt", binding.nc3ipvdt.getText().toString());

//at the age of 9 months
//          nc3m1
        sC3.put("nc3m1", binding.nc3m1a.isChecked() ? "1"
                : binding.nc3m1b.isChecked() ? "2"
                : "0");
        sC3.put("nc3m1dt", binding.nc3m1dt.getText().toString());

//at age of 15 months
//          nc3m2
        sC3.put("nc3m2", binding.nc3m2a.isChecked() ? "1"
                : binding.nc3m2b.isChecked() ? "2"
                : "0");
        sC3.put("nc3m2dt", binding.nc3m2dt.getText().toString());


//        nc305
        sC3.put("nc305", binding.nc305a.isChecked() ? "1"
                : binding.nc305b.isChecked() ? "2"
                : "0");

//        nc307
        sC3.put("nc307", binding.nc307a.isChecked() ? "1"
                : binding.nc307b.isChecked() ? "2"
                : binding.nc307c.isChecked() ? "3"
                : "0");

//        nc309
        sC3.put("nc309", binding.nc309a.isChecked() ? "1"
                : binding.nc309b.isChecked() ? "2"
                : binding.nc309c.isChecked() ? "3"
                : "0");

//        nc310
        sC3.put("nc310", binding.nc310.getText().toString());

//        nc311
        sC3.put("nc311", binding.nc311a.isChecked() ? "1"
                : binding.nc311b.isChecked() ? "2"
                : binding.nc311c.isChecked() ? "3"
                : "0");

//        nc312
        sC3.put("nc312", binding.nc312.getText().toString());

//        nc312
//        sC3.put("nc312", binding.nc312a.isChecked() ? "1"
//                : binding.nc312b.isChecked() ? "2"
//                : binding.nc312c.isChecked() ? "3"
//                : "0");
////        nc313
//        sC3.put("nc313", binding.nc313a.isChecked() ? "1"
//                : binding.nc313b.isChecked() ? "2"
//                : binding.nc31398.isChecked() ? "98"
//                : "0");


//        nc313
        sC3.put("nc313", binding.nc313a.isChecked() ? "1"
                : binding.nc313b.isChecked() ? "2"
                : binding.nc31398.isChecked() ? "98"
                : "0");

//        nc313
        sC3.put("nc313", binding.nc314.getText().toString());

//        nc314
        sC3.put("nc314", binding.nc315a.isChecked() ? "1"
                : binding.nc315b.isChecked() ? "2"
                : binding.nc31598.isChecked() ? "98"
                : "0");


        MainApp.cc.setsC3(String.valueOf(sC3));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSC3();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


}

