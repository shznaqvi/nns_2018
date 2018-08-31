package edu.aku.hassannaqvi.nns_2018.sync;

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

import edu.aku.hassannaqvi.nns_2018.JSONModels.JSONA2ModelClass;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract.familyMembers;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.other.JSONUtilClass;

import static android.content.Context.MODE_PRIVATE;

public class SyncMembers extends AsyncTask<Void, Integer, String> {
    private String TAG = "";
    Context context;
    String clusterNo, hhno;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    public SyncMembers(Context context, String clusterNo, String hhno) {
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
        Log.d(TAG, "doInBackground: URL " + MainApp.MembersURL);

        return downloadUrl();
    }

    private String downloadUrl() {
        String line = "No Response";
        HttpURLConnection connection = null;
        try {
            String request = MainApp._HOST_URL + MainApp.MembersURL;
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
                FamilyMembersContract fm = new FamilyMembersContract();
                //Mapping A2 inside json
                JSONA2ModelClass jsonA2 = new JSONA2ModelClass();
                jsonA2.setCluster_no(jsonObject.getString("cluster_no"));
                jsonA2.setResp(jsonObject.getString("resp"));
                jsonA2.setnh2SerialNo(jsonObject.getString("nh2SerialNo"));
                jsonA2.setnh202(jsonObject.getString("nh202"));
                jsonA2.setnh203(jsonObject.getString("nh203"));
                jsonA2.setnh204(jsonObject.getString("nh204"));
                jsonA2.setnh2doby(jsonObject.getString("nh2doby"));
                jsonA2.setnh2dobm(jsonObject.getString("nh2dobm"));
                jsonA2.setnh2dobd(jsonObject.getString("nh2dobd"));
                jsonA2.setnh206y(jsonObject.getString("nh206y"));
                jsonA2.setAge(jsonObject.getString("age"));
                jsonA2.setnh207(jsonObject.getString("nh207"));
                jsonA2.setnh208(jsonObject.getString("nh208"));
                jsonA2.setnh209(jsonObject.getString("nh209"));
                jsonA2.setnh20996x(jsonObject.getString("nh20996x"));
                jsonA2.setnh210(jsonObject.getString("nh210"));
                jsonA2.setnh211(jsonObject.getString("nh211"));
                jsonA2.setnh212(jsonObject.getString("nh212"));

                fm.setsA2(JSONUtilClass.getJSONFromModel(jsonA2, JSONA2ModelClass.class));
                //setting all values in family members contract
                fm.set_UID(jsonObject.getString(familyMembers.COLUMN_UID));
                fm.set_UUID(jsonObject.getString(familyMembers.COLUMN_UUID));
                fm.setFormDate(jsonObject.getString(familyMembers.COLUMN_FORMDATE));
                fm.setUser(jsonObject.getString(familyMembers.COLUMN_USER));
                fm.setHhNo(jsonObject.getString(familyMembers.COLUMN_HH_NO));
                fm.setEnmNo(jsonObject.getString(familyMembers.COLUMN_ENM_NO));
                fm.setAv(jsonObject.getString(familyMembers.COLUMN_AV));
                fm.setDevicetagID(jsonObject.getString(familyMembers.COLUMN_DEVICETAGID));
                fm.setDeviceId(jsonObject.getString(familyMembers.COLUMN_DEVICEID));
                DatabaseHelper db = new DatabaseHelper(context);
                db.saveAnthroMembersFromServer(fm);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Failed to get members " + result, Toast.LENGTH_SHORT).show();
        }
    }
}
