package com.facebook.video.videostreaming.protocol;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: reviews_feed_load_stories_success */
public class VideoBroadcastVideoStreamingConfigSerializer extends JsonSerializer<VideoBroadcastVideoStreamingConfig> {
    public final void m8156a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        VideoBroadcastVideoStreamingConfig videoBroadcastVideoStreamingConfig = (VideoBroadcastVideoStreamingConfig) obj;
        if (videoBroadcastVideoStreamingConfig == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m8155b(videoBroadcastVideoStreamingConfig, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(VideoBroadcastVideoStreamingConfig.class, new VideoBroadcastVideoStreamingConfigSerializer());
    }

    private static void m8155b(VideoBroadcastVideoStreamingConfig videoBroadcastVideoStreamingConfig, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "width", Integer.valueOf(videoBroadcastVideoStreamingConfig.width));
        AutoGenJsonHelper.a(jsonGenerator, "height", Integer.valueOf(videoBroadcastVideoStreamingConfig.height));
        AutoGenJsonHelper.a(jsonGenerator, "bit_rate", Integer.valueOf(videoBroadcastVideoStreamingConfig.bitRate));
        AutoGenJsonHelper.a(jsonGenerator, "frame_rate", Integer.valueOf(videoBroadcastVideoStreamingConfig.frameRate));
        AutoGenJsonHelper.a(jsonGenerator, "allow_b_frames", Boolean.valueOf(videoBroadcastVideoStreamingConfig.allowBFrames));
        AutoGenJsonHelper.a(jsonGenerator, "video_profile", videoBroadcastVideoStreamingConfig.videoProfile);
    }
}
