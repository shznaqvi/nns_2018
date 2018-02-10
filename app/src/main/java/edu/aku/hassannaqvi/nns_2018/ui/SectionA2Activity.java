package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Toast;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionA2Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;


public class SectionA2Activity extends AppCompatActivity {

    ActivitySectionA2Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_a2);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a2);
        bi.setCallback(this);

        setupViews();

        bi.na2dob.setManager(getSupportFragmentManager());
    }


    public void setupViews() {
        bi.na2dob.setManager(getSupportFragmentManager());

        bi.na20798.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.na2dob.setEnabled(false);
                    bi.na2dob.setText(null);
                    bi.na2aged.setEnabled(true);
                    bi.na2agem.setEnabled(true);
                    bi.na2agey.setEnabled(true);
                } else {
                    bi.na2dob.setEnabled(true);
                    bi.na2aged.setEnabled(false);
                    bi.na2aged.setText(null);
                    bi.na2agem.setEnabled(false);
                    bi.na2agem.setText(null);
                    bi.na2agey.setEnabled(false);
                    bi.na2agey.setText(null);
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

        startActivity(new Intent(this, SectionA3Activity.class));

    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);

    }

    private boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyTextBox(this, bi.na202, getString(R.string.na202))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.na203, bi.na203a, getString(R.string.na203))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.na203, bi.na20396, bi.na20396x, getString(R.string.na203) + " - " + getString(R.string.other))) {
            return false;
        }


        if (!validatorClass.EmptySpinner(this, bi.na204, getString(R.string.na204))) {
            return false;
        }

        if (!validatorClass.EmptySpinner(this, bi.na205, getString(R.string.na205))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.na206, bi.na206a, getString(R.string.na206))) {
            return false;
        }

        if (bi.na20798.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.na2aged, getString(R.string.na2age))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.na2aged, 0, 29, getString(R.string.na2age), " days")) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.na2agem, getString(R.string.na2age))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.na2agem, 0, 11, getString(R.string.na2age), " months")) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.na2agey, getString(R.string.na2age))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.na2aged, 0, 99, getString(R.string.na2age), " years")) {
                return false;
            }

            if (bi.na2aged.getText().toString().equals("0") && bi.na2agem.getText().toString().equals("0") && bi.na2agey.getText().toString().equals("0")) {
                Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.na2age), Toast.LENGTH_LONG).show();
                bi.na2agey.setError("All can not be zero");
                bi.na2agem.setError("All can not be zero");
                bi.na2aged.setError("All can not be zero");
                Log.i(SectionA2Activity.class.getSimpleName(), "na2age" + ": This data is Required!");
            } else {
                bi.na2agey.setError(null);
                bi.na2agem.setError(null);
                bi.na2aged.setError(null);
            }


        } else {
            if (!validatorClass.EmptyTextBox(this, bi.na2dob, getString(R.string.na2dob))) {
                return false;
            }

        }

        if (!validatorClass.EmptyRadioButton(this, bi.na2edu, bi.na2edua, getString(R.string.na2edu))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.na2occ, bi.na2occa, getString(R.string.na2occ))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.na2occ, bi.na2occ96, bi.na2occ96x, getString(R.string.na2occ) + " - " + getString(R.string.other))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.na2ms, bi.na2msa, getString(R.string.na2ms))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.na212, bi.na212a, getString(R.string.na212))) {
            return false;
        }

        return validatorClass.EmptyTextBox(this, bi.na213, getString(R.string.na213));
    }



}