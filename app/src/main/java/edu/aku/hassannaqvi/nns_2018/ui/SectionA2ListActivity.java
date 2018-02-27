package edu.aku.hassannaqvi.nns_2018.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionListA2Binding;
import edu.aku.hassannaqvi.nns_2018.databinding.FamilymemberslistBinding;


public class SectionA2ListActivity extends AppCompatActivity {

    static String respLineNo = "";
    ActivitySectionListA2Binding binding;
    Map<Integer, Map<Integer, Integer>> mem;
    /*Variables*/
    DatabaseHelper db;
    FamilyMembersAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_list_a2);
        binding.setCallback(this);

        setupViews();
    }


    public void setupViews() {

//        Setting Counts
        mem = MainApp.membersCount.getMembers();

        // Total
        binding.na2tm.setText(mem.get(1).get(1).toString());
        binding.na2tf.setText(mem.get(1).get(2).toString());
        // Adolescents
        binding.na2adm.setText(mem.get(2).get(1).toString());
        binding.na2adf.setText(mem.get(2).get(2).toString());
        // Children < 5
        binding.na2u5b.setText(mem.get(3).get(1).toString());
        binding.na2u5g.setText(mem.get(3).get(2).toString());
        //  Mwra
        binding.na2mw.setText(String.valueOf(MainApp.membersCount.getMwra()));

//        Populate RecyclerView
        new populateRecyclerView(this).execute();

        //        Recycler click listener
        binding.recyclerNoMembers.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, final int position) {
                        // TODO Handle item click

                        if (position != -1) {
                            boolean flag = true;
                            for (int hh : MainApp.hhClicked) {
                                if (hh == position) {
                                    flag = false;
                                    break;
                                }
                            }

                            if (flag) {
                                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                                        SectionA2ListActivity.this);
                                alertDialogBuilder
                                        .setMessage("Are you sure to update this member?")
                                        .setCancelable(false)
                                        .setPositiveButton("Ok",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {

                                                        MainApp.hhClicked.add(position);
                                                        for (int item : MainApp.hhClicked) {
                                                            binding.recyclerNoMembers.getChildAt(item).setBackgroundColor(Color.BLACK);
                                                        }

                                                        startActivity(new Intent(getApplicationContext(), SectionA2Activity.class)
                                                                .putExtra("data", MainApp.familyMembersList.get(position))
                                                                .putExtra("pos", position));

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
                    }
                })
        );

//        Checking Button continue
        if (MainApp.hhClicked.size() == 0 || MainApp.hhClicked.size() != MainApp.familyMembersList.size()) {
            binding.btnContinue.setVisibility(View.GONE);
        } else {
            binding.btnContinue.setVisibility(View.VISIBLE);
        }

//        Getting resp Line no
        if (getIntent().getBooleanExtra("respChecking", false)) {
            respLineNo = getIntent().getStringExtra("respLineNo");
        }

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

                respLineNo = "";
                startActivity(new Intent(this, SectionA4Activity.class));
//                startActivity(new Intent(this, SectionB1Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnAddMore() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(this, SectionA2Activity.class).putExtra("flag", true));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }

    private Boolean formValidation() {
        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject count = new JSONObject();

        count.put("na2tm", binding.na2tm.getText().toString());
        count.put("na2tf", binding.na2tf.getText().toString());
        count.put("na2adm", binding.na2adm.getText().toString());
        count.put("na2adf", binding.na2adf.getText().toString());
        count.put("na2u5b", binding.na2u5b.getText().toString());
        count.put("na2u5g", binding.na2u5g.getText().toString());
        count.put("na2mw", binding.na2mw.getText().toString());

        MainApp.fc.setRespLineNo(respLineNo);

        MainApp.fc.setCount(String.valueOf(count));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSACount();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        GestureDetector mGestureDetector;
        private OnItemClickListener mListener;

        public RecyclerItemClickListener(Context context, OnItemClickListener listener) {
            mListener = listener;

            mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
            View childView = view.findChildViewUnder(e.getX(), e.getY());
            if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
                mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }

        public interface OnItemClickListener {
            void onItemClick(View view, int position);
        }
    }

    //    Recycler classes
    public class FamilyMembersAdapter extends RecyclerView.Adapter<FamilyMembersAdapter.MyViewHolder> {

        MyViewHolder holder;
        private List<FamilyMembersContract> membersList;

        public FamilyMembersAdapter(List<FamilyMembersContract> membersList) {
            this.membersList = membersList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.familymemberslist, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            this.holder = holder;
            this.holder.bindUser(this.membersList.get(position));
        }

        @Override
        public int getItemCount() {
            return membersList.size();
        }

        public String MStatusChecking(String ms) {
            String result = "";
            switch (ms) {
                case "1":
                    result = "Married";
                    break;
                case "2":
                    result = "Widowed";
                    break;
                case "3":
                    result = "Divorced";
                    break;
                case "4":
                    result = "Seperated";
                    break;
                case "5":
                    result = "Never Married";
                    break;
            }
            return result;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            FamilymemberslistBinding familyBinding;

            public MyViewHolder(View itemView) {
                super(itemView);
                familyBinding = DataBindingUtil.bind(itemView);
            }

            public void bindUser(FamilyMembersContract mem) {
                familyBinding.memberName.setText(mem.getName().toUpperCase());
                familyBinding.gender.setText(mem.getGender().equals("1") ? "Male" : "Female");
                familyBinding.lineNo.setText("Line No:" + mem.getSerialNo());
                familyBinding.ffName.setText(mem.getFatherName().equals("") ? "..." : mem.getFatherName());
                familyBinding.mmName.setText(mem.getMotherName().equals("") ? "..." : mem.getMotherName());
                familyBinding.maritalStatus.setText(MStatusChecking(mem.getMaritialStatus()));
            }
        }
    }

    public class populateRecyclerView extends AsyncTask<String, String, String> {
        private Context mContext;

        public populateRecyclerView(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        protected String doInBackground(String... strings) {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {

//              Set Recycler View
                    mAdapter = new FamilyMembersAdapter(MainApp.familyMembersList);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    binding.recyclerNoMembers.setLayoutManager(mLayoutManager);
                    binding.recyclerNoMembers.setItemAnimator(new DefaultItemAnimator());
                    binding.recyclerNoMembers.setAdapter(mAdapter);

                    mAdapter.notifyDataSetChanged();
                }
            });


            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
//                   Background black for those that's data filled
                    for (int item : MainApp.hhClicked) {
                        binding.recyclerNoMembers.getChildAt(item).setBackgroundColor(Color.BLACK);
                    }
                }
            }, 800);
        }
    }
}