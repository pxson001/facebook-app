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

/* compiled from: loading_text */
public class DeleteInfoRequestMethod implements ApiMethod<DeleteInfoRequestParams, Void> {
    public final ApiRequest m8481a(Object obj) {
        DeleteInfoRequestParams deleteInfoRequestParams = (DeleteInfoRequestParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("field_types", "[\"" + Joiner.on("\",\"").skipNulls().join(deleteInfoRequestParams.f8573b) + "\"]"));
        a.add(new BasicNameValuePair("location", "ANDROID_ABOUT_PAGE"));
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s/info_requests", deleteInfoRequestParams.f8572a);
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "delete_info_request";
        newBuilder = newBuilder;
        newBuilder.c = "DELETE";
        newBuilder = newBuilder;
        newBuilder.d = formatStrLocaleSafe;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.k = ApiResponseType.JSON;
        return apiRequestBuilder2.C();
    }

    public final Object m8482a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
