package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import edu.aku.hassannaqvi.nns_2018.JSONModels.JSONModelClass;
import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.EnumBlockContract;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySpecimenInfoBinding;
import edu.aku.hassannaqvi.nns_2018.other.JSONUtilClass;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;


public class SpecimenInfoActivity extends AppCompatActivity {

    private static final String TAG = SpecimenInfoActivity.class.getName();
    static String enm_no;
    static String hh_no;
    static String hc_code;
    static String ht_code;
    static String wt_code;
    JSONModelClass json;
    ActivitySpecimenInfoBinding binding;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    DatabaseHelper db;
    Collection<FamilyMembersContract> members;
    Boolean isHC = false, isHT = false, isWT = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_specimen_info);
        db = new DatabaseHelper(this);
        binding.setCallback(this);

        SetupViewFunctionality();

    }

    public void SetupViewFunctionality() {

        MainApp.all_members = new ArrayList<>();
        MainApp.childUnder2 = new ArrayList<>();
        MainApp.childUnder5 = new ArrayList<>();
        MainApp.childNA = new ArrayList<>();
        MainApp.mwra = new ArrayList<>();
        MainApp.adolescents = new ArrayList<>();
        MainApp.minors = new ArrayList<>();
        MainApp.childUnder2Check = new ArrayList<>();
        members = new ArrayList<>();
        json = new JSONModelClass();

        if (MainActivity.ftype.equals("B")) {
            binding.fldGrpQR.setVisibility(View.VISIBLE);
            binding.fldGrpHC.setVisibility(View.VISIBLE);

        } else if (MainActivity.ftype.equals("W")) {
            binding.fldGrpQR.setVisibility(View.GONE);
            binding.hcCode.setText(null);

        }


        //slcMem = new ArrayList<>();
        binding.nh102.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.nh108.setText(null);
                binding.fldGrpnh101.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


//        FamilyMembersList initialization


//        HH listener
        binding.nh108.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                binding.nh108.setInputType(InputType.TYPE_CLASS_NUMBER);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                //clearFields();

                if (!binding.nh108.getText().toString().isEmpty() && binding.nh108.getText().toString().length() == 4) {
                    if (binding.nh108.getText().toString().substring(0, 3).matches("[0-9]+")) {
                        binding.nh108.setText(binding.nh108.getText().toString() + "-");
                        binding.nh108.setSelection(binding.nh108.getText().length());
                        binding.nh108.setInputType(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);

                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }


    public void BtnContinue() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {

            SaveDraft();

            if (UpdateDB()) {
                //Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();
                finish();

                startActivity(new Intent(this, SectionE1Activity.class));


            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {

        Toast.makeText(this, "Processing End Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {

            SaveDraft();

            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean formValidation() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//        nh102
        if (!validatorClass.EmptyTextBox(this, binding.nh102, getString(R.string.nh102))) {
            return false;
        }

//        nh108

        if (binding.nh108.getText().toString().length() == 6) {
            String[] str = binding.nh108.getText().toString().split("-");
            if (str.length > 2 || binding.nh108.getText().toString().charAt(4) != '-' || !str[0].matches("[0-9]+") || !str[1].matches("[a-zA-Z]")) {
                binding.nh108.setError("Wrong presentation!!");
                return false;
            }
        } else {
            Toast.makeText(this, "Invalid length: " + getString(R.string.nh108), Toast.LENGTH_SHORT).show();
            binding.nh108.setError("Invalid length");
            return false;
        }

        int scanChar;

        if (MainActivity.ftype.equals("B")) {
            if (!validatorClass.EmptyTextBox(this, binding.hcCode, getString(R.string.hc))) {
                return false;
            }

            if (binding.hcCode.getText().toString().contains("§")) {
                scanChar = 7;
            } else {
                scanChar = 6;
            }

            if (binding.hcCode.getText().length() != scanChar || !binding.hcCode.getText().toString().contains("-")
                    || !binding.hcCode.getText().toString().contains("HC")) {
                Toast.makeText(this, "ERROR(invalid)" + getString(R.string.hc), Toast.LENGTH_SHORT).show();
                binding.hcCode.setError("Invalid Number..");

                Log.i(TAG, "hcCode: Invalid number");
                return false;
            } else {
                binding.hcCode.setError(null);
            }
        }


        /*if(MainActivity.ftype.equals("A")) {
            if (!validatorClass.EmptyTextBox(this, binding.htCode, getString(R.string.ht))) {
                return false;
            }

            if (binding.htCode.getText().toString().contains("§")) {
                scanChar = 7;
            } else {
                scanChar = 6;
            }

            if (binding.htCode.getText().length() != scanChar || !binding.htCode.getText().toString().contains("-")
                    || !binding.htCode.getText().toString().contains("HT")) {
                Toast.makeText(this, "ERROR(invalid)" + getString(R.string.ht), Toast.LENGTH_SHORT).show();
                binding.htCode.setError("Invalid Number..");

                Log.i(TAG, "htCode: Invalid number");
                return false;
            } else {
                binding.htCode.setError(null);
            }

            if (!validatorClass.EmptyTextBox(this, binding.wtCode, getString(R.string.wt))) {
                return false;
            }

            if (binding.wtCode.getText().toString().contains("§")) {
                scanChar = 7;
            } else {
                scanChar = 6;
            }

            if (binding.wtCode.getText().length() != scanChar || !binding.wtCode.getText().toString().contains("-")
                    || !binding.wtCode.getText().toString().contains("WT")) {
                Toast.makeText(this, "ERROR(invalid)" + getString(R.string.wt), Toast.LENGTH_SHORT).show();
                binding.wtCode.setError("Invalid Number..");

                Log.i(TAG, "wtCode: Invalid number");
                return false;
            } else {
                binding.wtCode.setError(null);
            }
        }
*/


        return true;
    }

    private void SaveDraft() {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        enm_no = binding.nh102.getText().toString();
        hh_no = binding.nh108.getText().toString().toUpperCase();
        hc_code = binding.hcCode.getText().toString();
        //ht_code = binding.htCode.getText().toString();
        //wt_code = binding.wtCode.getText().toString();


    }


    private boolean UpdateDB() {

        return true;
    }

    public void BtnCheckHH() {

        if (!binding.nh102.getText().toString().trim().isEmpty() && !binding.nh108.getText().toString().trim().isEmpty()) {

            members = db.getAllMembersByHHforAnthro(binding.nh102.getText().toString(), binding.nh108.getText().toString().toUpperCase());

            if (members.size() != 0) {
                for (FamilyMembersContract fm : members) {

                    if (fm.getsA2() != null) {
                        json = JSONUtilClass.getModelFromJSON(fm.getsA2(), JSONModelClass.class);
                        if ((Integer.valueOf(json.getAge()) > 14 && Integer.valueOf(json.getAge()) < 50)
                                && json.getGender().equals("2") && json.getNh210().equals("1")) {
                            MainApp.mwra.add(fm);
                            MainApp.all_members.add(fm);
                        }
                        if ((Integer.valueOf(json.getAge()) >= 10 && (Integer.valueOf(json.getAge()) < 20))
                                && json.getGender().equals("2") && json.getNh210().equals("1")) {
                            MainApp.adolescents.add(fm);
                            MainApp.all_members.add(fm);
                        }

                        if ((Integer.valueOf(json.getAge()) >= 6 && (Integer.valueOf(json.getAge()) < 13))
                                && json.getNh210().equals("1")) {
                            MainApp.minors.add(fm);
                            MainApp.all_members.add(fm);
                        }

                        if (Integer.valueOf(json.getAge()) < 6 && json.getNh210().equals("1")) {
                            MainApp.childUnder5.add(fm);
                            MainApp.all_members.add(fm);
                        }

                    }

                }
                if (MainApp.all_members.size() > 0) {
                    Toast.makeText(this, "Members Found..", Toast.LENGTH_SHORT).show();
                    binding.fldGrpQR.setVisibility(View.VISIBLE);
                    binding.btnContinue.setVisibility(View.VISIBLE);
                    binding.btnEnd.setVisibility(View.GONE);

                } else {
                    binding.fldGrpQR.setVisibility(View.GONE);
                    binding.hcCode.setText(null);
                    //binding.htCode.setText(null);
                    //binding.wtCode.setText(null);
                    binding.btnContinue.setVisibility(View.GONE);
                    binding.btnEnd.setVisibility(View.GONE);
                    Toast.makeText(this, "No Eligible member found for anthropometry, Check another HH.", Toast.LENGTH_SHORT).show();
                }


            } else {
                Toast.makeText(this, "No members found for the HH.", Toast.LENGTH_SHORT).show();
            }


        } else {
            Toast.makeText(this, "Not found.", Toast.LENGTH_SHORT).show();
        }

    }

    public void BtnCheckEnm() {

        if (validatorClass.EmptyTextBox(this, binding.nh102, getString(R.string.nh102))) {

            EnumBlockContract enumBlockContract = db.getEnumBlock(binding.nh102.getText().toString());
            if (enumBlockContract != null) {
                String selected = enumBlockContract.getGeoarea();
                if (!selected.equals("")) {

                    String[] selSplit = selected.split("\\|");

                    binding.nh103.setText(selSplit[0]);
                    binding.nh104.setText(selSplit[1].equals("") ? "----" : selSplit[1]);
                    binding.nh105.setText(selSplit[2].equals("") ? "----" : selSplit[2]);
                    binding.nh106.setText(selSplit[3]);

                    binding.fldGrpnh101.setVisibility(View.VISIBLE);
                }
            } else {
                binding.nh108.setText(null);
                Toast.makeText(this, "Sorry not found any block", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void BtnScanHC() {
        //binding.hcCode.setText(null);
        isHC = true;
        isWT = false;
        isHT = false;

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Scan the QR code of Machine");
        integrator.setCameraId(0);  // Use a specific camera of the device
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(true);
        integrator.setOrientationLocked(false);

        integrator.initiateScan();

    }

/*
    public void BtnScanHT() {
        //binding.hcCode.setText(null);
        isHT = true;
        isWT = false;
        isHC = false;
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Scan the QR code of Machine");
        integrator.setCameraId(0);  // Use a specific camera of the device
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(true);
        integrator.setOrientationLocked(false);

        integrator.initiateScan();

    }

    public void BtnScanWT() {
        //binding.hcCode.setText(null);
        isWT = true;
        isHT = false;
        isHC = false;
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Scan the QR code of Machine");
        integrator.setCameraId(0);  // Use a specific camera of the device
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(true);
        integrator.setOrientationLocked(false);

        integrator.initiateScan();

    }
*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {


                if (isHC) {
                    if (result.getContents().contains("HC")) {
                        Toast.makeText(this, "HC Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                        binding.hcCode.setText("§" + result.getContents().trim());
                        binding.hcCode.setEnabled(false);
                        binding.hcCode.setError(null);
                    } else {
                        binding.hcCode.setError("Please Scan correct QR code");
                    }
                }


            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}
