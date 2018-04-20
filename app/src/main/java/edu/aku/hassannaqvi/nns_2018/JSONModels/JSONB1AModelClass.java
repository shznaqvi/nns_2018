package edu.aku.hassannaqvi.nns_2018.JSONModels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ali.azaz on 3/27/2018.
 */

public class JSONB1AModelClass {

    private String cluster_no = "";
    private String hhno = "";
    @SerializedName("wra_lno")
    private String serial = "";
    private String nw21701 = "";

    private String nw21702y = "";
    private String nw21702m = "";
    private String nw21702d = "";

    private String nw217Flag = "";

    public String getnw217Flag() {
        return nw217Flag;
    }

    public void setnw217Flag(String nw217Flag) {
        this.nw217Flag = nw217Flag;
    }

    public JSONB1AModelClass() {

    }

    public String getCluster_no() {
        return cluster_no;
    }

    public void setCluster_no(String cluster_no) {
        this.cluster_no = cluster_no;
    }

    public String getHhno() {
        return hhno;
    }

    public void setHhno(String hhno) {
        this.hhno = hhno;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getnw21701() {
        return nw21701;
    }

    public void setnw21701(String nw21701) {
        this.nw21701 = nw21701;
    }

    public String getnw21702y() {
        return nw21702y;
    }

    public void setnw21702y(String nw21702y) {
        this.nw21702y = nw21702y;
    }

    public String getnw21702m() {
        return nw21702m;
    }

    public void setnw21702m(String nw21702m) {
        this.nw21702m = nw21702m;
    }

    public String getnw21702d() {
        return nw21702d;
    }

    public void setnw21702d(String nw21702d) {
        this.nw21702d = nw21702d;
    }
}
