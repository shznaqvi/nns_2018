package edu.aku.hassannaqvi.nns_2018.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB2Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionB2Activity extends Activity {

    ActivitySectionB2Binding bi;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_b2);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b2);
        db = new DatabaseHelper(this);
        bi.setCallback(this);

        setupViews();
    }

    public void setupViews() {
        bi.nb201.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb201a.isChecked()) {
                    bi.fldGrpnb202.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnb202.setVisibility(View.GONE);
                    bi.nb202a.setChecked(false);
                    bi.nb202b.setChecked(false);
                    bi.nb202c.setChecked(false);
                    bi.nb202d.setChecked(false);
                    bi.nb202e.setChecked(false);
                    bi.nb202f.setChecked(false);
                    bi.nb202g.setChecked(false);
                    bi.nb202h.setChecked(false);
                    bi.nb20296.setChecked(false);
                    bi.nb20296x.setText(null);
                    bi.nb203m.setText(null);
                    bi.nb203w.setText(null);
                    bi.nb20398.setChecked(false);
                    bi.nb204.setText(null);
                    bi.nb20498.setChecked(false);
                    bi.nb205a.setChecked(false);
                    bi.nb205b.setChecked(false);
                    bi.nb205c.setChecked(false);
                    bi.nb205d.setChecked(false);
                    bi.nb205e.setChecked(false);
                    bi.nb205f.setChecked(false);
                    bi.nb205g.setChecked(false);
                    bi.nb205h.setChecked(false);
                    bi.nb20596.setChecked(false);
                    bi.nb20596x.setText(null);
                }
            }
        });

        bi.nb207.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb207a.isChecked()) {
                    bi.fldGrpnb208.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnb208.setVisibility(View.GONE);
                    bi.nb208.setText(null);
                    bi.nb20898.setChecked(false);
                }
            }
        });

        bi.nb209.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb209a.isChecked()) {
                    bi.fldGrpnb210.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnb210.setVisibility(View.GONE);
                    bi.nb21001.clearCheck();
                    bi.nb21002.clearCheck();
                    bi.nb21003.clearCheck();
                    bi.nb21098.clearCheck();
                    bi.nb21099.clearCheck();
                    bi.nb211.clearCheck();
                    bi.nb212m.setText(null);
                    bi.nb212d.setText(null);
                }
            }
        });

        bi.nb21098.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb21098a.isChecked()) {
                    bi.nb21001.setEnabled(false);
                    bi.nb21001.clearCheck();
                    bi.nb21002.setEnabled(false);
                    bi.nb21002.clearCheck();
                    bi.nb21003.setEnabled(false);
                    bi.nb21003.clearCheck();
                    bi.nb21099.setEnabled(false);
                    bi.nb21099.clearCheck();
                } else {
                    bi.nb21001.setEnabled(true);
                    bi.nb21002.setEnabled(true);
                    bi.nb21003.setEnabled(true);
                    bi.nb21099.setEnabled(true);

                }
            }
        });

        bi.nb21099.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb21099a.isChecked()) {
                    bi.nb21001.setEnabled(false);
                    bi.nb21001.clearCheck();
                    bi.nb21002.setEnabled(false);
                    bi.nb21002.clearCheck();
                    bi.nb21003.setEnabled(false);
                    bi.nb21003.clearCheck();
                    bi.nb21098.setEnabled(false);
                    bi.nb21098.clearCheck();
                } else {
                    bi.nb21001.setEnabled(true);
                    bi.nb21002.setEnabled(true);
                    bi.nb21003.setEnabled(true);
                    bi.nb21098.setEnabled(true);

                }
            }
        });

        bi.nb213.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb213a.isChecked()) {
                    bi.fldGrpnb214.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnb214.setVisibility(View.GONE);
                    bi.nb214.clearCheck();
                    bi.nb215m.setText(null);
                    bi.nb215d.setText(null);
                }
            }
        });

        bi.nb216.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb216a.isChecked()) {
                    bi.fldGrpnb217.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnb217.setVisibility(View.GONE);
                    bi.nb217.clearCheck();
                    bi.nb218d.setText(null);
                    bi.nb218m.setText(null);
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

        startActivity(new Intent(this, SectionB3Activity.class));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);

    }

    private boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyRadioButton(this, bi.nb201, bi.nb201a, getString(R.string.nb201))) {
            return false;
        }

        if (bi.nb201a.isChecked()) {
            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnb202check, bi.nb202a, getString(R.string.nb202))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnb202check, bi.nb20296, bi.nb20296x, getString(R.string.nb202) + " - " + getString(R.string.other))) {
                return false;
            }

            if (!bi.nb20398.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nb203w, getString(R.string.nb203) + " - " + getString(R.string.week))) {
                    return false;
                }

                if (!validatorClass.EmptyTextBox(this, bi.nb203m, getString(R.string.nb203) + " - " + getString(R.string.months))) {
                    return false;
                }

                if (bi.nb203w.getText().toString().equals("0") && bi.nb203m.getText().toString().equals("0")) {
                    Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nb203), Toast.LENGTH_LONG).show();
                    bi.nb203w.setError("All can not be zero");
                    bi.nb203w.setError("All can not be zero");
                    Log.i(SectionB2Activity.class.getSimpleName(), "nb203" + ": This data is Required!");
                } else {
                    bi.nb203w.setError(null);
                    bi.nb203m.setError(null);

                }

            }

            if (!bi.nb20498.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nb204, getString(R.string.nb204) + " - " + getString(R.string.times))) {
                    return false;
                }
            }

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnb205check, bi.nb205a, getString(R.string.nb205))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnb205check, bi.nb20596, bi.nb20596x, getString(R.string.nb205) + " - " + getString(R.string.other))) {
                return false;
            }

        }


        if (!validatorClass.EmptyRadioButton(this, bi.nb206, bi.nb206a, getString(R.string.nb206))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb207, bi.nb207a, getString(R.string.nb207))) {
            return false;
        }

        if (bi.nb207a.isChecked()) {
            if (!bi.nb20898.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nb208, getString(R.string.nb208) + " - " + getString(R.string.times))) {
                    return false;
                }
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb209, bi.nb209a, getString(R.string.nb209))) {
            return false;
        }

        if (bi.nb209a.isChecked()) {

            if (!bi.nb21098a.isChecked() || !bi.nb21099a.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.nb21001, bi.nb21001a, getString(R.string.nb21001))) {
                    return false;
                }

                if (!validatorClass.EmptyRadioButton(this, bi.nb21002, bi.nb21002a, getString(R.string.nb21002))) {
                    return false;
                }

                if (!validatorClass.EmptyRadioButton(this, bi.nb21003, bi.nb21003a, getString(R.string.nb21003))) {
                    return false;
                }
            }


            if (!validatorClass.EmptyRadioButton(this, bi.nb211, bi.nb211a, getString(R.string.nb211))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nb212m, getString(R.string.nb212) + " - " + getString(R.string.month))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nb212d, getString(R.string.nb212) + " - " + getString(R.string.day))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nb212m, 0, 11, getString(R.string.nb212), " months")) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nb212d, 0, 29, getString(R.string.nb212), " days")) {
                return false;
            }

            if (bi.nb212m.getText().toString().equals("0") && bi.nb212d.getText().toString().equals("0")) {
                Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nb212), Toast.LENGTH_LONG).show();
                bi.nb212m.setError("All can not be zero");
                bi.nb212d.setError("All can not be zero");
                Log.i(SectionB2Activity.class.getSimpleName(), "nb212" + ": This data is Required!");
            } else {
                bi.nb212m.setError(null);
                bi.nb212d.setError(null);

            }

        }


        if (!validatorClass.EmptyRadioButton(this, bi.nb213, bi.nb213a, getString(R.string.nb213))) {
            return false;
        }

        if (bi.nb213a.isChecked()) {


            if (!validatorClass.EmptyRadioButton(this, bi.nb214, bi.nb214a, getString(R.string.nb214))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nb215m, getString(R.string.nb215) + " - " + getString(R.string.month))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nb215d, getString(R.string.nb215) + " - " + getString(R.string.day))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nb215m, 0, 11, getString(R.string.nb215), " months")) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nb215d, 0, 29, getString(R.string.nb215), " days")) {
                return false;
            }

            if (bi.nb215m.getText().toString().equals("0") && bi.nb215d.getText().toString().equals("0")) {
                Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nb215), Toast.LENGTH_LONG).show();
                bi.nb215m.setError("All can not be zero");
                bi.nb215d.setError("All can not be zero");
                Log.i(SectionB2Activity.class.getSimpleName(), "nb215" + ": This data is Required!");
            } else {
                bi.nb215m.setError(null);
                bi.nb215d.setError(null);

            }

        }


        if (!validatorClass.EmptyRadioButton(this, bi.nb216, bi.nb216a, getString(R.string.nb216))) {
            return false;
        }

        if (bi.nb216a.isChecked()) {


            if (!validatorClass.EmptyRadioButton(this, bi.nb217, bi.nb217a, getString(R.string.nb217))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nb218m, getString(R.string.nb218) + " - " + getString(R.string.month))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nb218d, getString(R.string.nb218) + " - " + getString(R.string.day))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nb218m, 0, 11, getString(R.string.nb218), " months")) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nb218d, 0, 29, getString(R.string.nb218), " days")) {
                return false;
            }

            if (bi.nb218m.getText().toString().equals("0") && bi.nb218d.getText().toString().equals("0")) {
                Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nb218), Toast.LENGTH_LONG).show();
                bi.nb218m.setError("All can not be zero");
                bi.nb218d.setError("All can not be zero");
                Log.i(SectionB2Activity.class.getSimpleName(), "nb218" + ": This data is Required!");
            } else {
                bi.nb218m.setError(null);
                bi.nb218d.setError(null);

            }

        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb219, bi.nb219a, getString(R.string.nb219))) {
            return false;
        }

        return validatorClass.EmptyRadioButton(this, bi.nb220, bi.nb220a, getString(R.string.nb220));
    }


    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();
//       nb201
        JSONObject sB2 = new JSONObject();
        sB2.put("nb201", bi.nb201a.isChecked() ? "1"
                : bi.nb201b.isChecked() ? "2"
                : "0");

//       nb202
        sB2.put("nb202a", bi.nb202a.isChecked() ? "1" : "0");
        sB2.put("nb202b", bi.nb202b.isChecked() ? "2" : "0");
        sB2.put("nb202c", bi.nb202c.isChecked() ? "3" : "0");
        sB2.put("nb202d", bi.nb202d.isChecked() ? "4" : "0");
        sB2.put("nb202e", bi.nb202e.isChecked() ? "5" : "0");
        sB2.put("nb202f", bi.nb202f.isChecked() ? "6" : "0");
        sB2.put("nb202g", bi.nb202g.isChecked() ? "7" : "0");
        sB2.put("nb202h", bi.nb202h.isChecked() ? "8" : "0");
        sB2.put("nb202i", bi.nb20296.isChecked() ? "96" : "0");
        sB2.put("nb20296x", bi.nb20296x.getText().toString());


//        nb203
        sB2.put("nb203",bi.nb203w.getText().toString());
        sB2.put("nb203",bi.nb203w.getText().toString());
        sB2.put("nb20398", bi.nb20398.isChecked() ? "98" : "0");


        //        nb204
        sB2.put("nb204",bi.nb204.getText().toString());
        sB2.put("nb20498", bi.nb20498.isChecked() ? "98" : "0");

//      nb205
        sB2.put("nb205a", bi.nb205a.isChecked() ? "1" : "0");
        sB2.put("nb205b", bi.nb205b.isChecked() ? "2" : "0");
        sB2.put("nb205c", bi.nb205c.isChecked() ? "3" : "0");
        sB2.put("nb205d", bi.nb205d.isChecked() ? "4" : "0");
        sB2.put("nb205e", bi.nb205e.isChecked() ? "5" : "0");
        sB2.put("nb205f", bi.nb205f.isChecked() ? "6" : "0");
        sB2.put("nb205g", bi.nb205g.isChecked() ? "7" : "0");
        sB2.put("nb205h", bi.nb205h.isChecked() ? "8" : "0");
        sB2.put("nb205i", bi.nb20596.isChecked() ? "96" : "0");
        sB2.put("nb20596x", bi.nb20596x.getText().toString());

//        nb206
        sB2.put("nb206", bi.nb206a.isChecked() ? "1"
                : bi.nb206b.isChecked() ? "2"
                : bi.nb206c.isChecked() ? "3"
                : bi.nb20698.isChecked() ? "98"
                : "0");
//        nb207
        sB2.put("nb207", bi.nb207a.isChecked() ? "1"
                : bi.nb207b.isChecked() ? "2"
                : bi.nb20798.isChecked() ? "98"
                : "0");
//        nb208

        sB2.put("nb208",bi.nb208.getText().toString());
        sB2.put("nb20898", bi.nb20898.isChecked() ? "98" : "0");

//        nb209
        sB2.put("nb209", bi.nb209a.isChecked() ? "1"
                : bi.nb209b.isChecked() ? "2"
                : "0");
//        nb210
        sB2.put("nb21001", bi.nb21001a.isChecked() ? "1"
                : bi.nb21001b.isChecked() ? "2"
                : "0");
        sB2.put("nb21002", bi.nb21002a.isChecked() ? "1"
                : bi.nb21002b.isChecked() ? "2"
                : "0");
        sB2.put("nb21003", bi.nb21003a.isChecked() ? "1"
                : bi.nb21003b.isChecked() ? "2"
                : "0");
        sB2.put("nb21098", bi.nb21098a.isChecked() ? "1"
                : bi.nb21098b.isChecked() ? "2"
                : "0");
        sB2.put("nb21099", bi.nb21099a.isChecked() ? "1"
                : bi.nb21099b.isChecked() ? "2"
                : "0");

        //          nb211
        sB2.put("nb211", bi.nb211a.isChecked() ? "1"
                : bi.nb211b.isChecked() ? "2"
                : bi.nb211c.isChecked() ? "3"
                : bi.nb211d.isChecked() ? "4"
                : bi.nb211e.isChecked() ? "5"
                : "0");

//         nb212
        sB2.put("nb212m",bi.nb212m.getText().toString());
        sB2.put("nb212d",bi.nb212d.getText().toString());

        //        nb213
        sB2.put("nb213", bi.nb213a.isChecked() ? "1"
                : bi.nb213b.isChecked() ? "2"
                : "0");

//        nb214
        sB2.put("nb214", bi.nb214a.isChecked() ? "1"
                : bi.nb214b.isChecked() ? "2"
                : bi.nb214b.isChecked() ? "3"
                : bi.nb214b.isChecked() ? "4"
                : bi.nb214b.isChecked() ? "5"
                : "0");

//        nb215
        sB2.put("nb215m",bi.nb215m.getText().toString());
        sB2.put("nb215d",bi.nb215d.getText().toString());

//        nb216
        sB2.put("nb216", bi.nb216a.isChecked() ? "1"
                : bi.nb216b.isChecked() ? "2"
                : "0");
//        nb217
        sB2.put("nb217", bi.nb217a.isChecked() ? "1"
                : bi.nb217b.isChecked() ? "2"
                : bi.nb217c.isChecked() ? "3"
                : bi.nb217d.isChecked() ? "4"
                : bi.nb217e.isChecked() ? "5"
                : "0");

//        nb218
        sB2.put("nb218m",bi.nb218m.getText().toString());
        sB2.put("nb218d",bi.nb218d.getText().toString());

//        nb219
        sB2.put("nb219", bi.nb219a.isChecked() ? "1"
                : bi.nb219b.isChecked() ? "2"
                : "0");
//        nb220
        sB2.put("nb220", bi.nb220a.isChecked() ? "1"
                : bi.nb220b.isChecked() ? "2"
                : bi.nb22098.isChecked() ? "98"
                : "0");

        MainApp.mc.setsB2(String.valueOf(sB2));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSB2();

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
