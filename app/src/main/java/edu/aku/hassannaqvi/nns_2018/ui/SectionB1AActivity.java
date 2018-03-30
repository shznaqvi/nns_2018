package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
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
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionB1AActivity extends AppCompatActivity implements TextWatcher {

    private final long DELAY = 1000;
    ActivitySectionB1ABinding bi;
    DatabaseHelper db;
    int childSerial = 1;
    @BindViews({R.id.nw21702y, R.id.nw21702m, R.id.nw21702d})
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
        //setupViews();

        bi.count.setText("Pregnancy No " + MainApp.count + " out of " + MainApp.totalPregnancy);

        for (EditText ed : grpDate) {
            ed.addTextChangedListener(this);
        }

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


                if (MainApp.totalPregnancy >= MainApp.count) {
                    startActivity(new Intent(this, SectionB1AActivity.class));
                } else {

                    MainApp.count = 1;

                    if (SectionB1Activity.childCheck) {
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

/*
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
                    startActivity(i);

                    //startActivity(new Intent(this, SectionB1Activity.class).putExtra(""));
                }

*/

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


        if (!validatorClass.EmptyRadioButton(this, bi.nw21701, bi.nw21701a, getString(R.string.nw217))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nw21702y, getString(R.string.nw21702))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nw21702m, getString(R.string.nw21702))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nw21702d, getString(R.string.nw21702))) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, bi.nw21702d, 1, 31, 98, getString(R.string.nw21702), " day")) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, bi.nw21702m, 1, 12, 98, getString(R.string.nw21702), " month")) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.nw21702y, DateUtils.getCurrentYear() - 5, DateUtils.getCurrentYear(), getString(R.string.nw21702), " years")) {
            return false;
        }

        Calendar today = Calendar.getInstance();
        if (date.after(today)) {
            if (!validatorClass.RangeTextBoxforDate(this, bi.nw21702d, 1, DateUtils.getCurrentDate(), 98, "Date can not be more than today")) {
                return false;
            }

            if (!validatorClass.RangeTextBoxforDate(this, bi.nw21702m, 1, DateUtils.getCurrentMonth(), 98, "Month can not be more than current month")) {
                return false;
            }

            return validatorClass.RangeTextBoxforDate(this, bi.nw21702y, DateUtils.getCurrentYear() - 5, DateUtils.getCurrentYear(), "Year can not be more than current year");

        }



        return true;
    }


    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();


        MainApp.oc = new OutcomeContract();

        MainApp.oc.setDevicetagID(MainApp.getTagName(this));
        MainApp.oc.setFormDate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(System.currentTimeMillis()));
        MainApp.oc.setUser(MainApp.fc.getUser());
        MainApp.oc.setDeviceId(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.oc.setApp_ver(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.oc.set_UUID(MainApp.mc.get_UID());


        JSONObject sB1a = new JSONObject();

        sB1a.put("nw21701", bi.nw21701a.isChecked() ? "1" : bi.nw21701b.isChecked() ? "2" : "0");
        sB1a.put("nw21702y", bi.nw21702y.getText().toString());
        sB1a.put("nw21702m", bi.nw21702m.getText().toString());
        sB1a.put("nw21702d", bi.nw21702d.getText().toString());

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

        if (!bi.nw21702d.getText().toString().isEmpty() && !bi.nw21702m.getText().toString().isEmpty()
                && !bi.nw21702y.getText().toString().isEmpty()) {
            if (!bi.nw21702d.getText().toString().equals("98") && !bi.nw21702m.getText().toString().equals("98")) {
                date = DateUtils.getCalendarDate(bi.nw21702d.getText().toString(),
                        bi.nw21702m.getText().toString(), bi.nw21702y.getText().toString());

                yearsBydob = DateUtils.ageInYearByDOB(date);

            } else {

                yearsBydob = DateUtils.ageInYearByDOB(bi.nw21702y.getText().toString());
            }


        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}

