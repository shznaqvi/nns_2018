package edu.aku.hassannaqvi.nns_2018_lab_app.sync;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import edu.aku.hassannaqvi.nns_2018_lab_app.JSONModels.JSONA2ModelClass;
import edu.aku.hassannaqvi.nns_2018_lab_app.contracts.BLRandomContract;
import edu.aku.hassannaqvi.nns_2018_lab_app.contracts.BLRandomContract.singleRandomHH;
import edu.aku.hassannaqvi.nns_2018_lab_app.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018_lab_app.contracts.FamilyMembersContract.familyMembers;
import edu.aku.hassannaqvi.nns_2018_lab_app.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018_lab_app.core.MainApp;
import edu.aku.hassannaqvi.nns_2018_lab_app.other.JSONUtilClass;

public class SyncBLRandomWater extends AsyncTask<Void, Integer, String> {
    private String TAG = "";
    Context context;
    String hh02, hh03,hh07;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    public SyncBLRandomWater(Context context, String hh02, String hh03, String hh07) {
        this.context = context;
        this.hh02 = hh02;
        this.hh03 = hh03;
        this.hh07 = hh07;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(Void... voids) {
        Log.d(TAG, "doInBackground: URL " + MainApp.BLRandomWaterURL);

        return downloadUrl();
    }

    private String downloadUrl() {
        String line = "No Response";
        HttpURLConnection connection = null;
        try {
            String request = MainApp._HOST_URL + MainApp.BLRandomWaterURL;
            URL url = new URL(request);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            int HttpResult = connection.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {

                connection = (HttpURLConnection) url.openConnection();
                JsonObject jsonObject = new JsonObject();
                connection.setDoOutput(true);
                connection.setDoInput(true);
                connection.setInstanceFollowRedirects(false);
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("charset", "utf-8");
                connection.setUseCaches(false);
                connection.connect();

                DataOutputStream wr = new DataOutputStream(connection.getOutputStream());

                try {
                    jsonObject.addProperty("hh02", hh02);
                    jsonObject.addProperty("hh03", hh03);
                    jsonObject.addProperty("hh07", hh07);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                wr.writeBytes(jsonObject.toString().replace("\uFEFF", "") + "\n");
                wr.flush();


                BufferedReader br = new BufferedReader(new InputStreamReader(
                        connection.getInputStream(), "utf-8"));
                StringBuffer sb = new StringBuffer();

                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                System.out.println("" + sb.toString());
                return sb.toString();
            } else {
                System.out.println(connection.getResponseMessage());
                return connection.getResponseMessage();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            if (connection != null)
                connection.disconnect();
        }
        return line;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        int sSynced = 0;
        String sSyncedError = "";
        JSONArray json = null;
        try {
            json = new JSONArray(result);
            DatabaseHelper db = new DatabaseHelper(context);
            String uid = "";
//            db.saveBLRandomFromServer(json,);
            for (int i = 0; i < json.length(); i++) {
               JSONObject jsonObject = json.getJSONObject(i);
//                BLRandomContract bl = new BLRandomContract();
                //Mapping A2 inside json
                uid = jsonObject.getString(singleRandomHH.COLUMN_LUID);
/*
                bl.set_ID(jsonObject.getString(singleRandomHH.COLUMN_ID));
                bl.setRandomDT(jsonObject.getString(singleRandomHH.COLUMN_RANDOMDT));
                bl.setSno(jsonObject.getString(singleRandomHH.COLUMN_SNO_HH));
                bl.set(jsonObject.getString(singleRandomHH.COLUMN_SNO_HH));

                values.put(singleRandomHH.COLUMN_STRUCTURE_NO
                values.put(singleRandomHH.COLUMN_FAMILY_EXT_CODE, Vc.getExtension());
                values.put(singleRandomHH.COLUMN_HH, Vc.getHh());
                values.put(singleRandomHH.COLUMN_ENUM_BLOCK_CODE, Vc.getSubVillageCode());
                values.put(singleRandomHH.COLUMN_HH_HEAD, Vc.getHhhead());
                values.put(singleRandomHH.COLUMN_CONTACT, Vc.getContact());
                values.put(singleRandomHH.COLUMN_HH_SELECTED_STRUCT, Vc.getSelStructure());
*/
//                DatabaseHelper db = new DatabaseHelper(context);
            }
            db.saveBLRandomFromServer(json,uid);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Failed to get members " + result, Toast.LENGTH_SHORT).show();
        }
    }
}
