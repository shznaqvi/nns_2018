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

        settingTimeToEat();
    }

    private void settingTimeToEat() {
//        int count = 1;
//        String text = "_"+count;
//        bi.nw501.setText(getString(R.string.text));
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

        return validatorClass.EmptyCheckBox(this, bi.fldGrpnw501check, bi.nw501a, getString(R.string.nw501a));

        //Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();
/*
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

        return validatorClass.EmptyRadioButton(this, bi.nw50196, bi.nw50196a, bi.nw50196x, getString(R.string.nw501j) + " - " + getString(R.string.other));*/
    }

    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sB6 = new JSONObject();
        //       nw501

        sB6.put("nw501a", bi.nw501a.isChecked() ? "1"
                : "2");
        sB6.put("nw501b", bi.nw501b.isChecked() ? "1"
                : "2");
        sB6.put("nw501c", bi.nw501c.isChecked() ? "1"
                : "2");
        sB6.put("nw501d", bi.nw501d.isChecked() ? "1"
                : "2");
        sB6.put("nw501e", bi.nw501e.isChecked() ? "1"
                : "2");
        sB6.put("nw501f", bi.nw501f.isChecked() ? "1"
                : "2");
        sB6.put("nw501g", bi.nw501g.isChecked() ? "1"
                : "2");
        sB6.put("nw501h", bi.nw501h.isChecked() ? "1"
                : "2");
        sB6.put("nw501i", bi.nw501i.isChecked() ? "1"
                : "2");
        sB6.put("nw501j", bi.nw501j.isChecked() ? "1"
                : "2");

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
