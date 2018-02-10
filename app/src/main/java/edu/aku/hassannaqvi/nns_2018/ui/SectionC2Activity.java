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
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionC2Binding;

public class SectionC2Activity extends Activity {

    ActivitySectionC2Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_c2);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c2);
        bi.setCallback(this);

        setupViews();
    }

    public void setupViews() {
        bi.nc204.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc204a.isChecked()) {
                    bi.fldGrpnc205.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnc205.setVisibility(View.GONE);
                    bi.nc205.clearCheck();
                    bi.nc206.clearCheck();
                    bi.nc207.clearCheck();
                    bi.nc208.clearCheck();
                    bi.nc209.clearCheck();
                    bi.nc210.clearCheck();
                    bi.nc21096x.setText(null);
                    bi.nc211.clearCheck();
                }
            }
        });

        bi.nc205.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc205a.isChecked()) {
                    bi.fldGrpnc206.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnc206.setVisibility(View.GONE);
                    bi.nc206.clearCheck();
                    bi.nc207.clearCheck();
                }
            }
        });

        bi.nc206.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc206a.isChecked()) {
                    bi.fldGrpnc207.setVisibility(View.GONE);
                    bi.nc207.clearCheck();
                } else {
                    bi.fldGrpnc207.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.nc209.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc209b.isChecked()) {
                    bi.fldGrpnc210.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnc210.setVisibility(View.GONE);
                    bi.nc210.clearCheck();
                    bi.nc21096x.setText(null);
                }
            }
        });

        bi.nc211.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc211a.isChecked()) {
                    bi.fldGrpnc212.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnc212.setVisibility(View.GONE);
                    bi.nc212a.setChecked(false);
                    bi.nc212b.setChecked(false);
                    bi.nc212c.setChecked(false);
                    bi.nc212d.setChecked(false);
                    bi.nc212e.setChecked(false);
                    bi.nc212f.setChecked(false);
                    bi.nc212g.setChecked(false);
                    bi.nc212h.setChecked(false);
                    bi.nc212i.setChecked(false);
                    bi.nc212j.setChecked(false);
                    bi.nc21299.setChecked(false);
                    bi.nc21296.setChecked(false);
                    bi.nc21296x.setText(null);
                }
            }
        });

        bi.nc21299.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    bi.nc212a.setEnabled(false);
                    bi.nc212b.setEnabled(false);
                    bi.nc212c.setEnabled(false);
                    bi.nc212d.setEnabled(false);
                    bi.nc212e.setEnabled(false);
                    bi.nc212f.setEnabled(false);
                    bi.nc212g.setEnabled(false);
                    bi.nc212h.setEnabled(false);
                    bi.nc212i.setEnabled(false);
                    bi.nc212j.setEnabled(false);
                    bi.nc21296.setEnabled(false);
                    bi.nc212a.setChecked(false);
                    bi.nc212b.setChecked(false);
                    bi.nc212c.setChecked(false);
                    bi.nc212d.setChecked(false);
                    bi.nc212e.setChecked(false);
                    bi.nc212f.setChecked(false);
                    bi.nc212g.setChecked(false);
                    bi.nc212h.setChecked(false);
                    bi.nc212i.setChecked(false);
                    bi.nc212j.setChecked(false);
                    bi.nc21296.setChecked(false);
                    bi.nc21296x.setText(null);
                } else {
                    bi.nc212a.setEnabled(true);
                    bi.nc212b.setEnabled(true);
                    bi.nc212c.setEnabled(true);
                    bi.nc212d.setEnabled(true);
                    bi.nc212e.setEnabled(true);
                    bi.nc212f.setEnabled(true);
                    bi.nc212g.setEnabled(false);
                    bi.nc212h.setEnabled(false);
                    bi.nc212i.setEnabled(false);
                    bi.nc212j.setEnabled(false);
                    bi.nc21296.setEnabled(false);
                }
            }
        });

        bi.nc215b.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc215ba.isChecked()) {
                    bi.fldGrpnc215b1.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnc215b1.setVisibility(View.GONE);
                    bi.nc215b1.setText(null);
                    bi.nc215b198.setChecked(false);
                }
            }
        });

        bi.nc215c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc215ca.isChecked()) {
                    bi.fldGrpnc215c1.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnc215c1.setVisibility(View.GONE);
                    bi.nc215c1.setText(null);
                    bi.nc215c198.setChecked(false);
                }
            }
        });

        bi.nc215f.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc215fa.isChecked()) {
                    bi.fldGrpnc215f1.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnc215f1.setVisibility(View.GONE);
                    bi.nc215f1.setText(null);
                    bi.nc215f198.setChecked(false);
                }
            }
        });

        bi.nc216a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc216aa.isChecked()) {
                    bi.fldGrpnc216a1.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnc216a1.setVisibility(View.GONE);
                    bi.nc216a1.setText(null);
                    bi.nc216a198.setChecked(false);
                }
            }
        });

        bi.nc218.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc218a.isChecked()) {
                    bi.fldGrpnc219.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnc219.setVisibility(View.GONE);
                    bi.nc219.clearCheck();
                    bi.nc220.clearCheck();
                    bi.nc22096x.setText(null);
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


        startActivity(new Intent(this, SectionC3Activity.class));
    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);

    }
}
