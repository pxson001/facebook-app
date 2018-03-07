package com.facebook.selfupdate;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.tigon.iface.TigonRequest;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: extra_download_id */
public class AppApiMethod implements ApiMethod<AppServerParams, AppServerResponse> {
    public final ApiRequest m13257a(Object obj) {
        AppServerParams appServerParams = (AppServerParams) obj;
        List a = Lists.a(2);
        a.add(new BasicNameValuePair("queries", "{" + JSONObject.quote("channel") + ":" + JSONObject.quote("SELECT update_check_minutes FROM application_release_channel WHERE app_id='" + appServerParams.a + "' ORDER BY " + "update_check_minutes LIMIT 1") + ", " + JSONObject.quote("release") + ":" + JSONObject.quote("SELECT download_url, release_package, release_number, client_action, release_notes, application_name, application_version, allowed_networks, megaphone, file_mime_type, file_size FROM application_release WHERE app_id='" + appServerParams.a + "' AND " + "file_mime_type = '" + "application/vnd.android.package-archive'" + " AND release_number > " + appServerParams.b + " AND release_package = '" + appServerParams.c + "' AND match_client = 1" + " AND release_channel <> 'Expired' ORDER BY " + "release_number DESC" + " LIMIT 1") + "}"));
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("appUpdateFQLGet", TigonRequest.GET, "method/fql.multiquery", a, ApiResponseType.STRING);
    }

    public final Object m13258a(Object obj, ApiResponse apiResponse) {
        JSONObject jSONObject = null;
        JSONArray jSONArray = new JSONArray(apiResponse.b());
        JSONObject jSONObject2 = null;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
            if (jSONObject3.optString("name").equals("channel") && jSONObject3.getJSONArray("fql_result_set").length() > 0) {
                jSONObject2 = jSONObject3.getJSONArray("fql_result_set").getJSONObject(0);
            } else if (jSONObject3.optString("name").equals("release") && jSONObject3.getJSONArray("fql_result_set").length() > 0) {
                jSONObject = jSONObject3.getJSONArray("fql_result_set").getJSONObject(0);
            }
        }
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject("{}");
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject("{}");
        }
        return new AppServerResponse(jSONObject2, jSONObject);
    }
}
