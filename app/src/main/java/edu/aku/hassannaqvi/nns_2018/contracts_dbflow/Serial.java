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
public class Serial extends BaseModel {

    public static final String _URI = "enumblock.php";
    @Column
    @PrimaryKey(autoincrement = true)
    @Unique
    public int _id;
    @Column
    private String deviceId;

    @Column
    private String date;
    @Column
    private String serialno;
    @Column
    private String synced;
    @Column
    private String synced_date;

    public Serial() {
    }

    public Serial(String deviceId, String date, String serialNo) {
        this.deviceId = deviceId;
        this.date = date;
        this.serialno = serialNo;
    }

    public static Serial Sync(JSONObject jsonObject) {

        Gson gson = new GsonBuilder().create();
        Serial serObj = gson.fromJson(jsonObject.toString(), Serial.class);
        return serObj;

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSerialNo() {
        return serialno;
    }

    public void setSerialNo(String serialNo) {
        this.serialno = serialNo;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;
    }

    // JSON
    public JSONObject toJSONObject() throws JSONException {

        Gson gson = new GsonBuilder().create();
        JSONObject json = new JSONObject(gson.toJson(this, Serial.class));
        return json;
    }
}