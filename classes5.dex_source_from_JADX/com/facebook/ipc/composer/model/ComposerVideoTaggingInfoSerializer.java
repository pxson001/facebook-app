package com.facebook.ipc.composer.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TIMELINE_STORY */
public class ComposerVideoTaggingInfoSerializer extends JsonSerializer<ComposerVideoTaggingInfo> {
    public final void m23371a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerVideoTaggingInfo composerVideoTaggingInfo = (ComposerVideoTaggingInfo) obj;
        if (composerVideoTaggingInfo == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m23370b(composerVideoTaggingInfo, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ComposerVideoTaggingInfo.class, new ComposerVideoTaggingInfoSerializer());
    }

    private static void m23370b(ComposerVideoTaggingInfo composerVideoTaggingInfo, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "frames", composerVideoTaggingInfo.getFrames());
        AutoGenJsonHelper.a(jsonGenerator, "has_faceboxes", Boolean.valueOf(composerVideoTaggingInfo.hasFaceboxes()));
    }
}
