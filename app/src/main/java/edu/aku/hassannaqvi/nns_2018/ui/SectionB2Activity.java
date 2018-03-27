package edu.aku.hassannaqvi.nns_2018.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;

import java.util.Timer;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper_DBFlow;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB2Binding;
import edu.aku.hassannaqvi.nns_2018.validation.clearClass;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionB2Activity extends Activity {

    private final long DELAY = 1000;
    ActivitySectionB2Binding bi;
    DatabaseHelper_DBFlow db;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b2);
        db = new DatabaseHelper_DBFlow(this);
        bi.setCallback(this);

        setupViews();
    }

    public void setupViews() {
        bi.nw301.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nw301a.isChecked()) {
                    //bi.fldGrpnw302.setVisibility(View.VISIBLE);
                    clearClass.ClearAllFields(bi.fldGrpnw302, true);
                    clearClass.ClearAllFields(bi.fldGrpnw302check, true);
                    clearClass.ClearAllFields(bi.fldGrpnw306check, true);
                } else {
                    clearClass.ClearAllFields(bi.fldGrpnw302, false);
                    clearClass.ClearAllFields(bi.fldGrpnw302check, false);
                    clearClass.ClearAllFields(bi.fldGrpnw306check, false);
                    /*bi.fldGrpnw302.setVisibility(View.GONE);
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
                    bi.nw303.clearCheck();
                    bi.nw303961x.setText(null);
                    bi.nw303962x.setText(null);
                    bi.nw303963x.setText(null);
                    bi.nw304m.setText(null);
                    bi.nw304w.setText(null);
                    bi.nw30498.setChecked(false);
                    bi.nw305.setText(null);
                    bi.nw30598.setChecked(false);
                    bi.nw306a.setChecked(false);
                    bi.nw306b.setChecked(false);
                    bi.nw306c.setChecked(false);
                    bi.nw306d.setChecked(false);
                    bi.nw306e.setChecked(false);
                    bi.nw306f.setChecked(false);
                    bi.nw306g.setChecked(false);
                    bi.nw306h.setChecked(false);
                    bi.nw30696.setChecked(false);
                    bi.nw30696x.setText(null);*/
                }
            }
        });

        bi.nw306i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bi.nw306i.isChecked()) {

                    bi.nw306a.setChecked(false);
                    bi.nw306b.setChecked(false);
                    bi.nw306c.setChecked(false);
                    bi.nw306d.setChecked(false);
                    bi.nw306e.setChecked(false);
                    bi.nw306f.setChecked(false);
                    bi.nw306g.setChecked(false);
                    bi.nw306h.setChecked(false);
                    bi.nw30696.setChecked(false);

                    bi.nw306a.setEnabled(false);
                    bi.nw306b.setEnabled(false);
                    bi.nw306c.setEnabled(false);
                    bi.nw306d.setEnabled(false);
                    bi.nw306e.setEnabled(false);
                    bi.nw306f.setEnabled(false);
                    bi.nw306g.setEnabled(false);
                    bi.nw306h.setEnabled(false);
                    bi.nw30696.setEnabled(false);
                } else {
                    bi.nw306a.setEnabled(true);
                    bi.nw306b.setEnabled(true);
                    bi.nw306c.setEnabled(true);
                    bi.nw306d.setEnabled(true);
                    bi.nw306e.setEnabled(true);
                    bi.nw306f.setEnabled(true);
                    bi.nw306g.setEnabled(true);
                    bi.nw306h.setEnabled(true);
                    bi.nw30696.setEnabled(true);
                }
            }
        });
        bi.nw308.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nw308a.isChecked()) {
                    //bi.fldGrpnw309.setVisibility(View.VISIBLE);
                    clearClass.ClearAllFields(bi.fldGrpnw309, true);

                } else {

                    clearClass.ClearAllFields(bi.fldGrpnw309, false);
                    /*bi.fldGrpnw309.setVisibility(View.GONE);
                    bi.nw309.setText(null);
                    bi.nw30998.setChecked(false);*/
                }
            }
        });

        bi.nw310.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nw310a.isChecked()) {
                    clearClass.ClearAllFields(bi.fldGrpnb210, true);
                    clearClass.ClearAllFields(bi.fldGrpnw312, true);
                    //bi.fldGrpnb210.setVisibility(View.VISIBLE);
                } else {
                    clearClass.ClearAllFields(bi.fldGrpnb210, false);
                    clearClass.ClearAllFields(bi.fldGrpnw312, false);
                    /*bi.fldGrpnb210.setVisibility(View.GONE);
                    bi.nw311.clearCheck();
                    bi.nw31196x.setText(null);
                    bi.nw312a.setChecked(false);
                    bi.nw312b.setChecked(false);
                    bi.nw312c.setChecked(false);
                    bi.nw312d.setChecked(false);
                    bi.nw312e.setChecked(false);
                    bi.nw312f.setChecked(false);
                    bi.nw312g.setChecked(false);
                    bi.nw312h.setChecked(false);
                    bi.nw312i.setChecked(false);
                    bi.nw312j.setChecked(false);
                    bi.nw312k.setChecked(false);
                    bi.nw312l.setChecked(false);
                    bi.nw312m.setChecked(false);
                    bi.nw312961.setChecked(false);
                    bi.nw312962.setChecked(false);
                    bi.nw312963.setChecked(false);
                    bi.nw312961x.setText(null);
                    bi.nw312962x.setText(null);
                    bi.nw312963x.setText(null);
                    bi.nw313.clearCheck();
                    bi.nw314m.setText(null);
                    bi.nw314d.setText(null);*/
                }
            }
        });

        bi.nw315.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nw315a.isChecked()) {
                    //bi.fldGrpnw318.setVisibility(View.VISIBLE);
                    clearClass.ClearAllFields(bi.fldGrpnw318, true);
                    clearClass.ClearAllFields(bi.fldGrpnw317, true);
                } else {
                    clearClass.ClearAllFields(bi.fldGrpnw318, false);
                    clearClass.ClearAllFields(bi.fldGrpnw317, false);
                    /*bi.fldGrpnw318.setVisibility(View.GONE);

                    bi.nw316.clearCheck();
                    bi.nw31696x.setText(null);

                    bi.nw317a.setChecked(false);
                    bi.nw317b.setChecked(false);
                    bi.nw317c.setChecked(false);
                    bi.nw317d.setChecked(false);
                    bi.nw317e.setChecked(false);
                    bi.nw317f.setChecked(false);
                    bi.nw317g.setChecked(false);
                    bi.nw317h.setChecked(false);
                    bi.nw317i.setChecked(false);
                    bi.nw317j.setChecked(false);
                    bi.nw317k.setChecked(false);
                    bi.nw317l.setChecked(false);
                    bi.nw317m.setChecked(false);
                    bi.nw317961.setChecked(false);
                    bi.nw317962.setChecked(false);
                    bi.nw317963.setChecked(false);
                    bi.nw317961x.setText(null);
                    bi.nw317962x.setText(null);
                    bi.nw317963x.setText(null);

                    bi.nw318.clearCheck();

                    bi.nw319m.setText(null);
                    bi.nw319d.setText(null);*/
                }
            }
        });


        bi.nw320.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nw320a.isChecked()) {
                    //bi.fldGrpnw323.setVisibility(View.VISIBLE);
                    clearClass.ClearAllFields(bi.fldGrpnw323, true);
                    clearClass.ClearAllFields(bi.fldGrpnw322, true);
                } else {
                    clearClass.ClearAllFields(bi.fldGrpnw323, false);
                    clearClass.ClearAllFields(bi.fldGrpnw322, false);

/*                    bi.fldGrpnw323.setVisibility(View.GONE);

                    bi.nw321.clearCheck();
                    bi.nw32196x.setText(null);

                    bi.nw322a.setChecked(false);
                    bi.nw322b.setChecked(false);
                    bi.nw322c.setChecked(false);
                    bi.nw322d.setChecked(false);
                    bi.nw322e.setChecked(false);
                    bi.nw322f.setChecked(false);
                    bi.nw322g.setChecked(false);
                    bi.nw322h.setChecked(false);
                    bi.nw322i.setChecked(false);
                    bi.nw322j.setChecked(false);
                    bi.nw322k.setChecked(false);
                    bi.nw322l.setChecked(false);
                    bi.nw322m.setChecked(false);
                    bi.nw322961.setChecked(false);
                    bi.nw322962.setChecked(false);
                    bi.nw322963.setChecked(false);

                    bi.nw322961x.setText(null);
                    bi.nw322962x.setText(null);
                    bi.nw322963x.setText(null);

                    bi.nw323.clearCheck();

                    bi.nw324d.setText(null);
                    bi.nw324m.setText(null);*/
                }
            }
        });

//        Setting name of women
        bi.nw301Txt.setText(getString(R.string.nw301a) + " " + SectionB1Activity.wraName + " " + getString(R.string.nw301b));

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

                finish();

                if (!MainApp.B2B6Flag) {
                    MainApp.B2B6Flag = true;
                }

                startActivity(new Intent(this, SectionB3Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

        //startActivity(new Intent(this, SectionB3Activity.class));
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

        if (!validatorClass.EmptyRadioButton(this, bi.nw301, bi.nw301a, getString(R.string.nw301b) + " " + SectionB1Activity.wraName + " " + getString(R.string.nw301a))) {
            return false;
        }

        if (bi.nw301a.isChecked()) {
            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnw302check, bi.nw302a, getString(R.string.nw302))) {
                return false;
            }
            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnw302check, bi.nw30296, bi.nw30296x, getString(R.string.nw302) + " - " + getString(R.string.other))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.nw303, bi.nw303a, getString(R.string.nw303))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.nw303, bi.nw303f, bi.nw303961x, getString(R.string.nw303) + " - " + getString(R.string.nw303f))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.nw303, bi.nw303j, bi.nw303962x, getString(R.string.nw303) + " - " + getString(R.string.nw303j))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.nw303, bi.nw30396, bi.nw303963x, getString(R.string.nw303) + " - " + getString(R.string.other))) {
                return false;
            }


            if (!bi.nw30498.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nw304w, getString(R.string.nw304) + " - " + getString(R.string.week))) {
                    return false;
                }

                if (bi.nw304m.getText().toString().equals("0")) {
                    if (!validatorClass.RangeTextBox(this, bi.nw304w, 2, 44, getString(R.string.nw304), " weeks")) {
                        return false;
                    }
                } else {
                    if (!validatorClass.RangeTextBox(this, bi.nw304w, 0, 44, getString(R.string.nw304), " weeks")) {
                        return false;
                    }
                }

                if (!validatorClass.EmptyTextBox(this, bi.nw304m, getString(R.string.nw304) + " - " + getString(R.string.months))) {
                    return false;
                }

                if (bi.nw304w.getText().toString().equals("0")) {
                    if (!validatorClass.RangeTextBox(this, bi.nw304m, 1, 9, getString(R.string.nw203), " months")) {
                        return false;
                    }
                } else {
                    if (!validatorClass.RangeTextBox(this, bi.nw304m, 0, 9, getString(R.string.nw203), " months")) {
                        return false;
                    }
                }

                if (bi.nw304w.getText().toString().equals("0") && bi.nw304m.getText().toString().equals("0")) {
                    Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nw304), Toast.LENGTH_LONG).show();
                    bi.nw304w.setError("All can not be zero");
                    bi.nw304w.setError("All can not be zero");
                    Log.i(SectionB2Activity.class.getSimpleName(), "nw304" + ": This data is Required!");
                    return false;
                } else {
                    bi.nw304w.setError(null);
                    bi.nw304m.setError(null);

                }

            }

            if (!bi.nw30598.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nw305, getString(R.string.nw305) + " - " + getString(R.string.times))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, bi.nw305, 1, 15, getString(R.string.nw305), " times")) {
                    return false;
                }

            }

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnw306check, bi.nw306a, getString(R.string.nw306))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnw306check, bi.nw30696, bi.nw30696x, getString(R.string.nw306) + " - " + getString(R.string.other))) {
                return false;
            }

        }


        if (!validatorClass.EmptyRadioButton(this, bi.nw307, bi.nw307a, getString(R.string.nw307))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nw308, bi.nw308a, getString(R.string.nw308))) {
            return false;
        }

        if (bi.nw308a.isChecked()) {
            if (!bi.nw30998.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nw309, getString(R.string.nw309) + " - " + getString(R.string.times))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.nw309, 1, 5, getString(R.string.nw203), " times")) {
                    return false;
                }
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nw310, bi.nw310a, getString(R.string.nw310))) {
            return false;
        }

        if (bi.nw310a.isChecked()) {

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

            if (!validatorClass.EmptyRadioButton(this, bi.nw311, bi.nw311a, getString(R.string.nw311))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.nw311, bi.nw31196, bi.nw31196x, getString(R.string.nw311))) {
                return false;
            }
            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnw312, bi.nw312a, getString(R.string.nw312))) {
                return false;
            }
            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnw312, bi.nw312961, bi.nw312961x, getString(R.string.nw312))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnw312, bi.nw312962, bi.nw312962x, getString(R.string.nw312))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnw312, bi.nw312963, bi.nw312963x, getString(R.string.nw312))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, bi.nw313, bi.nw313a, getString(R.string.nw313))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nw314m, getString(R.string.nw314) + " - " + getString(R.string.months))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nw314d, getString(R.string.nw314) + " - " + getString(R.string.day))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nw314m, 0, 11, getString(R.string.nw314), " months")) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nw314d, 0, 29, getString(R.string.nw314), " days")) {
                return false;
            }

            if (bi.nw314m.getText().toString().equals("0") && bi.nw314d.getText().toString().equals("0")) {
                Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nw314), Toast.LENGTH_LONG).show();
                bi.nw314m.setError("All can not be zero");
                bi.nw314d.setError("All can not be zero");
                Log.i(SectionB2Activity.class.getSimpleName(), "nw314" + ": This data is Required!");
                return false;
            } else {
                bi.nw314m.setError(null);
                bi.nw314d.setError(null);

            }

        }

        if (!validatorClass.EmptyRadioButton(this, bi.nw315, bi.nw315a, getString(R.string.nw315))) {
            return false;
        }

        if (bi.nw315a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.nw316, bi.nw316a, getString(R.string.nw316))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.nw316, bi.nw31696, bi.nw31696x, getString(R.string.nw316))) {
                return false;
            }
            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnw317, bi.nw317a, getString(R.string.nw317))) {
                return false;
            }
            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnw317, bi.nw317961, bi.nw317961x, getString(R.string.nw317))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnw317, bi.nw317962, bi.nw317962x, getString(R.string.nw317))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnw317, bi.nw317963, bi.nw317963x, getString(R.string.nw317))) {
                return false;
            }


            if (!validatorClass.EmptyRadioButton(this, bi.nw318, bi.nw318a, getString(R.string.nw318))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nw319m, getString(R.string.nw319) + " - " + getString(R.string.month))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nw319d, getString(R.string.nw319) + " - " + getString(R.string.day))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nw319m, 0, 11, getString(R.string.nw319), " months")) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nw319d, 0, 29, getString(R.string.nw319), " days")) {
                return false;
            }

            if (bi.nw319m.getText().toString().equals("0") && bi.nw319d.getText().toString().equals(" 0")) {
                Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nw319), Toast.LENGTH_LONG).show();
                bi.nw319m.setError("All can not be zero");
                bi.nw319d.setError("All can not be zero");
                Log.i(SectionB2Activity.class.getSimpleName(), "nw319" + ": This data is Required!");
                return false;
            } else {
                bi.nw319m.setError(null);
                bi.nw319d.setError(null);

            }

        }


        if (!validatorClass.EmptyRadioButton(this, bi.nw320, bi.nw320a, getString(R.string.nw320))) {
            return false;
        }

        if (bi.nw320a.isChecked()) {


            if (!validatorClass.EmptyRadioButton(this, bi.nw321, bi.nw321a, getString(R.string.nw321))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.nw321, bi.nw32196, bi.nw32196x, getString(R.string.nw321))) {
                return false;
            }
            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnw322, bi.nw322a, getString(R.string.nw322))) {
                return false;
            }
            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnw322, bi.nw322961, bi.nw322961x, getString(R.string.nw322))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnw322, bi.nw322962, bi.nw322962x, getString(R.string.nw322))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnw322, bi.nw322963, bi.nw322963x, getString(R.string.nw322))) {
                return false;
            }


            if (!validatorClass.EmptyRadioButton(this, bi.nw323, bi.nw323a, getString(R.string.nw323))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nw324m, getString(R.string.nw324) + " - " + getString(R.string.month))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nw324d, getString(R.string.nw324) + " - " + getString(R.string.day))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nw324m, 0, 11, getString(R.string.nw324), " months")) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nw324d, 0, 29, getString(R.string.nw324), " days")) {
                return false;
            }

            if (bi.nw324m.getText().toString().equals("0") && bi.nw324d.getText().toString().equals("0")) {
                Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nw324), Toast.LENGTH_LONG).show();
                bi.nw324m.setError("All can not be zero");

                bi.nw324d.setError("All can not be zero");
                Log.i(SectionB2Activity.class.getSimpleName(), "nw324" + ": This data is Required!");
                return false;
            } else {
                bi.nw324m.setError(null);
                bi.nw324d.setError(null);

            }

        }

        if (!validatorClass.EmptyRadioButton(this, bi.nw325, bi.nw325a, getString(R.string.nw325))) {
            return false;
        }

        return validatorClass.EmptyRadioButton(this, bi.nw326, bi.nw326a, getString(R.string.nw326));
    }


    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();
        //JSONObject sB2 = new JSONObject();


        MainApp.mc.setNw301(bi.nw301a.isChecked() ? "1"
                : bi.nw301b.isChecked() ? "2"
                : "0");

//       nw302
        MainApp.mc.setNw302a(bi.nw302a.isChecked() ? "1" : "0");
        MainApp.mc.setNw302b(bi.nw302b.isChecked() ? "2" : "0");
        MainApp.mc.setNw302c(bi.nw302c.isChecked() ? "3" : "0");
        MainApp.mc.setNw302d(bi.nw302d.isChecked() ? "4" : "0");
        MainApp.mc.setNw302e(bi.nw302e.isChecked() ? "5" : "0");
        MainApp.mc.setNw302f(bi.nw302f.isChecked() ? "6" : "0");
        MainApp.mc.setNw302g(bi.nw302g.isChecked() ? "7" : "0");
        MainApp.mc.setNw302h(bi.nw302h.isChecked() ? "8" : "0");
        MainApp.mc.setNw30296(bi.nw30296.isChecked() ? "96" : "0");

        MainApp.mc.setNw30296x(bi.nw30296x.getText().toString());

//      nw303
        MainApp.mc.setNw303(bi.nw303a.isChecked() ? "1"
                : bi.nw303b.isChecked() ? "2"
                : bi.nw303c.isChecked() ? "3"
                : bi.nw303d.isChecked() ? "4"
                : bi.nw303e.isChecked() ? "5"
                : bi.nw303f.isChecked() ? "6"
                : bi.nw303g.isChecked() ? "7"
                : bi.nw303h.isChecked() ? "8"
                : bi.nw303i.isChecked() ? "9"
                : bi.nw303j.isChecked() ? "10"
                : bi.nw30396.isChecked() ? "96"
                : "0");
        MainApp.mc.setNw303961x(bi.nw303961x.getText().toString());
        MainApp.mc.setNw303962x(bi.nw303962x.getText().toString());
        MainApp.mc.setNw303963x(bi.nw303963x.getText().toString());


//        nw304
        MainApp.mc.setNw304(bi.nw304w.getText().toString());
        MainApp.mc.setNw30498(bi.nw30498.isChecked() ? "98" : "0");


//        nw204
        MainApp.mc.setNw305(bi.nw305.getText().toString());
        MainApp.mc.setNw30598(bi.nw30598.isChecked() ? "98" : "0");

//      nw306
        MainApp.mc.setNw306a(bi.nw306a.isChecked() ? "1" : "0");
        MainApp.mc.setNw306b(bi.nw306b.isChecked() ? "2" : "0");
        MainApp.mc.setNw306c(bi.nw306c.isChecked() ? "3" : "0");
        MainApp.mc.setNw306d(bi.nw306d.isChecked() ? "4" : "0");
        MainApp.mc.setNw306e(bi.nw306e.isChecked() ? "5" : "0");
        MainApp.mc.setNw306f(bi.nw306f.isChecked() ? "6" : "0");
        MainApp.mc.setNw306g(bi.nw306g.isChecked() ? "7" : "0");
        MainApp.mc.setNw306h(bi.nw306h.isChecked() ? "8" : "0");
        MainApp.mc.setNw306i(bi.nw306i.isChecked() ? "9" : "0");
        MainApp.mc.setNw30696(bi.nw30696.isChecked() ? "96" : "0");
        MainApp.mc.setNw30696x(bi.nw30696x.getText().toString());

//        nw307
        MainApp.mc.setNw307(bi.nw307a.isChecked() ? "1"
                : bi.nw307b.isChecked() ? "2"
                : bi.nw307c.isChecked() ? "3"
                : bi.nw30798.isChecked() ? "98"
                : "0");
//        nw308
        MainApp.mc.setNw308(bi.nw308a.isChecked() ? "1"
                : bi.nw308b.isChecked() ? "2"
                : bi.nw30898.isChecked() ? "98"
                : "0");
//        nw309

        MainApp.mc.setNw309(bi.nw30998.isChecked() ? "98" : bi.nw309.getText().toString());
//        sB2.put("nw30998", bi.nw30998.isChecked() ? "98" : "0");

//        nw310
        MainApp.mc.setNw310(bi.nw310a.isChecked() ? "1"
                : bi.nw310b.isChecked() ? "2"
                : "0");

//          nw311
        MainApp.mc.setNw311(bi.nw311a.isChecked() ? "1"
                : bi.nw311b.isChecked() ? "2"
                : bi.nw311c.isChecked() ? "3"
                : bi.nw311d.isChecked() ? "4"
                : bi.nw311e.isChecked() ? "5"
                : bi.nw311f.isChecked() ? "6"
                : bi.nw311g.isChecked() ? "7"
                : bi.nw311h.isChecked() ? "8"
                : bi.nw31196.isChecked() ? "96"
                : "0");
        MainApp.mc.setNw31196x(bi.nw31196x.getText().toString());
//        nw312
        MainApp.mc.setNw312a(bi.nw312a.isChecked() ? "1" : "0");
        MainApp.mc.setNw312b(bi.nw312b.isChecked() ? "2" : "0");
        MainApp.mc.setNw312c(bi.nw312c.isChecked() ? "3" : "0");
        MainApp.mc.setNw312d(bi.nw312d.isChecked() ? "4" : "0");
        MainApp.mc.setNw312e(bi.nw312e.isChecked() ? "5" : "0");
        MainApp.mc.setNw312f(bi.nw312f.isChecked() ? "6" : "0");
        MainApp.mc.setNw312g(bi.nw312g.isChecked() ? "7" : "0");
        MainApp.mc.setNw312h(bi.nw312h.isChecked() ? "8" : "0");
        MainApp.mc.setNw312i(bi.nw312i.isChecked() ? "9" : "0");
        MainApp.mc.setNw312j(bi.nw312j.isChecked() ? "10" : "0");
        MainApp.mc.setNw312k(bi.nw312k.isChecked() ? "11" : "0");
        MainApp.mc.setNw312l(bi.nw312l.isChecked() ? "12" : "0");
        MainApp.mc.setNw312m(bi.nw312m.isChecked() ? "13" : "0");
        MainApp.mc.setNw312961(bi.nw312961.isChecked() ? "961" : "0");
        MainApp.mc.setNw312962(bi.nw312962.isChecked() ? "962" : "0");
        MainApp.mc.setNw312963(bi.nw312963.isChecked() ? "963" : "0");

        MainApp.mc.setNw312961x(bi.nw312961x.getText().toString());
        MainApp.mc.setNw312962x(bi.nw312962x.getText().toString());
        MainApp.mc.setNw312963x(bi.nw312963x.getText().toString());

//         nw313
        MainApp.mc.setNw313(bi.nw313a.isChecked() ? "1"
                : bi.nw313b.isChecked() ? "2"
                : bi.nw313c.isChecked() ? "3"
                : bi.nw313d.isChecked() ? "4"
                : bi.nw313e.isChecked() ? "5"
                : "0");

//        nw314
        MainApp.mc.setNw314m(bi.nw314m.getText().toString());
        MainApp.mc.setNw314d(bi.nw314d.getText().toString());

        //        nw315
        MainApp.mc.setNw315(bi.nw315a.isChecked() ? "1"
                : bi.nw315b.isChecked() ? "2"
                : "0");

//        nw316

        MainApp.mc.setNw316(bi.nw316a.isChecked() ? "1"
                : bi.nw316b.isChecked() ? "2"
                : bi.nw316c.isChecked() ? "3"
                : bi.nw316d.isChecked() ? "4"
                : bi.nw316e.isChecked() ? "5"
                : bi.nw316f.isChecked() ? "6"
                : bi.nw316g.isChecked() ? "7"
                : bi.nw316h.isChecked() ? "8"
                : bi.nw31696.isChecked() ? "96"
                : "0");
        MainApp.mc.setNw31696x(bi.nw31696x.getText().toString());

//        nw317
        MainApp.mc.setNw317a(bi.nw317a.isChecked() ? "1" : "0");
        MainApp.mc.setNw317b(bi.nw317b.isChecked() ? "2" : "0");
        MainApp.mc.setNw317c(bi.nw317c.isChecked() ? "3" : "0");
        MainApp.mc.setNw317d(bi.nw317d.isChecked() ? "4" : "0");
        MainApp.mc.setNw317e(bi.nw317e.isChecked() ? "5" : "0");
        MainApp.mc.setNw317f(bi.nw317f.isChecked() ? "6" : "0");
        MainApp.mc.setNw317g(bi.nw317g.isChecked() ? "7" : "0");
        MainApp.mc.setNw317h(bi.nw317h.isChecked() ? "8" : "0");
        MainApp.mc.setNw317i(bi.nw317i.isChecked() ? "9" : "0");
        MainApp.mc.setNw317j(bi.nw317j.isChecked() ? "10" : "0");
        MainApp.mc.setNw317k(bi.nw317k.isChecked() ? "11" : "0");
        MainApp.mc.setNw317l(bi.nw317l.isChecked() ? "12" : "0");
        MainApp.mc.setNw317m(bi.nw317m.isChecked() ? "13" : "0");
        MainApp.mc.setNw317961(bi.nw317961.isChecked() ? "961" : "0");
        MainApp.mc.setNw317962(bi.nw317962.isChecked() ? "962" : "0");
        MainApp.mc.setNw317963(bi.nw317963.isChecked() ? "963" : "0");

        MainApp.mc.setNw317961x(bi.nw317961x.getText().toString());
        MainApp.mc.setNw317962x(bi.nw317962x.getText().toString());
        MainApp.mc.setNw317963x(bi.nw317963x.getText().toString());


//        nw318
        MainApp.mc.setNw318(bi.nw318a.isChecked() ? "1"
                : bi.nw318b.isChecked() ? "2"
                : bi.nw318b.isChecked() ? "3"
                : bi.nw318b.isChecked() ? "4"
                : bi.nw318b.isChecked() ? "5"
                : "0");

//        nw319
        MainApp.mc.setNw319m(bi.nw319m.getText().toString());
        MainApp.mc.setNw319d(bi.nw319d.getText().toString());

//        nw320
        MainApp.mc.setNw320(bi.nw320a.isChecked() ? "1"
                : bi.nw320b.isChecked() ? "2"
                : "0");


//        nw321

        MainApp.mc.setNw321(bi.nw321a.isChecked() ? "1"
                : bi.nw321b.isChecked() ? "2"
                : bi.nw321c.isChecked() ? "3"
                : bi.nw321d.isChecked() ? "4"
                : bi.nw321e.isChecked() ? "5"
                : bi.nw321f.isChecked() ? "6"
                : bi.nw321g.isChecked() ? "7"
                : bi.nw321h.isChecked() ? "8"
                : bi.nw32196.isChecked() ? "96"
                : "0");
        MainApp.mc.setNw32196x(bi.nw32196x.getText().toString());

//        nw322
        MainApp.mc.setNw322a(bi.nw322a.isChecked() ? "1" : "0");
        MainApp.mc.setNw322b(bi.nw322b.isChecked() ? "2" : "0");
        MainApp.mc.setNw322c(bi.nw322c.isChecked() ? "3" : "0");
        MainApp.mc.setNw322d(bi.nw322d.isChecked() ? "4" : "0");
        MainApp.mc.setNw322e(bi.nw322e.isChecked() ? "5" : "0");
        MainApp.mc.setNw322f(bi.nw322f.isChecked() ? "6" : "0");
        MainApp.mc.setNw322g(bi.nw322g.isChecked() ? "7" : "0");
        MainApp.mc.setNw322h(bi.nw322h.isChecked() ? "8" : "0");
        MainApp.mc.setNw322i(bi.nw322i.isChecked() ? "9" : "0");
        MainApp.mc.setNw322j(bi.nw322j.isChecked() ? "10" : "0");
        MainApp.mc.setNw322k(bi.nw322k.isChecked() ? "11" : "0");
        MainApp.mc.setNw322l(bi.nw322l.isChecked() ? "12" : "0");
        MainApp.mc.setNw322m(bi.nw322m.isChecked() ? "13" : "0");
        MainApp.mc.setNw322961(bi.nw322961.isChecked() ? "961" : "0");
        MainApp.mc.setNw322962(bi.nw322962.isChecked() ? "962" : "0");
        MainApp.mc.setNw322963(bi.nw322963.isChecked() ? "963" : "0");


        MainApp.mc.setNw322961x(bi.nw322961x.getText().toString());
        MainApp.mc.setNw322962x(bi.nw322962x.getText().toString());
        MainApp.mc.setNw322963x(bi.nw322963x.getText().toString());


//        nw323
        MainApp.mc.setNw323(bi.nw323a.isChecked() ? "1"
                : bi.nw323b.isChecked() ? "2"
                : bi.nw323c.isChecked() ? "3"
                : bi.nw323d.isChecked() ? "4"
                : bi.nw323e.isChecked() ? "5"
                : "0");

//        nw324
        MainApp.mc.setNw324m(bi.nw324m.getText().toString());
        MainApp.mc.setNw324d(bi.nw324d.getText().toString());

//        nw325
        MainApp.mc.setNw325(bi.nw325a.isChecked() ? "1"
                : bi.nw325b.isChecked() ? "2"
                : "0");
//        nw326
        MainApp.mc.setNw326(bi.nw326a.isChecked() ? "1"
                : bi.nw326b.isChecked() ? "2"
                : bi.nw32698.isChecked() ? "98"
                : "0");

        // MainApp.mc.setsB2(String.valueOf(sB2));


        //Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        /*DatabaseHelper_DBFlow db = new DatabaseHelper_DBFlow(this);

        int updcount = db.updateSB2();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/

        MainApp.mc.update();
        return true;

    }

}
