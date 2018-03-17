package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivityMembersScanningBinding;

public class MembersScanningActivity extends AppCompatActivity {


    static int progress = 0;
    ActivityMembersScanningBinding binding;
    int progressStatus = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_members_scanning);
        binding.setCallback(this);

        binding.collapsingToolbar.setTitle("SCANNED MEMBERS");

    }

    public void BtnAddMembers() {
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus = doSomeWork();
                    handler.post(new Runnable() {
                        public void run() {
                            binding.progress.setProgress(progressStatus);
//                            binding.progress.setSecondaryProgress(progressStatus + 10);
                        }
                    });
                }
                handler.post(new Runnable() {
                    public void run() {
                        progress = 0;

                        IntentIntegrator integrator = new IntentIntegrator(MembersScanningActivity.this);
                        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                        integrator.setPrompt("Scan QR sticker");
                        integrator.setCameraId(0);  // Use a specific camera of the device
                        integrator.setBeepEnabled(false);
                        integrator.setBarcodeImageEnabled(true);
                        integrator.setOrientationLocked(false);

                        integrator.initiateScan();
                    }
                });
            }

            private int doSomeWork() {
                try {
                    // ---simulate doing some work---
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return ++progress;
            }
        }).start();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();

                startActivity(new Intent(this, MembersScanningInfoActivity.class)
                        .putExtra("scanData", result.getContents().trim()));

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
