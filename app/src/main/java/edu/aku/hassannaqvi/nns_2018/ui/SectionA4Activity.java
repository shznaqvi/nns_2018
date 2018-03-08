package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

//        nh303
        binding.nh303.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nh303b) {
                    binding.nh305.clearCheck();
//                    binding.nh30596x.setText(null);
                }
            }
        });

//        nh307
        binding.nh307.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nh307i) {
                    binding.nh308.clearCheck();
                    binding.nh309.setText(null);
                }
            }
        });

//        nh321
        binding.nh321.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nh321b) {
                    binding.nh322.clearCheck();
                }
            }
        });

        binding.nh315.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nh315a.isChecked()) {
                    binding.fldGrpnh316.setVisibility(View.VISIBLE);
                } else {
                    binding.fldGrpnh316.setVisibility(View.GONE);
                    binding.nh316.clearCheck();
                }
            }
        });


    }

    public void BtnContinue() {

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


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }


    private boolean formValidation() {
        //Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();
        if (!validatorClass.EmptyRadioButton(this, binding.nh301, binding.nh30196, binding.nh30196x, getString(R.string.nh301))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.nh302, binding.nh30296, binding.nh30296x, getString(R.string.nh302))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, binding.nh303, binding.nh30396, binding.nh30396x, getString(R.string.nh303))) {
            return false;
        }
        if (!binding.nh303b.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, binding.nh304, getString(R.string.nh304))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, binding.nh304, 1, 99, getString(R.string.nh304), "minutes")) {
                return false;
            }

        }
        if (!validatorClass.EmptyRadioButton(this, binding.nh305, binding.nh305b, getString(R.string.nh305))) {
            return false;
        }
        if (binding.nh305a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, binding.nh306, binding.nh30696, binding.nh30696x, getString(R.string.nh306))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, binding.nh307, binding.nh30796, binding.nh30796x, getString(R.string.nh307))) {
            return false;
        }

        if (!binding.nh307i.isChecked() || !binding.nh307h.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, binding.nh308, binding.nh308b, getString(R.string.nh308))) {
                return false;
            }

            if (binding.nh308a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, binding.nh309, getString(R.string.nh309))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, binding.nh309, 1, 99, getString(R.string.nh309), "Toilet")) {
                    return false;
                }
            }
        }

        if (!validatorClass.EmptyRadioButton(this, binding.nh310, binding.nh31096, binding.nh31096x, getString(R.string.nh310))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.nh31101, binding.nh31101b, getString(R.string.nh31101))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.nh31102, binding.nh31102b, getString(R.string.nh31102))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.nh31103, binding.nh31103b, getString(R.string.nh31103))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.nh31104, binding.nh31104b, getString(R.string.nh31104))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.nh31105, binding.nh31105b, getString(R.string.nh31105))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.nh31106, binding.nh31106b, getString(R.string.nh31106))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.nh31107, binding.nh31107b, getString(R.string.nh31107))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.nh31108, binding.nh31108b, getString(R.string.nh31108))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.nh31109, binding.nh31109b, getString(R.string.nh31109))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.nh31110, binding.nh31110b, getString(R.string.nh31110))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.nh31111, binding.nh31111b, getString(R.string.nh31111))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.nh31112, binding.nh31112b, getString(R.string.nh31112))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.nh31113, binding.nh31113b, getString(R.string.nh31113))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.nh31114, binding.nh31114b, getString(R.string.nh31114))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.nh31115, binding.nh31115b, getString(R.string.nh31115))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.nh31116, binding.nh31116b, getString(R.string.nh31116))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.nh31117, binding.nh31117b, getString(R.string.nh31117))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.nh31118, binding.nh31118b, getString(R.string.nh31118))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.nh31119, binding.nh31119b, getString(R.string.nh31119))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, binding.fldGrpna0411check, binding.nh312a, getString(R.string.nh312))) {
            return false;
        }
        if (!validatorClass.EmptyCheckBox(this, binding.fldGrpna0411check, binding.nh313a, binding.nh31396x, getString(R.string.nh313))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.nh314, binding.nh31496, binding.nh31496x, getString(R.string.nh314))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.nh315, binding.nh31596, binding.nh31596x, getString(R.string.nh315))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.nh316, binding.nh316a, getString(R.string.nh316))) {
            return false;
        }
        // 315
        if (binding.nh316a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, binding.nh317, binding.nh317b, getString(R.string.nh317))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, binding.nh317, binding.nh31796, binding.nh31796x, getString(R.string.nh317))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.nh318, binding.nh31896, binding.nh31896x, getString(R.string.nh318))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.nh319, binding.nh31996, binding.nh31996x, getString(R.string.nh319))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.nh320, getString(R.string.nh320))) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, binding.nh320, 1, 15, getString(R.string.nh320), "Room")) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.nh321, binding.nh321b, getString(R.string.nh321))) {
            return false;
        }

        if (binding.nh321a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, binding.nh322, binding.nh322a, getString(R.string.nh322))) {
                return false;
            }

            if (binding.nh322a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, binding.nh322acr, getString(R.string.nh322acr))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, binding.nh322acr, 1, 999, getString(R.string.nh322acr), "acre")) {
                    return false;
                }
            } else if (binding.nh322b.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, binding.nh322can, getString(R.string.nh322can))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, binding.nh322can, 1, 999, getString(R.string.nh322can), "kanal")) {
                    return false;
                }
            }
        }

        if (!validatorClass.EmptyRadioButton(this, binding.nh323, binding.nh323b, getString(R.string.nh323))) {
            return false;
        }


        if (binding.nh323a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, binding.nh324a, getString(R.string.nh324a))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, binding.nh324a, 0, 999, getString(R.string.nh324a), "Animal")) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, binding.nh324b, getString(R.string.nh324b))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.nh324b, 0, 999, getString(R.string.nh324b), "Animal")) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, binding.nh324c, getString(R.string.nh324c))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.nh324c, 0, 999, getString(R.string.nh324c), "Animal")) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, binding.nh324d, getString(R.string.nh324d))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.nh324d, 0, 999, getString(R.string.nh324d), "Animal")) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, binding.nh324e, getString(R.string.nh324e))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.nh324e, 0, 999, getString(R.string.nh324e), "Animal")) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, binding.nh324f, getString(R.string.nh324f))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.nh324f, 0, 999, getString(R.string.nh324f), "Animal")) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, binding.nh324g, getString(R.string.nh324g))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.nh324g, 0, 999, getString(R.string.nh324g), "Animal")) {
                return false;
            }
        }
        return true;

    }

    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();


        JSONObject sA4 = new JSONObject();
        sA4.put("nh301", binding.nh301a.isChecked() ? "1"
                : binding.nh301b.isChecked() ? "2"
                : binding.nh301c.isChecked() ? "3"
                : binding.nh301d.isChecked() ? "4"
                : binding.nh301e.isChecked() ? "5"
                : binding.nh301f.isChecked() ? "6"
                : binding.nh301g.isChecked() ? "7"
                : binding.nh30196.isChecked() ? "96"
                : "0");
        sA4.put("nh30196x", binding.nh30196x.getText().toString());

        sA4.put("nh302", binding.nh302a.isChecked() ? "1"
                : binding.nh302b.isChecked() ? "2"
                : binding.nh30296.isChecked() ? "96" : "0");
        sA4.put("nh30296x", binding.nh30296x.getText().toString());


        sA4.put("nh303", binding.nh303b.isChecked() ? "1"
                : binding.nh303c.isChecked() ? "2"
                : binding.nh303d.isChecked() ? "3"
                : binding.nh303e.isChecked() ? "4"
                : binding.nh303f.isChecked() ? "5"
                : binding.nh303g.isChecked() ? "6"
                : binding.nh303h.isChecked() ? "7"
                : binding.nh303i.isChecked() ? "8"
                : binding.nh303j.isChecked() ? "9"
                : binding.nh303k.isChecked() ? "10"
                : binding.nh303l.isChecked() ? "11"
                : binding.nh303m.isChecked() ? "12"
                : binding.nh303n.isChecked() ? "13"
                : binding.nh303o.isChecked() ? "14"
                : binding.nh303p.isChecked() ? "15"
                : binding.nh30396.isChecked() ? "96"
                : "0");
        sA4.put("nh30396x", binding.nh30396x.getText().toString());

        sA4.put("nh304", binding.nh304.getText().toString());

        sA4.put("nh305", binding.nh305a.isChecked() ? "1"
                : binding.nh305b.isChecked() ? "2"
                : "0");

        sA4.put("nh306", binding.nh306a.isChecked() ? "1"
                : binding.nh306b.isChecked() ? "2"
                : binding.nh306c.isChecked() ? "3"
                : binding.nh306d.isChecked() ? "4"
                : binding.nh306e.isChecked() ? "5"
                : binding.nh306f.isChecked() ? "6"
                : binding.nh30696.isChecked() ? "96"
                : "0");
        sA4.put("nh30696x", binding.nh30696x.getText().toString());


        sA4.put("nh307", binding.nh307a.isChecked() ? "1"
                : binding.nh307b.isChecked() ? "2"
                : binding.nh307c.isChecked() ? "3"
                : binding.nh307d.isChecked() ? "4"
                : binding.nh307e.isChecked() ? "5"
                : binding.nh307f.isChecked() ? "6"
                : binding.nh307g.isChecked() ? "7"
                : binding.nh307h.isChecked() ? "8"
                : binding.nh307i.isChecked() ? "9"
                : binding.nh30796.isChecked() ? "96"
                : "0");

        sA4.put("nh30796x", binding.nh30796x.getText().toString());

        sA4.put("nh308", binding.nh308a.isChecked() ? "1"
                : binding.nh308b.isChecked() ? "2"
                : "0");

        sA4.put("nh309", binding.nh309.getText().toString());
//        nh310
        sA4.put("nh310", binding.nh310a.isChecked() ? "1"
                : binding.nh310b.isChecked() ? "2"
                : binding.nh310c.isChecked() ? "3"
                : binding.nh310d.isChecked() ? "4"
                : binding.nh310e.isChecked() ? "5"
                : binding.nh310f.isChecked() ? "6"
                : binding.nh310g.isChecked() ? "7"
                : binding.nh31096.isChecked() ? "96"
                : "0");
        sA4.put("nh31096x", binding.nh31096x.getText().toString());
//        nh311
        sA4.put("nh31101", binding.nh31101a.isChecked() ? "1"
                : binding.nh31101b.isChecked() ? "2"
                : "0");

        sA4.put("nh31102", binding.nh31102a.isChecked() ? "1"
                : binding.nh31102b.isChecked() ? "2"
                : "0");

        sA4.put("nh31103", binding.nh31103a.isChecked() ? "1"
                : binding.nh31103b.isChecked() ? "2"
                : "0");

        sA4.put("nh31104", binding.nh31104a.isChecked() ? "1"
                : binding.nh31104b.isChecked() ? "2"
                : "0");

        sA4.put("nh31105", binding.nh31105a.isChecked() ? "1"
                : binding.nh31105b.isChecked() ? "2"
                : "0");
        sA4.put("nh31106", binding.nh31106a.isChecked() ? "1"
                : binding.nh31106b.isChecked() ? "2"
                : "0");
        sA4.put("nh31107", binding.nh31107a.isChecked() ? "1"
                : binding.nh31107b.isChecked() ? "2"
                : "0");
        sA4.put("nh31108", binding.nh31108a.isChecked() ? "1"
                : binding.nh31108b.isChecked() ? "2"
                : "0");
        sA4.put("nh31109", binding.nh31109a.isChecked() ? "1"
                : binding.nh31109b.isChecked() ? "2"
                : "0");
        sA4.put("nh31110", binding.nh31110a.isChecked() ? "1"
                : binding.nh31110b.isChecked() ? "2"
                : "0");
        sA4.put("nh31111", binding.nh31111a.isChecked() ? "1"
                : binding.nh31111b.isChecked() ? "2"
                : "0");
        sA4.put("nh31112", binding.nh31112a.isChecked() ? "1"
                : binding.nh31112b.isChecked() ? "2"
                : "0");
        sA4.put("nh31113", binding.nh31113a.isChecked() ? "1"
                : binding.nh31113b.isChecked() ? "2"
                : "0");
        sA4.put("nh31114", binding.nh31114a.isChecked() ? "1"
                : binding.nh31114b.isChecked() ? "2"
                : "0");
        sA4.put("nh31115", binding.nh31115a.isChecked() ? "1"
                : binding.nh31115b.isChecked() ? "2"
                : "0");
        sA4.put("nh31116", binding.nh31116a.isChecked() ? "1"
                : binding.nh31116b.isChecked() ? "2"
                : "0");
        sA4.put("nh31117", binding.nh31117a.isChecked() ? "1"
                : binding.nh31117b.isChecked() ? "2"
                : "0");
        sA4.put("nh31118", binding.nh31118a.isChecked() ? "1"
                : binding.nh31118b.isChecked() ? "2"
                : "0");
        sA4.put("nh31119", binding.nh31119a.isChecked() ? "1"
                : binding.nh31119b.isChecked() ? "2"
                : "0");

//        nh312
        sA4.put("nh312a", binding.nh312a.isChecked() ? "1" : "0");
        sA4.put("nh312b", binding.nh312b.isChecked() ? "2" : "0");
        sA4.put("nh312c", binding.nh312c.isChecked() ? "3" : "0");
        sA4.put("nh312d", binding.nh312d.isChecked() ? "4" : "0");
        sA4.put("nh312e", binding.nh312e.isChecked() ? "5" : "0");
        sA4.put("nh312f", binding.nh312f.isChecked() ? "6" : "0");
        sA4.put("nh312g", binding.nh312g.isChecked() ? "7" : "0");
        sA4.put("nh312h", binding.nh312h.isChecked() ? "8" : "0");
        sA4.put("nh312i", binding.nh312i.isChecked() ? "9" : "0");

//        nh313
        sA4.put("nh313a", binding.nh313a.isChecked() ? "1" : "0");
        sA4.put("nh313b", binding.nh313b.isChecked() ? "2" : "0");
        sA4.put("nh313c", binding.nh313c.isChecked() ? "3" : "0");
        sA4.put("nh313d", binding.nh313d.isChecked() ? "4" : "0");
        sA4.put("nh313e", binding.nh313e.isChecked() ? "5" : "0");
        sA4.put("nh313f", binding.nh313f.isChecked() ? "6" : "0");
        sA4.put("nh31396", binding.nh31396.isChecked() ? "96" : "0");
        sA4.put("nh31496x", binding.nh31496x.getText().toString());

//        nh314
        sA4.put("nh314", binding.nh314a.isChecked() ? "1"
                : binding.nh314b.isChecked() ? "2"
                : binding.nh314c.isChecked() ? "3"
                : binding.nh314d.isChecked() ? "4"
                : binding.nh314e.isChecked() ? "5"
                : binding.nh314f.isChecked() ? "6"
                : binding.nh314g.isChecked() ? "7"
                : binding.nh314h.isChecked() ? "8"
                : binding.nh314i.isChecked() ? "9"
                : binding.nh314j.isChecked() ? "10"
                : binding.nh314k.isChecked() ? "11"
                : binding.nh31496.isChecked() ? "96"
                : "0");
        sA4.put("nh31496x", binding.nh31496x.getText().toString());
//       nh315
        sA4.put("nh315", binding.nh315a.isChecked() ? "1"
                : binding.nh315b.isChecked() ? "2"
                : binding.nh315c.isChecked() ? "3"
                : binding.nh31596.isChecked() ? "96"
                : "0");
        sA4.put("nh31596x", binding.nh31596x.getText().toString());
//        nh316
        sA4.put("nh316", binding.nh316a.isChecked() ? "1"
                : binding.nh316b.isChecked() ? "2"
                : "0");

//        nh317
        sA4.put("nh317", binding.nh317a.isChecked() ? "1"
                : binding.nh317b.isChecked() ? "2"
                : binding.nh317c.isChecked() ? "3"
                : binding.nh317d.isChecked() ? "4"
                : binding.nh317e.isChecked() ? "5"
                : binding.nh317f.isChecked() ? "6"
                : binding.nh317g.isChecked() ? "7"
                : binding.nh317h.isChecked() ? "8"
                : binding.nh317i.isChecked() ? "9"
                : binding.nh317j.isChecked() ? "10"
                : binding.nh317k.isChecked() ? "11"
                : binding.nh31796.isChecked() ? "96"
                : "0");
        sA4.put("nh31796x", binding.nh31796x.getText().toString());

//        nh318

        sA4.put("nh318", binding.nh318a.isChecked() ? "1"
                : binding.nh318b.isChecked() ? "2"
                : binding.nh318c.isChecked() ? "3"
                : binding.nh318d.isChecked() ? "4"
                : binding.nh318e.isChecked() ? "5"
                : binding.nh318f.isChecked() ? "6"
                : binding.nh318g.isChecked() ? "7"
                : binding.nh318h.isChecked() ? "8"
                : binding.nh318i.isChecked() ? "9"
                : binding.nh318j.isChecked() ? "10"
                : binding.nh318k.isChecked() ? "11"
                : binding.nh318l.isChecked() ? "12"
                : binding.nh318m.isChecked() ? "13"
                : binding.nh318n.isChecked() ? "14"
                : binding.nh31896.isChecked() ? "96"
                : "0");
        sA4.put("nh31896x", binding.nh31896x.getText().toString());

//          nh319
        sA4.put("nh319", binding.nh319a.isChecked() ? "1"
                : binding.nh319b.isChecked() ? "2"
                : binding.nh319c.isChecked() ? "3"
                : binding.nh319d.isChecked() ? "4"
                : binding.nh319e.isChecked() ? "5"
                : binding.nh319f.isChecked() ? "6"
                : binding.nh319g.isChecked() ? "7"
                : binding.nh319h.isChecked() ? "8"
                : binding.nh319i.isChecked() ? "9"
                : binding.nh319j.isChecked() ? "10"
                : binding.nh319k.isChecked() ? "11"
                : binding.nh319l.isChecked() ? "12"
                : binding.nh319m.isChecked() ? "13"
                : binding.nh319n.isChecked() ? "14"
                : binding.nh319o.isChecked() ? "15"
                : binding.nh319p.isChecked() ? "16"
                : binding.nh31996.isChecked() ? "96"
                : "0");
        sA4.put("nh31996x", binding.nh31996x.getText().toString());

//        nh320
        sA4.put("nh320", binding.nh320.getText().toString());

//        nh321
        sA4.put("nh321", binding.nh321a.isChecked() ? "1"
                : binding.nh321b.isChecked() ? "2"
                : "0");

//        nh322
        sA4.put("nh322", binding.nh322a.isChecked() ? "1"
                : binding.nh322b.isChecked() ? "2"
                : binding.nh32298.isChecked() ? "3"
                : "0");
        sA4.put("nh322acr", binding.nh322acr.getText().toString());
        sA4.put("nh322can", binding.nh322can.getText().toString());

//        nh323
        sA4.put("nh323", binding.nh323a.isChecked() ? "1"
                : binding.nh323b.isChecked() ? "2"
                : "0");
//        nh324
        sA4.put("nh324a", binding.nh324a.getText().toString());
        sA4.put("nh324b", binding.nh324b.getText().toString());
        sA4.put("nh324c", binding.nh324c.getText().toString());
        sA4.put("nh324d", binding.nh324d.getText().toString());
        sA4.put("nh324e", binding.nh324e.getText().toString());
        sA4.put("nh324f", binding.nh324f.getText().toString());
        sA4.put("nh324g", binding.nh324g.getText().toString());


        MainApp.fc.setsA4(String.valueOf(sA4));


        //Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSA4();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


}
