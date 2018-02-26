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
        bi.nw301.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nw301a.isChecked()) {
                    bi.fldGrpnw302.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnw302.setVisibility(View.GONE);
                    bi.nw302a.setChecked(false);
                    bi.nw302b.setChecked(false);
                    bi.nw302c.setChecked(false);
                    bi.nw302d.setChecked(false);
                    bi.nw302e.setChecked(false);
                    bi.nw302f.setChecked(false);
                    bi.nw302g.setChecked(false);
                    bi.nw302h.setChecked(false);
                    bi.nw30296.setChecked(false);
                    bi.nw30296x.setText(null);
                    bi.nw303m.setText(null);
                    bi.nw303w.setText(null);
                    bi.nw30398.setChecked(false);
                    bi.nw304.setText(null);
                    bi.nw30498.setChecked(false);
                    bi.nw305a.setChecked(false);
                    bi.nw305b.setChecked(false);
                    bi.nw305c.setChecked(false);
                    bi.nw305d.setChecked(false);
                    bi.nw305e.setChecked(false);
                    bi.nw305f.setChecked(false);
                    bi.nw305g.setChecked(false);
                    bi.nw305h.setChecked(false);
                    bi.nw30596.setChecked(false);
                    bi.nw30596x.setText(null);
                }
            }
        });

        bi.nw307.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nw307a.isChecked()) {
                    bi.fldGrpnw308.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnw308.setVisibility(View.GONE);
                    bi.nw308.setText(null);
                    bi.nw30898.setChecked(false);
                }
            }
        });

        bi.nw309.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nw309a.isChecked()) {
                    bi.fldGrpnb210.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnb210.setVisibility(View.GONE);
//                    bi.nb21001.clearCheck();
//                    bi.nb21002.clearCheck();
//                    bi.nb21003.clearCheck();
//                    bi.nb21098.clearCheck();
//                    bi.nb21099.clearCheck();
                    bi.nw312.clearCheck();
                    bi.nw313m.setText(null);
                    bi.nw313d.setText(null);
                }
            }
        });

//        bi.nb21098.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if (bi.nb21098a.isChecked()) {
//                    bi.nb21001.setEnabled(false);
//                    bi.nb21001.clearCheck();
//                    bi.nb21002.setEnabled(false);
//                    bi.nb21002.clearCheck();
//                    bi.nb21003.setEnabled(false);
//                    bi.nb21003.clearCheck();
//                    bi.nb21099.setEnabled(false);
//                    bi.nb21099.clearCheck();
//                } else {
//                    bi.nb21001.setEnabled(true);
//                    bi.nb21002.setEnabled(true);
//                    bi.nb21003.setEnabled(true);
//                    bi.nb21099.setEnabled(true);
//
//                }
//            }
//        });
//
//        bi.nb21099.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if (bi.nb21099a.isChecked()) {
//                    bi.nb21001.setEnabled(false);
//                    bi.nb21001.clearCheck();
//                    bi.nb21002.setEnabled(false);
//                    bi.nb21002.clearCheck();
//                    bi.nb21003.setEnabled(false);
//                    bi.nb21003.clearCheck();
//                    bi.nb21098.setEnabled(false);
//                    bi.nb21098.clearCheck();
//                } else {
//                    bi.nb21001.setEnabled(true);
//                    bi.nb21002.setEnabled(true);
//                    bi.nb21003.setEnabled(true);
//                    bi.nb21098.setEnabled(true);
//
//                }
//            }
//        });

        bi.nw314.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nw314a.isChecked()) {
                    bi.fldGrpnw317.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnw317.setVisibility(View.GONE);

                    bi.nw315.clearCheck();
                    bi.nw31596x.setText(null);

                    bi.nw316.clearCheck();
                    bi.nw316961x.setText(null);
                    bi.nw316962x.setText(null);
                    bi.nw316963x.setText(null);

                    bi.nw317.clearCheck();

                    bi.nw318m.setText(null);
                    bi.nw318d.setText(null);
                }
            }
        });


        bi.nw319.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nw319a.isChecked()) {

                    bi.fldGrpnw322.setVisibility(View.VISIBLE);

                } else {

                    bi.fldGrpnw322.setVisibility(View.GONE);

                    bi.nw320.clearCheck();
                    bi.nw32096x.setText(null);

                    bi.nw321.clearCheck();
                    bi.nw321961x.setText(null);
                    bi.nw321962x.setText(null);
                    bi.nw321963x.setText(null);

                    bi.nw322.clearCheck();

                    bi.nw323d.setText(null);
                    bi.nw323m.setText(null);
                }
            }
        });


        bi.nw317.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

            }
        });


    }

    public void BtnContinue() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, SectionB3Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

        //startActivity(new Intent(this, SectionB3Activity.class));
    }

    public void BtnEnd() {
        MainApp.endActivityMotherChild(this, this, true, false);

    }

    private boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyRadioButton(this, bi.nw301, bi.nw301a, getString(R.string.nw301))) {
            return false;
        }

        if (bi.nw301a.isChecked()) {
            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnw302check, bi.nw302a, getString(R.string.nw302))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnw302check, bi.nw30296, bi.nw30296x, getString(R.string.nw302) + " - " + getString(R.string.other))) {
                return false;
            }

            if (!bi.nw30398.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nw303w, getString(R.string.nw303) + " - " + getString(R.string.week))) {
                    return false;
                }

                if (bi.nw303m.getText().toString().equals("0")) {
                    if (!validatorClass.RangeTextBox(this, bi.nw303w, 2, 44, getString(R.string.nw203), " weeks")) {
                        return false;
                    }
                } else {
                    if (!validatorClass.RangeTextBox(this, bi.nw303w, 0, 44, getString(R.string.nw203), " weeks")) {
                        return false;
                    }
                }

                if (!validatorClass.EmptyTextBox(this, bi.nw303m, getString(R.string.nw303) + " - " + getString(R.string.months))) {
                    return false;
                }

                if (bi.nw303w.getText().toString().equals("0")) {
                    if (!validatorClass.RangeTextBox(this, bi.nw303m, 1, 9, getString(R.string.nw203), " months")) {
                        return false;
                    }
                } else {
                    if (!validatorClass.RangeTextBox(this, bi.nw303m, 0, 9, getString(R.string.nw203), " months")) {
                        return false;
                    }
                }

                if (bi.nw303w.getText().toString().equals("0") && bi.nw303m.getText().toString().equals("0")) {
                    Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nw303), Toast.LENGTH_LONG).show();
                    bi.nw303w.setError("All can not be zero");
                    bi.nw303w.setError("All can not be zero");
                    Log.i(SectionB2Activity.class.getSimpleName(), "nw303" + ": This data is Required!");
                    return false;
                } else {
                    bi.nw303w.setError(null);
                    bi.nw303m.setError(null);

                }

            }

            if (!bi.nw30498.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nw304, getString(R.string.nw304) + " - " + getString(R.string.times))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, bi.nw304, 1, 9, getString(R.string.nw203), " times")) {
                    return false;
                }

            }

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnw305check, bi.nw305a, getString(R.string.nw305))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnw305check, bi.nw30596, bi.nw30596x, getString(R.string.nw305) + " - " + getString(R.string.other))) {
                return false;
            }

        }


        if (!validatorClass.EmptyRadioButton(this, bi.nw306, bi.nw306a, getString(R.string.nw306))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nw307, bi.nw307a, getString(R.string.nw307))) {
            return false;
        }

        if (bi.nw307a.isChecked()) {
            if (!bi.nw30898.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nw308, getString(R.string.nw308) + " - " + getString(R.string.times))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.nw308, 1, 5, getString(R.string.nw203), " times")) {
                    return false;
                }
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nw309, bi.nw309a, getString(R.string.nw309))) {
            return false;
        }

        if (bi.nw309a.isChecked()) {

//            if (!bi.nb21098a.isChecked() || !bi.nb21099a.isChecked()) {
//                if (!validatorClass.EmptyRadioButton(this, bi.nb21001, bi.nb21001a, getString(R.string.nb21001))) {
//                    return false;
//                }
//
//                if (!validatorClass.EmptyRadioButton(this, bi.nb21002, bi.nb21002a, getString(R.string.nb21002))) {
//                    return false;
//                }
//
//                if (!validatorClass.EmptyRadioButton(this, bi.nb21003, bi.nb21003a, getString(R.string.nb21003))) {
//                    return false;
//                }
//            }

            if (!validatorClass.EmptyRadioButton(this,bi.nw310,bi.nw310a,getString(R.string.nw310))){
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this,bi.nw310,bi.nw310a,bi.nw31096x,getString(R.string.nw310))){
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this,bi.nw315,bi.nw315a,getString(R.string.nw315))){
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this,bi.nw315,bi.nw315a,bi.nw31596x,getString(R.string.nw315))){
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this,bi.nw320,bi.nw320a,getString(R.string.nw320))){
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this,bi.nw320,bi.nw320a,bi.nw32096x,getString(R.string.nw320))){
                return false;
            }


            if (!validatorClass.EmptyRadioButton(this, bi.nw312, bi.nw312a, getString(R.string.nw312))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nw313m, getString(R.string.nw313) + " - " + getString(R.string.month))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nw313d, getString(R.string.nw313) + " - " + getString(R.string.day))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nw313m, 0, 11, getString(R.string.nw313), " months")) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nw313d, 0, 29, getString(R.string.nw313), " days")) {
                return false;
            }

            if (bi.nw313m.getText().toString().equals("0") && bi.nw313d.getText().toString().equals("0")) {
                Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nw313), Toast.LENGTH_LONG).show();
                bi.nw313m.setError("All can not be zero");
                bi.nw313d.setError("All can not be zero");
                Log.i(SectionB2Activity.class.getSimpleName(), "nw313" + ": This data is Required!");
                return false;
            } else {
                bi.nw313m.setError(null);
                bi.nw313d.setError(null);

            }

        }


        if (!validatorClass.EmptyRadioButton(this, bi.nw314, bi.nw314a, getString(R.string.nw314))) {
            return false;
        }

        if (bi.nw314a.isChecked()) {


            if (!validatorClass.EmptyRadioButton(this, bi.nw317, bi.nw317a, getString(R.string.nw317))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nw318m, getString(R.string.nw318) + " - " + getString(R.string.month))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nw318d, getString(R.string.nw318) + " - " + getString(R.string.day))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nw318m, 0, 11, getString(R.string.nw318), " months")) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nw318d, 0, 29, getString(R.string.nw318), " days")) {
                return false;
            }

            if (bi.nw318m.getText().toString().equals("0") && bi.nw318d.getText().toString().equals("0")) {
                Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nw318), Toast.LENGTH_LONG).show();
                bi.nw318m.setError("All can not be zero");
                bi.nw318d.setError("All can not be zero");
                Log.i(SectionB2Activity.class.getSimpleName(), "nw318" + ": This data is Required!");
                return false;
            } else {
                bi.nw318m.setError(null);
                bi.nw318d.setError(null);

            }

        }


        if (!validatorClass.EmptyRadioButton(this, bi.nw319, bi.nw319a, getString(R.string.nw319))) {
            return false;
        }

        if (bi.nw319a.isChecked()) {


            if (!validatorClass.EmptyRadioButton(this, bi.nw322, bi.nw322a, getString(R.string.nw322))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nw323m, getString(R.string.nw323) + " - " + getString(R.string.month))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nw323d, getString(R.string.nw323) + " - " + getString(R.string.day))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nw323m, 0, 11, getString(R.string.nw323), " months")) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nw323d, 0, 29, getString(R.string.nw323), " days")) {
                return false;
            }

            if (bi.nw323m.getText().toString().equals("0") && bi.nw323d.getText().toString().equals("0")) {
                Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nw323), Toast.LENGTH_LONG).show();
                bi.nw323m.setError("All can not be zero");
                bi.nw323d.setError("All can not be zero");
                Log.i(SectionB2Activity.class.getSimpleName(), "nw323" + ": This data is Required!");
                return false;
            } else {
                bi.nw323m.setError(null);
                bi.nw323d.setError(null);

            }

        }

        if (!validatorClass.EmptyRadioButton(this, bi.nw324, bi.nw324a, getString(R.string.nw324))) {
            return false;
        }

        return validatorClass.EmptyRadioButton(this, bi.nw325, bi.nw325a, getString(R.string.nw325));
    }


    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();
//       nw301
        JSONObject sB2 = new JSONObject();
        sB2.put("nw301", bi.nw301a.isChecked() ? "1"
                : bi.nw301b.isChecked() ? "2"
                : "0");

//       nw302
        sB2.put("nw302a", bi.nw302a.isChecked() ? "1" : "0");
        sB2.put("nw302b", bi.nw302b.isChecked() ? "2" : "0");
        sB2.put("nw302c", bi.nw302c.isChecked() ? "3" : "0");
        sB2.put("nw302d", bi.nw302d.isChecked() ? "4" : "0");
        sB2.put("nw302e", bi.nw302e.isChecked() ? "5" : "0");
        sB2.put("nw302f", bi.nw302f.isChecked() ? "6" : "0");
        sB2.put("nw302g", bi.nw302g.isChecked() ? "7" : "0");
        sB2.put("nw302h", bi.nw302h.isChecked() ? "8" : "0");
        sB2.put("nw30296", bi.nw30296.isChecked() ? "96" : "0");
        sB2.put("nw30296x", bi.nw30296x.getText().toString());


//        nw303
        sB2.put("nw303", bi.nw303w.getText().toString());
        sB2.put("nw303", bi.nw303w.getText().toString());
        sB2.put("nw30398", bi.nw30398.isChecked() ? "98" : "0");


        //        nw204
        sB2.put("nw304", bi.nw304.getText().toString());
        sB2.put("nw30498", bi.nw30498.isChecked() ? "98" : "0");

//      nw305
        sB2.put("nw305a", bi.nw305a.isChecked() ? "1" : "0");
        sB2.put("nw305b", bi.nw305b.isChecked() ? "2" : "0");
        sB2.put("nw305c", bi.nw305c.isChecked() ? "3" : "0");
        sB2.put("nw305d", bi.nw305d.isChecked() ? "4" : "0");
        sB2.put("nw305e", bi.nw305e.isChecked() ? "5" : "0");
        sB2.put("nw305f", bi.nw305f.isChecked() ? "6" : "0");
        sB2.put("nw305g", bi.nw305g.isChecked() ? "7" : "0");
        sB2.put("nw305h", bi.nw305h.isChecked() ? "8" : "0");
        sB2.put("nw30596", bi.nw30596.isChecked() ? "96" : "0");
        sB2.put("nw30596x", bi.nw30596x.getText().toString());

//        nw306
        sB2.put("nw306", bi.nw306a.isChecked() ? "1"
                : bi.nw306b.isChecked() ? "2"
                : bi.nw306c.isChecked() ? "3"
                : bi.nw30698.isChecked() ? "98"
                : "0");
//        nw307
        sB2.put("nw307", bi.nw307a.isChecked() ? "1"
                : bi.nw307b.isChecked() ? "2"
                : bi.nw30798.isChecked() ? "98"
                : "0");
//        nw308

        sB2.put("nw308", bi.nw308.getText().toString());
        sB2.put("nw30898", bi.nw30898.isChecked() ? "98" : "0");

//        nw309
        sB2.put("nw309", bi.nw309a.isChecked() ? "1"
                : bi.nw309b.isChecked() ? "2"
                : "0");

//          nw310
        sB2.put("nw310", bi.nw310a.isChecked() ? "1"
                : bi.nw310b.isChecked() ? "2"
                : bi.nw310c.isChecked() ? "3"
                : bi.nw310d.isChecked() ? "4"
                : bi.nw310e.isChecked() ? "5"
                : bi.nw310f.isChecked() ? "6"
                : bi.nw310g.isChecked() ? "7"
                : bi.nw310h.isChecked() ? "8"
                : bi.nw31096.isChecked() ? "96"
                : "0");
        sB2.put("nw31096x",bi.nw31096x.getText().toString());
//        nw311
        sB2.put("nw311", bi.nw311a.isChecked() ? "1"
                : bi.nw311b.isChecked() ? "2"
                : bi.nw311c.isChecked() ? "3"
                : bi.nw311d.isChecked() ? "4"
                : bi.nw311e.isChecked() ? "5"
                : bi.nw311f.isChecked() ? "6"
                : bi.nw311g.isChecked() ? "7"
                : bi.nw311h.isChecked() ? "8"
                : bi.nw311i.isChecked() ? "9"
                : bi.nw311j.isChecked() ? "10"
                : bi.nw311k.isChecked() ? "11"
                : bi.nw311l.isChecked() ? "12"
                : bi.nw311m.isChecked() ? "13"
                : bi.nw311961.isChecked() ? "961"
                : bi.nw311962.isChecked() ? "962"
                : bi.nw311963.isChecked() ? "963"
                : "0");
        sB2.put("nw311961x",bi.nw311961x.getText().toString());
        sB2.put("nw311962x",bi.nw311962x.getText().toString());
        sB2.put("nw311963x",bi.nw311963x.getText().toString());

//         nw312
        sB2.put("nw312", bi.nw312a.isChecked() ? "1"
                : bi.nw312b.isChecked() ? "2"
                : bi.nw312c.isChecked() ? "3"
                : bi.nw312d.isChecked() ? "4"
                : bi.nw312e.isChecked() ? "5"
                : "0");

//        nw313
        sB2.put("nw313m", bi.nw313m.getText().toString());
        sB2.put("nw313d", bi.nw313d.getText().toString());

        //        nw314
        sB2.put("nw314", bi.nw314a.isChecked() ? "1"
                : bi.nw314b.isChecked() ? "2"
                : "0");

//        nw315

        sB2.put("nw315", bi.nw315a.isChecked() ? "1"
                : bi.nw315b.isChecked() ? "2"
                : bi.nw315c.isChecked() ? "3"
                : bi.nw315d.isChecked() ? "4"
                : bi.nw315e.isChecked() ? "5"
                : bi.nw315f.isChecked() ? "6"
                : bi.nw315g.isChecked() ? "7"
                : bi.nw315h.isChecked() ? "8"
                : bi.nw31596.isChecked() ? "96"
                : "0");
        sB2.put("nw31596x",bi.nw31596x.getText().toString());

//        nw316
        sB2.put("nw316", bi.nw316a.isChecked() ? "1"
                : bi.nw316b.isChecked() ? "2"
                : bi.nw316c.isChecked() ? "3"
                : bi.nw316d.isChecked() ? "4"
                : bi.nw316e.isChecked() ? "5"
                : bi.nw316f.isChecked() ? "6"
                : bi.nw316g.isChecked() ? "7"
                : bi.nw316h.isChecked() ? "8"
                : bi.nw316i.isChecked() ? "9"
                : bi.nw316j.isChecked() ? "10"
                : bi.nw316k.isChecked() ? "11"
                : bi.nw316l.isChecked() ? "12"
                : bi.nw316m.isChecked() ? "13"
                : bi.nw316961.isChecked() ? "961"
                : bi.nw316962.isChecked() ? "962"
                : bi.nw316963.isChecked() ? "963"
                : "0");
        sB2.put("nw316961x",bi.nw316961x.getText().toString());
        sB2.put("nw316962x",bi.nw316962x.getText().toString());
        sB2.put("nw316963x",bi.nw316963x.getText().toString());



//        nw317
        sB2.put("nw317", bi.nw317a.isChecked() ? "1"
                : bi.nw317b.isChecked() ? "2"
                : bi.nw317b.isChecked() ? "3"
                : bi.nw317b.isChecked() ? "4"
                : bi.nw317b.isChecked() ? "5"
                : "0");

//        nw318
        sB2.put("nw318m", bi.nw318m.getText().toString());
        sB2.put("nw318d", bi.nw318d.getText().toString());

//        nw319
        sB2.put("nw319", bi.nw319a.isChecked() ? "1"
                : bi.nw319b.isChecked() ? "2"
                : "0");


//        nw320

        sB2.put("nw320", bi.nw320a.isChecked() ? "1"
                : bi.nw320b.isChecked() ? "2"
                : bi.nw320c.isChecked() ? "3"
                : bi.nw320d.isChecked() ? "4"
                : bi.nw320e.isChecked() ? "5"
                : bi.nw320f.isChecked() ? "6"
                : bi.nw320g.isChecked() ? "7"
                : bi.nw320h.isChecked() ? "8"
                : bi.nw32096.isChecked() ? "96"
                : "0");
        sB2.put("nwnw32096x",bi.nw32096x.getText().toString());

//        nw321
        sB2.put("nw321", bi.nw321a.isChecked() ? "1"
                : bi.nw321b.isChecked() ? "2"
                : bi.nw321c.isChecked() ? "3"
                : bi.nw321d.isChecked() ? "4"
                : bi.nw321e.isChecked() ? "5"
                : bi.nw321f.isChecked() ? "6"
                : bi.nw321g.isChecked() ? "7"
                : bi.nw321h.isChecked() ? "8"
                : bi.nw321i.isChecked() ? "9"
                : bi.nw321j.isChecked() ? "10"
                : bi.nw321k.isChecked() ? "11"
                : bi.nw321l.isChecked() ? "12"
                : bi.nw321m.isChecked() ? "13"
                : bi.nw321961.isChecked() ? "961"
                : bi.nw321962.isChecked() ? "962"
                : bi.nw321963.isChecked() ? "963"
                : "0");
        sB2.put("nw321961x",bi.nw321961x.getText().toString());
        sB2.put("nw321962x",bi.nw321962x.getText().toString());
        sB2.put("nw321963x",bi.nw321963x.getText().toString());



//        nw322
        sB2.put("nw322", bi.nw322a.isChecked() ? "1"
                : bi.nw322b.isChecked() ? "2"
                : bi.nw322c.isChecked() ? "3"
                : bi.nw322d.isChecked() ? "4"
                : bi.nw322e.isChecked() ? "5"
                : "0");

//        nw323
        sB2.put("nw323m", bi.nw323m.getText().toString());
        sB2.put("nw323d", bi.nw323d.getText().toString());

//        nw324
        sB2.put("nw324", bi.nw324a.isChecked() ? "1"
                : bi.nw324b.isChecked() ? "2"
                : "0");
//        nw325
        sB2.put("nw325", bi.nw325a.isChecked() ? "1"
                : bi.nw325b.isChecked() ? "2"
                : bi.nw32598.isChecked() ? "98"
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
