package com.facebook.video.videostreaming.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: ride_provider */
public class VideoBroadcastInitResponseDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f5469a;

    static {
        GlobalAutoGenDeserializerCache.a(VideoBroadcastInitResponse.class, new VideoBroadcastInitResponseDeserializer());
        m8142e();
    }

    public VideoBroadcastInitResponseDeserializer() {
        a(VideoBroadcastInitResponse.class);
    }

    private static synchronized Map<String, FbJsonField> m8142e() {
        Map<String, FbJsonField> map;
        synchronized (VideoBroadcastInitResponseDeserializer.class) {
            if (f5469a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("rtmp_publish_url", FbJsonField.jsonField(VideoBroadcastInitResponse.class.getDeclaredField("rtmpPublishUrl")));
                    builder.b("video_id", FbJsonField.jsonField(VideoBroadcastInitResponse.class.getDeclaredField("videoId")));
                    builder.b("broadcast_id", FbJsonField.jsonField(VideoBroadcastInitResponse.class.getDeclaredField("broadcastId")));
                    builder.b("min_broadacst_duration", FbJsonField.jsonField(VideoBroadcastInitResponse.class.getDeclaredField("minBroadcastDurationSeconds")));
                    builder.b("max_broadcast_duration", FbJsonField.jsonField(VideoBroadcastInitResponse.class.getDeclaredField("maxBroadcastDurationSeconds")));
                    builder.b("speed_test_timeout_seconds", FbJsonField.jsonField(VideoBroadcastInitResponse.class.getDeclaredField("speedTestTimeoutSeconds")));
                    builder.b("send_stream_interrupted_interval", FbJsonField.jsonField(VideoBroadcastInitResponse.class.getDeclaredField("sendStreamInterruptedIntervalInSeconds")));
                    builder.b("video_streaming_config", FbJsonField.jsonField(VideoBroadcastInitResponse.class.getDeclaredField("videoStreamingConfig")));
                    builder.b("audio_streaming_config", FbJsonField.jsonField(VideoBroadcastInitResponse.class.getDeclaredField("audioStreamingConfig")));
                    builder.b("raw_json_config", FbJsonField.jsonField(VideoBroadcastInitResponse.class.getDeclaredField("mRawJsonConfig")));
                    builder.b("is_disk_recording_enabled", FbJsonField.jsonField(VideoBroadcastInitResponse.class.getDeclaredField("mIsDiskRecordingEnabled")));
                    builder.b("client_rendering_duration_ms", FbJsonField.jsonField(VideoBroadcastInitResponse.class.getDeclaredField("clientRenderingDurationMs")));
                    f5469a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f5469a;
        }
        return map;
    }

    public final FbJsonField m8143a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m8142e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m8142e().keySet());
    }
}
