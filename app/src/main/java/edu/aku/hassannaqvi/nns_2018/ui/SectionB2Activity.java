package edu.aku.hassannaqvi.nns_2018.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB2Binding;

public class SectionB2Activity extends Activity {

    ActivitySectionB2Binding bi;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_b2);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b2);
        db = new DatabaseHelper(this);
        bi.setCallback(this);

        setupViews();
    }

    public void setupViews() {
        bi.nb201.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb201a.isChecked()) {
                    bi.fldGrpnb202.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnb202.setVisibility(View.GONE);
                    bi.nb202a.setChecked(false);
                    bi.nb202b.setChecked(false);
                    bi.nb202c.setChecked(false);
                    bi.nb202d.setChecked(false);
                    bi.nb202e.setChecked(false);
                    bi.nb202f.setChecked(false);
                    bi.nb202g.setChecked(false);
                    bi.nb202h.setChecked(false);
                    bi.nb20296.setChecked(false);
                    bi.nb20296x.setText(null);
                    bi.nb203m.setText(null);
                    bi.nb203w.setText(null);
                    bi.nb20398.setChecked(false);
                    bi.nb204.setText(null);
                    bi.nb20498.setChecked(false);
                    bi.nb205a.setChecked(false);
                    bi.nb205b.setChecked(false);
                    bi.nb205c.setChecked(false);
                    bi.nb205d.setChecked(false);
                    bi.nb205e.setChecked(false);
                    bi.nb205f.setChecked(false);
                    bi.nb205g.setChecked(false);
                    bi.nb205h.setChecked(false);
                    bi.nb20596.setChecked(false);
                    bi.nb20596x.setText(null);
                }
            }
        });

        bi.nb207.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb207a.isChecked()) {
                    bi.fldGrpnb208.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnb208.setVisibility(View.GONE);
                    bi.nb208.setText(null);
                    bi.nb20898.setChecked(false);
                }
            }
        });

        bi.nb209.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb209a.isChecked()) {
                    bi.fldGrpnb210.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnb210.setVisibility(View.GONE);
                    bi.nb21001.clearCheck();
                    bi.nb21002.clearCheck();
                    bi.nb21003.clearCheck();
                    bi.nb21098.clearCheck();
                    bi.nb21099.clearCheck();
                    bi.nb211.clearCheck();
                    bi.nb212m.setText(null);
                    bi.nb212d.setText(null);
                }
            }
        });

        bi.nb21098.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb21098a.isChecked()) {
                    bi.nb21001.setEnabled(false);
                    bi.nb21001.clearCheck();
                    bi.nb21002.setEnabled(false);
                    bi.nb21002.clearCheck();
                    bi.nb21003.setEnabled(false);
                    bi.nb21003.clearCheck();
                    bi.nb21099.setEnabled(false);
                    bi.nb21099.clearCheck();
                } else {
                    bi.nb21001.setEnabled(true);
                    bi.nb21002.setEnabled(true);
                    bi.nb21003.setEnabled(true);
                    bi.nb21099.setEnabled(true);

                }
            }
        });

        bi.nb21099.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb21099a.isChecked()) {
                    bi.nb21001.setEnabled(false);
                    bi.nb21001.clearCheck();
                    bi.nb21002.setEnabled(false);
                    bi.nb21002.clearCheck();
                    bi.nb21003.setEnabled(false);
                    bi.nb21003.clearCheck();
                    bi.nb21098.setEnabled(false);
                    bi.nb21098.clearCheck();
                } else {
                    bi.nb21001.setEnabled(true);
                    bi.nb21002.setEnabled(true);
                    bi.nb21003.setEnabled(true);
                    bi.nb21098.setEnabled(true);

                }
            }
        });

        bi.nb213.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb213a.isChecked()) {
                    bi.fldGrpnb214.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnb214.setVisibility(View.GONE);
                    bi.nb214.clearCheck();
                    bi.nb215m.setText(null);
                    bi.nb215d.setText(null);
                }
            }
        });

        bi.nb216.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb216a.isChecked()) {
                    bi.fldGrpnb217.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnb217.setVisibility(View.GONE);
                    bi.nb217.clearCheck();
                    bi.nb218d.setText(null);
                    bi.nb218m.setText(null);
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

        startActivity(new Intent(this, SectionB3Activity.class));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);

    }
}
