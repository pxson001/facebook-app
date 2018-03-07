package com.facebook.ipc.composer.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TKEY;>; */
public class ComposerLocationSerializer extends JsonSerializer<ComposerLocation> {
    public final void m23348a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerLocation composerLocation = (ComposerLocation) obj;
        if (composerLocation == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m23347b(composerLocation, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ComposerLocation.class, new ComposerLocationSerializer());
    }

    private static void m23347b(ComposerLocation composerLocation, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "latitude", Double.valueOf(composerLocation.latitude));
        AutoGenJsonHelper.a(jsonGenerator, "longitude", Double.valueOf(composerLocation.longitude));
        AutoGenJsonHelper.a(jsonGenerator, "accuracy", Float.valueOf(composerLocation.accuracy));
        AutoGenJsonHelper.a(jsonGenerator, "time", Long.valueOf(composerLocation.time));
    }
}
