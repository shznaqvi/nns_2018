package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;

import butterknife.BindViews;
import butterknife.ButterKnife;
import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.OutcomeContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB1ABinding;
import edu.aku.hassannaqvi.nns_2018.other.DateUtils;
import edu.aku.hassannaqvi.nns_2018.validation.clearClass;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionB1AActivity extends AppCompatActivity implements TextWatcher {

    private final long DELAY = 1000;
    ActivitySectionB1ABinding bi;
    DatabaseHelper db;
    int childSerial = 1;
    @BindViews({R.id.nw217y, R.id.nw217m, R.id.nw217d})
    List<EditText> grpDate;
    Calendar date = Calendar.getInstance();
    long yearsBydob;
    private Timer timer = new Timer();

    //static int status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_b1_a);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b1_a);
        ButterKnife.bind(this);
        db = new DatabaseHelper(this);
        bi.setCallback(this);
        setupViews();

        bi.textName.setText("Selected Woman : " + SectionB1Activity.wraName);
        bi.count.setText("Pregnancy No " + MainApp.count + " out of " + MainApp.totalPregnancy);

        for (EditText ed : grpDate) {
            ed.addTextChangedListener(this);
        }
        if (MainApp.flag) {
            Boolean type = getIntent().getExtras().getBoolean("type");
            String datey = getIntent().getExtras().getString("datey");
            String datem = getIntent().getExtras().getString("datem");
            String dated = getIntent().getExtras().getString("dated");

            if (type) {
                bi.nw217y.setText(datey);
                bi.nw217m.setText(datem);
                bi.nw217d.setText(dated);
                bi.nw218d.setChecked(true);
                bi.nw217y.setEnabled(false);
                bi.nw217d.setEnabled(false);
                bi.nw217m.setEnabled(false);
                bi.nw218a.setEnabled(false);
                bi.nw218b.setEnabled(false);
                bi.nw218c.setEnabled(false);
                bi.nw218e.setEnabled(false);
                bi.nw218f.setEnabled(false);
            } else {
                bi.nw217y.setText(null);
                bi.nw217d.setText(null);
                bi.nw217m.setText(null);
                bi.nw218d.setChecked(false);
                bi.nw217y.setEnabled(true);
                bi.nw217d.setText(null);
                bi.nw217m.setText(null);
                bi.nw218a.setEnabled(true);
                bi.nw218b.setEnabled(true);
                bi.nw218c.setEnabled(true);
                bi.nw218e.setEnabled(true);
                bi.nw218f.setEnabled(true);

            }
        }

    }

    public void setupViews() {

        //bi.nw217.setManager(getSupportFragmentManager());
        //bi.nw217.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));

        bi.nw220.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nw220a.isChecked()) {
                    clearClass.ClearAllFields(bi.fldGrpnw221, true);
                    clearClass.ClearAllFields(bi.fldGrpnw222, false);

                    clearClass.ClearAllFields(bi.fldGrnw221alive, true);
                    clearClass.ClearAllFields(bi.fldGrnw221death, false);
                    //bi.fldGrpnw221.setVisibility(View.VISIBLE);
                    /*bi.fldGrpnw222.setVisibility(View.GONE);
                    bi.nw222d.setText(null);
                    bi.nw222m.setText(null);
                    bi.nw222y.setText(null);*/

                } else {
                    clearClass.ClearAllFields(bi.fldGrpnw221, false);
                    clearClass.ClearAllFields(bi.fldGrpnw222, true);

                    clearClass.ClearAllFields(bi.fldGrnw221alive, false);
                    clearClass.ClearAllFields(bi.fldGrnw221death, true);
                    /*bi.fldGrpnw221.setVisibility(View.GONE);
                    bi.fldGrpnw222.setVisibility(View.VISIBLE);
                    bi.nw221d.setText(null);
                    bi.nw221m.setText(null);
                    bi.nw221y.setText(null);*/
                }
            }
        });

        bi.nw218.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nw218a.isChecked() || bi.nw218b.isChecked() || bi.nw218e.isChecked()) {
                    clearClass.ClearAllFields(bi.fldGrpnb1a03, false);
                    clearClass.ClearAllFields(bi.fldGrnw221alive, false);
                    clearClass.ClearAllFields(bi.fldGrnw221death, false);

                } else {
                    clearClass.ClearAllFields(bi.fldGrpnb1a03, true);
                    clearClass.ClearAllFields(bi.fldGrnw221alive, true);
                    clearClass.ClearAllFields(bi.fldGrnw221death, true);
                }

            }
        });


    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
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
                MainApp.nuCount = 1;
                //Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();
                finish();
                if (MainApp.outcome != 4) {
                    MainApp.count++;
                    if (MainApp.totalPregnancy >= MainApp.count) {
                        startActivity(new Intent(this, SectionB1AActivity.class).putExtra("type", false));
                    } else {

                        MainApp.count = 1;

                        if (yearsBydob <= 2 && MainApp.status > 0) {
                            startActivity(new Intent(this, SectionB2Activity.class));
                        } else {
                            if (SectionB1Activity.WRAcounter == MainApp.mwra.size()
                                    &&
                                    MainApp.B6Flag) {
                                startActivity(new Intent(this, SectionB6Activity.class));
                            } else {
                                startActivity(new Intent(this, MotherEndingActivity.class)
                                        .putExtra("complete", true));
                            }
                        }
                    }
                } else {

                    MainApp.outcome = 0;
                    MainApp.flag = true;
                    childSerial++;
                    Intent i = new Intent(this, SectionB1AActivity.class);
                    i.putExtra("datey", bi.nw217y.getText().toString());
                    i.putExtra("datem", bi.nw217m.getText().toString());
                    i.putExtra("dated", bi.nw217d.getText().toString());
                    i.putExtra("type", true);
                    startActivity(i);

                    //startActivity(new Intent(this, SectionB1Activity.class).putExtra(""));
                }


            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

        //startActivity(new Intent(this, SectionB2Activity.class));
    }

    public void BtnEnd() {
        MainApp.endActivityMother(this, this, false);

    }

    private boolean ValidateForm() {

        //Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyTextBox(this, bi.nw217d, getString(R.string.nw217))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nw217m, getString(R.string.nw217))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nw217y, getString(R.string.nw217))) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, bi.nw217d, 1, 31, 98, getString(R.string.nw217), " day")) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, bi.nw217m, 1, 12, 98, getString(R.string.nw217), " month")) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.nw217y, DateUtils.getCurrentYear() - 5, DateUtils.getCurrentYear(), getString(R.string.nw217), " years")) {
            return false;
        }

        Calendar today = Calendar.getInstance();
        if (date.after(today)) {
            if (!validatorClass.RangeTextBoxforDate(this, bi.nw217d, 1, DateUtils.getCurrentDate(), 98, "Date can not be more than today")) {
                return false;
            }

            if (!validatorClass.RangeTextBoxforDate(this, bi.nw217m, 1, DateUtils.getCurrentMonth(), 98, "Month can not be more than current month")) {
                return false;
            }

            if (!validatorClass.RangeTextBoxforDate(this, bi.nw217y, DateUtils.getCurrentYear() - 5, DateUtils.getCurrentYear(), "Year can not be more than current year")) {
                return false;
            }

        }


        if (!validatorClass.EmptyRadioButton(this, bi.nw218, bi.nw218a, getString(R.string.nw218))) {
            return false;
        }

        if (bi.nw218c.isChecked() || bi.nw218f.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.nw220, bi.nw220a, getString(R.string.nw220))) {
                return false;
            }

            if (bi.nw220a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nw221y, getString(R.string.nw221) + " - " + getString(R.string.year))) {
                    return false;
                }

                if (!validatorClass.EmptyTextBox(this, bi.nw221m, getString(R.string.nw221) + " - " + getString(R.string.month))) {
                    return false;
                }

                if (!validatorClass.EmptyTextBox(this, bi.nw221d, getString(R.string.nw221) + " - " + getString(R.string.day))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.nw221y, 0, 4, getString(R.string.nw221), " years")) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.nw221m, 0, 11, getString(R.string.nw221), " months")) {
                    return false;
                }


                if (!validatorClass.RangeTextBox(this, bi.nw221d, 0, 29, getString(R.string.nw221), " days")) {
                    return false;
                }

                if (bi.nw221y.getText().toString().equals("0") && bi.nw221m.getText().toString().equals("0") && bi.nw221d.getText().toString().equals("0")) {
                    Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nw221), Toast.LENGTH_LONG).show();
                    bi.nw221y.setError("All can not be zero");
                    bi.nw221m.setError("All can not be zero");
                    bi.nw221d.setError("All can not be zero");
                    Log.i(SectionA2Activity.class.getSimpleName(), "nw221" + ": This data is Required!");
                    return false;
                } else {
                    bi.nw221y.setError(null);
                    bi.nw221m.setError(null);
                    bi.nw221d.setError(null);
                }
            } else if (bi.nw220b.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nw222y, getString(R.string.nw222) + " - " + getString(R.string.year))) {
                    return false;
                }

                if (!validatorClass.EmptyTextBox(this, bi.nw222m, getString(R.string.nw222) + " - " + getString(R.string.month))) {
                    return false;
                }

                if (!validatorClass.EmptyTextBox(this, bi.nw222d, getString(R.string.nw222) + " - " + getString(R.string.day))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.nw222y, 0, 4, getString(R.string.nw222), " years")) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.nw222m, 0, 11, getString(R.string.nw222), " months")) {
                    return false;
                }


                if (!validatorClass.RangeTextBox(this, bi.nw222d, 0, 29, getString(R.string.nw222), " days")) {
                    return false;
                }

                if (bi.nw222y.getText().toString().equals("0") && bi.nw222m.getText().toString().equals("0") && bi.nw222d.getText().toString().equals("0")) {
                    Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nw222), Toast.LENGTH_LONG).show();
                    bi.nw222y.setError("All can not be zero");
                    bi.nw222m.setError("All can not be zero");
                    bi.nw222d.setError("All can not be zero");
                    Log.i(SectionA2Activity.class.getSimpleName(), "nw222" + ": This data is Required!");
                    return false;
                } else {
                    bi.nw222y.setError(null);
                    bi.nw222m.setError(null);
                    bi.nw222d.setError(null);
                }
            }
        }


        return true;
    }


    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();


        MainApp.oc = new OutcomeContract();

        MainApp.oc.setDevicetagID(MainApp.getTagName(this));
        MainApp.oc.setFormDate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(System.currentTimeMillis()));
        MainApp.oc.setUser(MainApp.userName);
        MainApp.oc.setDeviceId(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.oc.setApp_ver(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.oc.set_UUID(MainApp.mc.get_UID());


        JSONObject sB1a = new JSONObject();

        sB1a.put("nw217y", bi.nw217y.getText().toString());
        sB1a.put("nw217m", bi.nw217m.getText().toString());
        sB1a.put("nw217d", bi.nw217d.getText().toString());

        sB1a.put("nw218", bi.nw218a.isChecked() ? "1"
                : bi.nw218b.isChecked() ? "2"
                : bi.nw218c.isChecked() ? "3"
                : bi.nw218d.isChecked() ? "4"
                : bi.nw218e.isChecked() ? "5"
                : bi.nw218f.isChecked() ? "6"
                : "0");

        if (!MainApp.flag) {
            MainApp.outcome = bi.nw218.indexOfChild(findViewById(bi.nw218.getCheckedRadioButtonId())) + 1;
        }


        sB1a.put("nw220", bi.nw220a.isChecked() ? "1"
                : bi.nw220b.isChecked() ? "2"
                : "0");
        if (bi.nw218c.isChecked() || bi.nw218d.isChecked() || bi.nw218f.isChecked()) {
            MainApp.status++;
        }

        sB1a.put("nw219", String.valueOf(childSerial));
        sB1a.put("nw221y", bi.nw221y.getText().toString());
        sB1a.put("nw221m", bi.nw221m.getText().toString());
        sB1a.put("nw221d", bi.nw221d.getText().toString());

        sB1a.put("nw222y", bi.nw222y.getText().toString());
        sB1a.put("nw222m", bi.nw222m.getText().toString());
        sB1a.put("nw222d", bi.nw222d.getText().toString());

        MainApp.oc.setsB1A(String.valueOf(sB1a));


        //Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        Long updcount = db.addOutcome(MainApp.oc, 0);
        MainApp.oc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.oc.set_UID(
                    (MainApp.oc.getDeviceId() + MainApp.oc.get_ID()));
            db.updateOutcomeID();

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

        if (!bi.nw217y.getText().toString().isEmpty() && !bi.nw217m.getText().toString().isEmpty()
                && !bi.nw217d.getText().toString().isEmpty()) {
            if (!bi.nw217d.getText().toString().equals("98") && !bi.nw217m.getText().toString().equals("98")) {
                date = DateUtils.getCalendarDate(bi.nw217d.getText().toString(), bi.nw217m.getText().toString(), bi.nw217y.getText().toString());

                yearsBydob = DateUtils.ageInYearByDOB(date);

            } else {
                //date = bi.nw217d.getText().toString() + "-" bi.nw21
                yearsBydob = DateUtils.ageInYearByDOB(bi.nw217y.getText().toString());
            }


        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}

