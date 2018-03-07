package com.facebook.video.videostreaming.protocol;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: rgba */
public class VideoBroadcastInitResponseSerializer extends JsonSerializer<VideoBroadcastInitResponse> {
    public final void m8145a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        VideoBroadcastInitResponse videoBroadcastInitResponse = (VideoBroadcastInitResponse) obj;
        if (videoBroadcastInitResponse == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m8144b(videoBroadcastInitResponse, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(VideoBroadcastInitResponse.class, new VideoBroadcastInitResponseSerializer());
    }

    private static void m8144b(VideoBroadcastInitResponse videoBroadcastInitResponse, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "rtmp_publish_url", videoBroadcastInitResponse.rtmpPublishUrl);
        AutoGenJsonHelper.a(jsonGenerator, "video_id", videoBroadcastInitResponse.videoId);
        AutoGenJsonHelper.a(jsonGenerator, "broadcast_id", videoBroadcastInitResponse.broadcastId);
        AutoGenJsonHelper.a(jsonGenerator, "min_broadacst_duration", Long.valueOf(videoBroadcastInitResponse.minBroadcastDurationSeconds));
        AutoGenJsonHelper.a(jsonGenerator, "max_broadcast_duration", Long.valueOf(videoBroadcastInitResponse.maxBroadcastDurationSeconds));
        AutoGenJsonHelper.a(jsonGenerator, "speed_test_timeout_seconds", Long.valueOf(videoBroadcastInitResponse.speedTestTimeoutSeconds));
        AutoGenJsonHelper.a(jsonGenerator, "send_stream_interrupted_interval", Long.valueOf(videoBroadcastInitResponse.sendStreamInterruptedIntervalInSeconds));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "video_streaming_config", videoBroadcastInitResponse.videoStreamingConfig);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "audio_streaming_config", videoBroadcastInitResponse.audioStreamingConfig);
        AutoGenJsonHelper.a(jsonGenerator, "raw_json_config", videoBroadcastInitResponse.mRawJsonConfig);
        AutoGenJsonHelper.a(jsonGenerator, "is_disk_recording_enabled", Boolean.valueOf(videoBroadcastInitResponse.mIsDiskRecordingEnabled));
        AutoGenJsonHelper.a(jsonGenerator, "client_rendering_duration_ms", Long.valueOf(videoBroadcastInitResponse.clientRenderingDurationMs));
    }
}
