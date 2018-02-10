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
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB3Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionB3Activity extends AppCompatActivity {

    ActivitySectionB3Binding binding;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_b3);
        db = new DatabaseHelper(this);

//        Assigning data to UI binding
        binding.setCallback(this);

//        Skip Patterns
        binding.nb301.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nb30198) {
                    binding.nb302.clearCheck();
                    binding.nb303.clearCheck();
                    binding.nb304.clearCheck();
                    binding.nb305.clearCheck();
                    binding.nb306.clearCheck();
                }
            }
        });

        binding.nb304.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nb304d) {
                    binding.nb305.clearCheck();
                    binding.nb306.clearCheck();
                }
            }
        });

        binding.nb305.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nb305b) {
                    binding.nb306.clearCheck();
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

        startActivity(new Intent(this, SectionB4Activity.class));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }


    public boolean formValidation() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//        nb301
        if (!validatorClass.EmptyRadioButton(this, binding.nb301, binding.nb30198, getString(R.string.nb301))) {
            return false;
        }

        if (!binding.nb30198.isChecked()) {
            // nb302
            if (!validatorClass.EmptyRadioButton(this, binding.nb302, binding.nb30296, binding.nb30296x, getString(R.string.nb302))) {
                return false;
            }
            // nb303
            if (!validatorClass.EmptyRadioButton(this, binding.nb303, binding.nb303h, getString(R.string.nb303))) {
                return false;
            }
            // nb304
            if (!validatorClass.EmptyRadioButton(this, binding.nb304, binding.nb304d, getString(R.string.nb304))) {
                return false;
            }

            if (!binding.nb304d.isChecked()) {
                // nb305
                if (!validatorClass.EmptyRadioButton(this, binding.nb305, binding.nb305b, getString(R.string.nb305))) {
                    return false;
                }

                if (binding.nb305a.isChecked()) {
                    // nb306
                    if (!validatorClass.EmptyRadioButton(this, binding.nb306, binding.nb306d, getString(R.string.nb306))) {
                        return false;
                    }
                }
            }

        }


        return true;
    }
}
