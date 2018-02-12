package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionC5Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionC5Activity extends AppCompatActivity {

    ActivitySectionC5Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_c5);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c5);
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

        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));

    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);

    }
   private boolean formValidation(){
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyRadioButton(this, bi.nc503, bi.nc503a, getString(R.string.nc503))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.nc504, bi.nc504a, getString(R.string.nc504))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.nc505, bi.nc505a, getString(R.string.nc505))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.nc506, bi.nc506a, getString(R.string.nc506))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.nc507, bi.nc507a, getString(R.string.nc507))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.nc508, bi.nc508a, getString(R.string.nc508))) {
            return false;
        }

        return true;

    }

}
