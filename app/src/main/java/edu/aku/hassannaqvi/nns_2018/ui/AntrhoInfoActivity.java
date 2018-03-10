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
    JSONModelClass json;
    ActivityAntrhoInfoBinding binding;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    DatabaseHelper db;
    Collection<FamilyMembersContract> members;

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
        binding.na102.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.na103.setText(null);
                binding.fldGrpna101.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


//        FamilyMembersList initialization


//        HH listener
        binding.na103.addTextChangedListener(new TextWatcher() {
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

                startActivity(new Intent(this, SectionA3Activity.class));


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

//        na101
        if (!validatorClass.EmptyTextBox(this, binding.na101, getString(R.string.na101))) {
            return false;
        }

//        na102
        if (!validatorClass.EmptyTextBox(this, binding.na102, getString(R.string.na102))) {
            return false;
        }

//        na103

        if (binding.na103.getText().toString().length() == 6) {
            String[] str = binding.na103.getText().toString().split("-");
            if (str.length > 2 || binding.na103.getText().toString().charAt(4) != '-' || !str[0].matches("[0-9]+") || !str[1].matches("[a-zA-Z]")) {
                binding.na103.setError("Wrong presentation!!");
                return false;
            }
        } else {
            Toast.makeText(this, "Invalid length: " + getString(R.string.na103), Toast.LENGTH_SHORT).show();
            binding.na103.setError("Invalid length");
            return false;
        }


        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        enm_no = binding.na102.getText().toString();
        hh_no = binding.na103.getText().toString().toUpperCase();

    }


    private boolean UpdateDB() {

        return true;
    }

    public void BtnCheckHH() {

        if (!binding.na102.getText().toString().trim().isEmpty() && !binding.na103.getText().toString().trim().isEmpty()) {

            members = db.getAllMembersByHH(binding.na102.getText().toString(), binding.na103.getText().toString().toUpperCase());

            if (members.size() != 0) {
                for (FamilyMembersContract fm : members) {

                    json = JSONUtilClass.getModelFromJSON(fm.getsA2());
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

                if (MainApp.all_members.size() > 0) {
                    binding.btnContinue.setVisibility(View.VISIBLE);
                    binding.btnEnd.setVisibility(View.GONE);

                } else {

                    binding.btnContinue.setVisibility(View.GONE);
                    binding.btnEnd.setVisibility(View.GONE);
                    Toast.makeText(this, "No Eligible member found for anthropometry, Check another HH.", Toast.LENGTH_SHORT).show();
                }


            } else {


                Toast.makeText(this, "No members found for the HH.", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Not found.", Toast.LENGTH_SHORT).show();
        }

    }

    public void BtnCheckEnm() {

        if (validatorClass.EmptyTextBox(this, binding.na102, getString(R.string.na102))) {

            String selected = db.getEnumBlock(binding.na102.getText().toString());
            if (!selected.equals("")) {

                String[] selSplit = selected.split("\\|");

                binding.na101a.setText(selSplit[0]);
                binding.na101b.setText(selSplit[1].equals("") ? "----" : selSplit[1]);
                binding.na101c.setText(selSplit[2].equals("") ? "----" : selSplit[2]);
                binding.na101d.setText(selSplit[3]);

                binding.fldGrpna101.setVisibility(View.VISIBLE);

            } else {
                binding.na103.setText(null);
                Toast.makeText(this, "Sorry not found any block", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
