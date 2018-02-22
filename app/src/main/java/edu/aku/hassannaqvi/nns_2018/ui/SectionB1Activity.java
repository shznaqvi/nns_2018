package edu.aku.hassannaqvi.nns_2018.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.contracts.MWRAContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB1Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

import static android.view.View.GONE;

public class SectionB1Activity extends Activity {

    static ArrayList<String> respName;
    static ArrayList<String> respSerial;
    ActivitySectionB1Binding bi;
    DatabaseHelper db;
    ArrayList<String> lstMwra;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_b1);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b1);
        db = new DatabaseHelper(this);
        lstMwra = new ArrayList<>();

        MainApp.mwraMap.put("....", "");
        lstMwra.add("....");
        respName = new ArrayList<>();
        respSerial = new ArrayList<>();
        respName.add("....");
        //respSerial.

        //Assigning data to UI binding
        bi.setCallback(this);

        setupViews();
    }

    public void setupViews() {

        bi.nw204.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (bi.nw204.getText().toString().equals("0")) {
                    bi.fldGrpnw205.setVisibility(GONE);
                    bi.nw207.clearCheck();
                    bi.nw206.setText(null);
                } else {
                    bi.fldGrpnw205.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        for (FamilyMembersContract fmc : MainApp.members_f_m) {

            respName.add(fmc.getName());
            respSerial.add(fmc.getSerialNo());
        }


        for (byte i = 0; i < MainApp.mwra.size(); i++) {
            MainApp.mwraMap.put(MainApp.mwra.get(i).getName(), MainApp.mwra.get(i).getSerialNo());
            lstMwra.add(MainApp.mwra.get(i).getName());
        }


        bi.nb101.setAdapter(new ArrayAdapter<>(this, R.layout.item_style, lstMwra));
        bi.resp.setAdapter(new ArrayAdapter<>(this, R.layout.item_style, respName));

        bi.nb101.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                position = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bi.resp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                position = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bi.nw207.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.nw207b) {
            bi.fldGrpnw208.setVisibility(GONE);
            bi.nw208.clearCheck();
            bi.nw20901.clearCheck();
            bi.nw20902.clearCheck();
            bi.nw20903.clearCheck();
            bi.nw20999.clearCheck();
            bi.nw20998.clearCheck();

        }
        else{
            bi.fldGrpnw208.setVisibility(View.VISIBLE);
        }

    }
});
        bi.nw20998.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.nw20998a) {
            bi.nw208.clearCheck();
            bi.nw20901.clearCheck();
            bi.nw20902.clearCheck();
            bi.nw20903.clearCheck();
            bi.nw20999.clearCheck();

            bi.nw20901.setEnabled(false);
            bi.nw20902.setEnabled(false);
            bi.nw20903.setEnabled(false);
            bi.nw20999.setEnabled(false);
        }
        else{
            bi.nw20901.setEnabled(true);
            bi.nw20902.setEnabled(true);
            bi.nw20903.setEnabled(true);
            bi.nw20999.setEnabled(true);
        }
    }
});
        bi.nw20999.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.nw20998a) {
            bi.nw20998.clearCheck();
            bi.nw20901.clearCheck();
            bi.nw20902.clearCheck();
            bi.nw20903.clearCheck();
        }
    }
});


        bi.nw208.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.nw208b) {
            bi.fldGrpnw209.setVisibility(View.GONE);
            bi.nw20901.clearCheck();
            bi.nw20902.clearCheck();
            bi.nw20903.clearCheck();
            bi.nw20998.clearCheck();
            bi.nw20999.clearCheck();
        }else{
            bi.fldGrpnw209.setVisibility(View.VISIBLE);

        }
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

                if (MainApp.totalPregnancy > 0) {

                    startActivity(new Intent(this, SectionB1AActivity.class));
                } else if (MainApp.totalPregnancy == 1 && bi.nw207a.isChecked()) {
                    startActivity(new Intent(this, SectionB2Activity.class));
                } else if (MainApp.totalPregnancy == 0) {
                    startActivity(new Intent(this, SectionB6Activity.class));
                }

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

        //startActivity(new Intent(this, SectionB1AActivity.class));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);

    }

    private boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();


        if (!validatorClass.EmptySpinner(this, bi.resp, getString(R.string.na107))) {
            return false;
        }

        if (!validatorClass.EmptySpinner(this, bi.nb101, getString(R.string.nb101))) {
            return false;
        }

        if (!bi.nb101.getSelectedItem().toString().equals(bi.resp.getSelectedItem().toString())) {
            Toast.makeText(this, "ERROR(invalid): " + "Respondent should be same as Selected Woman" + getString(R.string.nb101), Toast.LENGTH_LONG).show();

            ((TextView) bi.nb101.getSelectedView()).setText("Respondent should be same as Selected Woman");
            ((TextView) bi.nb101.getSelectedView()).setTextColor(Color.RED);

            ((TextView) bi.resp.getSelectedView()).setText("Respondent should be same as Selected Woman");
            ((TextView) bi.resp.getSelectedView()).setTextColor(Color.RED);

            Log.i(SectionB2Activity.class.getSimpleName(), "nb203" + ": This data is Required!");
            return false;
        } else {
            ((TextView) bi.resp.getSelectedView()).setError(null);
            ((TextView) bi.nb101.getSelectedView()).setError(null);
        }

        if (!validatorClass.EmptyTextBox(this, bi.nw203, getString(R.string.nw203))) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, bi.nw203, 15, 49, getString(R.string.na8a03m), " years")) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nw204, getString(R.string.nw204))) {
            return false;
        }

        if (Integer.valueOf(bi.nw204.getText().toString()) > 0) {

            if (!validatorClass.EmptyTextBox(this, bi.nw206, getString(R.string.nw206))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, bi.nw207, bi.nw207a, getString(R.string.nw207))) {
                return false;
            }

            if (bi.nw207a.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.nw208, bi.nw208a, getString(R.string.nw208))) {
                    return false;
                }

                if (bi.nw208a.isChecked()) {
                    if (!validatorClass.EmptyRadioButton(this, bi.nw20901, bi.nw20901a, getString(R.string.nw20901))) {
                        return false;
                    }

                    if (!validatorClass.EmptyRadioButton(this, bi.nw20902, bi.nw20902a, getString(R.string.nw20902))) {
                        return false;
                    }

                    if (!validatorClass.EmptyRadioButton(this, bi.nw20903, bi.nw20903a, getString(R.string.nw20903))) {
                        return false;
                    }

                    if (!validatorClass.EmptyRadioButton(this, bi.nw20998, bi.nw20998a, getString(R.string.dkn))) {
                        return false;
                    }

                    if (!validatorClass.EmptyRadioButton(this, bi.nw20999, bi.nw20999a, getString(R.string.nr))) {
                        return false;
                    }

                }
            }



        }
        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        MainApp.mc = new MWRAContract();

        MainApp.mc.setDevicetagID(MainApp.getTagName(this));
        MainApp.mc.setFormDate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(System.currentTimeMillis()));
        MainApp.mc.setUser(MainApp.userName);
        MainApp.mc.setDeviceId(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.mc.setApp_ver(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.mc.setB1SerialNo(MainApp.mwraMap.get(bi.nb101.getSelectedItem().toString()));
        MainApp.mc.set_UUID(MainApp.fc.getUID());

        JSONObject sB1 = new JSONObject();

        sB1.put("nb101", bi.nb101.getSelectedItem().toString());
        sB1.put("nb1serialno", MainApp.mwraMap.get(bi.nb101.getSelectedItem().toString()));
        sB1.put("nw204", bi.nw204.getText().toString());

        sB1.put("nw207", bi.nw207a.isChecked() ? "1"
                : bi.nw207b.isChecked() ? "2" : "0");

        sB1.put("nw206", bi.nw206.getText().toString());

        //        nw20901
        sB1.put("nw20901", bi.nw20901a.isChecked() ? "1"
                : bi.nw20901b.isChecked() ? "2" : "0");
        //        nw20902
        sB1.put("nw20902", bi.nw20902a.isChecked() ? "1"
                : bi.nw20902b.isChecked() ? "2" : "0");
        //        nw20903
        sB1.put("nw20903", bi.nw20903a.isChecked() ? "1"
                : bi.nw20903b.isChecked() ? "2" : "0");
        //        nw20998
        sB1.put("nw20998", bi.nw20998a.isChecked() ? "1"
                : bi.nw20998b.isChecked() ? "2" : "0");
        //        nw20999
        sB1.put("nw20999", bi.nw20999a.isChecked() ? "1"
                : bi.nw20999b.isChecked() ? "2" : "0");


        if (bi.nw207a.isChecked()) {
            MainApp.totalPregnancy = Integer.valueOf(bi.nw204.getText().toString()) - 1;
        } else {
            MainApp.totalPregnancy = Integer.valueOf(bi.nw204.getText().toString());
        }



        MainApp.mc.setsB1(String.valueOf(sB1));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        Long updcount = db.addMWRA(MainApp.mc);
        MainApp.mc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.mc.set_UID(
                    (MainApp.mc.getDeviceId() + MainApp.mc.get_ID()));
            db.updateMWRAID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

        //return true;

    }


}
