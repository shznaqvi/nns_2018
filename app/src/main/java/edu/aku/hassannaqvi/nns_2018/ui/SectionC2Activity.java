package edu.aku.hassannaqvi.nns_2018.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;

import java.util.List;
import java.util.Timer;

import butterknife.BindViews;
import butterknife.ButterKnife;
import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.Child;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionC2Binding;
import edu.aku.hassannaqvi.nns_2018.validation.clearClass;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionC2Activity extends Activity implements RadioGroup.OnCheckedChangeListener {

    private final long DELAY = 1000;
    ActivitySectionC2Binding bi;
    FamilyMembersContract selectedChild;
    @BindViews({R.id.nc215a, R.id.nc215b, R.id.nc215c, R.id.nc215d, R.id.nc215e, R.id.nc215f,
            R.id.nc215g, R.id.nc215h, R.id.nc215i, R.id.nc217a, R.id.nc217b, R.id.nc217c,
            R.id.nc217d, R.id.nc217e, R.id.nc217f, R.id.nc217g, R.id.nc217h, R.id.nc217i,
            R.id.nc217j, R.id.nc217k, R.id.nc217l, R.id.nc217m, R.id.nc217n, R.id.nc217o,
            R.id.nc217p, R.id.nc217q})
    List<RadioGroup> grpnc215;
    @BindViews({R.id.nc215aa, R.id.nc215ba, R.id.nc215ca, R.id.nc215da, R.id.nc215ea, R.id.nc215fa,
            R.id.nc215ga, R.id.nc215ha, R.id.nc215ia, R.id.nc217aa, R.id.nc217ba, R.id.nc217ca,
            R.id.nc217da, R.id.nc217ea, R.id.nc217fa, R.id.nc217ga, R.id.nc217ha, R.id.nc217ia,
            R.id.nc217ja, R.id.nc217ka, R.id.nc217la, R.id.nc217ma, R.id.nc217na, R.id.nc217oa,
            R.id.nc217pa, R.id.nc217qa})
    List<RadioButton> nc215yes;
    @BindViews({R.id.nc215ab, R.id.nc215bb, R.id.nc215cb, R.id.nc215db, R.id.nc215eb, R.id.nc215fb,
            R.id.nc215gb, R.id.nc215hb, R.id.nc215ib, R.id.nc217ab, R.id.nc217bb, R.id.nc217cb,
            R.id.nc217db, R.id.nc217eb, R.id.nc217fb, R.id.nc217gb, R.id.nc217hb, R.id.nc217ib,
            R.id.nc217jb, R.id.nc217kb, R.id.nc217lb, R.id.nc217mb, R.id.nc217nb, R.id.nc217ob,
            R.id.nc217pb, R.id.nc217qb})
    List<RadioButton> nc215no;
    @BindViews({R.id.nc215a98, R.id.nc215b98, R.id.nc215c98, R.id.nc215d98, R.id.nc215e98, R.id.nc215f98,
            R.id.nc215g98, R.id.nc215h98, R.id.nc215i98, R.id.nc217a98, R.id.nc217b98, R.id.nc217c98,
            R.id.nc217d98, R.id.nc217e98, R.id.nc217f98, R.id.nc217g98, R.id.nc217h98, R.id.nc217i98,
            R.id.nc217j98, R.id.nc217k98, R.id.nc217l98, R.id.nc217m98, R.id.nc217n98, R.id.nc217o98,
            R.id.nc217p98, R.id.nc217q98})
    List<RadioButton> nc215dkn;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_c2);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c2);
        ButterKnife.bind(this);
        bi.setCallback(this);

        setupViews();
    }

    public void setupViews() {
        //Get Intent
        selectedChild = (FamilyMembersContract) getIntent().getSerializableExtra("selectedChild");

        /*bi.nc205.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc205a.isChecked()) {
                    //bi.fldGrpnc206.setVisibility(View.VISIBLE);
                    clearClass.ClearAllFields(bi.fldGrpnc206, true);

                } else {
                    clearClass.ClearAllFields(bi.fldGrpnc206, false);

                }
            }
        });*/

        bi.nc206.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc206a.isChecked()) {
                    //bi.fldGrpnc207.setVisibility(View.VISIBLE);
                    clearClass.ClearAllFields(bi.fldGrpnc207, true);

                } else {
                    clearClass.ClearAllFields(bi.fldGrpnc207, false);
                    /*bi.fldGrpnc207.setVisibility(View.GONE);
                    bi.nc207.clearCheck();
                    bi.nc207d.setText(null);
                    bi.nc207h.setText(null);
                    bi.nc208.clearCheck();
                    bi.nc209.clearCheck();
                    bi.nc20996x.setText(null);
                    bi.nc210.clearCheck();
                    bi.nc211.clearCheck();
                    bi.nc21196x.setText(null);
                    bi.nc212.clearCheck();
*/
                }
            }
        });

        bi.nc208.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc208b.isChecked()) {
                    //bi.fldGrpnc209.setVisibility(View.VISIBLE);
                    clearClass.ClearAllFields(bi.fldGrpnc209, true);
                } else {
                    clearClass.ClearAllFields(bi.fldGrpnc209, false);
                    /*bi.fldGrpnc209.setVisibility(View.GONE);
                    bi.nc209.clearCheck();
                    bi.nc20996x.setText(null);*/
                }
            }
        });

        bi.nc210.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc210a.isChecked()) {
                    //bi.fldGrpnc211.setVisibility(View.VISIBLE);
                    clearClass.ClearAllFields(bi.fldGrpnc211, true);
                } else {
                    clearClass.ClearAllFields(bi.fldGrpnc211, false);
                    /*bi.fldGrpnc211.setVisibility(View.GONE);
                    bi.nc211.clearCheck();
                    bi.nc21196x.setText(null);*/
                }
            }
        });

        bi.nc212.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc212a.isChecked()) {
                    //bi.fldGrpnc212a.setVisibility(View.GONE);
                    clearClass.ClearAllFields(bi.fldGrpnc212a, false);
                    //bi.nc21201.clearCheck();
                } else {
                    //bi.fldGrpnc212a.setVisibility(View.VISIBLE);
                    clearClass.ClearAllFields(bi.fldGrpnc212a, true);
                }
            }
        });
        /*bi.nc20198.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    clearClass.ClearAllFields(bi.fldGrpyear, false);
                    clearClass.ClearAllFields(bi.fldGrpmonths, false);
                    clearClass.ClearAllFields(bi.fldGrpdays, false);
                } else {
                    clearClass.ClearAllFields(bi.fldGrpyear, true);
                    clearClass.ClearAllFields(bi.fldGrpmonths, true);
                    clearClass.ClearAllFields(bi.fldGrpdays, true);
                }
            }
        });*/



        /*bi.nc218.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(bi.nc218a.isChecked())
                {
                    bi.fldGrpnc219.setVisibility(View.VISIBLE);
                }else{
                    bi.fldGrpnc219.setVisibility(View.GONE);
                    bi.nc219.clearCheck();
                    bi.nc219x.setText(null);
                }
            }
        });*/

        for (RadioGroup rg : grpnc215) {
            rg.setOnCheckedChangeListener(this);
        }


    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
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

                startActivity(new Intent(this, SectionC3Activity.class)
                        .putExtra("selectedChild", selectedChild));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {

        MainApp.endChildActivity(this, this, false);

    }

    private boolean ValidateForm() {

        //Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        //if (!bi.nc20198.isChecked()) {


        //if (bi.nc205a.isChecked()) {
        if (!validatorClass.EmptyRadioButton(this, bi.nc206, bi.nc206a, getString(R.string.nc206))) {
            return false;
        }

        if (bi.nc206a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.nc207, bi.nc207a, getString(R.string.nc207))) {
                return false;
            }

            if (bi.nc207b.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nc207h, getString(R.string.nc207b))) {
                    return false;
                }

            }

            if (bi.nc207c.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nc207d, getString(R.string.nc207c))) {
                    return false;
                }

            }

            if (!validatorClass.EmptyRadioButton(this, bi.nc208, bi.nc208a, getString(R.string.nc208))) {
                return false;
            }

            if (bi.nc208b.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.nc209, bi.nc20996, bi.nc20996x, getString(R.string.nc209))) {
                    return false;
                }
            }

            if (!validatorClass.EmptyRadioButton(this, bi.nc210, bi.nc210a, getString(R.string.nc210))) {
                return false;
            }

            if (bi.nc210a.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.nc211, bi.nc21196, bi.nc21196x, getString(R.string.nc211))) {
                    return false;
                }
            }


            if (!validatorClass.EmptyRadioButton(this, bi.nc212, bi.nc212a, getString(R.string.nc212))) {
                return false;
            }
        }

        if (!bi.nc212a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.nc21201, bi.nc21201a, getString(R.string.nc212a))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.nc213, bi.nc213a, getString(R.string.nc213))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc214, bi.nc214a, getString(R.string.nc214))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215a, bi.nc215aa, getString(R.string.nc215a))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215b, bi.nc215ba, getString(R.string.nc215b))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215c, bi.nc215ca, getString(R.string.nc215c))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215d, bi.nc215da, getString(R.string.nc215d))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215e, bi.nc215ea, getString(R.string.nc215e))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215f, bi.nc215fa, getString(R.string.nc215f))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215g, bi.nc215ga, getString(R.string.nc215g))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215h, bi.nc215ha, getString(R.string.nc215h))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215i, bi.nc215ia, getString(R.string.nc215i))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc217a, bi.nc217aa, getString(R.string.nc217a))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc217b, bi.nc217ba, getString(R.string.nc217b))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc217c, bi.nc217ca, getString(R.string.nc217c))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc217d, bi.nc217da, getString(R.string.nc217d))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc217e, bi.nc217ea, getString(R.string.nc217e))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc217f, bi.nc217fa, getString(R.string.nc217f))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc217g, bi.nc217ga, getString(R.string.nc217g))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc217h, bi.nc217ha, getString(R.string.nc217h))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc217i, bi.nc217ia, getString(R.string.nc217i))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc217j, bi.nc217ja, getString(R.string.nc217j))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc217k, bi.nc217ka, getString(R.string.nc217k))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc217l, bi.nc217la, getString(R.string.nc217l))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc217m, bi.nc217ma, getString(R.string.nc217m))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc217n, bi.nc217na, getString(R.string.nc217n))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc217o, bi.nc217oa, getString(R.string.nc217o))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc217p, bi.nc217pa, getString(R.string.nc217p))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc217q, bi.nc217qa, getString(R.string.nc217q))) {
            return false;
        }

        if (isAllNo() || isAlldkn() || (!isoneYes())) {
            if (!validatorClass.EmptyRadioButton(this, bi.nc218, bi.nc218a, getString(R.string.nc218))) {
                return false;
            }
        }

        if ((isAllNo() || isAlldkn()) && bi.nc218a.isChecked()) {
            Toast.makeText(this, "ERROR: " + getString(R.string.nc218) + "Atleast one should be Yes", Toast.LENGTH_SHORT).show();
            bi.nc218a.setError(getString(R.string.nc218));
            Log.i(SectionC2Activity.class.getSimpleName(), "nc218: This data is Required!");
            return false;
        } else {
            bi.nc218a.setError(null);
        }

            /*if (isAlldkn() && bi.nc218a.isChecked()) {
                Toast.makeText(this, "ERROR: " + getString(R.string.nc218) + "Atleast one should be Yes", Toast.LENGTH_SHORT).show();
                bi.nc218a.setError(getString(R.string.nc218));
                Log.i(SectionC2Activity.class.getSimpleName(), "nc218: This data is Required!");
                return false;
            } else {
                bi.nc218a.setError(null);
            }
*/
        if (isoneYes()) {
            if (!validatorClass.EmptyRadioButton(this, bi.nc219, bi.nc219a, bi.nc219x, getString(R.string.nc219))) {
                return false;
            }
        }

        if (bi.nc219a.isChecked()) {
            if (!validatorClass.RangeTextBox(this, bi.nc219x, 1, 10, getString(R.string.nc219), " times")) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc220, bi.nc220a, getString(R.string.nc220))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc221, bi.nc22196, bi.nc22196x, getString(R.string.nc221))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc222, bi.nc22296, bi.nc22296x, getString(R.string.nc222))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc223, bi.nc223a, getString(R.string.nc223))) {
            return false;
        }
        //}

        return true;
    }


    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        //JSONObject sC2 = new JSONObject();

        MainApp.cc1 = new Child();


        MainApp.cc1.setNc2_child_name(selectedChild.getName());

        MainApp.cc1.setNc2_line_noSerial(selectedChild.getSerialNo());


        MainApp.cc1.setNc206(bi.nc206a.isChecked() ? "1"
                : bi.nc206b.isChecked() ? "2"
                : bi.nc20698.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc207(bi.nc207a.isChecked() ? "1"
                : bi.nc207b.isChecked() ? "2"
                : bi.nc207c.isChecked() ? "3"
                : "0");

        MainApp.cc1.setNc207h(bi.nc207h.getText().toString());
        MainApp.cc1.setNc207d(bi.nc207d.getText().toString());

        MainApp.cc1.setNc208(bi.nc208a.isChecked() ? "1"
                : bi.nc208b.isChecked() ? "2"
                : bi.nc20898.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc209(bi.nc209a.isChecked() ? "1"
                : bi.nc209b.isChecked() ? "2"
                : bi.nc209c.isChecked() ? "3"
                : bi.nc20996.isChecked() ? "96"
                : "0");

        MainApp.cc1.setNc20996x(bi.nc20996x.getText().toString());

        MainApp.cc1.setNc210(bi.nc210a.isChecked() ? "1"
                : bi.nc210b.isChecked() ? "2"
                : "0");

        MainApp.cc1.setNc211(bi.nc211a.isChecked() ? "1"
                : bi.nc211b.isChecked() ? "2"
                : bi.nc211c.isChecked() ? "3"
                : bi.nc211d.isChecked() ? "4"
                : bi.nc211e.isChecked() ? "5"
                : bi.nc211f.isChecked() ? "6"
                : bi.nc211g.isChecked() ? "7"
                : bi.nc211h.isChecked() ? "8"
                : bi.nc211i.isChecked() ? "9"
                : bi.nc211j.isChecked() ? "10"
                : bi.nc21199.isChecked() ? "99"
                : bi.nc21196.isChecked() ? "96"
                : "0");

        MainApp.cc1.setNc21196x(bi.nc21196x.getText().toString());

        MainApp.cc1.setNc212(bi.nc212a.isChecked() ? "1"
                : bi.nc212b.isChecked() ? "2"
                : bi.nc21298.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc212a(bi.nc21201a.isChecked() ? "1"
                : bi.nc21201b.isChecked() ? "2"
                : bi.nc2120198.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc213(bi.nc213a.isChecked() ? "1"
                : bi.nc213b.isChecked() ? "2"
                : bi.nc21398.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc214(bi.nc214a.isChecked() ? "1"
                : bi.nc214b.isChecked() ? "2"
                : bi.nc21498.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc215a(bi.nc215aa.isChecked() ? "1"
                : bi.nc215ab.isChecked() ? "2"
                : bi.nc215a98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc215b(bi.nc215ba.isChecked() ? "1"
                : bi.nc215bb.isChecked() ? "2"
                : bi.nc215b98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc215bx(bi.nc215bx.getText().toString());

        MainApp.cc1.setNc215c(bi.nc215ca.isChecked() ? "1"
                : bi.nc215cb.isChecked() ? "2"
                : bi.nc215c98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc215cx(bi.nc215cx.getText().toString());

        MainApp.cc1.setNc215d(bi.nc215da.isChecked() ? "1"
                : bi.nc215db.isChecked() ? "2"
                : bi.nc215d98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc215e(bi.nc215ea.isChecked() ? "1"
                : bi.nc215eb.isChecked() ? "2"
                : bi.nc215e98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc215f(bi.nc215fa.isChecked() ? "1"
                : bi.nc215fb.isChecked() ? "2"
                : bi.nc215f98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc215h(bi.nc215ga.isChecked() ? "1"
                : bi.nc215gb.isChecked() ? "2"
                : bi.nc215g98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc215h(bi.nc215ha.isChecked() ? "1"
                : bi.nc215hb.isChecked() ? "2"
                : bi.nc215h98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc215i(bi.nc215ia.isChecked() ? "1"
                : bi.nc215ib.isChecked() ? "2"
                : bi.nc215i98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc217a(bi.nc217aa.isChecked() ? "1"
                : bi.nc217ab.isChecked() ? "2"
                : bi.nc217a98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc217b(bi.nc217ba.isChecked() ? "1"
                : bi.nc217bb.isChecked() ? "2"
                : bi.nc217b98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc217c(bi.nc217ca.isChecked() ? "1"
                : bi.nc217cb.isChecked() ? "2"
                : bi.nc217c98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc217d(bi.nc217da.isChecked() ? "1"
                : bi.nc217db.isChecked() ? "2"
                : bi.nc217d98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc217e(bi.nc217ea.isChecked() ? "1"
                : bi.nc217eb.isChecked() ? "2"
                : bi.nc217e98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc217f(bi.nc217fa.isChecked() ? "1"
                : bi.nc217fb.isChecked() ? "2"
                : bi.nc217f98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc217g(bi.nc217ga.isChecked() ? "1"
                : bi.nc217gb.isChecked() ? "2"
                : bi.nc217g98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc217h(bi.nc217ha.isChecked() ? "1"
                : bi.nc217hb.isChecked() ? "2"
                : bi.nc217h98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc217i(bi.nc217ia.isChecked() ? "1"
                : bi.nc217ib.isChecked() ? "2"
                : bi.nc217i98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc217j(bi.nc217ja.isChecked() ? "1"
                : bi.nc217jb.isChecked() ? "2"
                : bi.nc217j98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc217k(bi.nc217ka.isChecked() ? "1"
                : bi.nc217kb.isChecked() ? "2"
                : bi.nc217k98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc217l(bi.nc217la.isChecked() ? "1"
                : bi.nc217lb.isChecked() ? "2"
                : bi.nc217l98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc217m(bi.nc217ma.isChecked() ? "1"
                : bi.nc217mb.isChecked() ? "2"
                : bi.nc217m98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc217n(bi.nc217na.isChecked() ? "1"
                : bi.nc217nb.isChecked() ? "2"
                : bi.nc217n98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc217o(bi.nc217oa.isChecked() ? "1"
                : bi.nc217ob.isChecked() ? "2"
                : bi.nc217o98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc217p(bi.nc217pa.isChecked() ? "1"
                : bi.nc217pb.isChecked() ? "2"
                : bi.nc217p98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc217q(bi.nc217qa.isChecked() ? "1"
                : bi.nc217qb.isChecked() ? "2"
                : bi.nc217q98.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc218(bi.nc218a.isChecked() ? "1"
                : bi.nc218b.isChecked() ? "2"
                : bi.nc21898.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc219(bi.nc21998.isChecked() ? "98" : bi.nc219x.getText().toString());

        MainApp.cc1.setNc220(bi.nc220a.isChecked() ? "1"
                : bi.nc220b.isChecked() ? "2"
                : bi.nc22098.isChecked() ? "98"
                : "0");

        MainApp.cc1.setNc221(bi.nc221a.isChecked() ? "1"
                : bi.nc221b.isChecked() ? "2"
                : bi.nc221c.isChecked() ? "3"
                : bi.nc22196.isChecked() ? "96"
                : "0");

        MainApp.cc1.setNc22196x(bi.nc22196x.getText().toString());

        MainApp.cc1.setNc222(bi.nc222a.isChecked() ? "1"
                : bi.nc222b.isChecked() ? "2"
                : bi.nc222c.isChecked() ? "3"
                : bi.nc22296.isChecked() ? "96"
                : "0");

        MainApp.cc1.setNc22296x(bi.nc22296x.getText().toString());

        MainApp.cc1.setNc223(bi.nc223a.isChecked() ? "1"
                : bi.nc223b.isChecked() ? "2"
                : bi.nc22398.isChecked() ? "98"
                : "0");

        //MainApp.cc.setsC2(String.valueOf(sC2));


        //Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {

        //Long rowId;
        /*DatabaseHelper_DBFlow db = new DatabaseHelper_DBFlow(this);

        int updcount = db.updateSC2();

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

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        if (isoneYes()) {
            //bi.fldGrpnc218.setVisibility(View.GONE);
            clearClass.ClearAllFields(bi.fldGrpnc218, false);
            clearClass.ClearAllFields(bi.fldGrpnc219, true);
            //bi.fldGrpnc219.setVisibility(View.VISIBLE);
            //bi.nc218.clearCheck();
        } else {
            clearClass.ClearAllFields(bi.fldGrpnc218, true);
            clearClass.ClearAllFields(bi.fldGrpnc219, true);
            //bi.fldGrpnc218.setVisibility(View.VISIBLE);
            //bi.fldGrpnc219.setVisibility(View.VISIBLE);
        }


        if (group == bi.nc215b) {
            if (bi.nc215ba.isChecked()) {
                //clearClass.ClearAllFields(bi.nc215bx, true);
                bi.nc215bx.setVisibility(View.VISIBLE);
                bi.nc215bx.setEnabled(true);
            } else {
                //bi.nc215bx.setVisibility(View.GONE);
                bi.nc215bx.setText(null);
                bi.nc215bx.setEnabled(false);

            }
        }

        if (group == bi.nc215c) {
            if (bi.nc215ca.isChecked()) {
                bi.nc215cx.setVisibility(View.VISIBLE);
                bi.nc215cx.setEnabled(true);
            } else {
                //bi.nc215cx.setVisibility(View.GONE);
                bi.nc215cx.setText(null);
                bi.nc215cx.setEnabled(false);
            }
        }

        if (group == bi.nc215f) {
            if (bi.nc215fa.isChecked()) {
                bi.nc215fx.setVisibility(View.VISIBLE);
                bi.nc215fx.setEnabled(true);
            } else {
                //bi.nc215fx.setVisibility(View.GONE);
                bi.nc215fx.setEnabled(false);
                bi.nc215fx.setText(null);
            }
        }

    }

    public boolean isoneYes() {

        int i = 0;
        for (RadioButton rg : nc215yes) {
            if (rg.isChecked())
                return true;
        }

        // Show answer here
        // return i == rg;
        return false;
    }

    public boolean isAlldkn() {

        int i = 0;
        for (RadioButton rg : nc215dkn) {
            if (rg.isChecked())
                i++;
        }

        // Show answer here
        return i == nc215dkn.size();
    }

    public boolean isAllNo() {

        int i = 0;
        for (RadioButton rg : nc215no) {
            if (rg.isChecked())
                i++;
        }

        // Show answer here
        return i == nc215no.size();
    }


}
