package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB3Binding;
import edu.aku.hassannaqvi.nns_2018.validation.clearClass;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionB3Activity extends AppCompatActivity implements TextWatcher, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    private final long DELAY = 1000;
    ActivitySectionB3Binding binding;
    DatabaseHelper db;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_b3);
        db = new DatabaseHelper(this);

//        Assigning data to UI binding
        binding.setCallback(this);

//        Skip Patterns
        binding.nw327.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                formValidation();
                if (i == R.id.nw32798) {
                    clearClass.ClearAllFields(binding.fldGrnw328, false);
                } else {
                    clearClass.ClearAllFields(binding.fldGrnw328, true);
                }
            }
        });

        binding.nw330.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                formValidation();
                if (i == R.id.nw330d) {
                    clearClass.ClearAllFields(binding.fldGrnw331, false);
//                    binding.nw331.clearCheck();
//                    binding.nw332.clearCheck();
                } else {
                    clearClass.ClearAllFields(binding.fldGrnw331, true);
                }
            }
        });

        binding.nw331.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                formValidation();
                if (i == R.id.nw331b) {
                    clearClass.ClearAllFields(binding.fldGrnw332, false);

//                    binding.nw332.clearCheck();
                } else {
                    clearClass.ClearAllFields(binding.fldGrnw332, true);

                }
            }
        });

//        Listener
        binding.nw328.setOnCheckedChangeListener(this);
        binding.nw329a.setOnCheckedChangeListener(this);
        binding.nw332.setOnCheckedChangeListener(this);

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

                startActivity(new Intent(this, SectionB4Activity.class));

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

        //Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//        nw327
        if (!validatorClass.EmptyRadioButton(this, binding.nw327, binding.nw32798, getString(R.string.nw327))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.nw327, binding.nw327a, binding.nw327m, getString(R.string.nw327))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.nw327, binding.nw327b, binding.nw327d, getString(R.string.nw327))) {
            return false;
        }

        if (!binding.nw32798.isChecked()) {
            // nw328
            if (!validatorClass.EmptyRadioButton(this, binding.nw328, binding.nw32896, binding.nw32896x, getString(R.string.nw328))) {
                return false;
            }
            // nw329
            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnw329, binding.nw329h, getString(R.string.nw329))) {
                return false;
            }
            // nw330
            if (!validatorClass.EmptyRadioButton(this, binding.nw330, binding.nw330d, getString(R.string.nw330))) {
                return false;
            }

            if (!binding.nw330d.isChecked()) {
                // nw331
                if (!validatorClass.EmptyRadioButton(this, binding.nw331, binding.nw331b, getString(R.string.nw331))) {
                    return false;
                }

                if (binding.nw331a.isChecked()) {
                    // nw332
                    if (!validatorClass.EmptyRadioButton(this, binding.nw332, binding.nw332d, getString(R.string.nw332))) {
                        return false;
                    }
                }
            }

        }

        return true;
    }


    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sB3 = new JSONObject();

        sB3.put("nw327", binding.nw327a.isChecked() ? "1"
                : binding.nw327b.isChecked() ? "2"
                : binding.nw32798.isChecked() ? "98"
                : "0");
        sB3.put("nw327m", binding.nw327m.getText().toString());
        sB3.put("nw327d", binding.nw327d.getText().toString());

        sB3.put("nw328", binding.nw328a.isChecked() ? "1"
                : binding.nw328b.isChecked() ? "2"
                : binding.nw328c.isChecked() ? "3"
                : binding.nw328d.isChecked() ? "4"
                : binding.nw328e.isChecked() ? "5"
                : binding.nw32896.isChecked() ? "96"
                : "0");

        sB3.put("nw32896x", binding.nw32896x.getText().toString());

        sB3.put("nw329a", binding.nw329a.isChecked() ? "1" : "0");
        sB3.put("nw329b", binding.nw329b.isChecked() ? "2" : "0");
        sB3.put("nw329c", binding.nw329c.isChecked() ? "3" : "0");
        sB3.put("nw329d", binding.nw329d.isChecked() ? "4" : "0");
        sB3.put("nw329e", binding.nw329e.isChecked() ? "5" : "0");
        sB3.put("nw329f", binding.nw329f.isChecked() ? "6" : "0");
        sB3.put("nw329g", binding.nw329g.isChecked() ? "7" : "0");
        sB3.put("nw329h", binding.nw329h.isChecked() ? "8" : "0");


        sB3.put("nw330", binding.nw330a.isChecked() ? "1"
                : binding.nw330b.isChecked() ? "2"
                : binding.nw330c.isChecked() ? "3"
                : binding.nw330d.isChecked() ? "4"
                : "0");

        sB3.put("nw331", binding.nw331a.isChecked() ? "1"
                : binding.nw331b.isChecked() ? "2"
                : "0");

        sB3.put("nw332", binding.nw332a.isChecked() ? "1"
                : binding.nw332b.isChecked() ? "2"
                : binding.nw332c.isChecked() ? "3"
                : binding.nw332d.isChecked() ? "4"
                : "0");

        MainApp.mc.setsB3(String.valueOf(sB3));


        //Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

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

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        timer.cancel();
        timer = new Timer();
        timer.schedule(
                new TimerTask() {
                    @Override
                    public void run() {

                        runOnUiThread(new Runnable() {
                            public void run() {
                                formValidation();
                            }
                        });

                    }
                },
                DELAY
        );
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        formValidation();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        formValidation();
    }
}

