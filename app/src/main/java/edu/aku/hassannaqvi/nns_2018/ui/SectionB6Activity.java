package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB6Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionB6Activity extends AppCompatActivity {

    private final long DELAY = 1000;
    ActivitySectionB6Binding bi;
    DatabaseHelper db;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_b6);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b6);
        db = new DatabaseHelper(this);
        bi.setCallback(this);
    }

    public void BtnContinue() {

        //Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                //Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();
                int childcount = 0;
                if (MainApp.childUnder5.size() > 0) {
                    for (FamilyMembersContract fmc : MainApp.childUnder5) {
                        if (fmc.getMotherId().equals(MainApp.mc.getB1SerialNo())) {
                            childcount++;
                        }
                    }
                    if (childcount < 1) {
                        startActivity(new Intent(this, MotherEndingActivity.class)
                                .putExtra("checkingFlag", true)
                                .putExtra("complete", true));

                    } else {
                        startActivity(new Intent(this, SectionC1Activity.class));
                    }

                } else {
                    startActivity(new Intent(this, MotherEndingActivity.class)
                            .putExtra("checkingFlag", true)
                            .putExtra("complete", true));
                }

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }


    }

    public void BtnEnd() {

        MainApp.endActivityMother(this, this, false);

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }

    private boolean ValidateForm() {

        //Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyRadioButton(this, bi.nw50101, bi.nw50101a, getString(R.string.nw501a))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nw50102, bi.nw50102a, getString(R.string.nw501b))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nw50103, bi.nw50103a, getString(R.string.nw501c))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nw50104, bi.nw50104a, getString(R.string.nw501d))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nw50105, bi.nw50105a, getString(R.string.nw501e))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nw50106, bi.nw50106a, getString(R.string.nw501f))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nw50107, bi.nw50107a, getString(R.string.nw501g))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nw50108, bi.nw50108a, getString(R.string.nw501h))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nw50108, bi.nw50108a, bi.nw50108x, getString(R.string.nw501h) + " - " + getString(R.string.other))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nw50109, bi.nw50109a, getString(R.string.nw501i))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nw50109, bi.nw50109a, bi.nw50109x, getString(R.string.nw501j) + " - " + getString(R.string.other))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nw50196, bi.nw50196a, getString(R.string.nw501j))) {
            return false;
        }

        return validatorClass.EmptyRadioButton(this, bi.nw50196, bi.nw50196a, bi.nw50196x, getString(R.string.nw501j) + " - " + getString(R.string.other));
    }

    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sB6 = new JSONObject();
        //       nw501
//        60101
        sB6.put("nw50101", bi.nw50101a.isChecked() ? "1"
                : bi.nw50101b.isChecked() ? "2"
                : "0");
//        60102
        sB6.put("nw50102", bi.nw50102a.isChecked() ? "1"
                : bi.nw50102b.isChecked() ? "2"
                : "0");
//        60103
        sB6.put("nw50103", bi.nw50103a.isChecked() ? "1"
                : bi.nw50103b.isChecked() ? "2"
                : "0");
//        60104
        sB6.put("nw50104", bi.nw50104a.isChecked() ? "1"
                : bi.nw50104b.isChecked() ? "2"
                : "0");
//        60105
        sB6.put("nw50105", bi.nw50105a.isChecked() ? "1"
                : bi.nw50105b.isChecked() ? "2"
                : "0");
//        60106
        sB6.put("nw50106", bi.nw50106a.isChecked() ? "1"
                : bi.nw50106b.isChecked() ? "2"
                : "0");
//        60107
        sB6.put("nw50107", bi.nw50107a.isChecked() ? "1"
                : bi.nw50107b.isChecked() ? "2"
                : "0");
//        60108
        sB6.put("nw50108", bi.nw50108a.isChecked() ? "1"
                : bi.nw50108b.isChecked() ? "2"
                : "0");
//        60109
        sB6.put("nw50109", bi.nw50109a.isChecked() ? "1"
                : bi.nw50109b.isChecked() ? "2"
                : "0");

//        60196
        sB6.put("nw50196", bi.nw50196a.isChecked() ? "1"
                : bi.nw50196b.isChecked() ? "2"
                : "0");


        sB6.put("nw50108x", bi.nw50108x.getText().toString());
        sB6.put("nw50109x", bi.nw50109x.getText().toString());
        sB6.put("nw50196x", bi.nw50196x.getText().toString());

        MainApp.mc.setsB6(String.valueOf(sB6));


        //Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSB6();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

        //return true;

    }

    /*public boolean isWomanChild()
    {

        if(MainApp.childUnder5.size() > 0)
        {
            for (FamilyMembersContract fmc : MainApp.childUnder5)
            {
                if(fmc.getMotherId().equals(MainApp.mc.getB1SerialNo()))
                {
                    return true;
                    break;
                }else {
                    return false;

                }
            }
        }
    }*/

}
