package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

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
                    binding.nb303a.setChecked(false);
                    binding.nb303b.setChecked(false);
                    binding.nb303c.setChecked(false);
                    binding.nb303d.setChecked(false);
                    binding.nb303e.setChecked(false);
                    binding.nb303f.setChecked(false);
                    binding.nb303g.setChecked(false);
                    binding.nb303h.setChecked(false);
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
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, SectionB5Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

//        startActivity(new Intent(this, SectionB4Activity.class));
    }

    public void BtnEnd() {

        MainApp.endActivityMother(this, this, false);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }


    public boolean formValidation() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//        nb301
        if (!validatorClass.EmptyRadioButton(this, binding.nb301, binding.nb30198, getString(R.string.nb301))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.nb301, binding.nb301a, binding.nb301m, getString(R.string.nb301))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.nb301, binding.nb301b, binding.nb301d, getString(R.string.nb301))) {
            return false;
        }

        if (!binding.nb30198.isChecked()) {
            // nb302
            if (!validatorClass.EmptyRadioButton(this, binding.nb302, binding.nb30296, binding.nb30296x, getString(R.string.nb302))) {
                return false;
            }
            // nb303
            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb303, binding.nb303h, getString(R.string.nb303))) {
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


    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sB3 = new JSONObject();

        sB3.put("nb301", binding.nb301a.isChecked() ? "1"
                : binding.nb301b.isChecked() ? "2"
                : binding.nb30198.isChecked() ? "98"
                : "0");
        sB3.put("nb301m", binding.nb301m.getText().toString());
        sB3.put("nb301d", binding.nb301d.getText().toString());

        sB3.put("nb302", binding.nb302a.isChecked() ? "1"
                : binding.nb302b.isChecked() ? "2"
                : binding.nb302c.isChecked() ? "3"
                : binding.nb302d.isChecked() ? "4"
                : binding.nb302e.isChecked() ? "5"
                : binding.nb30296.isChecked() ? "96"
                : "0");

        sB3.put("nb30296x", binding.nb30296x.getText().toString());

        sB3.put("nb303a", binding.nb303a.isChecked() ? "1" : "0");
        sB3.put("nb303b", binding.nb303b.isChecked() ? "2" : "0");
        sB3.put("nb303c", binding.nb303c.isChecked() ? "3" : "0");
        sB3.put("nb303d", binding.nb303d.isChecked() ? "4" : "0");
        sB3.put("nb303e", binding.nb303e.isChecked() ? "5" : "0");
        sB3.put("nb303f", binding.nb303f.isChecked() ? "6" : "0");
        sB3.put("nb303g", binding.nb303g.isChecked() ? "7" : "0");
        sB3.put("nb303h", binding.nb303h.isChecked() ? "8" : "0");


        sB3.put("nb304", binding.nb304a.isChecked() ? "1"
                : binding.nb304b.isChecked() ? "2"
                : binding.nb304c.isChecked() ? "3"
                : binding.nb304d.isChecked() ? "4"
                : "0");

        sB3.put("nb305", binding.nb305a.isChecked() ? "1"
                : binding.nb305b.isChecked() ? "2"
                : "0");

        sB3.put("nb306", binding.nb306a.isChecked() ? "1"
                : binding.nb306b.isChecked() ? "2"
                : binding.nb306c.isChecked() ? "3"
                : binding.nb306d.isChecked() ? "4"
                : "0");

        //MainApp.cc.setsB(String.valueOf(sB));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSB3();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

        //return true;

    }

}

