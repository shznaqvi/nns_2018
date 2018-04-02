package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindViews;
import butterknife.ButterKnife;
import edu.aku.hassannaqvi.nns_2018.JSONModels.JSONB1AModelClass;
import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.OutcomeContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB1ABinding;
import edu.aku.hassannaqvi.nns_2018.other.DateUtils;
import edu.aku.hassannaqvi.nns_2018.other.JSONUtilClass;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionB1AActivity extends AppCompatActivity implements TextWatcher, RadioGroup.OnCheckedChangeListener {

    private final long DELAY = 1000;
    ActivitySectionB1ABinding bi;
    DatabaseHelper db;
    int childSerial = 1;
    @BindViews({R.id.nw21702y, R.id.nw21702m, R.id.nw21702d})
    List<EditText> grpDate;
    Calendar date = Calendar.getInstance();
    long yearsBydob;
    Boolean firstTimePressed = false;
    Boolean backPressed = false;
    Boolean frontPressed = false;
    String uid = "";
    OutcomeContract outcomeCC;
    private Timer timer = new Timer();

    String classPassName = "";


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

/*        if (getIntent().getBooleanExtra("backPressed", false)) {
            frontPressed = true;*/

        Collection<OutcomeContract> outcomeContracts = db.getPressedOutcome();

        for (OutcomeContract outcomeContract : outcomeContracts) {
            JSONB1AModelClass jsonB1A = JSONUtilClass.getModelFromJSON(outcomeContract.getsB1A(), JSONB1AModelClass.class);

            if (jsonB1A.getSerial().equals(String.valueOf(MainApp.count))) {

                frontPressed = true;

                outcomeCC = outcomeContract;


                if (!jsonB1A.getnw21701().equals("0")) {
                    bi.nw21701.check(
                            jsonB1A.getnw21701().equals("1") ? bi.nw21701a.getId() :
                                    bi.nw21701b.getId()
                    );
                }

                bi.nw21702y.setText(jsonB1A.getnw21702y());
                bi.nw21702m.setText(jsonB1A.getnw21702m());
                bi.nw21702d.setText(jsonB1A.getnw21702d());
            }

        }

        bi.nw21701.setOnCheckedChangeListener(this);



    }


    public void BtnContinue() {
        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                MainApp.nuCount = 1;

                MainApp.count++;
                if (MainApp.count > MainApp.totalPregnancy) {

                    MainApp.count = 1;

                    if (SectionB1Activity.childCheck) {
                        startActivity(new Intent(this, SectionB2Activity.class));
                    } else {
                        if (SectionB1Activity.WRAcounter == MainApp.mwra.size()
                                &&
                                MainApp.B6Flag) {
                            startActivityForResult(new Intent(this, SectionB6Activity.class)
                                    .putExtra("backPressed", classPassName.equals(SectionB6Activity.class.getName())), 1);
                        } else {
                            startActivity(new Intent(this, MotherEndingActivity.class)
                                    .putExtra("complete", true));
                        }
                    }

                } else {

                    //MainApp.count ++;
                    startActivityForResult(new Intent(this, SectionB1AActivity.class)
                            .putExtra("backPressed", classPassName.equals(SectionB1AActivity.class.getName())), 1);
                }



            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
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

        if (!validatorClass.RangeTextBox(this, bi.nw21702y, DateUtils.getCurrentYear() - 5, DateUtils.getCurrentYear(), getString(R.string.nw21702), " years")) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, bi.nw21702m, 1, 12, 98, getString(R.string.nw21702), " month")) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, bi.nw21702d, 1, 31, 98, getString(R.string.nw21702), " day")) {
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

        MainApp.oc = new OutcomeContract();

        if (!backPressed && !frontPressed) {
            MainApp.oc.setDevicetagID(MainApp.getTagName(this));
            MainApp.oc.setFormDate(MainApp.fc.getFormDate());
            MainApp.oc.setUser(MainApp.userName);
            MainApp.oc.setDeviceId(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                    Settings.Secure.ANDROID_ID));
            MainApp.oc.setApp_ver(MainApp.versionName + "." + MainApp.versionCode);
            MainApp.oc.set_UUID(MainApp.mc.get_UID());
        } else {
            MainApp.oc.setUpdatedate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(System.currentTimeMillis()));

            if (frontPressed) {
                MainApp.oc.set_UID(outcomeCC.get_UID());
            } else if (backPressed) {
                MainApp.oc.set_UID(uid);
            }
        }

        JSONObject sB1a = new JSONObject();

        sB1a.put("enmno", MainApp.fc.getClusterNo());
        sB1a.put("hhno", MainApp.fc.getHhNo());

        sB1a.put("serial", Integer.valueOf(MainApp.count));
        sB1a.put("nw21701", bi.nw21701a.isChecked() ? "1" : bi.nw21701b.isChecked() ? "2" : "0");
        sB1a.put("nw21702y", bi.nw21702y.getText().toString());
        sB1a.put("nw21702m", bi.nw21702m.getText().toString());
        sB1a.put("nw21702d", bi.nw21702d.getText().toString());

        if (backPressed) {
            sB1a.put("backPressed", backPressed);
        } else if (frontPressed) {
            sB1a.put("frontPressed", frontPressed);
        }

        MainApp.oc.setsB1A(String.valueOf(sB1a));
    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        if (!backPressed && !frontPressed) {
            Long updcount = db.addOutcome(MainApp.oc, 0);
            MainApp.oc.set_ID(String.valueOf(updcount));

            if (updcount != 0) {
                MainApp.oc.set_UID(
                        (MainApp.oc.getDeviceId() + MainApp.oc.get_ID()));
                db.updateOutcomeID();

                uid = MainApp.oc.getDeviceId() + MainApp.oc.get_ID();

                return true;
            } else {
                Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            db.addOutcome(MainApp.oc, 1);

            return true;
        }
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

        timer.cancel();
        timer = new Timer();
        timer.schedule(
                new TimerTask() {
                    @Override
                    public void run() {

                        SectionB1AActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                ValidateForm();
                            }
                            //}
                        });

                    }
                },
                DELAY
        );


    }

    @Override
    protected void onResume() {
        super.onResume();

        if (firstTimePressed) {
            backPressed = true;
        }

        firstTimePressed = true;
    }


    @Override
    protected void onPause() {
        super.onPause();

        if (!backPressed) {
            firstTimePressed = false;
        }
    }


    @Override
    public void onBackPressed() {

        try {
            SaveDraft();
            UpdateDB();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        MainApp.count--;

        Intent intent = new Intent();
        intent.putExtra("backPressedClass", SectionB1AActivity.class.getName());
        setResult(RESULT_OK, intent);

        super.onBackPressed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                classPassName = data.getStringExtra("backPressedClass");
            } else {
                classPassName = "";
            }
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        ValidateForm();

    }
}

