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
public class Child extends BaseModel {
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
    private String respName;
    @Column
    private String respSerial;
    @Column
    private String nc101;
    @Column
    private String nc201d;
    @Column
    private String nc201m;
    @Column
    private String nc201y;
    @Column
    private String nc202;
    @Column
    private String nc203;
    @Column
    private String nc204a;
    @Column
    private String nc204b;
    @Column
    private String nc205;

//    C2

    @Column
    private String nc2_child_name;
    @Column
    private String nc2_line_noSerial;
    @Column
    private String nc206;
    @Column
    private String nc207;
    @Column
    private String nc207h;
    @Column
    private String nc207d;
    @Column
    private String nc208;
    @Column
    private String nc209;
    @Column
    private String nc20996x;
    @Column
    private String nc210;
    @Column
    private String nc211;
    @Column
    private String nc21196x;
    @Column
    private String nc212;
    @Column
    private String nc212a;
    @Column
    private String nc213;
    @Column
    private String nc214;
    @Column
    private String nc215a;
    @Column
    private String nc215b;

    @Column
    private String nc215bx;

    @Column
    private String nc215c;

    @Column
    private String nc215cx;

    @Column
    private String nc215d;
    @Column
    private String nc215e;
    @Column
    private String nc215f;
    @Column
    private String nc215g;
    @Column
    private String nc215h;
    @Column
    private String nc215i;
    @Column
    private String nc217a;
    @Column
    private String nc217b;
    @Column
    private String nc217c;
    @Column
    private String nc217d;
    @Column
    private String nc217e;
    @Column
    private String nc217f;
    @Column
    private String nc217g;
    @Column
    private String nc217h;
    @Column
    private String nc217i;
    @Column
    private String nc217j;
    @Column
    private String nc217k;
    @Column
    private String nc217l;
    @Column
    private String nc217m;
    @Column
    private String nc217n;
    @Column
    private String nc217o;
    @Column
    private String nc217p;
    @Column
    private String nc217q;
    @Column
    private String nc218;
    @Column
    private String nc219;
    @Column
    private String nc220;
    @Column
    private String nc221;
    @Column
    private String nc22196x;
    @Column
    private String nc222;
    @Column
    private String nc22296x;
    @Column
    private String nc223;


//    C3

    @Column
    private String nc3name;
    @Column
    private String nc300Serial;
    @Column
    private String nc302;
    @Column
    private String nc303;
    @Column
    private String nc3bcg;
    @Column
    private String nc3bcgd;
    @Column
    private String nc3bcgm;
    @Column
    private String nc3bcgy;
    @Column
    private String nc3opv0;
    @Column
    private String nc3opv0d;
    @Column
    private String nc3opv0m;
    @Column
    private String nc3opv0y;
    @Column
    private String nc3opv1;
    @Column
    private String nc3opv1d;
    @Column
    private String nc3opv1m;
    @Column
    private String nc3opv1y;
    @Column
    private String nc3p1;
    @Column
    private String nc3p1d;
    @Column
    private String nc3p1m;
    @Column
    private String nc3p1y;
    @Column
    private String nc3pcv1;
    @Column
    private String nc3pcv1d;
    @Column
    private String nc3pcv1m;
    @Column
    private String nc3pcv1y;
    @Column
    private String nc3opv2;
    @Column
    private String nc3opv2d;
    @Column
    private String nc3opv2m;
    @Column
    private String nc3opv2y;
    @Column
    private String nc3p2;
    @Column
    private String nc3p2d;
    @Column
    private String nc3p2m;
    @Column
    private String nc3p2y;
    @Column
    private String nc3pcv2;
    @Column
    private String nc3pcv2d;
    @Column
    private String nc3pcv2m;
    @Column
    private String nc3pcv2y;
    @Column
    private String nc3opv3;
    @Column
    private String nc3opv3d;
    @Column
    private String nc3opv3m;
    @Column
    private String nc3opv3y;
    @Column
    private String nc3p3;
    @Column
    private String nc3p3d;
    @Column
    private String nc3p3m;
    @Column
    private String nc3p3y;
    @Column
    private String nc3pcv3;
    @Column
    private String nc3pcv3b;
    @Column
    private String nc3pcv3d;
    @Column
    private String nc3pcv3m;
    @Column
    private String nc3pcv3y;
    @Column
    private String nc3ipv;
    @Column
    private String nc3ipvd;
    @Column
    private String nc3ipvm;
    @Column
    private String nc3ipvy;

    @Column
    private String nc3m1;
    @Column
    private String nc3m1d;
    @Column
    private String nc3m1m;
    @Column
    private String nc3m1y;
    @Column
    private String nc3m2;
    @Column
    private String nc3m2d;
    @Column
    private String nc3m2m;
    @Column
    private String nc3m2y;
    @Column
    private String nc305;
    @Column
    private String nc306;
    @Column
    private String nc307;
    @Column
    private String nc308;
    @Column
    private String nc309;
    @Column
    private String nc310;
    @Column
    private String nc311;
    @Column
    private String nc312;
    @Column
    private String nc313;
    @Column
    private String nc314;
    @Column
    private String nc315;
    @Column
    private String nc316;


//    C4

    @Column
    private String nc4name;
    @Column
    private String nc402Serial;
    @Column
    private String nc401;
    @Column
    private String nc402;
    @Column
    private String nc403;
    @Column
    private String nc4039601x;
    @Column
    private String nc4039602x;
    @Column
    private String nc4039603x;
    @Column
    private String nc404a;
    @Column
    private String nc404b;
    @Column
    private String nc404c;
    @Column
    private String nc404d;
    @Column
    private String nc404e;
    @Column
    private String nc404f;
    @Column
    private String nc404g;
    @Column
    private String nc404h;
    @Column
    private String nc404i;
    @Column
    private String nc404j;
    @Column
    private String nc40496;
    @Column
    private String nc40496x;
    @Column
    private String nc405;
    @Column
    private String nc406;
    @Column
    private String nc407;
    @Column
    private String nc4079601x;
    @Column
    private String nc4079602x;
    @Column
    private String nc4079603x;
    @Column
    private String nc408a;
    @Column
    private String nc408b;
    @Column
    private String nc408c;
    @Column
    private String nc408d;
    @Column
    private String nc408e;
    @Column
    private String nc408f;
    @Column
    private String nc408g;
    @Column
    private String nc408h;
    @Column
    private String nc408i;
    @Column
    private String nc4089601;
    @Column
    private String nc4089601x;
    @Column
    private String nc409;
    @Column
    private String nc410;
    @Column
    private String nc411;
    @Column
    private String nc4119601x;
    @Column
    private String nc4119602x;
    @Column
    private String nc4119603x;
    @Column
    private String nc412a;
    @Column
    private String nc412b;
    @Column
    private String nc412c;
    @Column
    private String nc412d;
    @Column
    private String nc412e;
    @Column
    private String nc412f;
    @Column
    private String nc412g;
    @Column
    private String nc412h;
    @Column
    private String nc4129601;
    @Column
    private String nc4129601x;
    @Column
    private String nc413;
    @Column
    private String nc414;
    @Column
    private String nc415;
    @Column
    private String nc416;
    @Column
    private String nc417;
    @Column
    private String nc418;
    @Column
    private String nc419;
    @Column
    private String nc420m;
    @Column
    private String nc420d;
    @Column
    private String nc501name;
    @Column
    private String nc501;
    @Column
    private String nc502Serial;
    @Column
    private String nc502;
    @Column
    private String nc503;
    @Column
    private String nc504;
    @Column
    private String nc505;
    @Column
    private String nc506;

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

    public String getRespName() {
        return respName;
    }

    public void setRespName(String respName) {
        this.respName = respName;
    }

    public String getRespSerial() {
        return respSerial;
    }

    public void setRespSerial(String respSerial) {
        this.respSerial = respSerial;
    }

    public String getNc101() {
        return nc101;
    }

    public void setNc101(String nc101) {
        this.nc101 = nc101;
    }

    public String getNc201d() {
        return nc201d;
    }

    public void setNc201d(String nc201d) {
        this.nc201d = nc201d;
    }

    public String getNc201m() {
        return nc201m;
    }

    public void setNc201m(String nc201m) {
        this.nc201m = nc201m;
    }

    public String getNc201y() {
        return nc201y;
    }

    public void setNc201y(String nc201y) {
        this.nc201y = nc201y;
    }

    public String getNc202() {
        return nc202;
    }

    public void setNc202(String nc202) {
        this.nc202 = nc202;
    }

    public String getNc203() {
        return nc203;
    }

    public void setNc203(String nc203) {
        this.nc203 = nc203;
    }

    public String getNc204a() {
        return nc204a;
    }

    public void setNc204a(String nc204a) {
        this.nc204a = nc204a;
    }

    public String getNc204b() {
        return nc204b;
    }

    public void setNc204b(String nc204b) {
        this.nc204b = nc204b;
    }

    public String getNc205() {
        return nc205;
    }

    public void setNc205(String nc205) {
        this.nc205 = nc205;
    }

    public String getNc2_child_name() {
        return nc2_child_name;
    }

    public void setNc2_child_name(String nc2_child_name) {
        this.nc2_child_name = nc2_child_name;
    }

    public String getNc2_line_noSerial() {
        return nc2_line_noSerial;
    }

    public void setNc2_line_noSerial(String nc2_line_noSerial) {
        this.nc2_line_noSerial = nc2_line_noSerial;
    }

    public String getNc206() {
        return nc206;
    }

    public void setNc206(String nc206) {
        this.nc206 = nc206;
    }

    public String getNc207() {
        return nc207;
    }

    public void setNc207(String nc207) {
        this.nc207 = nc207;
    }

    public String getNc207h() {
        return nc207h;
    }

    public void setNc207h(String nc207h) {
        this.nc207h = nc207h;
    }

    public String getNc207d() {
        return nc207d;
    }

    public void setNc207d(String nc207d) {
        this.nc207d = nc207d;
    }

    public String getNc208() {
        return nc208;
    }

    public void setNc208(String nc208) {
        this.nc208 = nc208;
    }

    public String getNc209() {
        return nc209;
    }

    public void setNc209(String nc209) {
        this.nc209 = nc209;
    }

    public String getNc20996x() {
        return nc20996x;
    }

    public void setNc20996x(String nc20996x) {
        this.nc20996x = nc20996x;
    }

    public String getNc210() {
        return nc210;
    }

    public void setNc210(String nc210) {
        this.nc210 = nc210;
    }

    public String getNc211() {
        return nc211;
    }

    public void setNc211(String nc211) {
        this.nc211 = nc211;
    }

    public String getNc21196x() {
        return nc21196x;
    }

    public void setNc21196x(String nc21196x) {
        this.nc21196x = nc21196x;
    }

    public String getNc212() {
        return nc212;
    }

    public void setNc212(String nc212) {
        this.nc212 = nc212;
    }

    public String getNc212a() {
        return nc212a;
    }

    public void setNc212a(String nc212a) {
        this.nc212a = nc212a;
    }

    public String getNc213() {
        return nc213;
    }

    public void setNc213(String nc213) {
        this.nc213 = nc213;
    }

    public String getNc214() {
        return nc214;
    }

    public void setNc214(String nc214) {
        this.nc214 = nc214;
    }

    public String getNc215a() {
        return nc215a;
    }

    public void setNc215a(String nc215a) {
        this.nc215a = nc215a;
    }

    public String getNc215b() {
        return nc215b;
    }

    public void setNc215b(String nc215b) {
        this.nc215b = nc215b;
    }

    public String getNc215bx() {
        return nc215bx;
    }

    public void setNc215bx(String nc215bx) {
        this.nc215bx = nc215bx;
    }

    public String getNc215c() {
        return nc215c;
    }

    public void setNc215c(String nc215c) {
        this.nc215c = nc215c;
    }

    public String getNc215cx() {
        return nc215cx;
    }

    public void setNc215cx(String nc215cx) {
        this.nc215cx = nc215cx;
    }

    public String getNc215d() {
        return nc215d;
    }

    public void setNc215d(String nc215d) {
        this.nc215d = nc215d;
    }

    public String getNc215e() {
        return nc215e;
    }

    public void setNc215e(String nc215e) {
        this.nc215e = nc215e;
    }

    public String getNc215f() {
        return nc215f;
    }

    public void setNc215f(String nc215f) {
        this.nc215f = nc215f;
    }

    public String getNc215g() {
        return nc215g;
    }

    public void setNc215g(String nc215g) {
        this.nc215g = nc215g;
    }

    public String getNc215h() {
        return nc215h;
    }

    public void setNc215h(String nc215h) {
        this.nc215h = nc215h;
    }

    public String getNc215i() {
        return nc215i;
    }

    public void setNc215i(String nc215i) {
        this.nc215i = nc215i;
    }

    public String getNc217a() {
        return nc217a;
    }

    public void setNc217a(String nc217a) {
        this.nc217a = nc217a;
    }

    public String getNc217b() {
        return nc217b;
    }

    public void setNc217b(String nc217b) {
        this.nc217b = nc217b;
    }

    public String getNc217c() {
        return nc217c;
    }

    public void setNc217c(String nc217c) {
        this.nc217c = nc217c;
    }

    public String getNc217d() {
        return nc217d;
    }

    public void setNc217d(String nc217d) {
        this.nc217d = nc217d;
    }

    public String getNc217e() {
        return nc217e;
    }

    public void setNc217e(String nc217e) {
        this.nc217e = nc217e;
    }

    public String getNc217f() {
        return nc217f;
    }

    public void setNc217f(String nc217f) {
        this.nc217f = nc217f;
    }

    public String getNc217g() {
        return nc217g;
    }

    public void setNc217g(String nc217g) {
        this.nc217g = nc217g;
    }

    public String getNc217h() {
        return nc217h;
    }

    public void setNc217h(String nc217h) {
        this.nc217h = nc217h;
    }

    public String getNc217i() {
        return nc217i;
    }

    public void setNc217i(String nc217i) {
        this.nc217i = nc217i;
    }

    public String getNc217j() {
        return nc217j;
    }

    public void setNc217j(String nc217j) {
        this.nc217j = nc217j;
    }

    public String getNc217k() {
        return nc217k;
    }

    public void setNc217k(String nc217k) {
        this.nc217k = nc217k;
    }

    public String getNc217l() {
        return nc217l;
    }

    public void setNc217l(String nc217l) {
        this.nc217l = nc217l;
    }

    public String getNc217m() {
        return nc217m;
    }

    public void setNc217m(String nc217m) {
        this.nc217m = nc217m;
    }

    public String getNc217n() {
        return nc217n;
    }

    public void setNc217n(String nc217n) {
        this.nc217n = nc217n;
    }

    public String getNc217o() {
        return nc217o;
    }

    public void setNc217o(String nc217o) {
        this.nc217o = nc217o;
    }

    public String getNc217p() {
        return nc217p;
    }

    public void setNc217p(String nc217p) {
        this.nc217p = nc217p;
    }

    public String getNc217q() {
        return nc217q;
    }

    public void setNc217q(String nc217q) {
        this.nc217q = nc217q;
    }

    public String getNc218() {
        return nc218;
    }

    public void setNc218(String nc218) {
        this.nc218 = nc218;
    }

    public String getNc219() {
        return nc219;
    }

    public void setNc219(String nc219) {
        this.nc219 = nc219;
    }

    public String getNc220() {
        return nc220;
    }

    public void setNc220(String nc220) {
        this.nc220 = nc220;
    }

    public String getNc221() {
        return nc221;
    }

    public void setNc221(String nc221) {
        this.nc221 = nc221;
    }

    public String getNc22196x() {
        return nc22196x;
    }

    public void setNc22196x(String nc22196x) {
        this.nc22196x = nc22196x;
    }

    public String getNc222() {
        return nc222;
    }

    public void setNc222(String nc222) {
        this.nc222 = nc222;
    }

    public String getNc22296x() {
        return nc22296x;
    }

    public void setNc22296x(String nc22296x) {
        this.nc22296x = nc22296x;
    }

    public String getNc223() {
        return nc223;
    }

    public void setNc223(String nc223) {
        this.nc223 = nc223;
    }

    public String getNc3name() {
        return nc3name;
    }

    public void setNc3name(String nc3name) {
        this.nc3name = nc3name;
    }

    public String getNc300Serial() {
        return nc300Serial;
    }

    public void setNc300Serial(String nc300Serial) {
        this.nc300Serial = nc300Serial;
    }

    public String getNc302() {
        return nc302;
    }

    public void setNc302(String nc302) {
        this.nc302 = nc302;
    }

    public String getNc303() {
        return nc303;
    }

    public void setNc303(String nc303) {
        this.nc303 = nc303;
    }

    public String getNc3bcg() {
        return nc3bcg;
    }

    public void setNc3bcg(String nc3bcg) {
        this.nc3bcg = nc3bcg;
    }

    public String getNc3bcgd() {
        return nc3bcgd;
    }

    public void setNc3bcgd(String nc3bcgd) {
        this.nc3bcgd = nc3bcgd;
    }

    public String getNc3bcgm() {
        return nc3bcgm;
    }

    public void setNc3bcgm(String nc3bcgm) {
        this.nc3bcgm = nc3bcgm;
    }

    public String getNc3bcgy() {
        return nc3bcgy;
    }

    public void setNc3bcgy(String nc3bcgy) {
        this.nc3bcgy = nc3bcgy;
    }

    public String getNc3opv0() {
        return nc3opv0;
    }

    public void setNc3opv0(String nc3opv0) {
        this.nc3opv0 = nc3opv0;
    }

    public String getNc3opv0d() {
        return nc3opv0d;
    }

    public void setNc3opv0d(String nc3opv0d) {
        this.nc3opv0d = nc3opv0d;
    }

    public String getNc3opv0m() {
        return nc3opv0m;
    }

    public void setNc3opv0m(String nc3opv0m) {
        this.nc3opv0m = nc3opv0m;
    }

    public String getNc3opv0y() {
        return nc3opv0y;
    }

    public void setNc3opv0y(String nc3opv0y) {
        this.nc3opv0y = nc3opv0y;
    }

    public String getNc3opv1() {
        return nc3opv1;
    }

    public void setNc3opv1(String nc3opv1) {
        this.nc3opv1 = nc3opv1;
    }

    public String getNc3opv1d() {
        return nc3opv1d;
    }

    public void setNc3opv1d(String nc3opv1d) {
        this.nc3opv1d = nc3opv1d;
    }

    public String getNc3opv1m() {
        return nc3opv1m;
    }

    public void setNc3opv1m(String nc3opv1m) {
        this.nc3opv1m = nc3opv1m;
    }

    public String getNc3opv1y() {
        return nc3opv1y;
    }

    public void setNc3opv1y(String nc3opv1y) {
        this.nc3opv1y = nc3opv1y;
    }

    public String getNc3p1() {
        return nc3p1;
    }

    public void setNc3p1(String nc3p1) {
        this.nc3p1 = nc3p1;
    }

    public String getNc3p1d() {
        return nc3p1d;
    }

    public void setNc3p1d(String nc3p1d) {
        this.nc3p1d = nc3p1d;
    }

    public String getNc3p1m() {
        return nc3p1m;
    }

    public void setNc3p1m(String nc3p1m) {
        this.nc3p1m = nc3p1m;
    }

    public String getNc3p1y() {
        return nc3p1y;
    }

    public void setNc3p1y(String nc3p1y) {
        this.nc3p1y = nc3p1y;
    }

    public String getNc3pcv1() {
        return nc3pcv1;
    }

    public void setNc3pcv1(String nc3pcv1) {
        this.nc3pcv1 = nc3pcv1;
    }

    public String getNc3pcv1d() {
        return nc3pcv1d;
    }

    public void setNc3pcv1d(String nc3pcv1d) {
        this.nc3pcv1d = nc3pcv1d;
    }

    public String getNc3pcv1m() {
        return nc3pcv1m;
    }

    public void setNc3pcv1m(String nc3pcv1m) {
        this.nc3pcv1m = nc3pcv1m;
    }

    public String getNc3pcv1y() {
        return nc3pcv1y;
    }

    public void setNc3pcv1y(String nc3pcv1y) {
        this.nc3pcv1y = nc3pcv1y;
    }

    public String getNc3opv2() {
        return nc3opv2;
    }

    public void setNc3opv2(String nc3opv2) {
        this.nc3opv2 = nc3opv2;
    }

    public String getNc3opv2d() {
        return nc3opv2d;
    }

    public void setNc3opv2d(String nc3opv2d) {
        this.nc3opv2d = nc3opv2d;
    }

    public String getNc3opv2m() {
        return nc3opv2m;
    }

    public void setNc3opv2m(String nc3opv2m) {
        this.nc3opv2m = nc3opv2m;
    }

    public String getNc3opv2y() {
        return nc3opv2y;
    }

    public void setNc3opv2y(String nc3opv2y) {
        this.nc3opv2y = nc3opv2y;
    }

    public String getNc3p2() {
        return nc3p2;
    }

    public void setNc3p2(String nc3p2) {
        this.nc3p2 = nc3p2;
    }

    public String getNc3p2d() {
        return nc3p2d;
    }

    public void setNc3p2d(String nc3p2d) {
        this.nc3p2d = nc3p2d;
    }

    public String getNc3p2m() {
        return nc3p2m;
    }

    public void setNc3p2m(String nc3p2m) {
        this.nc3p2m = nc3p2m;
    }

    public String getNc3p2y() {
        return nc3p2y;
    }

    public void setNc3p2y(String nc3p2y) {
        this.nc3p2y = nc3p2y;
    }

    public String getNc3pcv2() {
        return nc3pcv2;
    }

    public void setNc3pcv2(String nc3pcv2) {
        this.nc3pcv2 = nc3pcv2;
    }

    public String getNc3pcv2d() {
        return nc3pcv2d;
    }

    public void setNc3pcv2d(String nc3pcv2d) {
        this.nc3pcv2d = nc3pcv2d;
    }

    public String getNc3pcv2m() {
        return nc3pcv2m;
    }

    public void setNc3pcv2m(String nc3pcv2m) {
        this.nc3pcv2m = nc3pcv2m;
    }

    public String getNc3pcv2y() {
        return nc3pcv2y;
    }

    public void setNc3pcv2y(String nc3pcv2y) {
        this.nc3pcv2y = nc3pcv2y;
    }

    public String getNc3opv3() {
        return nc3opv3;
    }

    public void setNc3opv3(String nc3opv3) {
        this.nc3opv3 = nc3opv3;
    }

    public String getNc3opv3d() {
        return nc3opv3d;
    }

    public void setNc3opv3d(String nc3opv3d) {
        this.nc3opv3d = nc3opv3d;
    }

    public String getNc3opv3m() {
        return nc3opv3m;
    }

    public void setNc3opv3m(String nc3opv3m) {
        this.nc3opv3m = nc3opv3m;
    }

    public String getNc3opv3y() {
        return nc3opv3y;
    }

    public void setNc3opv3y(String nc3opv3y) {
        this.nc3opv3y = nc3opv3y;
    }

    public String getNc3p3() {
        return nc3p3;
    }

    public void setNc3p3(String nc3p3) {
        this.nc3p3 = nc3p3;
    }

    public String getNc3p3d() {
        return nc3p3d;
    }

    public void setNc3p3d(String nc3p3d) {
        this.nc3p3d = nc3p3d;
    }

    public String getNc3p3m() {
        return nc3p3m;
    }

    public void setNc3p3m(String nc3p3m) {
        this.nc3p3m = nc3p3m;
    }

    public String getNc3p3y() {
        return nc3p3y;
    }

    public void setNc3p3y(String nc3p3y) {
        this.nc3p3y = nc3p3y;
    }

    public String getNc3pcv3() {
        return nc3pcv3;
    }

    public void setNc3pcv3(String nc3pcv3) {
        this.nc3pcv3 = nc3pcv3;
    }

    public String getNc3pcv3b() {
        return nc3pcv3b;
    }

    public void setNc3pcv3b(String nc3pcv3b) {
        this.nc3pcv3b = nc3pcv3b;
    }

    public String getNc3pcv3d() {
        return nc3pcv3d;
    }

    public void setNc3pcv3d(String nc3pcv3d) {
        this.nc3pcv3d = nc3pcv3d;
    }

    public String getNc3pcv3m() {
        return nc3pcv3m;
    }

    public void setNc3pcv3m(String nc3pcv3m) {
        this.nc3pcv3m = nc3pcv3m;
    }

    public String getNc3pcv3y() {
        return nc3pcv3y;
    }

    public void setNc3pcv3y(String nc3pcv3y) {
        this.nc3pcv3y = nc3pcv3y;
    }

    public String getNc3ipv() {
        return nc3ipv;
    }

    public void setNc3ipv(String nc3ipv) {
        this.nc3ipv = nc3ipv;
    }

    public String getNc3ipvd() {
        return nc3ipvd;
    }

    public void setNc3ipvd(String nc3ipvd) {
        this.nc3ipvd = nc3ipvd;
    }

    public String getNc3ipvm() {
        return nc3ipvm;
    }

    public void setNc3ipvm(String nc3ipvm) {
        this.nc3ipvm = nc3ipvm;
    }

    public String getNc3ipvy() {
        return nc3ipvy;
    }

    public void setNc3ipvy(String nc3ipvy) {
        this.nc3ipvy = nc3ipvy;
    }

    public String getNc3m1() {
        return nc3m1;
    }

    public void setNc3m1(String nc3m1) {
        this.nc3m1 = nc3m1;
    }

    public String getNc3m1d() {
        return nc3m1d;
    }

    public void setNc3m1d(String nc3m1d) {
        this.nc3m1d = nc3m1d;
    }

    public String getNc3m1m() {
        return nc3m1m;
    }

    public void setNc3m1m(String nc3m1m) {
        this.nc3m1m = nc3m1m;
    }

    public String getNc3m1y() {
        return nc3m1y;
    }

    public void setNc3m1y(String nc3m1y) {
        this.nc3m1y = nc3m1y;
    }

    public String getNc3m2() {
        return nc3m2;
    }

    public void setNc3m2(String nc3m2) {
        this.nc3m2 = nc3m2;
    }

    public String getNc3m2d() {
        return nc3m2d;
    }

    public void setNc3m2d(String nc3m2d) {
        this.nc3m2d = nc3m2d;
    }

    public String getNc3m2m() {
        return nc3m2m;
    }

    public void setNc3m2m(String nc3m2m) {
        this.nc3m2m = nc3m2m;
    }

    public String getNc3m2y() {
        return nc3m2y;
    }

    public void setNc3m2y(String nc3m2y) {
        this.nc3m2y = nc3m2y;
    }

    public String getNc305() {
        return nc305;
    }

    public void setNc305(String nc305) {
        this.nc305 = nc305;
    }

    public String getNc306() {
        return nc306;
    }

    public void setNc306(String nc306) {
        this.nc306 = nc306;
    }

    public String getNc307() {
        return nc307;
    }

    public void setNc307(String nc307) {
        this.nc307 = nc307;
    }

    public String getNc308() {
        return nc308;
    }

    public void setNc308(String nc308) {
        this.nc308 = nc308;
    }

    public String getNc309() {
        return nc309;
    }

    public void setNc309(String nc309) {
        this.nc309 = nc309;
    }

    public String getNc310() {
        return nc310;
    }

    public void setNc310(String nc310) {
        this.nc310 = nc310;
    }

    public String getNc311() {
        return nc311;
    }

    public void setNc311(String nc311) {
        this.nc311 = nc311;
    }

    public String getNc312() {
        return nc312;
    }

    public void setNc312(String nc312) {
        this.nc312 = nc312;
    }

    public String getNc313() {
        return nc313;
    }

    public void setNc313(String nc313) {
        this.nc313 = nc313;
    }

    public String getNc314() {
        return nc314;
    }

    public void setNc314(String nc314) {
        this.nc314 = nc314;
    }

    public String getNc315() {
        return nc315;
    }

    public void setNc315(String nc315) {
        this.nc315 = nc315;
    }

    public String getNc316() {
        return nc316;
    }

    public void setNc316(String nc316) {
        this.nc316 = nc316;
    }

    public String getNc4name() {
        return nc4name;
    }

    public void setNc4name(String nc4name) {
        this.nc4name = nc4name;
    }

    public String getNc402Serial() {
        return nc402Serial;
    }

    public void setNc402Serial(String nc402Serial) {
        this.nc402Serial = nc402Serial;
    }

    public String getNc401() {
        return nc401;
    }

    public void setNc401(String nc401) {
        this.nc401 = nc401;
    }

    public String getNc402() {
        return nc402;
    }

    public void setNc402(String nc402) {
        this.nc402 = nc402;
    }

    public String getNc403() {
        return nc403;
    }

    public void setNc403(String nc403) {
        this.nc403 = nc403;
    }

    public String getNc4039601x() {
        return nc4039601x;
    }

    public void setNc4039601x(String nc4039601x) {
        this.nc4039601x = nc4039601x;
    }

    public String getNc4039602x() {
        return nc4039602x;
    }

    public void setNc4039602x(String nc4039602x) {
        this.nc4039602x = nc4039602x;
    }

    public String getNc4039603x() {
        return nc4039603x;
    }

    public void setNc4039603x(String nc4039603x) {
        this.nc4039603x = nc4039603x;
    }

    public String getNc404a() {
        return nc404a;
    }

    public void setNc404a(String nc404a) {
        this.nc404a = nc404a;
    }

    public String getNc404b() {
        return nc404b;
    }

    public void setNc404b(String nc404b) {
        this.nc404b = nc404b;
    }

    public String getNc404c() {
        return nc404c;
    }

    public void setNc404c(String nc404c) {
        this.nc404c = nc404c;
    }

    public String getNc404d() {
        return nc404d;
    }

    public void setNc404d(String nc404d) {
        this.nc404d = nc404d;
    }

    public String getNc404e() {
        return nc404e;
    }

    public void setNc404e(String nc404e) {
        this.nc404e = nc404e;
    }

    public String getNc404f() {
        return nc404f;
    }

    public void setNc404f(String nc404f) {
        this.nc404f = nc404f;
    }

    public String getNc404g() {
        return nc404g;
    }

    public void setNc404g(String nc404g) {
        this.nc404g = nc404g;
    }

    public String getNc404h() {
        return nc404h;
    }

    public void setNc404h(String nc404h) {
        this.nc404h = nc404h;
    }

    public String getNc404i() {
        return nc404i;
    }

    public void setNc404i(String nc404i) {
        this.nc404i = nc404i;
    }

    public String getNc404j() {
        return nc404j;
    }

    public void setNc404j(String nc404j) {
        this.nc404j = nc404j;
    }

    public String getNc40496() {
        return nc40496;
    }

    public void setNc40496(String nc40496) {
        this.nc40496 = nc40496;
    }

    public String getNc40496x() {
        return nc40496x;
    }

    public void setNc40496x(String nc40496x) {
        this.nc40496x = nc40496x;
    }

    public String getNc405() {
        return nc405;
    }

    public void setNc405(String nc405) {
        this.nc405 = nc405;
    }

    public String getNc406() {
        return nc406;
    }

    public void setNc406(String nc406) {
        this.nc406 = nc406;
    }

    public String getNc407() {
        return nc407;
    }

    public void setNc407(String nc407) {
        this.nc407 = nc407;
    }

    public String getNc4079601x() {
        return nc4079601x;
    }

    public void setNc4079601x(String nc4079601x) {
        this.nc4079601x = nc4079601x;
    }

    public String getNc4079602x() {
        return nc4079602x;
    }

    public void setNc4079602x(String nc4079602x) {
        this.nc4079602x = nc4079602x;
    }

    public String getNc4079603x() {
        return nc4079603x;
    }

    public void setNc4079603x(String nc4079603x) {
        this.nc4079603x = nc4079603x;
    }

    public String getNc408a() {
        return nc408a;
    }

    public void setNc408a(String nc408a) {
        this.nc408a = nc408a;
    }

    public String getNc408b() {
        return nc408b;
    }

    public void setNc408b(String nc408b) {
        this.nc408b = nc408b;
    }

    public String getNc408c() {
        return nc408c;
    }

    public void setNc408c(String nc408c) {
        this.nc408c = nc408c;
    }

    public String getNc408d() {
        return nc408d;
    }

    public void setNc408d(String nc408d) {
        this.nc408d = nc408d;
    }

    public String getNc408e() {
        return nc408e;
    }

    public void setNc408e(String nc408e) {
        this.nc408e = nc408e;
    }

    public String getNc408f() {
        return nc408f;
    }

    public void setNc408f(String nc408f) {
        this.nc408f = nc408f;
    }

    public String getNc408g() {
        return nc408g;
    }

    public void setNc408g(String nc408g) {
        this.nc408g = nc408g;
    }

    public String getNc408h() {
        return nc408h;
    }

    public void setNc408h(String nc408h) {
        this.nc408h = nc408h;
    }

    public String getNc408i() {
        return nc408i;
    }

    public void setNc408i(String nc408i) {
        this.nc408i = nc408i;
    }

    public String getNc4089601() {
        return nc4089601;
    }

    public void setNc4089601(String nc4089601) {
        this.nc4089601 = nc4089601;
    }

    public String getNc4089601x() {
        return nc4089601x;
    }

    public void setNc4089601x(String nc4089601x) {
        this.nc4089601x = nc4089601x;
    }

    public String getNc409() {
        return nc409;
    }

    public void setNc409(String nc409) {
        this.nc409 = nc409;
    }

    public String getNc410() {
        return nc410;
    }

    public void setNc410(String nc410) {
        this.nc410 = nc410;
    }

    public String getNc411() {
        return nc411;
    }

    public void setNc411(String nc411) {
        this.nc411 = nc411;
    }

    public String getNc4119601x() {
        return nc4119601x;
    }

    public void setNc4119601x(String nc4119601x) {
        this.nc4119601x = nc4119601x;
    }

    public String getNc4119602x() {
        return nc4119602x;
    }

    public void setNc4119602x(String nc4119602x) {
        this.nc4119602x = nc4119602x;
    }

    public String getNc4119603x() {
        return nc4119603x;
    }

    public void setNc4119603x(String nc4119603x) {
        this.nc4119603x = nc4119603x;
    }

    public String getNc412a() {
        return nc412a;
    }

    public void setNc412a(String nc412a) {
        this.nc412a = nc412a;
    }

    public String getNc412b() {
        return nc412b;
    }

    public void setNc412b(String nc412b) {
        this.nc412b = nc412b;
    }

    public String getNc412c() {
        return nc412c;
    }

    public void setNc412c(String nc412c) {
        this.nc412c = nc412c;
    }

    public String getNc412d() {
        return nc412d;
    }

    public void setNc412d(String nc412d) {
        this.nc412d = nc412d;
    }

    public String getNc412e() {
        return nc412e;
    }

    public void setNc412e(String nc412e) {
        this.nc412e = nc412e;
    }

    public String getNc412f() {
        return nc412f;
    }

    public void setNc412f(String nc412f) {
        this.nc412f = nc412f;
    }

    public String getNc412g() {
        return nc412g;
    }

    public void setNc412g(String nc412g) {
        this.nc412g = nc412g;
    }

    public String getNc412h() {
        return nc412h;
    }

    public void setNc412h(String nc412h) {
        this.nc412h = nc412h;
    }

    public String getNc4129601() {
        return nc4129601;
    }

    public void setNc4129601(String nc4129601) {
        this.nc4129601 = nc4129601;
    }

    public String getNc4129601x() {
        return nc4129601x;
    }

    public void setNc4129601x(String nc4129601x) {
        this.nc4129601x = nc4129601x;
    }

    public String getNc413() {
        return nc413;
    }

    public void setNc413(String nc413) {
        this.nc413 = nc413;
    }

    public String getNc414() {
        return nc414;
    }

    public void setNc414(String nc414) {
        this.nc414 = nc414;
    }

    public String getNc415() {
        return nc415;
    }

    public void setNc415(String nc415) {
        this.nc415 = nc415;
    }

    public String getNc416() {
        return nc416;
    }

    public void setNc416(String nc416) {
        this.nc416 = nc416;
    }

    public String getNc417() {
        return nc417;
    }

    public void setNc417(String nc417) {
        this.nc417 = nc417;
    }

    public String getNc418() {
        return nc418;
    }

    public void setNc418(String nc418) {
        this.nc418 = nc418;
    }

    public String getNc419() {
        return nc419;
    }

    public void setNc419(String nc419) {
        this.nc419 = nc419;
    }

    public String getNc420m() {
        return nc420m;
    }

    public void setNc420m(String nc420m) {
        this.nc420m = nc420m;
    }

    public String getNc420d() {
        return nc420d;
    }

    public void setNc420d(String nc420d) {
        this.nc420d = nc420d;
    }

    public String getNc501name() {
        return nc501name;
    }

    public void setNc501name(String nc501name) {
        this.nc501name = nc501name;
    }

    public String getNc501() {
        return nc501;
    }

    public void setNc501(String nc501) {
        this.nc501 = nc501;
    }

    public String getNc502Serial() {
        return nc502Serial;
    }

    public void setNc502Serial(String nc502Serial) {
        this.nc502Serial = nc502Serial;
    }

    public String getNc502() {
        return nc502;
    }

    public void setNc502(String nc502) {
        this.nc502 = nc502;
    }

    public String getNc503() {
        return nc503;
    }

    public void setNc503(String nc503) {
        this.nc503 = nc503;
    }

    public String getNc504() {
        return nc504;
    }

    public void setNc504(String nc504) {
        this.nc504 = nc504;
    }

    public String getNc505() {
        return nc505;
    }

    public void setNc505(String nc505) {
        this.nc505 = nc505;
    }

    public String getNc506() {
        return nc506;
    }

    public void setNc506(String nc506) {
        this.nc506 = nc506;
    }


    // JSON


}
