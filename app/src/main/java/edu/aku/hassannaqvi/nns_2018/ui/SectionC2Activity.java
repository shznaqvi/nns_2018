package edu.aku.hassannaqvi.nns_2018.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionC2Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

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


        startActivity(new Intent(this, SectionC3Activity.class));
    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);

    }

    private boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyRadioButton(this, bi.nc204, bi.nc204a, getString(R.string.nc204))) {
            return false;
        }

        if (bi.nc204a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.nc205, bi.nc205a, getString(R.string.nc205))) {
                return false;
            }

            if (bi.nc205a.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.nc206, bi.nc206a, getString(R.string.nc206))) {
                    return false;
                }

                if (bi.nc206a.isChecked()) {
                    if (!validatorClass.EmptyRadioButton(this, bi.nc207, bi.nc207a, getString(R.string.nc207))) {
                        return false;
                    }
                }
            }

            if (!validatorClass.EmptyRadioButton(this, bi.nc208, bi.nc208a, getString(R.string.nc208))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, bi.nc209, bi.nc209a, getString(R.string.nc209))) {
                return false;
            }

            if (bi.nc209a.isChecked() || bi.nc20998.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.nc210, bi.nc210a, getString(R.string.nc210))) {
                    return false;
                }
            }

            if (!validatorClass.EmptyRadioButton(this, bi.nc211, bi.nc211a, getString(R.string.nc211))) {
                return false;
            }

        }

        if (!bi.nc204a.isChecked() || bi.nc211a.isChecked()) {

            if (!bi.nc21299.isChecked()) {
                if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnc212check, bi.nc212a, getString(R.string.nc212))) {
                    return false;
                }

                if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnc212check, bi.nc21296, bi.nc21296x, getString(R.string.nb212) + " - " + getString(R.string.other))) {
                    return false;
                }
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc213, bi.nc213a, getString(R.string.nc213))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc214, bi.nc214a, getString(R.string.nc214))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215a, bi.nc215aa, getString(R.string.nc215a))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215b, bi.nc215ba, getString(R.string.nc215b))) {
            return false;
        }

        /*if (!validatorClass.EmptyRadioButton(this, bi.nc215b, bi.nc215ba, bi.nc215b1, getString(R.string.nc215b1))) {
            return false;
        }*/

        if (bi.nc215ba.isChecked() && !bi.nc215b198.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.nc215b1, getString(R.string.nb215))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, bi.nc215b1, 1, 7, getString(R.string.nb215), " times")) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.nc215c, bi.nc215ca, getString(R.string.nc215c))) {
            return false;
        }

        if (bi.nc215ca.isChecked() && !bi.nc215c198.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.nc215c1, getString(R.string.nb215))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nc215c1, 1, 7, getString(R.string.nc215), " times")) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215d, bi.nc215da, getString(R.string.nc215d))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215e, bi.nc215ea, getString(R.string.nc215e))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.nc215f, bi.nc215fa, getString(R.string.nc215f))) {
            return false;
        }

        if (bi.nc215fa.isChecked() && !bi.nc215f198.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.nc215f1, getString(R.string.nb215))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nc215f1, 1, 7, getString(R.string.nc215), " times")) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.nc215g, bi.nc215ga, getString(R.string.nc215g))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215h, bi.nc215ha, getString(R.string.nc215h))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215i, bi.nc215ia, getString(R.string.nc215i))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215i, bi.nc215ia, bi.nc215i96x, getString(R.string.nc215i) + " - " + getString(R.string.other))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216a, bi.nc216aa, getString(R.string.nc216a))) {
            return false;
        }


        if (bi.nc216aa.isChecked() && !bi.nc216a198.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.nc216a1, getString(R.string.nc216a1))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nc216a1, 1, 7, getString(R.string.nc216a1), " times")) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216b, bi.nc216ba, getString(R.string.nc216b))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216c, bi.nc216ca, getString(R.string.nc216c))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216d, bi.nc216da, getString(R.string.nc216d))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216e, bi.nc216ea, getString(R.string.nc216e))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216f, bi.nc216fa, getString(R.string.nc216f))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216g, bi.nc216ga, getString(R.string.nc216g))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216h, bi.nc216ha, getString(R.string.nc216h))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216i, bi.nc216ia, getString(R.string.nc216i))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216j, bi.nc216ja, getString(R.string.nc216j))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216k, bi.nc216ka, getString(R.string.nc216k))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216l, bi.nc216la, getString(R.string.nc216l))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216m, bi.nc216ma, getString(R.string.nc216m))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216n, bi.nc216na, getString(R.string.nc216n))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216x, bi.nc216xa, bi.nc216x1, getString(R.string.nc216x))) {
            return false;
        }

        if (bi.nc216aa.isChecked()) {
            if (!bi.nc216a1.getText().toString().isEmpty() && !bi.nc217.getText().toString().isEmpty()) {
                if (Integer.valueOf(bi.nc216a1.getText().toString()) != Integer.valueOf(bi.nc217.getText().toString())) {
                    Toast.makeText(this, "Both values should be same.. Check again ", Toast.LENGTH_SHORT).show();
                    bi.nc217.setError("Number of times recored for Yogurt in A1 is " + bi.nc216a1.getText().toString() + "Check again plz");    // Set Error on last radio button
                    bi.nc217.requestFocus();
                    Log.i(SectionC2Activity.class.getSimpleName(), "nc217: Both values should be same");

                } else {
                    bi.nc217.setError(null);
                }
            }
        } else if (bi.nc216ab.isChecked()) {
            if (!bi.nc217.getText().toString().isEmpty()) {
                if (Integer.valueOf(bi.nc217.getText().toString()) > 0) {
                    Toast.makeText(this, "Value should be zero", Toast.LENGTH_SHORT).show();
                    bi.nc217.setError("Number of times recored for Yogurt in Q16 A1 is 0 Check again plz");    // Set Error on last radio button
                    bi.nc217.requestFocus();
                    Log.i(SectionC2Activity.class.getSimpleName(), "nc217: Both values should be same");

                } else {
                    bi.nc217.setError(null);
                }
            }
        } else if (bi.nc216a98.isChecked() && !bi.nc21798.isChecked()) {
            Toast.makeText(this, "Check Again", Toast.LENGTH_SHORT).show();
            bi.nc21798.setError("Check Again.. Dont know is recored for yougurt in Q16 A");    // Set Error on last radio button
            bi.nc21798.requestFocus();
            Log.i(SectionC2Activity.class.getSimpleName(), "nc217:Check Again");

        } else {
            bi.nc21798.setError(null);
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc218, bi.nc218a, getString(R.string.nc218))) {
            return false;
        }

        if (bi.nc218a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.nc219, bi.nc219a, getString(R.string.nc219))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, bi.nc220, bi.nc220a, bi.nc22096x, getString(R.string.nc220))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc221, bi.nc221a, getString(R.string.nc221))) {
            return false;
        }

        if (bi.nc221a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.nc222, getString(R.string.nc222))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc223, bi.nc223a, getString(R.string.nc223))) {
            return false;
        }

        if (bi.nc223a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.nc224, getString(R.string.nc224))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc225, bi.nc225a, getString(R.string.nc225))) {
            return false;
        }

        if (bi.nc225a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.nc226, getString(R.string.nc226))) {
                return false;
            }
        }


        return true;
    }

}
