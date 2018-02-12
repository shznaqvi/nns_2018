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
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB5Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionB5Activity extends AppCompatActivity {

    ActivitySectionB5Binding binding;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_b5);
        db = new DatabaseHelper(this);

//        Assigning data to UI binding
        binding.setCallback(this);

//        Skip patterns

        binding.nb501.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nb501b) {
                    binding.nb502a.setChecked(false);
                    binding.nb502b.setChecked(false);
                    binding.nb502c.setChecked(false);
                    binding.nb502d.setChecked(false);
                    binding.nb502e.setChecked(false);
                    binding.nb502f.setChecked(false);
                    binding.nb502g.setChecked(false);
                    binding.nb50296.setChecked(false);

                    binding.nb503.clearCheck();
                    binding.nb504.setText(null);

                    binding.nb505a.setChecked(false);
                    binding.nb505b.setChecked(false);
                    binding.nb505c.setChecked(false);
                    binding.nb505d.setChecked(false);
                    binding.nb505e.setChecked(false);
                    binding.nb505f.setChecked(false);
                    binding.nb505g.setChecked(false);
                    binding.nb505h.setChecked(false);
                    binding.nb50596.setChecked(false);

                }
            }
        });

        binding.nb506.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nb506b) {
                    binding.nb507a.setChecked(false);
                    binding.nb507b.setChecked(false);
                    binding.nb507c.setChecked(false);
                    binding.nb507d.setChecked(false);
                    binding.nb507e.setChecked(false);
                    binding.nb507f.setChecked(false);
                    binding.nb507g.setChecked(false);
                    binding.nb50796.setChecked(false);

                    binding.nb508.clearCheck();
                    binding.nb509.setText(null);

                    binding.nb510a.setChecked(false);
                    binding.nb510b.setChecked(false);
                    binding.nb510c.setChecked(false);
                    binding.nb510d.setChecked(false);
                    binding.nb510e.setChecked(false);
                    binding.nb51096.setChecked(false);
                }
            }
        });


    }

    public void BtnContinue() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        /*if (ValidateForm()) {
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

        startActivity(new Intent(this, SectionB6Activity.class));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }


    private boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyRadioButton(this, binding.nb501, binding.nb501a, getString(R.string.nb501))) {
            return false;
        }

        if (binding.nb501a.isChecked()) {
            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb502check, binding.nb502a, getString(R.string.nb502))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb502check, binding.nb50296, binding.nb50296x, getString(R.string.nb502) + " - " + getString(R.string.other))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, binding.nb503, binding.nb503a, getString(R.string.nb503))) {
                return false;
            }

            if (binding.nb503a.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, binding.nb503hr, getString(R.string.nb503a))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, binding.nb503hr, 1, 23, getString(R.string.nb503a), " hours")) {
                    return false;
                }


            }


            if (binding.nb503b.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, binding.nb503d, getString(R.string.nb503b))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, binding.nb503d, 1, 29, getString(R.string.nb503b), " days")) {
                    return false;
                }

            }

            if (binding.nb503c.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, binding.nb503w, getString(R.string.nb503c))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, binding.nb503w, 1, 29, getString(R.string.nb503c), " weeks")) {
                    return false;
                }

            }


            if (!validatorClass.EmptyTextBox(this, binding.nb504, getString(R.string.nb504))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, binding.nb504, 1, 12, getString(R.string.nb504), " times")) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb505check, binding.nb505a, getString(R.string.nb505))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb505check, binding.nb50596, binding.nb50596x, getString(R.string.nb505) + " - " + getString(R.string.other))) {
                return false;
            }

        }


        if (!validatorClass.EmptyRadioButton(this, binding.nb506, binding.nb506a, getString(R.string.nb506))) {
            return false;
        }


        if (binding.nb506a.isChecked()) {

            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb507check, binding.nb507a, getString(R.string.nb507))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb507check, binding.nb50796, binding.nb50796x, getString(R.string.nb505) + " - " + getString(R.string.other))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, binding.nb508, binding.nb508a, getString(R.string.nb508))) {
                return false;
            }

            if (binding.nb508a.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, binding.nb508hr, getString(R.string.nb508a))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, binding.nb508hr, 1, 23, getString(R.string.nb508a), " hours")) {
                    return false;
                }


            }


            if (binding.nb508b.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, binding.nb508d, getString(R.string.nb508b))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, binding.nb508d, 1, 29, getString(R.string.nb508b), " days")) {
                    return false;
                }

            }

            if (binding.nb508c.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, binding.nb508w, getString(R.string.nb508c))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, binding.nb508w, 1, 29, getString(R.string.nb508c), " weeks")) {
                    return false;
                }

            }


            if (!validatorClass.EmptyTextBox(this, binding.nb509, getString(R.string.nb509))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, binding.nb509, 1, 12, getString(R.string.nb509), " times")) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb510check, binding.nb510a, getString(R.string.nb510))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb510check, binding.nb51096, binding.nb51096x, getString(R.string.nb510) + " - " + getString(R.string.other))) {
                return false;
            }


        }

        return true;
    }

}
