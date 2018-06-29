package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.text.SimpleDateFormat;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivityAnthroEndingBinding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class AnthroEndingActivity extends AppCompatActivity {

    private static final String TAG = AnthroEndingActivity.class.getSimpleName();

    ActivityAnthroEndingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_anthro_ending);
        binding.setCallback(this);

        Boolean check = getIntent().getExtras().getBoolean("complete");

        if (check) {
            binding.istatusa.setEnabled(true);
            binding.istatusb.setEnabled(false);
            binding.istatusc.setEnabled(false);
            binding.istatusd.setEnabled(false);
        } else {
            binding.istatusa.setEnabled(false);
            binding.istatusb.setEnabled(true);
            binding.istatusc.setEnabled(true);
            binding.istatusd.setEnabled(true);

        }

       /* binding.istatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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
        });*/
    }

    public void BtnEnd() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {

                finish();

                if (SectionD1Activity.counter == MainApp.all_members.size()) {

                    SectionD1Activity.counter = 1;
                    MainApp.all_members.clear();
                    SectionD1Activity.members.clear();
                    SectionD1Activity.membersMap.clear();
                    startActivity(new Intent(this, MainActivity.class));

                } else {


                    startActivity(new Intent(this, SectionD1Activity.class)
                            .putExtra("flag", true).putExtra("name", SectionD1Activity.name));
                }

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void SaveDraft() {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        MainApp.emc.setIstatus(binding.istatusa.isChecked() ? "1"
                : binding.istatusb.isChecked() ? "2"
                : binding.istatusc.isChecked() ? "3"
                : binding.istatusd.isChecked() ? "4"
                : "0");

        MainApp.emc.setEnd_time(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(System.currentTimeMillis()));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateAnthroEnding();

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


        return validatorClass.EmptyRadioButton(this, binding.istatus, binding.istatusa, getString(R.string.istatus));


    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }


}
