package edu.aku.hassannaqvi.nns_2018.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindViews;
import butterknife.ButterKnife;
import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.DeceasedContract;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionH8Binding;
import edu.aku.hassannaqvi.nns_2018.other.DateUtils;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionH8Activity extends Activity implements TextWatcher {

    ActivitySectionH8Binding bi;
    static int counter = 1;
    static int deccounter = 0;
    @BindViews({R.id.nh808d, R.id.nh808m, R.id.nh808y})
    List<EditText> grpdob;

    Calendar dob = Calendar.getInstance();
    List<String> mothersList, fathersList;
    List<String> mothersSerials, fathersSerials;
    Map<String, String> mothersMap, fathersMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_h8);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h8);
        ButterKnife.bind(this);
        bi.setCallback(this);

        for (EditText ed : grpdob) {
            ed.addTextChangedListener(this);
        }

        // Setting dropdowns

        mothersList = new ArrayList<>();
        mothersSerials = new ArrayList<>();
        mothersMap = new HashMap<>();

        mothersList.add("....");
        mothersList.add("N/A");
        mothersSerials.add("0");
        mothersMap.put("N/A_0", "00");

        fathersList = new ArrayList<>();
        fathersSerials = new ArrayList<>();
        fathersMap = new HashMap<>();

        fathersList.add("....");
        fathersList.add("N/A");
        fathersSerials.add("0");
        fathersMap.put("N/A_0", "00");

        for (FamilyMembersContract mem : MainApp.members_f_m) {
            if (mem.getna204().equals("1")) {
                fathersList.add(mem.getName());
                fathersSerials.add(mem.getSerialNo());
                fathersMap.put(mem.getName() + "_" + mem.getSerialNo(), mem.getSerialNo());
            } else {
                mothersList.add(mem.getName());
                mothersSerials.add(mem.getSerialNo());
                mothersMap.put(mem.getName() + "_" + mem.getSerialNo(), mem.getSerialNo());
            }
        }

        bi.nh804.setAdapter(new ArrayAdapter<>(this, R.layout.item_style, mothersList));
        bi.nh805.setAdapter(new ArrayAdapter<>(this, R.layout.item_style, fathersList));


        bi.nh807y.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!bi.nh807y.getText().toString().isEmpty()) {
                    if (Integer.valueOf(bi.nh807y.getText().toString()) < 5) {
                        bi.fldGrpfid.setVisibility(View.VISIBLE);
                        bi.fldGrpmid.setVisibility(View.VISIBLE);
                    } else {
                        bi.fldGrpfid.setVisibility(View.GONE);
                        bi.fldGrpmid.setVisibility(View.GONE);
                        bi.nh804.setSelection(1);
                        bi.nh805.setSelection(1);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        bi.txtCounter.setText("Count " + counter + " out of " + SectionA5Activity.deceasedCounter);



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

                if (counter == SectionA5Activity.deceasedCounter) {
                    counter = 1;

                    if (MainApp.mwra.size() > 0) {
                        startActivity(new Intent(this, SectionB1Activity.class));
                    } else if (MainApp.childUnder5.size() > 0) {
                        if (MainApp.childUnder5.size() == MainApp.childNA.size()) {
                            SectionC1Activity.isNA = true;
                            startActivity(new Intent(this, SectionC1Activity.class));
                        } else {
                            SectionC1Activity.isNA = false;
                            startActivity(new Intent(this, SectionC1Activity.class));
                        }
                    }
                } else {
                    counter++;
                    startActivity(new Intent(this, SectionH8Activity.class));
                }

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }

    private boolean formValidation() {

        //Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyTextBox(this, bi.nh803, getString(R.string.nh803))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nh806, bi.nh806a, getString(R.string.nh806))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nh807d, getString(R.string.nh807))) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, bi.nh807d, 0, 29, getString(R.string.nh807), " days")) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nh807m, getString(R.string.nh807))) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, bi.nh807d, 0, 11, getString(R.string.nh807), " months")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.nh807y, getString(R.string.nh807))) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, bi.nh807y, 0, 95, getString(R.string.nh807), " years")) {
            return false;
        }


        if (bi.nh807y.getText().toString().equals("0") && bi.nh807m.getText().toString().equals("0")
                && bi.nh807d.getText().toString().equals("0")) {
            Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.na2age), Toast.LENGTH_LONG).show();
            bi.nh807y.setError("All can not be zero");
            bi.nh807m.setError("All can not be zero");
            bi.nh807d.setError("All can not be zero");
            Log.i(SectionH8Activity.class.getSimpleName(), "nh807" + ": This data is Required!");
        } else {
            bi.nh807y.setError(null);
            bi.nh807m.setError(null);
            bi.nh807d.setError(null);
        }


        if (Integer.valueOf(bi.nh807y.getText().toString()) < 5) {
            if (!validatorClass.EmptySpinner(this, bi.nh804, getString(R.string.nh804))) {
                return false;
            }

            if (!validatorClass.EmptySpinner(this, bi.nh805, getString(R.string.nh805))) {
                return false;
            }
        }

        if (!validatorClass.EmptyTextBox(this, bi.nh808y, getString(R.string.nh808))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nh808m, getString(R.string.nh808))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nh808d, getString(R.string.nh808))) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, bi.nh808y, DateUtils.getCurrentYear() - 5, DateUtils.getCurrentYear(), getString(R.string.nh808), " year")) {
            return false;
        }

        Calendar today = Calendar.getInstance();
        if (dob.after(today)) {
            if (!validatorClass.RangeTextBoxforDate(this, bi.nh808d, 1, DateUtils.getCurrentDate(), 98, "Date can not be more than today")) {
                return false;
            }

            if (!validatorClass.RangeTextBoxforDate(this, bi.nh808m, 1, DateUtils.getCurrentMonth(), 98, "Month can not be more than current Month")) {
                return false;
            }

            if (!validatorClass.RangeTextBoxforDate(this, bi.nh808y, DateUtils.getCurrentYear() - 5, DateUtils.getCurrentYear(), 9998, "Year can not be more than current year")) {
                return false;
            }

        }
        return validatorClass.EmptyTextBox(this, bi.nh809, getString(R.string.nh809));
    }

    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();


        MainApp.dc = new DeceasedContract();

        MainApp.dc.setDevicetagID(MainApp.getTagName(this));
        MainApp.dc.setFormDate(MainApp.fc.getFormDate());
        MainApp.dc.setUser(MainApp.userName);
        MainApp.dc.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID));
        MainApp.dc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.dc.setUUID(MainApp.fc.getUID());

        JSONObject sA2 = new JSONObject();


        sA2.put("nh803", bi.nh803.getText().toString());
        sA2.put("nh804", bi.nh804.getSelectedItem().toString());
        sA2.put("nh805", bi.nh805.getSelectedItem().toString());
        sA2.put("nh806", bi.nh806a.isChecked() ? "1" : bi.nh806b.isChecked() ? "2" : "0");
        sA2.put("nh807y", bi.nh807y.getText().toString());
        sA2.put("nh807m", bi.nh807m.getText().toString());
        sA2.put("nh807d", bi.nh807d.getText().toString());
        sA2.put("nh808d", bi.nh808d.getText().toString());
        sA2.put("nh808m", bi.nh808m.getText().toString());
        sA2.put("nh808y", bi.nh808y.getText().toString());
        sA2.put("nh809", bi.nh809.getText().toString());

        MainApp.dc.setsH8(String.valueOf(sA2));


        //Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        long updcount = db.addDeceasedMembers(MainApp.dc);

        MainApp.dc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.dc.setUID(
                    (MainApp.dc.getDeviceID() + MainApp.dc.get_ID()));
            db.updateDeceasedMemberID();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        if (!bi.nh808d.getText().toString().isEmpty() && !bi.nh808m.getText().toString().isEmpty() && !bi.nh808y.getText().toString().isEmpty()) {

            if (!bi.nh808d.getText().toString().equals("98")) {

                dob = DateUtils.getCalendarDate(bi.nh808d.getText().toString(), bi.nh808m.getText().toString(),
                        bi.nh808y.getText().toString());


            } else if (!bi.nh808d.getText().toString().equals("98")) {
                dob = DateUtils.getCalendarDate(bi.nh808m.getText().toString(),
                        bi.nh808y.getText().toString());
            }

        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
