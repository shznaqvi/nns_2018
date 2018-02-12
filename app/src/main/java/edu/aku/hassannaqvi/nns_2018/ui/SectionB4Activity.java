package edu.aku.hassannaqvi.nns_2018.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB4Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionB4Activity extends Activity {

    ActivitySectionB4Binding binding;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_b4);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_b4);
        db = new DatabaseHelper(this);
        binding.setCallback(this);

        binding.nb40299.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    binding.nb402a.setChecked(false);
                    binding.nb402b.setChecked(false);
                    binding.nb402c.setChecked(false);
                    binding.nb402d.setChecked(false);
                    binding.nb402e.setChecked(false);
                    binding.nb40296.setChecked(false);

                    binding.nb402a.setEnabled(false);
                    binding.nb402b.setEnabled(false);
                    binding.nb402c.setEnabled(false);
                    binding.nb402d.setEnabled(false);
                    binding.nb402e.setEnabled(false);
                    binding.nb40296.setEnabled(false);
                } else {
                    binding.nb402a.setEnabled(true);
                    binding.nb402b.setEnabled(true);
                    binding.nb402c.setEnabled(true);
                    binding.nb402d.setEnabled(true);
                    binding.nb402e.setEnabled(true);
                    binding.nb40296.setEnabled(true);
                }
            }
        });
        binding.nb405.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.nb405b || checkedId == R.id.nb40598) {
                    binding.fldGrpnb406.setVisibility(View.GONE);
                    binding.nb406c.setText(null);
                    binding.nb406r.setText(null);
                    binding.nb40698.setChecked(false);
                } else {
                    binding.fldGrpnb406.setVisibility(View.VISIBLE);
                }
            }
        });
        binding.nb411.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.nb411b || checkedId == R.id.nb41198) {
                    binding.fldGrpnb412check.setVisibility(View.GONE);
                    binding.nb412a.setChecked(false);
                    binding.nb412b.setChecked(false);
                    binding.nb412c.setChecked(false);
                    binding.nb412d.setChecked(false);
                    binding.nb412e.setChecked(false);
                    binding.nb41296.setChecked(false);
                    binding.nb41298.setChecked(false);

                    binding.nb41296x.setText(null);

                } else {
                    binding.fldGrpnb412check.setVisibility(View.VISIBLE);
                }
            }
        });
        binding.nb41298.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    binding.nb412a.setEnabled(false);
                    binding.nb412b.setEnabled(false);
                    binding.nb412c.setEnabled(false);
                    binding.nb412d.setEnabled(false);
                    binding.nb412e.setEnabled(false);
                    binding.nb41296.setEnabled(false);

                    binding.nb412a.setChecked(false);
                    binding.nb412b.setChecked(false);
                    binding.nb412c.setChecked(false);
                    binding.nb412d.setChecked(false);
                    binding.nb412e.setChecked(false);
                    binding.nb41296.setChecked(false);

                    binding.nb41296x.setText(null);

                } else {
                    binding.nb412a.setEnabled(true);
                    binding.nb412b.setEnabled(true);
                    binding.nb412c.setEnabled(true);
                    binding.nb412d.setEnabled(true);
                    binding.nb412e.setEnabled(true);
                    binding.nb41296.setEnabled(true);
                }
            }
        });
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

        startActivity(new Intent(this, SectionB5Activity.class));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);

    }


    public boolean formValidation() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyRadioButton(this, binding.nb401, binding.nb40196, binding.nb40196x, getString(R.string.nb401))) {
            return false;
        }

        // nb402
        if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb402check, binding.nb40296, binding.nb40296x, String.valueOf(R.string.nb402))) {
            return false;
        }
        // nb403
        if (!validatorClass.EmptyRadioButton(this, binding.nb403, binding.nb40396, binding.nb40396x, getString(R.string.nb403))) {
            return false;
        }
        // nb404
        if (!validatorClass.EmptyRadioButton(this, binding.nb404, binding.nb40498, getString(R.string.nb404))) {
            return false;
        }
        // nb405
        if (!validatorClass.EmptyRadioButton(this, binding.nb405, binding.nb40598, getString(R.string.nb405))) {
            return false;
        }

        if (!binding.nb405b.isChecked()) {
            // nb406

        }

        // nb407
        if (!validatorClass.EmptyRadioButton(this, binding.nb407, binding.nb40798, getString(R.string.nb407))) {
            return false;
        }
        // nb408
        if (!validatorClass.EmptyRadioButton(this, binding.nb408, binding.nb40898, getString(R.string.nb408))) {
            return false;
        }
        // nb409
        if (!validatorClass.EmptyRadioButton(this, binding.nb409, binding.nb40998, getString(R.string.nb409))) {
            return false;
        }
        // nb410
        if (!validatorClass.EmptyRadioButton(this, binding.nb410, binding.nb41098, getString(R.string.nb410))) {
            return false;
        }

        if (!binding.nb411a.isChecked()) {
            // nb412
            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb412check, binding.nb41296, binding.nb41296x, String.valueOf(R.string.nb402))) {
                return false;
            }
        }

        return true;
    }
}
