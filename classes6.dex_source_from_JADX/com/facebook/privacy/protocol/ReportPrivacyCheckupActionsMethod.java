package com.facebook.privacy.protocol;

import android.text.TextUtils;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.privacy.protocol.ReportPrivacyCheckupActionsParams.PrivacyCheckupItem;
import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

/* compiled from: stickerSearch */
public class ReportPrivacyCheckupActionsMethod implements ApiMethod<ReportPrivacyCheckupActionsParams, Boolean> {
    public final ApiRequest m6117a(Object obj) {
        ReportPrivacyCheckupActionsParams reportPrivacyCheckupActionsParams = (ReportPrivacyCheckupActionsParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("events", m6116a(reportPrivacyCheckupActionsParams.f4176a)));
        arrayList.add(new BasicNameValuePair("product", "fb4a"));
        arrayList.add(new BasicNameValuePair("session_id", Long.toString(reportPrivacyCheckupActionsParams.f4178c)));
        if (!TextUtils.isEmpty(reportPrivacyCheckupActionsParams.f4177b)) {
            arrayList.add(new BasicNameValuePair("experiment_name", reportPrivacyCheckupActionsParams.f4177b));
        }
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.d = "me/privacy_checkup_mobile_events";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = "POST";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.b = "reportPrivacyCheckupActions";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = arrayList;
        return apiRequestBuilder.a(RequestPriority.INTERACTIVE).C();
    }

    public final Object m6118a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(true);
    }

    @VisibleForTesting
    private static String m6116a(List<PrivacyCheckupItem> list) {
        JSONArray jSONArray = new JSONArray();
        for (PrivacyCheckupItem a : list) {
            jSONArray.put(a.m6120a());
        }
        return jSONArray.toString();
    }
}
