package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import butterknife.BindViews;
import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.ChildContract;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionC1Binding;
import edu.aku.hassannaqvi.nns_2018.other.DateUtils;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionC1Activity extends AppCompatActivity implements TextWatcher {

    public static int counter = 1;
    public static int counterPerMom = 0;
    public static int counterPerNA = 0;
    public static String selectedChildName = "";
    public static boolean isNA;
    static List<String> childU5;
    static Map<String, FamilyMembersContract> childMap;
    private final long DELAY = 1000;
    Map<String, String> respMap;
    ArrayList<String> respName;
    ActivitySectionC1Binding binding;
    DatabaseHelper db;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    Boolean endflag = false;
    long agebyDob = 0;
    long ageInMontsbyDob = 0;
    Calendar dob = Calendar.getInstance();
    @BindViews({R.id.nc201d, R.id.nc201m, R.id.nc201y})
    List<EditText> grpDate;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_c1);
        db = new DatabaseHelper(this);
        respName = new ArrayList<>();
        respName.add("....");
        respMap = new HashMap<>();
        //childMap = new HashMap<>();

//        Assigning data to UI binding
        binding.setCallback(this);


//        Setup views
        if (getIntent().getBooleanExtra("childFlag", false)) {
            childU5.remove(getIntent().getStringExtra("name"));
            counter++;
        } else {

            counter = 1;
            counterPerMom = 0;
            counterPerNA = 0;

            childU5 = new ArrayList<>();
            childMap = new HashMap<>();

            childU5.add("....");

            if (isNA) {
                for (FamilyMembersContract fmc : MainApp.childNA) {
                    childMap.put(fmc.getName() + "-" + fmc.getSerialNo(), fmc);
                    childU5.add(fmc.getName() + "-" + fmc.getSerialNo());
                    counterPerNA++;
                }
            } else {
                for (FamilyMembersContract fmc : MainApp.childUnder5) {
                    if (fmc.getMotherId().equals(MainApp.mc.getB1SerialNo())) {
                        childMap.put(fmc.getName() + "-" + fmc.getSerialNo(), fmc);
                        childU5.add(fmc.getName() + "-" + fmc.getSerialNo());
                        counterPerMom++;
                    }
                }
            }
        }


        for (FamilyMembersContract fmc : MainApp.respList) {
            respName.add(fmc.getName() + "-" + fmc.getSerialNo());
            respMap.put(fmc.getName() + "-" + fmc.getSerialNo(), fmc.getSerialNo());
        }

        // setup head
        if (!isNA) {
            binding.txtCounter.setText("Count " + counter + " out of " + counterPerMom);
        } else {
            binding.txtCounter.setText("Count " + counter + " out of " + counterPerNA);
        }

        // setup spinner
        binding.nc101.setAdapter(new ArrayAdapter<>(this, R.layout.item_style, childU5));
        binding.resp.setAdapter(new ArrayAdapter<>(this, R.layout.item_style, respName));

        for (EditText ed : grpDate) {
            ed.addTextChangedListener(this);
        }
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }

    public void BtnContinue() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                //Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                if (Integer.valueOf(childMap.get(binding.nc101.getSelectedItem().toString()).getAgeInYear()) < 2) {
                    startActivity(new Intent(this, SectionC2Activity.class)
                            .putExtra("selectedChild", childMap.get(binding.nc101.getSelectedItem().toString())));
                } else {
                    startActivity(new Intent(this, SectionC3Activity.class)
                            .putExtra("selectedChild", childMap.get(binding.nc101.getSelectedItem().toString())));
                }

               /* startActivity(new Intent(this, SectionC5Activity.class)
                        .putExtra("selectedChild", childMap.get(binding.nc101.getSelectedItem().toString())));*/
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {

        endflag = true;
        if (formValidation()) {
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            //Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

            //finish();

            MainApp.endChildActivity(this, this, false);

        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
        }
    }

    private boolean formValidation() {
        //Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//        nc101

        if (endflag) {
            if (!validatorClass.EmptySpinner(this, binding.nc101, getString(R.string.nc101))) {
                return false;
            }
        } else {

            if (!validatorClass.EmptySpinner(this, binding.nc101, getString(R.string.nc101))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, binding.nc201d, getString(R.string.nc201))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, binding.nc201d, 1, 31, 98, getString(R.string.nc201), " days")) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, binding.nc201m, getString(R.string.nc201))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, binding.nc201m, 1, 12, getString(R.string.nc201), " months")) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, binding.nc201y, getString(R.string.nc201))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, binding.nc201y, DateUtils.getCurrentYear() - 5, DateUtils.getCurrentYear(), getString(R.string.nc201), " years")) {
                return false;
            }

            Calendar today = Calendar.getInstance();
            if (dob.after(today)) {
                if (!validatorClass.RangeTextBoxforDate(this, binding.nc201d, 1, DateUtils.getCurrentDate(), 98, "Date can not be more than today")) {
                    return false;
                }

                if (!validatorClass.RangeTextBoxforDate(this, binding.nc201m, 1, DateUtils.getCurrentMonth(), "Month can not be more than current month")) {
                    return false;
                }

                if (!validatorClass.RangeTextBoxforDate(this, binding.nc201y, DateUtils.getCurrentYear() - 5, DateUtils.getCurrentYear(), "Year can not be more than current year")) {
                    return false;
                }

            }

            if (!validatorClass.EmptyRadioButton(this, binding.nc202, binding.nc202a, getString(R.string.nc202))) {
                return false;
            }

            if (agebyDob < 1 && !binding.nc202a.isChecked()) {
                Toast.makeText(this, "ERROR(invalid): " + "Select correct option.. Age is less than 1 year" + getString(R.string.nc202), Toast.LENGTH_LONG).show();
                binding.nc202a.setError("Select correct option.. Age is less than 1 year");

                Log.i(SectionC1Activity.class.getSimpleName(), "nc202" + ": invalid");
                return false;
            } else {
                binding.nc202a.setError(null);
            }

            if ((agebyDob > 1 && agebyDob < 2) && !binding.nc202b.isChecked()) {
                Toast.makeText(this, "ERROR(invalid): " + "Select correct option.. Age is greater than 1 year" + getString(R.string.nc202), Toast.LENGTH_LONG).show();
                binding.nc202b.setError("Select correct option.. Age is greater than 1 year");

                Log.i(SectionC1Activity.class.getSimpleName(), "nc202" + ": invalid");
                return false;
            } else {
                binding.nc202b.setError(null);
            }

            if ((agebyDob >= 2 && agebyDob < 5) && !binding.nc202c.isChecked()) {
                Toast.makeText(this, "ERROR(invalid): " + "Select correct option.. Age is greater than 2 years" + getString(R.string.nc202), Toast.LENGTH_LONG).show();
                binding.nc202c.setError("Select correct option.. Age is greater than 2 years");

                Log.i(SectionC1Activity.class.getSimpleName(), "nc202" + ": invalid");
                return false;
            } else {
                binding.nc202c.setError(null);
            }

            if (!validatorClass.EmptyTextBox(this, binding.nc203, getString(R.string.nc203))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, binding.nc203, 0, 59, getString(R.string.nc203), " months")) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, binding.nc204a, binding.nc204aa, getString(R.string.nc204a))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, binding.nc204b, binding.nc204ba, getString(R.string.nc204b))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, binding.nc205, binding.nc205a, getString(R.string.nc205))) {
                return false;
            }



        }

        return true;

    }

    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        selectedChildName = binding.nc101.getSelectedItem().toString();

        MainApp.cc = new ChildContract();

        MainApp.cc.setDevicetagID(MainApp.getTagName(this));
        MainApp.cc.setFormDate(dtToday);
        MainApp.cc.setUser(MainApp.userName);
        MainApp.cc.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.cc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);

        if (childMap.get(binding.nc101.getSelectedItem().toString()).getMotherId().equals("00")) {
            MainApp.cc.setUUID(MainApp.fmc.get_UID());
        } else {
            MainApp.cc.setUUID(MainApp.mc.get_UID());
        }

        JSONObject sC1 = new JSONObject();

        sC1.put("respName", binding.resp.getSelectedItem().toString());
        sC1.put("respSerial", respMap.get(binding.resp.getSelectedItem().toString()));

//       nc101
        sC1.put("nc101", binding.nc101.getSelectedItem().toString());
//        nc103

        sC1.put("nc201d", binding.nc201d.getText().toString());
        sC1.put("nc201m", binding.nc201m.getText().toString());
        sC1.put("nc201y", binding.nc201y.getText().toString());


        sC1.put("nc202", binding.nc202a.isChecked() ? "1"
                : binding.nc202b.isChecked() ? "2"
                : binding.nc202c.isChecked() ? "3"
                : "0");

        sC1.put("nc203", binding.nc203.getText().toString());

        sC1.put("nc204a", binding.nc204aa.isChecked() ? "1"
                : binding.nc204ab.isChecked() ? "2"
                : "0");

        sC1.put("nc204b", binding.nc204ba.isChecked() ? "1"
                : binding.nc204bb.isChecked() ? "2"
                : "0");

        sC1.put("nc205", binding.nc205a.isChecked() ? "1"
                : binding.nc205b.isChecked() ? "2"
                : binding.nc20598.isChecked() ? "98"
                : "0");


        MainApp.cc.setsC1(String.valueOf(sC1));


    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        Long updcount = db.addChildForm(MainApp.cc);
        MainApp.cc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.cc.setUID(
                    (MainApp.cc.getDeviceID() + MainApp.cc.get_ID()));
            db.updateFormChildID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        if (!binding.nc201d.getText().toString().isEmpty()) {

            if (!binding.nc201d.getText().toString().equals("98")) {
                dob = DateUtils.getCalendarDate(binding.nc201d.getText().toString(),
                        binding.nc201m.getText().toString(), binding.nc201y.getText().toString());
                agebyDob = DateUtils.ageInYearByDOB(dob);
                ageInMontsbyDob = DateUtils.ageInMonthsByDOB(dob);
                binding.txtAge.setText("Current Age is : " + String.valueOf(ageInMontsbyDob) + "months");


            } else {
                dob = DateUtils.getCalendarDate(binding.nc201m.getText().toString(), binding.nc201y.getText().toString());
                agebyDob = DateUtils.ageInYearByDOB(dob);
                ageInMontsbyDob = DateUtils.ageInMonthsByDOB(dob);
                binding.txtAge.setText("Current Age is : " + String.valueOf(ageInMontsbyDob) + "months");

            }


        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
