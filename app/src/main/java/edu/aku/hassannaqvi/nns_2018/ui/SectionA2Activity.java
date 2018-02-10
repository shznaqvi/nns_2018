package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Toast;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionA2Binding;


public class SectionA2Activity extends AppCompatActivity {

    ActivitySectionA2Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_a2);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a2);
        bi.setCallback(this);

        setupViews();

        bi.na2dob.setManager(getSupportFragmentManager());
    }


    public void setupViews() {
        bi.na2dob.setManager(getSupportFragmentManager());

        bi.na20799.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.na2dob.setEnabled(false);
                    bi.na2dob.setText(null);
                    bi.na2age.setEnabled(true);
                } else {
                    bi.na2dob.setEnabled(true);
                    bi.na2age.setEnabled(false);
                    bi.na2age.setText(null);
                }
            }
        });


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

        startActivity(new Intent(this, SectionA3Activity.class));

    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);

    }
}