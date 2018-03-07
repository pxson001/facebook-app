package com.facebook.composer.minutiae.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: added_entry */
public class MinutiaeObjectSerializer extends JsonSerializer<MinutiaeObject> {
    public final void m19639a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MinutiaeObject minutiaeObject = (MinutiaeObject) obj;
        if (minutiaeObject == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m19638b(minutiaeObject, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(MinutiaeObject.class, new MinutiaeObjectSerializer());
    }

    private static void m19638b(MinutiaeObject minutiaeObject, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "verb", minutiaeObject.verb);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "object", minutiaeObject.object);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "custom_icon", minutiaeObject.customIcon);
        AutoGenJsonHelper.a(jsonGenerator, "suggestion_mechanism", minutiaeObject.suggestionMechanism);
        AutoGenJsonHelper.a(jsonGenerator, "hide_attachment", Boolean.valueOf(minutiaeObject.hideAttachment));
    }
}
