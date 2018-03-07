package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivityEndingBinding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class EndingActivity extends AppCompatActivity {

    private static final String TAG = EndingActivity.class.getSimpleName();

    ActivityEndingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_ending);
        binding.setCallback(this);

        Boolean check = getIntent().getExtras().getBoolean("complete");

        if (check) {
            binding.istatusa.setEnabled(true);
            binding.istatusb.setEnabled(false);
        } else {
            binding.istatusa.setEnabled(false);
            binding.istatusb.setEnabled(true);
        }

        binding.istatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (binding.istatus96.isChecked()) {
                    binding.istatus96x.setVisibility(View.VISIBLE);
                    //istatus88x.requestFocus();
                } else {
                    binding.istatus96x.setText(null);
                    binding.istatus96x.setVisibility(View.GONE);
                }
            }
        });
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

                Intent endSec = new Intent(this, MainActivity.class);
                startActivity(endSec);
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        MainApp.fc.setIstatus(binding.istatusa.isChecked() ? "1"
                : binding.istatusb.isChecked() ? "2"
                : binding.istatusc.isChecked() ? "3"
                : binding.istatusd.isChecked() ? "4"
                : binding.istatuse.isChecked() ? "5"
                : binding.istatusf.isChecked() ? "6"
                : binding.istatus96.isChecked() ? "96"
                : "0");

        MainApp.fc.setIstatus88x(binding.istatus96x.getText().toString());


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateEnding();

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


        return validatorClass.EmptyRadioButton(this, binding.istatus, binding.istatus96, binding.istatus96x, getString(R.string.istatus));
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }


}
