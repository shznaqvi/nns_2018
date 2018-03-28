package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB5Binding;
import edu.aku.hassannaqvi.nns_2018.validation.clearClass;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionB5Activity extends AppCompatActivity {

    private final long DELAY = 1000;
    ActivitySectionB5Binding binding;
    DatabaseHelper db;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_b5);
        db = new DatabaseHelper(this);

//        Assigning data to UI binding
        binding.setCallback(this);

//        Skip patterns

        binding.nw414.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nw414b) {
                    /*binding.nw415a.setChecked(false);
                    binding.nw415b.setChecked(false);
                    binding.nw415c.setChecked(false);
                    binding.nw415d.setChecked(false);
                    binding.nw415e.setChecked(false);
                    binding.nw415f.setChecked(false);
                    binding.nw415g.setChecked(false);
                    binding.nw41596.setChecked(false);

                    binding.nw416.clearCheck();
                    binding.nw417.setText(null);

                    binding.nw418a.setChecked(false);
                    binding.nw418b.setChecked(false);
                    binding.nw418c.setChecked(false);
                    binding.nw418d.setChecked(false);
                    binding.nw418e.setChecked(false);
                    binding.nw418f.setChecked(false);
                    binding.nw418g.setChecked(false);
                    binding.nw418h.setChecked(false);
                    binding.nw41896.setChecked(false);*/

                    clearClass.ClearAllFields(binding.fldGrpnw415, false);

                } else {
                    clearClass.ClearAllFields(binding.fldGrpnw415, true);
                }
            }
        });

        binding.nw419.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nw419b) {
                    /*binding.nw420a.setChecked(false);
                    binding.nw420b.setChecked(false);
                    binding.nw420c.setChecked(false);
                    binding.nw420d.setChecked(false);
                    binding.nw420e.setChecked(false);
                    binding.nw420f.setChecked(false);
                    binding.nw420g.setChecked(false);
                    binding.nw42096.setChecked(false);

                    binding.nw421.clearCheck();
                    binding.nw422.setText(null);

                    binding.nw423a.setChecked(false);
                    binding.nw423b.setChecked(false);
                    binding.nw423c.setChecked(false);
                    binding.nw423d.setChecked(false);
                    binding.nw423e.setChecked(false);
                    binding.nw42396.setChecked(false);*/

                    clearClass.ClearAllFields(binding.fldGrpnw420, false);
                } else {
                    clearClass.ClearAllFields(binding.fldGrpnw420, true);
                }
            }
        });

    }

    public void BtnContinue() {

        //Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                //Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();
                MainApp.nuCount = 1;

//                finish();

                if (SectionB1Activity.WRAcounter == MainApp.mwra.size()
                        &&
                        MainApp.B6Flag) {
                    startActivity(new Intent(this, SectionB6Activity.class));
                } else if (MainApp.B2B6Flag) {
                    startActivity(new Intent(this, SectionB6Activity.class));
                } else {
                    startActivity(new Intent(this, MotherEndingActivity.class)
                            .putExtra("complete", true));
                }

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

        //startActivity(new Intent(this, SectionB6Activity.class));
    }

    public void BtnEnd() {

        MainApp.endActivityMother(this, this, false);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }


    private boolean ValidateForm() {

        //Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyRadioButton(this, binding.nw414, binding.nw414a, getString(R.string.nw414))) {
            return false;
        }

        if (binding.nw414a.isChecked()) {
            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnw415check, binding.nw415a, getString(R.string.nw415))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnw415check, binding.nw41596, binding.nw41596x, getString(R.string.nw415) + " - " + getString(R.string.other))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, binding.nw416, binding.nw416a, getString(R.string.nw416))) {
                return false;
            }

            if (binding.nw416a.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, binding.nw416hr, getString(R.string.nw416a))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, binding.nw416hr, 1, 23, getString(R.string.nw416a), " hours")) {
                    return false;
                }


            }


            if (binding.nw416b.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, binding.nw416d, getString(R.string.nw416b))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, binding.nw416d, 1, 29, getString(R.string.nw416b), " days")) {
                    return false;
                }

            }

            if (binding.nw416c.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, binding.nw416w, getString(R.string.nw416c))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, binding.nw416w, 1, 29, getString(R.string.nw416c), " weeks")) {
                    return false;
                }

            }


            if (!validatorClass.EmptyTextBox(this, binding.nw417, getString(R.string.nw417))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, binding.nw417, 1, 12, getString(R.string.nw417), " times")) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnw418check, binding.nw418a, getString(R.string.nw418))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnw418check, binding.nw41896, binding.nw41896x, getString(R.string.nw418) + " - " + getString(R.string.other))) {
                return false;
            }

        }


        if (!validatorClass.EmptyRadioButton(this, binding.nw419, binding.nw419a, getString(R.string.nw419))) {
            return false;
        }


        if (binding.nw419a.isChecked()) {

            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnw420check, binding.nw420a, getString(R.string.nw420))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnw420check, binding.nw42096, binding.nw42096x, getString(R.string.nw418) + " - " + getString(R.string.other))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, binding.nw421, binding.nw421a, getString(R.string.nw421))) {
                return false;
            }

            if (binding.nw421a.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, binding.nw421hr, getString(R.string.nw421a))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, binding.nw421hr, 1, 23, getString(R.string.nw421a), " hours")) {
                    return false;
                }


            }


            if (binding.nw421b.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, binding.nw421d, getString(R.string.nw421b))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, binding.nw421d, 1, 29, getString(R.string.nw421b), " days")) {
                    return false;
                }

            }

            if (binding.nw421c.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, binding.nw421w, getString(R.string.nw421c))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, binding.nw421w, 1, 29, getString(R.string.nw421c), " weeks")) {
                    return false;
                }

            }


            if (!validatorClass.EmptyTextBox(this, binding.nw422, getString(R.string.nw422))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, binding.nw422, 1, 12, getString(R.string.nw422), " times")) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnw423check, binding.nw423a, getString(R.string.nw423))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnw423check, binding.nw42396, binding.nw42396x, getString(R.string.nw423) + " - " + getString(R.string.other))) {
                return false;
            }


        }

        return true;
    }

    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sB5 = new JSONObject();
        //       nw414
//        nw414
        sB5.put("nw414", binding.nw414a.isChecked() ? "1"
                : binding.nw414b.isChecked() ? "2"
                : "0");
//      nw415
        sB5.put("nw415a", binding.nw415a.isChecked() ? "1" : "0");
        sB5.put("nw415b", binding.nw415b.isChecked() ? "2" : "0");
        sB5.put("nw415c", binding.nw415c.isChecked() ? "3" : "0");
        sB5.put("nw415d", binding.nw415d.isChecked() ? "4" : "0");
        sB5.put("nw415e", binding.nw415e.isChecked() ? "5" : "0");
        sB5.put("nw415f", binding.nw415f.isChecked() ? "6" : "0");
        sB5.put("nw415g", binding.nw415g.isChecked() ? "7" : "0");
        sB5.put("nw41596", binding.nw41596.isChecked() ? "96" : "0");
        sB5.put("nw41596x", binding.nw41596x.getText().toString());

//      nw416
        sB5.put("nw416", binding.nw416a.isChecked() ? "1"
                : binding.nw416b.isChecked() ? "2"
                : binding.nw416c.isChecked() ? "3"
                : binding.nw41698.isChecked() ? "98"
                : "0");
        sB5.put("nw416hr", binding.nw416hr.getText().toString());
        sB5.put("nw416d", binding.nw416d.getText().toString());
        sB5.put("nw416w", binding.nw416w.getText().toString());

//        nw417
        sB5.put("nw417", binding.nw417.getText().toString());

//        nw418
        sB5.put("nw418a", binding.nw418a.isChecked() ? "1" : "0");
        sB5.put("nw418b", binding.nw418b.isChecked() ? "2" : "0");
        sB5.put("nw418c", binding.nw418c.isChecked() ? "3" : "0");
        sB5.put("nw418d", binding.nw418d.isChecked() ? "4" : "0");
        sB5.put("nw418e", binding.nw418e.isChecked() ? "5" : "0");
        sB5.put("nw418f", binding.nw418f.isChecked() ? "6" : "0");
        sB5.put("nw418g", binding.nw418g.isChecked() ? "7" : "0");
        sB5.put("nw418h", binding.nw418h.isChecked() ? "8" : "0");
        sB5.put("nw41896", binding.nw41896.isChecked() ? "96" : "0");
        sB5.put("nw41896x", binding.nw41896x.getText().toString());

//        nw419
        sB5.put("nw419", binding.nw419a.isChecked() ? "1"
                : binding.nw419b.isChecked() ? "2"
                : "0");
//        nw420
        sB5.put("nw420a", binding.nw420a.isChecked() ? "1" : "0");
        sB5.put("nw420b", binding.nw420b.isChecked() ? "2" : "0");
        sB5.put("nw420c", binding.nw420c.isChecked() ? "3" : "0");
        sB5.put("nw420d", binding.nw420d.isChecked() ? "4" : "0");
        sB5.put("nw420e", binding.nw420e.isChecked() ? "5" : "0");
        sB5.put("nw420f", binding.nw420f.isChecked() ? "6" : "0");
        sB5.put("nw420g", binding.nw420g.isChecked() ? "7" : "0");
        sB5.put("nw42096", binding.nw42096.isChecked() ? "96" : "0");
        sB5.put("nw42096x", binding.nw42096x.getText().toString());


//        nw421
        sB5.put("nw421", binding.nw421a.isChecked() ? "1"
                : binding.nw421b.isChecked() ? "2"
                : binding.nw421c.isChecked() ? "3"
                : binding.nw42198.isChecked() ? "98"
                : "0");
        sB5.put("nw421hr", binding.nw421hr.getText().toString());
        sB5.put("nw421d", binding.nw421d.getText().toString());
        sB5.put("nw421w", binding.nw421w.getText().toString());

//        nw422
        sB5.put("nw422", binding.nw422.getText().toString());

//        nw423
        sB5.put("nw423a", binding.nw423a.isChecked() ? "1" : "0");
        sB5.put("nw423b", binding.nw423b.isChecked() ? "2" : "0");
        sB5.put("nw423c", binding.nw423c.isChecked() ? "3" : "0");
        sB5.put("nw423d", binding.nw423d.isChecked() ? "4" : "0");
        sB5.put("nw423e", binding.nw423e.isChecked() ? "5" : "0");
        sB5.put("nw42396", binding.nw42396.isChecked() ? "96" : "0");
        sB5.put("nw42396x", binding.nw42396x.getText().toString());


        MainApp.mc.setsB5(String.valueOf(sB5));


        //Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSB5();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

        //return true;

    }

}
