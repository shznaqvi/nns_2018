package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivityChildEndingBinding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class ChildEndingActivity extends AppCompatActivity {

    private static final String TAG = ChildEndingActivity.class.getSimpleName();

    ActivityChildEndingBinding binding;
    Boolean flagMotherChild = false;
    Boolean flagNAChild = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_child_ending);
        binding.setCallback(this);

        binding.lblheaderName.setText(SectionC1Activity.selectedChildName.toUpperCase());


        Boolean check = getIntent().getExtras().getBoolean("complete");

        if (check) {
            binding.istatusa.setEnabled(true);
            binding.istatusb.setEnabled(false);
            binding.istatusc.setEnabled(false);
        } else {
            binding.istatusa.setEnabled(false);
            binding.istatusb.setEnabled(true);
            binding.istatusc.setEnabled(true);
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

                if (!flagNAChild) {

                    if (SectionC1Activity.counter == SectionC1Activity.counterPerMom) {

                        startActivity(new Intent(this, MotherEndingActivity.class)
                                .putExtra("checkingFlag", true)
                                .putExtra("complete", true));

                    } else {
                        startActivity(new Intent(this, SectionC1Activity.class)
                                .putExtra("childFlag", true)
                                .putExtra("name", SectionC1Activity.selectedChildName));
                    }
                } else {

                    if (SectionC1Activity.counter == SectionC1Activity.counterPerNA) {
                        SectionC1Activity.isNA = false;
                        startActivity(new Intent(this, SectionA3Activity.class));

                    } else {

                        startActivity(new Intent(this, SectionC1Activity.class)
                                .putExtra("childFlag", true)
                                .putExtra("name", SectionC1Activity.selectedChildName));
                    }
                }


            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();


        MainApp.cc.setCstatus(binding.istatusa.isChecked() ? "1"
                : binding.istatusb.isChecked() ? "2"
                : binding.istatusc.isChecked() ? "3"
                : "0");

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateChildEnding();
        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean formValidation() {
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyRadioButton(this, binding.istatus, binding.istatusc, getString(R.string.istatus))) {
            return false;
        }

        /*if (istatus88.isChecked()) {

            if (istatus88x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
                istatus88x.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "istatus88x: This data is Required!");
                return false;
            } else {
                istatus88x.setError(null);
            }

        }*/


        return true;
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }


}
