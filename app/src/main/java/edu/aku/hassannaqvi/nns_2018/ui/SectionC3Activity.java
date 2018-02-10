package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionC3Binding;

public class SectionC3Activity extends AppCompatActivity {

    ActivitySectionC3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_c3);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c3);
        bi.setCallback(this);
        bi.nc3bcgdt.setManager(getSupportFragmentManager());
        bi.nc3opv0dt.setManager(getSupportFragmentManager());
        bi.nc3opv1dt.setManager(getSupportFragmentManager());
        bi.nc3penta1dt.setManager(getSupportFragmentManager());
        bi.nc3pcv1dt.setManager(getSupportFragmentManager());
        bi.nc3opv2dt.setManager(getSupportFragmentManager());
        bi.nc3p2dt.setManager(getSupportFragmentManager());
        bi.nc3pcv2dt.setManager(getSupportFragmentManager());
        bi.nc3opv3dt.setManager(getSupportFragmentManager());
        bi.nc3p3dt.setManager(getSupportFragmentManager());
        bi.nc3pcv3dt.setManager(getSupportFragmentManager());
        bi.nc3ipvdt.setManager(getSupportFragmentManager());
        bi.nc3m1dt.setManager(getSupportFragmentManager());
        bi.nc3m2dt.setManager(getSupportFragmentManager());

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

        startActivity(new Intent(this, SectionC5Activity.class));

    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);

    }
}
