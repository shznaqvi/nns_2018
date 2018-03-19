package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivityMembersScanningInfoBinding;

public class MembersScanningInfoActivity extends AppCompatActivity {

    private static final String TAG = MembersScanningInfoActivity.class.getName();
    ActivityMembersScanningInfoBinding binding;
    FamilyMembersContract familyMembersContractScannedMembers;
    List<FamilyMembersContract> familyMembersContractScannedSubMembers;

    private String ScannedInfo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_members_scanning_info);
        binding.setCallback(this);

        String scanData = getIntent().getStringExtra("scanData");

        if (!scanData.equals("")) {
            scanJSON(scanData);
        }
    }

    private void scanJSON(String scanData) {

        try {

            familyMembersContractScannedMembers = new FamilyMembersContract();
            familyMembersContractScannedSubMembers = new ArrayList<>();

            JSONObject jsonObjectCC = new JSONObject(scanData);

            familyMembersContractScannedMembers.set_UID(jsonObjectCC.getString("_UID"));
            familyMembersContractScannedMembers.set_UUID(jsonObjectCC.getString("_UUID"));
            familyMembersContractScannedMembers.setName(jsonObjectCC.getString("name"));
            familyMembersContractScannedMembers.setSerialNo(jsonObjectCC.getString("serialNo"));
            familyMembersContractScannedMembers.setEnmNo(jsonObjectCC.getString("enmNo"));
            familyMembersContractScannedMembers.setHhNo(jsonObjectCC.getString("hhNo"));
            familyMembersContractScannedMembers.setType(jsonObjectCC.getString("type"));

            if (!jsonObjectCC.getString("sA2").equals("")) {

                JSONArray jsonSA2 = new JSONArray(jsonObjectCC.getString("sA2"));


                for (int i = 0; i < jsonSA2.length(); i++) {

                    JSONObject jsonObjectSubCC = jsonSA2.getJSONObject(i);

                    FamilyMembersContract fmc = new FamilyMembersContract();

                    fmc.set_UID(jsonObjectSubCC.getString("_UID"));
                    fmc.set_UUID(jsonObjectSubCC.getString("_UUID"));
                    fmc.setName(jsonObjectSubCC.getString("name"));
                    fmc.setSerialNo(jsonObjectSubCC.getString("serialNo"));
                    fmc.setEnmNo(jsonObjectSubCC.getString("enmNo"));
                    fmc.setHhNo(jsonObjectSubCC.getString("hhNo"));
                    fmc.setType(jsonObjectCC.getString("type"));

                    familyMembersContractScannedSubMembers.add(fmc);
                }

                MainApp.scannedMembersSubList.add(familyMembersContractScannedSubMembers);
            }

            // Setting in string
            ScannedInfo += (familyMembersContractScannedMembers.getType().equals("1") ? "Mother" : "Child (N/A)")
                    + ":\nSerial:" + familyMembersContractScannedMembers.getSerialNo()
                    + "\nNAME:" + familyMembersContractScannedMembers.getName().toUpperCase()
                    + "\nEnumeration No:" + familyMembersContractScannedMembers.getEnmNo()
                    + "\nHHNo:" + familyMembersContractScannedMembers.getHhNo();

            for (byte i = 0; i < familyMembersContractScannedSubMembers.size(); i++) {

                FamilyMembersContract fm = familyMembersContractScannedSubMembers.get(i);

                ScannedInfo += "\n" + (i + 1) + "):Serial:" + fm.getSerialNo() + "\nNAME:" + fm.getName().toUpperCase() + "\n";
            }

            if (!ScannedInfo.equals("")) {
                binding.syncData.setText(ScannedInfo);

                MainApp.scannedMembersList.add(familyMembersContractScannedMembers);

                binding.btnContinue.setEnabled(true);

            } else {
                Toast.makeText(this, "Sorry can't parse QR-Image!!", Toast.LENGTH_SHORT).show();
            }


        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Sorry can't parse QR-Image!!", Toast.LENGTH_SHORT).show();
            binding.btnContinue.setEnabled(false);
        }

    }

    public void BtnReScan() {
        MainApp.openQRScanner(MembersScanningInfoActivity.this);
    }

    public void BtnContinue() {
        finish();
        startActivity(new Intent(this, MembersScanningActivity.class)
                .putExtra("reBackActivity", false));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();

                scanJSON(result.getContents().trim());

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
