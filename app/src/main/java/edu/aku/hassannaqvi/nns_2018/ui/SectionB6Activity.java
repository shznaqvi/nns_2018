package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB6Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionB6Activity extends AppCompatActivity {

    ActivitySectionB6Binding bi;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_b6);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b6);
        db = new DatabaseHelper(this);
        bi.setCallback(this);
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

        startActivity(new Intent(this, SectionC1Activity.class));

    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);

    }

    private boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyRadioButton(this, bi.nb60101, bi.nb60101a, getString(R.string.nb601a))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60102, bi.nb60102a, getString(R.string.nb601b))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60103, bi.nb60103a, getString(R.string.nb601c))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60104, bi.nb60104a, getString(R.string.nb601d))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60105, bi.nb60105a, getString(R.string.nb601e))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60106, bi.nb60106a, getString(R.string.nb601f))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60107, bi.nb60107a, getString(R.string.nb601g))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb6019601, bi.nb6019601a, getString(R.string.nb601h))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb6019601, bi.nb6019601a, bi.nb6019601x, getString(R.string.nb601h) + " - " + getString(R.string.other))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb6019602, bi.nb6019602a, getString(R.string.nb601i))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb6019602, bi.nb6019602a, bi.nb6019602x, getString(R.string.nb601j) + " - " + getString(R.string.other))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb6019603, bi.nb6019603a, getString(R.string.nb601j))) {
            return false;
        }

        return validatorClass.EmptyRadioButton(this, bi.nb6019603, bi.nb6019603a, bi.nb6019603x, getString(R.string.nb601j) + " - " + getString(R.string.other));
    }

}
