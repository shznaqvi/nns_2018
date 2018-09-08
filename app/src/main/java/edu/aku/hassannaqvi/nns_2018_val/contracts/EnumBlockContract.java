package edu.aku.hassannaqvi.nns_2018_val.contracts;


import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class EnumBlockContract {

    private static final String TAG = "EnumBlock_CONTRACT";
    String ebcode;
    String geoarea;
    String cluster;
    String en_hhno;
    String en_hh03;
    String en_hh07;

    public EnumBlockContract() {
        // Default Constructor
    }

    public EnumBlockContract Sync(JSONObject jsonObject) throws JSONException {
        this.ebcode = jsonObject.getString(EnumBlockTable.COLUMN_EB_CODE);
        this.geoarea = jsonObject.getString(EnumBlockTable.COLUMN_GEO_AREA);
        this.cluster = jsonObject.getString(EnumBlockTable.COLUMN_CLUSTER_AREA);
        this.en_hhno = jsonObject.getString(EnumBlockTable.COLUMN_EN_HHNO);
        this.en_hh03 = jsonObject.getString(EnumBlockTable.COLUMN_EN_HH03);
        this.en_hh07 = jsonObject.getString(EnumBlockTable.COLUMN_EN_HH07);
        return this;
    }

    public EnumBlockContract HydrateEnum(Cursor cursor) {
        this.ebcode = cursor.getString(cursor.getColumnIndex(EnumBlockTable.COLUMN_EB_CODE));
        this.geoarea = cursor.getString(cursor.getColumnIndex(EnumBlockTable.COLUMN_GEO_AREA));
        this.cluster = cursor.getString(cursor.getColumnIndex(EnumBlockTable.COLUMN_CLUSTER_AREA));
        this.en_hhno = cursor.getString(cursor.getColumnIndex(EnumBlockTable.COLUMN_EN_HHNO));
        this.en_hh03 = cursor.getString(cursor.getColumnIndex(EnumBlockTable.COLUMN_EN_HH03));
        this.en_hh07 = cursor.getString(cursor.getColumnIndex(EnumBlockTable.COLUMN_EN_HH07));
        return this;
    }

    public String getEbcode() {
        return ebcode;
    }

    public void setEbcode(String ebcode) {
        this.ebcode = ebcode;
    }

    public String getGeoarea() {
        return geoarea;
    }

    public void setGeoarea(String geoarea) {
        this.geoarea = geoarea;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getEn_hhno() {
        return en_hhno;
    }

    public void setEn_hhno(String en_hhno) {
        this.en_hhno = en_hhno;
    }

    public String getEn_hh03() {
        return en_hh03;
    }

    public void setEn_hh03(String en_hh03) {
        this.en_hh03 = en_hh03;
    }

    public String getEn_hh07() {
        return en_hh07;
    }

    public void setEn_hh07(String en_hh07) {
        this.en_hh07 = en_hh07;
    }

    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();
        json.put(EnumBlockTable.COLUMN_EB_CODE, this.ebcode == null ? JSONObject.NULL : this.ebcode);
        json.put(EnumBlockTable.COLUMN_GEO_AREA, this.geoarea == null ? JSONObject.NULL : this.geoarea);
        json.put(EnumBlockTable.COLUMN_CLUSTER_AREA, this.cluster == null ? JSONObject.NULL : this.cluster);
        json.put(EnumBlockTable.COLUMN_EN_HHNO, this.en_hhno == null ? JSONObject.NULL : this.en_hhno);
        json.put(EnumBlockTable.COLUMN_EN_HH03, this.en_hh03 == null ? JSONObject.NULL : this.en_hh03);
        json.put(EnumBlockTable.COLUMN_EN_HH07, this.en_hh07 == null ? JSONObject.NULL : this.en_hh07);
        return json;
    }


    public static abstract class EnumBlockTable implements BaseColumns {

        public static final String TABLE_NAME = "enumblock";
        public static final String COLUMN_EB_CODE = "ebcode";
        public static final String COLUMN_GEO_AREA = "geoarea";
        public static final String COLUMN_CLUSTER_AREA = "cluster";
        public static final String COLUMN_EN_HHNO = "hhno";
        public static final String COLUMN_EN_HH03 = "hh03";
        public static final String COLUMN_EN_HH07 = "hh07";

        public static final String _URI = "enumblock_m.php";
    }
}