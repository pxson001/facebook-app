package com.facebook.composer.publish.common.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: activityClass */
public class ComposerSessionLoggingDataSerializer extends JsonSerializer<ComposerSessionLoggingData> {
    public final void m19724a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerSessionLoggingData composerSessionLoggingData = (ComposerSessionLoggingData) obj;
        if (composerSessionLoggingData == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m19723b(composerSessionLoggingData, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ComposerSessionLoggingData.class, new ComposerSessionLoggingDataSerializer());
    }

    private static void m19723b(ComposerSessionLoggingData composerSessionLoggingData, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "composition_duration", Long.valueOf(composerSessionLoggingData.getCompositionDuration()));
        AutoGenJsonHelper.a(jsonGenerator, "number_of_copy_pastes", Integer.valueOf(composerSessionLoggingData.getNumberOfPastes()));
        AutoGenJsonHelper.a(jsonGenerator, "number_of_keystrokes", Integer.valueOf(composerSessionLoggingData.getNumberOfKeystrokes()));
    }
}
