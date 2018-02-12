package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB5Binding;

public class SectionB5Activity extends AppCompatActivity {

    ActivitySectionB5Binding binding;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_b5);
        db = new DatabaseHelper(this);

//        Assigning data to UI binding
        binding.setCallback(this);

//        Skip patterns

        binding.nb501.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nb501b) {
                    binding.nb502a.setChecked(false);
                    binding.nb502b.setChecked(false);
                    binding.nb502c.setChecked(false);
                    binding.nb502d.setChecked(false);
                    binding.nb502e.setChecked(false);
                    binding.nb502f.setChecked(false);
                    binding.nb502g.setChecked(false);
                    binding.nb50296.setChecked(false);

                    binding.nb503.clearCheck();
                    binding.nb504.setText(null);

                    binding.nb505a.setChecked(false);
                    binding.nb505b.setChecked(false);
                    binding.nb505c.setChecked(false);
                    binding.nb505d.setChecked(false);
                    binding.nb505e.setChecked(false);
                    binding.nb505f.setChecked(false);
                    binding.nb505g.setChecked(false);
                    binding.nb505h.setChecked(false);
                    binding.nb50596.setChecked(false);

                }
            }
        });

        binding.nb506.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nb506b) {
                    binding.nb507a.setChecked(false);
                    binding.nb507b.setChecked(false);
                    binding.nb507c.setChecked(false);
                    binding.nb507d.setChecked(false);
                    binding.nb507e.setChecked(false);
                    binding.nb507f.setChecked(false);
                    binding.nb507g.setChecked(false);
                    binding.nb50796.setChecked(false);

                    binding.nb508.clearCheck();
                    binding.nb509.setText(null);

                    binding.nb510a.setChecked(false);
                    binding.nb510b.setChecked(false);
                    binding.nb510c.setChecked(false);
                    binding.nb510d.setChecked(false);
                    binding.nb510e.setChecked(false);
                    binding.nb51096.setChecked(false);
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

        startActivity(new Intent(this, SectionB6Activity.class));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }

}
