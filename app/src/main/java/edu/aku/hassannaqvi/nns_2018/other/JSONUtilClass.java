package edu.aku.hassannaqvi.nns_2018.other;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gul.sanober on 3/7/2018.
 */

public class JSONUtilClass {

    public static JSONModelClass getModelFromJSON(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONModelClass demo = new JSONModelClass();
            demo.setName(jsonObject.getString("na202"));
            demo.setAge(jsonObject.getString("age"));
            demo.setMaritalStatus(jsonObject.getString("na207"));
            demo.setSerialNo(jsonObject.getString("na2SerialNo"));
            demo.setGender(jsonObject.getString("na204"));

            return demo;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*public static String getJSONFromModel(TestingDemoModel model)
    {
        String str = "";
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("var1Key", model.var1);
            jsonObject.put("nameKey", model.name);
            jsonObject.put("anyVarKey", model.anyVar);
            str = jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return str;
    }*/
}
