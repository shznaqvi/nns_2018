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
public class MWRA extends BaseModel {

    public static String _URL = "wras.php";
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


    //B1
    @Column
    private String nw101;
    @Column
    private String nw1serialno;
    @Column
    private String nw201days;
    @Column
    private String nw201months;
    @Column
    private String nw201years;
    @Column
    private String nw202;
    @Column
    private String nw203;
    @Column
    private String nw204;
    @Column
    private String nw205;
    @Column
    private String nw206;
    @Column
    private String nw207;
    @Column
    private String nw208;
    @Column
    private String nw209;
    @Column
    private String nw209a;
    @Column
    private String nw210;
    @Column
    private String nw211;
    @Column
    private String nw212;
    @Column
    private String nw21301;
    @Column
    private String nw21302;
    @Column
    private String nw21303;
    @Column
    private String nw21398;
    @Column
    private String nw21399;

    //SB2
    @Column
    private String nw301;
    @Column
    private String nw302a;
    @Column
    private String nw302b;
    @Column
    private String nw302c;
    @Column
    private String nw302d;
    @Column
    private String nw302e;
    @Column
    private String nw302f;
    @Column
    private String nw302g;
    @Column
    private String nw302h;
    @Column
    private String nw30296;
    @Column
    private String nw30296x;
    @Column
    private String nw303;
    @Column
    private String nw303961x;
    @Column
    private String nw303962x;
    @Column
    private String nw303963x;
    @Column
    private String nw304;
    @Column
    private String nw30498;
    @Column
    private String nw305;
    @Column
    private String nw30598;
    @Column
    private String nw306a;
    @Column
    private String nw306b;
    @Column
    private String nw306c;
    @Column
    private String nw306d;
    @Column
    private String nw306e;
    @Column
    private String nw306f;
    @Column
    private String nw306g;
    @Column
    private String nw306h;
    @Column
    private String nw306i;
    @Column
    private String nw30696;
    @Column
    private String nw30696x;
    @Column
    private String nw307;
    @Column
    private String nw308;
    @Column
    private String nw309;
    @Column
    private String nw310;
    @Column
    private String nw311;
    @Column
    private String nw31196x;
    @Column
    private String nw312a;
    @Column
    private String nw312b;
    @Column
    private String nw312c;
    @Column
    private String nw312d;
    @Column
    private String nw312e;
    @Column
    private String nw312f;
    @Column
    private String nw312g;
    @Column
    private String nw312h;
    @Column
    private String nw312i;
    @Column
    private String nw312j;
    @Column
    private String nw312k;
    @Column
    private String nw312l;
    @Column
    private String nw312m;
    @Column
    private String nw312961;
    @Column
    private String nw312962;
    @Column
    private String nw312963;
    @Column
    private String nw312961x;
    @Column
    private String nw312962x;
    @Column
    private String nw312963x;
    @Column
    private String nw313;
    @Column
    private String nw314m;
    @Column
    private String nw314d;
    @Column
    private String nw315;
    @Column
    private String nw316;
    @Column
    private String nw31696x;
    @Column
    private String nw317a;
    @Column
    private String nw317b;
    @Column
    private String nw317c;
    @Column
    private String nw317d;
    @Column
    private String nw317e;
    @Column
    private String nw317f;
    @Column
    private String nw317g;
    @Column
    private String nw317h;
    @Column
    private String nw317i;
    @Column
    private String nw317j;
    @Column
    private String nw317k;
    @Column
    private String nw317l;
    @Column
    private String nw317m;
    @Column
    private String nw317961;
    @Column
    private String nw317962;
    @Column
    private String nw317963;
    @Column
    private String nw317961x;
    @Column
    private String nw317962x;
    @Column
    private String nw317963x;
    @Column
    private String nw318;
    @Column
    private String nw319m;
    @Column
    private String nw319d;
    @Column
    private String nw320;
    @Column
    private String nw321;
    @Column
    private String nw32196x;
    @Column
    private String nw322a;
    @Column
    private String nw322b;
    @Column
    private String nw322c;
    @Column
    private String nw322d;
    @Column
    private String nw322e;
    @Column
    private String nw322f;
    @Column
    private String nw322g;
    @Column
    private String nw322h;
    @Column
    private String nw322i;
    @Column
    private String nw322j;
    @Column
    private String nw322k;
    @Column
    private String nw322l;
    @Column
    private String nw322m;
    @Column
    private String nw322961;
    @Column
    private String nw322962;
    @Column
    private String nw322963;
    @Column
    private String nw322961x;
    @Column
    private String nw322962x;
    @Column
    private String nw322963x;
    @Column
    private String nw323;
    @Column
    private String nw324m;
    @Column
    private String nw324d;
    @Column
    private String nw325;
    @Column
    private String nw326;
    // SB3
    @Column
    private String nw327;
    @Column
    private String nw327m;
    @Column
    private String nw327d;
    @Column
    private String nw328;
    @Column
    private String nw32896x;
    @Column
    private String nw329a;
    @Column
    private String nw329b;
    @Column
    private String nw329c;
    @Column
    private String nw329d;
    @Column
    private String nw329e;
    @Column
    private String nw329f;
    @Column
    private String nw329g;
    @Column
    private String nw329h;
    @Column
    private String nw330;
    @Column
    private String nw331;
    @Column
    private String nw332;
    // SB4
    @Column
    private String nw401;
    @Column
    private String nw40196x;
    @Column
    private String nw402a;
    @Column
    private String nw402b;
    @Column
    private String nw402c;
    @Column
    private String nw402d;
    @Column
    private String nw402e;
    @Column
    private String nw402f;
    @Column
    private String nw402g;
    @Column
    private String nw402h;
    @Column
    private String nw40299;
    @Column
    private String nw40296;
    @Column
    private String nw40296x;
    @Column
    private String nw403;
    @Column
    private String nw403fx;
    @Column
    private String nw403jx;
    @Column
    private String nw40396x;
    @Column
    private String nw404;
    @Column
    private String nw405;
    @Column
    private String nw406c;
    @Column
    private String nw406r;
    @Column
    private String nw40698;
    @Column
    private String nw407;
    @Column
    private String nw408;
    @Column
    private String nw409;
    @Column
    private String nw410h;
    @Column
    private String nw410d;
    @Column
    private String nw410;
    @Column
    private String nw411;
    @Column
    private String nw412a;
    @Column
    private String nw412b;
    @Column
    private String nw412c;
    @Column
    private String nw412d;
    @Column
    private String nw412e;
    @Column
    private String nw412f;
    @Column
    private String nw41298;
    @Column
    private String nw41296;
    @Column
    private String nw41296x;
    @Column
    private String nw413;
    // SB5
    @Column
    private String nw414;
    @Column
    private String nw415a;
    @Column
    private String nw415b;
    @Column
    private String nw415c;
    @Column
    private String nw415d;
    @Column
    private String nw415e;
    @Column
    private String nw415f;
    @Column
    private String nw415g;
    @Column
    private String nw41596;
    @Column
    private String nw41596x;
    @Column
    private String nw416;
    @Column
    private String nw416hr;
    @Column
    private String nw416d;
    @Column
    private String nw416w;
    @Column
    private String nw417;
    @Column
    private String nw418a;
    @Column
    private String nw418b;
    @Column
    private String nw418c;
    @Column
    private String nw418d;
    @Column
    private String nw418e;
    @Column
    private String nw418f;
    @Column
    private String nw418g;
    @Column
    private String nw418h;
    @Column
    private String nw41896;
    @Column
    private String nw41896x;
    @Column
    private String nw419;
    @Column
    private String nw420a;
    @Column
    private String nw420b;
    @Column
    private String nw420c;
    @Column
    private String nw420d;
    @Column
    private String nw420e;
    @Column
    private String nw420f;
    @Column
    private String nw420g;
    @Column
    private String nw42096;
    @Column
    private String nw42096x;
    @Column
    private String nw421;
    @Column
    private String nw421hr;
    @Column
    private String nw421d;
    @Column
    private String nw421w;
    @Column
    private String nw422;
    @Column
    private String nw423a;
    @Column
    private String nw423b;
    @Column
    private String nw423c;
    @Column
    private String nw423d;
    @Column
    private String nw423e;
    @Column
    private String nw42396;
    @Column
    private String nw42396x;
    @Column
    private String B1SerialNo;

    public static MWRA Sync(JSONObject jsonObject) {

        Gson gson = new GsonBuilder().create();
        MWRA mwraobj = gson.fromJson(jsonObject.toString(), MWRA.class);
        return mwraobj;

    }

    public String getNw313() {
        return nw313;
    }

    public void setNw313(String nw313) {
        this.nw313 = nw313;
    }

    public String getNw31696x() {
        return nw31696x;
    }

    public void setNw31696x(String nw31696x) {
        this.nw31696x = nw31696x;
    }

    public String getB1SerialNo() {
        return B1SerialNo;
    }

    public void setB1SerialNo(String b1SerialNo) {
        B1SerialNo = b1SerialNo;
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

    public String getNw101() {
        return nw101;
    }

    public void setNw101(String nw101) {
        this.nw101 = nw101;
    }

    public String getNw1serialno() {
        return nw1serialno;
    }

    public void setNw1serialno(String nw1serialno) {
        this.nw1serialno = nw1serialno;
    }

    public String getNw201days() {
        return nw201days;
    }

    public void setNw201days(String nw201days) {
        this.nw201days = nw201days;
    }

    public String getNw201months() {
        return nw201months;
    }

    public void setNw201months(String nw201months) {
        this.nw201months = nw201months;
    }

    public String getNw201years() {
        return nw201years;
    }

    public void setNw201years(String nw201years) {
        this.nw201years = nw201years;
    }

    public String getNw202() {
        return nw202;
    }

    public void setNw202(String nw202) {
        this.nw202 = nw202;
    }

    public String getNw203() {
        return nw203;
    }

    public void setNw203(String nw203) {
        this.nw203 = nw203;
    }

    public String getNw204() {
        return nw204;
    }

    public void setNw204(String nw204) {
        this.nw204 = nw204;
    }

    public String getNw205() {
        return nw205;
    }

    public void setNw205(String nw205) {
        this.nw205 = nw205;
    }

    public String getNw206() {
        return nw206;
    }

    public void setNw206(String nw206) {
        this.nw206 = nw206;
    }

    public String getNw207() {
        return nw207;
    }

    public void setNw207(String nw207) {
        this.nw207 = nw207;
    }

    public String getNw208() {
        return nw208;
    }

    public void setNw208(String nw208) {
        this.nw208 = nw208;
    }

    public String getNw209() {
        return nw209;
    }

    public void setNw209(String nw209) {
        this.nw209 = nw209;
    }

    public String getNw209a() {
        return nw209a;
    }

    public void setNw209a(String nw209a) {
        this.nw209a = nw209a;
    }

    public String getNw210() {
        return nw210;
    }

    public void setNw210(String nw210) {
        this.nw210 = nw210;
    }

    public String getNw211() {
        return nw211;
    }

    public void setNw211(String nw211) {
        this.nw211 = nw211;
    }

    public String getNw212() {
        return nw212;
    }

    public void setNw212(String nw212) {
        this.nw212 = nw212;
    }

    public String getNw21301() {
        return nw21301;
    }

    public void setNw21301(String nw21301) {
        this.nw21301 = nw21301;
    }

    public String getNw21302() {
        return nw21302;
    }

    public void setNw21302(String nw21302) {
        this.nw21302 = nw21302;
    }

    public String getNw21303() {
        return nw21303;
    }

    public void setNw21303(String nw21303) {
        this.nw21303 = nw21303;
    }

    public String getNw21398() {
        return nw21398;
    }

    public void setNw21398(String nw21398) {
        this.nw21398 = nw21398;
    }

    public String getNw21399() {
        return nw21399;
    }

    public void setNw21399(String nw21399) {
        this.nw21399 = nw21399;
    }

    public String getNw301() {
        return nw301;
    }

    public void setNw301(String nw301) {
        this.nw301 = nw301;
    }

    public String getNw302a() {
        return nw302a;
    }

    public void setNw302a(String nw302a) {
        this.nw302a = nw302a;
    }

    public String getNw302b() {
        return nw302b;
    }

    public void setNw302b(String nw302b) {
        this.nw302b = nw302b;
    }

    public String getNw302c() {
        return nw302c;
    }

    public void setNw302c(String nw302c) {
        this.nw302c = nw302c;
    }

    public String getNw302d() {
        return nw302d;
    }

    public void setNw302d(String nw302d) {
        this.nw302d = nw302d;
    }

    public String getNw302e() {
        return nw302e;
    }

    public void setNw302e(String nw302e) {
        this.nw302e = nw302e;
    }

    public String getNw302f() {
        return nw302f;
    }

    public void setNw302f(String nw302f) {
        this.nw302f = nw302f;
    }

    public String getNw302g() {
        return nw302g;
    }

    public void setNw302g(String nw302g) {
        this.nw302g = nw302g;
    }

    public String getNw302h() {
        return nw302h;
    }

    public void setNw302h(String nw302h) {
        this.nw302h = nw302h;
    }

    public String getNw30296() {
        return nw30296;
    }

    public void setNw30296(String nw30296) {
        this.nw30296 = nw30296;
    }

    public String getNw30296x() {
        return nw30296x;
    }

    public void setNw30296x(String nw30296x) {
        this.nw30296x = nw30296x;
    }

    public String getNw303() {
        return nw303;
    }

    public void setNw303(String nw303) {
        this.nw303 = nw303;
    }

    public String getNw303961x() {
        return nw303961x;
    }

    public void setNw303961x(String nw303961x) {
        this.nw303961x = nw303961x;
    }

    public String getNw303962x() {
        return nw303962x;
    }

    public void setNw303962x(String nw303962x) {
        this.nw303962x = nw303962x;
    }

    public String getNw303963x() {
        return nw303963x;
    }

    public void setNw303963x(String nw303963x) {
        this.nw303963x = nw303963x;
    }

    public String getNw304() {
        return nw304;
    }

    public void setNw304(String nw304) {
        this.nw304 = nw304;
    }

    public String getNw30498() {
        return nw30498;
    }

    public void setNw30498(String nw30498) {
        this.nw30498 = nw30498;
    }

    public String getNw305() {
        return nw305;
    }

    public void setNw305(String nw305) {
        this.nw305 = nw305;
    }

    public String getNw30598() {
        return nw30598;
    }

    public void setNw30598(String nw30598) {
        this.nw30598 = nw30598;
    }

    public String getNw306a() {
        return nw306a;
    }

    public void setNw306a(String nw306a) {
        this.nw306a = nw306a;
    }

    public String getNw306b() {
        return nw306b;
    }

    public void setNw306b(String nw306b) {
        this.nw306b = nw306b;
    }

    public String getNw306c() {
        return nw306c;
    }

    public void setNw306c(String nw306c) {
        this.nw306c = nw306c;
    }

    public String getNw306d() {
        return nw306d;
    }

    public void setNw306d(String nw306d) {
        this.nw306d = nw306d;
    }

    public String getNw306e() {
        return nw306e;
    }

    public void setNw306e(String nw306e) {
        this.nw306e = nw306e;
    }

    public String getNw306f() {
        return nw306f;
    }

    public void setNw306f(String nw306f) {
        this.nw306f = nw306f;
    }

    public String getNw306g() {
        return nw306g;
    }

    public void setNw306g(String nw306g) {
        this.nw306g = nw306g;
    }

    public String getNw306h() {
        return nw306h;
    }

    public void setNw306h(String nw306h) {
        this.nw306h = nw306h;
    }

    public String getNw306i() {
        return nw306i;
    }

    public void setNw306i(String nw306i) {
        this.nw306i = nw306i;
    }

    public String getNw30696() {
        return nw30696;
    }

    public void setNw30696(String nw30696) {
        this.nw30696 = nw30696;
    }

    public String getNw30696x() {
        return nw30696x;
    }

    public void setNw30696x(String nw30696x) {
        this.nw30696x = nw30696x;
    }

    public String getNw307() {
        return nw307;
    }

    public void setNw307(String nw307) {
        this.nw307 = nw307;
    }

    public String getNw308() {
        return nw308;
    }

    public void setNw308(String nw308) {
        this.nw308 = nw308;
    }

    public String getNw309() {
        return nw309;
    }

    public void setNw309(String nw309) {
        this.nw309 = nw309;
    }

    public String getNw310() {
        return nw310;
    }

    public void setNw310(String nw310) {
        this.nw310 = nw310;
    }

    public String getNw311() {
        return nw311;
    }

    public void setNw311(String nw311) {
        this.nw311 = nw311;
    }

    public String getNw31196x() {
        return nw31196x;
    }

    public void setNw31196x(String nw31196x) {
        this.nw31196x = nw31196x;
    }

    public String getNw312a() {
        return nw312a;
    }

    public void setNw312a(String nw312a) {
        this.nw312a = nw312a;
    }

    public String getNw312b() {
        return nw312b;
    }

    public void setNw312b(String nw312b) {
        this.nw312b = nw312b;
    }

    public String getNw312c() {
        return nw312c;
    }

    public void setNw312c(String nw312c) {
        this.nw312c = nw312c;
    }

    public String getNw312d() {
        return nw312d;
    }

    public void setNw312d(String nw312d) {
        this.nw312d = nw312d;
    }

    public String getNw312e() {
        return nw312e;
    }

    public void setNw312e(String nw312e) {
        this.nw312e = nw312e;
    }

    public String getNw312f() {
        return nw312f;
    }

    public void setNw312f(String nw312f) {
        this.nw312f = nw312f;
    }

    public String getNw312g() {
        return nw312g;
    }

    public void setNw312g(String nw312g) {
        this.nw312g = nw312g;
    }

    public String getNw312h() {
        return nw312h;
    }

    public void setNw312h(String nw312h) {
        this.nw312h = nw312h;
    }

    public String getNw312i() {
        return nw312i;
    }

    public void setNw312i(String nw312i) {
        this.nw312i = nw312i;
    }

    public String getNw312j() {
        return nw312j;
    }

    public void setNw312j(String nw312j) {
        this.nw312j = nw312j;
    }

    public String getNw312k() {
        return nw312k;
    }

    public void setNw312k(String nw312k) {
        this.nw312k = nw312k;
    }

    public String getNw312l() {
        return nw312l;
    }

    public void setNw312l(String nw312l) {
        this.nw312l = nw312l;
    }

    public String getNw312m() {
        return nw312m;
    }

    public void setNw312m(String nw312m) {
        this.nw312m = nw312m;
    }

    public String getNw312961() {
        return nw312961;
    }

    public void setNw312961(String nw312961) {
        this.nw312961 = nw312961;
    }

    public String getNw312962() {
        return nw312962;
    }

    public void setNw312962(String nw312962) {
        this.nw312962 = nw312962;
    }

    public String getNw312963() {
        return nw312963;
    }

    public void setNw312963(String nw312963) {
        this.nw312963 = nw312963;
    }

    public String getNw312961x() {
        return nw312961x;
    }

    public void setNw312961x(String nw312961x) {
        this.nw312961x = nw312961x;
    }

    public String getNw312962x() {
        return nw312962x;
    }

    public void setNw312962x(String nw312962x) {
        this.nw312962x = nw312962x;
    }

    public String getNw312963x() {
        return nw312963x;
    }

    public void setNw312963x(String nw312963x) {
        this.nw312963x = nw312963x;
    }

    public String getNw314m() {
        return nw314m;
    }

    public void setNw314m(String nw314m) {
        this.nw314m = nw314m;
    }

    public String getNw314d() {
        return nw314d;
    }

    public void setNw314d(String nw314d) {
        this.nw314d = nw314d;
    }

    public String getNw315() {
        return nw315;
    }

    public void setNw315(String nw315) {
        this.nw315 = nw315;
    }

    public String getNw316() {
        return nw316;
    }

    public void setNw316(String nw316) {
        this.nw316 = nw316;
    }

    public String getNw317a() {
        return nw317a;
    }

    public void setNw317a(String nw317a) {
        this.nw317a = nw317a;
    }

    public String getNw317b() {
        return nw317b;
    }

    public void setNw317b(String nw317b) {
        this.nw317b = nw317b;
    }

    public String getNw317c() {
        return nw317c;
    }

    public void setNw317c(String nw317c) {
        this.nw317c = nw317c;
    }

    public String getNw317d() {
        return nw317d;
    }

    public void setNw317d(String nw317d) {
        this.nw317d = nw317d;
    }

    public String getNw317e() {
        return nw317e;
    }

    public void setNw317e(String nw317e) {
        this.nw317e = nw317e;
    }

    public String getNw317f() {
        return nw317f;
    }

    public void setNw317f(String nw317f) {
        this.nw317f = nw317f;
    }

    public String getNw317g() {
        return nw317g;
    }

    public void setNw317g(String nw317g) {
        this.nw317g = nw317g;
    }

    public String getNw317h() {
        return nw317h;
    }

    public void setNw317h(String nw317h) {
        this.nw317h = nw317h;
    }

    public String getNw317i() {
        return nw317i;
    }

    public void setNw317i(String nw317i) {
        this.nw317i = nw317i;
    }

    public String getNw317j() {
        return nw317j;
    }

    public void setNw317j(String nw317j) {
        this.nw317j = nw317j;
    }

    public String getNw317k() {
        return nw317k;
    }

    public void setNw317k(String nw317k) {
        this.nw317k = nw317k;
    }

    public String getNw317l() {
        return nw317l;
    }

    public void setNw317l(String nw317l) {
        this.nw317l = nw317l;
    }

    public String getNw317m() {
        return nw317m;
    }

    public void setNw317m(String nw317m) {
        this.nw317m = nw317m;
    }

    public String getNw317961() {
        return nw317961;
    }

    public void setNw317961(String nw317961) {
        this.nw317961 = nw317961;
    }

    public String getNw317962() {
        return nw317962;
    }

    public void setNw317962(String nw317962) {
        this.nw317962 = nw317962;
    }

    public String getNw317963() {
        return nw317963;
    }

    public void setNw317963(String nw317963) {
        this.nw317963 = nw317963;
    }

    public String getNw317961x() {
        return nw317961x;
    }

    public void setNw317961x(String nw317961x) {
        this.nw317961x = nw317961x;
    }

    public String getNw317962x() {
        return nw317962x;
    }

    public void setNw317962x(String nw317962x) {
        this.nw317962x = nw317962x;
    }

    public String getNw317963x() {
        return nw317963x;
    }

    public void setNw317963x(String nw317963x) {
        this.nw317963x = nw317963x;
    }

    public String getNw318() {
        return nw318;
    }

    public void setNw318(String nw318) {
        this.nw318 = nw318;
    }

    public String getNw319m() {
        return nw319m;
    }

    public void setNw319m(String nw319m) {
        this.nw319m = nw319m;
    }

    public String getNw319d() {
        return nw319d;
    }

    public void setNw319d(String nw319d) {
        this.nw319d = nw319d;
    }

    public String getNw320() {
        return nw320;
    }

    public void setNw320(String nw320) {
        this.nw320 = nw320;
    }

    public String getNw321() {
        return nw321;
    }

    public void setNw321(String nw321) {
        this.nw321 = nw321;
    }

    public String getNw32196x() {
        return nw32196x;
    }

    public void setNw32196x(String nw32196x) {
        this.nw32196x = nw32196x;
    }

    public String getNw322a() {
        return nw322a;
    }

    public void setNw322a(String nw322a) {
        this.nw322a = nw322a;
    }

    public String getNw322b() {
        return nw322b;
    }

    public void setNw322b(String nw322b) {
        this.nw322b = nw322b;
    }

    public String getNw322c() {
        return nw322c;
    }

    public void setNw322c(String nw322c) {
        this.nw322c = nw322c;
    }

    public String getNw322d() {
        return nw322d;
    }

    public void setNw322d(String nw322d) {
        this.nw322d = nw322d;
    }

    public String getNw322e() {
        return nw322e;
    }

    public void setNw322e(String nw322e) {
        this.nw322e = nw322e;
    }

    public String getNw322f() {
        return nw322f;
    }

    public void setNw322f(String nw322f) {
        this.nw322f = nw322f;
    }

    public String getNw322g() {
        return nw322g;
    }

    public void setNw322g(String nw322g) {
        this.nw322g = nw322g;
    }

    public String getNw322h() {
        return nw322h;
    }

    public void setNw322h(String nw322h) {
        this.nw322h = nw322h;
    }

    public String getNw322i() {
        return nw322i;
    }

    public void setNw322i(String nw322i) {
        this.nw322i = nw322i;
    }

    public String getNw322j() {
        return nw322j;
    }

    public void setNw322j(String nw322j) {
        this.nw322j = nw322j;
    }

    public String getNw322k() {
        return nw322k;
    }

    public void setNw322k(String nw322k) {
        this.nw322k = nw322k;
    }

    public String getNw322l() {
        return nw322l;
    }

    public void setNw322l(String nw322l) {
        this.nw322l = nw322l;
    }

    public String getNw322m() {
        return nw322m;
    }

    public void setNw322m(String nw322m) {
        this.nw322m = nw322m;
    }

    public String getNw322961() {
        return nw322961;
    }

    public void setNw322961(String nw322961) {
        this.nw322961 = nw322961;
    }

    public String getNw322962() {
        return nw322962;
    }

    public void setNw322962(String nw322962) {
        this.nw322962 = nw322962;
    }

    public String getNw322963() {
        return nw322963;
    }

    public void setNw322963(String nw322963) {
        this.nw322963 = nw322963;
    }

    public String getNw322961x() {
        return nw322961x;
    }

    public void setNw322961x(String nw322961x) {
        this.nw322961x = nw322961x;
    }

    public String getNw322962x() {
        return nw322962x;
    }

    public void setNw322962x(String nw322962x) {
        this.nw322962x = nw322962x;
    }

    public String getNw322963x() {
        return nw322963x;
    }

    public void setNw322963x(String nw322963x) {
        this.nw322963x = nw322963x;
    }

    public String getNw323() {
        return nw323;
    }

    public void setNw323(String nw323) {
        this.nw323 = nw323;
    }

    public String getNw324m() {
        return nw324m;
    }

    public void setNw324m(String nw324m) {
        this.nw324m = nw324m;
    }

    public String getNw324d() {
        return nw324d;
    }

    public void setNw324d(String nw324d) {
        this.nw324d = nw324d;
    }

    public String getNw325() {
        return nw325;
    }

    public void setNw325(String nw325) {
        this.nw325 = nw325;
    }

    public String getNw326() {
        return nw326;
    }

    public void setNw326(String nw326) {
        this.nw326 = nw326;
    }

    public String getNw327() {
        return nw327;
    }

    public void setNw327(String nw327) {
        this.nw327 = nw327;
    }

    public String getNw327m() {
        return nw327m;
    }

    public void setNw327m(String nw327m) {
        this.nw327m = nw327m;
    }

    public String getNw327d() {
        return nw327d;
    }

    public void setNw327d(String nw327d) {
        this.nw327d = nw327d;
    }

    public String getNw328() {
        return nw328;
    }

    public void setNw328(String nw328) {
        this.nw328 = nw328;
    }

    public String getNw32896x() {
        return nw32896x;
    }

    public void setNw32896x(String nw32896x) {
        this.nw32896x = nw32896x;
    }

    public String getNw329a() {
        return nw329a;
    }

    public void setNw329a(String nw329a) {
        this.nw329a = nw329a;
    }

    public String getNw329b() {
        return nw329b;
    }

    public void setNw329b(String nw329b) {
        this.nw329b = nw329b;
    }

    public String getNw329c() {
        return nw329c;
    }

    public void setNw329c(String nw329c) {
        this.nw329c = nw329c;
    }

    public String getNw329d() {
        return nw329d;
    }

    public void setNw329d(String nw329d) {
        this.nw329d = nw329d;
    }

    public String getNw329e() {
        return nw329e;
    }

    public void setNw329e(String nw329e) {
        this.nw329e = nw329e;
    }

    public String getNw329f() {
        return nw329f;
    }

    public void setNw329f(String nw329f) {
        this.nw329f = nw329f;
    }

    public String getNw329g() {
        return nw329g;
    }

    public void setNw329g(String nw329g) {
        this.nw329g = nw329g;
    }

    public String getNw329h() {
        return nw329h;
    }

    public void setNw329h(String nw329h) {
        this.nw329h = nw329h;
    }

    public String getNw330() {
        return nw330;
    }

    public void setNw330(String nw330) {
        this.nw330 = nw330;
    }

    public String getNw331() {
        return nw331;
    }

    public void setNw331(String nw331) {
        this.nw331 = nw331;
    }

    public String getNw332() {
        return nw332;
    }

    public void setNw332(String nw332) {
        this.nw332 = nw332;
    }

    public String getNw401() {
        return nw401;
    }

    public void setNw401(String nw401) {
        this.nw401 = nw401;
    }

    public String getNw40196x() {
        return nw40196x;
    }

    public void setNw40196x(String nw40196x) {
        this.nw40196x = nw40196x;
    }

    public String getNw402a() {
        return nw402a;
    }

    public void setNw402a(String nw402a) {
        this.nw402a = nw402a;
    }

    public String getNw402b() {
        return nw402b;
    }

    public void setNw402b(String nw402b) {
        this.nw402b = nw402b;
    }

    public String getNw402c() {
        return nw402c;
    }

    public void setNw402c(String nw402c) {
        this.nw402c = nw402c;
    }

    public String getNw402d() {
        return nw402d;
    }

    public void setNw402d(String nw402d) {
        this.nw402d = nw402d;
    }

    public String getNw402e() {
        return nw402e;
    }

    public void setNw402e(String nw402e) {
        this.nw402e = nw402e;
    }

    public String getNw402f() {
        return nw402f;
    }

    public void setNw402f(String nw402f) {
        this.nw402f = nw402f;
    }

    public String getNw402g() {
        return nw402g;
    }

    public void setNw402g(String nw402g) {
        this.nw402g = nw402g;
    }

    public String getNw402h() {
        return nw402h;
    }

    public void setNw402h(String nw402h) {
        this.nw402h = nw402h;
    }

    public String getNw40299() {
        return nw40299;
    }

    public void setNw40299(String nw40299) {
        this.nw40299 = nw40299;
    }

    public String getNw40296() {
        return nw40296;
    }

    public void setNw40296(String nw40296) {
        this.nw40296 = nw40296;
    }

    public String getNw40296x() {
        return nw40296x;
    }

    public void setNw40296x(String nw40296x) {
        this.nw40296x = nw40296x;
    }

    public String getNw403() {
        return nw403;
    }

    public void setNw403(String nw403) {
        this.nw403 = nw403;
    }

    public String getNw403fx() {
        return nw403fx;
    }

    public void setNw403fx(String nw403fx) {
        this.nw403fx = nw403fx;
    }

    public String getNw403jx() {
        return nw403jx;
    }

    public void setNw403jx(String nw403jx) {
        this.nw403jx = nw403jx;
    }

    public String getNw40396x() {
        return nw40396x;
    }

    public void setNw40396x(String nw40396x) {
        this.nw40396x = nw40396x;
    }

    public String getNw404() {
        return nw404;
    }

    public void setNw404(String nw404) {
        this.nw404 = nw404;
    }

    public String getNw405() {
        return nw405;
    }

    public void setNw405(String nw405) {
        this.nw405 = nw405;
    }

    public String getNw406c() {
        return nw406c;
    }

    public void setNw406c(String nw406c) {
        this.nw406c = nw406c;
    }

    public String getNw406r() {
        return nw406r;
    }

    public void setNw406r(String nw406r) {
        this.nw406r = nw406r;
    }

    public String getNw40698() {
        return nw40698;
    }

    public void setNw40698(String nw40698) {
        this.nw40698 = nw40698;
    }

    public String getNw407() {
        return nw407;
    }

    public void setNw407(String nw407) {
        this.nw407 = nw407;
    }

    public String getNw408() {
        return nw408;
    }

    public void setNw408(String nw408) {
        this.nw408 = nw408;
    }

    public String getNw409() {
        return nw409;
    }

    public void setNw409(String nw409) {
        this.nw409 = nw409;
    }

    public String getNw410h() {
        return nw410h;
    }

    public void setNw410h(String nw410h) {
        this.nw410h = nw410h;
    }

    public String getNw410d() {
        return nw410d;
    }

    public void setNw410d(String nw410d) {
        this.nw410d = nw410d;
    }

    public String getNw410() {
        return nw410;
    }

    public void setNw410(String nw410) {
        this.nw410 = nw410;
    }

    public String getNw411() {
        return nw411;
    }

    public void setNw411(String nw411) {
        this.nw411 = nw411;
    }

    public String getNw412a() {
        return nw412a;
    }

    public void setNw412a(String nw412a) {
        this.nw412a = nw412a;
    }

    public String getNw412b() {
        return nw412b;
    }

    public void setNw412b(String nw412b) {
        this.nw412b = nw412b;
    }

    public String getNw412c() {
        return nw412c;
    }

    public void setNw412c(String nw412c) {
        this.nw412c = nw412c;
    }

    public String getNw412d() {
        return nw412d;
    }

    public void setNw412d(String nw412d) {
        this.nw412d = nw412d;
    }

    public String getNw412e() {
        return nw412e;
    }

    public void setNw412e(String nw412e) {
        this.nw412e = nw412e;
    }

    public String getNw412f() {
        return nw412f;
    }

    public void setNw412f(String nw412f) {
        this.nw412f = nw412f;
    }

    public String getNw41298() {
        return nw41298;
    }

    public void setNw41298(String nw41298) {
        this.nw41298 = nw41298;
    }

    public String getNw41296() {
        return nw41296;
    }

    public void setNw41296(String nw41296) {
        this.nw41296 = nw41296;
    }

    public String getNw41296x() {
        return nw41296x;
    }

    public void setNw41296x(String nw41296x) {
        this.nw41296x = nw41296x;
    }

    public String getNw413() {
        return nw413;
    }

    public void setNw413(String nw413) {
        this.nw413 = nw413;
    }

    public String getNw414() {
        return nw414;
    }

    public void setNw414(String nw414) {
        this.nw414 = nw414;
    }

    public String getNw415a() {
        return nw415a;
    }

    public void setNw415a(String nw415a) {
        this.nw415a = nw415a;
    }

    public String getNw415b() {
        return nw415b;
    }

    public void setNw415b(String nw415b) {
        this.nw415b = nw415b;
    }

    public String getNw415c() {
        return nw415c;
    }

    public void setNw415c(String nw415c) {
        this.nw415c = nw415c;
    }

    public String getNw415d() {
        return nw415d;
    }

    public void setNw415d(String nw415d) {
        this.nw415d = nw415d;
    }

    public String getNw415e() {
        return nw415e;
    }

    public void setNw415e(String nw415e) {
        this.nw415e = nw415e;
    }

    public String getNw415f() {
        return nw415f;
    }

    public void setNw415f(String nw415f) {
        this.nw415f = nw415f;
    }

    public String getNw415g() {
        return nw415g;
    }

    public void setNw415g(String nw415g) {
        this.nw415g = nw415g;
    }

    public String getNw41596() {
        return nw41596;
    }

    public void setNw41596(String nw41596) {
        this.nw41596 = nw41596;
    }

    public String getNw41596x() {
        return nw41596x;
    }

    public void setNw41596x(String nw41596x) {
        this.nw41596x = nw41596x;
    }

    public String getNw416() {
        return nw416;
    }

    public void setNw416(String nw416) {
        this.nw416 = nw416;
    }

    public String getNw416hr() {
        return nw416hr;
    }

    public void setNw416hr(String nw416hr) {
        this.nw416hr = nw416hr;
    }

    public String getNw416d() {
        return nw416d;
    }

    public void setNw416d(String nw416d) {
        this.nw416d = nw416d;
    }

    public String getNw416w() {
        return nw416w;
    }

    public void setNw416w(String nw416w) {
        this.nw416w = nw416w;
    }

    public String getNw417() {
        return nw417;
    }

    public void setNw417(String nw417) {
        this.nw417 = nw417;
    }

    public String getNw418a() {
        return nw418a;
    }

    public void setNw418a(String nw418a) {
        this.nw418a = nw418a;
    }

    public String getNw418b() {
        return nw418b;
    }

    public void setNw418b(String nw418b) {
        this.nw418b = nw418b;
    }

    public String getNw418c() {
        return nw418c;
    }

    public void setNw418c(String nw418c) {
        this.nw418c = nw418c;
    }

    public String getNw418d() {
        return nw418d;
    }

    public void setNw418d(String nw418d) {
        this.nw418d = nw418d;
    }

    public String getNw418e() {
        return nw418e;
    }

    public void setNw418e(String nw418e) {
        this.nw418e = nw418e;
    }

    public String getNw418f() {
        return nw418f;
    }

    public void setNw418f(String nw418f) {
        this.nw418f = nw418f;
    }

    public String getNw418g() {
        return nw418g;
    }

    public void setNw418g(String nw418g) {
        this.nw418g = nw418g;
    }

    public String getNw418h() {
        return nw418h;
    }

    public void setNw418h(String nw418h) {
        this.nw418h = nw418h;
    }

    public String getNw41896() {
        return nw41896;
    }

    public void setNw41896(String nw41896) {
        this.nw41896 = nw41896;
    }

    public String getNw41896x() {
        return nw41896x;
    }

    public void setNw41896x(String nw41896x) {
        this.nw41896x = nw41896x;
    }

    public String getNw419() {
        return nw419;
    }

    public void setNw419(String nw419) {
        this.nw419 = nw419;
    }

    public String getNw420a() {
        return nw420a;
    }

    public void setNw420a(String nw420a) {
        this.nw420a = nw420a;
    }

    public String getNw420b() {
        return nw420b;
    }

    public void setNw420b(String nw420b) {
        this.nw420b = nw420b;
    }

    public String getNw420c() {
        return nw420c;
    }

    public void setNw420c(String nw420c) {
        this.nw420c = nw420c;
    }

    public String getNw420d() {
        return nw420d;
    }

    public void setNw420d(String nw420d) {
        this.nw420d = nw420d;
    }

    public String getNw420e() {
        return nw420e;
    }

    public void setNw420e(String nw420e) {
        this.nw420e = nw420e;
    }

    public String getNw420f() {
        return nw420f;
    }

    public void setNw420f(String nw420f) {
        this.nw420f = nw420f;
    }

    public String getNw420g() {
        return nw420g;
    }

    public void setNw420g(String nw420g) {
        this.nw420g = nw420g;
    }

    public String getNw42096() {
        return nw42096;
    }

    public void setNw42096(String nw42096) {
        this.nw42096 = nw42096;
    }

    public String getNw42096x() {
        return nw42096x;
    }

    public void setNw42096x(String nw42096x) {
        this.nw42096x = nw42096x;
    }

    public String getNw421() {
        return nw421;
    }

    public void setNw421(String nw421) {
        this.nw421 = nw421;
    }

    public String getNw421hr() {
        return nw421hr;
    }

    public void setNw421hr(String nw421hr) {
        this.nw421hr = nw421hr;
    }

    public String getNw421d() {
        return nw421d;
    }

    public void setNw421d(String nw421d) {
        this.nw421d = nw421d;
    }

    public String getNw421w() {
        return nw421w;
    }

    public void setNw421w(String nw421w) {
        this.nw421w = nw421w;
    }

    public String getNw422() {
        return nw422;
    }

    public void setNw422(String nw422) {
        this.nw422 = nw422;
    }

    public String getNw423a() {
        return nw423a;
    }

    public void setNw423a(String nw423a) {
        this.nw423a = nw423a;
    }

    public String getNw423b() {
        return nw423b;
    }

    public void setNw423b(String nw423b) {
        this.nw423b = nw423b;
    }

    public String getNw423c() {
        return nw423c;
    }

    public void setNw423c(String nw423c) {
        this.nw423c = nw423c;
    }

    public String getNw423d() {
        return nw423d;
    }

    public void setNw423d(String nw423d) {
        this.nw423d = nw423d;
    }

    public String getNw423e() {
        return nw423e;
    }

    public void setNw423e(String nw423e) {
        this.nw423e = nw423e;
    }

    public String getNw42396() {
        return nw42396;
    }

    public void setNw42396(String nw42396) {
        this.nw42396 = nw42396;
    }

    public String getNw42396x() {
        return nw42396x;
    }

    public void setNw42396x(String nw42396x) {
        this.nw42396x = nw42396x;
    }

    // JSON
    public JSONObject toJSONObject() throws JSONException {

        Gson gson = new GsonBuilder().create();
        JSONObject json = new JSONObject(gson.toJson(this, MWRA.class));
        return json;
    }
}
