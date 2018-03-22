package edu.aku.hassannaqvi.nns_2018.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
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
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB4Binding;
import edu.aku.hassannaqvi.nns_2018.validation.clearClass;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionB4Activity extends Activity implements TextWatcher, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    private final long DELAY = 1000;
    ActivitySectionB4Binding binding;
    DatabaseHelper db;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_b4);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_b4);
        db = new DatabaseHelper(this);
        binding.setCallback(this);

        binding.nw40299.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                formValidation();
                if (isChecked) {
                    binding.nw402a.setChecked(false);
                    binding.nw402b.setChecked(false);
                    binding.nw402c.setChecked(false);
                    binding.nw402d.setChecked(false);
                    binding.nw402e.setChecked(false);
                    binding.nw402f.setChecked(false);
                    binding.nw402g.setChecked(false);
                    binding.nw402h.setChecked(false);
                    binding.nw40296.setChecked(false);

                    binding.nw402a.setEnabled(false);
                    binding.nw402b.setEnabled(false);
                    binding.nw402c.setEnabled(false);
                    binding.nw402d.setEnabled(false);
                    binding.nw402e.setEnabled(false);
                    binding.nw402f.setEnabled(false);
                    binding.nw402g.setEnabled(false);
                    binding.nw402h.setEnabled(false);
                    binding.nw40296.setEnabled(false);
                } else {
                    binding.nw402a.setEnabled(true);
                    binding.nw402b.setEnabled(true);
                    binding.nw402c.setEnabled(true);
                    binding.nw402d.setEnabled(true);
                    binding.nw402e.setEnabled(true);
                    binding.nw402f.setEnabled(true);
                    binding.nw402g.setEnabled(true);
                    binding.nw402h.setEnabled(true);
                    binding.nw40296.setEnabled(true);
                }
            }
        });
        binding.nw405.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                formValidation();
                if (checkedId == R.id.nw405b || checkedId == R.id.nw40598) {
                    /*binding.fldGrpnw406.setVisibility(View.GONE);
                    binding.nw406c.setText(null);
                    binding.nw406r.setText(null);
                    binding.nw40698.setChecked(false);*/

                    clearClass.ClearAllFields(binding.fldGrpnw406, false);

                } else {
//                    binding.fldGrpnw406.setVisibility(View.VISIBLE);

                    clearClass.ClearAllFields(binding.fldGrpnw406, true);
                }
            }
        });
        binding.nb411.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                formValidation();
                if (checkedId == R.id.nb411b || checkedId == R.id.nb41198) {
                    /*binding.fldGrpnb412.setVisibility(View.GONE);
                    binding.nb412a.setChecked(false);
                    binding.nb412b.setChecked(false);
                    binding.nb412c.setChecked(false);
                    binding.nb412d.setChecked(false);
                    binding.nb412e.setChecked(false);
                    binding.nb41296.setChecked(false);
                    binding.nb41298.setChecked(false);

                    binding.nb41296x.setText(null);

                    binding.nw413.clearCheck();
                    binding.nw413961x.setText(null);
                    binding.nw413962x.setText(null);
                    binding.nw413963x.setText(null);*/

                    clearClass.ClearAllFields(binding.fldGrpnb412, false);

                } else {
//                    binding.fldGrpnb412.setVisibility(View.VISIBLE);
                    clearClass.ClearAllFields(binding.fldGrpnb412, true);
                }
            }
        });
        binding.nb41298.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                formValidation();
                if (isChecked) {
                    binding.nb412a.setEnabled(false);
                    binding.nb412b.setEnabled(false);
                    binding.nb412c.setEnabled(false);
                    binding.nb412d.setEnabled(false);
                    binding.nb412e.setEnabled(false);
                    binding.nb41296.setEnabled(false)
                    ;

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

//        Listener
        binding.nw401.setOnCheckedChangeListener(this);
        binding.nw403.setOnCheckedChangeListener(this);
        binding.nw404.setOnCheckedChangeListener(this);
        binding.nw406c.addTextChangedListener(this);
        binding.nw406r.addTextChangedListener(this);
        binding.nw407.setOnCheckedChangeListener(this);
        binding.nw408.setOnCheckedChangeListener(this);
        binding.nw409.setOnCheckedChangeListener(this);
        binding.nb410.setOnCheckedChangeListener(this);
        binding.nw413.setOnCheckedChangeListener(this);

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

                startActivity(new Intent(this, SectionB5Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

        //startActivity(new Intent(this, SectionB5Activity.class));
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

        if (!validatorClass.EmptyRadioButton(this, binding.nw401, binding.nw40196, binding.nw40196x, getString(R.string.nw401))) {
            return false;
        }

        // nw402
        if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnw402check, binding.nw40296, binding.nw40296x, getString(R.string.nw402))) {
            return false;
        }
        // nw403
        if (!validatorClass.EmptyRadioButton(this, binding.nw403, binding.nw403a, getString(R.string.nw403))) {
            return false;
        } // nw403
        if (!validatorClass.EmptyRadioButton(this, binding.nw403, binding.nw403f, binding.nw403fx, getString(R.string.nw403) + " " + getString(R.string.nw403f))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.nw403, binding.nw403j, binding.nw403jx, getString(R.string.nw403) + " " + getString(R.string.nw403j))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.nw403, binding.nw40396, binding.nw40396x, getString(R.string.nw403) + " " + getString(R.string.other))) {
            return false;
        }
        // nw404
        if (!validatorClass.EmptyRadioButton(this, binding.nw404, binding.nw40498, getString(R.string.nw404))) {
            return false;
        }
        // nw405
        if (!validatorClass.EmptyRadioButton(this, binding.nw405, binding.nw40598, getString(R.string.nw405))) {
            return false;
        }

        if (!binding.nw405b.isChecked()) {
            // nw406

            if (!binding.nw40698.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, binding.nw406c, getString(R.string.nw406) + " - " + getString(R.string.nw406c))) {
                    return false;
                }

                if (!validatorClass.EmptyTextBox(this, binding.nw406r, getString(R.string.nw406) + " - " + getString(R.string.nw406r))) {
                    return false;
                }

            }

        }

        // nw407
        if (!validatorClass.EmptyRadioButton(this, binding.nw407, binding.nw40798, getString(R.string.nw407))) {
            return false;
        }
        // nw408
        if (!validatorClass.EmptyRadioButton(this, binding.nw408, binding.nw40898, getString(R.string.nw408))) {
            return false;
        }
        // nw409
        if (!validatorClass.EmptyRadioButton(this, binding.nw409, binding.nw40998, getString(R.string.nw409))) {
            return false;
        }
        // nb410
        if (!validatorClass.EmptyRadioButton(this, binding.nb410, binding.nb41098, getString(R.string.nb410))) {
            return false;
        }


        if (binding.nb410b.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, binding.nb410h, getString(R.string.nb410) + " - " + getString(R.string.nb410h))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, binding.nb410h, 1, 24, getString(R.string.nb410), " hours")) {
                return false;
            }
        }

        if (binding.nb410c.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, binding.nb410d, getString(R.string.nb410) + " - " + getString(R.string.nb410d))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, binding.nb410d, 1, 30, getString(R.string.nb410), " days")) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, binding.nb411, binding.nb41198, getString(R.string.nb411))) {
            return false;
        }

        if (binding.nb411a.isChecked()) {
            // nb412
            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb412check, binding.nb41296, binding.nb41296x, String.valueOf(R.string.nb412))) {
                return false;
            }
            // nw413
            if (!validatorClass.EmptyRadioButton(this, binding.nw413, binding.nw413a, getString(R.string.nc403))) {
                return false;
            }
//        nw4139601
            if (!validatorClass.EmptyRadioButton(this, binding.nw413, binding.nw413961, binding.nw413961x, getString(R.string.nw413) + " - " + getString(R.string.nw413961))) {
                return false;
            }
//        nw4139602
            if (!validatorClass.EmptyRadioButton(this, binding.nw413, binding.nw413962, binding.nw413962x, getString(R.string.nw413) + " - " + getString(R.string.nw413962))) {
                return false;
            }
//        nw4139603
            if (!validatorClass.EmptyRadioButton(this, binding.nw413, binding.nw413963, binding.nw413963x, getString(R.string.nw413) + " - " + getString(R.string.other))) {
                return false;
            }

        }
        return true;
    }


    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sB4 = new JSONObject();
        //       nw401
        sB4.put("nw401", binding.nw401a.isChecked() ? "1"
                : binding.nw401b.isChecked() ? "2"
                : binding.nw401c.isChecked() ? "3"
                : binding.nw401d.isChecked() ? "4"
                : binding.nw401e.isChecked() ? "5"
                : binding.nw401f.isChecked() ? "6"
                : binding.nw401g.isChecked() ? "7"
                : binding.nw401h.isChecked() ? "8"
                : binding.nw40196.isChecked() ? "96"
                : binding.nw40199.isChecked() ? "99"
                : "0");
        sB4.put("nw40196x", binding.nw40196x.getText().toString());

//        nw402
        sB4.put("nw402a", binding.nw402a.isChecked() ? "1" : "0");
        sB4.put("nw402b", binding.nw402b.isChecked() ? "2" : "0");
        sB4.put("nw402c", binding.nw402c.isChecked() ? "3" : "0");
        sB4.put("nw402d", binding.nw402d.isChecked() ? "4" : "0");
        sB4.put("nw402e", binding.nw402e.isChecked() ? "5" : "0");
        sB4.put("nw402f", binding.nw402f.isChecked() ? "6" : "0");
        sB4.put("nw402g", binding.nw402g.isChecked() ? "7" : "0");
        sB4.put("nw402h", binding.nw402h.isChecked() ? "8" : "0");
        sB4.put("nw40299", binding.nw40299.isChecked() ? "99" : "0");
        sB4.put("nw40296", binding.nw40296.isChecked() ? "96" : "0");
        sB4.put("nw40296x", binding.nw40296x.getText().toString());

//       nw403
        sB4.put("nw403", binding.nw403a.isChecked() ? "1"
                : binding.nw403b.isChecked() ? "2"
                : binding.nw403c.isChecked() ? "3"
                : binding.nw403d.isChecked() ? "4"
                : binding.nw403e.isChecked() ? "5"
                : binding.nw403f.isChecked() ? "6"
                : binding.nw403g.isChecked() ? "7"
                : binding.nw403h.isChecked() ? "8"
                : binding.nw403i.isChecked() ? "9"
                : binding.nw403j.isChecked() ? "10"
                : binding.nw40396.isChecked() ? "96"
                : "0");
        sB4.put("nw403fx", binding.nw403fx.getText().toString());
        sB4.put("nw403jx", binding.nw403jx.getText().toString());
        sB4.put("nw40396x", binding.nw40396x.getText().toString());

//        nw404
        sB4.put("nw404", binding.nw404a.isChecked() ? "1"
                : binding.nw404b.isChecked() ? "2"
                : binding.nw404c.isChecked() ? "3"
                : binding.nw404d.isChecked() ? "4"
                : binding.nw404e.isChecked() ? "5"
                : binding.nw40498.isChecked() ? "98"
                : "0");
//        nw405
        sB4.put("nw405", binding.nw405a.isChecked() ? "1"
                : binding.nw405b.isChecked() ? "2"
                : binding.nw40598.isChecked() ? "98"
                : "0");
//        nw406
        sB4.put("nw406c", binding.nw406c.getText().toString());
        sB4.put("nw406r", binding.nw406r.getText().toString());

        sB4.put("nw40698", binding.nw40698.isChecked() ? "1" : "0");

//        nw407
        sB4.put("nw407", binding.nw407a.isChecked() ? "1"
                : binding.nw407b.isChecked() ? "2"
                : binding.nw40798.isChecked() ? "98"
                : "0");

//        nw408
        sB4.put("nw408", binding.nw408a.isChecked() ? "1"
                : binding.nw408b.isChecked() ? "2"
                : binding.nw40898.isChecked() ? "98"
                : "0");

//        nw409
        sB4.put("nw409", binding.nw409a.isChecked() ? "1"
                : binding.nw409b.isChecked() ? "2"
                : binding.nw40998.isChecked() ? "98"
                : "0");


//        nb410
        sB4.put("nw410h", binding.nb410h.getText().toString());
        sB4.put("nw410d", binding.nb410d.getText().toString());
        sB4.put("nw410", binding.nb410a.isChecked() ? "1"
                : binding.nb410b.isChecked() ? "2"
                : binding.nb41097.isChecked() ? "97"
                : binding.nb41098.isChecked() ? "98"
                : "0");

//        nb411
        sB4.put("nw411", binding.nb411a.isChecked() ? "1"
                : binding.nb411b.isChecked() ? "2"
                : binding.nb41198.isChecked() ? "98"
                : "0");

//      nb412
        sB4.put("nw412a", binding.nb412a.isChecked() ? "1" : "0");
        sB4.put("nw412b", binding.nb412b.isChecked() ? "2" : "0");
        sB4.put("nw412c", binding.nb412c.isChecked() ? "3" : "0");
        sB4.put("nw412d", binding.nb412d.isChecked() ? "4" : "0");
        sB4.put("nw412e", binding.nb412e.isChecked() ? "5" : "0");
        sB4.put("nw412f", binding.nb412e.isChecked() ? "6" : "0");
        sB4.put("nw41298", binding.nb41298.isChecked() ? "98" : "0");
        sB4.put("nw41296", binding.nb41298.isChecked() ? "96" : "0");

        sB4.put("nw41296x", binding.nb41296x.getText().toString());


        //        nb413
        sB4.put("nw413", binding.nw413a.isChecked() ? "1"
                : binding.nw413b.isChecked() ? "2"
                : binding.nw413c.isChecked() ? "3"
                : binding.nw413d.isChecked() ? "4"
                : binding.nw413e.isChecked() ? "5"
                : binding.nw413f.isChecked() ? "6"
                : binding.nw413g.isChecked() ? "7"
                : binding.nw413h.isChecked() ? "8"
                : binding.nw413i.isChecked() ? "9"
                : binding.nw413j.isChecked() ? "10"
                : binding.nw413k.isChecked() ? "11"
                : binding.nw413l.isChecked() ? "12"
                : binding.nw413m.isChecked() ? "13"
                : binding.nw413961.isChecked() ? "961"
                : binding.nw413962.isChecked() ? "962"
                : binding.nw413963.isChecked() ? "963"
                : "0");


        MainApp.mc.setsB4(String.valueOf(sB4));


        //Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSB4();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
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
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        formValidation();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        formValidation();
    }
}
