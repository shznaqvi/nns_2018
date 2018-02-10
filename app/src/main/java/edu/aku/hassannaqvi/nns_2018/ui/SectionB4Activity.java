package edu.aku.hassannaqvi.nns_2018.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB4Binding;

public class SectionB4Activity extends Activity {

    ActivitySectionB4Binding binding;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_b4);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_b4);
        db = new DatabaseHelper(this);
        binding.setCallback(this);

        binding.nb40199.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    binding.nb401a.setChecked(false);
                    binding.nb401b.setChecked(false);
                    binding.nb401c.setChecked(false);
                    binding.nb401d.setChecked(false);
                    binding.nb401e.setChecked(false);
                    binding.nb40196.setChecked(false);

                    binding.nb401a.setEnabled(false);
                    binding.nb401b.setEnabled(false);
                    binding.nb401c.setEnabled(false);
                    binding.nb401d.setEnabled(false);
                    binding.nb401e.setEnabled(false);
                    binding.nb40196.setEnabled(false);
                }
                else{
                    binding.nb401a.setEnabled(true);
                    binding.nb401b.setEnabled(true);
                    binding.nb401c.setEnabled(true);
                    binding.nb401d.setEnabled(true);
                    binding.nb401e.setEnabled(true);
                    binding.nb40196.setEnabled(true);
                }
            }
        });
        binding.nb404.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.nb404b||checkedId == R.id.nb40498){
                    binding.fldGrpnb405.setVisibility(View.GONE);
                    binding.nb405c.setText(null);
                    binding.nb405r.setText(null);
                    binding.nb40598.setChecked(false);
                }
                else{
                    binding.fldGrpnb405.setVisibility(View.VISIBLE);
                }
            }
        });
        binding.nb410.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.nb410b|| checkedId == R.id.nb41098){
                    binding.fldGrpnb411check.setVisibility(View.GONE);
                    binding.nb411a.setChecked(false);
                    binding.nb411b.setChecked(false);
                    binding.nb411c.setChecked(false);
                    binding.nb411d.setChecked(false);
                    binding.nb411e.setChecked(false);
                    binding.nb41196.setChecked(false);
                    binding.nb41198.setChecked(false);

                    binding.nb41196x.setText(null);

                }
                else{
                    binding.fldGrpnb411check.setVisibility(View.VISIBLE);
                }
            }
        });
        binding.nb41198.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    binding.nb411a.setEnabled(false);
                    binding.nb411b.setEnabled(false);
                    binding.nb411c.setEnabled(false);
                    binding.nb411d.setEnabled(false);
                    binding.nb411e.setEnabled(false);
                    binding.nb41196.setEnabled(false);

                    binding.nb411a.setChecked(false);
                    binding.nb411b.setChecked(false);
                    binding.nb411c.setChecked(false);
                    binding.nb411d.setChecked(false);
                    binding.nb411e.setChecked(false);
                    binding.nb41196.setChecked(false);

                    binding.nb41196x.setText(null);

                }
                else{
                    binding.nb411a.setEnabled(true);
                    binding.nb411b.setEnabled(true);
                    binding.nb411c.setEnabled(true);
                    binding.nb411d.setEnabled(true);
                    binding.nb411e.setEnabled(true);
                    binding.nb41196.setEnabled(true);
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

        startActivity(new Intent(this, SectionB5Activity.class));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);

    }
}
