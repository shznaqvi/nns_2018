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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.FamilyMembers;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.Recipients;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionA8ABinding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionA8AActivity extends Activity {

    static int counter = 1;
    static int reccounter = 0;
    static Map<String, FamilyMembers> recpmap;
    static ArrayList<String> recpNames;
    static ArrayList<String> recpSerial;
    private final long DELAY = 1000;
    ActivitySectionA8ABinding bi;
    DatabaseHelper db;
    //FamilyMembersContract fmcSelected;
    FamilyMembers fmcSelected;

    int position = 0;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a8_a);
        db = new DatabaseHelper(this);
        bi.setCallback(this);

        if (getIntent().getBooleanExtra("flag", true)) {
            reccounter = getIntent().getIntExtra("recCounter", 0);

            recpmap = new HashMap<>();
            recpNames = new ArrayList<>();
            recpSerial = new ArrayList<>();

            recpNames.add("....");
            recpSerial.add("0");


            for (FamilyMembers fmc : MainApp.all_members) {
                recpmap.put(fmc.getName() + "_" + fmc.getSerialNo(), fmc);
                recpNames.add(fmc.getName());
                recpSerial.add(fmc.getSerialNo());
            }

        } else {
            counter++;

        }

        bi.nh7a02.setAdapter(new ArrayAdapter<>(this, R.layout.item_style, recpNames));

        bi.nh7a02.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
                Log.d("For Debug", "Position selected is: " + position);
                try {
                    if (position != 0) {

                        fmcSelected = recpmap.get(recpNames.get(position) + "_" + recpSerial.get(position));
                    }
                } catch (Exception e) {
                    Log.e("Error", "There is an error while selecting name from spinner: " + e);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // setup head
        bi.txtCounter.setText("Count " + counter + " out of " + reccounter);

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
                //Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                if (counter == reccounter) {

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
                    } else {
                        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
                    }
                } else {

                    recpNames.remove(bi.nh7a02.getSelectedItem().toString());
                    recpSerial.remove(recpSerial.get(position));

                    startActivity(new Intent(this, SectionA8AActivity.class).putExtra("flag", false));
                }


            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }


    private boolean ValidateForm() {

        //Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptySpinner(this, bi.nh7a02, getString(R.string.nh7a02))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nh7a03y, getString(R.string.nh7a03y))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nh7a03m, getString(R.string.nh7a03m))) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, bi.nh7a03m, 0, 11, getString(R.string.nh7a03m), " months")) {
            return false;
        }

        if (bi.nh7a03m.getText().toString().equals("0") && bi.nh7a03m.getText().toString().equals("0")) {
            Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.na2age), Toast.LENGTH_LONG).show();
            bi.nh7a03m.setError("All can not be zero");
            bi.nh7a03y.setError("All can not be zero");
            Log.i(SectionA2Activity.class.getSimpleName(), "nh703" + ": This data is Required!");
        } else {
            bi.nh7a03y.setError(null);
            bi.nh7a03m.setError(null);
        }

        if (!validatorClass.EmptyCheckBox(this, bi.fldGrpna08a04check, bi.nh7a04a, getString(R.string.nh7a04))) {
            return false;
        }

        if (!validatorClass.EmptyCheckBox(this, bi.fldGrpna08a04check, bi.nh7a0496, bi.nh7a0496x, getString(R.string.nh7a04) + " - " + getString(R.string.other))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.nh7a05, getString(R.string.nh7a05))) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, bi.nh7a05, 1000, 99999, getString(R.string.nh7a05), " Rupees")) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nh7a06, getString(R.string.nh7a06))) {
            return false;
        }

        return validatorClass.RangeTextBox(this, bi.nh7a06, 0, Integer.valueOf(bi.nh7a05.getText().toString()), getString(R.string.nh7a06), " Rupees");
    }

    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        MainApp.rc = new Recipients();

        MainApp.rc.setDevicetagid(MainApp.getTagName(this));
        MainApp.rc.setFormdate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(System.currentTimeMillis()));
        MainApp.rc.setUser(MainApp.userName);
        MainApp.rc.setDeviceid(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.rc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.rc.set_uuid(fmcSelected.get_uid());


        MainApp.rc.setNh7a01(fmcSelected.getName());
        MainApp.rc.setNh7a01Serial(fmcSelected.getSerialNo());

        MainApp.rc.setNh7a02(bi.nh7a02.getSelectedItem().toString());
        //sA8a.put("nh7a02", bi.nh7a02.getText().toString());

        MainApp.rc.setNh7a03y(bi.nh7a03y.getText().toString());

        MainApp.rc.setNh7a03m(bi.nh7a03m.getText().toString());

        MainApp.rc.setNh7a04a(bi.nh7a04a.isChecked() ? "1" : "0");
        MainApp.rc.setNh7a04b(bi.nh7a04b.isChecked() ? "2" : "0");
        MainApp.rc.setNh7a04c(bi.nh7a04c.isChecked() ? "3" : "0");
        MainApp.rc.setNh7a04d(bi.nh7a04d.isChecked() ? "4" : "0");
        MainApp.rc.setNh7a04e(bi.nh7a04e.isChecked() ? "5" : "0");
        MainApp.rc.setNh7a04f(bi.nh7a04f.isChecked() ? "6" : "0");
        MainApp.rc.setNh7a04g(bi.nh7a04g.isChecked() ? "7" : "0");
        MainApp.rc.setNh7a04h(bi.nh7a04h.isChecked() ? "8" : "0");
        MainApp.rc.setNh7a04i(bi.nh7a04i.isChecked() ? "9" : "0");
        MainApp.rc.setNh7a0496(bi.nh7a0496.isChecked() ? "96" : "0");
        MainApp.rc.setNh7a0496x(bi.nh7a0496x.getText().toString());
        MainApp.rc.setNh7a05(bi.nh7a05.getText().toString());
        MainApp.rc.setNh7a06(bi.nh7a06.getText().toString());



        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        //Long updcount = db.addRecipient(MainApp.rc);
        Long updcount = MainApp.rc.insert();
        //MainApp.rc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.rc.set_uid(
                    (MainApp.rc.getDeviceid() + MainApp.rc._id));
            //db.updateRecepientID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

        //return true;

    }


}
