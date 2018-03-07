package com.facebook.ipc.composer.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TIMELINE_HEADER */
public class MinutiaeTagSerializer extends JsonSerializer<MinutiaeTag> {
    public final void m23388a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MinutiaeTag minutiaeTag = (MinutiaeTag) obj;
        if (minutiaeTag == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m23387b(minutiaeTag, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(MinutiaeTag.class, new MinutiaeTagSerializer());
    }

    private static void m23387b(MinutiaeTag minutiaeTag, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "og_action_type_id", minutiaeTag.ogActionTypeId);
        AutoGenJsonHelper.a(jsonGenerator, "og_object_id", minutiaeTag.ogObjectId);
        AutoGenJsonHelper.a(jsonGenerator, "og_phrase", minutiaeTag.ogPhrase);
        AutoGenJsonHelper.a(jsonGenerator, "og_icon_id", minutiaeTag.ogIconId);
        AutoGenJsonHelper.a(jsonGenerator, "oh_hide_attachment", Boolean.valueOf(minutiaeTag.ogHideAttachment));
        AutoGenJsonHelper.a(jsonGenerator, "og_suggestion_mechanism", minutiaeTag.ogSuggestionMechanism);
    }
}
