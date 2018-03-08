package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivityMotherEndingBinding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class MotherEndingActivity extends AppCompatActivity {

    private static final String TAG = MotherEndingActivity.class.getSimpleName();

    ActivityMotherEndingBinding binding;
    Boolean flagMotherChild = false;
    Boolean flagNAChild = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_mother_ending);
        binding.setCallback(this);

/*
        flagMotherChild = getIntent().getBooleanExtra("checkingFlag", false);
        if (flagMotherChild) {
            binding.lblheaderName.setText(SectionB1Activity.wraName.toUpperCase());
        } else {
*/
        binding.lblheaderName.setText(SectionB1Activity.wraName.toUpperCase());
        //}

        Boolean check = getIntent().getExtras().getBoolean("complete");

        if (check) {
            binding.istatusa.setEnabled(true);
            binding.istatusb.setEnabled(false);
            binding.istatusc.setEnabled(false);
            binding.istatusd.setEnabled(false);
            binding.istatuse.setEnabled(false);
            binding.istatus96.setEnabled(false);
        } else {
            binding.istatusa.setEnabled(false);
            binding.istatusb.setEnabled(true);
            binding.istatusc.setEnabled(true);
            binding.istatusd.setEnabled(true);
            binding.istatuse.setEnabled(true);
            binding.istatus96.setEnabled(true);
        }


        flagNAChild = SectionC1Activity.counterPerMom <= 0;


    }

    public void BtnEnd() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {

                finish();

                if (SectionB1Activity.WRAcounter == MainApp.mwra.size()) {

                    if (MainApp.childNA.size() > 0) {
                        SectionC1Activity.isNA = true;
                        startActivity(new Intent(this, SectionC1Activity.class));
                    } else {
                        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
                    }

                } else {
                    startActivity(new Intent(this, SectionB1Activity.class)
                            .putExtra("mwraFlag", true)
                            .putExtra("wraName", SectionB1Activity.wraName));
                }

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();



        MainApp.mc.setMstatus(binding.istatusa.isChecked() ? "1"
                : binding.istatusb.isChecked() ? "2"
                : binding.istatusc.isChecked() ? "3"
                : binding.istatusd.isChecked() ? "4"
                : binding.istatuse.isChecked() ? "5"
                : binding.istatus96.isChecked() ? "96"
                : "0");

        MainApp.mc.setMstatus88x(binding.istatus96x.getText().toString());

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateMotherEnding();
        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

        //return true;

    }

    private boolean formValidation() {
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyRadioButton(this, binding.istatus, binding.istatusa, getString(R.string.istatus))) {
            return false;
        }

        if (binding.istatus96.isChecked()) {

            if (binding.istatus96x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
                binding.istatus96x.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "istatus96x: This data is Required!");
                return false;
            } else {
                binding.istatus96x.setError(null);
            }

        }


        return true;
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }


}
