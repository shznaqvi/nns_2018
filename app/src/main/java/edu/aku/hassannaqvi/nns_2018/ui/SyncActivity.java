package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import edu.aku.hassannaqvi.nns_2018.Adapters.syncListAdapter;
import edu.aku.hassannaqvi.nns_2018.Adapters.upload_list_adapter;
import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.ChildContract;
import edu.aku.hassannaqvi.nns_2018.contracts.DeceasedContract;
import edu.aku.hassannaqvi.nns_2018.contracts.EligibleMembersContract;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.contracts.FormsContract;
import edu.aku.hassannaqvi.nns_2018.contracts.MWRAContract;
import edu.aku.hassannaqvi.nns_2018.contracts.MicroContract;
import edu.aku.hassannaqvi.nns_2018.contracts.NutritionContract;
import edu.aku.hassannaqvi.nns_2018.contracts.OutcomeContract;
import edu.aku.hassannaqvi.nns_2018.contracts.RecipientsContract;
import edu.aku.hassannaqvi.nns_2018.contracts.SpecimenContract;
import edu.aku.hassannaqvi.nns_2018.contracts.WaterSpecimenContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySyncBinding;
import edu.aku.hassannaqvi.nns_2018.get.GetAllData;
import edu.aku.hassannaqvi.nns_2018.other.SyncModel;
import edu.aku.hassannaqvi.nns_2018.sync.SyncAllData;
import edu.aku.hassannaqvi.nns_2018.sync.SyncDevice;

public class SyncActivity extends AppCompatActivity implements SyncDevice.SyncDevicInterface {
    SharedPreferences.Editor editor;
    SharedPreferences sharedPref;
    String DirectoryName;
    DatabaseHelper db;
    syncListAdapter syncLstAdapter;
    upload_list_adapter uploadListAdapter;
    ActivitySyncBinding bi;
    SyncModel model;
    SyncModel uploadmodel;
    List<SyncModel> list;
    List<SyncModel> uploadlist;
    Boolean listActivityCreated;
    Boolean uploadlistActivityCreated;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_sync);
        bi.setCallback(this);
        list = new ArrayList<>();
        uploadlist = new ArrayList<>();
        bi.noItem.setVisibility(View.VISIBLE);
        bi.noDataItem.setVisibility(View.VISIBLE);
        listActivityCreated = true;
        uploadlistActivityCreated = true;
        db = new DatabaseHelper(this);
        dbBackup();
        bi.btnSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (LoginActivity.checkAndRequestPermissions(SyncActivity.this, SyncActivity.this)) {
                        onSyncDataClick();
                    } else {
                        Toast.makeText(SyncActivity.this, "Please allow permissions from setting", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    onSyncDataClick();
                }

            }
        });
        bi.btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (LoginActivity.checkAndRequestPermissions(SyncActivity.this, SyncActivity.this)) {
                        syncServer();

                    } else {
                        Toast.makeText(SyncActivity.this, "Please allow permissions from setting", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    syncServer();

                }

            }
        });
        setAdapter();
        setUploadAdapter();
    }

    public void onSyncDataClick() {

        // Require permissions INTERNET & ACCESS_NETWORK_STATE
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            new SyncDevice(SyncActivity.this, true).execute();

        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }
    }

    void setAdapter() {
        syncLstAdapter = new syncListAdapter(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        bi.rvSyncList.setLayoutManager(mLayoutManager);
        bi.rvSyncList.setItemAnimator(new DefaultItemAnimator());
        bi.rvSyncList.setAdapter(syncLstAdapter);
        syncLstAdapter.notifyDataSetChanged();
        if (syncLstAdapter.getItemCount() > 0) {
            bi.noItem.setVisibility(View.GONE);
        } else {
            bi.noItem.setVisibility(View.VISIBLE);
        }
    }

    void setUploadAdapter() {
        uploadListAdapter = new upload_list_adapter(uploadlist);
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getApplicationContext());
        bi.rvUploadList.setLayoutManager(mLayoutManager2);
        bi.rvUploadList.setItemAnimator(new DefaultItemAnimator());
        bi.rvUploadList.setAdapter(uploadListAdapter);
        uploadListAdapter.notifyDataSetChanged();
        if (uploadListAdapter.getItemCount() > 0) {
            bi.noDataItem.setVisibility(View.GONE);
        } else {
            bi.noDataItem.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void processFinish(boolean flag) {
        if (flag) {
            HashMap<String, String> tagVal = MainApp.getTagValues(this);
            new syncData(SyncActivity.this, tagVal.get("org") != null ? tagVal.get("org").equals("null") ? null : tagVal.get("org") : null).execute();
        }
    }

    public void syncServer() {

        // Require permissions INTERNET & ACCESS_NETWORK_STATE
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            DatabaseHelper db = new DatabaseHelper(this);
            //syncStatus.setText(null);
            new SyncDevice(this, false).execute();
            Toast.makeText(getApplicationContext(), "Syncing Forms", Toast.LENGTH_SHORT).show();
            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "Forms",
                    "updateSyncedForms",
                    FormsContract.class,
                    MainApp._HOST_URL + FormsContract.FormsTable._URL,
                    db.getUnsyncedForms(), this.findViewById(R.id.syncStatus), 0, uploadListAdapter, uploadlist
            ).execute();

            Toast.makeText(getApplicationContext(), "Syncing Family Members", Toast.LENGTH_SHORT).show();
            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "Family Members",
                    "updateSyncedFamilyMembers",
                    FamilyMembersContract.class,
                    MainApp._HOST_URL + FamilyMembersContract.familyMembers._URL,
                    db.getUnsyncedFamilyMembers(), this.findViewById(R.id.syncStatus), 1, uploadListAdapter, uploadlist
            ).execute();
            bi.noDataItem.setVisibility(View.GONE);
            Toast.makeText(getApplicationContext(), "Syncing WRAs", Toast.LENGTH_SHORT).show();
            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "WRAs",
                    "updateSyncedMWRAForm",
                    MWRAContract.class,
                    MainApp._HOST_URL + MWRAContract.MWRATable._URL,
                    db.getUnsyncedMWRA(), this.findViewById(R.id.syncStatus), 2, uploadListAdapter, uploadlist
            ).execute();

            Toast.makeText(getApplicationContext(), "Syncing Children", Toast.LENGTH_SHORT).show();
            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "Children",
                    "updateSyncedChildForm",
                    ChildContract.class,
                    MainApp._HOST_URL + ChildContract.ChildTable._URL,
                    db.getUnsyncedChildForms(), this.findViewById(R.id.syncStatus), 3, uploadListAdapter, uploadlist
            ).execute();

            Toast.makeText(getApplicationContext(), "Syncing Eligibles", Toast.LENGTH_SHORT).show();
            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "Eligibles",
                    "updateSyncedEligibles",
                    EligibleMembersContract.class,
                    MainApp._HOST_URL + EligibleMembersContract.eligibleMembers._URL,
                    db.getUnsyncedEligbleMembers(), this.findViewById(R.id.syncStatus), 4, uploadListAdapter, uploadlist
            ).execute();

            Toast.makeText(getApplicationContext(), "Syncing Outcomes", Toast.LENGTH_SHORT).show();
            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "Outcomes",
                    "updateSyncedOutcomeForm",
                    OutcomeContract.class,
                    MainApp._HOST_URL + OutcomeContract.outcomeTable._URL,
                    db.getUnsyncedOutcome(), this.findViewById(R.id.syncStatus), 5, uploadListAdapter, uploadlist
            ).execute();

            Toast.makeText(getApplicationContext(), "Syncing Recepients", Toast.LENGTH_SHORT).show();
            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "Recepients",
                    "updateSyncedRecepientsForm",
                    RecipientsContract.class,
                    MainApp._HOST_URL + RecipientsContract.RecipientsTable._URL,
                    db.getUnsyncedRecipients(), this.findViewById(R.id.syncStatus), 6, uploadListAdapter, uploadlist
            ).execute();

            Toast.makeText(getApplicationContext(), "Syncing Nutrition", Toast.LENGTH_SHORT).show();
            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "Nutrition",
                    "updateSyncedNutrition",
                    NutritionContract.class,
                    MainApp._HOST_URL + NutritionContract.NutritionTable._URL,
                    db.getUnsyncedNutrition(), this.findViewById(R.id.syncStatus), 7, uploadListAdapter, uploadlist
            ).execute();

            Toast.makeText(getApplicationContext(), "Syncing Deceased", Toast.LENGTH_SHORT).show();
            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "Deceased",
                    "updateSyncedDeceasedForm",
                    DeceasedContract.class,
                    MainApp._HOST_URL + DeceasedContract.DeceasedTable._URL,
                    db.getUnsyncedDeceasedMembers(), this.findViewById(R.id.syncStatus), 8, uploadListAdapter, uploadlist
            ).execute();
            Toast.makeText(getApplicationContext(), "Syncing Blood Specimen", Toast.LENGTH_SHORT).show();
            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "Specimen",
                    "updateSyncedSpecimen",
                    SpecimenContract.class,
                    MainApp._HOST_URL + SpecimenContract.SpecimenTable._URL,
                    db.getUnsyncedSpecimenForms(), this.findViewById(R.id.syncStatus), 9, uploadListAdapter, uploadlist
            ).execute();

            Toast.makeText(getApplicationContext(), "Syncing Blood Specimen", Toast.LENGTH_SHORT).show();
            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "WaterSpecimen",
                    "updateSyncedWaterSpecimen",
                    WaterSpecimenContract.class,
                    MainApp._HOST_URL + WaterSpecimenContract.WaterSpecimenTable._URL,
                    db.getUnsyncedWaterSpecimenForms(), this.findViewById(R.id.syncStatus), 10, uploadListAdapter, uploadlist
            ).execute();

            Toast.makeText(getApplicationContext(), "Syncing Micro Results", Toast.LENGTH_SHORT).show();
            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "Micro",
                    "updateSyncedMicroForm",
                    MicroContract.class,
                    MainApp._HOST_URL + MicroContract.MicroTable._URL,
                    db.getUnsyncedMicroForms(), this.findViewById(R.id.syncStatus), 11, uploadListAdapter, uploadlist
            ).execute();


/*
            Toast.makeText(getApplicationContext(), "Syncing Summary", Toast.LENGTH_SHORT).show();
            if (uploadlistActivityCreated){
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "Summary",
                    "updateSyncedSummaryForm",
                    SummaryContract.class,
                    MainApp._HOST_URL + SummaryContract.singleSum._URL,
                    db.getUnsyncedSummary(), this.findViewById(R.id.syncStatus),9,uploadListAdapter,uploadlist
            ).execute();
            */
            uploadlistActivityCreated = false;

            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = syncPref.edit();

            editor.putString("LastUpSyncServer", dtToday);

            editor.apply();

        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }

    }

    public void dbBackup() {

        sharedPref = getSharedPreferences("src", MODE_PRIVATE);
        editor = sharedPref.edit();

        if (sharedPref.getBoolean("flag", false)) {

            String dt = sharedPref.getString("dt", new SimpleDateFormat("dd-MM-yy").format(new Date()));

            if (dt != new SimpleDateFormat("dd-MM-yy").format(new Date())) {
                editor.putString("dt", new SimpleDateFormat("dd-MM-yy").format(new Date()));

                editor.commit();
            }

            File folder = new File(Environment.getExternalStorageDirectory() + File.separator + DatabaseHelper.PROJECT_NAME);
            boolean success = true;
            if (!folder.exists()) {
                success = folder.mkdirs();
            }
            if (success) {

                DirectoryName = folder.getPath() + File.separator + sharedPref.getString("dt", "");
                folder = new File(DirectoryName);
                if (!folder.exists()) {
                    success = folder.mkdirs();
                }
                if (success) {

                    try {
                        File dbFile = new File(this.getDatabasePath(DatabaseHelper.DATABASE_NAME).getPath());
                        FileInputStream fis = new FileInputStream(dbFile);

                        String outFileName = DirectoryName + File.separator +
                                DatabaseHelper.DB_NAME;

                        // Open the empty db as the output stream
                        OutputStream output = new FileOutputStream(outFileName);

                        // Transfer bytes from the inputfile to the outputfile
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = fis.read(buffer)) > 0) {
                            output.write(buffer, 0, length);
                        }
                        // Close the streams
                        output.flush();
                        output.close();
                        fis.close();
                    } catch (IOException e) {
                        Log.e("dbBackup:", e.getMessage());
                    }

                }

            } else {
                Toast.makeText(this, "Not create folder", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public class syncData extends AsyncTask<String, String, String> {

        private Context mContext;
        String orgID;

        public syncData(Context mContext, String orgID) {
            this.mContext = mContext;
            this.orgID = orgID;
        }

        @Override
        protected String doInBackground(String... strings) {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {

//                  getting Enum Blocks
                    Toast.makeText(SyncActivity.this, "Sync Enum Blocks", Toast.LENGTH_SHORT).show();

                    if (listActivityCreated) {
                        model = new SyncModel();
                        model.setstatusID(0);
                        list.add(model);
                    }
                    new GetAllData(mContext, "EnumBlock", syncLstAdapter, list).execute(orgID);
                    bi.noItem.setVisibility(View.GONE);

//                  getting Users!!
                    Toast.makeText(SyncActivity.this, "Sync Users", Toast.LENGTH_SHORT).show();

                    if (listActivityCreated) {
                        model = new SyncModel();
                        model.setstatusID(0);
                        list.add(model);
                    }
                    new GetAllData(mContext, "User", syncLstAdapter, list).execute(orgID);

//                   getting BL Random
                    Toast.makeText(SyncActivity.this, "Sync BL Random", Toast.LENGTH_SHORT).show();
                    if (listActivityCreated) {
                        model = new SyncModel();
                        model.setstatusID(0);
                        list.add(model);
                    }
                    new GetAllData(mContext, "BLRandom", syncLstAdapter, list).execute(orgID);

//                    Getting App Version
                    Toast.makeText(SyncActivity.this, "Sync App Version", Toast.LENGTH_SHORT).show();
                    if (listActivityCreated) {
                        model = new SyncModel();
                        model.setstatusID(0);
                        list.add(model);
                    }
                    new GetAllData(mContext, "VersionApp", syncLstAdapter, list).execute();
                    /*Toast.makeText(Menu2Activity.this, "Sync Family Members", Toast.LENGTH_LONG).show();
                    new GetAllData(mContext, "FamilyMembers").execute();*/

                    listActivityCreated = false;
                }
            });


            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

//                    populateSpinner(mContext);

                    editor.putBoolean("flag", true);
                    editor.commit();

                    dbBackup();

                }
            }, 1200);
        }
    }

}
