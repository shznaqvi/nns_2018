package edu.aku.hassannaqvi.nns_2018.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;

import java.util.Timer;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.Child;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper_DBFlow;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionC4Binding;
import edu.aku.hassannaqvi.nns_2018.validation.clearClass;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionC4Activity extends Activity {

    private final long DELAY = 1000;
    ActivitySectionC4Binding binding;
    DatabaseHelper_DBFlow db;
    FamilyMembersContract selectedChild;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_c4);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_c4);
        db = new DatabaseHelper_DBFlow(this);

        //        Assigning data to UI binding
        binding.setCallback(this);

        setupViews();
    }

    private void setupViews() {
        binding.nc401.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc401a.isChecked()) {
                    //binding.fldGrnc402.setVisibility(View.VISIBLE);
                    clearClass.ClearAllFields(binding.fldGrnc402, true);
                } else {
                    clearClass.ClearAllFields(binding.fldGrnc402, false);
                    /*binding.fldGrnc402.setVisibility(View.GONE);
                    binding.nc402.clearCheck();
                    binding.nc403.clearCheck();

                    binding.nc404a.setChecked(false);
                    binding.nc404b.setChecked(false);
                    binding.nc404c.setChecked(false);
                    binding.nc404d.setChecked(false);
                    binding.nc404e.setChecked(false);
                    binding.nc404f.setChecked(false);
                    binding.nc404g.setChecked(false);
                    binding.nc404h.setChecked(false);
                    binding.nc404i.setChecked(false);
                    binding.nc404j.setChecked(false);
                    binding.nc40496x.setText(null);

                    binding.nc4039601x.setText(null);
                    binding.nc4039602x.setText(null);
                    binding.nc4039603x.setText(null);*/
                }
            }
        });
        binding.nc402.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc402a.isChecked()) {
                    //binding.fldGrnc403.setVisibility(View.VISIBLE);
                    clearClass.ClearAllFields(binding.fldGrnc403, true);
                } else {

                    clearClass.ClearAllFields(binding.fldGrnc403, false);
                    /*binding.fldGrnc403.setVisibility(View.GONE);
                    binding.nc403.clearCheck();

                    binding.nc4039601x.setText(null);
                    binding.nc4039602x.setText(null);
                    binding.nc4039603x.setText(null);

                    binding.nc404a.setChecked(false);
                    binding.nc404b.setChecked(false);
                    binding.nc404c.setChecked(false);
                    binding.nc404d.setChecked(false);
                    binding.nc404e.setChecked(false);
                    binding.nc404f.setChecked(false);
                    binding.nc404g.setChecked(false);
                    binding.nc404h.setChecked(false);
                    binding.nc404i.setChecked(false);
                    binding.nc404j.setChecked(false);
                    binding.nc40496.setChecked(false);

                    binding.nc40496x.setText(null);*/
                }
            }
        });

        binding.nc405.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc405a.isChecked()) {
                    //binding.fldGrnc406.setVisibility(View.VISIBLE);
                    clearClass.ClearAllFields(binding.fldGrnc406, true);
                } else {
                    clearClass.ClearAllFields(binding.fldGrnc406, false);
                    /*binding.fldGrnc406.setVisibility(View.GONE);
                    binding.nc406.clearCheck();
                    binding.nc407.clearCheck();

                    binding.nc4079601x.setText(null);
                    binding.nc4079602x.setText(null);
                    binding.nc4079603x.setText(null);

                    binding.nc408a.setChecked(false);
                    binding.nc408b.setChecked(false);
                    binding.nc408c.setChecked(false);
                    binding.nc408d.setChecked(false);
                    binding.nc408e.setChecked(false);
                    binding.nc408f.setChecked(false);
                    binding.nc408g.setChecked(false);
                    binding.nc408h.setChecked(false);
                    binding.nc408i.setChecked(false);
                    binding.nc4089601x.setText(null);*/
                }
            }
        });
        binding.nc406.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc406a.isChecked()) {
                    //binding.fldGrnc407.setVisibility(View.VISIBLE);
                    clearClass.ClearAllFields(binding.fldGrnc407, true);
                } else {
                    clearClass.ClearAllFields(binding.fldGrnc407, false);
                    /*binding.fldGrnc407.setVisibility(View.GONE);
                    binding.nc407.clearCheck();

                    binding.nc4079601x.setText(null);
                    binding.nc4079602x.setText(null);
                    binding.nc4079603x.setText(null);

                    binding.nc408a.setChecked(false);
                    binding.nc408b.setChecked(false);
                    binding.nc408c.setChecked(false);
                    binding.nc408d.setChecked(false);
                    binding.nc408e.setChecked(false);
                    binding.nc408f.setChecked(false);
                    binding.nc408g.setChecked(false);
                    binding.nc408h.setChecked(false);
                    binding.nc408i.setChecked(false);
                    binding.nc4089601x.setText(null);*/
                }
            }
        });

        binding.nc409.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc409a.isChecked()) {
                    //binding.fldGrnc410.setVisibility(View.VISIBLE);
                    clearClass.ClearAllFields(binding.fldGrnc410, true);
                } else {
                    clearClass.ClearAllFields(binding.fldGrnc410, false);
                    /*binding.fldGrnc410.setVisibility(View.GONE);
                    binding.nc410.clearCheck();
                    binding.nc411.clearCheck();

                    binding.nc4119601x.setText(null);
                    binding.nc4119602x.setText(null);
                    binding.nc4119603x.setText(null);


                    binding.nc412b.setChecked(false);
                    binding.nc412c.setChecked(false);
//                    binding.nc412d.setChecked(false);
                    binding.nc412e.setChecked(false);
                    binding.nc412f.setChecked(false);
                    binding.nc412g.setChecked(false);
                    binding.nc412h.setChecked(false);
                    binding.nc412i.setChecked(false);
                    binding.nc4129601x.setText(null);

*/
                }
            }
        });
        binding.nc410.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc410a.isChecked()) {
                    //binding.fldGrnc411.setVisibility(View.VISIBLE);
                    clearClass.ClearAllFields(binding.fldGrnc411, true);
                } else {
                    clearClass.ClearAllFields(binding.fldGrnc411, false);
                    /*binding.fldGrnc411.setVisibility(View.GONE);
                    binding.nc411.clearCheck();

                    binding.nc4119601x.setText(null);
                    binding.nc4119602x.setText(null);
                    binding.nc4119603x.setText(null);

                    binding.nc412b.setChecked(false);
                    binding.nc412c.setChecked(false);
//                    binding.nc412d.setChecked(false);
                    binding.nc412e.setChecked(false);
                    binding.nc412f.setChecked(false);
                    binding.nc412g.setChecked(false);
                    binding.nc412h.setChecked(false);
                    binding.nc412i.setChecked(false);
                    binding.nc4129601x.setText(null);*/
                }
            }
        });
        binding.nc415.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.nc415a) {
                    clearClass.ClearAllFields(binding.fldGrpnc416, true);
                } else {
                    clearClass.ClearAllFields(binding.fldGrpnc416, false);
                }
            }
        });
        binding.nc418.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.nc418a) {
                    clearClass.ClearAllFields(binding.fldGrpnc419, true);
                } else {
                    clearClass.ClearAllFields(binding.fldGrpnc419, false);
                }
            }
        });


        //Get Intent
        selectedChild = (FamilyMembersContract) getIntent().getSerializableExtra("selectedChild");

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
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

                if (Integer.valueOf(selectedChild.getAgeInYear()) >= 2) {
                    startActivity(new Intent(this, SectionC5Activity.class)
                            .putExtra("selectedChild", selectedChild));
                } else {

                    /*MainApp.endActivityMotherChild(this, this, false, true);*/

                    startActivity(new Intent(this, ChildEndingActivity.class)
                            //.putExtra("checkingFlag", false)
                            .putExtra("complete", true));

                }

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {
        MainApp.endChildActivity(this, this, false);
    }

    private boolean formValidation() {
        //Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//       nc401
        if (!validatorClass.EmptyRadioButton(this, binding.nc401, binding.nc401b, getString(R.string.nc401))) {
            return false;
        }
        if (binding.nc401a.isChecked()) {

//        nc402
            if (!validatorClass.EmptyRadioButton(this, binding.nc402, binding.nc402b, getString(R.string.nc402))) {
                return false;
            }

            if (binding.nc402a.isChecked()) {
//        nc403
                if (!validatorClass.EmptyRadioButton(this, binding.nc403, binding.nc403a, getString(R.string.nc403))) {
                    return false;
                }
//        nc4039601
                if (!validatorClass.EmptyRadioButton(this, binding.nc403, binding.nc4039601, binding.nc4039601x, getString(R.string.nc403) + " - " + getString(R.string.otherpubm))) {
                    return false;
                }
//        nc4039602
                else if (!validatorClass.EmptyRadioButton(this, binding.nc403, binding.nc4039602, binding.nc4039602x, getString(R.string.nc403) + " - " + getString(R.string.otherprim))) {
                    return false;
                }
//        nc4039603
                else if (!validatorClass.EmptyRadioButton(this, binding.nc403, binding.nc4039603, binding.nc4039603x, getString(R.string.nc403) + " - " + getString(R.string.other))) {
                    return false;
                }

//        fldGrpnc404
                if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnc404, binding.nc40496, binding.nc40496x, getString(R.string.nc404))) {
                    return false;
                }
            }


        }

//       nc405
        if (!validatorClass.EmptyRadioButton(this, binding.nc405, binding.nc405b, getString(R.string.nc405))) {
            return false;
        }

        if (binding.nc405a.isChecked()) {

//        nc406
            if (!validatorClass.EmptyRadioButton(this, binding.nc406, binding.nc406b, getString(R.string.nc406))) {
                return false;
            }
            if (binding.nc406a.isChecked()) {

                // nc407
                if (!validatorClass.EmptyRadioButton(this, binding.nc407, binding.nc4079603, getString(R.string.nc407))) {
                    return false;
                }

//        nc4079601x
                if (!validatorClass.EmptyRadioButton(this, binding.nc407, binding.nc4079601, binding.nc4079601x, getString(R.string.nc407) + " - " + getString(R.string.otherpubm))) {
                    return false;
                }
//        nc4079602x
                else if (!validatorClass.EmptyRadioButton(this, binding.nc407, binding.nc4079602, binding.nc4079602x, getString(R.string.nc407) + " - " + getString(R.string.otherprim))) {
                    return false;
                }
//        nc4079603x
                else if (!validatorClass.EmptyRadioButton(this, binding.nc407, binding.nc4079603, binding.nc4079603x, getString(R.string.nc407) + " - " + getString(R.string.other))) {
                    return false;
                }

                //    fldGrnc408check
                if (!validatorClass.EmptyCheckBox(this, binding.fldGrnc408check, binding.nc4089601, binding.nc4089601x, getString(R.string.nc408))) {
                    return false;
                }
            }
        }

//       nc409
        if (!validatorClass.EmptyRadioButton(this, binding.nc409, binding.nc409b, getString(R.string.nc409))) {
            return false;
        }
        if (binding.nc409a.isChecked()) {
//        nc410
            if (!validatorClass.EmptyRadioButton(this, binding.nc410, binding.nc410b, getString(R.string.nc410))) {
                return false;
            }
            if (binding.nc410a.isChecked()) {
                // nc411
                if (!validatorClass.EmptyRadioButton(this, binding.nc411, binding.nc4119603, getString(R.string.nc411))) {
                    return false;
                }

//        nc4119601x
                if (!validatorClass.EmptyRadioButton(this, binding.nc411, binding.nc4119601, binding.nc4119601x, getString(R.string.nc411) + " - " + getString(R.string.otherpubm))) {
                    return false;
                }
//        nc4119602x
                if (!validatorClass.EmptyRadioButton(this, binding.nc411, binding.nc4119602, binding.nc4119602x, getString(R.string.nc411) + " - " + getString(R.string.otherprim))) {
                    return false;
                }
//        nc4119603x
                if (!validatorClass.EmptyRadioButton(this, binding.nc411, binding.nc4119603, binding.nc4119603x, getString(R.string.nc411) + " - " + getString(R.string.other))) {
                    return false;
                }
                // fldGrnc412check
                if (!validatorClass.EmptyCheckBox(this, binding.fldGrnc412check, binding.nc4129601, binding.nc4129601x, getString(R.string.nc412))) {
                    return false;
                }
            }
        }

//       nc413
        if (!validatorClass.EmptyRadioButton(this, binding.nc413, binding.nc41398, getString(R.string.nc413))) {
            return false;
        }

//        nc414
        if (!validatorClass.EmptyRadioButton(this, binding.nc414, binding.nc41498, getString(R.string.nc414))) {
            return false;
        }
//    nc415
        if (!validatorClass.EmptyRadioButton(this, binding.nc415, binding.nc41598, getString(R.string.nc415))) {
            return false;
        }

        if (binding.nc415a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, binding.nc416, getString(R.string.nc416))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, binding.nc417, binding.nc417a, getString(R.string.nc417))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, binding.nc418, binding.nc418a, getString(R.string.nc418))) {
            return false;
        }
        if (binding.nc418a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, binding.nc419, binding.nc419a, getString(R.string.nc419))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, binding.nc420m, getString(R.string.months))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, binding.nc420d, getString(R.string.day))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.nc420m, 0, 11, getString(R.string.nc420), " months")) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, binding.nc420d, 0, 29, getString(R.string.nc420), " days")) {
                return false;
            }

            if (binding.nc420m.getText().toString().equals("0") && binding.nc420d.getText().toString().equals("0")) {
                Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nc420), Toast.LENGTH_LONG).show();
                binding.nc420m.setError("All can not be zero");
                binding.nc420d.setError("All can not be zero");
                Log.i(SectionC4Activity.class.getSimpleName(), "nw420" + ": This data is Required!");
                return false;
            } else {
                binding.nc420m.setError(null);
                binding.nc420d.setError(null);
            }

        }
        return true;
    }


    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        //JSONObject sC4 = new JSONObject();

        MainApp.cc1 = new Child();

//        nc301
        MainApp.cc1.setNc4name(selectedChild.getName());
//        nc302
        MainApp.cc1.setNc402Serial(selectedChild.getSerialNo());

//        nc401
        MainApp.cc1.setNc401(binding.nc401a.isChecked() ? "1"
                : binding.nc401b.isChecked() ? "2"
                : "0");

//      nc402
        MainApp.cc1.setNc402(binding.nc402a.isChecked() ? "1"
                : binding.nc402b.isChecked() ? "2"
                : "0");


//        nc403
        MainApp.cc1.setNc403(binding.nc403a.isChecked() ? "1"
                : binding.nc403b.isChecked() ? "2"
                : binding.nc403c.isChecked() ? "3"
                : binding.nc403d.isChecked() ? "4"
                : binding.nc403e.isChecked() ? "5"
                : binding.nc4039601.isChecked() ? "961"
                : binding.nc403f.isChecked() ? "6"
                : binding.nc403g.isChecked() ? "7"
                : binding.nc403h.isChecked() ? "8"
                : binding.nc403i.isChecked() ? "9"
                : binding.nc403j.isChecked() ? "10"
                : binding.nc4039602.isChecked() ? "962"
                : binding.nc403k.isChecked() ? "11"
                : binding.nc403l.isChecked() ? "12"
                : binding.nc403m.isChecked() ? "13"
                : binding.nc4039603.isChecked() ? "963"
                : "0");


        MainApp.cc1.setNc4039601x(binding.nc4039601x.getText().toString());
        MainApp.cc1.setNc4039602x(binding.nc4039602x.getText().toString());
        MainApp.cc1.setNc4039603x(binding.nc4039603x.getText().toString());

//     nc404
        MainApp.cc1.setNc404a(binding.nc404a.isChecked() ? "1" : "0");
        MainApp.cc1.setNc404b(binding.nc404b.isChecked() ? "2" : "0");
        MainApp.cc1.setNc404c(binding.nc404c.isChecked() ? "3" : "0");
        MainApp.cc1.setNc404d(binding.nc404d.isChecked() ? "4" : "0");
        MainApp.cc1.setNc404e(binding.nc404e.isChecked() ? "5" : "0");
        MainApp.cc1.setNc404f(binding.nc404f.isChecked() ? "6" : "0");
        MainApp.cc1.setNc404g(binding.nc404g.isChecked() ? "7" : "0");
        MainApp.cc1.setNc404h(binding.nc404h.isChecked() ? "8" : "0");
        MainApp.cc1.setNc404i(binding.nc404i.isChecked() ? "9" : "0");
        MainApp.cc1.setNc404j(binding.nc404j.isChecked() ? "10" : "0");
        MainApp.cc1.setNc40496(binding.nc40496.isChecked() ? "96" : "0");

        MainApp.cc1.setNc40496x(binding.nc40496x.getText().toString());

//        nc405
        MainApp.cc1.setNc405(binding.nc405a.isChecked() ? "1"
                : binding.nc405b.isChecked() ? "2"
                : "0");

//      nc406
        MainApp.cc1.setNc406(binding.nc406a.isChecked() ? "1"
                : binding.nc406b.isChecked() ? "2"
                : "0");


//        nc407
        MainApp.cc1.setNc407(binding.nc407a.isChecked() ? "1"
                : binding.nc407b.isChecked() ? "2"
                : binding.nc407c.isChecked() ? "3"
                : binding.nc407d.isChecked() ? "4"
                : binding.nc407e.isChecked() ? "5"
                : binding.nc4079601.isChecked() ? "961"
                : binding.nc407f.isChecked() ? "6"
                : binding.nc407g.isChecked() ? "7"
                : binding.nc407h.isChecked() ? "8"
                : binding.nc407i.isChecked() ? "9"
                : binding.nc407j.isChecked() ? "10"
                : binding.nc4079602.isChecked() ? "962"
                : binding.nc407k.isChecked() ? "11"
                : binding.nc407l.isChecked() ? "12"
                : binding.nc407m.isChecked() ? "13"
                : binding.nc4079603.isChecked() ? "963"
                : "0");


        MainApp.cc1.setNc4079601x(binding.nc4079601x.getText().toString());
        MainApp.cc1.setNc4079602x(binding.nc4079602x.getText().toString());
        MainApp.cc1.setNc4079603x(binding.nc4079603x.getText().toString());

//     nc408
        MainApp.cc1.setNc408a(binding.nc408a.isChecked() ? "1" : "0");
        MainApp.cc1.setNc408b(binding.nc408b.isChecked() ? "2" : "0");
        MainApp.cc1.setNc408c(binding.nc408c.isChecked() ? "3" : "0");
        MainApp.cc1.setNc408d(binding.nc408d.isChecked() ? "4" : "0");
        MainApp.cc1.setNc408e(binding.nc408e.isChecked() ? "5" : "0");
        MainApp.cc1.setNc408f(binding.nc408f.isChecked() ? "6" : "0");
        MainApp.cc1.setNc408g(binding.nc408g.isChecked() ? "7" : "0");
        MainApp.cc1.setNc408h(binding.nc408h.isChecked() ? "8" : "0");
        MainApp.cc1.setNc408i(binding.nc408i.isChecked() ? "9" : "0");
        MainApp.cc1.setNc4089601(binding.nc4089601.isChecked() ? "96" : "0");

        MainApp.cc1.setNc4089601x(binding.nc4089601x.getText().toString());


//        nc409
        MainApp.cc1.setNc409(binding.nc409a.isChecked() ? "1"
                : binding.nc409b.isChecked() ? "2"
                : "0");

//      nc410
        MainApp.cc1.setNc410(binding.nc410a.isChecked() ? "1"
                : binding.nc410b.isChecked() ? "2"
                : "0");


//        nc411
        MainApp.cc1.setNc411(binding.nc411a.isChecked() ? "1"
                : binding.nc411b.isChecked() ? "2"
                : binding.nc411c.isChecked() ? "3"
                : binding.nc411d.isChecked() ? "4"
                : binding.nc411e.isChecked() ? "5"
                : binding.nc4119601.isChecked() ? "961"
                : binding.nc411f.isChecked() ? "6"
                : binding.nc411g.isChecked() ? "7"
                : binding.nc411h.isChecked() ? "8"
                : binding.nc411i.isChecked() ? "9"
                : binding.nc411j.isChecked() ? "10"
                : binding.nc4119602.isChecked() ? "962"
                : binding.nc411k.isChecked() ? "11"
                : binding.nc411l.isChecked() ? "12"
                : binding.nc411m.isChecked() ? "13"
                : binding.nc4119603.isChecked() ? "963"
                : "0");


        MainApp.cc1.setNc4119601x(binding.nc4119601x.getText().toString());
        MainApp.cc1.setNc4119602x(binding.nc4119602x.getText().toString());
        MainApp.cc1.setNc4119603x(binding.nc4119603x.getText().toString());

//     nc412
        MainApp.cc1.setNc412b(binding.nc412b.isChecked() ? "1" : "0");
        MainApp.cc1.setNc412c(binding.nc412c.isChecked() ? "2" : "0");
//        sC4.put("nc412d", binding.nc412d.isChecked() ? "3" : "0");
        MainApp.cc1.setNc412e(binding.nc412e.isChecked() ? "3" : "0");
        MainApp.cc1.setNc412f(binding.nc412f.isChecked() ? "4" : "0");
        MainApp.cc1.setNc412g(binding.nc412g.isChecked() ? "5" : "0");
        MainApp.cc1.setNc412h(binding.nc412h.isChecked() ? "6" : "0");
        MainApp.cc1.setNc412i(binding.nc412i.isChecked() ? "7" : "0");
        MainApp.cc1.setNc412j(binding.nc412j.isChecked() ? "8" : "0");
        MainApp.cc1.setNc4129601(binding.nc4129601.isChecked() ? "96" : "0");

        MainApp.cc1.setNc4129601x(binding.nc4129601x.getText().toString());


//        nc413
        MainApp.cc1.setNc413(binding.nc413a.isChecked() ? "1"
                : binding.nc413b.isChecked() ? "2"
                : binding.nc41498.isChecked() ? "98"
                : "0");

//      nc414
        MainApp.cc1.setNc414(binding.nc414a.isChecked() ? "1"
                : binding.nc414b.isChecked() ? "2"
                : binding.nc41498.isChecked() ? "98"
                : "0");
//        nc415
        MainApp.cc1.setNc415(binding.nc415a.isChecked() ? "1"
                : binding.nc415b.isChecked() ? "2"
                : "0");

//        nc416
        MainApp.cc1.setNc416(binding.nc416.getText().toString());

//        nc417
        MainApp.cc1.setNc417(binding.nc417a.isChecked() ? "1"
                : binding.nc417b.isChecked() ? "2"
                : binding.nc417c.isChecked() ? "3"
                : binding.nc417d.isChecked() ? "4"
                : binding.nc417e.isChecked() ? "5"
                : "0");
//        nc418
        MainApp.cc1.setNc418(binding.nc418a.isChecked() ? "1"
                : binding.nc418b.isChecked() ? "2"
                : "0");
//        nc419
        MainApp.cc1.setNc419(binding.nc419a.isChecked() ? "1"
                : binding.nc419b.isChecked() ? "2"
                : binding.nc419c.isChecked() ? "3"
                : binding.nc419d.isChecked() ? "4"
                : binding.nc419e.isChecked() ? "5"
                : "0");
//        nc420m
        MainApp.cc1.setNc420m(binding.nc420m.getText().toString());

//        nc420d

        MainApp.cc1.setNc420d(binding.nc420d.getText().toString());


        //MainApp.cc.setsC4(String.valueOf(sC4));


        //Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {

        //Long rowId;
        /*DatabaseHelper_DBFlow db = new DatabaseHelper_DBFlow(this);

        int updcount = db.updateSC4();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/

        MainApp.cc1.update();
        return true;
    }


}