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
    @BindViews({R.id.nw215y, R.id.nw215m, R.id.nw215d})
    List<EditText> grpDate;
    String date;
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
                bi.nw215y.setText(datey);
                bi.nw215m.setText(datem);
                bi.nw215d.setText(dated);
                bi.nw216d.setChecked(true);
                bi.nw215y.setEnabled(false);
                bi.nw215d.setEnabled(false);
                bi.nw215m.setEnabled(false);
                bi.nw216a.setEnabled(false);
                bi.nw216b.setEnabled(false);
                bi.nw216c.setEnabled(false);
                bi.nw216e.setEnabled(false);
                bi.nw216f.setEnabled(false);
            } else {
                bi.nw215y.setText(null);
                bi.nw215d.setText(null);
                bi.nw215m.setText(null);
                bi.nw216d.setChecked(false);
                bi.nw215y.setEnabled(true);
                bi.nw215d.setText(null);
                bi.nw215m.setText(null);
                bi.nw216a.setEnabled(true);
                bi.nw216b.setEnabled(true);
                bi.nw216c.setEnabled(true);
                bi.nw216e.setEnabled(true);
                bi.nw216f.setEnabled(true);

            }
        }

    }

    public void setupViews() {

        //bi.nw215.setManager(getSupportFragmentManager());
        //bi.nw215.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));

        bi.nw217.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nw217a.isChecked()) {
                    clearClass.ClearAllFields(bi.fldGrpnw219, true);
                    clearClass.ClearAllFields(bi.fldGrpnw220, false);

                    clearClass.ClearAllFields(bi.fldGrnw219alive, true);
                    clearClass.ClearAllFields(bi.fldGrnw219death, false);
                    //bi.fldGrpnw219.setVisibility(View.VISIBLE);
                    /*bi.fldGrpnw220.setVisibility(View.GONE);
                    bi.nw220d.setText(null);
                    bi.nw220m.setText(null);
                    bi.nw220y.setText(null);*/

                } else {
                    clearClass.ClearAllFields(bi.fldGrpnw219, false);
                    clearClass.ClearAllFields(bi.fldGrpnw220, true);

                    clearClass.ClearAllFields(bi.fldGrnw219alive, false);
                    clearClass.ClearAllFields(bi.fldGrnw219death, true);
                    /*bi.fldGrpnw219.setVisibility(View.GONE);
                    bi.fldGrpnw220.setVisibility(View.VISIBLE);
                    bi.nw219d.setText(null);
                    bi.nw219m.setText(null);
                    bi.nw219y.setText(null);*/
                }
            }
        });

        bi.nw216.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nw216a.isChecked() || bi.nw216b.isChecked() || bi.nw216e.isChecked()) {
                    clearClass.ClearAllFields(bi.fldGrpnb1a03, false);
                    clearClass.ClearAllFields(bi.fldGrnw219alive, false);
                    clearClass.ClearAllFields(bi.fldGrnw219death, false);

                } else {
                    clearClass.ClearAllFields(bi.fldGrpnb1a03, true);
                    clearClass.ClearAllFields(bi.fldGrnw219alive, true);
                    clearClass.ClearAllFields(bi.fldGrnw219death, true);
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
                        if (yearsBydob <= 2 && MainApp.status > 0) {
                            startActivity(new Intent(this, SectionB2Activity.class));
                        } else {
                            startActivity(new Intent(this, SectionB6Activity.class));
                        }
                    }
                } else {

                    MainApp.outcome = 0;
                    MainApp.flag = true;
                    childSerial++;
                    Intent i = new Intent(this, SectionB1AActivity.class);
                    i.putExtra("datey", bi.nw215y.getText().toString());
                    i.putExtra("datem", bi.nw215m.getText().toString());
                    i.putExtra("dated", bi.nw215d.getText().toString());
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

        if (!validatorClass.EmptyTextBox(this, bi.nw215d, getString(R.string.nw215))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nw215m, getString(R.string.nw215))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nw215y, getString(R.string.nw215))) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, bi.nw215d, 1, 31, 98, getString(R.string.nw215), " day")) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, bi.nw215m, 1, 12, 98, getString(R.string.nw215), " month")) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.nw215y, 2013, 2018, getString(R.string.nw215), " year")) {
            return false;
        }



        if (!validatorClass.EmptyRadioButton(this, bi.nw216, bi.nw216a, getString(R.string.nw216))) {
            return false;
        }

        if (bi.nw216c.isChecked() || bi.nw216f.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.nw217, bi.nw217a, getString(R.string.nw217))) {
                return false;
            }

            if (bi.nw217a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nw219y, getString(R.string.nw219) + " - " + getString(R.string.year))) {
                    return false;
                }

                if (!validatorClass.EmptyTextBox(this, bi.nw219m, getString(R.string.nw219) + " - " + getString(R.string.month))) {
                    return false;
                }

                if (!validatorClass.EmptyTextBox(this, bi.nw219d, getString(R.string.nw219) + " - " + getString(R.string.day))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.nw219y, 0, 4, getString(R.string.nw219), " years")) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.nw219m, 0, 11, getString(R.string.nw219), " months")) {
                    return false;
                }


                if (!validatorClass.RangeTextBox(this, bi.nw219d, 0, 29, getString(R.string.nw219), " days")) {
                    return false;
                }

                if (bi.nw219y.getText().toString().equals("0") && bi.nw219m.getText().toString().equals("0") && bi.nw219d.getText().toString().equals("0")) {
                    Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nw219), Toast.LENGTH_LONG).show();
                    bi.nw219y.setError("All can not be zero");
                    bi.nw219m.setError("All can not be zero");
                    bi.nw219d.setError("All can not be zero");
                    Log.i(SectionA2Activity.class.getSimpleName(), "nw219" + ": This data is Required!");
                } else {
                    bi.nw219y.setError(null);
                    bi.nw219m.setError(null);
                    bi.nw219d.setError(null);
                }
            } else if (bi.nw217b.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nw220y, getString(R.string.nw220) + " - " + getString(R.string.year))) {
                    return false;
                }

                if (!validatorClass.EmptyTextBox(this, bi.nw220m, getString(R.string.nw220) + " - " + getString(R.string.month))) {
                    return false;
                }

                if (!validatorClass.EmptyTextBox(this, bi.nw220d, getString(R.string.nw220) + " - " + getString(R.string.day))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.nw220y, 0, 4, getString(R.string.nw220), " years")) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.nw220m, 0, 11, getString(R.string.nw220), " months")) {
                    return false;
                }


                if (!validatorClass.RangeTextBox(this, bi.nw220d, 0, 29, getString(R.string.nw220), " days")) {
                    return false;
                }

                if (bi.nw220y.getText().toString().equals("0") && bi.nw220m.getText().toString().equals("0") && bi.nw220d.getText().toString().equals("0")) {
                    Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nw220), Toast.LENGTH_LONG).show();
                    bi.nw220y.setError("All can not be zero");
                    bi.nw220m.setError("All can not be zero");
                    bi.nw220d.setError("All can not be zero");
                    Log.i(SectionA2Activity.class.getSimpleName(), "nw220" + ": This data is Required!");
                } else {
                    bi.nw220y.setError(null);
                    bi.nw220m.setError(null);
                    bi.nw220d.setError(null);
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

        sB1a.put("nw215y", bi.nw215y.getText().toString());
        sB1a.put("nw215m", bi.nw215m.getText().toString());
        sB1a.put("nw215d", bi.nw215d.getText().toString());

        sB1a.put("nw216", bi.nw216a.isChecked() ? "1"
                : bi.nw216b.isChecked() ? "2"
                : bi.nw216c.isChecked() ? "3"
                : bi.nw216d.isChecked() ? "4"
                : bi.nw216e.isChecked() ? "5"
                : bi.nw216f.isChecked() ? "6"
                : "0");

        if (!MainApp.flag) {
            MainApp.outcome = bi.nw216.indexOfChild(findViewById(bi.nw216.getCheckedRadioButtonId())) + 1;
        }


        sB1a.put("nw217", bi.nw217a.isChecked() ? "1"
                : bi.nw217b.isChecked() ? "2"
                : "0");
        if (bi.nw217a.isChecked()) {
            MainApp.status++;
        }

        sB1a.put("nw218", String.valueOf(childSerial));
        sB1a.put("nw219y", bi.nw219y.getText().toString());
        sB1a.put("nw219m", bi.nw219m.getText().toString());
        sB1a.put("nw219d", bi.nw219d.getText().toString());

        sB1a.put("nw220y", bi.nw220y.getText().toString());
        sB1a.put("nw220m", bi.nw220m.getText().toString());
        sB1a.put("nw220d", bi.nw220d.getText().toString());

        MainApp.oc.setsB1A(String.valueOf(sB1a));


        //Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        Long updcount = db.addOutcome(MainApp.oc);
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

        if (!bi.nw215y.getText().toString().isEmpty() && !bi.nw215m.getText().toString().isEmpty()
                && !bi.nw215d.getText().toString().isEmpty()) {
            if (bi.nw215d.getText().toString().equals("98") && !bi.nw215m.getText().toString().equals("98")) {
                date = "%02d" + bi.nw215d.getText().toString() + "-" + "%02d" + bi.nw215m.getText().toString()
                        + "-" + bi.nw215y.getText().toString();

                yearsBydob = DateUtils.ageInYearByDOB(DateUtils.getCalendarDate(date));

            } else {
                //date = bi.nw215d.getText().toString() + "-" bi.nw21
                yearsBydob = DateUtils.ageInYearByDOB(bi.nw215y.getText().toString());
            }


        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}

