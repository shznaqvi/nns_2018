package edu.aku.hassannaqvi.nns_2018.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionC4Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionC4Activity extends AppCompatActivity {

    ActivitySectionC4Binding binding;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_c4);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_c4);
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
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }

    private boolean formValidation(){
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//       nc403
        if (!validatorClass.EmptyRadioButton(this, binding.nc403,binding.nc403b, getString(R.string.nc403))) {
            return false;
        }

//        nc404
        if (!validatorClass.EmptyRadioButton(this, binding.nc404,binding.nc404b, getString(R.string.nc404))){
            return false;
        }

//        nc405
        if (!validatorClass.EmptyRadioButton(this, binding.nc405,binding.nc4059603, getString(R.string.nc405))){
            return false;
        }
//        nc4059601
        if (!validatorClass.EmptyRadioButton(this, binding.nc405,binding.nc4059603, binding.nc4059601x, getString(R.string.nc405))){
            return false;
        }
//        nc4059602
        if (!validatorClass.EmptyRadioButton(this, binding.nc405,binding.nc4059603, binding.nc4059602x, getString(R.string.nc405))){
            return false;
        }
//        nc4059603
        if (!validatorClass.EmptyRadioButton(this, binding.nc405,binding.nc4059603, binding.nc4059603x, getString(R.string.nc405))){
            return false;
        }

//        fldGrpnc406
        if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnc406, binding.nc40696, binding.nc40696x, getString(R.string.nc406))){
            return false;
        }


//       nc407
        if (!validatorClass.EmptyRadioButton(this, binding.nc407,binding.nc407b, getString(R.string.nc407))) {
            return false;
        }

//        nc408
        if (!validatorClass.EmptyRadioButton(this, binding.nc408,binding.nc408b, getString(R.string.nc408))){
            return false;
        }

       // nc409
        if (!validatorClass.EmptyRadioButton(this, binding.nc409,binding.nc4099603, getString(R.string.nc409))){
            return false;
        }

//        nc4099601x
        if (!validatorClass.EmptyRadioButton(this, binding.nc409,binding.nc4099603, binding.nc4099601x, getString(R.string.nc409))){
            return false;
        }
//        nc4099602x
        if (!validatorClass.EmptyRadioButton(this, binding.nc409,binding.nc4099603, binding.nc4099602x, getString(R.string.nc409))){
            return false;
        }
//        nc4099603x
        if (!validatorClass.EmptyRadioButton(this, binding.nc409,binding.nc4099603, binding.nc4099603x, getString(R.string.nc409))){
            return false;
        }

        //    fldGrnc410check
        if (!validatorClass.EmptyCheckBox(this, binding.fldGrnc410check,binding.nc4109601, binding.nc4109601x, getString(R.string.nc410))){
            return false;
        }


//       nc411
        if (!validatorClass.EmptyRadioButton(this, binding.nc411,binding.nc411b, getString(R.string.nc411))) {
            return false;
        }

//        nc412
        if (!validatorClass.EmptyRadioButton(this, binding.nc412,binding.nc412b, getString(R.string.nc412))){
            return false;
        }

        // nc413
        if (!validatorClass.EmptyRadioButton(this, binding.nc413,binding.nc4139603, getString(R.string.nc413))){
            return false;
        }

//        nc4139601x
        if (!validatorClass.EmptyRadioButton(this, binding.nc413,binding.nc4139603, binding.nc4139601x, getString(R.string.nc413))){
            return false;
        }
//        nc4139602x
        if (!validatorClass.EmptyRadioButton(this, binding.nc413,binding.nc4139603, binding.nc4139602x, getString(R.string.nc413))){
            return false;
        }
//        nc4139603x
        if (!validatorClass.EmptyRadioButton(this, binding.nc413,binding.nc4139603, binding.nc4139603x, getString(R.string.nc413))){
            return false;
        }
        // nc414
        if (!validatorClass.EmptyCheckBox(this, binding.fldGrnc414check,binding.nc4149601, binding.nc4149601x, getString(R.string.nc414))){
            return false;
        }

//       nc415
        if (!validatorClass.EmptyRadioButton(this, binding.nc415,binding.nc41598, getString(R.string.nc415))) {
            return false;
        }

//        nc416
        if (!validatorClass.EmptyRadioButton(this, binding.nc416,binding.nc41698, getString(R.string.nc416))){
            return false;
        }


        return true;
        }

}