package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionA4Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionA4Activity extends AppCompatActivity {

    ActivitySectionA4Binding binding;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_a4);
        db = new DatabaseHelper(this);

//        Assigning data to UI binding
        binding.setCallback(this);

//        Skip Pattern

//        na403
        binding.na403.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.na403b) {
                    binding.na404.clearCheck();
                    binding.na40496x.setText(null);
                }
            }
        });

//        na405
        binding.na405.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.na405i) {
                    binding.na406.clearCheck();
                    binding.na407.setText(null);
                }
            }
        });

//        na419
        binding.na419.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.na419b) {
                    binding.na420.clearCheck();
                }
            }
        });


    }

    public void BtnContinue() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, SectionA5Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

        //startActivity(new Intent(this, SectionA5Activity.class));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);

    }
    private boolean formValidation() {
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();
        if (!validatorClass.EmptyRadioButton(this, binding.na401, binding.na40196, binding.na40196x, getString(R.string.na401))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na402, binding.na40296, binding.na40296x, getString(R.string.na402))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na403, binding.na403b, getString(R.string.na403))) {
            return false;
        }
        if (binding.na403a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, binding.na404, binding.na40496, binding.na40496x, getString(R.string.na404))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na405, binding.na40596, binding.na40596x, getString(R.string.na405))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na406, binding.na406b, getString(R.string.na406))) {
            return false;
        }

        if (binding.na406a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, binding.na407, getString(R.string.na407))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na408, binding.na40896, binding.na40896x, getString(R.string.na408))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na40901, binding.na40901b, getString(R.string.na40901))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na40902, binding.na40902b, getString(R.string.na40902))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na40903, binding.na40903b, getString(R.string.na40903))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na40904, binding.na40904b, getString(R.string.na40904))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na40905, binding.na40905b, getString(R.string.na40905))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410a, getString(R.string.na410a))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410b, getString(R.string.na410b))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410c, getString(R.string.na410c))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410d, getString(R.string.na410d))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410e, getString(R.string.na410e))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410f, getString(R.string.na410f))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410g, getString(R.string.na410g))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410h, getString(R.string.na410h))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410i, getString(R.string.na410i))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410j, getString(R.string.na410j))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410k, getString(R.string.na410k))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410l, getString(R.string.na410l))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410m, getString(R.string.na410m))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410n, getString(R.string.na410n))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410o, getString(R.string.na410o))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na410p, getString(R.string.na410p))) {
            return false;
        }

        if (!validatorClass.EmptyCheckBox(this, binding.fldGrpna0411check, binding.na41196, binding.na41196x, getString(R.string.na411))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na412, binding.na41296, binding.na41296x, getString(R.string.na412))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na413, binding.na41396, binding.na41396x, getString(R.string.na413))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na414, binding.na41496, binding.na41496x, getString(R.string.na414))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na415, binding.na41596, binding.na41596x, getString(R.string.na415))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na416, binding.na41696, binding.na41696x, getString(R.string.na416))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, binding.na417, 1, 15, getString(R.string.na417), "Room")) {
            return false;
        }
        if (!validatorClass.EmptyCheckBox(this, binding.fldGrpna0418check, binding.na418i, getString(R.string.na418))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na419, binding.na419b, getString(R.string.na419))) {
            return false;
        }
        if (binding.na419a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, binding.na420acr, getString(R.string.na420acr))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, binding.na420can, getString(R.string.na420can))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, binding.na420, binding.na42098, getString(R.string.na420))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na421, binding.na421b, getString(R.string.na421))) {
            return false;
        }
        if (binding.na421a.isChecked()) {
            if (!validatorClass.RangeTextBox(this, binding.na422a, 0, 999, getString(R.string.na422a), "Animal")) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.na422b, 0, 999, getString(R.string.na422b), "Animal")) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.na422c, 0, 999, getString(R.string.na422c), "Animal")) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.na422d, 0, 999, getString(R.string.na422d), "Animal")) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.na422e, 0, 999, getString(R.string.na422e), "Animal")) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.na422f, 0, 999, getString(R.string.na422f), "Animal")) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.na422g, 0, 999, getString(R.string.na422g), "Animal")) {
                return false;
            }
        }
        return true;

    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sA4 = new JSONObject();
        sA4.put("na401", binding.na401a.isChecked() ? "1"
                : binding.na401b.isChecked() ? "2"
                : binding.na401c.isChecked() ? "3"
                : binding.na401d.isChecked() ? "4"
                : binding.na401e.isChecked() ? "5"
                : binding.na401f.isChecked() ? "6"
                : binding.na40196.isChecked() ? "96"
                : "0");
        sA4.put("na40196x", binding.na40196x.getText().toString());


        sA4.put("na402", binding.na402a.isChecked() ? "1"
                : binding.na402b.isChecked() ? "2"
                : binding.na402c.isChecked() ? "3"
                : binding.na402d.isChecked() ? "4"
                : binding.na402e.isChecked() ? "5"
                : binding.na402f.isChecked() ? "6"
                : binding.na402g.isChecked() ? "7"
                : binding.na402h.isChecked() ? "8"
                : binding.na402i.isChecked() ? "9"
                : binding.na402j.isChecked() ? "10"
                : binding.na402k.isChecked() ? "11"
                : binding.na402l.isChecked() ? "12"
                : binding.na402m.isChecked() ? "13"
                : binding.na402n.isChecked() ? "14"
                : binding.na402o.isChecked() ? "15"
                : binding.na40296.isChecked() ? "96"
                : "0");
        sA4.put("na40296x", binding.na40296x.getText().toString());

        sA4.put("na403", binding.na403a.isChecked() ? "1"
                : binding.na403b.isChecked() ? "2"
                : "0");

        sA4.put("na404", binding.na404a.isChecked() ? "1"
                : binding.na404b.isChecked() ? "2"
                : binding.na404c.isChecked() ? "3"
                : binding.na404d.isChecked() ? "4"
                : binding.na404e.isChecked() ? "5"
                : binding.na404f.isChecked() ? "6"
                : binding.na40496.isChecked() ? "96"
                : "0");
        sA4.put("na40496x", binding.na40496x.getText().toString());

        sA4.put("na405", binding.na405a.isChecked() ? "1"
                : binding.na405b.isChecked() ? "2"
                : binding.na405c.isChecked() ? "3"
                : binding.na405d.isChecked() ? "4"
                : binding.na405e.isChecked() ? "5"
                : binding.na405f.isChecked() ? "6"
                : binding.na405g.isChecked() ? "7"
                : binding.na405h.isChecked() ? "8"
                : binding.na405i.isChecked() ? "9"
                : binding.na40596.isChecked() ? "96"
                : "0");
        sA4.put("na40596x", binding.na40596x.getText().toString());

        sA4.put("na406", binding.na406a.isChecked() ? "1"
                : binding.na406b.isChecked() ? "2"
                : "0");

        sA4.put("na407", binding.na407.getText().toString());

        sA4.put("na408", binding.na408a.isChecked() ? "1"
                : binding.na408b.isChecked() ? "2"
                : binding.na408c.isChecked() ? "3"
                : binding.na408d.isChecked() ? "4"
                : binding.na408e.isChecked() ? "5"
                : binding.na408f.isChecked() ? "6"
                : binding.na40896.isChecked() ? "96"
                : "0");
        sA4.put("na40896x", binding.na40896x.getText().toString());

        sA4.put("na40901", binding.na40901a.isChecked() ? "1"
                : binding.na40901b.isChecked() ? "2"
                : "0");

        sA4.put("na40902", binding.na40902a.isChecked() ? "1"
                : binding.na40902b.isChecked() ? "2"
                : "0");

        sA4.put("na40903", binding.na40903a.isChecked() ? "1"
                : binding.na40903b.isChecked() ? "2"
                : "0");

        sA4.put("na40904", binding.na40904a.isChecked() ? "1"
                : binding.na40904b.isChecked() ? "2"
                : "0");

        sA4.put("na40905", binding.na40905a.isChecked() ? "1"
                : binding.na40905b.isChecked() ? "2"
                : "0");
//        410

        sA4.put("na410a", binding.na410a.getText().toString());
        sA4.put("na410b", binding.na410b.getText().toString());
        sA4.put("na410c", binding.na410c.getText().toString());
        sA4.put("na410d", binding.na410d.getText().toString());
        sA4.put("na410e", binding.na410e.getText().toString());
        sA4.put("na410f", binding.na410f.getText().toString());
        sA4.put("na410g", binding.na410g.getText().toString());
        sA4.put("na410h", binding.na410h.getText().toString());
        sA4.put("na410i", binding.na410i.getText().toString());
        sA4.put("na410j", binding.na410j.getText().toString());
        sA4.put("na410k", binding.na410k.getText().toString());
        sA4.put("na410l", binding.na410l.getText().toString());
        sA4.put("na410m", binding.na410m.getText().toString());
        sA4.put("na410n", binding.na410n.getText().toString());
        sA4.put("na410o", binding.na410o.getText().toString());
        sA4.put("na410p", binding.na410p.getText().toString());

//        411
        sA4.put("na411a", binding.na411a.isChecked() ? "1" : "0");
        sA4.put("na411b", binding.na411b.isChecked() ? "2" : "0");
        sA4.put("na411c", binding.na411c.isChecked() ? "3" : "0");
        sA4.put("na411d", binding.na411d.isChecked() ? "4" : "0");
        sA4.put("na411e", binding.na411e.isChecked() ? "5" : "0");
        sA4.put("na411f", binding.na411f.isChecked() ? "6" : "0");
        sA4.put("na41196", binding.na41196.isChecked() ? "96" : "0");

        sA4.put("na41196x", binding.na41196x.getText().toString());

//        412
        sA4.put("na412", binding.na412a.isChecked() ? "1"
                : binding.na412b.isChecked() ? "2"
                : binding.na412c.isChecked() ? "3"
                : binding.na412d.isChecked() ? "4"
                : binding.na412e.isChecked() ? "5"
                : binding.na412f.isChecked() ? "6"
                : binding.na412g.isChecked() ? "7"
                : binding.na412h.isChecked() ? "8"
                : binding.na412i.isChecked() ? "9"
                : binding.na412j.isChecked() ? "10"
                : binding.na41296.isChecked() ? "96"
                : "0");
        sA4.put("na41296x", binding.na41296x.getText().toString());
//       413
        sA4.put("na413", binding.na413a.isChecked() ? "1"
                : binding.na413b.isChecked() ? "2"
                : binding.na413c.isChecked() ? "3"
                : binding.na41296.isChecked() ? "96"
                : "0");
        sA4.put("na41396x", binding.na41396x.getText().toString());

//        414
        sA4.put("na414", binding.na414a.isChecked() ? "1"
                : binding.na414b.isChecked() ? "2"
                : binding.na414c.isChecked() ? "3"
                : binding.na414d.isChecked() ? "4"
                : binding.na414e.isChecked() ? "5"
                : binding.na414f.isChecked() ? "6"
                : binding.na414g.isChecked() ? "7"
                : binding.na414h.isChecked() ? "8"
                : binding.na414i.isChecked() ? "9"
                : binding.na414j.isChecked() ? "10"
                : binding.na414j.isChecked() ? "10"
                : binding.na41496.isChecked() ? "96"
                : "0");
        sA4.put("na41496x", binding.na41496x.getText().toString());

//        415

        sA4.put("na415", binding.na415a.isChecked() ? "1"
                : binding.na415b.isChecked() ? "2"
                : binding.na415c.isChecked() ? "3"
                : binding.na415d.isChecked() ? "4"
                : binding.na415e.isChecked() ? "5"
                : binding.na415f.isChecked() ? "6"
                : binding.na415g.isChecked() ? "7"
                : binding.na415h.isChecked() ? "8"
                : binding.na415i.isChecked() ? "9"
                : binding.na415j.isChecked() ? "10"
                : binding.na415k.isChecked() ? "11"
                : binding.na415l.isChecked() ? "12"
                : binding.na415m.isChecked() ? "13"
                : binding.na41596.isChecked() ? "96"
                : "0");
        sA4.put("na41596x", binding.na41596x.getText().toString());

//          416
        sA4.put("na416", binding.na416a.isChecked() ? "1"
                : binding.na416b.isChecked() ? "2"
                : binding.na416c.isChecked() ? "3"
                : binding.na416d.isChecked() ? "4"
                : binding.na416e.isChecked() ? "5"
                : binding.na416f.isChecked() ? "6"
                : binding.na416g.isChecked() ? "7"
                : binding.na416h.isChecked() ? "8"
                : binding.na416i.isChecked() ? "9"
                : binding.na416j.isChecked() ? "10"
                : binding.na416k.isChecked() ? "11"
                : binding.na41696.isChecked() ? "96"
                : "0");
        sA4.put("na41696x", binding.na41696x.getText().toString());

//        417
        sA4.put("na417", binding.na417.getText().toString());

//        418
        sA4.put("na418a", binding.na418a.isChecked() ? "1" : "0");
        sA4.put("na418b", binding.na418b.isChecked() ? "2" : "0");
        sA4.put("na418c", binding.na418c.isChecked() ? "3" : "0");
        sA4.put("na418d", binding.na418d.isChecked() ? "4" : "0");
        sA4.put("na418e", binding.na418e.isChecked() ? "5" : "0");
        sA4.put("na418f", binding.na418f.isChecked() ? "6" : "0");
        sA4.put("na418g", binding.na418g.isChecked() ? "7" : "0");
        sA4.put("na418h", binding.na418h.isChecked() ? "8" : "0");
        sA4.put("na418i", binding.na418i.isChecked() ? "9" : "0");

//        419
        sA4.put("na419", binding.na419a.isChecked() ? "1"
                : binding.na419b.isChecked() ? "2"
                : "0");

//        420
        sA4.put("na420", binding.na420a.isChecked() ? "1"
                : binding.na420b.isChecked() ? "2"
                : binding.na42098.isChecked() ? "3"
                : "0");
        sA4.put("na420acr", binding.na420acr.getText().toString());
        sA4.put("na420can", binding.na420can.getText().toString());

//        421
        sA4.put("na421", binding.na421a.isChecked() ? "1"
                : binding.na421b.isChecked() ? "2"
                : "0");
//        422
        sA4.put("na422a", binding.na422a.getText().toString());
        sA4.put("na422b", binding.na422b.getText().toString());
        sA4.put("na422c", binding.na422c.getText().toString());
        sA4.put("na422d", binding.na422d.getText().toString());
        sA4.put("na422e", binding.na422e.getText().toString());
        sA4.put("na422f", binding.na422f.getText().toString());
        sA4.put("na422g", binding.na422g.getText().toString());


        MainApp.fc.setsA4(String.valueOf(sA4));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSA4();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}
