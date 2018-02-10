package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB1ABinding;

public class SectionB1AActivity extends AppCompatActivity {

    ActivitySectionB1ABinding bi;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_b1_a);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b1_a);
        db = new DatabaseHelper(this);
        bi.setCallback(this);


        setupViews();

    }

    public void setupViews() {

        bi.nb1a01.setManager(getSupportFragmentManager());

        bi.nb1a04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb1a04a.isChecked()) {
                    bi.fldGrpnb1a05.setVisibility(View.VISIBLE);
                    bi.fldGrpnb1a06.setVisibility(View.GONE);
                    bi.nb1a06d.setText(null);
                    bi.nb1a06m.setText(null);
                    bi.nb1a06y.setText(null);

                } else {
                    bi.fldGrpnb1a05.setVisibility(View.GONE);
                    bi.fldGrpnb1a06.setVisibility(View.VISIBLE);
                    bi.nb1a05d.setText(null);
                    bi.nb1a05m.setText(null);
                    bi.nb1a05y.setText(null);
                }
            }
        });

        bi.nb1a02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb1a02a.isChecked() || bi.nb1a02b.isChecked() || bi.nb1a02c.isChecked()) {
                    bi.fldGrpnb1a03.setVisibility(View.GONE);
                    bi.nb1a04.clearCheck();
                    bi.nb1a05d.setText(null);
                    bi.nb1a05m.setText(null);
                    bi.nb1a05y.setText(null);
                    bi.nb1a06d.setText(null);
                    bi.nb1a06m.setText(null);
                    bi.nb1a06y.setText(null);

                } else {
                    bi.fldGrpnb1a03.setVisibility(View.VISIBLE);
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

        startActivity(new Intent(this, SectionB2Activity.class));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);

    }
}
