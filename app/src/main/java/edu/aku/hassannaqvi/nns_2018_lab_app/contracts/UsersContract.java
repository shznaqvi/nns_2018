package edu.aku.hassannaqvi.nns_2018_lab_app.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class UsersContract {

    private static final String TAG = "Users_CONTRACT";
    Long _ID;
    String ROW_USERNAME;
    String ROW_PASSWORD;
    String FULL_NAME;
    String TEAM_NO;
    String ORG_ID;

    public UsersContract() {
        // Default Constructor
    }

    public UsersContract(String username, String password) {
        this.ROW_PASSWORD = password;
        this.ROW_USERNAME = username;


    }

    public Long getUserID() {
        return this._ID;
    }

    public void setId(int id) {
        this._ID = Long.valueOf(id);
    }

    public String getUserName() {
        return this.ROW_USERNAME;
    }

    public void setUserName(String username) {
        this.ROW_USERNAME = username;
    }

    public String getPassword() {
        return this.ROW_PASSWORD;
    }

    public void setPassword(String password) {
        this.ROW_PASSWORD = password;
    }

    public String getFULL_NAME() {
        return FULL_NAME;
    }

    public void setFULL_NAME(String FULL_NAME) {
        this.FULL_NAME = FULL_NAME;
    }

    public String getTEAM_NO() {
        return TEAM_NO;
    }

    public void setTEAM_NO(String TEAM_NO) {
        this.TEAM_NO = TEAM_NO;
    }

    public String getORG_ID() {
        return ORG_ID;
    }

    public void setORG_ID(String ORG_ID) {
        this.ORG_ID = ORG_ID;
    }

    public UsersContract Sync(JSONObject jsonObject) throws JSONException {
        this.ROW_USERNAME = jsonObject.getString(UsersTable.ROW_USERNAME);
        this.ROW_PASSWORD = jsonObject.getString(UsersTable.ROW_PASSWORD);
        this.FULL_NAME = jsonObject.getString(UsersTable.FULL_NAME);
        this.TEAM_NO = jsonObject.getString(UsersTable.TEAM_NO);
        this.ORG_ID = jsonObject.getString(UsersTable.ORG_ID);
        return this;

    }

    public UsersContract Hydrate(Cursor cursor) {
        this._ID = cursor.getLong(cursor.getColumnIndex(UsersTable._ID));
        this.ROW_USERNAME = cursor.getString(cursor.getColumnIndex(UsersTable.ROW_USERNAME));
        this.ROW_PASSWORD = cursor.getString(cursor.getColumnIndex(UsersTable.ROW_PASSWORD));
        this.FULL_NAME = cursor.getString(cursor.getColumnIndex(UsersTable.FULL_NAME));
        this.TEAM_NO = cursor.getString(cursor.getColumnIndex(UsersTable.TEAM_NO));
        this.ORG_ID = cursor.getString(cursor.getColumnIndex(UsersTable.ORG_ID));
        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();
        json.put(UsersTable._ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(UsersTable.ROW_USERNAME, this.ROW_USERNAME == null ? JSONObject.NULL : this.ROW_USERNAME);
        json.put(UsersTable.ROW_PASSWORD, this.ROW_PASSWORD == null ? JSONObject.NULL : this.ROW_PASSWORD);
        json.put(UsersTable.FULL_NAME, this.FULL_NAME == null ? JSONObject.NULL : this.FULL_NAME);
        json.put(UsersTable.TEAM_NO, this.TEAM_NO == null ? JSONObject.NULL : this.TEAM_NO);
        json.put(UsersTable.ORG_ID, this.ORG_ID == null ? JSONObject.NULL : this.ORG_ID);
        return json;
    }

    public static abstract class UsersTable implements BaseColumns {

        public static final String TABLE_NAME = "users";
        public static final String _ID = "id";
        public static final String ROW_USERNAME = "username";
        public static final String ROW_PASSWORD = "password";
        public static final String FULL_NAME = "full_name";
        public static final String TEAM_NO = "teamno";
        public static final String ORG_ID = "id_org";

        public static final String _URI = "users.php";
    }
}