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

import edu.aku.hassannaqvi.nns_2018_lab_app.JSONModels.JSONE2ModelClass;
import edu.aku.hassannaqvi.nns_2018_lab_app.contracts.WaterSpecimenContract;
import edu.aku.hassannaqvi.nns_2018_lab_app.contracts.WaterSpecimenContract.WaterSpecimenTable;
import edu.aku.hassannaqvi.nns_2018_lab_app.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018_lab_app.core.MainApp;
import edu.aku.hassannaqvi.nns_2018_lab_app.other.JSONUtilClass;

public class SyncWater extends AsyncTask<Void, Integer, String> {
    Context context;
    String clusterNo, hhno;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    private String TAG = "";

    public SyncWater(Context context, String clusterNo, String hhno) {
        this.context = context;
        this.clusterNo = clusterNo;
        this.hhno = hhno;
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
        Log.d(TAG, "doInBackground: URL " + MainApp.WaterURL);

        return downloadUrl();
    }

    private String downloadUrl() {
        String line = "No Response";
        HttpURLConnection connection = null;
        try {
            String request = MainApp._HOST_URL + MainApp.WaterURL;
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
                    jsonObject.addProperty("cluster", clusterNo);
                    jsonObject.addProperty("hhno", hhno);

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
            for (int i = 0; i < json.length(); i++) {
                JSONObject jsonObject = json.getJSONObject(i);
                WaterSpecimenContract fm = new WaterSpecimenContract();
                //Mapping A2 inside json
                JSONE2ModelClass jsonE2 = new JSONE2ModelClass();
                jsonE2.setNe201a(jsonObject.getString("ne201a"));
                jsonE2.setNe20201(jsonObject.getString("ne20201"));

                fm.setsE2(JSONUtilClass.getJSONFromModel(jsonE2, JSONE2ModelClass.class));
                //setting all values in family members contract

                fm.setUID(jsonObject.getString(WaterSpecimenTable.COLUMN__UID));
                fm.setUUID(jsonObject.getString(WaterSpecimenTable.COLUMN__UUID));
                fm.setClusterno(jsonObject.getString(WaterSpecimenTable.COLUMN_CLUSTER));
                fm.setFormDate(jsonObject.getString(WaterSpecimenTable.COLUMN_FORMDATE));
                fm.setUser(jsonObject.getString(WaterSpecimenTable.COLUMN_USER));
                fm.setHhno(jsonObject.getString(WaterSpecimenTable.COLUMN_HH));
                fm.setDevicetagID(jsonObject.getString(WaterSpecimenTable.COLUMN_DEVICETAGID));
                fm.setDeviceID(jsonObject.getString(WaterSpecimenTable.COLUMN_DEVICEID));
                fm.setAppversion(jsonObject.getString(WaterSpecimenTable.COLUMN_APPVERSION));

                DatabaseHelper db = new DatabaseHelper(context);
                Boolean waterrecordAlreadyExist = db.CheckWaterRecordExist(fm.getClusterno(), fm.getHhno());
                if (!waterrecordAlreadyExist) {
                    db.saveWaterFromServer(fm);
                } else {
                    // Record already saved in DB
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Failed to get Water Records" + result, Toast.LENGTH_SHORT).show();
        }
    }
}
