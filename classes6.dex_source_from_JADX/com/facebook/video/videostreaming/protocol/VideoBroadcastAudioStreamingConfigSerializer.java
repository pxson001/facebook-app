package com.facebook.video.videostreaming.protocol;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: rotateDegrees */
public class VideoBroadcastAudioStreamingConfigSerializer extends JsonSerializer<VideoBroadcastAudioStreamingConfig> {
    public final void m8132a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        VideoBroadcastAudioStreamingConfig videoBroadcastAudioStreamingConfig = (VideoBroadcastAudioStreamingConfig) obj;
        if (videoBroadcastAudioStreamingConfig == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m8131b(videoBroadcastAudioStreamingConfig, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(VideoBroadcastAudioStreamingConfig.class, new VideoBroadcastAudioStreamingConfigSerializer());
    }

    private static void m8131b(VideoBroadcastAudioStreamingConfig videoBroadcastAudioStreamingConfig, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "sample_rate", Integer.valueOf(videoBroadcastAudioStreamingConfig.sampleRate));
        AutoGenJsonHelper.a(jsonGenerator, "bit_rate", Integer.valueOf(videoBroadcastAudioStreamingConfig.bitRate));
        AutoGenJsonHelper.a(jsonGenerator, "channels", Integer.valueOf(videoBroadcastAudioStreamingConfig.channels));
    }
}
