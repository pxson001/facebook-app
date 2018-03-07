package com.facebook.privacy.protocol;

import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.privacy.protocol.EditObjectsPrivacyParams.ObjectPrivacyEdit;
import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: sticker_store_pack */
public class EditObjectsPrivacyMethod implements ApiMethod<EditObjectsPrivacyParams, Boolean> {
    public final ApiRequest m6031a(Object obj) {
        EditObjectsPrivacyParams editObjectsPrivacyParams = (EditObjectsPrivacyParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("edits", m6030a(editObjectsPrivacyParams.f4132b)));
        arrayList.add(new BasicNameValuePair("caller", editObjectsPrivacyParams.f4131a));
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.d = "me/privacy_edits";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = "POST";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.b = "editObjectsPrivacy";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = arrayList;
        return apiRequestBuilder.a(RequestPriority.INTERACTIVE).C();
    }

    public final Object m6032a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(true);
    }

    @VisibleForTesting
    private static String m6030a(List<ObjectPrivacyEdit> list) {
        JSONArray jSONArray = new JSONArray();
        for (ObjectPrivacyEdit objectPrivacyEdit : list) {
            Map hashMap = new HashMap();
            hashMap.put("fbid", objectPrivacyEdit.f4127a);
            hashMap.put("client_time", String.valueOf(objectPrivacyEdit.f4128b));
            hashMap.put("type", objectPrivacyEdit.f4129c.toString());
            hashMap.put("privacy", objectPrivacyEdit.f4130d);
            jSONArray.put(new JSONObject(hashMap).toString());
        }
        return jSONArray.toString();
    }
}
