package edu.aku.hassannaqvi.nns_2018.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.contracts.MWRAContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB1Binding;
import edu.aku.hassannaqvi.nns_2018.validation.clearClass;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionB1Activity extends Activity {

    public static String wraName = "";
    public static int WRAcounter = 1;
    public static int WRAsize = 0;
    static Map<String, FamilyMembersContract> wraMap;
    static ArrayList<String> lstMwra;
    private final long DELAY = 1000;
    ArrayList<String> respName;
    Map<String, String> respMap;
    ActivitySectionB1Binding bi;
    DatabaseHelper db;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_b1);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b1);
        db = new DatabaseHelper(this);

        //Assigning data to UI binding
        bi.setCallback(this);

        setupViews();
    }

    public void setupViews() {

        /*respName = new ArrayList<>();
        respName.add("....");
        respMap = new HashMap<>();*/

        MainApp.status = 0;


//      Get intent
        if (getIntent().getBooleanExtra("reBackComing", true)) {
            if (getIntent().getBooleanExtra("mwraFlag", false)) {
                lstMwra.remove(getIntent().getStringExtra("wraName"));
                //      Increment WRA COUNTER
                WRAcounter++;
            } else {
                wraMap = new HashMap<>();
                lstMwra = new ArrayList<>();

                lstMwra.add("....");

                for (FamilyMembersContract wra : MainApp.mwra) {
                    wraMap.put(wra.getName() + "-" + wra.getSerialNo(), wra);
                    lstMwra.add(wra.getName() + "-" + wra.getSerialNo());
                }

                WRAcounter = 1;

                WRAsize = MainApp.mwra.size();
            }
        } else {
            for (int i = WRAsize; i < MainApp.mwra.size(); i++) {
                wraMap.put(MainApp.mwra.get(i).getName() + "-" + MainApp.mwra.get(i).getSerialNo(), MainApp.mwra.get(i));
                lstMwra.add(MainApp.mwra.get(i).getName() + "-" + MainApp.mwra.get(i).getSerialNo());
            }

            WRAsize = MainApp.mwra.size();
        }


        bi.nb101.setAdapter(new ArrayAdapter<>(this, R.layout.item_style, lstMwra));


        bi.nb101.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (bi.nb101.getSelectedItemPosition() != 0) {
                    bi.curAge.setText("Current Age is: " + wraMap.get(bi.nb101.getSelectedItem().toString()).getAgeInYear() + " years");
                    bi.curAge1.setText("Current Age is: " + wraMap.get(bi.nb101.getSelectedItem().toString()).getAgeInYear() + " years");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


//============================================ Skip Patterns =======================================

        bi.nw203.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nw203a.isChecked()) {
                    //clearClass.ClearAllFields(bi.fldGrpnw204, true);

                    bi.nw204a.setEnabled(true);
                    bi.nw204b.setEnabled(true);
                    bi.nw205a.setEnabled(true);
                    bi.nw205b.setEnabled(true);
                    bi.nw206.setEnabled(true);
                    bi.nw207a.setEnabled(true);
                    bi.nw207b.setEnabled(true);
                    bi.nw208.setEnabled(true);
                    bi.nw209.setEnabled(true);
                    bi.nw210.setEnabled(true);
                    bi.nw211a.setEnabled(true);
                    bi.nw211b.setEnabled(true);
                    bi.nw212a.setEnabled(true);
                    bi.nw212b.setEnabled(true);
                    bi.nw21301.setEnabled(true);
                    bi.nw21302.setEnabled(true);
                    bi.nw21303.setEnabled(true);
                    bi.nw21398.setEnabled(true);
                    bi.nw21399.setEnabled(true);
                } else {
                    //clearClass.ClearAllFields(bi.fldGrpnw204, false);

                    bi.nw204a.setEnabled(false);
                    bi.nw204b.setEnabled(false);
                    bi.nw204.clearCheck();
                    bi.nw205a.setEnabled(false);
                    bi.nw205b.setEnabled(false);
                    bi.nw205.clearCheck();
                    bi.nw206.setEnabled(false);
                    bi.nw206.setText(null);
                    bi.nw207a.setEnabled(false);
                    bi.nw207b.setEnabled(false);
                    bi.nw207.clearCheck();
                    bi.nw208.setEnabled(false);
                    bi.nw208.setText(null);
                    bi.nw209.setEnabled(false);
                    bi.nw209.setText(null);
                    bi.nw210.setEnabled(false);
                    bi.nw210.setText(null);
                    bi.nw211a.setEnabled(false);
                    bi.nw211b.setEnabled(false);
                    bi.nw211.clearCheck();
                    bi.nw212a.setEnabled(false);
                    bi.nw212b.setEnabled(false);
                    bi.nw212.clearCheck();
                    bi.nw21301.clearCheck();
                    bi.nw21302.clearCheck();
                    bi.nw21303.clearCheck();
                    bi.nw21398.clearCheck();
                    bi.nw21399.clearCheck();

                    bi.nw21301.setEnabled(false);
                    bi.nw21302.setEnabled(false);
                    bi.nw21303.setEnabled(false);
                    bi.nw21398.setEnabled(false);
                    bi.nw21399.setEnabled(false);
                }
            }
        });

        bi.nw204.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nw204a.isChecked()) {
                    //clearClass.ClearAllFields(bi.fldGrpnw205, false);
                    //clearClass.ClearAllFields(bi.fldGrpnw206, true);
                    bi.nw205a.setEnabled(false);
                    bi.nw205b.setEnabled(false);
                    bi.nw205.clearCheck();

                } else {

                    bi.nw205a.setEnabled(true);
                    bi.nw205b.setEnabled(true);
                    //bi.nw205.clearCheck();
                }
            }
        });

        bi.nw205.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nw205a.isChecked()) {

                    bi.nw206.setEnabled(true);
                    bi.nw207a.setEnabled(true);
                    bi.nw207b.setEnabled(true);
                    bi.nw208.setEnabled(true);
                    bi.nw209.setEnabled(true);
                    bi.nw210.setEnabled(true);
                    bi.nw211a.setEnabled(true);
                    bi.nw211b.setEnabled(true);
                    bi.nw212a.setEnabled(true);
                    bi.nw212b.setEnabled(true);
                    bi.nw21301.setEnabled(true);
                    bi.nw21302.setEnabled(true);
                    bi.nw21303.setEnabled(true);
                    bi.nw21398.setEnabled(true);
                    bi.nw21399.setEnabled(true);

                } else {

                    bi.nw206.setEnabled(false);
                    bi.nw206.setText(null);
                    bi.nw207a.setEnabled(false);
                    bi.nw207b.setEnabled(false);
                    bi.nw207.clearCheck();
                    bi.nw208.setEnabled(false);
                    bi.nw208.setText(null);
                    bi.nw209.setEnabled(false);
                    bi.nw209.setText(null);
                    bi.nw210.setEnabled(false);
                    bi.nw210.setText(null);
                    bi.nw211a.setEnabled(false);
                    bi.nw211b.setEnabled(false);
                    bi.nw211.clearCheck();
                    bi.nw212a.setEnabled(false);
                    bi.nw212b.setEnabled(false);
                    bi.nw212.clearCheck();
                    bi.nw21301.clearCheck();
                    bi.nw21302.clearCheck();
                    bi.nw21303.clearCheck();
                    bi.nw21398.clearCheck();
                    bi.nw21399.clearCheck();

                    bi.nw21301.setEnabled(false);
                    bi.nw21302.setEnabled(false);
                    bi.nw21303.setEnabled(false);
                    bi.nw21398.setEnabled(false);
                    bi.nw21399.setEnabled(false);
                }
            }
        });

        bi.nw207.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.nw207a) {

                    bi.nw208.setEnabled(true);
                    bi.nw209.setEnabled(true);
                    bi.nw210.setEnabled(true);
                    bi.nw211a.setEnabled(true);
                    bi.nw211b.setEnabled(true);
                    bi.nw212a.setEnabled(true);
                    bi.nw212b.setEnabled(true);
                    bi.nw21301.setEnabled(true);
                    bi.nw21302.setEnabled(true);
                    bi.nw21303.setEnabled(true);
                    bi.nw21398.setEnabled(true);
                    bi.nw21399.setEnabled(true);

                } else {
                    bi.nw208.setEnabled(false);
                    bi.nw208.setText(null);
                    bi.nw209.setEnabled(false);
                    bi.nw209.setText(null);
                    bi.nw210.setEnabled(false);
                    bi.nw210.setText(null);
                    bi.nw211a.setEnabled(false);
                    bi.nw211b.setEnabled(false);
                    bi.nw211.clearCheck();
                    bi.nw212a.setEnabled(false);
                    bi.nw212b.setEnabled(false);
                    bi.nw212.clearCheck();
                    bi.nw21301.clearCheck();
                    bi.nw21302.clearCheck();
                    bi.nw21303.clearCheck();
                    bi.nw21398.clearCheck();
                    bi.nw21399.clearCheck();

                    bi.nw21301.setEnabled(false);
                    bi.nw21302.setEnabled(false);
                    bi.nw21303.setEnabled(false);
                    bi.nw21398.setEnabled(false);
                    bi.nw21399.setEnabled(false);
                }
            }
        });

        bi.nw208.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (bi.nw208.getText().toString().equals("0")) {
                    //clearClass.ClearAllFields(bi.fldGrpnw209, false);
                    bi.nw209.setEnabled(false);
                    bi.nw209.setText(null);
                    bi.nw210.setEnabled(false);
                    bi.nw210.setText(null);
                    bi.nw211a.setEnabled(false);
                    bi.nw211b.setEnabled(false);
                    bi.nw211.clearCheck();
                    bi.nw212a.setEnabled(false);
                    bi.nw212b.setEnabled(false);
                    bi.nw212.clearCheck();
                    bi.nw21301.clearCheck();
                    bi.nw21302.clearCheck();
                    bi.nw21303.clearCheck();
                    bi.nw21398.clearCheck();
                    bi.nw21399.clearCheck();
                    bi.nw21301.setEnabled(false);
                    bi.nw21302.setEnabled(false);
                    bi.nw21303.setEnabled(false);
                    bi.nw21398.setEnabled(false);
                    bi.nw21399.setEnabled(false);

                } else {

                    bi.nw209.setEnabled(true);
                    bi.nw210.setEnabled(true);
                    bi.nw211a.setEnabled(true);
                    bi.nw211b.setEnabled(true);
                    bi.nw212a.setEnabled(true);
                    bi.nw212b.setEnabled(true);
                    bi.nw21301.setEnabled(true);
                    bi.nw21302.setEnabled(true);
                    bi.nw21303.setEnabled(true);
                    bi.nw21398.setEnabled(true);
                    bi.nw21399.setEnabled(true);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        bi.nw209.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (bi.nw209.getText().toString().equals("0")) {
                    clearClass.ClearAllFields(bi.fldGrpnw210, false);


                } else {
                    clearClass.ClearAllFields(bi.fldGrpnw210, true);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        bi.nw211.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.nw211a) {
                    bi.nw212a.setEnabled(true);
                    bi.nw212b.setEnabled(true);
                    bi.nw21301.setEnabled(true);
                    bi.nw21302.setEnabled(true);
                    bi.nw21303.setEnabled(true);
                    bi.nw21398.setEnabled(true);
                    bi.nw21399.setEnabled(true);
                } else {
                    bi.nw212a.setEnabled(false);
                    bi.nw212b.setEnabled(false);
                    bi.nw212.clearCheck();
                    bi.nw21301.clearCheck();
                    bi.nw21302.clearCheck();
                    bi.nw21303.clearCheck();
                    bi.nw21398.clearCheck();
                    bi.nw21399.clearCheck();

                    bi.nw21301.setEnabled(false);
                    bi.nw21302.setEnabled(false);
                    bi.nw21303.setEnabled(false);
                    bi.nw21398.setEnabled(false);
                    bi.nw21399.setEnabled(false);
                }

            }
        });
        bi.nw212.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.nw212a) {
                    clearClass.ClearAllFields(bi.fldGrpnb107, true);

                } else {
                    clearClass.ClearAllFields(bi.fldGrpnb107, false);

                }
            }
        });
        bi.nw21398.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.nw21398a) {
                    //  bi.nw212.clearCheck();
                    bi.nw21301.clearCheck();
                    bi.nw21302.clearCheck();
                    bi.nw21303.clearCheck();
                    bi.nw21399.clearCheck();

                    bi.nw21301a.setEnabled(false);
                    bi.nw21301b.setEnabled(false);
                    bi.nw21302a.setEnabled(false);
                    bi.nw21302b.setEnabled(false);
                    bi.nw21303a.setEnabled(false);
                    bi.nw21303b.setEnabled(false);
                    bi.nw21399a.setEnabled(false);
                    bi.nw21399b.setEnabled(false);
                } else {
                    bi.nw21301a.setEnabled(true);
                    bi.nw21301b.setEnabled(true);

                    bi.nw21302a.setEnabled(true);
                    bi.nw21302b.setEnabled(true);

                    bi.nw21303a.setEnabled(true);
                    bi.nw21303b.setEnabled(true);

                    bi.nw21399a.setEnabled(true);
                    bi.nw21399b.setEnabled(true);
                }
            }
        });
        bi.nw21399.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.nw21399a) {
                    bi.nw21301.clearCheck();
                    bi.nw21302.clearCheck();
                    bi.nw21303.clearCheck();
                    bi.nw21398.clearCheck();

                    bi.nw21301a.setEnabled(false);
                    bi.nw21301b.setEnabled(false);

                    bi.nw21302a.setEnabled(false);
                    bi.nw21302b.setEnabled(false);

                    bi.nw21303a.setEnabled(false);
                    bi.nw21303b.setEnabled(false);

                    bi.nw21398a.setEnabled(false);
                    bi.nw21398b.setEnabled(false);
                } else {
                    bi.nw21301a.setEnabled(true);
                    bi.nw21301b.setEnabled(true);

                    bi.nw21302a.setEnabled(true);
                    bi.nw21302b.setEnabled(true);

                    bi.nw21303a.setEnabled(true);
                    bi.nw21303b.setEnabled(true);

                    bi.nw21398a.setEnabled(true);
                    bi.nw21398b.setEnabled(true);
                }
            }
        });


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

                MainApp.nuCount = 1;
                finish();

                if (bi.nw203a.isChecked()) {
                    finish();
                    if (bi.nw204a.isChecked() || bi.nw205a.isChecked()) {
                        if (bi.nw207a.isChecked()) {
                            if (MainApp.totalPregnancy > 0) {
//                                startActivity(new Intent(this, SectionB1AActivity.class));
                                startActivity(new Intent(this, SectionC1Activity.class));
                            } else if (MainApp.totalPregnancy == 1 && bi.nw211a.isChecked()) {
                                startActivity(new Intent(this, SectionB2Activity.class));
                            } else if (MainApp.totalPregnancy == 0) {
                                startActivity(new Intent(this, SectionB6Activity.class));
                            }
                        } else {
                            startActivity(new Intent(this, SectionB6Activity.class));
                        }
                    } else {
                        startActivity(new Intent(this, SectionB6Activity.class));
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

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }

    public void BtnEnd() {
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            //Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

            //finish();

            MainApp.endChildActivity(this, this, false);

        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean ValidateForm() {

        if (!validatorClass.EmptySpinner(this, bi.nb101, getString(R.string.nb101))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nw201days, getString(R.string.day))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.nw201days, 1, 29, 98, "Range 1-29 or 98", getString(R.string.day))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nw201months, getString(R.string.months))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.nw201months, 1, 11, 98, "Range 1-11 or 98", getString(R.string.months))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nw201years, getString(R.string.year2))) {
            return false;
        }

        Date date = new Date(); // Current date
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);

        if (!validatorClass.RangeTextBox(this, bi.nw201years, year - 49, year - 15, 9998,
                "Range " + (year - 49) + " - " + (year - 15), getString(R.string.year2))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nw202, getString(R.string.nw202))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.nw202, 15, 49, "Range 15-49", getString(R.string.year))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nw203, bi.nw203b, getString(R.string.nw203))) {
            return false;
        }

        if (bi.nw203a.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.nw204, bi.nw204a, getString(R.string.nw204))) {
                return false;
            }

            if (bi.nw204b.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.nw205, bi.nw205a, getString(R.string.nw205))) {
                    return false;
                }
            }

            if (bi.nw204a.isChecked() || bi.nw205a.isChecked()) {

                //if (bi.nw204a.isChecked() || bi.nw205a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nw206, getString(R.string.nw206))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.nw206, 15, Integer.valueOf(bi.nw202.getText().toString()), getString(R.string.nw206), " years")) {
                    return false;
                }

                if (!validatorClass.EmptyRadioButton(this, bi.nw207, bi.nw207a, getString(R.string.nw207))) {
                    return false;
                }


                if (bi.nw207a.isChecked()) {

                    if (!validatorClass.EmptyTextBox(this, bi.nw208, getString(R.string.nw208))) {
                        return false;
                    }


                    if (Integer.valueOf(bi.nw208.getText().toString()) > 0) {

                        if (!validatorClass.EmptyTextBox(this, bi.nw209, getString(R.string.nw209))) {
                            return false;
                        }
                        if (!validatorClass.RangeTextBox(this, bi.nw209, 0, Integer.valueOf(bi.nw208.getText().toString()), getString(R.string.nw209), " Deliveries")) {
                            return false;
                        }

                        if (!validatorClass.EmptyTextBox(this, bi.nw210, getString(R.string.nw210))) {
                            return false;
                        }

                        if (!validatorClass.RangeTextBox(this, bi.nw210, Integer.valueOf(bi.nw206.getText().toString()), Integer.valueOf(bi.nw202.getText().toString()), getString(R.string.nw210), " years")) {
                            return false;
                        }

                        if (!validatorClass.EmptyRadioButton(this, bi.nw211, bi.nw211a, getString(R.string.nw211))) {
                            return false;
                        }


                        if (bi.nw211a.isChecked()) {

                            String Errormsg = " If you are curently pregnant then total number of pregnancies and deliveries cannot be equal!";
                            Boolean condition = bi.nw208.getText().toString().equals(bi.nw209.getText().toString());
                            Boolean condit = Integer.valueOf(bi.nw208.getText().toString()) == Integer.valueOf(bi.nw209.getText().toString());
                            if (condition) {
                                validatorClass.setErrorOnMultTextFields(this, Errormsg, condition, bi.nw208, bi.nw209);
                                validatorClass.setErrorOnMultRadioFields(this, Errormsg, condition, bi.nw211a);
                                return false;
                            }

                            if (!validatorClass.EmptyRadioButton(this, bi.nw212, bi.nw212a, getString(R.string.nw212))) {
                                return false;
                            }

                            if (bi.nw212a.isChecked()) {
                                 /*   if (!validatorClass.EmptyRadioButton(this, bi.nw21398, bi.nw21398a, getString(R.string.dkn))) {
                                        return false;
                                    }

                                    if (!validatorClass.EmptyRadioButton(this, bi.nw21399, bi.nw21399a, getString(R.string.nr))) {
                                        return false;
                                    }*/

                                if (!bi.nw21398a.isChecked() || !bi.nw21399a.isChecked()) {
                                    if (!validatorClass.EmptyRadioButton(this, bi.nw21301, bi.nw21301a, getString(R.string.nw21301))) {
                                        return false;
                                    }

                                    if (!validatorClass.EmptyRadioButton(this, bi.nw21302, bi.nw21302a, getString(R.string.nw21302))) {
                                        return false;
                                    }

                                    if (!validatorClass.EmptyRadioButton(this, bi.nw21303, bi.nw21303a, getString(R.string.nw21303))) {
                                        return false;
                                    }

                                    if (!validatorClass.EmptyRadioButton(this, bi.nw21398, bi.nw21398a, getString(R.string.dkn))) {
                                        return false;
                                    }

                                    if (!validatorClass.EmptyRadioButton(this, bi.nw21399, bi.nw21399a, getString(R.string.nr))) {
                                        return false;
                                    }
                                }
                                    /*else if(bi.nw21398a.isChecked()){
                                        if (!validatorClass.EmptyRadioButton(this, bi.nw21398, bi.nw21398a, getString(R.string.dkn))) {
                                            return false;
                                        }
                                    }
                                    else if(bi.nw21399a.isChecked()){
                                        if (!validatorClass.EmptyRadioButton(this, bi.nw21399, bi.nw21399a, getString(R.string.nr))) {
                                            return false;
                                        }
                                    }*/

                            }
                            // When number of pregnancies is 1 and currently pregnant is yes then number of deliveries cannot be 1

                        }


                    }


                }


                //}


            }

        }
        return true;
    }

    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        MainApp.mc = new MWRAContract();

        MainApp.mc.setDevicetagID(MainApp.getTagName(this));
        MainApp.mc.setFormDate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(System.currentTimeMillis()));
        MainApp.mc.setUser(MainApp.userName);
        MainApp.mc.setDeviceId(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.mc.setApp_ver(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.mc.setB1SerialNo(wraMap.get(bi.nb101.getSelectedItem().toString()).getSerialNo());
        MainApp.mc.set_UUID(MainApp.fc.getUID());

        wraName = bi.nb101.getSelectedItem().toString();

        JSONObject sB1 = new JSONObject();

        sB1.put("nw101", bi.nb101.getSelectedItem().toString());
        sB1.put("nw1serialno", wraMap.get(bi.nb101.getSelectedItem().toString()).getSerialNo());

        //        nw201
        sB1.put("nw201days", bi.nw201days.getText().toString());
        sB1.put("nw201months", bi.nw201months.getText().toString());
        sB1.put("nw201years", bi.nw201years.getText().toString());
        //        nw202
        sB1.put("nw202", bi.nw202.getText().toString());
        //        nw203
        sB1.put("nw203", bi.nw203a.isChecked() ? "1" : bi.nw203b.isChecked() ? "2" : "0");
        //        nw204
        sB1.put("nw204", bi.nw204a.isChecked() ? "1" : bi.nw204b.isChecked() ? "2" : "0");
        //        nw205
        sB1.put("nw205", bi.nw205a.isChecked() ? "1" : bi.nw205b.isChecked() ? "2" : "0");
        //        nw206
        sB1.put("nw206", bi.nw206.getText().toString());
        //        nw207
        sB1.put("nw207", bi.nw207a.isChecked() ? "1" : bi.nw207b.isChecked() ? "2" : "0");

        sB1.put("nw208", bi.nw208.getText().toString());
        sB1.put("nw209", bi.nw209.getText().toString());

        sB1.put("nw210", bi.nw210.getText().toString());

        sB1.put("nw211", bi.nw211a.isChecked() ? "1" : bi.nw211b.isChecked() ? "2" : "0");

        sB1.put("nw212", bi.nw212a.isChecked() ? "1" : bi.nw212b.isChecked() ? "2" : "0");

        //        nw21301
        sB1.put("nw21301", bi.nw21301a.isChecked() ? "1" : bi.nw21301b.isChecked() ? "2" : "0");
        //        nw21302
        sB1.put("nw21302", bi.nw21302a.isChecked() ? "1"
                : bi.nw21302b.isChecked() ? "2" : "0");
        //        nw21303
        sB1.put("nw21303", bi.nw21303a.isChecked() ? "1"
                : bi.nw21303b.isChecked() ? "2" : "0");
        //        nw21398
        sB1.put("nw21398", bi.nw21398a.isChecked() ? "1"
                : bi.nw21398b.isChecked() ? "2" : "0");
        //        nw21399
        sB1.put("nw21399", bi.nw21399a.isChecked() ? "1"
                : bi.nw21399b.isChecked() ? "2" : "0");


        if (!bi.nw208.getText().toString().isEmpty()) {
            if (bi.nw211a.isChecked()) {
                MainApp.totalPregnancy = Integer.valueOf(bi.nw208.getText().toString()) - 1;
            } else {
                MainApp.totalPregnancy = Integer.valueOf(bi.nw208.getText().toString());
            }
        }

        MainApp.mc.setsB1(String.valueOf(sB1));


        //Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        Long updcount = db.addMWRA(MainApp.mc);
        MainApp.mc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.mc.set_UID(
                    (MainApp.mc.getDeviceId() + MainApp.mc.get_ID()));
            db.updateMWRAID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

        //return true;

    }

    public void BtnAddMember() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                SectionB1Activity.this);
        alertDialogBuilder
                .setMessage("Are you sure to add missing member?")
                .setCancelable(false)
                .setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                startActivity(new Intent(SectionB1Activity.this, SectionA2ListActivity.class)
                                        .putExtra("reBack", true));
                            }
                        });
        alertDialogBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

}
