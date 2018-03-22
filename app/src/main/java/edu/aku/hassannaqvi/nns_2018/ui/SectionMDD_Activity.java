package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionMddBinding;

public class SectionMDD_Activity extends AppCompatActivity {
    ActivitySectionMddBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_mdd_);

        setUpView();

    }

    private void setUpView() {


    }


    public void BtnEnd() {


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

                startActivity(new Intent(this, SectionB6Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

        //startActivity(new Intent(this, SectionB6Activity.class));
    }

    private boolean UpdateDB() {
        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);


        //sanober check this update method
        int updcount = db.updateSB5();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

        //return true;
    }

    private void SaveDraft() throws JSONException {
       /* JSONObject sB2 = new JSONObject();
        sB2.put("nw301", bi.nw301a.isChecked() ? "1"
                : bi.nw301b.isChecked() ? "2"
                : "0");

//       nw302
        sB2.put("nw302a", bi.nw302a.isChecked() ? "1" : "0");
        sB2.put("nw302b", bi.nw302b.isChecked() ? "2" : "0");
        sB2.put("nw302c", bi.nw302c.isChecked() ? "3" : "0");
        sB2.put("nw302d", bi.nw302d.isChecked() ? "4" : "0");
        sB2.put("nw302e", bi.nw302e.isChecked() ? "5" : "0");
        sB2.put("nw302f", bi.nw302f.isChecked() ? "6" : "0");
        sB2.put("nw302g", bi.nw302g.isChecked() ? "7" : "0");
        sB2.put("nw302h", bi.nw302h.isChecked() ? "8" : "0");
        sB2.put("nw30296", bi.nw30296.isChecked() ? "96" : "0");

        sB2.put("nw30296x", bi.nw30296x.getText().toString());

//      nw303
        sB2.put("nw303", bi.nw303a.isChecked() ? "1"
                : bi.nw303b.isChecked() ? "2"
                : bi.nw303c.isChecked() ? "3"
                : bi.nw303d.isChecked() ? "4"
                : bi.nw303e.isChecked() ? "5"
                : bi.nw303f.isChecked() ? "6"
                : bi.nw303g.isChecked() ? "7"
                : bi.nw303h.isChecked() ? "8"
                : bi.nw303i.isChecked() ? "9"
                : bi.nw303j.isChecked() ? "10"
                : bi.nw30396.isChecked() ? "96"
                : "0");*/
    }

    private boolean ValidateForm() {

      /*  if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnw306check, bi.nw30696, bi.nw30696x, getString(R.string.nw306) + " - " + getString(R.string.other))) {
            return false;
        }*/

        return false;
    }
}
