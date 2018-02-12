package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

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

    private boolean formValidation(){
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//        nc101
        if (!validatorClass.EmptyTextBox(this, binding.nc101, getString(R.string.nc101))) {
            return false;
        }
//        nc103
        if (!validatorClass.EmptyRadioButton(this, binding.nc103,binding.nc103d, getString(R.string.nc103))) {
            return false;
        }
//        nc104
        if (!validatorClass.EmptyRadioButton(this, binding.nc104,binding.nc10498, getString(R.string.nc104))) {
            return false;
        }


        return true;
    }
}
