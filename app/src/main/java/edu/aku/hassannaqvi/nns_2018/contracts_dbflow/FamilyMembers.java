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

import java.io.Serializable;

import edu.aku.hassannaqvi.nns_2018.AppDB;

/**
 * Created by gul.sanober on 3/27/2018.
 */
@Table(database = AppDB.class)
public class FamilyMembers extends BaseModel implements Serializable {

    public static String _URL = "familymembers.php";
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

    @Column
    private String serialNo;
    @Column
    private String na204;
    @Column
    private String name;
    @Column
    private String relationHH;
    @Column
    private String Resp;
    @Column
    private String age;
    @Column
    private String motherId;
    @Column
    private String resp;
    @Column
    private String nh2SerialNo;
    @Column
    private String nh202;
    @Column
    private String nh203;
    @Column
    private String nh204;
    @Column
    private String nh2doby;
    @Column
    private String nh2dobm;
    @Column
    private String nh2dobd;
    @Column
    private String nh206y;
    @Column
    private String nh207;
    @Column
    private String nh208;
    @Column
    private String nh209;
    @Column
    private String nh20996x;
    @Column
    private String nh210;
    @Column
    private String nh211;
    @Column
    private String nh212;
    @Column
    private String martitalStatus;
    @Column
    private String fatherName;
    @Column
    private String motherName;
    @Column
    private String ageInYear;

    public static FamilyMembers Sync(JSONObject jsonObject) {

        Gson gson = new GsonBuilder().create();
        FamilyMembers familyMembersObj = gson.fromJson(jsonObject.toString(), FamilyMembers.class);
        return familyMembersObj;

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

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getNa204() {
        return na204;
    }

    public void setNa204(String na204) {
        this.na204 = na204;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationHH() {
        return relationHH;
    }

    public void setRelationHH(String relationHH) {
        this.relationHH = relationHH;
    }

    public String getResp() {
        return Resp;
    }

    public void setResp(String resp) {
        Resp = resp;
    }

    public String getNh2SerialNo() {
        return nh2SerialNo;
    }

    public void setNh2SerialNo(String nh2SerialNo) {
        this.nh2SerialNo = nh2SerialNo;
    }

    public String getNh202() {
        return nh202;
    }

    public void setNh202(String nh202) {
        this.nh202 = nh202;
    }

    public String getNh203() {
        return nh203;
    }

    public void setNh203(String nh203) {
        this.nh203 = nh203;
    }

    public String getNh204() {
        return nh204;
    }

    public void setNh204(String nh204) {
        this.nh204 = nh204;
    }

    public String getNh2doby() {
        return nh2doby;
    }

    public void setNh2doby(String nh2doby) {
        this.nh2doby = nh2doby;
    }

    public String getNh2dobm() {
        return nh2dobm;
    }

    public void setNh2dobm(String nh2dobm) {
        this.nh2dobm = nh2dobm;
    }

    public String getNh2dobd() {
        return nh2dobd;
    }

    public void setNh2dobd(String nh2dobd) {
        this.nh2dobd = nh2dobd;
    }

    public String getNh206y() {
        return nh206y;
    }

    public void setNh206y(String nh206y) {
        this.nh206y = nh206y;
    }

    public String getNh207() {
        return nh207;
    }

    public void setNh207(String nh207) {
        this.nh207 = nh207;
    }

    public String getNh208() {
        return nh208;
    }

    public void setNh208(String nh208) {
        this.nh208 = nh208;
    }

    public String getNh209() {
        return nh209;
    }

    public void setNh209(String nh209) {
        this.nh209 = nh209;
    }

    public String getNh20996x() {
        return nh20996x;
    }

    public void setNh20996x(String nh20996x) {
        this.nh20996x = nh20996x;
    }

    public String getNh210() {
        return nh210;
    }

    public void setNh210(String nh210) {
        this.nh210 = nh210;
    }

    public String getNh211() {
        return nh211;
    }

    public void setNh211(String nh211) {
        this.nh211 = nh211;
    }

    public String getNh212() {
        return nh212;
    }

    public void setNh212(String nh212) {
        this.nh212 = nh212;
    }

    public String getMartitalStatus() {
        return martitalStatus;
    }

    public void setMartitalStatus(String martitalStatus) {
        this.martitalStatus = martitalStatus;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getAgeInYear() {
        return ageInYear;
    }

    public void setAgeInYear(String ageInYear) {
        this.ageInYear = ageInYear;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMotherId() {
        return motherId;
    }

    public void setMotherId(String motherId) {
        this.motherId = motherId;
    }

    // JSON
    // JSON
    public JSONObject toJSONObject() throws JSONException {

        Gson gson = new GsonBuilder().create();
        JSONObject json = new JSONObject(gson.toJson(this, FamilyMembers.class));
        return json;
    }
}
