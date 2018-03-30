package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

import edu.aku.hassannaqvi.nns_2018.Adapters.ChildAdapter;
import edu.aku.hassannaqvi.nns_2018.Adapters.WraAdapter;
import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.BLRandomContract;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivityViewMemberBinding;
import edu.aku.hassannaqvi.nns_2018.other.JSONModelClass;
import edu.aku.hassannaqvi.nns_2018.other.JSONUtilClass;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;


public class ViewMemberActivity extends AppCompatActivity {

    WraAdapter wraAdapter;
    ChildAdapter childAdapter;


    ActivityViewMemberBinding binding;
    Collection<BLRandomContract> selected;
    DatabaseHelper db;
    JSONModelClass json;
    Collection<FamilyMembersContract> members;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_member);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_member);
        db = new DatabaseHelper(this);
        binding.setCallback(this);

    }

    private void initializingLists() {

        MainApp.all_members = new ArrayList<>();
        MainApp.childUnder5 = new ArrayList<>();
        MainApp.mwra = new ArrayList<>();
        members = new ArrayList<>();
        json = new JSONModelClass();

    }

 /*   private void notifywrachange(WraAdapter wraAdapter) {
        wraAdapter.notifyDataSetChanged();
    }

    private void notifychildchange(ChildAdapter childAdapter) {
        childAdapter.notifyDataSetChanged();
    }*/

    public void clearFields() {
        binding.fldGrpviewlist.setVisibility(View.GONE);
        //clear all lists
    }

    public void BtnCheckHH() {

        if (!binding.chckenumblock.getText().toString().trim().isEmpty() && !binding.chckhouse.getText().toString().trim().isEmpty()) {

            String uid = db.getUIDByHH(binding.chckenumblock.getText().toString(), binding.chckhouse.getText().toString().toUpperCase());
            if (uid != null) {

                initializingLists();

                members = db.getAllMembersByHH(uid);

                if (members.size() != 0) {
                    for (FamilyMembersContract fm : members) {

                        if (fm.getsA2() != null) {
                            json = JSONUtilClass.getModelFromJSON(fm.getsA2(), JSONModelClass.class);
                            if ((Integer.valueOf(json.getAge()) >= 15 && Integer.valueOf(json.getAge()) <= 49) && json.getGender().equals("2")) {
                                //  Log.d("Test",fm.getName());
                                MainApp.mwra.add(fm);
                                MainApp.all_members.add(fm);

                            }
                           /* if ((Integer.valueOf(json.getAge()) >= 10 && (Integer.valueOf(json.getAge()) <= 19)) && json.getMaritalStatus().equals("5")) {
                                MainApp.adolescents.add(fm);
                                MainApp.all_members.add(fm);
                            }*/
                            if (Integer.valueOf(json.getAge()) < 5) {
                                // Log.d("Test",fm.getName());
                                MainApp.childUnder5.add(fm);
                                MainApp.all_members.add(fm);

                            }
                        }

                    }

                    if (MainApp.all_members.size() > 0) {
                        Toast.makeText(this, "Members Found..", Toast.LENGTH_SHORT).show();
                        binding.btnContinue.setVisibility(View.VISIBLE);
                        binding.btnEnd.setVisibility(View.GONE);
                        binding.fldGrpviewlist.setVisibility(View.VISIBLE);
                        viewWraList();
                        viewChildList();

                    } else {
                        binding.fldGrpviewlist.setVisibility(View.GONE);
                        binding.btnContinue.setVisibility(View.GONE);
                        binding.btnEnd.setVisibility(View.GONE);
                        Toast.makeText(this, "No members found, Check another HH.", Toast.LENGTH_SHORT).show();
                    }

                }
            } else {
                binding.fldGrpviewlist.setVisibility(View.GONE);
                Toast.makeText(this, "No members found for the HH.", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Not found.", Toast.LENGTH_SHORT).show();
        }

    }

    private void viewChildList() {

        new populateChildRecyclerView(this).execute();
    }

    private void viewWraList() {

        new populateWraRecyclerView(this).execute();


    }

    public void BtnCheckEnm() {

        if (validatorClass.EmptyTextBox(this, binding.chckenumblock, getString(R.string.nh102))) {

            String selected = db.getEnumBlock(binding.chckenumblock.getText().toString());
            if (!selected.equals("")) {

                String[] selSplit = selected.split("\\|");
                binding.nsuba.setText(selSplit[0]);
                binding.nzilla.setText(selSplit[1].equals("") ? "----" : selSplit[1]);
                binding.ntehsil.setText(selSplit[2].equals("") ? "----" : selSplit[2]);
                binding.ncity.setText(selSplit[3]);

                binding.fldGrphidden.setVisibility(View.VISIBLE);

            } else {
                binding.chckhouse.setText(null);
                Toast.makeText(this, "Sorry not found any block", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void BtnContinue() {

/*        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
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
        }*/
    }

    public void BtnEnd() {
/*
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
        }*/
    }

    public class populateWraRecyclerView extends AsyncTask<String, String, String> {
        private Context mContext;

        public populateWraRecyclerView(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        protected String doInBackground(String... strings) {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {

//              Set Recycler View
                    wraAdapter = new WraAdapter(MainApp.mwra);
                    if (wraAdapter.getItemCount() != 0) {
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        binding.recyclerMwra.setLayoutManager(mLayoutManager);
                        binding.recyclerMwra.setItemAnimator(new DefaultItemAnimator());
                        binding.recyclerMwra.setAdapter(wraAdapter);
                        wraAdapter.notifyDataSetChanged();

                    }
                }
            });


            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    wraAdapter.notifyDataSetChanged();
//
                }
            }, 800);
        }
    }

    public class populateChildRecyclerView extends AsyncTask<String, String, String> {
        private Context mContext;

        public populateChildRecyclerView(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        protected String doInBackground(String... strings) {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {

//              Set Recycler View
                    childAdapter = new ChildAdapter(MainApp.childUnder5);


                    if (childAdapter.getItemCount() != 0) {

                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        binding.recyclerChild.setLayoutManager(mLayoutManager);
                        binding.recyclerChild.setItemAnimator(new DefaultItemAnimator());
                        binding.recyclerChild.setAdapter(childAdapter);
                        childAdapter.notifyDataSetChanged();
                        // notifychildchange(childAdapter);
                    }
                }
            });

            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // notifychildchange(childAdapter);
//                   Background black for those that's data filled
                  /*  for (int item : MainApp.hhClicked) {
                        binding.recyclerChild.getChildAt(item).setBackgroundColor(Color.BLACK);
                    }*/
                }
            }, 800);
        }
    }


}
