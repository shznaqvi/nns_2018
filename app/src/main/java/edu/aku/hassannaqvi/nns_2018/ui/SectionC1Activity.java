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
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionC1Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionC1Activity extends AppCompatActivity {

    ActivitySectionC1Binding binding;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_c1);
        db = new DatabaseHelper(this);

//        Assigning data to UI binding
        binding.setCallback(this);
    }

    public void BtnContinue() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        /*if (formValidation()) {
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

        startActivity(new Intent(this, SectionC2Activity.class));
    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);
    }

    private boolean formValidation() {
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//        nc101
        if (!validatorClass.EmptyTextBox(this, binding.nc101, getString(R.string.nc101))) {
            return false;
        }
//        nc103
        if (!validatorClass.EmptyRadioButton(this, binding.nc103, binding.nc10398, getString(R.string.nc103))) {
            return false;
        }
//        nc104
        return validatorClass.EmptyRadioButton(this, binding.nc104, binding.nc10498, getString(R.string.nc104));
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sC1 = new JSONObject();
        //       nc101
        sC1.put("nc101", binding.nc101.getText().toString());
//        nc103
        sC1.put("nc103", binding.nc103a.isChecked() ? "1"
                : binding.nc103b.isChecked() ? "2"
                : binding.nc103c.isChecked() ? "3"
                : binding.nc10398.isChecked() ? "98"
                : "0");

//        nc104
        sC1.put("nc104", binding.nc104a.isChecked() ? "1"
                : binding.nc104b.isChecked() ? "2"
                : binding.nc10498.isChecked() ? "98"
                : "0");


        //MainApp.cc.setsA4(String.valueOf(sB));


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
