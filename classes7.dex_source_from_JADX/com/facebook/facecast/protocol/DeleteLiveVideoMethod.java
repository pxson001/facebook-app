package com.facebook.facecast.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.ImmutableList.Builder;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: ban_user_ */
public class DeleteLiveVideoMethod implements ApiMethod<String, Void> {
    public final ApiRequest m22304a(Object obj) {
        String str = (String) obj;
        Builder builder = new Builder();
        builder.c(new BasicNameValuePair("format", "json"));
        builder.c(new BasicNameValuePair("delay_delete", "true"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "graphLiveVideoDelete";
        newBuilder = newBuilder;
        newBuilder.c = "DELETE";
        newBuilder = newBuilder;
        newBuilder.d = "v2.3/" + str;
        newBuilder = newBuilder;
        newBuilder.g = builder.b();
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m22305a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
