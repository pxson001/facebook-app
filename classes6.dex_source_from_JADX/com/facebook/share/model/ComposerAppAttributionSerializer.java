package com.facebook.share.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: server_status */
public class ComposerAppAttributionSerializer extends JsonSerializer<ComposerAppAttribution> {
    public final void m7696a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerAppAttribution composerAppAttribution = (ComposerAppAttribution) obj;
        if (composerAppAttribution == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m7695b(composerAppAttribution, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ComposerAppAttribution.class, new ComposerAppAttributionSerializer());
    }

    private static void m7695b(ComposerAppAttribution composerAppAttribution, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "app_id", composerAppAttribution.appId);
        AutoGenJsonHelper.a(jsonGenerator, "app_name", composerAppAttribution.appName);
        AutoGenJsonHelper.a(jsonGenerator, "app_key_hash", composerAppAttribution.appKeyHash);
        AutoGenJsonHelper.a(jsonGenerator, "app_metadata", composerAppAttribution.appMetadata);
    }
}
