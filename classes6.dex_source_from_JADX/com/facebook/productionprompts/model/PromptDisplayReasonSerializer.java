package com.facebook.productionprompts.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ss_see_more_button */
public class PromptDisplayReasonSerializer extends JsonSerializer<PromptDisplayReason> {
    public final void m6347a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        PromptDisplayReason promptDisplayReason = (PromptDisplayReason) obj;
        if (promptDisplayReason == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m6346b(promptDisplayReason, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(PromptDisplayReason.class, new PromptDisplayReasonSerializer());
    }

    private static void m6346b(PromptDisplayReason promptDisplayReason, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "reason_with_entities", promptDisplayReason.textWithEntities);
    }
}
