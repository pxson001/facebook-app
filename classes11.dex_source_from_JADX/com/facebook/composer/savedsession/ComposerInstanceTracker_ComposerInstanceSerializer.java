package com.facebook.composer.savedsession;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fill */
public class ComposerInstanceTracker_ComposerInstanceSerializer extends JsonSerializer<ComposerInstance> {
    public final void m8234a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerInstance composerInstance = (ComposerInstance) obj;
        if (composerInstance == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m8233b(composerInstance, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ComposerInstance.class, new ComposerInstanceTracker_ComposerInstanceSerializer());
    }

    private static void m8233b(ComposerInstance composerInstance, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "start_time", Long.valueOf(composerInstance.startTime));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "configuration", composerInstance.configuration);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "last_saved_session", composerInstance.lastSavedSession);
    }
}
