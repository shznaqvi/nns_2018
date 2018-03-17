package edu.aku.hassannaqvi.nns_2018.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivityMembersScanningInfoBinding;

public class MembersScanningInfoActivity extends AppCompatActivity {

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

            JSONArray jsonArray = new JSONArray(scanData);
            JSONObject jsonObjectCC = jsonArray.getJSONObject(0);

            familyMembersContractScannedMembers.set_UID(jsonObjectCC.getString("_UID"));
            familyMembersContractScannedMembers.set_UUID(jsonObjectCC.getString("_UUID"));
            familyMembersContractScannedMembers.setName(jsonObjectCC.getString("name"));
            familyMembersContractScannedMembers.setSerialNo(jsonObjectCC.getString("serialNo"));
            familyMembersContractScannedMembers.setEnmNo(jsonObjectCC.getString("enmNo"));
            familyMembersContractScannedMembers.setHhNo(jsonObjectCC.getString("hhNo"));
            familyMembersContractScannedMembers.setType(jsonObjectCC.getString("type"));

            if (!jsonObjectCC.getString("sA2").equals(null)) {

                JSONArray jsonSA2 = new JSONArray(jsonObjectCC.getString("sA2"));

                JSONObject jsonObjectSubCC = jsonSA2.getJSONObject(0);

                for (int i = 0; i < jsonObjectSubCC.length(); i++) {

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

            }

            // Setting in string
            ScannedInfo += (familyMembersContractScannedMembers.getType().equals("1") ? "Mother" : "Child (N/A)")
                    + ":\nSerial:" + familyMembersContractScannedMembers.getSerialNo()
                    + "\nNAME:" + familyMembersContractScannedMembers.getName().toUpperCase()
                    + "\nEnumeration No:" + familyMembersContractScannedMembers.getEnmNo()
                    + "\nHHNo:" + familyMembersContractScannedMembers.getHhNo();

            for (byte i = 0; i < familyMembersContractScannedSubMembers.size(); i++) {

                FamilyMembersContract fm = familyMembersContractScannedSubMembers.get(i);

                ScannedInfo += (i + 1) + "):Serial:" + fm.getSerialNo() + "\nNAME:" + fm.getName().toUpperCase() + "\n";
            }

            binding.syncData.setText(ScannedInfo);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
