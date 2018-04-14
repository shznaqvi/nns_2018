package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.aku.hassannaqvi.nns_2018.JSONModels.JSONModelClass;
import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.contracts.SpecimenContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionE1Binding;
import edu.aku.hassannaqvi.nns_2018.other.JSONUtilClass;

public class SectionE1Activity extends AppCompatActivity {

    static List<String> members;
    static Map<String, FamilyMembersContract> membersMap;
    static String name;
    static String grouptype;
    static int counter = 1;
    ActivitySectionE1Binding bi;
    DatabaseHelper db;
    int slc_type;
    JSONModelClass json;
    FamilyMembersContract slecMem;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    int position = 0;
    static List<String> group;
    int namePosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_e1);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e1);

        this.setTitle(getResources().getString(R.string.ne1heading));

        bi.setCallback(this);
        setupViews();

    }

    public void setupViews() {

//        Setup spinner
        //  Getting Extra
        /*if (getIntent().getBooleanExtra("flag", false)) {
            members.remove(getIntent().getStringExtra("name"));
            group.remove(getIntent().getStringExtra("grouptype"));*/

        //counter++;

        slecMem = new FamilyMembersContract();

        if (getIntent().getBooleanExtra("flag", true)) {

            group = new ArrayList<>();

            group.add("....");


            if (MainApp.mwra.size() > 0) {
                group.add(getResources().getString(R.string.neselecteda));
            }
            if (MainApp.childUnder5.size() > 0) {
                group.add(getResources().getString(R.string.neselectedb));
            }

            if (MainApp.adolescents.size() > 0) {
                group.add(getResources().getString(R.string.neselectedd));
            }

            if (MainApp.minors.size() > 0) {
                group.add(getResources().getString(R.string.neselectedc));
            }
        }

        bi.ne103.setAdapter(new ArrayAdapter<>(this, R.layout.item_style, group));

        bi.ne103.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                if (bi.ne103.getSelectedItemPosition() != 0) {
                    position = i;

                    members = new ArrayList<>();
                    membersMap = new HashMap<>();
                    members.add("....");

                    familyMembersSetting(MainApp.mwra);  // 1 for Mwra
                    familyMembersSetting(MainApp.childUnder5);  // 2 for Under 5
                    familyMembersSetting(MainApp.adolescents);  // 3 for Adolescents
                    familyMembersSetting(MainApp.minors);  // 3 for minors

                    bi.ne102.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.item_style, members));

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        bi.ne102.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (bi.ne102.getSelectedItemPosition() != 0) {
                    namePosition = position;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void familyMembersSetting(List<FamilyMembersContract> family) {


        for (FamilyMembersContract fmc : family) {

            if (position == Integer.valueOf(fmc.getType())) {
                json = JSONUtilClass.getModelFromJSON(fmc.getsA2(), JSONModelClass.class);
                membersMap.put(json.getName() + "_" + json.getSerialNo(), fmc);
                members.add(json.getName() + "_" + json.getSerialNo());
            }
        }

    }

    public void BtnScanBL() {
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

    public void BtnScanUR() {
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
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {

                //finish();

                if (group.size() > 0) {

                    group.remove(position);
                    members.clear();
                    counter++;
                    finish();
                    startActivity(new Intent(this, SectionE1Activity.class).putExtra("flag", false));
                } else {
                    group.clear();
                    members.clear();
                    counter = 1;
                    startActivity(new Intent(this, MainActivity.class));
                }

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

        //Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();


        return true;
    }

    private void SaveDraft() {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        MainApp.smc = new SpecimenContract();
        MainApp.smc.setDevicetagID(MainApp.getTagName(this));
        MainApp.smc.setFormDate(slecMem.getFormDate());
        MainApp.smc.setUser(MainApp.userName);
        MainApp.smc.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.smc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.smc.setUUID(slecMem.get_UUID());
        MainApp.smc.setFMUID(slecMem.get_UID());
        MainApp.smc.setLineNo(membersMap.get(bi.ne102.getSelectedItem().toString()).getSerialNo());
        MainApp.smc.setClusterno(SpecimenInfoActivity.enm_no);
        MainApp.smc.setHhno(SpecimenInfoActivity.hh_no);


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);


        Long updcount = db.addSpecimenMembers(MainApp.smc);
        MainApp.smc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.smc.setUID(
                    (MainApp.smc.getDeviceID() + MainApp.smc.get_ID()));
            db.updateSpecimenMemberID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
        //return true;
    }

    public class SelectedMem {
        int type;
        FamilyMembersContract fmc;


        public SelectedMem(int type, FamilyMembersContract fmc) {
            this.type = type;
            this.fmc = fmc;
        }

        public int getType() {
            return type;
        }


        public FamilyMembersContract getFmc() {
            return fmc;
        }
    }
}

