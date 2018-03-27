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
public class Recipients extends BaseModel {
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
    private String nh7a01;
    @Column
    private String nh7a01Serial;
    @Column
    private String nh7a02;
    @Column
    private String nh7a03y;
    @Column
    private String nh7a03m;
    @Column
    private String nh7a04a;
    @Column
    private String nh7a04b;
    @Column
    private String nh7a04c;
    @Column
    private String nh7a04d;
    @Column
    private String nh7a04e;
    @Column
    private String nh7a04f;
    @Column
    private String nh7a04g;
    @Column
    private String nh7a04h;
    @Column
    private String nh7a04i;
    @Column
    private String nh7a0496;
    @Column
    private String nh7a0496x;
    @Column
    private String nh7a05;
    @Column
    private String nh7a06;


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

    public String getNh7a01() {
        return nh7a01;
    }

    public void setNh7a01(String nh7a01) {
        this.nh7a01 = nh7a01;
    }

    public String getNh7a01Serial() {
        return nh7a01Serial;
    }

    public void setNh7a01Serial(String nh7a01Serial) {
        this.nh7a01Serial = nh7a01Serial;
    }

    public String getNh7a02() {
        return nh7a02;
    }

    public void setNh7a02(String nh7a02) {
        this.nh7a02 = nh7a02;
    }

    public String getNh7a03y() {
        return nh7a03y;
    }

    public void setNh7a03y(String nh7a03y) {
        this.nh7a03y = nh7a03y;
    }

    public String getNh7a03m() {
        return nh7a03m;
    }

    public void setNh7a03m(String nh7a03m) {
        this.nh7a03m = nh7a03m;
    }

    public String getNh7a04a() {
        return nh7a04a;
    }

    public void setNh7a04a(String nh7a04a) {
        this.nh7a04a = nh7a04a;
    }

    public String getNh7a04b() {
        return nh7a04b;
    }

    public void setNh7a04b(String nh7a04b) {
        this.nh7a04b = nh7a04b;
    }

    public String getNh7a04c() {
        return nh7a04c;
    }

    public void setNh7a04c(String nh7a04c) {
        this.nh7a04c = nh7a04c;
    }

    public String getNh7a04d() {
        return nh7a04d;
    }

    public void setNh7a04d(String nh7a04d) {
        this.nh7a04d = nh7a04d;
    }

    public String getNh7a04e() {
        return nh7a04e;
    }

    public void setNh7a04e(String nh7a04e) {
        this.nh7a04e = nh7a04e;
    }

    public String getNh7a04f() {
        return nh7a04f;
    }

    public void setNh7a04f(String nh7a04f) {
        this.nh7a04f = nh7a04f;
    }

    public String getNh7a04g() {
        return nh7a04g;
    }

    public void setNh7a04g(String nh7a04g) {
        this.nh7a04g = nh7a04g;
    }

    public String getNh7a04h() {
        return nh7a04h;
    }

    public void setNh7a04h(String nh7a04h) {
        this.nh7a04h = nh7a04h;
    }

    public String getNh7a04i() {
        return nh7a04i;
    }

    public void setNh7a04i(String nh7a04i) {
        this.nh7a04i = nh7a04i;
    }

    public String getNh7a0496() {
        return nh7a0496;
    }

    public void setNh7a0496(String nh7a0496) {
        this.nh7a0496 = nh7a0496;
    }

    public String getNh7a0496x() {
        return nh7a0496x;
    }

    public void setNh7a0496x(String nh7a0496x) {
        this.nh7a0496x = nh7a0496x;
    }

    public String getNh7a05() {
        return nh7a05;
    }

    public void setNh7a05(String nh7a05) {
        this.nh7a05 = nh7a05;
    }

    public String getNh7a06() {
        return nh7a06;
    }

    public void setNh7a06(String nh7a06) {
        this.nh7a06 = nh7a06;
    }
}
