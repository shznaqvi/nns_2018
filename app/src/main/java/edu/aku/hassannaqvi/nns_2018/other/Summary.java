package edu.aku.hassannaqvi.nns_2018.other;

import android.database.Cursor;

public class Summary {
    String formdate,
            cluster_no,
            hh_no,
            istatus,
            user,
            member,
            wra,
            child,
            blood,
            water;

    public Summary(Cursor c) {
        this.formdate = c.getString(c.getColumnIndex("formdate"));
        this.cluster_no = c.getString(c.getColumnIndex("cluster_no"));
        this.hh_no = c.getString(c.getColumnIndex("hh_no"));
        this.istatus = c.getString(c.getColumnIndex("istatus"));
        this.user = c.getString(c.getColumnIndex("user"));
        this.member = c.getString(c.getColumnIndex("member"));
        this.wra = c.getString(c.getColumnIndex("wra"));
        this.child = c.getString(c.getColumnIndex("child"));
        this.blood = c.getString(c.getColumnIndex("blood"));
        this.water = c.getString(c.getColumnIndex("water"));
    }

    public static String[] GetHeaders() {
        return new String[]{
                "HH NO",
                "CLUSTER NO",
                "FORMDATE",
                "MEMBER",
                "WRA",
                "CHILD",
                "BLOOD",
                "WATER",
                "USER",
                "ISTATUS"
        };
    }

    public static String[] GetBody(Summary summary) {
        return new String[]{
                summary.getHh_no(),
                summary.getCluster_no(),
                summary.getFormdate(),
                summary.getMember(),
                summary.getWra(),
                summary.getChild(),
                summary.getBlood(),
                summary.getWater(),
                summary.getUser(),
                GetIstatus(summary.getIstatus())
        };
    }

    public String getFormdate() {
        return formdate;
    }

    public String getCluster_no() {
        return cluster_no;
    }

    public String getHh_no() {
        return hh_no;
    }

    public String getIstatus() {
        return istatus;
    }

    public String getUser() {
        return user;
    }

    public String getMember() {
        return member;
    }

    public String getWra() {
        return wra;
    }

    public String getChild() {
        return child;
    }

    public String getBlood() {
        return blood;
    }

    public String getWater() {
        return water;
    }

    private static String GetIstatus(String istatus) {
        switch (istatus) {
            case "1":
                return "Complete";
            case "2":
                return "Incomplete";
            case "3":
                return "N/A";
            case "4":
                return "Refused";
            case "5":
                return "N/A";
            case "6":
                return "N/A";
            case "7":
                return "Partial";
            default:
                return "Other";
        }
    }

}
