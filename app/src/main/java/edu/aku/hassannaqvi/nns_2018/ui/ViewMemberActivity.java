package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Context;
import android.content.Intent;
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

import edu.aku.hassannaqvi.nns_2018.Adapters.AdolescentsAdapter;
import edu.aku.hassannaqvi.nns_2018.Adapters.ChildAdapter;
import edu.aku.hassannaqvi.nns_2018.Adapters.OthersAdapter;
import edu.aku.hassannaqvi.nns_2018.Adapters.WraAdapter;
import edu.aku.hassannaqvi.nns_2018.JSONModels.JSONModelClass;
import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.BLRandomContract;
import edu.aku.hassannaqvi.nns_2018.contracts.EnumBlockContract;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivityViewMemberBinding;
import edu.aku.hassannaqvi.nns_2018.other.JSONUtilClass;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;


public class ViewMemberActivity extends AppCompatActivity {

    WraAdapter wraAdapter;
    ChildAdapter childAdapter;
    AdolescentsAdapter adolescentsAdapter;
    OthersAdapter othersAdapter;


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

        if (getIntent().getBooleanExtra("flagEdit", true)) {

            binding.fldGrpEditHH.setVisibility(View.GONE);
            binding.fldGrpVisA.setVisibility(View.GONE);
            binding.fldGrpVisB.setVisibility(View.GONE);

            binding.chckenumblock.setText(MainApp.fc.getClusterNo());
            binding.chckhouse.setText(MainApp.fc.getHhNo());

            initializingLists();

            BtnCheckEnm();
            BtnCheckHH();

        } else {
            binding.fldGrpEditHH.setVisibility(View.VISIBLE);
            binding.fldGrpVisA.setVisibility(View.VISIBLE);
            binding.fldGrpVisB.setVisibility(View.VISIBLE);

            initializingLists();
        }

    }

    private void initializingLists() {

        MainApp.all_members_1 = new ArrayList<>();
        MainApp.otherMembers_1 = new ArrayList<>();
        MainApp.childUnder5_1 = new ArrayList<>();
        MainApp.adolescents_1 = new ArrayList<>();
        MainApp.mwra_1 = new ArrayList<>();
        members = new ArrayList<>();
        json = new JSONModelClass();

    }

    public void clearFields() {
        binding.fldGrpviewlist.setVisibility(View.GONE);
        //clear all lists
    }

    public void BtnCheckHH() {

        if (!binding.chckenumblock.getText().toString().trim().isEmpty() && !binding.chckhouse.getText().toString().trim().isEmpty()) {

            String uid = db.getUIDByHH(binding.chckenumblock.getText().toString(), binding.chckhouse.getText().toString().toUpperCase(), "");
            if (uid != null) {

                members = db.getAllMembersByHH(uid);

                if (members.size() != 0) {
                    for (FamilyMembersContract fm : members) {

                        if (fm.getsA2() != null) {
                            json = JSONUtilClass.getModelFromJSON(fm.getsA2(), JSONModelClass.class);
                            if ((Integer.valueOf(json.getAge()) >= 15 && Integer.valueOf(json.getAge()) <= 49) && json.getGender().equals("2")) {
                                MainApp.mwra_1.add(fm);
                                MainApp.all_members_1.add(fm);
                            }
                            if ((Integer.valueOf(json.getAge()) >= 10 && (Integer.valueOf(json.getAge()) <= 19)) && json.getMaritalStatus().equals("5")) {
                                MainApp.adolescents_1.add(fm);
                                MainApp.all_members_1.add(fm);
                            } else if (Integer.valueOf(json.getAge()) < 5) {
                                MainApp.childUnder5_1.add(fm);
                                MainApp.all_members_1.add(fm);
                            } else if (!((Integer.valueOf(json.getAge()) >= 15 && Integer.valueOf(json.getAge()) <= 49) && json.getGender().equals("2"))) {
                                MainApp.otherMembers_1.add(fm);
                                MainApp.all_members_1.add(fm);
                            }

                        }

                    }

                    if (MainApp.all_members_1.size() > 0) {
                        Toast.makeText(this, "Members Found..", Toast.LENGTH_SHORT).show();
                        binding.btnContinue.setVisibility(View.VISIBLE);
                        binding.btnEnd.setVisibility(View.GONE);
                        binding.fldGrpviewlist.setVisibility(View.VISIBLE);
                        viewWraList();
                        viewChildList();
                        viewAdolList();
                        viewOthList();

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

    private void viewAdolList() {
        new populateAdolRecyclerView(this).execute();
    }

    private void viewOthList() {
        new populateOtherRecyclerView(this).execute();
    }

    public void BtnCheckEnm() {

        if (validatorClass.EmptyTextBox(this, binding.chckenumblock, getString(R.string.nh102))) {

            EnumBlockContract enumBlockContract = db.getEnumBlock(binding.chckenumblock.getText().toString());
            String selected = enumBlockContract.getGeoarea();
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

        Intent GetIntent = null;
        switch (getIntent().getIntExtra("activity", 0)) {
            case 1:
                if (MainApp.mwra.size() > 0) {
                    GetIntent = new Intent(this, SectionB1Activity.class);
                } else if (MainApp.childUnder5.size() > 0) {
                    if (MainApp.childUnder5.size() == MainApp.childNA.size()) {
                        SectionC1Activity.isNA = true;
                        GetIntent = new Intent(this, SectionC1Activity.class);
                    } else {
                        SectionC1Activity.isNA = false;
                        GetIntent = new Intent(this, SectionC1Activity.class);
                    }
                } else {
                    GetIntent = new Intent(this, EndingActivity.class).putExtra("complete", true);
                }
                break;

            case 2:
                if (MainApp.mwra.size() > 0) {
                    GetIntent = new Intent(this, SectionB1Activity.class);
                } else if (MainApp.childUnder5.size() > 0) {
                    if (MainApp.childUnder5.size() == MainApp.childNA.size()) {
                        SectionC1Activity.isNA = true;
                        GetIntent = new Intent(this, SectionC1Activity.class);
                    } else {
                        SectionC1Activity.isNA = false;
                        GetIntent = new Intent(this, SectionC1Activity.class);
                    }
                }
                break;

            case 3:
                if (MainApp.mwra.size() > 0) {
                    GetIntent = new Intent(this, SectionB1Activity.class);
                } else if (MainApp.childUnder5.size() > 0) {
                    if (MainApp.childUnder5.size() == MainApp.childNA.size()) {
                        SectionC1Activity.isNA = true;
                        GetIntent = new Intent(this, SectionC1Activity.class);
                    } else {
                        SectionC1Activity.isNA = false;
                        GetIntent = new Intent(this, SectionC1Activity.class);
                    }
                } else {
                    GetIntent = new Intent(this, EndingActivity.class).putExtra("complete", true);
                }
                break;

            case 4:
                if (!(SectionC1Activity.counterPerMom <= 0)) {

                    if (SectionC1Activity.counter == SectionC1Activity.counterPerMom) {

                        if (SectionB1Activity.WRAcounter == MainApp.mwra.size()
                                ||
                                SectionB1Activity.lstMwra.size() == 1) {
                            SectionB1Activity.WRAcounter++;
                            SectionB1Activity.lstMwra.remove(SectionB1Activity.wraName);

                            SectionC1Activity.isNA = false;
//                            SectionC1Activity.childU5.remove(SectionC1Activity.selectedChildName);
                            SectionC1Activity.counter = 1;
                            SectionC1Activity.counterPerMom = 0;
                            SectionC1Activity.counterPerNA = 0;

                            GetIntent = new Intent(this, EndingActivity.class).putExtra("complete", true);
                        } else {

                            SectionC1Activity.isNA = false;
//                            SectionC1Activity.childU5.remove(SectionC1Activity.selectedChildName);

                            GetIntent = new Intent(this, SectionB1Activity.class)
                                    .putExtra("mwraFlag", true)
                                    .putExtra("wraName", SectionB1Activity.wraName);
                        }

                    } else {
                        GetIntent = new Intent(this, SectionC1Activity.class)
                                .putExtra("childFlag", true)
                                .putExtra("name", SectionC1Activity.selectedChildName);
                    }
                } else {

                    if (SectionC1Activity.counter == SectionC1Activity.counterPerNA) {

                        SectionC1Activity.isNA = false;
//                        SectionC1Activity.childU5.remove(SectionC1Activity.selectedChildName);
                        SectionC1Activity.counter = 1;
                        SectionC1Activity.counterPerMom = 0;
                        SectionC1Activity.counterPerNA = 0;

                        GetIntent = new Intent(this, EndingActivity.class).
                                putExtra("complete", true);

                    } else {

                        GetIntent = new Intent(this, SectionC1Activity.class)
                                .putExtra("childFlag", true)
                                .putExtra("name", SectionC1Activity.selectedChildName);
                    }
                }
                break;

            case 5:
                if (MainApp.childUnder5.size() > 0) {
                    int childcount = 0;
                    for (FamilyMembersContract fmc : MainApp.childUnder5) {
                        if (fmc.getMotherId().equals(MainApp.mc.getB1SerialNo())) {
                            childcount++;
                        }
                    }
                    if (childcount > 0) {
                        GetIntent = new Intent(this, SectionC1Activity.class);
                    } else if (MainApp.childNA.size() > 0) {
                        SectionC1Activity.isNA = true;
                        GetIntent = new Intent(this, SectionC1Activity.class);
                    } else if (SectionB1Activity.WRAcounter == MainApp.mwra.size()) {
                        SectionB1Activity.WRAcounter++;
                        SectionB1Activity.lstMwra.remove(SectionB1Activity.wraName);
                        GetIntent = new Intent(this, EndingActivity.class).putExtra("complete", true);
                    } else {
                        GetIntent = new Intent(this, SectionB1Activity.class)
                                .putExtra("mwraFlag", true)
                                .putExtra("wraName", SectionB1Activity.wraName);
                    }
                } else if (SectionB1Activity.WRAcounter == MainApp.mwra.size()) {
                    SectionB1Activity.WRAcounter++;
                    SectionB1Activity.lstMwra.remove(SectionB1Activity.wraName);
                    GetIntent = new Intent(this, EndingActivity.class).putExtra("complete", true);
                } else {
                    GetIntent = new Intent(this, SectionB1Activity.class)
                            .putExtra("mwraFlag", true)
                            .putExtra("wraName", SectionB1Activity.wraName);
                }
                break;
            case 6:
                if (SectionA1Activity.reBackChildFlag) {
                    if (MainApp.mwra.size() > 0 && SectionB1Activity.WRAsize != MainApp.mwra.size()) {
                        GetIntent = new Intent(this, SectionB1Activity.class)
                                .putExtra("reBackComing", false);
                    } else if (MainApp.childUnder5.size() > 0 &&
                            (SectionC1Activity.NAChildsize != MainApp.childNA.size() ||
                                    SectionC1Activity.Childsize != (MainApp.childUnder5.size() - MainApp.childNA.size()))) {
                        if (MainApp.childNA.size() > SectionC1Activity.NAChildsize) {
                            SectionC1Activity.isNA = true;
                            GetIntent = new Intent(this, SectionC1Activity.class)
                                    .putExtra("reBackComing", false);
                        } else {
                            SectionC1Activity.isNA = false;
                            GetIntent = new Intent(this, SectionC1Activity.class)
                                    .putExtra("reBackComing", false);
                        }
                    } else {
                        GetIntent = new Intent(this, EndingActivity.class).putExtra("complete", true);
                    }
                } else {
                    SectionC1Activity.isNA = false;
                    GetIntent = new Intent(this, SectionC1Activity.class)
                            .putExtra("reBackComing", false);
                }
                break;
            default:
                GetIntent = new Intent(this, EndingActivity.class).putExtra("complete", true);
                break;
        }

        finish();
        startActivity(GetIntent);

    }

    public void BtnEnd() {
    }

    public void BtnEditHH() {
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
                    wraAdapter = new WraAdapter(MainApp.mwra_1);
                    if (wraAdapter.getItemCount() > 0) {
                        binding.nowrafound.setVisibility(View.VISIBLE);
                        binding.nowrafound.setText("WRA's found!!");
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        binding.recyclerMwra.setLayoutManager(mLayoutManager);
                        binding.recyclerMwra.setItemAnimator(new DefaultItemAnimator());
                        binding.recyclerMwra.setAdapter(wraAdapter);
                        wraAdapter.notifyDataSetChanged();
                    } else {
                        binding.nowrafound.setVisibility(View.VISIBLE);
                        binding.nowrafound.setText("NO WRA's found!!");
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

    public class populateAdolRecyclerView extends AsyncTask<String, String, String> {
        private Context mContext;

        public populateAdolRecyclerView(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        protected String doInBackground(String... strings) {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {

//              Set Recycler View
                    adolescentsAdapter = new AdolescentsAdapter(MainApp.adolescents_1);
                    if (adolescentsAdapter.getItemCount() > 0) {
                        binding.noadolfound.setVisibility(View.VISIBLE);
                        binding.noadolfound.setText("Adolescent found!!");
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        binding.recyclerAdol.setLayoutManager(mLayoutManager);
                        binding.recyclerAdol.setItemAnimator(new DefaultItemAnimator());
                        binding.recyclerAdol.setAdapter(adolescentsAdapter);
                        adolescentsAdapter.notifyDataSetChanged();
                    } else {
                        binding.noadolfound.setVisibility(View.VISIBLE);
                        binding.noadolfound.setText("No Adolescent found!!");
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
                        binding.recyclerAdol.getChildAt(item).setBackgroundColor(Color.BLACK);
                    }*/
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
                    childAdapter = new ChildAdapter(MainApp.childUnder5_1);


                    if (childAdapter.getItemCount() > 0) {
                        binding.nochildfound.setVisibility(View.VISIBLE);
                        binding.nochildfound.setText("Children's found!!");
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        binding.recyclerChild.setLayoutManager(mLayoutManager);
                        binding.recyclerChild.setItemAnimator(new DefaultItemAnimator());
                        binding.recyclerChild.setAdapter(childAdapter);
                        childAdapter.notifyDataSetChanged();

                    } else {
                        binding.nochildfound.setVisibility(View.VISIBLE);
                        binding.nochildfound.setText("No Children found!!");
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

    public class populateOtherRecyclerView extends AsyncTask<String, String, String> {
        private Context mContext;

        public populateOtherRecyclerView(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        protected String doInBackground(String... strings) {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {

//              Set Recycler View
                    othersAdapter = new OthersAdapter(MainApp.otherMembers_1);

                    if (othersAdapter.getItemCount() > 0) {
                        binding.othersfound.setVisibility(View.VISIBLE);
                        binding.othersfound.setText("Other Members found!!");
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        binding.recyclerOthers.setLayoutManager(mLayoutManager);
                        binding.recyclerOthers.setItemAnimator(new DefaultItemAnimator());
                        binding.recyclerOthers.setAdapter(othersAdapter);
                        othersAdapter.notifyDataSetChanged();

                    } else {
                        binding.othersfound.setVisibility(View.VISIBLE);
                        binding.othersfound.setText("No Other Members found!!");
                    }
                }
            });

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
        }
    }

}
