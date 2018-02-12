package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionA3Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionA3Activity extends AppCompatActivity {

    ActivitySectionA3Binding bi;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_a3);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a3);
        db = new DatabaseHelper(this);

//        Assigning data to UI binding
        bi.setCallback(this);

        //setupViews();


    }

    public void setupViews() {

    }

    public void BtnContinue() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        /*if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, ChildAssessmentActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }*/

        startActivity(new Intent(this, SectionA4Activity.class));


    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }


    private boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyTextBox(this, bi.na3w, getString(R.string.na3w))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.na3h, getString(R.string.na3h))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.na3muac, getString(R.string.na3muac))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.na3bcgscar, bi.na3bcgscara, getString(R.string.na3bcgscar))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.na3g, bi.na3ga, getString(R.string.na3g))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.na3ca, bi.na3caa, getString(R.string.na3ca))) {
            return false;
        }

        return validatorClass.EmptyRadioButton(this, bi.na3o, bi.na3oa, getString(R.string.na3o));
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sA3 = new JSONObject();

        sA3.put("na3w", bi.na3w.getText().toString());

        sA3.put("na3h", bi.na3h.getText().toString());

        sA3.put("na3muac", bi.na3muac.getText().toString());

        sA3.put("na3bcgscar", bi.na3bcgscara.isChecked() ? "1"
                : bi.na3bcgscarb.isChecked() ? "2" : "0");

        sA3.put("na3g", bi.na3ga.isChecked() ? "1"
                : bi.na3gb.isChecked() ? "2" : "0");

        sA3.put("na3g", bi.na3caa.isChecked() ? "1"
                : bi.na3cab.isChecked() ? "2" : "0");

        sA3.put("na3o", bi.na3oa.isChecked() ? "1"
                : bi.na3ob.isChecked() ? "2" : "0");


        //MainApp.cc.setsB(String.valueOf(sB));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        /*Long updcount = db.addChildForm(MainApp.cc);
        MainApp.cc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.cc.setUID(
                    (MainApp.cc.getDeviceID() + MainApp.cc.get_ID()));
            db.updateFormChildID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/

        return true;

    }


}
