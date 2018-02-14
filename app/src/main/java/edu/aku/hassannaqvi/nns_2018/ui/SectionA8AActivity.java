package edu.aku.hassannaqvi.nns_2018.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.contracts.RecipientsContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionA8ABinding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionA8AActivity extends Activity {

    ActivitySectionA8ABinding bi;
    DatabaseHelper db;

    Map<String, FamilyMembersContract> recpmap;
    ArrayList<String> recpNames;

    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a8_a);
        db = new DatabaseHelper(this);
        bi.setCallback(this);

        recpmap = new HashMap<>();
        recpNames = new ArrayList<>();

        recpNames.add("....");

        for (byte i = 0; i < MainApp.members_f_m.size(); i++) {
            recpmap.put(MainApp.members_f_m.get(i).getName(), new FamilyMembersContract());
            recpNames.add(MainApp.members_f_m.get(i).getName());
        }


        bi.na8a02.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, recpNames));

        bi.na8a02.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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

                startActivity(new Intent(this, SectionB1Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

        //startActivity(new Intent(this, SectionB1Activity.class));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);

    }


    private boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptySpinner(this, bi.na8a02, getString(R.string.na8a02))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.na8a03y, getString(R.string.na8a03y))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.na8a03m, getString(R.string.na8a03m))) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, bi.na8a03m, 0, 11, getString(R.string.na8a03m), " months")) {
            return false;
        }

        if (bi.na8a03m.getText().toString().equals("0") && bi.na8a03m.getText().toString().equals("0")) {
            Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.na2age), Toast.LENGTH_LONG).show();
            bi.na8a03m.setError("All can not be zero");
            bi.na8a03y.setError("All can not be zero");
            Log.i(SectionA2Activity.class.getSimpleName(), "na803" + ": This data is Required!");
        } else {
            bi.na8a03y.setError(null);
            bi.na8a03m.setError(null);
        }

        if (!validatorClass.EmptyCheckBox(this, bi.fldGrpna08a04check, bi.na8a04a, getString(R.string.na8a04))) {
            return false;
        }

        if (!validatorClass.EmptyCheckBox(this, bi.fldGrpna08a04check, bi.na8a0496, bi.na8a0496x, getString(R.string.na8a04) + " - " + getString(R.string.other))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.na8a05, getString(R.string.na8a05))) {
            return false;
        }

        return validatorClass.EmptyTextBox(this, bi.na8a06, getString(R.string.na8a06));
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        MainApp.rc = new RecipientsContract();

        MainApp.rc.setDevicetagID(MainApp.getTagName(this));
        MainApp.rc.setFormDate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(System.currentTimeMillis()));
        MainApp.rc.setUser(MainApp.userName);
        MainApp.rc.setDeviceId(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.rc.setApp_ver(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.rc.set_UUID(MainApp.fmc.get_UID());

        JSONObject sA8a = new JSONObject();

        sA8a.put("na8a02", bi.na8a02.getSelectedItem().toString());

        sA8a.put("na8a03y", bi.na8a03y.getText().toString());

        sA8a.put("na8a03m", bi.na8a03m.getText().toString());

        sA8a.put("na8a04a", bi.na8a04a.isChecked() ? "1" : "0");
        sA8a.put("na8a04b", bi.na8a04b.isChecked() ? "2" : "0");
        sA8a.put("na8a04c", bi.na8a04c.isChecked() ? "3" : "0");
        sA8a.put("na8a04d", bi.na8a04d.isChecked() ? "4" : "0");
        sA8a.put("na8a04e", bi.na8a04e.isChecked() ? "5" : "0");
        sA8a.put("na8a04f", bi.na8a04f.isChecked() ? "6" : "0");
        sA8a.put("na8a04g", bi.na8a04g.isChecked() ? "7" : "0");
        sA8a.put("na8a04h", bi.na8a04h.isChecked() ? "8" : "0");
        sA8a.put("na8a04i", bi.na8a04i.isChecked() ? "9" : "0");
        sA8a.put("na8a0496", bi.na8a0496.isChecked() ? "96" : "0");
        sA8a.put("na8a0496x", bi.na8a0496x.getText().toString());
        sA8a.put("na8a05", bi.na8a05.getText().toString());
        sA8a.put("na8a06", bi.na8a06.getText().toString());


        MainApp.rc.setsA8A(String.valueOf(sA8a));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        Long updcount = db.addRecipient(MainApp.rc);
        MainApp.rc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.rc.set_UID(
                    (MainApp.rc.getDeviceId() + MainApp.rc.get_ID()));
            db.updateRecepientID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

        //return true;

    }



}
