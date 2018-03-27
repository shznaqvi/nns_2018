package edu.aku.hassannaqvi.nns_2018.contracts_dbflow;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;
import com.raizlabs.android.dbflow.structure.BaseModel;

import edu.aku.hassannaqvi.nns_2018.AppDB;

/**
 * Created by javed.khan on 3/27/2018.
 */

@Table(database = AppDB.class)
public class EnumBlockContract extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    @Unique
    public int _id;
    @Column
    public String projectname = "NNS-2018";
    @Column
    private String NULLHACK;
    @Column
    private String ebcode;
    @Column
    private String geoarea;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getNULLHACK() {
        return NULLHACK;
    }

    public void setNULLHACK(String NULLHACK) {
        this.NULLHACK = NULLHACK;
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
}