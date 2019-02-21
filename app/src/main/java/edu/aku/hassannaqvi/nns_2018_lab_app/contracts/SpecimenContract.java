package edu.aku.hassannaqvi.nns_2018_lab_app.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by javed.khan on 1/22/2018.
 */

public class SpecimenContract {


    private final String projectName = "National Nutrition Survey 2018";
    private String _ID = "";
    private String _UID = "";
    private String _UUID = "";
    private String FMUID = "";
    private String formDate = ""; // Date
    private String user = ""; // Interviewer
    private String lineNo = "";

    private String sE1 = ""; // sB

    private String deviceID = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion;

    private String clusterno = "";
    private String hhno = "";

    public SpecimenContract() {

    }


    public SpecimenContract Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString(SpecimenTable.COLUMN__ID);
        this._UID = jsonObject.getString(SpecimenTable.COLUMN__UID);
        this._UUID = jsonObject.getString(SpecimenTable.COLUMN__UUID);
        this.FMUID = jsonObject.getString(SpecimenTable.COLUMN_FM_UID);
        this.clusterno = jsonObject.getString(SpecimenTable.COLUMN_CLUSTER);
        this.hhno = jsonObject.getString(SpecimenTable.COLUMN_HH);
        this.formDate = jsonObject.getString(SpecimenTable.COLUMN_FORMDATE);
        this.user = jsonObject.getString(SpecimenTable.COLUMN_USER);
        this.lineNo = jsonObject.getString(SpecimenTable.COLUMN_LINENO);
        this.sE1 = jsonObject.getString(SpecimenTable.COLUMN_SE1);
        this.deviceID = jsonObject.getString(SpecimenTable.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(SpecimenTable.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(SpecimenTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(SpecimenTable.COLUMN_SYNCED_DATE);
        this.appversion = jsonObject.getString(SpecimenTable.COLUMN_APPVERSION);


        return this;

    }

    public SpecimenContract Hydrate(Cursor cursor, int type) {


        this._ID = cursor.getString(cursor.getColumnIndex(SpecimenTable.COLUMN__ID));
        this._UID = cursor.getString(cursor.getColumnIndex(SpecimenTable.COLUMN__UID));
        this._UUID = cursor.getString(cursor.getColumnIndex(SpecimenTable.COLUMN__UUID));
        this.FMUID = cursor.getString(cursor.getColumnIndex(SpecimenTable.COLUMN_FM_UID));
        this.clusterno = cursor.getString(cursor.getColumnIndex(SpecimenTable.COLUMN_CLUSTER));
        this.hhno = cursor.getString(cursor.getColumnIndex(SpecimenTable.COLUMN_HH));


        if (type == 0 || type == 1) {
            this.sE1 = cursor.getString(cursor.getColumnIndex(SpecimenTable.COLUMN_SE1));
        }

        if (type == 0) {
            this.formDate = cursor.getString(cursor.getColumnIndex(SpecimenTable.COLUMN_FORMDATE));
            this.user = cursor.getString(cursor.getColumnIndex(SpecimenTable.COLUMN_USER));
            this.lineNo = cursor.getString(cursor.getColumnIndex(SpecimenTable.COLUMN_LINENO));
            this.deviceID = cursor.getString(cursor.getColumnIndex(SpecimenTable.COLUMN_DEVICEID));
            this.devicetagID = cursor.getString(cursor.getColumnIndex(SpecimenTable.COLUMN_DEVICETAGID));
            this.synced = cursor.getString(cursor.getColumnIndex(SpecimenTable.COLUMN_SYNCED));
            this.synced_date = cursor.getString(cursor.getColumnIndex(SpecimenTable.COLUMN_SYNCED_DATE));
            this.appversion = cursor.getString(cursor.getColumnIndex(SpecimenTable.COLUMN_APPVERSION));

        }
        // TODO:

        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(SpecimenTable.COLUMN_PROJECTNAME, this.projectName == null ? JSONObject.NULL : this.projectName);
        json.put(SpecimenTable.COLUMN__ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(SpecimenTable.COLUMN__UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(SpecimenTable.COLUMN__UUID, this._UUID == null ? JSONObject.NULL : this._UUID);
        json.put(SpecimenTable.COLUMN_FM_UID, this.FMUID == null ? JSONObject.NULL : this.FMUID);
        json.put(SpecimenTable.COLUMN_CLUSTER, this.clusterno == null ? JSONObject.NULL : this.clusterno);
        json.put(SpecimenTable.COLUMN_HH, this.hhno == null ? JSONObject.NULL : this.hhno);
        //json.put(MicroTable.COLUMN_MUID, this.MUID == null ? JSONObject.NULL : this.MUID);

        json.put(SpecimenTable.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(SpecimenTable.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);
        json.put(SpecimenTable.COLUMN_LINENO, this.lineNo == null ? JSONObject.NULL : this.lineNo);

        if (!this.sE1.equals("")) {
            json.put(SpecimenTable.COLUMN_SE1, this.sE1.equals("") ? JSONObject.NULL : new JSONObject(this.sE1));
            /*  json.put(MicroTable.COLUMN_SC1, this.sC1 == null ? JSONObject.NULL : this.sC1);*/
        }


        json.put(SpecimenTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(SpecimenTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        /*json.put(MicroTable.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(MicroTable.COLUMN_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);*/
        json.put(SpecimenTable.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);


        return json;
    }

    public String getClusterno() {
        return clusterno;
    }

    public void setClusterno(String clusterno) {
        this.clusterno = clusterno;
    }

    public String getHhno() {
        return hhno;
    }

    public void setHhno(String hhno) {
        this.hhno = hhno;
    }

    public String getFMUID() {
        return FMUID;
    }

    public void setFMUID(String FMUID) {
        this.FMUID = FMUID;
    }

    public String getProjectName() {
        return projectName;
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String getUID() {
        return _UID;
    }

    public void setUID(String _UID) {
        this._UID = _UID;
    }


    public String getUUID() {
        return _UUID;
    }

    public void setUUID(String _UUID) {
        this._UUID = _UUID;
    }


    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
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


    public String getsE1() {
        return sE1;
    }

    public void setsE1(String sE1) {
        this.sE1 = sE1;
    }

    public String getLineNo() {
        return lineNo;
    }

    public void setLineNo(String lineNo) {
        this.lineNo = lineNo;
    }


    public static abstract class SpecimenTable implements BaseColumns {

        public static final String TABLE_NAME = "specimen";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";

        public static final String COLUMN_PROJECTNAME = "projectname";
        public static final String COLUMN__ID = "_id";
        public static final String COLUMN__UID = "_uid";
        public static final String COLUMN__UUID = "_uuid";
        public static final String COLUMN_FM_UID = "fmuid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_LINENO = "lineno";
        public static final String COLUMN_CLUSTER = "cluster";
        public static final String COLUMN_HH = "hh_no";
        public static final String COLUMN_SE1 = "se1";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "devicetagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APPVERSION = "appversion";


        public static String _URL = "specimen.php";
    }

}