package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.contracts.FormsContract;
import edu.aku.hassannaqvi.nns_2018.contracts.WaterSpecimenContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionE2Binding;
import edu.aku.hassannaqvi.nns_2018.validation.clearClass;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionE2Activity extends AppCompatActivity {


    private static final String TAG = SectionE2Activity.class.getSimpleName();
    ActivitySectionE2Binding bi;
    Boolean isMicro = false, isNitric = false, isBoric = false, isPlain = false, isQC = false, isField = false;

    //FamilyMembersContract fmc;
    Map<Integer, FamilyMembersContract> membersMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_e2);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e2);
        this.setTitle(getResources().getString(R.string.ne2heading));
        bi.setCallback(this);


        membersMap = new HashMap<>();

        for (FamilyMembersContract fmc : MainApp.all_members) {
            membersMap.put(0, fmc);
        }


        bi.ne201a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    clearClass.ClearAllFields(bi.fldGrpMicro, true);
                    bi.btnScanMicro.setEnabled(true);
                } else {
                    clearClass.ClearAllFields(bi.fldGrpMicro, false);
                    bi.btnScanMicro.setEnabled(false);
                }
            }
        });

        bi.ne201b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    clearClass.ClearAllFields(bi.fldGrpNirtric, true);
                    bi.btnScanNitric.setEnabled(true);
                } else {
                    clearClass.ClearAllFields(bi.fldGrpNirtric, false);
                    bi.btnScanNitric.setEnabled(false);
                }
            }
        });

        bi.ne201c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    clearClass.ClearAllFields(bi.fldGrpBoric, true);
                    bi.btnScanBoric.setEnabled(true);
                } else {
                    clearClass.ClearAllFields(bi.fldGrpBoric, false);
                    bi.btnScanBoric.setEnabled(false);
                }
            }
        });

        bi.ne201d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    clearClass.ClearAllFields(bi.fldGrpPlain, true);
                    bi.btnScanPlain.setEnabled(true);
                } else {
                    clearClass.ClearAllFields(bi.fldGrpPlain, false);
                    bi.btnScanPlain.setEnabled(false);
                }
            }
        });


        bi.ne201e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    clearClass.ClearAllFields(bi.fldGrpQC, true);
                    bi.btnScanQC.setEnabled(true);
                } else {
                    clearClass.ClearAllFields(bi.fldGrpQC, false);
                    bi.btnScanQC.setEnabled(false);
                }
            }
        });

        bi.ne201f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    clearClass.ClearAllFields(bi.fldGrpField, true);
                    bi.btnScanField.setEnabled(true);
                } else {
                    clearClass.ClearAllFields(bi.fldGrpField, false);
                    bi.btnScanField.setEnabled(false);
                }
            }
        });


        bi.ne20201.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.ne20201a.isChecked()) {
                    clearClass.ClearAllFields(bi.fldGrpne20301, true);
                    bi.btnScanMicro.setEnabled(true);
                } else {
                    clearClass.ClearAllFields(bi.fldGrpne20301, false);
                    bi.btnScanMicro.setEnabled(false);
                }
            }
        });

        bi.ne20202.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.ne20202a.isChecked()) {
                    clearClass.ClearAllFields(bi.fldGrpneNitric, true);
                    bi.btnScanNitric.setEnabled(true);
                } else {
                    clearClass.ClearAllFields(bi.fldGrpneNitric, false);
                    bi.btnScanNitric.setEnabled(false);
                }
            }
        });


        bi.ne20203.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.ne20203a.isChecked()) {
                    clearClass.ClearAllFields(bi.fldGrpneBoric, true);
                    bi.btnScanBoric.setEnabled(true);
                } else {
                    clearClass.ClearAllFields(bi.fldGrpneBoric, false);
                    bi.btnScanBoric.setEnabled(false);
                }
            }
        });

        bi.ne20204.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.ne20204a.isChecked()) {
                    clearClass.ClearAllFields(bi.fldGrpnePlain, true);
                    bi.btnScanPlain.setEnabled(true);
                } else {
                    clearClass.ClearAllFields(bi.fldGrpnePlain, false);
                    bi.btnScanPlain.setEnabled(false);
                }
            }
        });

        bi.ne20205.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.ne20205a.isChecked()) {
                    clearClass.ClearAllFields(bi.fldGrpneQC, true);
                    bi.btnScanQC.setEnabled(true);
                } else {
                    clearClass.ClearAllFields(bi.fldGrpneQC, false);
                    bi.btnScanQC.setEnabled(false);
                }
            }
        });

        bi.ne20206.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.ne20206a.isChecked()) {
                    clearClass.ClearAllFields(bi.fldGrpneField, true);
                    bi.btnScanNitric.setEnabled(true);
                } else {
                    clearClass.ClearAllFields(bi.fldGrpneField, false);
                    bi.btnScanField.setEnabled(false);
                }
            }
        });

    }


    public void BtnScanMirco() {
        //binding.hcCode.setText(null);
        isMicro = true;
        isPlain = false;
        isNitric = false;
        isBoric = false;
        isField = false;
        isQC = false;

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Scan the QR code of Machine");
        integrator.setCameraId(0);  // Use a specific camera of the device
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(true);
        integrator.setOrientationLocked(false);

        integrator.initiateScan();

    }

    public void BtnScanNitric() {
        //binding.hcCode.setText(null);
        isNitric = true;
        isPlain = false;
        isMicro = false;
        isBoric = false;
        isField = false;
        isQC = false;

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Scan the QR code of Machine");
        integrator.setCameraId(0);  // Use a specific camera of the device
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(true);
        integrator.setOrientationLocked(false);

        integrator.initiateScan();

    }

    public void BtnScanBoric() {
        //binding.hcCode.setText(null);

        isBoric = true;
        isPlain = false;
        isMicro = false;
        isNitric = false;
        isField = false;
        isQC = false;

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Scan the QR code of Machine");
        integrator.setCameraId(0);  // Use a specific camera of the device
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(true);
        integrator.setOrientationLocked(false);

        integrator.initiateScan();

    }

    public void BtnScanPlain() {
        //binding.hcCode.setText(null);

        isPlain = true;
        isMicro = false;
        isNitric = false;
        isBoric = false;
        isField = false;
        isQC = false;

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Scan the QR code of Machine");
        integrator.setCameraId(0);  // Use a specific camera of the device
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(true);
        integrator.setOrientationLocked(false);

        integrator.initiateScan();

    }

    public void BtnScanQC() {
        //binding.hcCode.setText(null);
        isQC = true;
        isMicro = false;
        isNitric = false;
        isBoric = false;
        isField = false;
        isPlain = false;

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Scan the QR code of Machine");
        integrator.setCameraId(0);  // Use a specific camera of the device
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(true);
        integrator.setOrientationLocked(false);

        integrator.initiateScan();

    }

    public void BtnScanField() {
        //binding.hcCode.setText(null);

        isField = true;
        isMicro = false;
        isNitric = false;
        isBoric = false;
        isQC = false;
        isPlain = false;

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
                if (isMicro) {
                    if (result.getContents().contains("HM")) {
                        Toast.makeText(this, "HM Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                        bi.ne20301.setText("§" + result.getContents().trim());
                        bi.ne20301.setEnabled(false);
                        bi.ne20301.setError(null);
                    } else {
                        bi.ne20301.setError("Please Scan correct QR code");
                    }
                } else if (isNitric) {
                    if (result.getContents().contains("HN")) {
                        Toast.makeText(this, "HN Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                        bi.ne20302.setText("§" + result.getContents().trim());
                        bi.ne20302.setEnabled(false);
                        bi.ne20302.setError(null);
                    } else {
                        bi.ne20302.setError("Please Scan correct QR code");
                    }
                } else if (isBoric) {
                    if (result.getContents().contains("HB")) {
                        Toast.makeText(this, "HB Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                        bi.ne20303.setText("§" + result.getContents().trim());
                        bi.ne20303.setEnabled(false);
                        bi.ne20303.setError(null);
                    } else {
                        bi.ne20303.setError("Please Scan correct QR code");
                    }
                } else if (isPlain) {
                    if (result.getContents().contains("HP")) {
                        Toast.makeText(this, "HP Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                        bi.ne20304.setText("§" + result.getContents().trim());
                        bi.ne20304.setEnabled(false);
                        bi.ne20304.setError(null);
                    } else {
                        bi.ne20304.setError("Please Scan correct QR code");
                    }
                } else if (isQC) {
                    if (result.getContents().contains("HQ")) {
                        Toast.makeText(this, "HQ Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                        bi.ne20305.setText("§" + result.getContents().trim());
                        bi.ne20305.setEnabled(false);
                        bi.ne20305.setError(null);
                    } else {
                        bi.ne20305.setError("Please Scan correct QR code");
                    }
                } else if (isField) {
                    if (result.getContents().contains("HF")) {
                        Toast.makeText(this, "HF Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                        bi.ne20306.setText("§" + result.getContents().trim());
                        bi.ne20306.setEnabled(false);
                        bi.ne20306.setError(null);
                    } else {
                        bi.ne20306.setError("Please Scan correct QR code");
                    }
                }

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
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (UpdateDB()) {
                //Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (UpdateDB()) {
            //Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

            //finish();

            MainApp.endAnthroActivity(this, this);

        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean formValidation() {

        int scanChar;

        //Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();
        if (!(bi.ne201a.isChecked() || bi.ne201b.isChecked() || bi.ne201c.isChecked() || bi.ne201d.isChecked()
                || bi.ne201e.isChecked() || bi.ne201f.isChecked())) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.ne201), Toast.LENGTH_LONG).show();
            bi.ne201a.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "ne201: This data is Required!");
            return false;
        } else {
            bi.ne201a.setError(null);
        }

        if (!bi.ne201a.isChecked() && (bi.ne201b.isChecked() || bi.ne201c.isChecked() || bi.ne201d.isChecked()
                || bi.ne201e.isChecked() || bi.ne201f.isChecked())) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.ne201a), Toast.LENGTH_LONG).show();
            bi.ne201a.setError("Please Select Micro Testing first...");    // Set Error on last radio button

            Log.i(TAG, "ne201a: This data is Required!");
            return false;
        } else {
            bi.ne201a.setError(null);
        }

        if (bi.ne201a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.ne20201, bi.ne20201a, getString(R.string.ne202a))) {
                return false;
            }

            if (bi.ne20201a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ne20301, getString(R.string.ne203))) {
                    return false;
                }

                if (bi.ne20301.getText().toString().contains("§")) {
                    scanChar = 19;
                } else {
                    scanChar = 18;
                }

                if (bi.ne20301.getText().length() != scanChar || !bi.ne20301.getText().toString().contains("-")
                        || !bi.ne20301.getText().toString().contains("HM")) {
                    Toast.makeText(this, "ERROR(invalid)" + getString(R.string.ne203), Toast.LENGTH_SHORT).show();
                    bi.ne20301.setError("Invalid or Incomplete QR code..");

                    Log.i(TAG, "ne20301: Invalid Bar code");
                    return false;
                } else {
                    bi.ne20301.setError(null);
                }

            }
        }

        if (bi.ne201b.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.ne20202, bi.ne20202a, getString(R.string.ne202b))) {
                return false;
            }

            if (bi.ne20202a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ne20302, getString(R.string.ne203))) {
                    return false;
                }

                if (bi.ne20302.getText().toString().contains("§")) {
                    scanChar = 19;
                } else {
                    scanChar = 18;
                }

                if (bi.ne20302.getText().length() != scanChar || !bi.ne20302.getText().toString().contains("-")
                        || !bi.ne20302.getText().toString().contains("HN")) {
                    Toast.makeText(this, "ERROR(invalid)" + getString(R.string.ne203), Toast.LENGTH_SHORT).show();
                    bi.ne20302.setError("Invalid or Incomplete QR code..");

                    Log.i(TAG, "ne20302: Invalid Bar code");
                    return false;
                } else {
                    bi.ne20302.setError(null);
                }

            }
        }


        if (bi.ne201c.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.ne20203, bi.ne20203a, getString(R.string.ne202c))) {
                return false;
            }

            if (bi.ne20203a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ne20303, getString(R.string.ne203))) {
                    return false;
                }

                if (bi.ne20303.getText().toString().contains("§")) {
                    scanChar = 19;
                } else {
                    scanChar = 18;
                }

                if (bi.ne20303.getText().length() != scanChar || !bi.ne20303.getText().toString().contains("-")
                        || !bi.ne20303.getText().toString().contains("HB")) {
                    Toast.makeText(this, "ERROR(invalid)" + getString(R.string.ne203), Toast.LENGTH_SHORT).show();
                    bi.ne20303.setError("Invalid or Incomplete QR code..");

                    Log.i(TAG, "ne20303: Invalid Bar code");
                    return false;
                } else {
                    bi.ne20303.setError(null);
                }

            }
        }

        if (bi.ne201d.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.ne20204, bi.ne20204a, getString(R.string.ne202d))) {
                return false;
            }

            if (bi.ne20204a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ne20304, getString(R.string.ne203))) {
                    return false;
                }

                if (bi.ne20304.getText().toString().contains("§")) {
                    scanChar = 19;
                } else {
                    scanChar = 18;
                }

                if (bi.ne20304.getText().length() != scanChar || !bi.ne20304.getText().toString().contains("-")
                        || !bi.ne20304.getText().toString().contains("HP")) {
                    Toast.makeText(this, "ERROR(invalid)" + getString(R.string.ne203), Toast.LENGTH_SHORT).show();
                    bi.ne20304.setError("Invalid or Incomplete QR code..");

                    Log.i(TAG, "ne20304: Invalid Bar code");
                    return false;
                } else {
                    bi.ne20304.setError(null);
                }

            }
        }

        if (bi.ne201e.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.ne20205, bi.ne20205a, getString(R.string.ne202e))) {
                return false;
            }

            if (bi.ne20205a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ne20305, getString(R.string.ne203))) {
                    return false;
                }

                if (bi.ne20305.getText().toString().contains("§")) {
                    scanChar = 19;
                } else {
                    scanChar = 18;
                }

                if (bi.ne20305.getText().length() != scanChar || !bi.ne20305.getText().toString().contains("-")
                        || !bi.ne20305.getText().toString().contains("HQ")) {
                    Toast.makeText(this, "ERROR(invalid)" + getString(R.string.ne203), Toast.LENGTH_SHORT).show();
                    bi.ne20305.setError("Invalid or Incomplete QR code..");

                    Log.i(TAG, "ne20305: Invalid Bar code");
                    return false;
                } else {
                    bi.ne20305.setError(null);
                }

            }
        }

        if (bi.ne201f.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.ne20206, bi.ne20206a, getString(R.string.ne202f))) {
                return false;
            }

            if (bi.ne20206a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ne20306, getString(R.string.ne203))) {
                    return false;
                }

                if (bi.ne20306.getText().toString().contains("§")) {
                    scanChar = 19;
                } else {
                    scanChar = 18;
                }

                if (bi.ne20306.getText().length() != scanChar || !bi.ne20306.getText().toString().contains("-")
                        || !bi.ne20306.getText().toString().contains("FB")) {
                    Toast.makeText(this, "ERROR(invalid)" + getString(R.string.ne203), Toast.LENGTH_SHORT).show();
                    bi.ne20306.setError("Invalid or Incomplete QR code..");

                    Log.i(TAG, "ne20306: Invalid Bar code");
                    return false;
                } else {
                    bi.ne20306.setError(null);
                }

            }
        }


        return true;
    }

    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        MainApp.wsc = new WaterSpecimenContract();
        MainApp.wsc.setDevicetagID(MainApp.getTagName(this));
        MainApp.wsc.setFormDate(membersMap.get(0).getFormDate());
        MainApp.wsc.setUser(MainApp.userName);
        MainApp.wsc.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.wsc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.wsc.setUUID(membersMap.get(0).get_UUID());

        MainApp.wsc.setClusterno(SpecimenInfoActivity.enm_no);
        MainApp.wsc.setHhno(SpecimenInfoActivity.hh_no);

        JSONObject sE1 = new JSONObject();

        sE1.put("ne_selected_water", String.valueOf(SpecimenInfoActivity.selected));
        sE1.put("start_time", SpecimenInfoActivity.datetime);
        sE1.put("ne201a", bi.ne201a.isChecked() ? "1" : "2");
        sE1.put("ne20201", bi.ne20201a.isChecked() ? "1" : bi.ne20201b.isChecked() ? "2" : "0");
        sE1.put("ne20301", bi.ne20301.getText().toString());

        sE1.put("ne201b", bi.ne201b.isChecked() ? "1" : "2");
        sE1.put("ne20202", bi.ne20202a.isChecked() ? "1" : bi.ne20202b.isChecked() ? "2" : "0");
        sE1.put("ne20302", bi.ne20302.getText().toString());

        sE1.put("ne201c", bi.ne201c.isChecked() ? "1" : "2");
        sE1.put("ne20203", bi.ne20203a.isChecked() ? "1" : bi.ne20203b.isChecked() ? "2" : "0");
        sE1.put("ne20303", bi.ne20303.getText().toString());

        sE1.put("ne201d", bi.ne201d.isChecked() ? "1" : "2");
        sE1.put("ne20204", bi.ne20204a.isChecked() ? "1" : bi.ne20204b.isChecked() ? "2" : "0");
        sE1.put("ne20304", bi.ne20304.getText().toString());

        sE1.put("ne201e", bi.ne201e.isChecked() ? "1" : "2");
        sE1.put("ne20205", bi.ne20205a.isChecked() ? "1" : bi.ne20205b.isChecked() ? "2" : "0");
        sE1.put("ne20305", bi.ne20305.getText().toString());

        sE1.put("ne201f", bi.ne201f.isChecked() ? "1" : "2");
        sE1.put("ne20206", bi.ne20206a.isChecked() ? "1" : bi.ne20206b.isChecked() ? "2" : "0");
        sE1.put("ne20306", bi.ne20306.getText().toString());

        sE1.put("end_time", new SimpleDateFormat("dd-MM-yyyy HH:mm").format(System.currentTimeMillis()));

        MainApp.wsc.setsE2(String.valueOf(sE1));


        // Set summary fields
        FormsContract fc = new FormsContract();
        fc.setClusterNo(MainApp.wsc.getClusterno());
        fc.setHhNo(MainApp.wsc.getHhno());
        fc.setDevicetagID(MainApp.wsc.getDevicetagID());
        fc.setFormDate(MainApp.wsc.getFormDate());
        fc.setUser(MainApp.wsc.getUser());
        fc.setDeviceID(MainApp.wsc.getDeviceID());
        fc.setAppversion(MainApp.wsc.getAppversion());
        MainApp.sumc = MainApp.AddSummary(fc, 6);

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();


    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        Long updcount = db.addWaterSpecimenForm(MainApp.wsc);
        MainApp.wsc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.wsc.setUID(
                    (MainApp.wsc.getDeviceID() + MainApp.wsc.get_ID()));
            db.updateWaterSpecimenMemberID();

            return MainApp.UpdateSummary(this, db, 6);

        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }


        //return true;
    }
}
