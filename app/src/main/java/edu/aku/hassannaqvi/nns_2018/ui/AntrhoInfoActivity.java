package edu.aku.hassannaqvi.nns_2018.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Timer;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivityAntrhoInfoBinding;
import edu.aku.hassannaqvi.nns_2018.other.JSONModelClass;
import edu.aku.hassannaqvi.nns_2018.other.JSONUtilClass;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;


public class AntrhoInfoActivity extends Activity {

    private static final String TAG = SectionA1Activity.class.getName();
    static String enm_no;
    static String hh_no;
    private final long DELAY = 1000;
    JSONModelClass json;
    ActivityAntrhoInfoBinding binding;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    DatabaseHelper db;
    Collection<FamilyMembersContract> members;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_antrho_info);
        db = new DatabaseHelper(this);
        binding.setCallback(this);

        SetupViewFunctionality();

    }

    public void SetupViewFunctionality() {

        MainApp.all_members = new ArrayList<>();
        MainApp.childUnder2 = new ArrayList<>();
        MainApp.childUnder5 = new ArrayList<>();
        MainApp.childUnder5 = new ArrayList<>();
        MainApp.childNA = new ArrayList<>();
        MainApp.mwra = new ArrayList<>();
        MainApp.adolescents = new ArrayList<>();
        members = new ArrayList<>();
        json = new JSONModelClass();


        //slcMem = new ArrayList<>();
        binding.nh102.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.nh108.setText(null);
                binding.fldGrpnh101.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


//        FamilyMembersList initialization


//        HH listener
        binding.nh108.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                //clearFields();
            }

            @Override
            public void afterTextChanged(Editable editable) {

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
                //Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();
                finish();

                startActivity(new Intent(this, SectionD1Activity.class));


            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {

        Toast.makeText(this, "Processing End Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean formValidation() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//        nh102
        if (!validatorClass.EmptyTextBox(this, binding.nh102, getString(R.string.nh102))) {
            return false;
        }

//        nh108

        if (binding.nh108.getText().toString().length() == 6) {
            String[] str = binding.nh108.getText().toString().split("-");
            if (str.length > 2 || binding.nh108.getText().toString().charAt(4) != '-' || !str[0].matches("[0-9]+") || !str[1].matches("[a-zA-Z]")) {
                binding.nh108.setError("Wrong presentation!!");
                return false;
            }
        } else {
            Toast.makeText(this, "Invalid length: " + getString(R.string.nh108), Toast.LENGTH_SHORT).show();
            binding.nh108.setError("Invalid length");
            return false;
        }


        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        enm_no = binding.nh102.getText().toString();
        hh_no = binding.nh108.getText().toString().toUpperCase();

    }


    private boolean UpdateDB() {

        return true;
    }

    public void BtnCheckHH() {

        if (!binding.nh102.getText().toString().trim().isEmpty() && !binding.nh108.getText().toString().trim().isEmpty()) {

            String uid = db.getUIDByHH(binding.nh102.getText().toString(), binding.nh108.getText().toString().toUpperCase());
            if (uid != null) {
                members = db.getAllMembersByHH(uid);

                if (members.size() != 0) {
                    for (FamilyMembersContract fm : members) {

                        if (fm.getsA2() != null) {
                            json = JSONUtilClass.getModelFromJSON(fm.getsA2(), JSONModelClass.class);
                            if ((Integer.valueOf(json.getAge()) >= 15 && Integer.valueOf(json.getAge()) <= 49) && json.getGender().equals("2")) {
                                MainApp.mwra.add(fm);
                                MainApp.all_members.add(fm);
                            }
                            if ((Integer.valueOf(json.getAge()) >= 10 && (Integer.valueOf(json.getAge()) <= 19)) && json.getMaritalStatus().equals("5")) {
                                MainApp.adolescents.add(fm);
                                MainApp.all_members.add(fm);
                            }
                            if (Integer.valueOf(json.getAge()) < 5) {
                                MainApp.childUnder5.add(fm);
                                MainApp.all_members.add(fm);
                            }
                        }

                    }
                    if (MainApp.all_members.size() > 0) {
                        Toast.makeText(this, "Members Found..", Toast.LENGTH_SHORT).show();
                        binding.btnContinue.setVisibility(View.VISIBLE);
                        binding.btnEnd.setVisibility(View.GONE);

                    } else {

                        binding.btnContinue.setVisibility(View.GONE);
                        binding.btnEnd.setVisibility(View.GONE);
                        Toast.makeText(this, "No Eligible member found for anthropometry, Check another HH.", Toast.LENGTH_SHORT).show();
                    }


                }
            } else {
                Toast.makeText(this, "No members found for the HH.", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Not found.", Toast.LENGTH_SHORT).show();
        }

    }

    public void BtnCheckEnm() {

        if (validatorClass.EmptyTextBox(this, binding.nh102, getString(R.string.nh102))) {

            String selected = db.getEnumBlock(binding.nh102.getText().toString());
            if (!selected.equals("")) {

                String[] selSplit = selected.split("\\|");

                binding.nh103.setText(selSplit[0]);
                binding.nh104.setText(selSplit[1].equals("") ? "----" : selSplit[1]);
                binding.nh105.setText(selSplit[2].equals("") ? "----" : selSplit[2]);
                binding.nh106.setText(selSplit[3]);

                binding.fldGrpnh101.setVisibility(View.VISIBLE);

            } else {
                binding.nh108.setText(null);
                Toast.makeText(this, "Sorry not found any block", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
