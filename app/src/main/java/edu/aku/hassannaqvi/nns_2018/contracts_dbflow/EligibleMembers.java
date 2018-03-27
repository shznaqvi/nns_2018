package edu.aku.hassannaqvi.nns_2018.contracts_dbflow;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;
import com.raizlabs.android.dbflow.structure.BaseModel;

import edu.aku.hassannaqvi.nns_2018.AppDB;

/**
 * Created by gul.sanober on 3/27/2018.
 */
@Table(database = AppDB.class)
public class EligibleMembers extends BaseModel {
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
    private String hccode;
    @Column
    private String htcode;
    @Column
    private String wtcode;
    @Column
    private String nd101;
    @Column
    private String nd101Serial;
    @Column
    private String nd1Serial;
    @Column
    private String nd1w;
    @Column
    private String nd1h;
    @Column
    private String nd1muac;
    @Column
    private String nd1bcgscar;
    @Column
    private String nd1g;
    @Column
    private String nd1ca;
    @Column
    private String nd1o;

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
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

    public String getHccode() {
        return hccode;
    }

    public void setHccode(String hccode) {
        this.hccode = hccode;
    }

    public String getHtcode() {
        return htcode;
    }

    public void setHtcode(String htcode) {
        this.htcode = htcode;
    }

    public String getWtcode() {
        return wtcode;
    }

    public void setWtcode(String wtcode) {
        this.wtcode = wtcode;
    }

    public String getNd101() {
        return nd101;
    }

    public void setNd101(String nd101) {
        this.nd101 = nd101;
    }

    public String getNd101Serial() {
        return nd101Serial;
    }

    public void setNd101Serial(String nd101Serial) {
        this.nd101Serial = nd101Serial;
    }

    public String getNd1Serial() {
        return nd1Serial;
    }

    public void setNd1Serial(String nd1Serial) {
        this.nd1Serial = nd1Serial;
    }

    public String getNd1w() {
        return nd1w;
    }

    public void setNd1w(String nd1w) {
        this.nd1w = nd1w;
    }

    public String getNd1h() {
        return nd1h;
    }

    public void setNd1h(String nd1h) {
        this.nd1h = nd1h;
    }

    public String getNd1muac() {
        return nd1muac;
    }

    public void setNd1muac(String nd1muac) {
        this.nd1muac = nd1muac;
    }

    public String getNd1bcgscar() {
        return nd1bcgscar;
    }

    public void setNd1bcgscar(String nd1bcgscar) {
        this.nd1bcgscar = nd1bcgscar;
    }

    public String getNd1g() {
        return nd1g;
    }

    public void setNd1g(String nd1g) {
        this.nd1g = nd1g;
    }

    public String getNd1ca() {
        return nd1ca;
    }

    public void setNd1ca(String nd1ca) {
        this.nd1ca = nd1ca;
    }

    public String getNd1o() {
        return nd1o;
    }

    public void setNd1o(String nd1o) {
        this.nd1o = nd1o;
    }
}
