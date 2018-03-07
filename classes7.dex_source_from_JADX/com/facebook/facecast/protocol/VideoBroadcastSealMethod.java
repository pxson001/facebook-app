package com.facebook.facecast.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: b-graph.facebook.com */
public class VideoBroadcastSealMethod implements ApiMethod<VideoBroadcastSealRequest, Void> {
    public final ApiRequest m22403a(Object obj) {
        VideoBroadcastSealRequest videoBroadcastSealRequest = (VideoBroadcastSealRequest) obj;
        Builder builder = ImmutableList.builder();
        builder.c(new BasicNameValuePair("seal_video_broadcast", Boolean.toString(true)));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "video_broadcast_update";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = videoBroadcastSealRequest.f18802a;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.g = builder.b();
        return newBuilder.C();
    }

    public final Object m22404a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
