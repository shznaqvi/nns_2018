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
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

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
        binding.nc3p1dt.setManager(getSupportFragmentManager());
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
        binding.nc312.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nc312b) {
                    binding.nc313.clearCheck();
                }
            }
        });

        binding.nc304.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nc304d) {
                    binding.nc3bcg.clearCheck();
                    binding.nc3opv0.clearCheck();
                    binding.nc3opv1.clearCheck();
                    binding.nc3p1.clearCheck();
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
    private boolean formValidation(){
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//       nc303
        if (!validatorClass.EmptyRadioButton(this, binding.nc303,binding.nc303b, getString(R.string.nc303))) {
            return false;
        }

//        nc304
        if (!validatorClass.EmptyRadioButton(this, binding.nc304,binding.nc304d, getString(R.string.nc304))){
            return false;
        }

//        nc3bcg
        if(!validatorClass.EmptyRadioButton(this,binding.nc3bcg, binding.nc3bcgb, binding.nc3bcgdt, getString(R.string.nc3bcg))){
            return false;
        }
//        nc3opv0
        if(!validatorClass.EmptyRadioButton(this,binding.nc3opv0, binding.nc3opv0b, binding.nc3opv0dt, getString(R.string.nc3opv0))){
            return false;
        }


//        nc3opv1
        if(!validatorClass.EmptyRadioButton(this,binding.nc3opv1, binding.nc3opv1b, binding.nc3opv1dt, getString(R.string.nc3opv1))){
            return false;
        }
//        nc3p1
        if(!validatorClass.EmptyRadioButton(this,binding.nc3p1, binding.nc3p1b, binding.nc3p1dt, getString(R.string.nc3p1))){
            return false;
        }
//        nc3pcv1
        if(!validatorClass.EmptyRadioButton(this,binding.nc3pcv1, binding.nc3pcv1b, binding.nc3pcv1dt, getString(R.string.nc3pcv1))){
            return false;
        }




//        nc3opv2
        if(!validatorClass.EmptyRadioButton(this,binding.nc3opv2, binding.nc3opv2b, binding.nc3opv2dt, getString(R.string.nc3opv2))){
            return false;
        }
//        nc3p2
        if(!validatorClass.EmptyRadioButton(this,binding.nc3p2, binding.nc3p2b, binding.nc3p2dt, getString(R.string.nc3p2))){
            return false;
        }
//        nc3pcv2
        if(!validatorClass.EmptyRadioButton(this,binding.nc3pcv2, binding.nc3pcv2b, binding.nc3pcv2dt, getString(R.string.nc3pcv2))){
            return false;
        }



//        nc3opv3
        if(!validatorClass.EmptyRadioButton(this,binding.nc3opv3, binding.nc3opv3b, binding.nc3opv3dt, getString(R.string.nc3opv3))){
            return false;
        }
//        nc3p3
        if(!validatorClass.EmptyRadioButton(this,binding.nc3p3, binding.nc3p3b, binding.nc3p3dt, getString(R.string.nc3p3))){
            return false;
        }
//        nc3pcv3
        if(!validatorClass.EmptyRadioButton(this,binding.nc3pcv3, binding.nc3pcv3b, binding.nc3pcv3dt, getString(R.string.nc3pcv3))){
            return false;
        }
//        nc3ipv3
        if(!validatorClass.EmptyRadioButton(this,binding.nc3ipv, binding.nc3ipvb, binding.nc3ipvdt, getString(R.string.nc3ipv))){
            return false;
        }

//        nc3m1dt
        if(!validatorClass.EmptyRadioButton(this,binding.nc3m1, binding.nc3m1b, binding.nc3m1dt, getString(R.string.nc3m1))){
            return false;
        }

//        nc3m2dt
        if(!validatorClass.EmptyRadioButton(this,binding.nc3m2, binding.nc3m2b, binding.nc3m2dt, getString(R.string.nc3m2))){
            return false;
        }



//        nc306
        if (!validatorClass.EmptyRadioButton(this, binding.nc306, binding.nc306b,getString(R.string.nc306))) {
            return false;
        }

//        nc307
        if (!validatorClass.EmptyRadioButton(this, binding.nc307, binding.nc307b,getString(R.string.nc307))) {
            return false;
        }
//        nc308
        if (!validatorClass.EmptyRadioButton(this, binding.nc308, binding.nc308b,getString(R.string.nc308))) {
            return false;
        }

//        nc309
        if (!validatorClass.EmptyTextBox(this, binding.nc309, getString(R.string.nc309))) {
            return false;
        }

//        nc310
        if (!validatorClass.EmptyRadioButton(this, binding.nc310, binding.nc310b, getString(R.string.nc310))) {
            return false;
        }

//        nc311
        if (!validatorClass.EmptyTextBox(this, binding.nc311, getString(R.string.nc311))) {
            return false;
        }

//        nc312
        if (!validatorClass.EmptyRadioButton(this, binding.nc312, binding.nc312b, getString(R.string.nc312))) {
            return false;
        }
//        nc313
        if (!validatorClass.EmptyRadioButton(this, binding.nc313, binding.nc31398, getString(R.string.nc313))) {
            return false;
        }
//        nc314
        if (!validatorClass.EmptyRadioButton(this, binding.nc314, binding.nc31498, getString(R.string.nc314))) {
            return false;
        }

//        nc315
        if (!validatorClass.EmptyTextBox(this, binding.nc315, getString(R.string.nc315))) {
            return false;
        }

//        nc316
        if (!validatorClass.EmptyRadioButton(this, binding.nc316, binding.nc31698, getString(R.string.nc316))) {
            return false;
        }

//        nc317
        if (!validatorClass.EmptyTextBox(this, binding.nc317, getString(R.string.nc317))) {
            return false;
        }


        return true;
    }
    }

