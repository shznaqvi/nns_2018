package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionA5Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionA5Activity extends AppCompatActivity {

    ActivitySectionA5Binding binding;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_a5);
        db = new DatabaseHelper(this);

//        Assigning data to UI binding
        binding.setCallback(this);

        binding.na501.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (!(checkedId == R.id.na501a)) {
                    binding.na502.clearCheck();
                    binding.na503a.setChecked(false);
                    binding.na503b.setChecked(false);
                    binding.na503c.setChecked(false);
                    binding.na503d.setChecked(false);
                    binding.na503e.setChecked(false);
                }
            }
        });

        binding.na503e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    binding.na503a.setEnabled(false);
                    binding.na503b.setEnabled(false);
                    binding.na503c.setEnabled(false);
                    binding.na503d.setEnabled(false);

                    binding.na503a.setChecked(false);
                    binding.na503b.setChecked(false);
                    binding.na503c.setChecked(false);
                    binding.na503d.setChecked(false);

                } else {
                    binding.na503a.setEnabled(true);
                    binding.na503b.setEnabled(true);
                    binding.na503c.setEnabled(true);
                    binding.na503d.setEnabled(true);
                }
            }
        });

        binding.na504.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.na504b) {
                    binding.na505a.setChecked(false);
                    binding.na505b.setChecked(false);
                    binding.na505c.setChecked(false);
                    binding.na505d.setChecked(false);
                    binding.na505e.setChecked(false);
                }
            }
        });
        binding.na505e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    binding.na505a.setEnabled(false);
                    binding.na505b.setEnabled(false);
                    binding.na505c.setEnabled(false);
                    binding.na505d.setEnabled(false);

                    binding.na505a.setChecked(false);
                    binding.na505b.setChecked(false);
                    binding.na505c.setChecked(false);
                    binding.na505d.setChecked(false);

                } else {
                    binding.na505a.setEnabled(true);
                    binding.na505b.setEnabled(true);
                    binding.na505c.setEnabled(true);
                    binding.na505d.setEnabled(true);
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

        startActivity(new Intent(this, SectionA8AActivity.class));
    }

    public boolean formValidation() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//        na501
        if (!validatorClass.EmptyRadioButton(this, binding.na501, binding.na501d, getString(R.string.na501))) {
            return false;
        }

//        na502
        if (!binding.na502a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, binding.na501, binding.na502b, getString(R.string.na502b))) {
                return false;
            }
            // na503
            if (!validatorClass.EmptyCheckBox(this, binding.fldGrna503check, binding.na503e, String.valueOf(R.string.na503))) {
                return false;
            }
        }

//        na504
        if (!validatorClass.EmptyRadioButton(this, binding.na504, binding.na504b, getString(R.string.na504))) {
            return false;
        }
//        na505
        if (!validatorClass.EmptyCheckBox(this, binding.fldGrpna505check, binding.na505e, String.valueOf(R.string.na505))) {
            return false;
        }
//        na50601
        if (!validatorClass.EmptyRadioButton(this, binding.na50601, binding.na50601b, getString(R.string.na50601))) {
            return false;
        }
//        na50602
        if (!validatorClass.EmptyRadioButton(this, binding.na50602, binding.na50602b, getString(R.string.na50602))) {
            return false;
        }
//        na50603
        if (!validatorClass.EmptyRadioButton(this, binding.na50603, binding.na50603b, getString(R.string.na50603))) {
            return false;
        }
//        na50604
        if (!validatorClass.EmptyRadioButton(this, binding.na50604, binding.na50604b, getString(R.string.na50604))) {
            return false;
        }
//        na50605
        if (!validatorClass.EmptyRadioButton(this, binding.na50605, binding.na50605b, getString(R.string.na50605))) {
            return false;
        }
//        na50696
        if (!validatorClass.EmptyRadioButton(this, binding.na50696, binding.na50696a, binding.na50696x, getString(R.string.other))) {
            return false;
        }
//        na601
        if (!validatorClass.EmptyRadioButton(this, binding.na601, binding.na60196, binding.na60196x, getString(R.string.other))) {
            return false;
        }
//        na602
        if (!validatorClass.EmptyRadioButton(this, binding.na602, binding.na602c, getString(R.string.na602))) {
            return false;
        }
//        na603
        if (!validatorClass.EmptyRadioButton(this, binding.na603, binding.na603d, getString(R.string.na603))) {
            return false;
        }

//        na701
        if (!validatorClass.EmptyRadioButton(this, binding.na701, binding.na70199, getString(R.string.na701))) {
            return false;
        }
//        na702
        if (!validatorClass.EmptyRadioButton(this, binding.na702, binding.na70299, getString(R.string.na702))) {
            return false;
        }
//        na703
        if (!validatorClass.EmptyRadioButton(this, binding.na703, binding.na70399, getString(R.string.na703))) {
            return false;
        }
//        na704
        if (!validatorClass.EmptyRadioButton(this, binding.na704, binding.na70499, getString(R.string.na704))) {
            return false;
        }
//        na705
        if (!validatorClass.EmptyRadioButton(this, binding.na705, binding.na70599, getString(R.string.na705))) {
            return false;
        }
//        na706
        if (!validatorClass.EmptyRadioButton(this, binding.na706, binding.na70699, getString(R.string.na706))) {
            return false;
        }
//        na707
        if (!validatorClass.EmptyRadioButton(this, binding.na707, binding.na70799, getString(R.string.na707))) {
            return false;
        }
//        na708
        if (!validatorClass.EmptyRadioButton(this, binding.na708, binding.na70899, getString(R.string.na708))) {
            return false;
        }
//        na709
        return validatorClass.EmptyRadioButton(this, binding.na709, binding.na70999, getString(R.string.na709));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);

    }


}
