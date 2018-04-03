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
import java.util.TimerTask;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.contracts.MWRAContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB1Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionB1Activity extends Activity implements TextWatcher, RadioGroup.OnCheckedChangeListener {

    public static String wraName = "";
    public static int WRAcounter = 0;
    public static int WRAsize = 0;
    static Map<String, FamilyMembersContract> wraMap;
    static ArrayList<String> lstMwra;
    static Boolean childCheck = false;
    private final long DELAY = 1000;
    ArrayList<String> respName;
    Map<String, String> respMap;
    ActivitySectionB1Binding bi;
    DatabaseHelper db;
    Boolean backPressed = false;
    Boolean frontPressed = false;
    String classPassName = "";
    private Timer timer = new Timer();

    static int size = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_b1);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b1);
        db = new DatabaseHelper(this);

        //Assigning data to UI binding
        bi.setCallback(this);
        this.setTitle(getResources().getString(R.string.nbheading));

        setupViews();
    }

    public void setupViews() {


        MainApp.status = 0;


//      Get intent
        if (getIntent().getBooleanExtra("reBackComing", true)) {
            if (getIntent().getBooleanExtra("mwraFlag", false)) {
                lstMwra.remove(getIntent().getStringExtra("wraName"));
                //      Increment WRA COUNTER
                WRAcounter++;

//                WRAsize = MainApp.mwra.size();

            } else {
                wraMap = new HashMap<>();
                lstMwra = new ArrayList<>();

                lstMwra.add("....");

                for (FamilyMembersContract wra : MainApp.mwra) {
                    wraMap.put(wra.getName() + "-" + wra.getSerialNo(), wra);
                    lstMwra.add(wra.getName() + "-" + wra.getSerialNo());
                }

                WRAcounter = 1;


            }
        } else {

            if (WRAcounter == 1) {
                wraMap = new HashMap<>();
                lstMwra = new ArrayList<>();

                lstMwra.add("....");

                WRAsize = 0;
            }

            for (int i = WRAsize; i < MainApp.mwra.size(); i++) {
                wraMap.put(MainApp.mwra.get(i).getName() + "-" + MainApp.mwra.get(i).getSerialNo(), MainApp.mwra.get(i));
                lstMwra.add(MainApp.mwra.get(i).getName() + "-" + MainApp.mwra.get(i).getSerialNo());
            }

//            WRAsize = MainApp.mwra.size();

        }


        bi.nb101.setAdapter(new ArrayAdapter<>(this, R.layout.item_style, lstMwra));

        bi.nb101.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (bi.nb101.getSelectedItemPosition() != 0) {
                    for (FamilyMembersContract fmc : MainApp.childUnder2Check) {
                        childCheck = fmc.getMotherId().equals(wraMap.get(bi.nb101.getSelectedItem().toString()).getSerialNo());
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        bi.nw202.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!bi.nw202.getText().toString().isEmpty()) {
                    bi.curAge.setText("Current Age is: " + bi.nw202.getText().toString() + " years");
                    bi.curAge1.setText("Current Age is: " + bi.nw202.getText().toString() + " years");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

//============================================ Skip Patterns =======================================


        bi.nw201days.addTextChangedListener(this);
        bi.nw201months.addTextChangedListener(this);
        bi.nw201years.addTextChangedListener(this);
        bi.nw202.addTextChangedListener(this);

        bi.nw203.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ValidateForm();
                if (bi.nw203a.isChecked()) {
                    bi.nw204a.setEnabled(true);
                    bi.nw204b.setEnabled(true);
                    bi.nw205a.setEnabled(true);
                    bi.nw205b.setEnabled(true);
                    bi.nw206.setEnabled(true);
                    bi.nw207a.setEnabled(true);
                    bi.nw207b.setEnabled(true);
                    bi.nw208a.setEnabled(true);
                    bi.nw208b.setEnabled(true);
                    bi.nw209a.setEnabled(true);
                    bi.nw209b.setEnabled(true);

                    bi.nw21001a.setEnabled(true);
                    bi.nw21002a.setEnabled(true);
                    bi.nw21003a.setEnabled(true);
                    bi.nw21098a.setEnabled(true);
                    bi.nw21099a.setEnabled(true);
                    bi.nw21001b.setEnabled(true);
                    bi.nw21002b.setEnabled(true);
                    bi.nw21003b.setEnabled(true);
                    bi.nw21098b.setEnabled(true);
                    bi.nw21099b.setEnabled(true);

                    bi.nw211.setEnabled(true);
                    bi.nw212.setEnabled(true);
                    bi.nw214.setEnabled(true);
                    bi.nw215.setEnabled(true);
                    bi.nw216a.setEnabled(true);
                    bi.nw216b.setEnabled(true);
                    bi.nw216aa.setEnabled(true);
                    bi.nw213.setEnabled(true);

                } else {
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
                    bi.nw208a.setEnabled(false);
                    bi.nw208b.setEnabled(false);
                    bi.nw208.clearCheck();

                    bi.nw209a.setEnabled(false);
                    bi.nw209b.setEnabled(false);
                    bi.nw209.clearCheck();

                    bi.nw21001.clearCheck();
                    bi.nw21002.clearCheck();
                    bi.nw21003.clearCheck();
                    bi.nw21098.clearCheck();
                    bi.nw21099.clearCheck();

                    bi.nw21001a.setEnabled(false);
                    bi.nw21002a.setEnabled(false);
                    bi.nw21003a.setEnabled(false);
                    bi.nw21098a.setEnabled(false);
                    bi.nw21099a.setEnabled(false);

                    bi.nw21001b.setEnabled(false);
                    bi.nw21002b.setEnabled(false);
                    bi.nw21003b.setEnabled(false);
                    bi.nw21098b.setEnabled(false);
                    bi.nw21099b.setEnabled(false);

                    bi.nw211.setEnabled(false);
                    bi.nw211.setText(null);
                    bi.nw212.setEnabled(false);
                    bi.nw212.setText(null);
                    bi.nw214.setEnabled(false);
                    bi.nw215.setEnabled(false);
                    bi.nw216a.setEnabled(false);
                    bi.nw216b.setEnabled(false);
                    bi.nw216.clearCheck();
                    bi.nw216aa.setEnabled(false);
                    bi.nw216aa.setText(null);
                    bi.nw213.setEnabled(false);
                    bi.nw213.setText(null);

                }
            }
        });

        bi.nw204.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ValidateForm();
                if (bi.nw204a.isChecked()) {
                    bi.nw205a.setEnabled(false);
                    bi.nw205b.setEnabled(false);
                    bi.nw205.clearCheck();

                    bi.nw206.setEnabled(true);
                    bi.nw207a.setEnabled(true);
                    bi.nw207b.setEnabled(true);
                    bi.nw208a.setEnabled(true);
                    bi.nw208b.setEnabled(true);
                    bi.nw209a.setEnabled(true);
                    bi.nw209b.setEnabled(true);
                    bi.nw21001a.setEnabled(true);
                    bi.nw21002a.setEnabled(true);
                    bi.nw21003a.setEnabled(true);
                    bi.nw21098a.setEnabled(true);
                    bi.nw21099a.setEnabled(true);

                    bi.nw21001b.setEnabled(true);
                    bi.nw21002b.setEnabled(true);
                    bi.nw21003b.setEnabled(true);
                    bi.nw21098b.setEnabled(true);
                    bi.nw21099b.setEnabled(true);
                    bi.nw211.setEnabled(true);
                    bi.nw212.setEnabled(true);
                    bi.nw214.setEnabled(true);
                    bi.nw215.setEnabled(true);
                    bi.nw216a.setEnabled(true);
                    bi.nw216b.setEnabled(true);
                    bi.nw216aa.setEnabled(true);
                    bi.nw213.setEnabled(true);

                } else {

                    bi.nw205a.setEnabled(true);
                    bi.nw205b.setEnabled(true);
                    bi.nw206.setEnabled(false);
                    bi.nw206.setText(null);
                    bi.nw207a.setEnabled(false);
                    bi.nw207b.setEnabled(false);
                    bi.nw207.clearCheck();
                    bi.nw208a.setEnabled(false);
                    bi.nw208b.setEnabled(false);
                    bi.nw208.clearCheck();
                    bi.nw209a.setEnabled(false);
                    bi.nw209b.setEnabled(false);
                    bi.nw209.clearCheck();
                    bi.nw21001.clearCheck();
                    bi.nw21002.clearCheck();
                    bi.nw21003.clearCheck();
                    bi.nw21098.clearCheck();
                    bi.nw21099.clearCheck();

                    bi.nw21001.setEnabled(false);
                    bi.nw21002.setEnabled(false);
                    bi.nw21003.setEnabled(false);
                    bi.nw21098.setEnabled(false);
                    bi.nw21099.setEnabled(false);
                    bi.nw211.setEnabled(false);
                    bi.nw211.setText(null);
                    bi.nw212.setEnabled(false);
                    bi.nw212.setText(null);
                    bi.nw214.setEnabled(false);
                    bi.nw215.setEnabled(false);
                    bi.nw216a.setEnabled(false);
                    bi.nw216b.setEnabled(false);
                    bi.nw216.clearCheck();
                    bi.nw216aa.setEnabled(false);
                    bi.nw216aa.setText(null);
                    bi.nw213.setEnabled(false);
                    bi.nw213.setText(null);

                }
            }
        });

        bi.nw205.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ValidateForm();
                if (bi.nw205a.isChecked()) {
                    bi.nw206.setEnabled(true);
                    bi.nw207a.setEnabled(true);
                    bi.nw207b.setEnabled(true);
                    bi.nw211.setEnabled(true);
                    bi.nw212.setEnabled(true);
                    bi.nw215.setEnabled(true);
                    bi.nw214.setEnabled(true);
                    bi.nw216a.setEnabled(true);
                    bi.nw216b.setEnabled(true);
                    bi.nw216aa.setEnabled(true);
                    bi.nw215.setEnabled(true);
                    bi.nw213.setEnabled(true);
                    bi.nw208a.setEnabled(true);
                    bi.nw208b.setEnabled(true);
                    bi.nw209a.setEnabled(true);
                    bi.nw209b.setEnabled(true);
//                    w213
                    bi.nw21001a.setEnabled(true);
                    bi.nw21002a.setEnabled(true);
                    bi.nw21003a.setEnabled(true);
                    bi.nw21098a.setEnabled(true);
                    bi.nw21099a.setEnabled(true);

                    bi.nw21001b.setEnabled(true);
                    bi.nw21002b.setEnabled(true);
                    bi.nw21003b.setEnabled(true);
                    bi.nw21098b.setEnabled(true);
                    bi.nw21099b.setEnabled(true);

                } else {
                    bi.nw206.setEnabled(false);
                    bi.nw206.setText(null);
                    bi.nw207a.setEnabled(false);
                    bi.nw207b.setEnabled(false);
                    bi.nw207.clearCheck();
                    bi.nw211.setEnabled(false);
                    bi.nw211.setText(null);
                    bi.nw212.setEnabled(false);
                    bi.nw212.setText(null);
                    bi.nw215.setEnabled(false);
                    bi.nw214.setEnabled(false);

                    bi.nw216a.setEnabled(false);
                    bi.nw216b.setEnabled(false);
                    bi.nw216.clearCheck();
                    bi.nw216aa.setEnabled(false);
                    bi.nw216aa.setText(null);
                    bi.nw213.setEnabled(false);
                    bi.nw213.setText(null);
                    bi.nw208a.setEnabled(false);
                    bi.nw208b.setEnabled(false);
                    bi.nw208.clearCheck();
                    bi.nw209a.setEnabled(false);
                    bi.nw209b.setEnabled(false);
                    bi.nw209.clearCheck();

                    bi.nw21001.clearCheck();
                    bi.nw21002.clearCheck();
                    bi.nw21003.clearCheck();
                    bi.nw21098.clearCheck();
                    bi.nw21099.clearCheck();

                    bi.nw21001a.setEnabled(false);
                    bi.nw21002a.setEnabled(false);
                    bi.nw21003a.setEnabled(false);
                    bi.nw21098a.setEnabled(false);
                    bi.nw21099a.setEnabled(false);

                    bi.nw21001b.setEnabled(false);
                    bi.nw21002b.setEnabled(false);
                    bi.nw21003b.setEnabled(false);
                    bi.nw21098b.setEnabled(false);
                    bi.nw21099b.setEnabled(false);

                }
            }
        });

        bi.nw206.addTextChangedListener(this);

        bi.nw207.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ValidateForm();
                if (checkedId == R.id.nw207a) {

                    bi.nw211.setEnabled(true);
                    bi.nw212.setEnabled(true);
                    bi.nw215.setEnabled(true);
                    bi.nw214.setEnabled(true);
                    bi.nw216a.setEnabled(true);
                    bi.nw216b.setEnabled(true);
                    bi.nw216aa.setEnabled(true);
                    bi.nw213.setEnabled(true);
                    bi.nw208a.setEnabled(true);
                    bi.nw208b.setEnabled(true);
                    bi.nw209a.setEnabled(true);
                    bi.nw209b.setEnabled(true);
                    bi.nw21001a.setEnabled(true);
                    bi.nw21002a.setEnabled(true);
                    bi.nw21003a.setEnabled(true);
                    bi.nw21098a.setEnabled(true);
                    bi.nw21099a.setEnabled(true);
                    bi.nw21001b.setEnabled(true);
                    bi.nw21002b.setEnabled(true);
                    bi.nw21003b.setEnabled(true);
                    bi.nw21098b.setEnabled(true);
                    bi.nw21099b.setEnabled(true);
                } else {
                    bi.nw211.setEnabled(false);
                    bi.nw211.setText(null);
                    bi.nw212.setEnabled(false);
                    bi.nw215.setEnabled(false);
                    bi.nw212.setText(null);
                    bi.nw215.setText(null);
                    bi.nw214.setEnabled(false);
                    bi.nw216a.setEnabled(false);
                    bi.nw216b.setEnabled(false);
                    bi.nw216.clearCheck();
                    bi.nw216aa.setEnabled(false);
                    bi.nw216aa.setText(null);
                    bi.nw213.setEnabled(false);
                    bi.nw213.setText(null);
                    bi.nw208a.setEnabled(false);
                    bi.nw208b.setEnabled(false);
                    bi.nw208.clearCheck();
                    bi.nw209a.setEnabled(false);
                    bi.nw209b.setEnabled(false);
                    bi.nw209.clearCheck();
                    bi.nw21001.clearCheck();
                    bi.nw21002.clearCheck();
                    bi.nw21003.clearCheck();
                    bi.nw21098.clearCheck();
                    bi.nw21099.clearCheck();

                    bi.nw21001a.setEnabled(false);
                    bi.nw21002a.setEnabled(false);
                    bi.nw21003a.setEnabled(false);
                    bi.nw21098a.setEnabled(false);
                    bi.nw21099a.setEnabled(false);

                    bi.nw21001b.setEnabled(false);
                    bi.nw21002b.setEnabled(false);
                    bi.nw21003b.setEnabled(false);
                    bi.nw21098b.setEnabled(false);
                    bi.nw21099b.setEnabled(false);
                }
            }
        });

        bi.nw211.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (bi.nw207a.isChecked() && bi.nw208a.isChecked()) {
                    if (bi.nw211.getText().toString().equals("1")) {
                        bi.nw212.setEnabled(false);
                        bi.nw213.setEnabled(false);
                        bi.nw214.setEnabled(false);
                        bi.nw215.setEnabled(false);
                        bi.nw216a.setEnabled(false);
                        bi.nw216b.setEnabled(false);
                        bi.nw216aa.setEnabled(false);
                        bi.nw212.setText("0");
                        bi.nw213.setText(null);
                        bi.nw214.setText(null);
                        bi.nw215.setText(null);
                        bi.nw216.clearCheck();
                        bi.nw216aa.setText(null);

                    } else {
                        bi.nw212.setEnabled(true);
                        bi.nw213.setEnabled(true);
                        bi.nw214.setEnabled(true);
                        bi.nw215.setEnabled(true);
                        bi.nw216a.setEnabled(true);
                        bi.nw216b.setEnabled(true);
                        bi.nw216aa.setEnabled(true);
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

                timer.cancel();
                timer = new Timer();
                timer.schedule(
                        new TimerTask() {
                            @Override
                            public void run() {

                                SectionB1Activity.this.runOnUiThread(new Runnable() {
                                    public void run() {
                                        ValidateForm();
                                    }
                                    //}
                                });

                            }
                        },
                        DELAY
                );
            }
        });


        bi.nw212.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (bi.nw207a.isChecked() && bi.nw208a.isChecked() && bi.nw211.getText().toString().equals("1")) {
                    if (bi.nw212.getText().toString().equals("0")) {
                        bi.nw213.setEnabled(false);
                        bi.nw213.setText(null);
                        bi.nw214.setEnabled(false);
                        bi.nw214.setText(null);
                        bi.nw215.setEnabled(false);
                        bi.nw215.setText(null);
                        bi.nw216a.setEnabled(false);
                        bi.nw216b.setEnabled(false);
                        bi.nw216.clearCheck();
                        bi.nw216aa.setEnabled(false);
                        bi.nw216aa.setText(null);

                    } else {

                        bi.nw213.setEnabled(true);
                        bi.nw214.setEnabled(true);
                        bi.nw215.setEnabled(true);
                        bi.nw216a.setEnabled(true);
                        bi.nw216b.setEnabled(true);
                        bi.nw216aa.setEnabled(true);

                    }
                } else if (bi.nw207a.isChecked() && bi.nw211.getText().toString().equals("1")) {
                    if (bi.nw212.getText().toString().equals("0")) {
                        bi.nw213.setEnabled(false);
                        bi.nw213.setText(null);
                        bi.nw214.setEnabled(false);
                        bi.nw214.setText(null);
                        bi.nw215.setEnabled(false);
                        bi.nw215.setText(null);
                        bi.nw216a.setEnabled(false);
                        bi.nw216b.setEnabled(false);
                        bi.nw216.clearCheck();
                        bi.nw216aa.setEnabled(false);
                        bi.nw216aa.setText(null);

                    } else {

                        bi.nw213.setEnabled(true);
                        bi.nw214.setEnabled(true);
                        bi.nw215.setEnabled(true);
                        bi.nw216a.setEnabled(true);
                        bi.nw216b.setEnabled(true);
                        bi.nw216aa.setEnabled(true);

                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                timer.cancel();
                timer = new Timer();
                timer.schedule(
                        new TimerTask() {
                            @Override
                            public void run() {

                                SectionB1Activity.this.runOnUiThread(new Runnable() {
                                    public void run() {
                                        ValidateForm();
                                    }
                                    //}
                                });

                            }
                        },
                        DELAY
                );

            }
        });


        bi.nw214.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (bi.nw214.getText().toString().equals("0") || bi.nw214.getText().toString().isEmpty()) {
                    bi.nw215.setEnabled(false);
                    bi.nw215.setText(null);
                    bi.nw216a.setEnabled(false);
                    bi.nw216b.setEnabled(false);
                    bi.nw216.clearCheck();
                    bi.nw216aa.setEnabled(false);
                    bi.nw216aa.setText(null);
                } else {
                    bi.nw215.setEnabled(true);
                    bi.nw216a.setEnabled(true);
                    bi.nw216b.setEnabled(true);
                    bi.nw216aa.setEnabled(true);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                timer.cancel();
                timer = new Timer();
                timer.schedule(
                        new TimerTask() {
                            @Override
                            public void run() {

                                SectionB1Activity.this.runOnUiThread(new Runnable() {
                                    public void run() {
                                        ValidateForm();
                                    }
                                    //}
                                });

                            }
                        },
                        DELAY
                );

            }
        });

        bi.nw208.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ValidateForm();
                if (checkedId == R.id.nw208a) {
                    bi.nw209a.setEnabled(true);
                    bi.nw209b.setEnabled(true);

                    bi.nw21001a.setEnabled(true);
                    bi.nw21002a.setEnabled(true);
                    bi.nw21003a.setEnabled(true);
                    bi.nw21098a.setEnabled(true);
                    bi.nw21099a.setEnabled(true);

                    bi.nw21001b.setEnabled(true);
                    bi.nw21002b.setEnabled(true);
                    bi.nw21003b.setEnabled(true);
                    bi.nw21098b.setEnabled(true);
                    bi.nw21099b.setEnabled(true);
                } else {
                    bi.nw209a.setEnabled(false);
                    bi.nw209b.setEnabled(false);
                    bi.nw209.clearCheck();

                    bi.nw21001.clearCheck();
                    bi.nw21002.clearCheck();
                    bi.nw21003.clearCheck();
                    bi.nw21098.clearCheck();
                    bi.nw21099.clearCheck();
                    bi.nw21001.clearCheck();
                    bi.nw21002.clearCheck();
                    bi.nw21003.clearCheck();
                    bi.nw21098.clearCheck();
                    bi.nw21099.clearCheck();

                    bi.nw21001a.setEnabled(false);
                    bi.nw21002a.setEnabled(false);
                    bi.nw21003a.setEnabled(false);
                    bi.nw21098a.setEnabled(false);
                    bi.nw21099a.setEnabled(false);

                    bi.nw21001b.setEnabled(false);
                    bi.nw21002b.setEnabled(false);
                    bi.nw21003b.setEnabled(false);
                    bi.nw21098b.setEnabled(false);
                    bi.nw21099b.setEnabled(false);
                }

            }
        });
        bi.nw209.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ValidateForm();
                if (checkedId == R.id.nw209a) {
                    bi.nw21001a.setEnabled(true);
                    bi.nw21002a.setEnabled(true);
                    bi.nw21003a.setEnabled(true);
                    bi.nw21098a.setEnabled(true);
                    bi.nw21099a.setEnabled(true);

                    bi.nw21001b.setEnabled(true);
                    bi.nw21002b.setEnabled(true);
                    bi.nw21003b.setEnabled(true);
                    bi.nw21098b.setEnabled(true);
                    bi.nw21099b.setEnabled(true);

                } else {
                    bi.nw21001.clearCheck();
                    bi.nw21002.clearCheck();
                    bi.nw21003.clearCheck();
                    bi.nw21098.clearCheck();
                    bi.nw21099.clearCheck();

                    bi.nw21001a.setEnabled(false);
                    bi.nw21002a.setEnabled(false);
                    bi.nw21003a.setEnabled(false);
                    bi.nw21098a.setEnabled(false);
                    bi.nw21099a.setEnabled(false);

                    bi.nw21001b.setEnabled(false);
                    bi.nw21002b.setEnabled(false);
                    bi.nw21003b.setEnabled(false);
                    bi.nw21098b.setEnabled(false);
                    bi.nw21099b.setEnabled(false);

                }
            }
        });


        bi.nw21001.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ValidateForm();
                if (checkedId == R.id.nw21001a) {
                    bi.nw21003.clearCheck();
                    bi.nw21098.clearCheck();
                    bi.nw21099.clearCheck();

                    bi.nw21003a.setEnabled(false);
                    bi.nw21003b.setEnabled(false);
                    bi.nw21098a.setEnabled(false);
                    bi.nw21098b.setEnabled(false);
                    bi.nw21099a.setEnabled(false);
                    bi.nw21099b.setEnabled(false);
                } else {

                    bi.nw21003a.setEnabled(true);
                    bi.nw21003b.setEnabled(true);

                    bi.nw21098a.setEnabled(true);
                    bi.nw21098b.setEnabled(true);

                    bi.nw21099a.setEnabled(true);
                    bi.nw21099b.setEnabled(true);
                }
            }
        });

        bi.nw21002.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ValidateForm();
                if (checkedId == R.id.nw21002a) {
                    bi.nw21003.clearCheck();
                    bi.nw21098.clearCheck();
                    bi.nw21099.clearCheck();

                    bi.nw21003a.setEnabled(false);
                    bi.nw21003b.setEnabled(false);
                    bi.nw21098a.setEnabled(false);
                    bi.nw21098b.setEnabled(false);
                    bi.nw21099a.setEnabled(false);
                    bi.nw21099b.setEnabled(false);
                } else {

                    bi.nw21003a.setEnabled(true);
                    bi.nw21003b.setEnabled(true);

                    bi.nw21098a.setEnabled(true);
                    bi.nw21098b.setEnabled(true);

                    bi.nw21099a.setEnabled(true);
                    bi.nw21099b.setEnabled(true);
                }
            }
        });


        bi.nw21003.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ValidateForm();
                if (checkedId == R.id.nw21003a) {
                    //  bi.nw209.clearCheck();
                    bi.nw21001.clearCheck();
                    bi.nw21002.clearCheck();
                    bi.nw21098.clearCheck();
                    bi.nw21099.clearCheck();

                    bi.nw21001a.setEnabled(false);
                    bi.nw21001b.setEnabled(false);
                    bi.nw21002a.setEnabled(false);
                    bi.nw21002b.setEnabled(false);
                    bi.nw21098a.setEnabled(false);
                    bi.nw21098b.setEnabled(false);
                    bi.nw21099a.setEnabled(false);
                    bi.nw21099b.setEnabled(false);
                } else {
                    bi.nw21001a.setEnabled(true);
                    bi.nw21001b.setEnabled(true);

                    bi.nw21002a.setEnabled(true);
                    bi.nw21002b.setEnabled(true);

                    bi.nw21098a.setEnabled(true);
                    bi.nw21098b.setEnabled(true);

                    bi.nw21099a.setEnabled(true);
                    bi.nw21099b.setEnabled(true);
                }
            }
        });

        bi.nw21098.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ValidateForm();
                if (checkedId == R.id.nw21098a) {
                    //  bi.nw209.clearCheck();
                    bi.nw21001.clearCheck();
                    bi.nw21002.clearCheck();
                    bi.nw21003.clearCheck();
                    bi.nw21099.clearCheck();

                    bi.nw21001a.setEnabled(false);
                    bi.nw21001b.setEnabled(false);
                    bi.nw21002a.setEnabled(false);
                    bi.nw21002b.setEnabled(false);
                    bi.nw21003a.setEnabled(false);
                    bi.nw21003b.setEnabled(false);
                    bi.nw21099a.setEnabled(false);
                    bi.nw21099b.setEnabled(false);
                } else {
                    bi.nw21001a.setEnabled(true);
                    bi.nw21001b.setEnabled(true);

                    bi.nw21002a.setEnabled(true);
                    bi.nw21002b.setEnabled(true);

                    bi.nw21003a.setEnabled(true);
                    bi.nw21003b.setEnabled(true);

                    bi.nw21099a.setEnabled(true);
                    bi.nw21099b.setEnabled(true);
                }
            }
        });


        bi.nw21099.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ValidateForm();
                if (checkedId == R.id.nw21099a) {
                    bi.nw21001.clearCheck();
                    bi.nw21002.clearCheck();
                    bi.nw21003.clearCheck();
                    bi.nw21098.clearCheck();

                    bi.nw21001a.setEnabled(false);
                    bi.nw21001b.setEnabled(false);
                    bi.nw21002a.setEnabled(false);
                    bi.nw21002b.setEnabled(false);
                    bi.nw21003a.setEnabled(false);
                    bi.nw21003b.setEnabled(false);
                    bi.nw21098a.setEnabled(false);
                    bi.nw21098b.setEnabled(false);
                } else {
                    bi.nw21001a.setEnabled(true);
                    bi.nw21001b.setEnabled(true);

                    bi.nw21002a.setEnabled(true);
                    bi.nw21002b.setEnabled(true);

                    bi.nw21003a.setEnabled(true);
                    bi.nw21003b.setEnabled(true);

                    bi.nw21098a.setEnabled(true);
                    bi.nw21098b.setEnabled(true);
                }
            }
        });

        bi.nw213.addTextChangedListener(this);
        bi.nw214.addTextChangedListener(this);
        bi.nw215.addTextChangedListener(this);
        bi.nw216aa.addTextChangedListener(this);


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
                MainApp.count = 1;

                frontPressed = true;

                WRAsize = MainApp.mwra.size();

                //finish();

                if (bi.nw203a.isChecked()) {
                    if (bi.nw204a.isChecked() || bi.nw205a.isChecked()) {
                        if (bi.nw207a.isChecked()) {
                            if (MainApp.totalPregnancy > 0) {
                                startActivityForResult(new Intent(this, SectionB1AActivity.class)
                                        .putExtra("backPressed", classPassName.equals(SectionB1AActivity.class.getName())), 1);
                            } else if (childCheck) {
                                startActivity(new Intent(this, SectionB2Activity.class));
                            } else {
                                if (SectionB1Activity.WRAcounter == MainApp.mwra.size()
                                        &&
                                        MainApp.B6Flag) {
                                    startActivityForResult(new Intent(this, SectionB6Activity.class)
                                            .putExtra("backPressed", classPassName.equals(SectionB6Activity.class.getName())), 1);
                                } else {
                                    startActivity(new Intent(this, MotherEndingActivity.class)
                                            .putExtra("complete", true));
                                }
                            }
                        } else {
                            if (SectionB1Activity.WRAcounter == MainApp.mwra.size()
                                    &&
                                    MainApp.B6Flag) {
                                startActivityForResult(new Intent(this, SectionB6Activity.class)
                                        .putExtra("backPressed", classPassName.equals(SectionB6Activity.class.getName())), 1);
                            } else {
                                startActivity(new Intent(this, MotherEndingActivity.class)
                                        .putExtra("complete", true));
                            }
                        }
                    } else {
                        if (SectionB1Activity.WRAcounter == MainApp.mwra.size()
                                &&
                                MainApp.B6Flag) {
                            startActivityForResult(new Intent(this, SectionB6Activity.class)
                                    .putExtra("backPressed", classPassName.equals(SectionB6Activity.class.getName())), 1);
                        } else {
                            startActivity(new Intent(this, MotherEndingActivity.class)
                                    .putExtra("complete", true));
                        }
                    }
                } else {
                    startActivity(new Intent(this, MotherEndingActivity.class)
                            .putExtra("checkingFlag", true)
                            .putExtra("complete", true));
                }

                //startActivity(new Intent(this, SectionC1Activity.class));

//                finish();

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
        if (!validatorClass.RangeTextBox(this, bi.nw201days, 1, 31, 98, "Range 1-31 or 98", getString(R.string.day))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nw201months, getString(R.string.months))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.nw201months, 1, 12, 98, "Range 1-12 or 98", getString(R.string.months))) {
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

                if (!validatorClass.RangeTextBox(this, bi.nw206, 10, Integer.valueOf(bi.nw202.getText().toString()), getString(R.string.nw206), " years")) {
                    return false;
                }

                if (!validatorClass.EmptyRadioButton(this, bi.nw207, bi.nw207a, getString(R.string.nw207))) {
                    return false;
                }

                if (bi.nw207a.isChecked()) {

                    if (!validatorClass.EmptyRadioButton(this, bi.nw208, bi.nw208a, getString(R.string.nw208))) {
                        return false;
                    }

                    if (bi.nw208a.isChecked()) {

                        if (!validatorClass.EmptyRadioButton(this, bi.nw209, bi.nw209a, getString(R.string.nw210))) {
                            return false;
                        }

                        if (bi.nw209a.isChecked()) {

                            if (!bi.nw21098a.isChecked() && !bi.nw21099a.isChecked() && !bi.nw21003a.isChecked()) {
                                if (!validatorClass.EmptyRadioButton(this, bi.nw21001, bi.nw21001a, getString(R.string.nw21001))) {
                                    return false;
                                }

                                if (!validatorClass.EmptyRadioButton(this, bi.nw21002, bi.nw21002a, getString(R.string.nw21002))) {
                                    return false;
                                }

                            }
                        }

                    }


                    if (!validatorClass.EmptyTextBox(this, bi.nw211, getString(R.string.nw211))) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, bi.nw212, getString(R.string.nw212))) {
                        return false;
                    }
                    if (!validatorClass.RangeTextBox(this, bi.nw212, 0, Integer.valueOf(bi.nw211.getText().toString()), getString(R.string.nw212), " Deliveries")) {
                        return false;
                    }

                    if (!bi.nw212.getText().toString().equals("0")) {
                        if (!validatorClass.EmptyTextBox(this, bi.nw213, getString(R.string.nw213))) {
                            return false;
                        }

                        if (!validatorClass.EmptyTextBox(this, bi.nw213, getString(R.string.nw213))) {
                            return false;
                        }

                        if (!validatorClass.RangeTextBox(this, bi.nw213, Integer.valueOf(bi.nw206.getText().toString()), Integer.valueOf(bi.nw202.getText().toString()), getString(R.string.nw213), " years")) {
                            return false;
                        }


                        if (!validatorClass.EmptyTextBox(this, bi.nw214, getString(R.string.nw214))) {
                            return false;
                        }

                        if (!validatorClass.RangeTextBox(this, bi.nw214, 0, Integer.valueOf(bi.nw211.getText().toString()), getString(R.string.nw211), " Deliveries")) {
                            return false;
                        }

                        if (!validatorClass.EmptyTextBox(this, bi.nw215, getString(R.string.nw215))) {
                            return false;
                        }
                        if (!validatorClass.RangeTextBox(this, bi.nw215, 0, Integer.valueOf(bi.nw212.getText().toString()), getString(R.string.nw212), " Deliveries")) {
                            return false;
                        }

                        if (!validatorClass.EmptyRadioButton(this, bi.nw216, bi.nw216a, getString(R.string.nw216))) {
                            return false;
                        }

                        if (bi.nw216a.isChecked()) {
                            return validatorClass.EmptyTextBox(this, bi.nw216aa, getString(R.string.nw216a));
                        }
                    }

                }


                //}


            }

        }
        return true;
    }

    private void SaveDraft() throws JSONException {

        JSONObject sB1 = new JSONObject();

        if (!backPressed) {
            MainApp.mc = new MWRAContract();
            MainApp.mc.setDevicetagID(MainApp.getTagName(this));
            MainApp.mc.setFormDate(MainApp.fc.getFormDate());
            MainApp.mc.setUser(MainApp.userName);
            MainApp.mc.setDeviceId(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                    Settings.Secure.ANDROID_ID));
            MainApp.mc.setApp_ver(MainApp.versionName + "." + MainApp.versionCode);
            MainApp.mc.setB1SerialNo(wraMap.get(bi.nb101.getSelectedItem().toString()).getSerialNo());
            MainApp.mc.set_UUID(MainApp.fc.getUID());
        } else {
            sB1.put("updatedate_nw1", new SimpleDateFormat("dd-MM-yyyy HH:mm").format(System.currentTimeMillis()));
            MainApp.mc.set_UID(MainApp.mc.get_UID());
        }

        wraName = bi.nb101.getSelectedItem().toString();

        sB1.put("enmno", MainApp.fc.getClusterNo());
        sB1.put("hhno", MainApp.fc.getHhNo());
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
        sB1.put("nw208", bi.nw208a.isChecked() ? "1" : bi.nw208b.isChecked() ? "2" : "0");

        sB1.put("nw209", bi.nw209a.isChecked() ? "1" : bi.nw209b.isChecked() ? "2" : "0");

        //        nw21001
        sB1.put("nw21001", bi.nw21001a.isChecked() ? "1" : "2");
        //        nw21002
        sB1.put("nw21002", bi.nw21002a.isChecked() ? "1" : "2");
        //        nw21003
        sB1.put("nw21003", bi.nw21003a.isChecked() ? "1" : "2");
        //        nw21098
        sB1.put("nw21098", bi.nw21098a.isChecked() ? "1" : "2");
        //        nw21099
        sB1.put("nw21099", bi.nw21099a.isChecked() ? "1" : "2");

        sB1.put("nw211", bi.nw211.getText().toString());
        sB1.put("nw212", bi.nw212.getText().toString());
        sB1.put("nw213", bi.nw213.getText().toString());
        sB1.put("nw214", bi.nw214.getText().toString());
        sB1.put("nw215", bi.nw215.getText().toString());
        sB1.put("nw216", bi.nw216a.isChecked() ? "1" : bi.nw216b.isChecked() ? "2" : "0");
        sB1.put("nw216aa", bi.nw216aa.getText().toString());

        if (bi.nw216a.isChecked() && !bi.nw216aa.getText().toString().isEmpty()) {
            MainApp.totalPregnancy = Integer.valueOf(bi.nw216aa.getText().toString());
        }


        MainApp.mc.setsB1(String.valueOf(sB1));

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        if (!backPressed) {
            Long updcount = db.addMWRA(MainApp.mc, 0);
            MainApp.mc.set_ID(String.valueOf(updcount));

            if (updcount != 0) {
                MainApp.mc.set_UID(
                        (MainApp.mc.getDeviceId() + MainApp.mc.get_ID()));
                db.updateMWRAID();

                return true;
            } else {
                Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            Long updcount = db.addMWRA(MainApp.mc, 1);

            return true;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (frontPressed) {
            backPressed = true;
        }

        if (backPressed) {
            bi.nb101.setEnabled(false);
            bi.btnAddMember.setVisibility(View.GONE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                classPassName = data.getStringExtra("backPressedClass");
            } else {
                classPassName = "";
            }
        }
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

                                WRAsize = MainApp.mwra.size();

                                finish();
                                startActivity(new Intent(SectionB1Activity.this, SectionA2ListActivity.class)
                                        .putExtra("reBack", true)
                                        .putExtra("reBackChild", true));
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

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        timer.cancel();
        timer = new Timer();
        timer.schedule(
                new TimerTask() {
                    @Override
                    public void run() {

                        SectionB1Activity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                ValidateForm();
                            }
                            //}
                        });

                    }
                },
                DELAY
        );

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        ValidateForm();
    }
}
