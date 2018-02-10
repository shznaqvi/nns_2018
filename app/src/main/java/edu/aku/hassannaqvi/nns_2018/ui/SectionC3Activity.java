package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionC3Binding;

public class SectionC3Activity extends AppCompatActivity {

    ActivitySectionC3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_c3);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_c3);
        binding.setCallback(this);
        binding.nc3bcgdt.setManager(getSupportFragmentManager());
        binding.nc3opv0dt.setManager(getSupportFragmentManager());
        binding.nc3opv1dt.setManager(getSupportFragmentManager());
        binding.nc3penta1dt.setManager(getSupportFragmentManager());
        binding.nc3pcv1dt.setManager(getSupportFragmentManager());
        binding.nc3opv2dt.setManager(getSupportFragmentManager());
        binding.nc3p2dt.setManager(getSupportFragmentManager());
        binding.nc3pcv2dt.setManager(getSupportFragmentManager());
        binding.nc3opv3dt.setManager(getSupportFragmentManager());
        binding.nc3p3dt.setManager(getSupportFragmentManager());
        binding.nc3pcv3dt.setManager(getSupportFragmentManager());
        binding.nc3ipvdt.setManager(getSupportFragmentManager());
        binding.nc3m1dt.setManager(getSupportFragmentManager());
        binding.nc3m2dt.setManager(getSupportFragmentManager());

//        Skip Patterns
        binding.nc310.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nc310b) {
                    binding.nc311.clearCheck();
                    binding.nc312.clearCheck();
                    binding.nc313.clearCheck();
                }
            }
        });

        binding.nc305.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nc305c) {
                    binding.nc3bcg.clearCheck();
                    binding.nc3opv0.clearCheck();
                    binding.nc3opv1.clearCheck();
                    binding.nc3penta1.clearCheck();
                    binding.nc3pcv1.clearCheck();
                    binding.nc3opv2.clearCheck();
                    binding.nc3p2.clearCheck();
                    binding.nc3pcv2.clearCheck();
                    binding.nc3opv3.clearCheck();
                    binding.nc3p3.clearCheck();
                    binding.nc3pcv3.clearCheck();
                    binding.nc3ipv.clearCheck();
                    binding.nc3m1.clearCheck();
                    binding.nc3m2.clearCheck();
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

        startActivity(new Intent(this, SectionC5Activity.class));

    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);

    }
}
