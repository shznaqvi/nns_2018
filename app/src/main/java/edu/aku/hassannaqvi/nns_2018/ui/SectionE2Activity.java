package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionE2Binding;

public class SectionE2Activity extends AppCompatActivity {


    ActivitySectionE2Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_e2);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e2);

        this.setTitle(getResources().getString(R.string.ne2heading));

        bi.setCallback(this);


    }

    public void BtnScan() {
        //binding.hcCode.setText(null);

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Scan the QR code of Machine");
        integrator.setCameraId(0);  // Use a specific camera of the device
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(true);
        integrator.setOrientationLocked(false);

        integrator.initiateScan();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {


                /*if (isHC) {
                    if (result.getContents().contains("HC")) {
                        Toast.makeText(this, "HC Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                        binding.hcCode.setText("§" + result.getContents().trim());
                        binding.hcCode.setEnabled(false);
                        binding.hcCode.setError(null);
                    } else {
                        binding.hcCode.setError("Please Scan correct QR code");
                    }
                }*/


            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void BtnContinue() {

//        Validation Boolean
        MainApp.validateFlag = true;

        //Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                //Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

/*
                if (counter == MainApp.all_members.size()) {

                    counter = 1;

                    startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));

                } else {

                    members.remove(binding.nd101.getSelectedItem().toString());

                    startActivity(new Intent(this, SectionD1Activity.class)
                            .putExtra("flag", true));
                }
*/

                startActivity(new Intent(this, AnthroEndingActivity.class).putExtra("complete", true));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {
        SaveDraft();
        if (UpdateDB()) {
            //Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

            //finish();

            MainApp.endAnthroActivity(this, this);

        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean formValidation() {

        //Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();


        return true;
    }

    private void SaveDraft() {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        return true;
    }
}
