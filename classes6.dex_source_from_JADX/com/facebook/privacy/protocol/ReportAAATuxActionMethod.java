package com.facebook.privacy.protocol;

import android.text.TextUtils;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

/* compiled from: sticker_keyboard_selected */
public final class ReportAAATuxActionMethod implements ApiMethod<ReportAAATuxActionParams, Boolean> {
    public final ApiRequest m6110a(Object obj) {
        ReportAAATuxActionParams reportAAATuxActionParams = (ReportAAATuxActionParams) obj;
        List a = Lists.a(6);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(reportAAATuxActionParams.f4149a);
        a.add(new BasicNameValuePair("events", jSONArray.toString()));
        a.add(new BasicNameValuePair("client_time", Long.toString(reportAAATuxActionParams.f4150b.longValue())));
        a.add(new BasicNameValuePair("surface", "fb4atux"));
        a.add(new BasicNameValuePair("log_exposure", Boolean.toString(false)));
        if (!TextUtils.isEmpty(reportAAATuxActionParams.f4151c)) {
            a.add(new BasicNameValuePair("source", reportAAATuxActionParams.f4151c));
        }
        a.add(new BasicNameValuePair("format", "json"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "reportAAATuxAction";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "me/audience_alignment_info";
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m6111a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(true);
    }
}
