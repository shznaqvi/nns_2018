package edu.aku.hassannaqvi.nns_2018_val.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.nns_2018_val.R;
import edu.aku.hassannaqvi.nns_2018_val.WifiDirect.WiFiDirectActivity;
import edu.aku.hassannaqvi.nns_2018_val.core.DatabaseHelper;

public class AddMember_MenuActivity extends AppCompatActivity {

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    String DirectoryName;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = new DatabaseHelper(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu_add_member, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_addMember:
                //onSyncDataClick();
                BtnAddMember();
                return true;

            case R.id.menu_wifiDirect:
                Intent wifidirect = new Intent(getApplicationContext(), WiFiDirectActivity.class);
                startActivity(wifidirect);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }


    public void BtnAddMember() {


    }


}
