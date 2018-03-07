package com.facebook.video.videostreaming.protocol;

import com.facebook.debug.log.BLog;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* compiled from: roboto-medium */
public class VideoBroadcastInitMethod implements ApiMethod<String, VideoBroadcastInitResponse> {
    private static final Class<?> f5455a = VideoBroadcastInitMethod.class;

    public final ApiRequest m8138a(Object obj) {
        String str;
        String str2 = (String) obj;
        Builder builder = ImmutableList.builder();
        Map hashMap = new HashMap();
        hashMap.put("android_video_profile", "baseline");
        hashMap.put("stream_network_use_ssl_factory", "0");
        hashMap.put("client_render_duration_ms", Long.toString(15));
        builder.c(new BasicNameValuePair("broadcast_default_settings", new JSONObject(hashMap).toString()));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "newVideoBroadcastAndroid";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        if (str2 == null) {
            str = "video_broadcasts";
        } else {
            str = "/video_broadcasts";
        }
        newBuilder.d = str;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.g = builder.b();
        return newBuilder.C();
    }

    public final /* bridge */ /* synthetic */ Object m8139a(Object obj, ApiResponse apiResponse) {
        return m8135a(apiResponse);
    }

    private static VideoBroadcastInitResponse m8135a(ApiResponse apiResponse) {
        long j;
        boolean z;
        JsonNode c = apiResponse.c();
        JsonNode b = c.b("rtmp_publish_url");
        JsonNode b2 = c.b("social_context_entity_id");
        JsonNode b3 = c.b("id");
        JsonNode b4 = c.b("min_broadcast_duration");
        JsonNode b5 = c.b("max_time_in_seconds");
        JsonNode b6 = c.b("speed_test_ui_timeout");
        JsonNode b7 = c.b("send_stream_interrupted_interval_in_seconds");
        JsonNode b8 = c.b("stream_disk_recording_enabled");
        JsonNode b9 = c.b("client_render_duration_ms");
        Preconditions.checkNotNull(b);
        Preconditions.checkNotNull(b2);
        Preconditions.checkNotNull(b3);
        VideoBroadcastVideoStreamingConfig a = m8136a(c);
        VideoBroadcastAudioStreamingConfig b10 = m8137b(c);
        VideoBroadcastInitResponse.Builder builder = new VideoBroadcastInitResponse.Builder();
        builder.f5456a = b.s();
        VideoBroadcastInitResponse.Builder builder2 = builder;
        builder2.f5457b = b2.s();
        builder2 = builder2;
        builder2.f5458c = b3.s();
        VideoBroadcastInitResponse.Builder builder3 = builder2;
        if (b4 == null) {
            j = 4;
        } else {
            j = b4.D();
        }
        builder3.f5459d = j;
        builder3 = builder3;
        if (b5 == null) {
            j = 3600;
        } else {
            j = b5.D();
        }
        builder3.f5460e = j;
        builder3 = builder3;
        if (b6 == null) {
            j = 7;
        } else {
            j = b6.D();
        }
        builder3.f5461f = j;
        builder3 = builder3;
        if (b7 == null) {
            j = 0;
        } else {
            j = b7.D();
        }
        builder3.f5462g = j;
        builder2 = builder3;
        builder2.f5463h = a;
        builder2 = builder2;
        builder2.f5464i = b10;
        builder2 = builder2;
        builder2.f5465j = c.toString();
        VideoBroadcastInitResponse.Builder builder4 = builder2;
        if (b8 == null) {
            z = false;
        } else {
            z = b8.F();
        }
        builder4.f5466k = z;
        VideoBroadcastInitResponse.Builder builder5 = builder4;
        if (b9 == null) {
            j = 15;
        } else {
            j = b9.D();
        }
        builder5.f5467l = j;
        return builder5.m8140a();
    }

    private static VideoBroadcastVideoStreamingConfig m8136a(JsonNode jsonNode) {
        VideoBroadcastVideoStreamingConfig videoBroadcastVideoStreamingConfig = null;
        try {
            String s;
            boolean z;
            JsonNode b = jsonNode.b("android_video_profile");
            if (b != null) {
                s = b.s();
            } else {
                s = null;
            }
            VideoBroadcastVideoStreamingConfig.Builder d = new VideoBroadcastVideoStreamingConfig.Builder().m8146a(jsonNode.b("stream_video_width").w()).m8150b(jsonNode.b("stream_video_height").w()).m8151c(jsonNode.b("stream_video_bit_rate").w()).m8152d(jsonNode.b("stream_video_fps").w());
            if (jsonNode.b("stream_video_allow_b_frames").w() != 0) {
                z = true;
            } else {
                z = false;
            }
            videoBroadcastVideoStreamingConfig = d.m8148a(z).m8147a(s).m8149a();
        } catch (Throwable e) {
            BLog.b(f5455a, e, "Error getting VideoStreamingConfig", new Object[0]);
        }
        return videoBroadcastVideoStreamingConfig;
    }

    private static VideoBroadcastAudioStreamingConfig m8137b(JsonNode jsonNode) {
        try {
            return new VideoBroadcastAudioStreamingConfig.Builder().m8125a(jsonNode.b("stream_audio_sample_rate").w()).m8128c(jsonNode.b("stream_audio_channels").w()).m8127b(jsonNode.b("stream_audio_bit_rate").w()).m8126a();
        } catch (Throwable e) {
            BLog.b(f5455a, e, "Error getting AudioStreamingConfig", new Object[0]);
            return null;
        }
    }
}
