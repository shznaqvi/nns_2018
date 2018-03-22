package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionA5Binding;
import edu.aku.hassannaqvi.nns_2018.validation.clearClass;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionA5Activity extends AppCompatActivity {

    private final long DELAY = 1000;
    ActivitySectionA5Binding binding;
    DatabaseHelper db;
    int recipientCounter = 0;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_a5);
        db = new DatabaseHelper(this);

//        Assigning data to UI binding
        binding.setCallback(this);

        binding.nh401.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (!(checkedId == R.id.nh401a)) {

                    clearClass.ClearAllFields(binding.fldGrpnh402, false);
                    /*binding.nh402.clearCheck();
                    binding.nh403a.setChecked(false);
                    binding.nh403b.setChecked(false);
                    binding.nh403c.setChecked(false);
                    binding.nh403d.setChecked(false);
                    binding.nh403e.setChecked(false);*/
                } else {
                    clearClass.ClearAllFields(binding.fldGrpnh402, true);
                }
            }
        });

        binding.nh403e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    binding.nh403a.setEnabled(false);
                    binding.nh403b.setEnabled(false);
                    binding.nh403c.setEnabled(false);
                    binding.nh403d.setEnabled(false);

                    binding.nh403a.setChecked(false);
                    binding.nh403b.setChecked(false);
                    binding.nh403c.setChecked(false);
                    binding.nh403d.setChecked(false);

                } else {
                    binding.nh403a.setEnabled(true);
                    binding.nh403b.setEnabled(true);
                    binding.nh403c.setEnabled(true);
                    binding.nh403d.setEnabled(true);
                }
            }
        });

        binding.nh404.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.nh404b) {
                    clearClass.ClearAllFields(binding.fldGrpnh405, false);
                    /*binding.nh405a.setChecked(false);
                    binding.nh405b.setChecked(false);
                    binding.nh405c.setChecked(false);
                    binding.nh405d.setChecked(false);
                    binding.nh405e.setChecked(false);*/
                } else {
                    clearClass.ClearAllFields(binding.fldGrpnh405, true);
                }
            }
        });
        binding.nh405e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    binding.nh405a.setEnabled(false);
                    binding.nh405b.setEnabled(false);
                    binding.nh405c.setEnabled(false);
                    binding.nh405d.setEnabled(false);

                    binding.nh405a.setChecked(false);
                    binding.nh405b.setChecked(false);
                    binding.nh405c.setChecked(false);
                    binding.nh405d.setChecked(false);

                } else {
                    binding.nh405a.setEnabled(true);
                    binding.nh405b.setEnabled(true);
                    binding.nh405c.setEnabled(true);
                    binding.nh405d.setEnabled(true);
                }
            }
        });
        binding.nh403a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (binding.nh403a.isChecked() || binding.nh403b.isChecked() || binding.nh403c.isChecked()) {
                    clearClass.ClearAllFields(binding.fldGrnh404, false);
                    clearClass.ClearAllFields(binding.fldGrpnh405, false);
                   /* binding.nh404.clearCheck();
                    binding.nh405a.setChecked(false);
                    binding.nh405b.setChecked(false);
                    binding.nh405c.setChecked(false);
                    binding.nh405d.setChecked(false);
                    binding.nh405e.setChecked(false);*/
                } else {
                    clearClass.ClearAllFields(binding.fldGrnh404, true);
                    clearClass.ClearAllFields(binding.fldGrpnh405, true);

                }
            }
        });
        binding.nh403b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (binding.nh403a.isChecked() || binding.nh403b.isChecked() || binding.nh403c.isChecked()) {
                    clearClass.ClearAllFields(binding.fldGrnh404, false);
                    clearClass.ClearAllFields(binding.fldGrpnh405, false);
                    /*binding.nh404.clearCheck();
                    binding.nh405a.setChecked(false);
                    binding.nh405b.setChecked(false);
                    binding.nh405c.setChecked(false);
                    binding.nh405d.setChecked(false);
                    binding.nh405e.setChecked(false);*/
                } else {
                    clearClass.ClearAllFields(binding.fldGrnh404, true);
                    clearClass.ClearAllFields(binding.fldGrpnh405, true);

                }
            }
        });
        binding.nh403c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (binding.nh403a.isChecked() || binding.nh403b.isChecked() || binding.nh403c.isChecked()) {
                    clearClass.ClearAllFields(binding.fldGrnh404, false);
                    clearClass.ClearAllFields(binding.fldGrpnh405, false);
                   /* binding.nh404.clearCheck();
                    binding.nh405a.setChecked(false);
                    binding.nh405b.setChecked(false);
                    binding.nh405c.setChecked(false);
                    binding.nh405d.setChecked(false);
                    binding.nh405e.setChecked(false);*/
                } else {
                    clearClass.ClearAllFields(binding.fldGrnh404, true);
                    clearClass.ClearAllFields(binding.fldGrpnh405, true);
                }
            }
        });

        binding.nh501.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.nh501d) {
                    clearClass.ClearAllFields(binding.fldGrnh602, false);

                } else {
                    clearClass.ClearAllFields(binding.fldGrnh602, true);

                }
            }
        });

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

                if (recipientCounter > 0) {
                    startActivity(new Intent(this, SectionA8AActivity.class).putExtra("recCounter", recipientCounter));
                } else if (MainApp.mwra.size() > 0) {
                    startActivity(new Intent(this, SectionB1Activity.class));
                } else if (MainApp.childUnder5.size() > 0) {
                    if (MainApp.childUnder5.size() == MainApp.childNA.size()) {
                        SectionC1Activity.isNA = true;
                        startActivity(new Intent(this, SectionC1Activity.class));
                    } else {
                        SectionC1Activity.isNA = false;
                        startActivity(new Intent(this, SectionC1Activity.class));
                    }
                } else {
                    startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
                }


            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }

    public boolean formValidation() {

        //Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//        nh401
        if (!validatorClass.EmptyRadioButton(this, binding.nh401, binding.nh401d, getString(R.string.nh401))) {
            return false;
        }

//        nh402
        if (binding.nh401a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, binding.nh402, binding.nh402b, getString(R.string.nh402b))) {
                return false;
            }
            // nh403
            if (!validatorClass.EmptyCheckBox(this, binding.fldGrnh403check, binding.nh403a, getString(R.string.nh403))) {
                return false;
            }
        }
        if (!binding.nh403a.isChecked() && !binding.nh403b.isChecked() && !binding.nh403c.isChecked()) {
//        nh404
            if (!validatorClass.EmptyRadioButton(this, binding.nh404, binding.nh404a, getString(R.string.nh404))) {
                return false;
            }

//        nh405
            if (binding.nh404a.isChecked()) {
                if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnh405check, binding.nh405e, getString(R.string.nh405))) {
                    return false;
                }
            }
        }
//        nh40601
        if (!validatorClass.EmptyRadioButton(this, binding.nh40601, binding.nh40601b, getString(R.string.nh40601))) {
            return false;
        }
//        nh40602
        if (!validatorClass.EmptyRadioButton(this, binding.nh40602, binding.nh40602b, getString(R.string.nh40602))) {
            return false;
        }
//        nh40603
        if (!validatorClass.EmptyRadioButton(this, binding.nh40603, binding.nh40603b, getString(R.string.nh40603))) {
            return false;
        }
//        nh40604
        if (!validatorClass.EmptyRadioButton(this, binding.nh40604, binding.nh40604b, getString(R.string.nh40604))) {
            return false;
        }
//        nh40605
        if (!validatorClass.EmptyRadioButton(this, binding.nh40605, binding.nh40605b, getString(R.string.nh40605))) {
            return false;
        }
//        nh40696
        if (!validatorClass.EmptyRadioButton(this, binding.nh40696, binding.nh40696a, binding.nh40696x, getString(R.string.nh406) + " - " + getString(R.string.other))) {
            return false;
        }
//        nh501
        if (!validatorClass.EmptyRadioButton(this, binding.nh501, binding.nh501a, getString(R.string.nh501))) {
            return false;
        }
//        nh501
        if (!validatorClass.EmptyRadioButton(this, binding.nh501, binding.nh50196, binding.nh50196x, getString(R.string.nh501) + " - " + getString(R.string.other))) {
            return false;
        }
        if (!binding.nh501d.isChecked()) {


//        nh502
            if (!validatorClass.EmptyRadioButton(this, binding.nh502, binding.nh502c, getString(R.string.nh502))) {
                return false;
            }
//        nh503
            if (!validatorClass.EmptyRadioButton(this, binding.nh503, binding.nh503d, getString(R.string.nh503))) {
                return false;
            }
        }

//        nh601
        if (!validatorClass.EmptyRadioButton(this, binding.nh601, binding.nh60199, getString(R.string.nh601))) {
            return false;
        }
//        nh602
        if (!validatorClass.EmptyRadioButton(this, binding.nh602, binding.nh60299, getString(R.string.nh602))) {
            return false;
        }
//        nh603
        if (!validatorClass.EmptyRadioButton(this, binding.nh603, binding.nh60399, getString(R.string.nh603))) {
            return false;
        }
//        nh604
        if (!validatorClass.EmptyRadioButton(this, binding.nh604, binding.nh60499, getString(R.string.nh604))) {
            return false;
        }
//        nh605
        if (!validatorClass.EmptyRadioButton(this, binding.nh605, binding.nh60599, getString(R.string.nh605))) {
            return false;
        }
//        nh606
        if (!validatorClass.EmptyRadioButton(this, binding.nh606, binding.nh60699, getString(R.string.nh606))) {
            return false;
        }
//        nh607
        if (!validatorClass.EmptyRadioButton(this, binding.nh607, binding.nh60799, getString(R.string.nh607))) {
            return false;
        }
//        nh608
        if (!validatorClass.EmptyRadioButton(this, binding.nh608, binding.nh60899, getString(R.string.nh608))) {
            return false;
        }
//        nh609
        if (!validatorClass.EmptyRadioButton(this, binding.nh609, binding.nh60999, getString(R.string.nh609))) {
            return false;
        }
//        nh701
        if (!validatorClass.EmptyRadioButton(this, binding.nh701, binding.nh701b, getString(R.string.nh701))) {
            return false;
        }
//        nh702
        if (binding.nh701a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, binding.nh702, getString(R.string.nh702))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, binding.nh702, 1, MainApp.membersCount.getCount(), getString(R.string.nh702), "Recipient no")) {
                return false;
            }

        }

        return true;
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);

    }


    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sA5 = new JSONObject();

        sA5.put("nh401", binding.nh401a.isChecked() ? "1"
                : binding.nh401b.isChecked() ? "2"
                : binding.nh401c.isChecked() ? "3"
                : binding.nh401d.isChecked() ? "4"
                : "0");

        sA5.put("nh402", binding.nh402a.isChecked() ? "1"
                : binding.nh402b.isChecked() ? "2"
                : "0");

        sA5.put("nh403a", binding.nh403a.isChecked() ? "1" : "0");
        sA5.put("nh403b", binding.nh403b.isChecked() ? "2" : "0");
        sA5.put("nh403c", binding.nh403c.isChecked() ? "3" : "0");
        sA5.put("nh403d", binding.nh403d.isChecked() ? "4" : "0");
        sA5.put("nh403e", binding.nh403e.isChecked() ? "5" : "0");

        sA5.put("nh404", binding.nh404a.isChecked() ? "1"
                : binding.nh404b.isChecked() ? "2"
                : "0");

        sA5.put("nh405a", binding.nh405a.isChecked() ? "1" : "0");
        sA5.put("nh405b", binding.nh405b.isChecked() ? "2" : "0");
        sA5.put("nh405c", binding.nh405c.isChecked() ? "3" : "0");
        sA5.put("nh405d", binding.nh405d.isChecked() ? "4" : "0");
        sA5.put("nh405e", binding.nh405e.isChecked() ? "5" : "0");


        sA5.put("nh40601", binding.nh40601a.isChecked() ? "1"
                : binding.nh40601b.isChecked() ? "2"
                : "0");


        sA5.put("nh40602", binding.nh40602a.isChecked() ? "1"
                : binding.nh40602b.isChecked() ? "2"
                : "0");

        sA5.put("nh40603", binding.nh40603a.isChecked() ? "1"
                : binding.nh40603b.isChecked() ? "2"
                : "0");

        sA5.put("nh40604", binding.nh40604a.isChecked() ? "1"
                : binding.nh40604b.isChecked() ? "2"
                : "0");

        sA5.put("nh40605", binding.nh40605a.isChecked() ? "1"
                : binding.nh40605b.isChecked() ? "2"
                : "0");

        sA5.put("nh40696", binding.nh40696a.isChecked() ? "1"
                : binding.nh40696b.isChecked() ? "2"
                : "0");

        sA5.put("nh40696x", binding.nh40696x.getText().toString());



        // Section A6

        sA5.put("nh501", binding.nh501a.isChecked() ? "1"
                : binding.nh501b.isChecked() ? "2"
                : binding.nh501c.isChecked() ? "3"
                : binding.nh501d.isChecked() ? "4"
                : binding.nh50196.isChecked() ? "96"
                : "0");

        sA5.put("nh50196x", binding.nh50196x.getText().toString());

        sA5.put("nh502", binding.nh502a.isChecked() ? "1"
                : binding.nh502b.isChecked() ? "2"
                : binding.nh502c.isChecked() ? "3"
                : "0");

        sA5.put("nh503", binding.nh503a.isChecked() ? "1"
                : binding.nh503b.isChecked() ? "2"
                : binding.nh503c.isChecked() ? "3"
                : binding.nh503d.isChecked() ? "4"
                : "0");

        //Section A7

        sA5.put("nh601", binding.nh601a.isChecked() ? "1"
                : binding.nh601b.isChecked() ? "2"
                : binding.nh60198.isChecked() ? "98"
                : binding.nh60199.isChecked() ? "99"
                : "0");

        sA5.put("nh602", binding.nh602a.isChecked() ? "1"
                : binding.nh602b.isChecked() ? "2"
                : binding.nh60298.isChecked() ? "98"
                : binding.nh60299.isChecked() ? "99"
                : "0");

        sA5.put("nh603", binding.nh603a.isChecked() ? "1"
                : binding.nh603b.isChecked() ? "2"
                : binding.nh60398.isChecked() ? "98"
                : binding.nh60399.isChecked() ? "99"
                : "0");

        sA5.put("nh604", binding.nh604a.isChecked() ? "1"
                : binding.nh604b.isChecked() ? "2"
                : binding.nh60498.isChecked() ? "98"
                : binding.nh60499.isChecked() ? "99"
                : "0");

        sA5.put("nh605", binding.nh605a.isChecked() ? "1"
                : binding.nh605b.isChecked() ? "2"
                : binding.nh60598.isChecked() ? "98"
                : binding.nh60599.isChecked() ? "99"
                : "0");

        sA5.put("nh606", binding.nh606a.isChecked() ? "1"
                : binding.nh606b.isChecked() ? "2"
                : binding.nh60698.isChecked() ? "98"
                : binding.nh60699.isChecked() ? "99"
                : "0");

        sA5.put("nh607", binding.nh607a.isChecked() ? "1"
                : binding.nh607b.isChecked() ? "2"
                : binding.nh60798.isChecked() ? "98"
                : binding.nh60799.isChecked() ? "99"
                : "0");

        sA5.put("nh608", binding.nh608a.isChecked() ? "1"
                : binding.nh608b.isChecked() ? "2"
                : binding.nh60898.isChecked() ? "98"
                : binding.nh60899.isChecked() ? "99"
                : "0");

        sA5.put("nh609", binding.nh609a.isChecked() ? "1"
                : binding.nh609b.isChecked() ? "2"
                : binding.nh60998.isChecked() ? "98"
                : binding.nh60999.isChecked() ? "99"
                : "0");

        // Section A8

        sA5.put("nh701", binding.nh701a.isChecked() ? "1"
                : binding.nh701b.isChecked() ? "2"
                : "0");

        sA5.put("nh702", binding.nh702.getText().toString());

        if (binding.nh701a.isChecked()) {
            recipientCounter = Integer.valueOf(binding.nh702.getText().toString());
        }

        MainApp.fc.setsA5(String.valueOf(sA5));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSA5();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


}
