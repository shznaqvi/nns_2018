package edu.aku.hassannaqvi.nns_2018.contracts_dbflow;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;
import com.raizlabs.android.dbflow.structure.BaseModel;

import edu.aku.hassannaqvi.nns_2018.AppDB;

/**
 * Created by wajah on 3/27/2018.
 */
@Table(database = AppDB.class)
public class FormContract extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    @Unique
    public int _id;
    @Column
    public String projectname = "NNS-2018";
    @Column
    private String NULLHACK;
    @Column
    private String _uid;
    @Column
    private String formdate;
    @Column
    private String user;
    @Column
    private String istatus;
    @Column
    private String istatus88x;

    // SA1
    @Column
    private String rndid;
    @Column
    private String luid;
    @Column
    private String randDT;
    @Column
    private String hh03;
    @Column
    private String hh07;
    @Column
    private String hhhead;
    @Column
    private String hh09;
    @Column
    private String hhss;
    @Column
    private String hhheadpresent;
    @Column
    private String hhheadpresentnew;

    @Column
    private String nh101;
    @Column
    private String nh103;
    @Column
    private String nh104;
    @Column
    private String nh105;
    @Column
    private String nh106;
    @Column
    private String nh113;
    @Column
    private String nh115;

    @Column
    private String nh213;
    @Column
    private String nh11701blood;
    @Column
    private String nh11702urine;
    @Column
    private String nh11703water;
    @Column
    private String nh11801;
    @Column
    private String nh11802;

    @Column
    private String nh119a;
    @Column
    private String nh119b;
    @Column
    private String nh119c;
    @Column
    private String nh119d;
    @Column
    private String nh119e;
    @Column
    private String nh119f;
    @Column
    private String nh119g;

    @Column
    private String nh11996;
    @Column
    private String nh11996x;

    //SA4
    @Column
    private String nh301;
    @Column
    private String nh30196x;
    @Column
    private String nh302;
    @Column
    private String nh30296x;
    @Column
    private String nh303a;
    @Column
    private String nh303;
    @Column
    private String nh30396x;
    @Column
    private String nh304;
    @Column
    private String nh305;
    @Column
    private String nh306;
    @Column
    private String nh30696x;
    @Column
    private String nh307;
    @Column
    private String nh30796x;
    @Column
    private String nh308;
    @Column
    private String nh309;
    @Column
    private String nh310;

    @Column
    private String nh31096x;
    @Column
    private String nh31101;
    @Column
    private String nh31102;
    @Column
    private String nh31103;
    @Column
    private String nh31104;
    @Column
    private String nh31105;
    @Column
    private String nh31106;
    @Column
    private String nh31107;
    @Column
    private String nh31108;

    @Column
    private String nh31109;
    @Column
    private String nh31110;
    @Column
    private String nh31111;
    @Column
    private String nh31112;
    @Column
    private String nh31113;
    @Column
    private String nh31114;
    @Column
    private String nh31115;
    @Column
    private String nh31116;
    @Column
    private String nh31117;

    @Column
    private String nh31118;
    @Column
    private String nh31119;
    @Column
    private String nh312a;
    @Column
    private String nh312b;
    @Column
    private String nh312c;
    @Column
    private String nh312d;
    @Column
    private String nh312e;
    @Column
    private String nh312f;
    @Column
    private String nh312g;
    @Column
    private String nh312h;
    @Column
    private String nh312i;

    @Column
    private String nh313a;
    @Column
    private String nh313b;
    @Column
    private String nh313c;
    @Column
    private String nh313d;
    @Column
    private String nh313e;
    @Column
    private String nh313f;
    @Column
    private String nh31396;
    @Column
    private String nh31396x;
    @Column
    private String nh314;
    @Column
    private String nh31496x;

    @Column
    private String nh315;
    @Column
    private String nh31596x;
    @Column
    private String nh316;
    @Column
    private String nh317;
    @Column
    private String nh31796x;
    @Column
    private String nh318;
    @Column
    private String nh31896x;
    @Column
    private String nh319;
    @Column
    private String nh31996x;
    @Column
    private String nh320;
    @Column
    private String nh321;
    @Column
    private String nh322;
    @Column
    private String nh322acr;
    @Column
    private String nh322can;
    @Column
    private String nh323;
    @Column
    private String nh324a;
    @Column
    private String nh324b;
    @Column
    private String nh324c;
    @Column
    private String nh324d;
    @Column
    private String nh324e;
    @Column
    private String nh324f;
    @Column
    private String nh324g;


    //a5
    @Column
    private String nh401;
    @Column
    private String nh402;
    @Column
    private String nh403a;
    @Column

    private String nh403b;
    @Column
    private String nh403c;
    @Column
    private String nh403d;
    @Column
    private String nh403e;
    @Column
    private String nh404;
    @Column
    private String nh405a;
    @Column
    private String nh405b;
    @Column
    private String nh405c;
    @Column
    private String nh405d;
    @Column
    private String nh405e;
    @Column
    private String nh40601;
    @Column
    private String nh40602;
    @Column
    private String nh40603;
    @Column
    private String nh40604;
    @Column
    private String nh40605;
    @Column
    private String nh40696;
    @Column
    private String nh40696x;
    @Column
    private String nh501;
    @Column
    private String nh50196x;
    @Column
    private String nh502;
    @Column
    private String nh503;
    @Column
    private String nh601;
    @Column
    private String nh602;
    @Column
    private String nh603;
    @Column
    private String nh604;
    @Column
    private String nh605;
    @Column
    private String nh606;
    @Column
    private String nh607;
    @Column
    private String nh608;
    @Column
    private String nh609;
    @Column
    private String nh701;
    @Column
    private String nh702;
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

    public String getNh401() {
        return nh401;
    }

    public void setNh401(String nh401) {
        this.nh401 = nh401;
    }

    public String getNh402() {
        return nh402;
    }

    public void setNh402(String nh402) {
        this.nh402 = nh402;
    }

    public String getNh403a() {
        return nh403a;
    }

    public void setNh403a(String nh403a) {
        this.nh403a = nh403a;
    }

    public String getNh403b() {
        return nh403b;
    }

    public void setNh403b(String nh403b) {
        this.nh403b = nh403b;
    }

    public String getNh403c() {
        return nh403c;
    }

    public void setNh403c(String nh403c) {
        this.nh403c = nh403c;
    }

    public String getNh403d() {
        return nh403d;
    }

    public void setNh403d(String nh403d) {
        this.nh403d = nh403d;
    }

    public String getNh403e() {
        return nh403e;
    }

    public void setNh403e(String nh403e) {
        this.nh403e = nh403e;
    }

    public String getNh404() {
        return nh404;
    }

    public void setNh404(String nh404) {
        this.nh404 = nh404;
    }

    public String getNh405a() {
        return nh405a;
    }

    public void setNh405a(String nh405a) {
        this.nh405a = nh405a;
    }

    public String getNh405b() {
        return nh405b;
    }

    public void setNh405b(String nh405b) {
        this.nh405b = nh405b;
    }

    public String getNh405c() {
        return nh405c;
    }

    public void setNh405c(String nh405c) {
        this.nh405c = nh405c;
    }

    public String getNh405d() {
        return nh405d;
    }

    public void setNh405d(String nh405d) {
        this.nh405d = nh405d;
    }

    public String getNh405e() {
        return nh405e;
    }

    public void setNh405e(String nh405e) {
        this.nh405e = nh405e;
    }

    public String getNh40601() {
        return nh40601;
    }

    public void setNh40601(String nh40601) {
        this.nh40601 = nh40601;
    }

    public String getNh40602() {
        return nh40602;
    }

    public void setNh40602(String nh40602) {
        this.nh40602 = nh40602;
    }

    public String getNh40603() {
        return nh40603;
    }

    public void setNh40603(String nh40603) {
        this.nh40603 = nh40603;
    }

    public String getNh40604() {
        return nh40604;
    }

    public void setNh40604(String nh40604) {
        this.nh40604 = nh40604;
    }

    public String getNh40605() {
        return nh40605;
    }

    public void setNh40605(String nh40605) {
        this.nh40605 = nh40605;
    }

    public String getNh40696() {
        return nh40696;
    }

    public void setNh40696(String nh40696) {
        this.nh40696 = nh40696;
    }

    public String getNh40696x() {
        return nh40696x;
    }

    public void setNh40696x(String nh40696x) {
        this.nh40696x = nh40696x;
    }

    public String getNh501() {
        return nh501;
    }

    public void setNh501(String nh501) {
        this.nh501 = nh501;
    }

    public String getNh50196x() {
        return nh50196x;
    }

    public void setNh50196x(String nh50196x) {
        this.nh50196x = nh50196x;
    }

    public String getNh502() {
        return nh502;
    }

    public void setNh502(String nh502) {
        this.nh502 = nh502;
    }

    public String getNh503() {
        return nh503;
    }

    public void setNh503(String nh503) {
        this.nh503 = nh503;
    }

    public String getNh601() {
        return nh601;
    }

    public void setNh601(String nh601) {
        this.nh601 = nh601;
    }

    public String getNh602() {
        return nh602;
    }

    public void setNh602(String nh602) {
        this.nh602 = nh602;
    }

    public String getNh603() {
        return nh603;
    }

    public void setNh603(String nh603) {
        this.nh603 = nh603;
    }

    public String getNh604() {
        return nh604;
    }

    public void setNh604(String nh604) {
        this.nh604 = nh604;
    }

    public String getNh605() {
        return nh605;
    }

    public void setNh605(String nh605) {
        this.nh605 = nh605;
    }

    public String getNh606() {
        return nh606;
    }

    public void setNh606(String nh606) {
        this.nh606 = nh606;
    }

    public String getNh607() {
        return nh607;
    }

    public void setNh607(String nh607) {
        this.nh607 = nh607;
    }

    public String getNh608() {
        return nh608;
    }

    public void setNh608(String nh608) {
        this.nh608 = nh608;
    }

    public String getNh609() {
        return nh609;
    }

    public void setNh609(String nh609) {
        this.nh609 = nh609;
    }

    public String getNh701() {
        return nh701;
    }

    public void setNh701(String nh701) {
        this.nh701 = nh701;
    }

    public String getNh702() {
        return nh702;
    }

    public void setNh702(String nh702) {
        this.nh702 = nh702;
    }


    /*public String getSA1() {
        return sA1;
    }

    public void setSA1(String sA1) {
        this.sA1 = sA1;
    }

    public String getSA4() {
        return sA4;
    }

    public void setSA4(String sA4) {
        this.sA4 = sA4;
    }*/

    public String getNULLHACK() {
        return NULLHACK;
    }

    public void setNULLHACK(String NULLHACK) {
        this.NULLHACK = NULLHACK;
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

    public String getNh301() {
        return nh301;
    }

    public void setNh301(String nh301) {
        this.nh301 = nh301;
    }

    public String getNh30196x() {
        return nh30196x;
    }

    public void setNh30196x(String nh30196x) {
        this.nh30196x = nh30196x;
    }

    public String getNh302() {
        return nh302;
    }

    public void setNh302(String nh302) {
        this.nh302 = nh302;
    }

    public String getNh30296x() {
        return nh30296x;
    }

    public void setNh30296x(String nh30296x) {
        this.nh30296x = nh30296x;
    }

    public String getNh303a() {
        return nh303a;
    }

    public void setNh303a(String nh303a) {
        this.nh303a = nh303a;
    }

    public String getNh303() {
        return nh303;
    }

    public void setNh303(String nh303) {
        this.nh303 = nh303;
    }

    public String getNh30396x() {
        return nh30396x;
    }

    public void setNh30396x(String nh30396x) {
        this.nh30396x = nh30396x;
    }

    public String getNh304() {
        return nh304;
    }

    public void setNh304(String nh304) {
        this.nh304 = nh304;
    }

    public String getNh305() {
        return nh305;
    }

    public void setNh305(String nh305) {
        this.nh305 = nh305;
    }

    public String getNh306() {
        return nh306;
    }

    public void setNh306(String nh306) {
        this.nh306 = nh306;
    }

    public String getNh30696x() {
        return nh30696x;
    }

    public void setNh30696x(String nh30696x) {
        this.nh30696x = nh30696x;
    }

    public String getNh307() {
        return nh307;
    }

    public void setNh307(String nh307) {
        this.nh307 = nh307;
    }

    public String getNh30796x() {
        return nh30796x;
    }

    public void setNh30796x(String nh30796x) {
        this.nh30796x = nh30796x;
    }

    public String getNh308() {
        return nh308;
    }

    public void setNh308(String nh308) {
        this.nh308 = nh308;
    }

    public String getNh309() {
        return nh309;
    }

    public void setNh309(String nh309) {
        this.nh309 = nh309;
    }

    public String getNh310() {
        return nh310;
    }

    public void setNh310(String nh310) {
        this.nh310 = nh310;
    }

    public String getNh31096x() {
        return nh31096x;
    }

    public void setNh31096x(String nh31096x) {
        this.nh31096x = nh31096x;
    }

    public String getNh31101() {
        return nh31101;
    }

    public void setNh31101(String nh31101) {
        this.nh31101 = nh31101;
    }

    public String getNh31102() {
        return nh31102;
    }

    public void setNh31102(String nh31102) {
        this.nh31102 = nh31102;
    }

    public String getNh31103() {
        return nh31103;
    }

    public void setNh31103(String nh31103) {
        this.nh31103 = nh31103;
    }

    public String getNh31104() {
        return nh31104;
    }

    public void setNh31104(String nh31104) {
        this.nh31104 = nh31104;
    }

    public String getNh31105() {
        return nh31105;
    }

    public void setNh31105(String nh31105) {
        this.nh31105 = nh31105;
    }

    public String getNh31106() {
        return nh31106;
    }

    public void setNh31106(String nh31106) {
        this.nh31106 = nh31106;
    }

    public String getNh31107() {
        return nh31107;
    }

    public void setNh31107(String nh31107) {
        this.nh31107 = nh31107;
    }

    public String getNh31108() {
        return nh31108;
    }

    public void setNh31108(String nh31108) {
        this.nh31108 = nh31108;
    }

    public String getNh31109() {
        return nh31109;
    }

    public void setNh31109(String nh31109) {
        this.nh31109 = nh31109;
    }

    public String getNh31110() {
        return nh31110;
    }

    public void setNh31110(String nh31110) {
        this.nh31110 = nh31110;
    }

    public String getNh31111() {
        return nh31111;
    }

    public void setNh31111(String nh31111) {
        this.nh31111 = nh31111;
    }

    public String getNh31112() {
        return nh31112;
    }

    public void setNh31112(String nh31112) {
        this.nh31112 = nh31112;
    }

    public String getNh31113() {
        return nh31113;
    }

    public void setNh31113(String nh31113) {
        this.nh31113 = nh31113;
    }

    public String getNh31114() {
        return nh31114;
    }

    public void setNh31114(String nh31114) {
        this.nh31114 = nh31114;
    }

    public String getNh31115() {
        return nh31115;
    }

    public void setNh31115(String nh31115) {
        this.nh31115 = nh31115;
    }

    public String getNh31116() {
        return nh31116;
    }

    public void setNh31116(String nh31116) {
        this.nh31116 = nh31116;
    }

    public String getNh31117() {
        return nh31117;
    }

    public void setNh31117(String nh31117) {
        this.nh31117 = nh31117;
    }

    public String getNh31118() {
        return nh31118;
    }

    public void setNh31118(String nh31118) {
        this.nh31118 = nh31118;
    }

    public String getNh31119() {
        return nh31119;
    }

    public void setNh31119(String nh31119) {
        this.nh31119 = nh31119;
    }

    public String getNh312a() {
        return nh312a;
    }

    public void setNh312a(String nh312a) {
        this.nh312a = nh312a;
    }

    public String getNh312b() {
        return nh312b;
    }

    public void setNh312b(String nh312b) {
        this.nh312b = nh312b;
    }

    public String getNh312c() {
        return nh312c;
    }

    public void setNh312c(String nh312c) {
        this.nh312c = nh312c;
    }

    public String getNh312d() {
        return nh312d;
    }

    public void setNh312d(String nh312d) {
        this.nh312d = nh312d;
    }

    public String getNh312e() {
        return nh312e;
    }

    public void setNh312e(String nh312e) {
        this.nh312e = nh312e;
    }

    public String getNh312f() {
        return nh312f;
    }

    public void setNh312f(String nh312f) {
        this.nh312f = nh312f;
    }

    public String getNh312g() {
        return nh312g;
    }

    public void setNh312g(String nh312g) {
        this.nh312g = nh312g;
    }

    public String getNh312h() {
        return nh312h;
    }

    public void setNh312h(String nh312h) {
        this.nh312h = nh312h;
    }

    public String getNh312i() {
        return nh312i;
    }

    public void setNh312i(String nh312i) {
        this.nh312i = nh312i;
    }

    public String getNh313a() {
        return nh313a;
    }

    public void setNh313a(String nh313a) {
        this.nh313a = nh313a;
    }

    public String getNh313b() {
        return nh313b;
    }

    public void setNh313b(String nh313b) {
        this.nh313b = nh313b;
    }

    public String getNh313c() {
        return nh313c;
    }

    public void setNh313c(String nh313c) {
        this.nh313c = nh313c;
    }

    public String getNh313d() {
        return nh313d;
    }

    public void setNh313d(String nh313d) {
        this.nh313d = nh313d;
    }

    public String getNh313e() {
        return nh313e;
    }

    public void setNh313e(String nh313e) {
        this.nh313e = nh313e;
    }

    public String getNh313f() {
        return nh313f;
    }

    public void setNh313f(String nh313f) {
        this.nh313f = nh313f;
    }

    public String getNh31396() {
        return nh31396;
    }

    public void setNh31396(String nh31396) {
        this.nh31396 = nh31396;
    }

    public String getNh31396x() {
        return nh31396x;
    }

    public void setNh31396x(String nh31396x) {
        this.nh31396x = nh31396x;
    }

    public String getNh314() {
        return nh314;
    }

    public void setNh314(String nh314) {
        this.nh314 = nh314;
    }

    public String getNh31496x() {
        return nh31496x;
    }

    public void setNh31496x(String nh31496x) {
        this.nh31496x = nh31496x;
    }

    public String getNh315() {
        return nh315;
    }

    public void setNh315(String nh315) {
        this.nh315 = nh315;
    }

    public String getNh31596x() {
        return nh31596x;
    }

    public void setNh31596x(String nh31596x) {
        this.nh31596x = nh31596x;
    }

    public String getNh316() {
        return nh316;
    }

    public void setNh316(String nh316) {
        this.nh316 = nh316;
    }

    public String getNh317() {
        return nh317;
    }

    public void setNh317(String nh317) {
        this.nh317 = nh317;
    }

    public String getNh31796x() {
        return nh31796x;
    }

    public void setNh31796x(String nh31796x) {
        this.nh31796x = nh31796x;
    }

    public String getNh318() {
        return nh318;
    }

    public void setNh318(String nh318) {
        this.nh318 = nh318;
    }

    public String getNh31896x() {
        return nh31896x;
    }

    public void setNh31896x(String nh31896x) {
        this.nh31896x = nh31896x;
    }

    public String getNh319() {
        return nh319;
    }

    public void setNh319(String nh319) {
        this.nh319 = nh319;
    }

    public String getNh31996x() {
        return nh31996x;
    }

    public void setNh31996x(String nh31996x) {
        this.nh31996x = nh31996x;
    }

    public String getNh320() {
        return nh320;
    }

    public void setNh320(String nh320) {
        this.nh320 = nh320;
    }

    public String getNh321() {
        return nh321;
    }

    public void setNh321(String nh321) {
        this.nh321 = nh321;
    }

    public String getNh322() {
        return nh322;
    }

    public void setNh322(String nh322) {
        this.nh322 = nh322;
    }

    public String getNh322acr() {
        return nh322acr;
    }

    public void setNh322acr(String nh322acr) {
        this.nh322acr = nh322acr;
    }

    public String getNh322can() {
        return nh322can;
    }

    public void setNh322can(String nh322can) {
        this.nh322can = nh322can;
    }

    public String getNh323() {
        return nh323;
    }

    public void setNh323(String nh323) {
        this.nh323 = nh323;
    }

    public String getNh324a() {
        return nh324a;
    }

    public void setNh324a(String nh324a) {
        this.nh324a = nh324a;
    }

    public String getNh324b() {
        return nh324b;
    }

    public void setNh324b(String nh324b) {
        this.nh324b = nh324b;
    }

    public String getNh324c() {
        return nh324c;
    }

    public void setNh324c(String nh324c) {
        this.nh324c = nh324c;
    }

    public String getNh324d() {
        return nh324d;
    }

    public void setNh324d(String nh324d) {
        this.nh324d = nh324d;
    }

    public String getNh324e() {
        return nh324e;
    }

    public void setNh324e(String nh324e) {
        this.nh324e = nh324e;
    }

    public String getNh324f() {
        return nh324f;
    }

    public void setNh324f(String nh324f) {
        this.nh324f = nh324f;
    }

    public String getNh324g() {
        return nh324g;
    }

    public void setNh324g(String nh324g) {
        this.nh324g = nh324g;
    }

    public String getRndid() {
        return rndid;
    }

    public void setRndid(String rndid) {
        this.rndid = rndid;
    }

    public String getLuid() {
        return luid;
    }

    public void setLuid(String luid) {
        this.luid = luid;
    }

    public String getRandDT() {
        return randDT;
    }

    public void setRandDT(String randDT) {
        this.randDT = randDT;
    }

    public String getHh03() {
        return hh03;
    }

    public void setHh03(String hh03) {
        this.hh03 = hh03;
    }

    public String getHh07() {
        return hh07;
    }

    public void setHh07(String hh07) {
        this.hh07 = hh07;
    }

    public String getHhhead() {
        return hhhead;
    }

    public void setHhhead(String hhhead) {
        this.hhhead = hhhead;
    }

    public String getHh09() {
        return hh09;
    }

    public void setHh09(String hh09) {
        this.hh09 = hh09;
    }

    public String getHhss() {
        return hhss;
    }

    public void setHhss(String hhss) {
        this.hhss = hhss;
    }

    public String getHhheadpresent() {
        return hhheadpresent;
    }

    public void setHhheadpresent(String hhheadpresent) {
        this.hhheadpresent = hhheadpresent;
    }

    public String getHhheadpresentnew() {
        return hhheadpresentnew;
    }

    public void setHhheadpresentnew(String hhheadpresentnew) {
        this.hhheadpresentnew = hhheadpresentnew;
    }

    public String getNh101() {
        return nh101;
    }

    public void setNh101(String nh101) {
        this.nh101 = nh101;
    }

    public String getNh103() {
        return nh103;
    }

    public void setNh103(String nh103) {
        this.nh103 = nh103;
    }

    public String getNh104() {
        return nh104;
    }

    public void setNh104(String nh104) {
        this.nh104 = nh104;
    }

    public String getNh105() {
        return nh105;
    }

    public void setNh105(String nh105) {
        this.nh105 = nh105;
    }

    public String getNh106() {
        return nh106;
    }

    public void setNh106(String nh106) {
        this.nh106 = nh106;
    }

    public String getNh113() {
        return nh113;
    }

    public void setNh113(String nh113) {
        this.nh113 = nh113;
    }

    public String getNh115() {
        return nh115;
    }

    public void setNh115(String nh115) {
        this.nh115 = nh115;
    }

    public String getNh213() {
        return nh213;
    }

    public void setNh213(String nh213) {
        this.nh213 = nh213;
    }

    public String getNh11701blood() {
        return nh11701blood;
    }

    public void setNh11701blood(String nh11701blood) {
        this.nh11701blood = nh11701blood;
    }

    public String getNh11702urine() {
        return nh11702urine;
    }

    public void setNh11702urine(String nh11702urine) {
        this.nh11702urine = nh11702urine;
    }

    public String getNh11703water() {
        return nh11703water;
    }

    public void setNh11703water(String nh11703water) {
        this.nh11703water = nh11703water;
    }

    public String getNh11801() {
        return nh11801;
    }

    public void setNh11801(String nh11801) {
        this.nh11801 = nh11801;
    }

    public String getNh11802() {
        return nh11802;
    }

    public void setNh11802(String nh11802) {
        this.nh11802 = nh11802;
    }

    public String getNh119a() {
        return nh119a;
    }

    public void setNh119a(String nh119a) {
        this.nh119a = nh119a;
    }

    public String getNh119b() {
        return nh119b;
    }

    public void setNh119b(String nh119b) {
        this.nh119b = nh119b;
    }

    public String getNh119c() {
        return nh119c;
    }

    public void setNh119c(String nh119c) {
        this.nh119c = nh119c;
    }

    public String getNh119d() {
        return nh119d;
    }

    public void setNh119d(String nh119d) {
        this.nh119d = nh119d;
    }

    public String getNh119e() {
        return nh119e;
    }

    public void setNh119e(String nh119e) {
        this.nh119e = nh119e;
    }

    public String getNh119f() {
        return nh119f;
    }

    public void setNh119f(String nh119f) {
        this.nh119f = nh119f;
    }

    public String getNh119g() {
        return nh119g;
    }

    public void setNh119g(String nh119g) {
        this.nh119g = nh119g;
    }

    public String getNh11996() {
        return nh11996;
    }

    public void setNh11996(String nh11996) {
        this.nh11996 = nh11996;
    }

    public String getNh11996x() {
        return nh11996x;
    }

    public void setNh11996x(String nh11996x) {
        this.nh11996x = nh11996x;
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
}
