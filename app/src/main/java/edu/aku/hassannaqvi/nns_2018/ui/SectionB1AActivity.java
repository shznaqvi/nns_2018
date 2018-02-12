package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB1ABinding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

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
        /*if (ValidateForm()) {
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

    private boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyTextBox(this, bi.nb1a01, getString(R.string.nb1a01))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb1a02, bi.nb1a02a, getString(R.string.nb1a02))) {
            return false;
        }

        if (bi.nb1a02c.isChecked() || bi.nb1a02f.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.nb1a04, bi.nb1a04a, getString(R.string.nb1a04))) {
                return false;
            }

            if (bi.nb1a04a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nb1a05y, getString(R.string.nb1a05) + " - " + getString(R.string.year))) {
                    return false;
                }

                if (!validatorClass.EmptyTextBox(this, bi.nb1a05m, getString(R.string.nb1a05) + " - " + getString(R.string.month))) {
                    return false;
                }

                if (!validatorClass.EmptyTextBox(this, bi.nb1a05d, getString(R.string.nb1a05) + " - " + getString(R.string.day))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.nb1a05m, 0, 11, getString(R.string.nb1a05), " months")) {
                    return false;
                }


                if (!validatorClass.RangeTextBox(this, bi.nb1a05d, 0, 29, getString(R.string.nb1a05), " days")) {
                    return false;
                }

                if (bi.nb1a05y.getText().toString().equals("0") && bi.nb1a05m.getText().toString().equals("0") && bi.nb1a05d.getText().toString().equals("0")) {
                    Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nb1a05), Toast.LENGTH_LONG).show();
                    bi.nb1a05y.setError("All can not be zero");
                    bi.nb1a05m.setError("All can not be zero");
                    bi.nb1a05d.setError("All can not be zero");
                    Log.i(SectionA2Activity.class.getSimpleName(), "nb1a05" + ": This data is Required!");
                } else {
                    bi.nb1a05y.setError(null);
                    bi.nb1a05m.setError(null);
                    bi.nb1a05d.setError(null);
                }
            } else if (bi.nb1a04b.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nb1a06y, getString(R.string.nb1a06) + " - " + getString(R.string.year))) {
                    return false;
                }

                if (!validatorClass.EmptyTextBox(this, bi.nb1a06m, getString(R.string.nb1a06) + " - " + getString(R.string.month))) {
                    return false;
                }

                if (!validatorClass.EmptyTextBox(this, bi.nb1a06d, getString(R.string.nb1a06) + " - " + getString(R.string.day))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.nb1a06m, 0, 11, getString(R.string.nb1a06), " months")) {
                    return false;
                }


                if (!validatorClass.RangeTextBox(this, bi.nb1a06d, 0, 29, getString(R.string.nb1a06), " days")) {
                    return false;
                }

                if (bi.nb1a06y.getText().toString().equals("0") && bi.nb1a06m.getText().toString().equals("0") && bi.nb1a06d.getText().toString().equals("0")) {
                    Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nb1a06), Toast.LENGTH_LONG).show();
                    bi.nb1a06y.setError("All can not be zero");
                    bi.nb1a06m.setError("All can not be zero");
                    bi.nb1a06d.setError("All can not be zero");
                    Log.i(SectionA2Activity.class.getSimpleName(), "nb1a06" + ": This data is Required!");
                } else {
                    bi.nb1a06y.setError(null);
                    bi.nb1a06m.setError(null);
                    bi.nb1a06d.setError(null);
                }
            }
        }


        return true;
    }

}
