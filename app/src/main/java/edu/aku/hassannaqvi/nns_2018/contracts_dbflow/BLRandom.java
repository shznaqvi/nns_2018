package edu.aku.hassannaqvi.nns_2018.contracts_dbflow;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
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
public class BLRandom extends BaseModel {

    public static final String _URI = "bl_random.php";
    @Column
    @PrimaryKey(autoincrement = true)
    @Unique
    public int _id;
    @Column
    private String randDT;

    @Column
    private String UID;
    @Column
    private String LUID;
    @Column
    @SerializedName("hh02")
    private String enum_Block_code; // ENM_Block
    @Column
    @SerializedName("hh03")
    private String struc_no; // Structure
    @Column
    @SerializedName("hh07")
    private String family_ext; // Family Ext
    @Column
    @SerializedName("hh")
    private String hh;
    @Column
    @SerializedName("hh08")
    private String hh_head; // Household head
    @Column
    @SerializedName("hh09")
    private String contact_no; // Family Ext
    @Column
    @SerializedName("hhss")
    private String hh_selec_stru; // Family Ext


    public BLRandom() {
    }

    public BLRandom(BLRandom rnd) {
        this._id = rnd.get_id();
        this.LUID = rnd.getLUID();
        this.enum_Block_code = rnd.getEnum_Block_code();
        this.struc_no = rnd.getStruc_no();
        this.family_ext = rnd.getFamily_ext();
        this.hh = rnd.getHh();
        this.hh_head = rnd.getHh_head();
        this.randDT = rnd.getRandDT();
        this.contact_no = rnd.getContact_no();
        this.hh_selec_stru = rnd.getHh_selec_stru();
    }

    public static BLRandom Sync(JSONObject jsonObject) {

        Gson gson = new GsonBuilder().create();
        BLRandom blRandom = gson.fromJson(jsonObject.toString(), BLRandom.class);
        return blRandom;

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getRandDT() {
        return randDT;
    }

    public void setRandDT(String randDT) {
        this.randDT = randDT;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getEnum_Block_code() {
        return enum_Block_code;
    }

    public void setEnum_Block_code(String enum_Block_code) {
        this.enum_Block_code = enum_Block_code;
    }

    public String getStruc_no() {
        return struc_no;
    }

    public void setStruc_no(String struc_no) {
        this.struc_no = struc_no;
    }

    public String getFamily_ext() {
        return family_ext;
    }

    public void setFamily_ext(String family_ext) {
        this.family_ext = family_ext;
    }

    public String getHh() {
        return hh;
    }

    public void setHh(String hh) {
        this.hh = hh;
    }

    public String getHh_head() {
        return hh_head;
    }

    public void setHh_head(String hh_head) {
        this.hh_head = hh_head;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getHh_selec_stru() {
        return hh_selec_stru;
    }

    public void setHh_selec_stru(String hh_selec_stru) {
        this.hh_selec_stru = hh_selec_stru;
    }

    public String getLUID() {
        return LUID;
    }

    public void setLUID(String LUID) {
        this.LUID = LUID;
    }

    // JSON
    public JSONObject toJSONObject() throws JSONException {

        Gson gson = new GsonBuilder().create();
        JSONObject json = new JSONObject(gson.toJson(this, BLRandom.class));
        return json;
    }
}
