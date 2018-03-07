package com.facebook.ipc.slideshow;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: unhighlight_rich_notification_tap */
public class SlideshowEditConfigurationSerializer extends JsonSerializer<SlideshowEditConfiguration> {
    public final void m1397a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        SlideshowEditConfiguration slideshowEditConfiguration = (SlideshowEditConfiguration) obj;
        if (slideshowEditConfiguration == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m1396b(slideshowEditConfiguration, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(SlideshowEditConfiguration.class, new SlideshowEditConfigurationSerializer());
    }

    private static void m1396b(SlideshowEditConfiguration slideshowEditConfiguration, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "action_when_done", slideshowEditConfiguration.getActionWhenDone());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "composer_configuration", slideshowEditConfiguration.getComposerConfiguration());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "media_items", slideshowEditConfiguration.getMediaItems());
        AutoGenJsonHelper.a(jsonGenerator, "session_id", slideshowEditConfiguration.getSessionId());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "slideshow_data", slideshowEditConfiguration.getSlideshowData());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "source", slideshowEditConfiguration.getSource());
    }
}
