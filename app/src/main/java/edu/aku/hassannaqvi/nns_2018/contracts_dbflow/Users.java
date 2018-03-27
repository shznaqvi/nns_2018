package edu.aku.hassannaqvi.nns_2018.contracts_dbflow;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.nns_2018.AppDB;

/**
 * Created by gul.sanober on 3/27/2018.
 */

@Table(database = AppDB.class)
public class Users extends BaseModel {

    public static final String _URI = "users.php";
    @Column
    @PrimaryKey(autoincrement = true)
    @Unique
    public int _id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String full_name;

    public static Users Sync(JSONObject jsonObject) {

        Gson gson = new GsonBuilder().create();
        Users user = gson.fromJson(jsonObject.toString(), Users.class);
        return user;

        /*
        this.ROW_USERNAME = jsonObject.getString(UsersContract.UsersTable.ROW_USERNAME);
        this.ROW_PASSWORD = jsonObject.getString(UsersContract.UsersTable.ROW_PASSWORD);
        this.FULL_NAME = jsonObject.getString(UsersContract.UsersTable.FULL_NAME);
//        this.REGION_DSS = jsonObject.getString(UsersTable.REGION_DSS);
        return this;
        */
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    // JSON
    public JSONObject toJSONObject() throws JSONException {

        Gson gson = new GsonBuilder().create();
        JSONObject json = new JSONObject(gson.toJson(this, Users.class));
        return json;
    }
}