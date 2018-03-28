package edu.aku.hassannaqvi.nns_2018.contracts_dbflow;

import com.google.gson.annotations.SerializedName;
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
    @SerializedName("apkInfo")
    private String apkInfo;
    @Column
    @SerializedName("versionCode")
    private int versionCode;
    @Column
    @SerializedName("path")
    private String path;

    /*public static VersionApp Sync(JSONObject jsonObject) {

        Gson gson = new GsonBuilder().create();
        VersionApp verObj = gson.fromJson(jsonObject.toString(), VersionApp.class);
        return verObj;

    }*/

    public static VersionApp Sync(JSONObject jsonObject) throws JSONException {
        VersionApp vapp = new VersionApp();
        //vapp.setVersionCode(jsonObject.getJSONObject(vapp.getApkInfo()).getString(vapp.getApkInfo()));
        vapp.setPath(jsonObject.getString(vapp.path));
        return vapp;
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

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getPath() {
        return path;
    }

    // JSON
   /* public JSONObject toJSONObject() throws JSONException {

        Gson gson = new GsonBuilder().create();
        JSONObject json = new JSONObject(gson.toJson(this, VersionApp.class));
        return json;
    }*/

    /*public VersionApp Sync(JSONObject jsonObject) throws JSONException {
        this.versionCode = jsonObject.getJSONObject(apkInfo).getString(versionCode);
        this.path = jsonObject.getString(path);
        return this;
    }*/

    public void setPath(String path) {
        this.path = path;
    }
}