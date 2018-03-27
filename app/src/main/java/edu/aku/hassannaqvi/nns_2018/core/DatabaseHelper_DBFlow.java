package edu.aku.hassannaqvi.nns_2018.core;

import android.content.Context;
import android.database.SQLException;
import android.util.Log;

import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.BLRandom;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.BLRandom_Table;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.Child;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.Child_Table;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.EligibleMembers;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.EligibleMembers_Table;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.EnumBlock;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.EnumBlock_Table;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.FamilyMembers;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.FamilyMembers_Table;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.FormContract;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.FormContract_Table;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.MWRA;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.MWRA_Table;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.Nutrition;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.Nutrition_Table;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.Outcome;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.Outcome_Table;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.Recipients;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.Recipients_Table;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.Serial;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.Serial_Table;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.Users;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.Users_Table;
import edu.aku.hassannaqvi.nns_2018.contracts_dbflow.VersionApp;

/**
 * Created by wajah on 3/28/2018.
 */

public class DatabaseHelper_DBFlow {

    public static final String DATABASE_NAME = "nns_2018.db";
    public static final String DB_NAME = DATABASE_NAME.replace(".", "_copy.");
    public static final String PROJECT_NAME = "NNS-2018";
    private final String TAG = "DatabaseHelper";
    public String spDateT = new SimpleDateFormat("dd-MM-yy").format(new Date().getTime());

    public DatabaseHelper_DBFlow(Context context) {
        //super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //super(context, "tempdbname.db", null, 1);
    }


    public void syncEnumBlocks(JSONArray Enumlist) {

        Delete.table(EnumBlock.class);
        try {
            JSONArray jsonArray = Enumlist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                EnumBlock Vc = EnumBlock.Sync(jsonObjectCC);
                Vc.insert();
            }
        } catch (Exception e) {
        }

        /*
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(EnumBlockTable.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = Enumlist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                EnumBlockContract Vc = new EnumBlockContract();
                Vc.Sync(jsonObjectCC);

                ContentValues values = new ContentValues();

                values.put(EnumBlockTable.COLUMN_EB_CODE, Vc.getEbcode());
                values.put(EnumBlockTable.COLUMN_GEO_AREA, Vc.getTalukaName());

                db.insert(EnumBlockTable.TABLE_NAME, null, values);
            }
        } catch (Exception e) {
        } finally {
            db.close();
        }
        */
    }


    public void syncVersionApp(JSONArray Versionlist) {

        Delete.table(VersionApp.class);
        try {
            JSONArray jsonArray = Versionlist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                VersionApp vapp = VersionApp.Sync(jsonObjectCC);
                vapp.insert();
            }
        } catch (Exception e) {
        }

        /*
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(VersionAppTable.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = Versionlist;
            JSONObject jsonObjectCC = jsonArray.getJSONObject(0);

            VersionAppContract Vc = new VersionAppContract();
            Vc.Sync(jsonObjectCC);

            ContentValues values = new ContentValues();

            values.put(VersionAppTable.COLUMN_PATH_NAME, Vc.getPathname());
            values.put(VersionAppTable.COLUMN_VERSION_CODE, Vc.getVersioncode());

            db.insert(VersionAppTable.TABLE_NAME, null, values);
        } catch (Exception e) {
        } finally {
            db.close();
        }
        */
    }

    public void syncBLRandom(JSONArray BLlist) {

        Delete.table(BLRandom.class);
        try {
            JSONArray jsonArray = BLlist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                BLRandom blobj = BLRandom.Sync(jsonObjectCC);
                blobj.insert();
            }
        } catch (Exception e) {
        }

        /*
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(singleRandomHH.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = BLlist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                BLRandomContract Vc = new BLRandomContract();
                Vc.Sync(jsonObjectCC);

                ContentValues values = new ContentValues();

                values.put(singleRandomHH.COLUMN_ID, Vc.get_ID());
                values.put(singleRandomHH.COLUMN_LUID, Vc.getLUID());
                values.put(singleRandomHH.COLUMN_STRUCTURE_NO, Vc.getStructure());
                values.put(singleRandomHH.COLUMN_FAMILY_EXT_CODE, Vc.getExtension());
                values.put(singleRandomHH.COLUMN_HH, Vc.getHh());
                values.put(singleRandomHH.COLUMN_ENUM_BLOCK_CODE, Vc.getSubVillageCode());
                values.put(singleRandomHH.COLUMN_RANDOMDT, Vc.getRandomDT());
                values.put(singleRandomHH.COLUMN_HH_HEAD, Vc.getHhhead());
                values.put(singleRandomHH.COLUMN_CONTACT, Vc.getContact());
                values.put(singleRandomHH.COLUMN_HH_SELECTED_STRUCT, Vc.getSelStructure());

                db.insert(singleRandomHH.TABLE_NAME, null, values);
            }
        } catch (Exception e) {
        } finally {
            db.close();
        }
        */
    }


    public String getUIDByHH(String subAreaCode, String hh) {

        String uid = null;

        List<FormContract> formContractList = SQLite.select(edu.aku.hassannaqvi.nns_2018.contracts_dbflow.FormContract_Table._id,
                edu.aku.hassannaqvi.nns_2018.contracts_dbflow.FormContract_Table._uid)
                .from(FormContract.class)
                .where(edu.aku.hassannaqvi.nns_2018.contracts_dbflow.FormContract_Table.enm_no.is(subAreaCode))
                .and(edu.aku.hassannaqvi.nns_2018.contracts_dbflow.FormContract_Table.hh_no.is(hh))
                .and(edu.aku.hassannaqvi.nns_2018.contracts_dbflow.FormContract_Table.istatus.is("1"))
                .orderBy(edu.aku.hassannaqvi.nns_2018.contracts_dbflow.FormContract_Table._id, false)
                .limit(1)
                .queryList();

        if (formContractList.size() == 1)
            uid = formContractList.get(0).get_uid();

        return uid;

        /*
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {

                FormsTable._ID,
                FormsTable.COLUMN_UID,

        };

        String whereClause = FormsTable.COLUMN_ENM_NO + "=? AND " +
                FormsTable.COLUMN_HH_NO + "=? AND " +
                FormsTable.COLUMN_ISTATUS + "=?";
        String[] whereArgs = new String[]{subAreaCode, hh, "1"};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable._ID + " DESC LIMIT 1";

        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext() && c.getCount() == 1) {
                return (c.getString(c.getColumnIndex(FormsTable.COLUMN_UID)));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return null;
        */
    }


    public Collection<FamilyMembers> getAllMembersByHH(String uid) {

        List<FamilyMembers> familyMembersList = SQLite.select().from(FamilyMembers.class)
                .where(FamilyMembers_Table._uuid.is(uid))
                .orderBy(FamilyMembers_Table._id, true)
                .queryList();

        return familyMembersList;

        /*
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {

                familyMembers.COLUMN_ID,
                familyMembers.COLUMN_UID,
                familyMembers.COLUMN_UUID,
                familyMembers.COLUMN_FORMDATE,
                familyMembers.COLUMN_USER,
                familyMembers.COLUMN_HH_NO,
                familyMembers.COLUMN_ENM_NO,
                familyMembers.COLUMN_SA2,
                familyMembers.COLUMN_DEVICETAGID,
                familyMembers.COLUMN_DEVICEID,
                familyMembers.COLUMN_SYNCED,
                familyMembers.COLUMN_SYNCED_DATE,
                familyMembers.COLUMN_APP_VERSION

        };

        String whereClause = familyMembers.COLUMN_UUID + "=? ";
        //+ familyMembers.COLUMN_HH_NO + "=?";
        String[] whereArgs = new String[]{uid};
        String groupBy = null;
        String having = null;

        String orderBy =
                familyMembers.COLUMN_ID + " ASC";

        Collection<FamilyMembersContract> allBL = new ArrayList<>();
        try {
            c = db.query(
                    familyMembers.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FamilyMembersContract dc = new FamilyMembersContract();
                allBL.add(dc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allBL;
        */
    }


    public Collection<BLRandom> getAllBLRandom(String subAreaCode, String hh) {

        List<BLRandom> blRandomList = SQLite.select().from(BLRandom.class)
                .where(BLRandom_Table.enum_Block_code.is(subAreaCode))
                .and(BLRandom_Table.hh.is(hh))
                .orderBy(BLRandom_Table._id, true)
                .queryList();

        return blRandomList;


        /*
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                singleRandomHH.COLUMN_ID,
                singleRandomHH.COLUMN_LUID,
                singleRandomHH.COLUMN_STRUCTURE_NO,
                singleRandomHH.COLUMN_FAMILY_EXT_CODE,
                singleRandomHH.COLUMN_HH,
                singleRandomHH.COLUMN_ENUM_BLOCK_CODE,
                singleRandomHH.COLUMN_RANDOMDT,
                singleRandomHH.COLUMN_HH_SELECTED_STRUCT,
                singleRandomHH.COLUMN_CONTACT,
                singleRandomHH.COLUMN_HH_HEAD
        };

        String whereClause = singleRandomHH.COLUMN_ENUM_BLOCK_CODE + "=? AND " +
                singleRandomHH.COLUMN_HH + "=?";
        String[] whereArgs = new String[]{subAreaCode, hh};
        String groupBy = null;
        String having = null;

        String orderBy =
                singleRandomHH.COLUMN_ID + " ASC";

        Collection<BLRandomContract> allBL = new ArrayList<>();
        try {
            c = db.query(
                    singleRandomHH.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                BLRandomContract dc = new BLRandomContract();
                allBL.add(dc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allBL;
        */
    }

    public String getEnumBlock(String enumBlock) {

        List<EnumBlock> enmList = SQLite.select().from(EnumBlock.class)
                .where(EnumBlock_Table.ebcode.is(enumBlock))
                .orderBy(EnumBlock_Table._id, true)
                .queryList();

        String allEB = "";

        for (EnumBlock enm : enmList) {
            allEB = enm.getGeoarea();
        }

        return allEB;

        /*SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                EnumBlockTable._ID,
                EnumBlockTable.COLUMN_EB_CODE,
                EnumBlockTable.COLUMN_GEO_AREA
        };

        String whereClause = EnumBlockTable.COLUMN_EB_CODE + " =?";
        String[] whereArgs = new String[]{enumBlock};
        String groupBy = null;
        String having = null;

        String orderBy =
                EnumBlockTable._ID + " ASC";

        String allEB = "";
        try {
            c = db.query(
                    EnumBlockTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allEB = c.getString(c.getColumnIndex(EnumBlockTable.COLUMN_GEO_AREA));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }*/
        // return allEB;
    }

    public VersionApp getVersionApp() {

        VersionApp versionApp = SQLite.select().from(VersionApp.class)
                .orderBy(Serial_Table._id, true)
                .querySingle();

        return versionApp;

        /*
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                VersionAppTable._ID,
                VersionAppTable.COLUMN_VERSION_CODE,
                VersionAppTable.COLUMN_PATH_NAME
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy = singleSerial._ID + " ASC";

        VersionAppContract allVC = new VersionAppContract();
        try {
            c = db.query(
                    VersionAppTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allVC.hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allVC;
        */
    }

    public Serial getSerialWRTDate(String date) {

        Serial serial = SQLite.select().from(Serial.class)
                .where(Serial_Table.date.is(date))
                .orderBy(Serial_Table._id, true)
                .querySingle();

        return serial;

        /*
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                singleSerial._ID,
                singleSerial.COLUMN_DEVICE_ID,
                singleSerial.COLUMN_DATE,
                singleSerial.COLUMN_SERIAL_NO,
        };

        String whereClause = singleSerial.COLUMN_DATE + " =?";
        String[] whereArgs = new String[]{date};
        String groupBy = null;
        String having = null;

        String orderBy =
                singleSerial._ID + " ASC";

        SerialContract allDC = new SerialContract();
        try {
            c = db.query(
                    singleSerial.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allDC.hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
        */
    }


    public void syncUser(JSONArray userlist) {

        Delete.table(Users.class);
        try {
            JSONArray jsonArray = userlist;
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);

                Users user = Users.Sync(jsonObjectUser);
                user.insert();

            }


        } catch (Exception e) {
            Log.d(TAG, "syncUser(e): " + e);
        } finally {
            //db.close();
        }

        /*
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersTable.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = userlist;
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);

                UsersContract user = new UsersContract();
                user.Sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(UsersContract.UsersTable.ROW_USERNAME, user.getUserName());
                values.put(UsersTable.ROW_PASSWORD, user.getPassword());
                values.put(UsersTable.FULL_NAME, user.getFULL_NAME());
                db.insert(UsersTable.TABLE_NAME, null, values);
            }


        } catch (Exception e) {
            Log.d(TAG, "syncUser(e): " + e);
        } finally {
            db.close();
        }
        */
    }

    public boolean Login(String username, String password) throws SQLException {

        List<Users> usersList = SQLite.select().from(Users.class)
                .where(Users_Table.username.is(username))
                .and(Users_Table.password.is(password))
                .queryList();

        return usersList.size() > 0;

        /*
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        String[] columns = {
                UsersTable._ID
        };

// Which row to update, based on the ID
        String selection = UsersContract.UsersTable.ROW_USERNAME + " = ?" + " AND " + UsersContract.UsersTable.ROW_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(UsersContract.UsersTable.TABLE_NAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        return cursorCount > 0;
        */
    }

    public Long addSerialForm(Serial sc) {

        return sc.insert();

        /*
        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(singleSerial.COLUMN_DEVICE_ID, sc.getDeviceid());
        values.put(singleSerial.COLUMN_DATE, sc.getdt());
        values.put(singleSerial.COLUMN_SERIAL_NO, sc.getSerialno());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                singleSerial.TABLE_NAME,
                singleSerial.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
        */
    }





    /*public int updateFormID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_UID, MainApp.fc.getUID());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }
*/
    /*public int updateFamilyMemberID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(familyMembers.COLUMN_UID, MainApp.fmc.get_UID());

// Which row to update, based on the ID
        String selection = familyMembers.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fmc.get_ID())};

        int count = db.update(familyMembers.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }
*/

    /*public int updateMWRAID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MWRATable.COLUMN_UID, MainApp.mc.get_UID());

// Which row to update, based on the ID
        String selection = MWRATable.COLUMN__ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.mc.get_ID())};

        int count = db.update(MWRATable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }*/

    /*public int updateNutritionID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(NutritionTable.COLUMN_UID, MainApp.nc.get_UID());

// Which row to update, based on the ID
        String selection = NutritionTable.COLUMN__ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.nc.get_ID())};

        int count = db.update(NutritionTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }*/

/*    public int updateOutcomeID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(outcomeTable.COLUMN_UID, MainApp.oc.get_UID());

// Which row to update, based on the ID
        String selection = outcomeTable.COLUMN__ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.oc.get_ID())};

        int count = db.update(outcomeTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }*/
/*

    public int updateRecepientID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(RecipientsTable.COLUMN_UID, MainApp.rc.get_UID());

// Which row to update, based on the ID
        String selection = RecipientsTable.COLUMN__ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.rc.get_ID())};

        int count = db.update(RecipientsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }
*/

  /*  public int updateFormChildID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ChildTable.COLUMN__UID, MainApp.cc.getUID());

// Which row to update, based on the ID
        String selection = ChildTable.COLUMN__ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.cc.get_ID())};

        int count = db.update(ChildTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }
*/

    /* public int updateEligibleMemberID() {
         SQLiteDatabase db = this.getReadableDatabase();

 // New value for one column
         ContentValues values = new ContentValues();
         values.put(eligibleMembers.COLUMN_UID, MainApp.emc.get_UID());

 // Which row to update, based on the ID
         String selection = eligibleMembers.COLUMN__ID + " = ?";
         String[] selectionArgs = {String.valueOf(MainApp.emc.get_ID())};

         int count = db.update(eligibleMembers.TABLE_NAME,
                 values,
                 selection,
                 selectionArgs);
         return count;
     }
 */
    public Collection<FormContract> getUnsyncedForms() {

        List<FormContract> formsList = SQLite.select().from(FormContract.class)
                .where(FormContract_Table.synced.is("null"))
                .or(FormContract_Table.synced.is("''"))
                .orderBy(FormContract_Table._id, true)
                .queryList();

        return formsList;

        /*
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_USER,
                FormsTable.COLUMN_RESP_LNO,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_ISTATUS88x,
                //FormsTable.COLUMN_GPSELEV,
                FormsTable.COLUMN_HH_NO,
                FormsTable.COLUMN_ENM_NO,
                FormsTable.COLUMN_SA1,
                FormsTable.COLUMN_SA4,
                FormsTable.COLUMN_SA5,
                FormsTable.COLUMN_SB4,
                FormsTable.COLUMN_COUNT,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_SYNCED,
                FormsTable.COLUMN_SYNCED_DATE,
                FormsTable.COLUMN_APP_VERSION
        };
        String whereClause = FormsTable.COLUMN_SYNCED + " is null OR " + FormsTable.COLUMN_SYNCED + " = '' ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable._ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
        */
    }


    public Collection<FamilyMembers> getUnsyncedFamilyMembers() {

        List<FamilyMembers> familList = SQLite.select().from(FamilyMembers.class)
                .where(FamilyMembers_Table.synced.is("null"))
                .or(FamilyMembers_Table.synced.is("''"))
                .orderBy(FamilyMembers_Table._id, true)
                .queryList();

        return familList;

        /*
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                familyMembers._ID,
                familyMembers.COLUMN_UID,
                familyMembers.COLUMN_UUID,
                familyMembers.COLUMN_FORMDATE,
                familyMembers.COLUMN_USER,
                //FormsTable.COLUMN_GPSELEV,
                familyMembers.COLUMN_HH_NO,
                familyMembers.COLUMN_ENM_NO,
                familyMembers.COLUMN_SA2,
                familyMembers.COLUMN_DEVICETAGID,
                familyMembers.COLUMN_DEVICEID,
                familyMembers.COLUMN_SYNCED,
                familyMembers.COLUMN_SYNCED_DATE,
                familyMembers.COLUMN_APP_VERSION
        };
        String whereClause = familyMembers.COLUMN_SYNCED + " is null OR " + familyMembers.COLUMN_SYNCED + " = '' ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                familyMembers._ID + " ASC";

        Collection<FamilyMembersContract> allFC = new ArrayList<FamilyMembersContract>();
        try {
            c = db.query(
                    familyMembers.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FamilyMembersContract fc = new FamilyMembersContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
        */
    }


    public Collection<Child> getUnsyncedChildForms() {

        List<Child> childList = SQLite.select().from(Child.class)
                .where(Child_Table.synced.is("null"))
                .or(Child_Table.synced.is("''"))
                .orderBy(Child_Table._id, true)
                .queryList();

        return childList;

        /*
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ChildTable.COLUMN__ID,
                ChildTable.COLUMN__UID,
                ChildTable.COLUMN__UUID,
                ChildTable.COLUMN_FORMDATE,
                ChildTable.COLUMN_USER,
                ChildTable.COLUMN_C1SERIALNO,
                ChildTable.COLUMN_SC1,
                ChildTable.COLUMN_SC2,
                ChildTable.COLUMN_SC3,
                ChildTable.COLUMN_SC4,
                ChildTable.COLUMN_SC5,
                ChildTable.COLUMN_DEVICEID,
                ChildTable.COLUMN_DEVICETAGID,
                ChildTable.COLUMN_SYNCED,
                ChildTable.COLUMN_SYNCED_DATE,
                ChildTable.COLUMN_APPVERSION,
                ChildTable.COLUMN_CSTATUS,
                ChildTable.COLUMN_CSTATUS88x,

        };
        String whereClause = ChildContract.ChildTable.COLUMN_SYNCED + " is null OR " + ChildTable.COLUMN_SYNCED + " = '' ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                ChildTable.COLUMN__ID + " ASC";

        Collection<ChildContract> allFC = new ArrayList<ChildContract>();
        try {
            c = db.query(
                    ChildTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ChildContract fc = new ChildContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
        */
    }


    public Collection<EligibleMembers> getUnsyncedEligbleMembers() {

        List<EligibleMembers> eliList = SQLite.select().from(EligibleMembers.class)
                .where(EligibleMembers_Table.synced.is("null"))
                .or(EligibleMembers_Table.synced.is("''"))
                .orderBy(EligibleMembers_Table._id, true)
                .queryList();

        return eliList;


        /*
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                eligibleMembers.COLUMN__ID,
                eligibleMembers.COLUMN_UID,
                eligibleMembers.COLUMN_UUID,
                eligibleMembers.COLUMN_FORMDATE,
                eligibleMembers.COLUMN_DEVICEID,
                eligibleMembers.COLUMN_DEVICETAGID,
                eligibleMembers.COLUMN_USER,
                eligibleMembers.COLUMN_APPVERSION,
                eligibleMembers.COLUMN_ENM_NO,
                eligibleMembers.COLUMN_HH_NO,
                eligibleMembers.COLUMN_DOB,
                eligibleMembers.COLUMN_AGE,
                eligibleMembers.COLUMN_na204,
                eligibleMembers.COLUMN_SA3,
                eligibleMembers.COLUMN_ISTATUS,
                eligibleMembers.COLUMN_ISTATUS88x,
                eligibleMembers.COLUMN_SYNCED,
                eligibleMembers.COLUMN_SYNCEDDATE,

        };
        String whereClause = eligibleMembers.COLUMN_SYNCED + " is null OR " + eligibleMembers.COLUMN_SYNCED + " = '' ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                eligibleMembers.COLUMN__ID + " ASC";

        Collection<EligibleMembersContract> allFC = new ArrayList<EligibleMembersContract>();
        try {
            c = db.query(
                    eligibleMembers.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                EligibleMembersContract fc = new EligibleMembersContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
        */
    }


    public Collection<MWRA> getUnsyncedMWRA() {

        List<MWRA> mwraList = SQLite.select().from(MWRA.class)
                .where(MWRA_Table.synced.is("null"))
                .or(MWRA_Table.synced.is("''"))
                .orderBy(MWRA_Table._id, true)
                .queryList();

        return mwraList;

        /*
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                MWRATable.COLUMN__ID,
                MWRATable.COLUMN_UID,
                MWRATable.COLUMN_UUID,
                MWRATable.COLUMN_FORMDATE,
                MWRATable.COLUMN_DEVICEID,
                MWRATable.COLUMN_DEVICETAGID,
                MWRATable.COLUMN_USER,
                MWRATable.COLUMN_APP_VER,
                MWRATable.COLUMN_B1SERIALNO,
                MWRATable.COLUMN_SB1,
                MWRATable.COLUMN_SB2,
                MWRATable.COLUMN_SB3,
                MWRATable.COLUMN_SB4,
                MWRATable.COLUMN_SB5,
                MWRATable.COLUMN_SB6,
                MWRATable.COLUMN_MSTATUS,
                MWRATable.COLUMN_MSTATUS88x,
                MWRATable.COLUMN_SYNCED,
                MWRATable.COLUMN_SYNCEDDATE

        };
        String whereClause = MWRATable.COLUMN_SYNCED + " is null OR " + MWRATable.COLUMN_SYNCED + " = '' ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                MWRATable.COLUMN__ID + " ASC";

        Collection<MWRAContract> allFC = new ArrayList<MWRAContract>();
        try {
            c = db.query(
                    MWRATable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                MWRAContract fc = new MWRAContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
        */
    }


    public Collection<Nutrition> getUnsyncedNutrition() {

        List<Nutrition> nutritionList = SQLite.select().from(Nutrition.class)
                .where(Nutrition_Table.synced.is("null"))
                .or(Nutrition_Table.synced.is("''"))
                .orderBy(Nutrition_Table._id, true)
                .queryList();

        return nutritionList;

        /*
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                NutritionTable.COLUMN__ID,
                NutritionTable.COLUMN_UID,
                NutritionTable.COLUMN_UUID,
                NutritionTable.COLUMN_FORMDATE,
                NutritionTable.COLUMN_DEVICEID,
                NutritionTable.COLUMN_DEVICETAGID,
                NutritionTable.COLUMN_USER,
                NutritionTable.COLUMN_APP_VER,
                NutritionTable.COLUMN_SB6,

                NutritionTable.COLUMN_SYNCED,
                NutritionTable.COLUMN_SYNCEDDATE,

        };
        String whereClause = NutritionTable.COLUMN_SYNCED + " is null OR " + NutritionTable.COLUMN_SYNCED + " = '' ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                NutritionTable.COLUMN__ID + " ASC";

        Collection<NutritionContract> allFC = new ArrayList<NutritionContract>();
        try {
            c = db.query(
                    NutritionTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                NutritionContract fc = new NutritionContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
        */
    }


    public Collection<Recipients> getUnsyncedRecipients() {

        List<Recipients> recipientsList = SQLite.select().from(Recipients.class)
                .where(Recipients_Table.synced.is("null"))
                .or(Recipients_Table.synced.is("''"))
                .orderBy(Recipients_Table._id, true)
                .queryList();

        return recipientsList;

        /*
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                RecipientsTable.COLUMN__ID,
                RecipientsTable.COLUMN_UID,
                RecipientsTable.COLUMN_UUID,
                RecipientsTable.COLUMN_FORMDATE,
                RecipientsTable.COLUMN_DEVICEID,
                RecipientsTable.COLUMN_DEVICETAGID,
                RecipientsTable.COLUMN_USER,
                RecipientsTable.COLUMN_APP_VER,
                RecipientsTable.COLUMN_A8ASNO,
                RecipientsTable.COLUMN_SA8A,

                RecipientsTable.COLUMN_SYNCED,
                RecipientsTable.COLUMN_SYNCEDDATE,

        };
        String whereClause = RecipientsTable.COLUMN_SYNCED + " is null OR " + RecipientsTable.COLUMN_SYNCED + " = '' ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                RecipientsTable.COLUMN__ID + " ASC";

        Collection<RecipientsContract> allFC = new ArrayList<RecipientsContract>();
        try {
            c = db.query(
                    RecipientsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                RecipientsContract fc = new RecipientsContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
        */
    }


    public Collection<Outcome> getUnsyncedOutcome() {

        List<Outcome> outcomList = SQLite.select().from(Outcome.class)
                .where(Outcome_Table.synced.is("null"))
                .or(Outcome_Table.synced.is("''"))
                .orderBy(Outcome_Table._id, true)
                .queryList();

        return outcomList;

        /*

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                outcomeTable.COLUMN__ID,
                outcomeTable.COLUMN_UID,
                outcomeTable.COLUMN_UUID,
                outcomeTable.COLUMN_FORMDATE,
                outcomeTable.COLUMN_DEVICEID,
                outcomeTable.COLUMN_DEVICETAGID,
                outcomeTable.COLUMN_USER,
                outcomeTable.COLUMN_APP_VER,
                outcomeTable.COLUMN_B1APregSNO,
                outcomeTable.COLUMN_SB1A,

                outcomeTable.COLUMN_SYNCED,
                outcomeTable.COLUMN_SYNCEDDATE,

        };
        String whereClause = outcomeTable.COLUMN_SYNCED + " is null OR " + outcomeTable.COLUMN_SYNCED + " = '' ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                outcomeTable.COLUMN__ID + " ASC";

        Collection<OutcomeContract> allFC = new ArrayList<OutcomeContract>();
        try {
            c = db.query(
                    outcomeTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                OutcomeContract fc = new OutcomeContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
        */
    }


    public Collection<Serial> getUnsyncedSerials() {

        List<Serial> seriaslist = SQLite.select().from(Serial.class)
                .where(Serial_Table.synced.is("null"))
                .or(Serial_Table.synced.is("''"))
                .orderBy(Serial_Table._id, true)
                .queryList();

        return seriaslist;


        /*
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                singleSerial._ID,
                singleSerial.COLUMN_DEVICE_ID,
                singleSerial.COLUMN_DATE,
                singleSerial.COLUMN_SERIAL_NO,
                singleSerial.COLUMN_SYNCED,
                singleSerial.COLUMN_SYNCED_DATE
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                singleSerial._ID + " ASC";

        Collection<SerialContract> allFC = new ArrayList<SerialContract>();
        try {
            c = db.query(
                    singleSerial.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                SerialContract fc = new SerialContract();
                allFC.add(fc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
        */
    }


    public Collection<FormContract> getTodayForms() {

        List<FormContract> formContractList = SQLite.select().from(FormContract.class)
                .where(FormContract_Table.formdate.like("%" + spDateT.substring(0, 8).trim() + "%"))
                .orderBy(FormContract_Table._id, true)
                .queryList();

        return formContractList;


        /*
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_HH_NO,
                FormsTable.COLUMN_ENM_NO,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SYNCED,

        };
        String whereClause = FormsTable.COLUMN_FORMDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable._ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                fc.set_ID(c.getString(c.getColumnIndex(FormsTable._ID)));
                fc.setEnmNo(c.getString(c.getColumnIndex(FormsTable.COLUMN_ENM_NO)));
                fc.setHhNo(c.getString(c.getColumnIndex(FormsTable.COLUMN_HH_NO)));
                fc.setFormDate(c.getString(c.getColumnIndex(FormsTable.COLUMN_FORMDATE)));
                fc.setIstatus(c.getString(c.getColumnIndex(FormsTable.COLUMN_ISTATUS)));
                fc.setSynced(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYNCED)));
                allFC.add(fc);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
        */
    }

}
