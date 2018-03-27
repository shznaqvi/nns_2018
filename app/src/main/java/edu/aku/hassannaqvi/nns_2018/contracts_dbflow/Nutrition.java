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
public class Nutrition extends BaseModel {
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

    // JSON

    @Column
    private String nw501a;
    @Column
    private String nw501b;
    @Column
    private String nw501c;
    @Column
    private String nw501d;
    @Column
    private String nw501e;
    @Column
    private String nw501f;
    @Column
    private String nw501g;
    @Column
    private String nw501h;
    @Column
    private String nw501i;
    @Column
    private String nw501j;


    public String getNw501a() {
        return nw501a;
    }

    public void setNw501a(String nw501a) {
        this.nw501a = nw501a;
    }

    public String getNw501b() {
        return nw501b;
    }

    public void setNw501b(String nw501b) {
        this.nw501b = nw501b;
    }

    public String getNw501c() {
        return nw501c;
    }

    public void setNw501c(String nw501c) {
        this.nw501c = nw501c;
    }

    public String getNw501d() {
        return nw501d;
    }

    public void setNw501d(String nw501d) {
        this.nw501d = nw501d;
    }

    public String getNw501e() {
        return nw501e;
    }

    public void setNw501e(String nw501e) {
        this.nw501e = nw501e;
    }

    public String getNw501f() {
        return nw501f;
    }

    public void setNw501f(String nw501f) {
        this.nw501f = nw501f;
    }

    public String getNw501g() {
        return nw501g;
    }

    public void setNw501g(String nw501g) {
        this.nw501g = nw501g;
    }

    public String getNw501h() {
        return nw501h;
    }

    public void setNw501h(String nw501h) {
        this.nw501h = nw501h;
    }

    public String getNw501i() {
        return nw501i;
    }

    public void setNw501i(String nw501i) {
        this.nw501i = nw501i;
    }

    public String getNw501j() {
        return nw501j;
    }

    public void setNw501j(String nw501j) {
        this.nw501j = nw501j;
    }
}
