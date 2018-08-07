package edu.aku.hassannaqvi.nns_2018_validation.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.aku.hassannaqvi.nns_2018_validation.JSONModels.JSONA5ModelClass;
import edu.aku.hassannaqvi.nns_2018_validation.R;
import edu.aku.hassannaqvi.nns_2018_validation.contracts.FormsContract;
import edu.aku.hassannaqvi.nns_2018_validation.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018_validation.core.MainApp;
import edu.aku.hassannaqvi.nns_2018_validation.databinding.ActivitySectionH8infoBinding;
import edu.aku.hassannaqvi.nns_2018_validation.other.JSONUtilClass;
import edu.aku.hassannaqvi.nns_2018_validation.validation.validatorClass;

public class SectionH8infoActivity extends AppCompatActivity {
    ActivitySectionH8infoBinding bi;
    int prevDeceasedCounter = 0;
    static int deceasedCounter = 0;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h8info);
        bi.setCallback(this);
        db = new DatabaseHelper(this);
        this.setTitle(getResources().getString(R.string.nh8heading));

        if (SectionA1Activity.editFormFlag) {
            AutoPopulate();
        }
    }

    public boolean formValidation() {


        if (!validatorClass.EmptyRadioButton(this, bi.nh801, bi.nh801a, getString(R.string.nh801))) {
            return false;
        }

        if (bi.nh801a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.nh802, getString(R.string.nh802))) {
                return false;
            }

            if (SectionA1Activity.editFormFlag) {
                if (Integer.valueOf(bi.nh802.getText().toString()) > prevDeceasedCounter) {
                    Toast.makeText(this, "Can't increase Deceased!", Toast.LENGTH_SHORT).show();
                    return false;
                }
            } else {
                return validatorClass.RangeTextBox(this, bi.nh802, 1, 99, getString(R.string.nh802), " Deceased");
            }
        }

        return true;
    }

    private void SaveDraft() {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();


        JSONA5ModelClass jsonA5 = JSONUtilClass.getModelFromJSON(MainApp.fc.getsA5(), JSONA5ModelClass.class);


        jsonA5.setnh801(bi.nh801a.isChecked() ? "1" : bi.nh801b.isChecked() ? "2" : "0");
        jsonA5.setnh802(bi.nh802.getText().toString());

        if (bi.nh801a.isChecked()) {
            deceasedCounter = Integer.valueOf(bi.nh802.getText().toString());
        }
//        JsonObject json = new JsonObject(jsonA5);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        MainApp.fc.setsA5(String.valueOf(gson.toJson(jsonA5)));

        // Set summary fields
        MainApp.sumc = MainApp.AddSummary(MainApp.fc, 1);

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSA5();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void AutoPopulate() {
        FormsContract formContract = db.getsA5();
        if (!formContract.getsA5().equals("")) {

            JSONA5ModelClass jsonA5 = JSONUtilClass.getModelFromJSON(formContract.getsA5(), JSONA5ModelClass.class);

            if (!jsonA5.getnh801().equals("0")) {
                bi.nh801.check(
                        jsonA5.getnh801().equals("1") ? bi.nh801a.getId() :
                                bi.nh801b.getId()

                );
            }
            bi.nh802.setText(jsonA5.getnh802());

            if (jsonA5.getnh801().equals("2")) {
                bi.nh801a.setEnabled(false);
            }
            if (!jsonA5.getnh802().equals("")) {
                prevDeceasedCounter = Integer.valueOf(jsonA5.getnh802());
            }

        }
    }

    public void BtnContinue() {

//        Validation Boolean
        MainApp.validateFlag = true;

        //Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                if (bi.nh801a.isChecked()) {
                    startActivity(new Intent(SectionH8infoActivity.this, SectionH8Activity.class));
                } else {
                    if (SectionA1Activity.editFormFlag) {
                        startActivity(new Intent(this, ViewMemberActivity.class)
                                .putExtra("flagEdit", false)
                                .putExtra("comingBack", true)
                                .putExtra("cluster", MainApp.fc.getClusterNo())
                                .putExtra("hhno", MainApp.fc.getHhNo())
                        );

                    } else {

                        if (!MainApp.UpdateSummary(this, db, 1)) {
                            Toast.makeText(this, "Summary Table not update!!", Toast.LENGTH_SHORT).show();
                        }

                        startActivity(new Intent(this, ViewMemberActivity.class).putExtra("activity", 3));
                    }
                }
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }

    public void BtnEnd() {
        if (SectionA1Activity.editFormFlag) {
            startActivity(new Intent(this, ViewMemberActivity.class)
                    .putExtra("flagEdit", false)
                    .putExtra("comingBack", true)
                    .putExtra("cluster", MainApp.fc.getClusterNo())
                    .putExtra("hhno", MainApp.fc.getHhNo())
            );
        } else {
            MainApp.endActivity(this, this);
        }

    }
}
