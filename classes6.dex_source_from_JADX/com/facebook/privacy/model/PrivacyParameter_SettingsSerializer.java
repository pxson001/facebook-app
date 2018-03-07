package com.facebook.privacy.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feature_image_access */
public class PrivacyParameter_SettingsSerializer extends JsonSerializer<Settings> {
    public final void m22695a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Settings settings = (Settings) obj;
        if (settings == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m22694b(settings, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(Settings.class, new PrivacyParameter_SettingsSerializer());
    }

    private static void m22694b(Settings settings, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "no_tag_expansion", Boolean.valueOf(settings.noTagExpansion));
    }
}
