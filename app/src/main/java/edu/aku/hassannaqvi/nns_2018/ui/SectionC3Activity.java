package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;

import butterknife.ButterKnife;
import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionC3Binding;
import edu.aku.hassannaqvi.nns_2018.validation.clearClass;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionC3Activity extends AppCompatActivity {

    private final long DELAY = 1000;
    ActivitySectionC3Binding binding;
    FamilyMembersContract selectedChild;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_c3);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_c3);
        ButterKnife.bind(this);
        binding.setCallback(this);
        binding.nc302.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.nc302b) {
                    clearClass.ClearAllFields(binding.fldGrpnc303parent, false);
                    clearClass.ClearAllFields(binding.fldGrpnc303, false);


                } else {
                    clearClass.ClearAllFields(binding.fldGrpnc303parent, true);
                    clearClass.ClearAllFields(binding.fldGrpnc303, true);

                }

            }
        });


        binding.nc303.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nc303d) {
                    /*binding.nc3bcg.clearCheck();
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
                    binding.nc3m2.clearCheck();*/

                    clearClass.ClearAllFields(binding.fldGrpnc303, false);
                } else {
                    clearClass.ClearAllFields(binding.fldGrpnc303, true);
                }
            }
        });

        binding.nc315.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (binding.nc315b.isChecked() || binding.nc31598.isChecked()) {
//                    binding.nc316.clearCheck();
                    clearClass.ClearAllFields(binding.fldGrpnc315, false);
                } else {
                    clearClass.ClearAllFields(binding.fldGrpnc315, true);
                }
            }
        });

        binding.nc3bcg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc3bcga.isChecked()) {
                    binding.nc3bcgy.setEnabled(true);
                    binding.nc3bcgm.setEnabled(true);
                    binding.nc3bcgd.setEnabled(true);

                } else {
                    binding.nc3bcgy.setEnabled(false);
                    binding.nc3bcgm.setEnabled(false);
                    binding.nc3bcgd.setEnabled(false);
                    binding.nc3bcgy.setText(null);
                    binding.nc3bcgm.setText(null);
                    binding.nc3bcgd.setText(null);

                }
            }
        });

        binding.nc3opv0.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc3opv0a.isChecked()) {
                    binding.nc3opv0y.setEnabled(true);
                    binding.nc3opv0m.setEnabled(true);
                    binding.nc3opv0d.setEnabled(true);

                } else {
                    binding.nc3opv0y.setEnabled(false);
                    binding.nc3opv0m.setEnabled(false);
                    binding.nc3opv0d.setEnabled(false);
                    binding.nc3opv0y.setText(null);
                    binding.nc3opv0m.setText(null);
                    binding.nc3opv0d.setText(null);

                }
            }
        });

        binding.nc3opv1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc3opv1a.isChecked()) {
                    binding.nc3opv1y.setEnabled(true);
                    binding.nc3opv1m.setEnabled(true);
                    binding.nc3opv1d.setEnabled(true);

                } else {
                    binding.nc3opv1y.setEnabled(false);
                    binding.nc3opv1m.setEnabled(false);
                    binding.nc3opv1d.setEnabled(false);
                    binding.nc3opv1y.setText(null);
                    binding.nc3opv1m.setText(null);
                    binding.nc3opv1d.setText(null);

                }
            }
        });

        binding.nc3p1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc3p1a.isChecked()) {
                    binding.nc3p1y.setEnabled(true);
                    binding.nc3p1m.setEnabled(true);
                    binding.nc3p1d.setEnabled(true);

                } else {
                    binding.nc3p1y.setEnabled(false);
                    binding.nc3p1m.setEnabled(false);
                    binding.nc3p1d.setEnabled(false);
                    binding.nc3p1y.setText(null);
                    binding.nc3p1m.setText(null);
                    binding.nc3p1d.setText(null);

                }
            }
        });

        binding.nc3pcv1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc3pcv1a.isChecked()) {
                    binding.nc3pcv1y.setEnabled(true);
                    binding.nc3pcv1m.setEnabled(true);
                    binding.nc3pcv1d.setEnabled(true);

                } else {
                    binding.nc3pcv1y.setEnabled(false);
                    binding.nc3pcv1m.setEnabled(false);
                    binding.nc3pcv1d.setEnabled(false);
                    binding.nc3pcv1y.setText(null);
                    binding.nc3pcv1m.setText(null);
                    binding.nc3pcv1d.setText(null);

                }
            }
        });

        binding.nc3opv2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc3opv2a.isChecked()) {
                    binding.nc3opv2y.setEnabled(true);
                    binding.nc3opv2m.setEnabled(true);
                    binding.nc3opv2d.setEnabled(true);

                } else {
                    binding.nc3opv2y.setEnabled(false);
                    binding.nc3opv2m.setEnabled(false);
                    binding.nc3opv2d.setEnabled(false);
                    binding.nc3opv2y.setText(null);
                    binding.nc3opv2m.setText(null);
                    binding.nc3opv2d.setText(null);

                }
            }
        });

        binding.nc3pcv2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc3pcv2a.isChecked()) {
                    binding.nc3pcv2y.setEnabled(true);
                    binding.nc3pcv2m.setEnabled(true);
                    binding.nc3pcv2d.setEnabled(true);

                } else {
                    binding.nc3pcv2y.setEnabled(false);
                    binding.nc3pcv2m.setEnabled(false);
                    binding.nc3pcv2d.setEnabled(false);
                    binding.nc3pcv2y.setText(null);
                    binding.nc3pcv2m.setText(null);
                    binding.nc3pcv2d.setText(null);

                }
            }
        });

        binding.nc3p2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc3p2a.isChecked()) {
                    binding.nc3p2y.setEnabled(true);
                    binding.nc3p2m.setEnabled(true);
                    binding.nc3p2d.setEnabled(true);

                } else {
                    binding.nc3p2y.setEnabled(false);
                    binding.nc3p2m.setEnabled(false);
                    binding.nc3p2d.setEnabled(false);
                    binding.nc3p2y.setText(null);
                    binding.nc3p2m.setText(null);
                    binding.nc3p2d.setText(null);

                }
            }
        });


        binding.nc3opv3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc3opv3a.isChecked()) {
                    binding.nc3opv3y.setEnabled(true);
                    binding.nc3opv3m.setEnabled(true);
                    binding.nc3opv3d.setEnabled(true);

                } else {
                    binding.nc3opv3y.setEnabled(false);
                    binding.nc3opv3m.setEnabled(false);
                    binding.nc3opv3d.setEnabled(false);
                    binding.nc3opv3y.setText(null);
                    binding.nc3opv3m.setText(null);
                    binding.nc3opv3d.setText(null);

                }
            }
        });


        binding.nc3p3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc3p3a.isChecked()) {
                    binding.nc3p3y.setEnabled(true);
                    binding.nc3p3m.setEnabled(true);
                    binding.nc3p3d.setEnabled(true);

                } else {
                    binding.nc3p3y.setEnabled(false);
                    binding.nc3p3m.setEnabled(false);
                    binding.nc3p3d.setEnabled(false);
                    binding.nc3p3y.setText(null);
                    binding.nc3p3m.setText(null);
                    binding.nc3p3d.setText(null);

                }
            }
        });


        binding.nc3pcv3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc3pcv3a.isChecked()) {
                    binding.nc3pcv3y.setEnabled(true);
                    binding.nc3pcv3m.setEnabled(true);
                    binding.nc3pcv3d.setEnabled(true);

                } else {
                    binding.nc3pcv3y.setEnabled(false);
                    binding.nc3pcv3m.setEnabled(false);
                    binding.nc3pcv3d.setEnabled(false);
                    binding.nc3pcv3y.setText(null);
                    binding.nc3pcv3m.setText(null);
                    binding.nc3pcv3d.setText(null);

                }
            }
        });

        binding.nc3ipv.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc3ipva.isChecked()) {
                    binding.nc3ipvy.setEnabled(true);
                    binding.nc3ipvm.setEnabled(true);
                    binding.nc3ipvd.setEnabled(true);

                } else {
                    binding.nc3ipvy.setEnabled(false);
                    binding.nc3ipvm.setEnabled(false);
                    binding.nc3ipvd.setEnabled(false);
                    binding.nc3ipvy.setText(null);
                    binding.nc3ipvm.setText(null);
                    binding.nc3ipvd.setText(null);

                }
            }
        });


        binding.nc3m1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc3m1a.isChecked()) {
                    binding.nc3m1y.setEnabled(true);
                    binding.nc3m1m.setEnabled(true);
                    binding.nc3m1d.setEnabled(true);

                } else {
                    binding.nc3m1y.setEnabled(false);
                    binding.nc3m1m.setEnabled(false);
                    binding.nc3m1d.setEnabled(false);
                    binding.nc3m1y.setText(null);
                    binding.nc3m1m.setText(null);
                    binding.nc3m1d.setText(null);

                }
            }
        });


        binding.nc3m2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc3m2a.isChecked()) {
                    binding.nc3m2y.setEnabled(true);
                    binding.nc3m2m.setEnabled(true);
                    binding.nc3m2d.setEnabled(true);

                } else {
                    binding.nc3m2y.setEnabled(false);
                    binding.nc3m2m.setEnabled(false);
                    binding.nc3m2d.setEnabled(false);
                    binding.nc3m2y.setText(null);
                    binding.nc3m2m.setText(null);
                    binding.nc3m2d.setText(null);

                }
            }
        });


        //Get Intent
        selectedChild = (FamilyMembersContract) getIntent().getSerializableExtra("selectedChild");

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

                startActivity(new Intent(this, SectionC4Activity.class)
                        .putExtra("selectedChild", selectedChild));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void BtnEnd() {

        MainApp.endChildActivity(this, this, false);

    }

    private boolean formValidation() {
        //Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//       nc302
        if (!validatorClass.EmptyRadioButton(this, binding.nc302, binding.nc302b, getString(R.string.nc302))) {
            return false;
        }
        if (binding.nc302a.isChecked()) {

//        nc303
            if (!validatorClass.EmptyRadioButton(this, binding.nc303, binding.nc303d, getString(R.string.nc303))) {
                return false;
            }


            if (!binding.nc303d.isChecked()) {
//        nc3bcg
                if (!validatorClass.EmptyRadioButton(this, binding.nc3bcg, binding.nc3bcga, getString(R.string.nc3bcg))) {
                    return false;
                }

                if (binding.nc3bcga.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, binding.nc3bcgd, getString(R.string.nc3bcg) + " - " + getString(R.string.day))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3bcgm, getString(R.string.nc3bcg) + " - " + getString(R.string.month))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3bcgy, getString(R.string.nc3bcg) + " - " + getString(R.string.year2))) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3bcgd, 1, 31, 98, getString(R.string.nc3bcg), " day")) {
                        return false;
                    }

                    if (!validatorClass.RangeTextBox(this, binding.nc3bcgm, 1, 31, 98, getString(R.string.nc3bcg), " month")) {
                        return false;
                    }

                    if (!validatorClass.RangeTextBox(this, binding.nc3bcgy, 2013, 2018, 9998, getString(R.string.nc3bcg), " year")) {
                        return false;
                    }

                }
//        nc3opv0
                if (!validatorClass.EmptyRadioButton(this, binding.nc3opv0, binding.nc3opv0a, getString(R.string.nc3opv0))) {
                    return false;
                }

                if (binding.nc3opv0a.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, binding.nc3opv0d, getString(R.string.nc3opv0) + " - " + getString(R.string.day))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3opv0m, getString(R.string.nc3opv0) + " - " + getString(R.string.month))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3opv0y, getString(R.string.nc3opv0) + " - " + getString(R.string.year2))) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3opv0d, 1, 31, 98, getString(R.string.nc3opv0), " day")) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3opv0m, 1, 31, 98, getString(R.string.nc3opv0), " month")) {
                        return false;
                    }

                    if (!validatorClass.RangeTextBox(this, binding.nc3opv0y, 2013, 2018, 9998, getString(R.string.nc3opv0), " year")) {
                        return false;
                    }

                }

//        nc3opv1
                if (!validatorClass.EmptyRadioButton(this, binding.nc3opv1, binding.nc3opv1a, getString(R.string.nc3opv1))) {
                    return false;
                }

                if (binding.nc3opv1a.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, binding.nc3opv1d, getString(R.string.nc3opv1) + " - " + getString(R.string.day))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3opv1m, getString(R.string.nc3opv1) + " - " + getString(R.string.month))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3opv1y, getString(R.string.nc3opv1) + " - " + getString(R.string.year2))) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3opv1d, 1, 31, 98, getString(R.string.nc3opv1), " day")) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3opv1m, 1, 31, 98, getString(R.string.nc3opv1), " month")) {
                        return false;
                    }

                    if (!validatorClass.RangeTextBox(this, binding.nc3opv1y, 2013, 2018, 9998, getString(R.string.nc3opv1), " year")) {
                        return false;
                    }

                }

//        nc3p1
                if (!validatorClass.EmptyRadioButton(this, binding.nc3p1, binding.nc3p1a, getString(R.string.nc3p1))) {
                    return false;
                }

                if (binding.nc3p1a.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, binding.nc3p1d, getString(R.string.nc3p1) + " - " + getString(R.string.day))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3p1m, getString(R.string.nc3p1) + " - " + getString(R.string.month))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3p1y, getString(R.string.nc3p1) + " - " + getString(R.string.year2))) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3p1d, 1, 31, 98, getString(R.string.nc3p1), " day")) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3p1m, 1, 31, 98, getString(R.string.nc3p1), " month")) {
                        return false;
                    }

                    if (!validatorClass.RangeTextBox(this, binding.nc3p1y, 2013, 2018, 9998, getString(R.string.nc3p1), " year")) {
                        return false;
                    }

                }

//        nc3pcv1
                if (!validatorClass.EmptyRadioButton(this, binding.nc3pcv1, binding.nc3pcv1a, getString(R.string.nc3pcv1))) {
                    return false;
                }

                if (binding.nc3pcv1a.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, binding.nc3pcv1d, getString(R.string.nc3pcv1) + " - " + getString(R.string.day))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3pcv1m, getString(R.string.nc3pcv1) + " - " + getString(R.string.month))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3pcv1y, getString(R.string.nc3pcv1) + " - " + getString(R.string.year2))) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3pcv1d, 1, 31, 98, getString(R.string.nc3pcv1), " day")) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3pcv1m, 1, 31, 98, getString(R.string.nc3pcv1), " month")) {
                        return false;
                    }

                    if (!validatorClass.RangeTextBox(this, binding.nc3pcv1y, 2013, 2018, 9998, getString(R.string.nc3pcv1), " year")) {
                        return false;
                    }

                }

//        nc3opv2
                if (!validatorClass.EmptyRadioButton(this, binding.nc3opv2, binding.nc3opv2a, getString(R.string.nc3opv2))) {
                    return false;
                }

                if (binding.nc3opv2a.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, binding.nc3opv2d, getString(R.string.nc3opv2) + " - " + getString(R.string.day))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3opv2m, getString(R.string.nc3opv2) + " - " + getString(R.string.month))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3opv2y, getString(R.string.nc3opv2) + " - " + getString(R.string.year2))) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3opv2d, 1, 31, 98, getString(R.string.nc3opv2), " day")) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3opv2m, 1, 31, 98, getString(R.string.nc3opv2), " month")) {
                        return false;
                    }

                    if (!validatorClass.RangeTextBox(this, binding.nc3opv2y, 2013, 2018, 9998, getString(R.string.nc3opv2), " year")) {
                        return false;
                    }

                }
//        nc3p2
                if (!validatorClass.EmptyRadioButton(this, binding.nc3p2, binding.nc3p2a, getString(R.string.nc3p2))) {
                    return false;
                }

                if (binding.nc3p2a.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, binding.nc3p2d, getString(R.string.nc3p2) + " - " + getString(R.string.day))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3p2m, getString(R.string.nc3p2) + " - " + getString(R.string.month))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3p2y, getString(R.string.nc3p2) + " - " + getString(R.string.year2))) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3p2d, 1, 31, 98, getString(R.string.nc3p2), " day")) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3p2m, 1, 31, 98, getString(R.string.nc3p2), " month")) {
                        return false;
                    }

                    if (!validatorClass.RangeTextBox(this, binding.nc3p2y, 2013, 2018, 9998, getString(R.string.nc3p2), " year")) {
                        return false;
                    }
                }
//        nc3pcv2
                if (!validatorClass.EmptyRadioButton(this, binding.nc3pcv2, binding.nc3pcv2a, getString(R.string.nc3pcv2))) {
                    return false;
                }

                if (binding.nc3pcv2a.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, binding.nc3pcv2d, getString(R.string.nc3pcv2) + " - " + getString(R.string.day))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3pcv2m, getString(R.string.nc3pcv2) + " - " + getString(R.string.month))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3pcv2y, getString(R.string.nc3pcv2) + " - " + getString(R.string.year2))) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3pcv2d, 1, 31, 98, getString(R.string.nc3pcv2), " day")) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3pcv2m, 1, 31, 98, getString(R.string.nc3pcv2), " month")) {
                        return false;
                    }

                    if (!validatorClass.RangeTextBox(this, binding.nc3pcv2y, 2013, 2018, 9998, getString(R.string.nc3pcv2), " year")) {
                        return false;
                    }
                }

//        nc3opv3
                if (!validatorClass.EmptyRadioButton(this, binding.nc3opv3, binding.nc3opv3a, getString(R.string.nc3opv3))) {
                    return false;
                }

                if (binding.nc3opv3a.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, binding.nc3opv3d, getString(R.string.nc3opv3) + " - " + getString(R.string.day))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3opv3m, getString(R.string.nc3opv3) + " - " + getString(R.string.month))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3opv3y, getString(R.string.nc3opv3) + " - " + getString(R.string.year2))) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3opv3d, 1, 31, 98, getString(R.string.nc3opv3), " day")) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3opv3m, 1, 31, 98, getString(R.string.nc3opv3), " month")) {
                        return false;
                    }

                    if (!validatorClass.RangeTextBox(this, binding.nc3opv3y, 2013, 2018, 9998, getString(R.string.nc3opv3), " year")) {
                        return false;
                    }
                }

//        nc3p3
                if (!validatorClass.EmptyRadioButton(this, binding.nc3p3, binding.nc3p3a, getString(R.string.nc3p3))) {
                    return false;
                }

                if (binding.nc3p3a.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, binding.nc3p3d, getString(R.string.nc3opv3) + " - " + getString(R.string.day))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3p3m, getString(R.string.nc3opv3) + " - " + getString(R.string.month))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3p3y, getString(R.string.nc3opv3) + " - " + getString(R.string.year2))) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3p3d, 1, 31, 98, getString(R.string.nc3opv3), " day")) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3p3m, 1, 31, 98, getString(R.string.nc3opv3), " month")) {
                        return false;
                    }

                    if (!validatorClass.RangeTextBox(this, binding.nc3p3y, 2013, 2018, 9998, getString(R.string.nc3opv3), " year")) {
                        return false;
                    }
                }

//        nc3pcv3
                if (!validatorClass.EmptyRadioButton(this, binding.nc3pcv3, binding.nc3pcv3a, getString(R.string.nc3pcv3))) {
                    return false;
                }

                if (binding.nc3pcv3a.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, binding.nc3pcv3d, getString(R.string.nc3pcv3) + " - " + getString(R.string.day))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3pcv3m, getString(R.string.nc3pcv3) + " - " + getString(R.string.month))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3pcv3y, getString(R.string.nc3pcv3) + " - " + getString(R.string.year2))) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3pcv3d, 1, 31, 98, getString(R.string.nc3pcv3), " day")) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3pcv3m, 1, 31, 98, getString(R.string.nc3pcv3), " month")) {
                        return false;
                    }

                    if (!validatorClass.RangeTextBox(this, binding.nc3pcv3y, 2013, 2018, 9998, getString(R.string.nc3pcv3), " year")) {
                        return false;
                    }

                }

//        nc3ipv3
                if (!validatorClass.EmptyRadioButton(this, binding.nc3ipv, binding.nc3ipva, getString(R.string.nc3ipv))) {
                    return false;
                }

                if (binding.nc3ipva.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, binding.nc3ipvd, getString(R.string.nc3ipv) + " - " + getString(R.string.day))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3ipvm, getString(R.string.nc3ipv) + " - " + getString(R.string.month))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3ipvy, getString(R.string.nc3ipv) + " - " + getString(R.string.year2))) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3ipvd, 1, 31, 98, getString(R.string.nc3ipv), " day")) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3ipvm, 1, 31, 98, getString(R.string.nc3ipv), " month")) {
                        return false;
                    }

                    if (!validatorClass.RangeTextBox(this, binding.nc3ipvy, 2013, 2018, 9998, getString(R.string.nc3ipv), " year")) {
                        return false;
                    }
                }

//        nc3m1dt
                if (!validatorClass.EmptyRadioButton(this, binding.nc3m1, binding.nc3m1a, getString(R.string.nc3m1))) {
                    return false;
                }

                if (binding.nc3m1a.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, binding.nc3m1d, getString(R.string.nc3m1) + " - " + getString(R.string.day))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3m1m, getString(R.string.nc3m1) + " - " + getString(R.string.month))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3m1y, getString(R.string.nc3m1) + " - " + getString(R.string.year2))) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3m1d, 1, 31, 98, getString(R.string.nc3m1), " day")) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3m1m, 1, 31, 98, getString(R.string.nc3m1), " month")) {
                        return false;
                    }

                    if (!validatorClass.RangeTextBox(this, binding.nc3m1y, 2013, 2018, 9998, getString(R.string.nc3m1), " year")) {
                        return false;
                    }

                }

//        nc3m2dt
                if (!validatorClass.EmptyRadioButton(this, binding.nc3m2, binding.nc3m2a, getString(R.string.nc3m2))) {
                    return false;
                }

                if (binding.nc3m2a.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, binding.nc3m2d, getString(R.string.nc3m2) + " - " + getString(R.string.day))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3m2m, getString(R.string.nc3m2) + " - " + getString(R.string.month))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, binding.nc3m2y, getString(R.string.nc3m2) + " - " + getString(R.string.year2))) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3m2d, 1, 31, 98, getString(R.string.nc3m2), " day")) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, binding.nc3m2m, 1, 31, 98, getString(R.string.nc3m2), " month")) {
                        return false;
                    }

                    if (!validatorClass.RangeTextBox(this, binding.nc3m2y, 2013, 2018, 9998, getString(R.string.nc3m2), " year")) {
                        return false;
                    }
                }

            }

        }
//        nc305
        if (!validatorClass.EmptyRadioButton(this, binding.nc305, binding.nc305c, getString(R.string.nc305))) {
            return false;
        }

//        nc306
        if (!validatorClass.EmptyRadioButton(this, binding.nc306, binding.nc306b, getString(R.string.nc306))) {
            return false;
        }

//        na307
        if (!validatorClass.EmptyRadioButton(this, binding.nc307, binding.nc307b, getString(R.string.nc307))) {
            return false;
        }

//        nc308
        if (!validatorClass.EmptyRadioButton(this, binding.nc308, binding.nc308b, getString(R.string.nc308))) {
            return false;
        }

        if (binding.nc308a.isChecked()) {
//        nc309
            if (!validatorClass.EmptyTextBox(this, binding.nc309, getString(R.string.nc309))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.nc309, 1, 4, getString(R.string.nc309), "DPT/COMBO/PENT")) {
                return false;
            }
        }

//        nc310
        if (!validatorClass.EmptyRadioButton(this, binding.nc310, binding.nc310b, getString(R.string.nc310))) {
            return false;
        }

        if (binding.nc310a.isChecked()) {
//        nc311
            if (!validatorClass.EmptyTextBox(this, binding.nc311, getString(R.string.nc311))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.nc311, 1, 4, getString(R.string.nc311), "PCV")) {
                return false;
            }
        }

//        nc311
//        if (!validatorClass.EmptyRadioButton(this, binding.nc311, binding.nc311b, getString(R.string.nc311))) {
//            return false;
//        }
////        nc312
//        if (!validatorClass.EmptyRadioButton(this, binding.nc312, binding.nc31298, getString(R.string.nc312))) {
//            return false;
//        }
//        nc312
        if (!validatorClass.EmptyRadioButton(this, binding.nc312, binding.nc31298, getString(R.string.nc312))) {
            return false;
        }

        if (binding.nc312a.isChecked()) {

//        nc313
            if (!validatorClass.EmptyTextBox(this, binding.nc313, getString(R.string.nc313))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.nc313, 1, 4, getString(R.string.nc313), "Mesasles / MMR")) {
                return false;
            }

        }
//        nc314
        if (!validatorClass.EmptyRadioButton(this, binding.nc314, binding.nc31498, getString(R.string.nc314))) {
            return false;
        }

//        nc315
        if (!validatorClass.EmptyRadioButton(this, binding.nc315, binding.nc31598, getString(R.string.nc315))) {
            return false;
        }

        if (binding.nc315a.isChecked()) {
//        nc316
            if (!validatorClass.EmptyRadioButton(this, binding.nc316, binding.nc31698, getString(R.string.nc316))) {
                return false;
            }
        }
        return true;
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }

    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sC3 = new JSONObject();

//        nc301
        MainApp.cc1.setNc3name(selectedChild.getName());
//        nc302
        MainApp.cc1.setNc300Serial(selectedChild.getSerialNo());

//        nc302
        MainApp.cc1.setNc302(binding.nc302a.isChecked() ? "1"
                : binding.nc302b.isChecked() ? "2"
                : "0");

//        nc303
        MainApp.cc1.setNc303(binding.nc303a.isChecked() ? "1"
                : binding.nc303b.isChecked() ? "2"
                : binding.nc303c.isChecked() ? "3"
                : binding.nc303d.isChecked() ? "4"
                : "0");
//at birth
//          nc3bcg
        MainApp.cc1.setNc3bcg(binding.nc3bcga.isChecked() ? "1"
                : binding.nc3bcgb.isChecked() ? "2"
                : "0");
        MainApp.cc1.setNc3bcgd(binding.nc3bcgd.getText().toString());
        MainApp.cc1.setNc3bcgm(binding.nc3bcgm.getText().toString());
        MainApp.cc1.setNc3bcgy(binding.nc3bcgy.getText().toString());


//          nc3opv0
        MainApp.cc1.setNc3opv0(binding.nc3opv0a.isChecked() ? "1"
                : binding.nc3opv0b.isChecked() ? "2"
                : "0");
        MainApp.cc1.setNc3opv0d(binding.nc3bcgd.getText().toString());
        MainApp.cc1.setNc3opv0m(binding.nc3bcgm.getText().toString());
        MainApp.cc1.setNc3opv0y(binding.nc3bcgy.getText().toString());


//       at age of 6

//          nc3opv1
        MainApp.cc1.setNc3opv1(binding.nc3opv1a.isChecked() ? "1"
                : binding.nc3opv1b.isChecked() ? "2"
                : "0");
        MainApp.cc1.setNc3opv1d(binding.nc3bcgd.getText().toString());
        MainApp.cc1.setNc3opv1m(binding.nc3bcgm.getText().toString());
        MainApp.cc1.setNc3opv1y(binding.nc3bcgy.getText().toString());

//          nc3p1
        MainApp.cc1.setNc3p1(binding.nc3p1a.isChecked() ? "1"
                : binding.nc3p1b.isChecked() ? "2"
                : "0");
        MainApp.cc1.setNc3p1d(binding.nc3bcgd.getText().toString());
        MainApp.cc1.setNc3p1m(binding.nc3bcgm.getText().toString());
        MainApp.cc1.setNc3p1y(binding.nc3bcgy.getText().toString());


//          nc3pcv1
        MainApp.cc1.setNc3pcv1(binding.nc3pcv1a.isChecked() ? "1"
                : binding.nc3pcv1b.isChecked() ? "2"
                : "0");
        MainApp.cc1.setNc3pcv1d(binding.nc3bcgd.getText().toString());
        MainApp.cc1.setNc3pcv1m(binding.nc3bcgm.getText().toString());
        MainApp.cc1.setNc3pcv1y(binding.nc3bcgy.getText().toString());

//       at age of 10 weeks

//          nc3opv2
        MainApp.cc1.setNc3opv2(binding.nc3opv2a.isChecked() ? "1"
                : binding.nc3opv2b.isChecked() ? "2"
                : "0");
        MainApp.cc1.setNc3opv2d(binding.nc3bcgd.getText().toString());
        MainApp.cc1.setNc3opv2m(binding.nc3bcgm.getText().toString());
        MainApp.cc1.setNc3opv2y(binding.nc3bcgy.getText().toString());

//          nc3p2
        MainApp.cc1.setNc3p2(binding.nc3p2a.isChecked() ? "1"
                : binding.nc3p2b.isChecked() ? "2"
                : "0");
        MainApp.cc1.setNc3p2d(binding.nc3bcgd.getText().toString());
        MainApp.cc1.setNc3p2m(binding.nc3bcgm.getText().toString());
        MainApp.cc1.setNc3p2y(binding.nc3bcgy.getText().toString());


//          nc3pcv2
        MainApp.cc1.setNc3pcv2(binding.nc3pcv2a.isChecked() ? "1"
                : binding.nc3pcv2b.isChecked() ? "2"
                : "0");
        MainApp.cc1.setNc3pcv2d(binding.nc3bcgd.getText().toString());
        MainApp.cc1.setNc3pcv2m(binding.nc3bcgm.getText().toString());
        MainApp.cc1.setNc3pcv2y(binding.nc3bcgy.getText().toString());


//       at age of 14 weeks

//          nc3opv3
        MainApp.cc1.setNc3opv3(binding.nc3opv3a.isChecked() ? "1"
                : binding.nc3opv3b.isChecked() ? "2"
                : "0");
        MainApp.cc1.setNc3opv3d(binding.nc3bcgd.getText().toString());
        MainApp.cc1.setNc3opv3m(binding.nc3bcgm.getText().toString());
        MainApp.cc1.setNc3opv3y(binding.nc3bcgy.getText().toString());

//          nc3p3
        MainApp.cc1.setNc3p3(binding.nc3p3a.isChecked() ? "1"
                : binding.nc3p3b.isChecked() ? "2"
                : "0");

        MainApp.cc1.setNc3p3d(binding.nc3bcgd.getText().toString());
        MainApp.cc1.setNc3p3m(binding.nc3bcgm.getText().toString());
        MainApp.cc1.setNc3p3y(binding.nc3bcgy.getText().toString());

//          nc3pcv3
        MainApp.cc1.setNc3pcv3(binding.nc3pcv3a.isChecked() ? "1"
                : binding.nc3pcv3b.isChecked() ? "2"
                : "0");
        MainApp.cc1.setNc3pcv3d(binding.nc3bcgd.getText().toString());
        MainApp.cc1.setNc3pcv3m(binding.nc3bcgm.getText().toString());
        MainApp.cc1.setNc3pcv3y(binding.nc3bcgy.getText().toString());

//          nc3ipv
        MainApp.cc1.setNc3ipv(binding.nc3ipva.isChecked() ? "1"
                : binding.nc3ipvb.isChecked() ? "2"
                : "0");
        MainApp.cc1.setNc3ipvd(binding.nc3bcgd.getText().toString());
        MainApp.cc1.setNc3ipvm(binding.nc3bcgm.getText().toString());
        MainApp.cc1.setNc3ipvy(binding.nc3bcgy.getText().toString());


//at the age of 9 months
//          nc3m1
        MainApp.cc1.setNc3m1(binding.nc3m1a.isChecked() ? "1"
                : binding.nc3m1b.isChecked() ? "2"
                : "0");
        MainApp.cc1.setNc3m1d(binding.nc3bcgd.getText().toString());
        MainApp.cc1.setNc3m1m(binding.nc3bcgm.getText().toString());
        MainApp.cc1.setNc3m1y(binding.nc3bcgy.getText().toString());


//at age of 15 months
//          nc3m2
        MainApp.cc1.setNc3m2(binding.nc3m2a.isChecked() ? "1"
                : binding.nc3m2b.isChecked() ? "2"
                : "0");
        MainApp.cc1.setNc3m2d(binding.nc3bcgd.getText().toString());
        MainApp.cc1.setNc3m2m(binding.nc3bcgm.getText().toString());
        MainApp.cc1.setNc3m2y(binding.nc3bcgy.getText().toString());


//        nc305
        MainApp.cc1.setNc305(binding.nc305a.isChecked() ? "1"
                : binding.nc305b.isChecked() ? "2" : binding.nc305c.isChecked() ? "98"
                : "0");

//        nc306
        MainApp.cc1.setNc306(binding.nc306a.isChecked() ? "1"
                : binding.nc306b.isChecked() ? "2"
                : binding.nc306c.isChecked() ? "98"
                : "0");

//        nc307
        MainApp.cc1.setNc307(binding.nc307a.isChecked() ? "1"
                : binding.nc307b.isChecked() ? "2"
                : binding.nc307c.isChecked() ? "98"
                : "0");

//        nc308
        MainApp.cc1.setNc308(binding.nc308a.isChecked() ? "1"
                : binding.nc308b.isChecked() ? "2"
                : binding.nc308c.isChecked() ? "98"
                : "0");

//        nc309
        MainApp.cc1.setNc309(binding.nc309.getText().toString());

//        nc310
        MainApp.cc1.setNc310(binding.nc310a.isChecked() ? "1"
                : binding.nc310b.isChecked() ? "2"
                : binding.nc310c.isChecked() ? "98"
                : "0");

//        nc311
        MainApp.cc1.setNc311(binding.nc311.getText().toString());


//        nc312
        MainApp.cc1.setNc312(binding.nc312a.isChecked() ? "1"
                : binding.nc312b.isChecked() ? "2"
                : binding.nc31298.isChecked() ? "98"
                : "0");

//        nc313
        MainApp.cc1.setNc313(binding.nc313.getText().toString());

//        nc314
        MainApp.cc1.setNc314(binding.nc314a.isChecked() ? "1"
                : binding.nc314b.isChecked() ? "2"
                : binding.nc31498.isChecked() ? "98"
                : "0");

//        nc315
        MainApp.cc1.setNc315(binding.nc315a.isChecked() ? "1"
                : binding.nc315b.isChecked() ? "2"
                : binding.nc31598.isChecked() ? "98"
                : "0");

//        nc316
        MainApp.cc1.setNc316(binding.nc316a.isChecked() ? "1"
                : binding.nc316b.isChecked() ? "2"
                : "0");


        //MainApp.cc.setsC3(String.valueOf(sC3));


        //Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSC3();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


}

