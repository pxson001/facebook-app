package com.facebook.feed.photoreminder.composer;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: admin_click_recent_shares */
public class PhotoReminderPluginConfigSerializer extends JsonSerializer<PhotoReminderPluginConfig> {
    public final void m23031a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        PhotoReminderPluginConfig photoReminderPluginConfig = (PhotoReminderPluginConfig) obj;
        if (photoReminderPluginConfig == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m23030b(photoReminderPluginConfig, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(PhotoReminderPluginConfig.class, new PhotoReminderPluginConfigSerializer());
    }

    private static void m23030b(PhotoReminderPluginConfig photoReminderPluginConfig, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "prompt_entry_point_analytics", photoReminderPluginConfig.mPromptAnalytics);
    }
}
