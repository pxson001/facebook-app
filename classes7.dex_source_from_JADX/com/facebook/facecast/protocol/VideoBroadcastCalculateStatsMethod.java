package com.facebook.facecast.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* compiled from: b-www.facebook.com */
public class VideoBroadcastCalculateStatsMethod implements ApiMethod<VideoBroadcastCalculateStatsRequest, Void> {
    public final ApiRequest m22401a(Object obj) {
        VideoBroadcastCalculateStatsRequest videoBroadcastCalculateStatsRequest = (VideoBroadcastCalculateStatsRequest) obj;
        Map hashMap = new HashMap();
        hashMap.put("max_viewers", Integer.toString(videoBroadcastCalculateStatsRequest.f18800b));
        hashMap.put("recorded_audio_duration", Long.toString(videoBroadcastCalculateStatsRequest.f18801c));
        String jSONObject = new JSONObject(hashMap).toString();
        Builder builder = ImmutableList.builder();
        builder.c(new BasicNameValuePair("calculate_stats", Boolean.toString(true)));
        builder.c(new BasicNameValuePair("broadcast_client_status", jSONObject));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "video_broadcast_update";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = videoBroadcastCalculateStatsRequest.f18799a;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.g = builder.b();
        return newBuilder.C();
    }

    public final Object m22402a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
