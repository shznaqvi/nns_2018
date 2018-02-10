package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionA5Binding;

public class SectionA5Activity extends AppCompatActivity {

    ActivitySectionA5Binding binding;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_a5);
        db = new DatabaseHelper(this);

//        Assigning data to UI binding
        binding.setCallback(this);

        binding.na501.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(binding.na501a.isChecked()||binding.na501b.isChecked()||binding.na501c.isChecked())
                {
                    binding.fldGrpna502.setVisibility(View.VISIBLE);
                }else{
                    binding.fldGrpna502.setVisibility(View.GONE);
                    binding.na502.clearCheck();
                    binding.na503a.setChecked(false);
                    binding.na503b.setChecked(false);
                    binding.na503c.setChecked(false);
                    binding.na503d.setChecked(false);


                }
            }
        });

        binding.na503e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    binding.na503a.setEnabled(false);
                    binding.na503b.setEnabled(false);
                    binding.na503c.setEnabled(false);
                    binding.na503d.setEnabled(false);

                    binding.na503a.setChecked(false);
                    binding.na503b.setChecked(false);
                    binding.na503c.setChecked(false);
                    binding.na503d.setChecked(false);

                }else{
                    binding.na503a.setEnabled(true);
                    binding.na503b.setEnabled(true);
                    binding.na503c.setEnabled(true);
                    binding.na503d.setEnabled(true);
                }
            }
        });

       binding.na504.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               if(checkedId == R.id.na504b){
                   binding.fldGrpna505check.setVisibility(View.GONE);
                   binding.na505a.setChecked(false);
                   binding.na505b.setChecked(false);
                   binding.na505c.setChecked(false);
                   binding.na505d.setChecked(false);
                   binding.na505e.setChecked(false);

               }
               else if(checkedId == R.id.na504a){
                   binding.fldGrpna505check.setVisibility(View.VISIBLE);

               }
           }
       });
       binding.na505e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked)
               {
                   binding.na505a.setEnabled(false);
                   binding.na505b.setEnabled(false);
                   binding.na505c.setEnabled(false);
                   binding.na505d.setEnabled(false);

                   binding.na505a.setChecked(false);
                   binding.na505b.setChecked(false);
                   binding.na505c.setChecked(false);
                   binding.na505d.setChecked(false);

               }else{
                   binding.na505a.setEnabled(true);
                   binding.na505b.setEnabled(true);
                   binding.na505c.setEnabled(true);
                   binding.na505d.setEnabled(true);
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

        startActivity(new Intent(this, SectionA8AActivity.class));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);

    }


}
