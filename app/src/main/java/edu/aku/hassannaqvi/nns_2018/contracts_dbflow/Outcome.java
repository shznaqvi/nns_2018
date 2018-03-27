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
public class Outcome extends BaseModel {

    public static String _URL = "outcomes.php";
    @Column
    @PrimaryKey(autoincrement = true)
    @Unique
    public int _id;

    @Column
    public String projectname = "NNS-2018";
    @Column
    private String _uid;
    @Column
    private String _uuid;
    @Column
    private String formdate;
    @Column
    private String user;
    @Column
    private String istatus;
    @Column
    private String istatus88x;
    @Column
    private String enm_no;
    @Column
    private String resp_lno;
    @Column
    private String hh_no;
    @Column
    private String gpslat;
    @Column
    private String gpslng;
    @Column
    private String gpsdate;
    @Column
    private String gpsacc;
    @Column
    private String gpselev;
    @Column
    private String deviceid;
    @Column
    private String devicetagid;
    @Column
    private String synced;
    @Column
    private String synced_date;

    @Column
    private String appversion;

    // SB1A
    @Column
    private String nw215y;
    @Column
    private String nw215m;
    @Column
    private String nw215d;
    @Column
    private String nw216;
    @Column
    private String nw217;
    @Column
    private String nw218;
    @Column
    private String nw219y;
    @Column
    private String nw219m;
    @Column
    private String nw219d;
    @Column
    private String nw220y;
    @Column
    private String nw220m;
    @Column
    private String nw220d;

    public static Outcome Sync(JSONObject jsonObject) {

        Gson gson = new GsonBuilder().create();
        Outcome outObj = gson.fromJson(jsonObject.toString(), Outcome.class);
        return outObj;

    }

    public String getProjectname() {
        return projectname;
    }

    public String get_uid() {
        return _uid;
    }

    public void set_uid(String _uid) {
        this._uid = _uid;
    }

    public String get_uuid() {
        return _uuid;
    }

    public void set_uuid(String _uuid) {
        this._uuid = _uuid;
    }

    public String getFormdate() {
        return formdate;
    }

    public void setFormdate(String formdate) {
        this.formdate = formdate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }

    public String getIstatus88x() {
        return istatus88x;
    }

    public void setIstatus88x(String istatus88x) {
        this.istatus88x = istatus88x;
    }

    public String getEnm_no() {
        return enm_no;
    }

    public void setEnm_no(String enm_no) {
        this.enm_no = enm_no;
    }

    public String getResp_lno() {
        return resp_lno;
    }

    public void setResp_lno(String resp_lno) {
        this.resp_lno = resp_lno;
    }

    public String getHh_no() {
        return hh_no;
    }

    public void setHh_no(String hh_no) {
        this.hh_no = hh_no;
    }

    public String getGpslat() {
        return gpslat;
    }

    public void setGpslat(String gpslat) {
        this.gpslat = gpslat;
    }

    public String getGpslng() {
        return gpslng;
    }

    public void setGpslng(String gpslng) {
        this.gpslng = gpslng;
    }

    public String getGpsdate() {
        return gpsdate;
    }

    public void setGpsdate(String gpsdate) {
        this.gpsdate = gpsdate;
    }

    public String getGpsacc() {
        return gpsacc;
    }

    public void setGpsacc(String gpsacc) {
        this.gpsacc = gpsacc;
    }

    public String getGpselev() {
        return gpselev;
    }

    public void setGpselev(String gpselev) {
        this.gpselev = gpselev;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getDevicetagid() {
        return devicetagid;
    }

    public void setDevicetagid(String devicetagid) {
        this.devicetagid = devicetagid;
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

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }

    public String getNw215y() {
        return nw215y;
    }

    public void setNw215y(String nw215y) {
        this.nw215y = nw215y;
    }

    public String getNw215m() {
        return nw215m;
    }

    public void setNw215m(String nw215m) {
        this.nw215m = nw215m;
    }

    public String getNw215d() {
        return nw215d;
    }

    public void setNw215d(String nw215d) {
        this.nw215d = nw215d;
    }

    public String getNw216() {
        return nw216;
    }

    public void setNw216(String nw216) {
        this.nw216 = nw216;
    }

    public String getNw217() {
        return nw217;
    }

    public void setNw217(String nw217) {
        this.nw217 = nw217;
    }

    public String getNw218() {
        return nw218;
    }

    public void setNw218(String nw218) {
        this.nw218 = nw218;
    }

    public String getNw219y() {
        return nw219y;
    }

    public void setNw219y(String nw219y) {
        this.nw219y = nw219y;
    }

    public String getNw219m() {
        return nw219m;
    }

    public void setNw219m(String nw219m) {
        this.nw219m = nw219m;
    }

    public String getNw219d() {
        return nw219d;
    }

    public void setNw219d(String nw219d) {
        this.nw219d = nw219d;
    }

    public String getNw220y() {
        return nw220y;
    }

    public void setNw220y(String nw220y) {
        this.nw220y = nw220y;
    }

    public String getNw220m() {
        return nw220m;
    }

    public void setNw220m(String nw220m) {
        this.nw220m = nw220m;
    }

    public String getNw220d() {
        return nw220d;
    }

    public void setNw220d(String nw220d) {
        this.nw220d = nw220d;
    }

    // JSON
    public JSONObject toJSONObject() throws JSONException {

        Gson gson = new GsonBuilder().create();
        JSONObject json = new JSONObject(gson.toJson(this, Outcome.class));
        return json;
    }
}
