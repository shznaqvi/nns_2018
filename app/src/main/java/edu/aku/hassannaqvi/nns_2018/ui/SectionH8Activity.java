package edu.aku.hassannaqvi.nns_2018.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.DeceasedContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionH8Binding;
import edu.aku.hassannaqvi.nns_2018.other.DateUtils;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionH8Activity extends Activity implements TextWatcher {

    ActivitySectionH8Binding bi;
    @BindViews({R.id.nh808d, R.id.nh808m, R.id.nh808y})
    List<EditText> grpdob;

    Calendar dob = Calendar.getInstance();

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

                //if (flag) {
                //  startActivity(new Intent(this, SectionA2ListActivity.class));
                //} else {
                /*startActivity(new Intent(this, SectionA2ListActivity.class)
                        .putExtra("respChecking", binding.respa.isChecked())
                        .putExtra("respLineNo", MainApp.fmc.getSerialNo()));*/
                //}


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

        if (!validatorClass.EmptyRadioButton(this, bi.nh801, bi.nh801a, getString(R.string.nh801))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nh802, getString(R.string.nh802))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nh803, getString(R.string.nh803))) {
            return false;
        }


        if (!validatorClass.EmptySpinner(this, bi.nh804, getString(R.string.nh804))) {
            return false;
        }

        if (!validatorClass.EmptySpinner(this, bi.nh805, getString(R.string.nh805))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nh806, bi.nh806a, getString(R.string.nh806))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nh807, getString(R.string.nh807))) {
            return false;
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

        sA2.put("nh801", bi.nh801a.isChecked() ? "1" : bi.nh801b.isChecked() ? "2" : "0");
        sA2.put("nh802", bi.nh802.getText().toString());
        sA2.put("nh803", bi.nh803.getText().toString());
        sA2.put("nh804", bi.nh804.getSelectedItem().toString());
        sA2.put("nh805", bi.nh805.getSelectedItem().toString());
        sA2.put("nh806", bi.nh806a.isChecked() ? "1" : bi.nh806b.isChecked() ? "2" : "0");
        sA2.put("nh807", bi.nh807.getText().toString());
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
