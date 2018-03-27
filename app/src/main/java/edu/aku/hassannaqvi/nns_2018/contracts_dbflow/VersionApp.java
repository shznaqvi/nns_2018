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
public class VersionApp extends BaseModel {

    public static final String _URI = "output.json";
    @Column
    @PrimaryKey(autoincrement = true)
    @Unique
    public int _id;
    @Column
    private String apkInfo;
    @Column
    private String versionCode;
    @Column
    private String path;

    public static VersionApp Sync(JSONObject jsonObject) {

        Gson gson = new GsonBuilder().create();
        VersionApp verObj = gson.fromJson(jsonObject.toString(), VersionApp.class);
        return verObj;

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getApkInfo() {
        return apkInfo;
    }

    public void setApkInfo(String apkInfo) {
        this.apkInfo = apkInfo;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    // JSON
    public JSONObject toJSONObject() throws JSONException {

        Gson gson = new GsonBuilder().create();
        JSONObject json = new JSONObject(gson.toJson(this, VersionApp.class));
        return json;
    }
}