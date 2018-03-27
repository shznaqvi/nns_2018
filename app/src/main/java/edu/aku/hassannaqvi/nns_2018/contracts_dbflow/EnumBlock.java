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
 * Created by javed.khan on 3/27/2018.
 */

@Table(database = AppDB.class)
public class EnumBlock extends BaseModel {

    public static final String _URI = "enumblock.php";
    @Column
    @PrimaryKey(autoincrement = true)
    @Unique
    public int _id;
    @Column
    private String ebcode;
    @Column
    private String geoarea;

    public static EnumBlock Sync(JSONObject jsonObject) {

        Gson gson = new GsonBuilder().create();
        EnumBlock enumBlockObj = gson.fromJson(jsonObject.toString(), EnumBlock.class);
        return enumBlockObj;

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
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

    // JSON
    public JSONObject toJSONObject() throws JSONException {

        Gson gson = new GsonBuilder().create();
        JSONObject json = new JSONObject(gson.toJson(this, EnumBlock.class));
        return json;
    }
}