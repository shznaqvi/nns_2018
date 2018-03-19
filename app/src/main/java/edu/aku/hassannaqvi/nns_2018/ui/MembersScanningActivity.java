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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivityMembersScanningBinding;
import edu.aku.hassannaqvi.nns_2018.databinding.ScannedmemberslistBinding;

public class MembersScanningActivity extends AppCompatActivity {

    static int progress = 0;
    Boolean exit = true;
    ActivityMembersScanningBinding binding;
    int progressStatus = 0;
    Handler handler = new Handler();
    ScannedFamilyMembersAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_members_scanning);
        binding.setCallback(this);

        binding.collapsingToolbar.setTitle("SCANNED MEMBERS");

        if (getIntent().getBooleanExtra("reBackActivity", true)) {

            MainApp.scannedMembersList = new ArrayList<>();
            MainApp.scannedMembersSubList = new ArrayList<>();

        } else {
            exit = false;
            progress = 0;
            binding.progress.setProgress(progressStatus);

            binding.progress.setVisibility(View.GONE);

            // Populate RecyclerView
            new populateRecyclerView(this).execute();
        }
    }

    public void BtnAddMembers() {

        binding.progress.setVisibility(View.VISIBLE);

        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus = doSomeWork();
                    handler.post(new Runnable() {
                        public void run() {
                            binding.progress.setProgress(progressStatus);
//                            binding.progress.setSecondaryProgress(progressStatus + 10);
                        }
                    });
                }
                handler.post(new Runnable() {
                    public void run() {
                        MainApp.openQRScanner(MembersScanningActivity.this);
                    }
                });
            }

            private int doSomeWork() {
                try {
                    // ---simulate doing some work---
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return ++progress;
            }
        }).start();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();

                finish();

                startActivity(new Intent(this, MembersScanningInfoActivity.class)
                        .putExtra("scanData", result.getContents().trim()));

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity

        } else {
            Toast.makeText(this, "Press back will lost this list!!",
                    Toast.LENGTH_LONG).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }
    }

    //    Recycler classes
    public class ScannedFamilyMembersAdapter extends RecyclerView.Adapter<ScannedFamilyMembersAdapter.MyViewHolder> {

        MyViewHolder holder;
        private List<FamilyMembersContract> membersList;

        public ScannedFamilyMembersAdapter(List<FamilyMembersContract> membersList) {
            this.membersList = membersList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.scannedmemberslist, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            this.holder = holder;
            this.holder.bindUser(membersList.get(position));
        }

        @Override
        public int getItemCount() {
            return membersList.size();
        }

        public int SetImage(String na204) {
            int result = 0;
            result = R.drawable.ctr_female;
            return result;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            ScannedmemberslistBinding scannedFamilyBinding;

            public MyViewHolder(View itemView) {
                super(itemView);
                scannedFamilyBinding = DataBindingUtil.bind(itemView);
            }

            public void bindUser(FamilyMembersContract mem) {
                scannedFamilyBinding.imgUser.setImageDrawable(getDrawable(SetImage(mem.getna204())));
                scannedFamilyBinding.memberName.setText(mem.getName().toUpperCase());
                scannedFamilyBinding.na204.setText(mem.getna204().equals("1") ? "Male" : "Female");
                scannedFamilyBinding.lineNo.setText("Line No:" + mem.getSerialNo());
                scannedFamilyBinding.mmHHno.setText(mem.getHhNo());
                scannedFamilyBinding.mmEnum.setText(mem.getEnmNo());
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
                    mAdapter = new ScannedFamilyMembersAdapter(MainApp.scannedMembersList);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    binding.recyclerscannedmemberslist.setLayoutManager(mLayoutManager);
                    binding.recyclerscannedmemberslist.setItemAnimator(new DefaultItemAnimator());
                    binding.recyclerscannedmemberslist.setAdapter(mAdapter);

                    mAdapter.notifyDataSetChanged();
                }
            });


            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            /*new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
//                   Background black for those that's data filled
                    for (int item : MainApp.hhClicked) {
                        binding.recyclerscannedmemberslist.getChildAt(item).setBackgroundColor(Color.BLACK);
                    }
                }
            }, 800);*/
        }
    }

}
