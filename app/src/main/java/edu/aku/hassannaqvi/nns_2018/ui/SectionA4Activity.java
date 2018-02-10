package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionA4Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionA4Activity extends AppCompatActivity {

    ActivitySectionA4Binding binding;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_a4);
        db = new DatabaseHelper(this);

//        Assigning data to UI binding
        binding.setCallback(this);

//        Skip Pattern

//        na403
        binding.na403.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.na403b) {
                    binding.na404.clearCheck();
                    binding.na40496x.setText(null);
                }
            }
        });

//        na405
        binding.na405.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.na405i) {
                    binding.na406.clearCheck();
                    binding.na407.setText(null);
                }
            }
        });

//        na419
        binding.na419.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.na419b) {
                    binding.na420.clearCheck();
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

        startActivity(new Intent(this, SectionA5Activity.class));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);

    }
    private boolean formValidation() {
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();
        if (!validatorClass.EmptyRadioButton(this, binding.na401, binding.na40196, binding.na40196x, getString(R.string.na401))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na402, binding.na40296, binding.na40296x, getString(R.string.na402))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na403, binding.na403b, getString(R.string.na403))) {
            return false;
        }
        if (binding.na403a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, binding.na404, binding.na40496, binding.na40496x, getString(R.string.na404))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na405, binding.na40596, binding.na40596x, getString(R.string.na405))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na406, binding.na406b, getString(R.string.na406))) {
            return false;
        }

        if (binding.na406a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, binding.na407, getString(R.string.na407))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na408, binding.na40896, binding.na40896x, getString(R.string.na408))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na40901, binding.na40901b, getString(R.string.na40901))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na40902, binding.na40902b, getString(R.string.na40902))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na40903, binding.na40903b, getString(R.string.na40903))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na40904, binding.na40904b, getString(R.string.na40904))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na40905, binding.na40905b, getString(R.string.na40905))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410a, getString(R.string.na410a))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410b, getString(R.string.na410b))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410c, getString(R.string.na410c))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410d, getString(R.string.na410d))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410e, getString(R.string.na410e))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410f, getString(R.string.na410f))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410g, getString(R.string.na410g))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410h, getString(R.string.na410h))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410i, getString(R.string.na410i))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410j, getString(R.string.na410j))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410k, getString(R.string.na410k))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410l, getString(R.string.na410l))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410m, getString(R.string.na410m))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410n, getString(R.string.na410n))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410o, getString(R.string.na410o))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410p, getString(R.string.na410p))) {
            return false;
        }

        if (!validatorClass.EmptyCheckBox(this, binding.fldGrpna0411check, binding.na41196, binding.na41196x, getString(R.string.na411))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na412, binding.na41296, binding.na41296x, getString(R.string.na412))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na413, binding.na41396, binding.na41396x, getString(R.string.na413))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na414, binding.na41496, binding.na41496x, getString(R.string.na414))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na415, binding.na41596, binding.na41596x, getString(R.string.na415))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na416, binding.na41696, binding.na41696x, getString(R.string.na416))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, binding.na417, 1, 15, getString(R.string.na417), "Room")) {
            return false;
        }
        if (!validatorClass.EmptyCheckBox(this, binding.fldGrpna0418check, binding.na418i, getString(R.string.na418))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na419, binding.na419b, getString(R.string.na419))) {
            return false;
        }
        if (binding.na419a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, binding.na420acr, getString(R.string.na420acr))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, binding.na420can, getString(R.string.na420can))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, binding.na420, binding.na42098, getString(R.string.na420))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na421, binding.na421b, getString(R.string.na421))) {
            return false;
        }
        if (binding.na421a.isChecked()) {
            if (!validatorClass.RangeTextBox(this, binding.na422a, 0, 999, getString(R.string.na422a), "Animal")) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.na422b, 0, 999, getString(R.string.na422b), "Animal")) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.na422c, 0, 999, getString(R.string.na422c), "Animal")) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.na422d, 0, 999, getString(R.string.na422d), "Animal")) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.na422e, 0, 999, getString(R.string.na422e), "Animal")) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.na422f, 0, 999, getString(R.string.na422f), "Animal")) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.na422g, 0, 999, getString(R.string.na422g), "Animal")) {
                return false;
            }
        }
        return true;

    }

}
