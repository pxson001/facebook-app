package com.facebook.ipc.composer.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TK; */
public class ComposerSlideshowDataSerializer extends JsonSerializer<ComposerSlideshowData> {
    public final void m23353a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerSlideshowData composerSlideshowData = (ComposerSlideshowData) obj;
        if (composerSlideshowData == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m23352b(composerSlideshowData, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ComposerSlideshowData.class, new ComposerSlideshowDataSerializer());
    }

    private static void m23352b(ComposerSlideshowData composerSlideshowData, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "audio_track_id", composerSlideshowData.getAudioTrackId());
    }
}
