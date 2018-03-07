package com.facebook.profile.inforequest.protocol;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: load_friend_list */
public class InfoRequestMethod implements ApiMethod<InfoRequestParams, Void> {
    public final ApiRequest m8483a(Object obj) {
        InfoRequestParams infoRequestParams = (InfoRequestParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("field_types", "[\"" + Joiner.on("\",\"").skipNulls().join(infoRequestParams.f8575b) + "\"]"));
        a.add(new BasicNameValuePair("message", infoRequestParams.f8576c));
        a.add(new BasicNameValuePair("location", "ANDROID_ABOUT_PAGE"));
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s/info_requests", infoRequestParams.f8574a);
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "ask_info_request";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = formatStrLocaleSafe;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.k = ApiResponseType.JSON;
        return apiRequestBuilder2.C();
    }

    public final Object m8484a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
