package com.facebook.backgroundlocation.settings.write;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: crowdsourcing_create_claim */
public class BackgroundLocationUpdateSettingsMethod implements ApiMethod<BackgroundLocationUpdateSettingsParams, Boolean> {
    public final ApiRequest m20592a(Object obj) {
        BackgroundLocationUpdateSettingsParams backgroundLocationUpdateSettingsParams = (BackgroundLocationUpdateSettingsParams) obj;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "background-location-update-settings";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "/me/location_privacy";
        newBuilder = newBuilder;
        List a = Lists.a();
        if (backgroundLocationUpdateSettingsParams.f16526a.isPresent()) {
            a.add(new BasicNameValuePair("tracking", ((Boolean) backgroundLocationUpdateSettingsParams.f16526a.get()).toString()));
        }
        if (backgroundLocationUpdateSettingsParams.f16527b.isPresent()) {
            a.add(new BasicNameValuePair("privacy", (String) backgroundLocationUpdateSettingsParams.f16527b.get()));
        }
        newBuilder.g = a;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    public final Object m20593a(Object obj, ApiResponse apiResponse) {
        return Boolean.valueOf(apiResponse.c().u());
    }
}
