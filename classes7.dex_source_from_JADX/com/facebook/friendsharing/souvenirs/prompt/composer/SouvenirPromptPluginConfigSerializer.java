package com.facebook.friendsharing.souvenirs.prompt.composer;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: REMOVE */
public class SouvenirPromptPluginConfigSerializer extends JsonSerializer<SouvenirPromptPluginConfig> {
    public final void m26252a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        SouvenirPromptPluginConfig souvenirPromptPluginConfig = (SouvenirPromptPluginConfig) obj;
        if (souvenirPromptPluginConfig == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m26251b(souvenirPromptPluginConfig, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(SouvenirPromptPluginConfig.class, new SouvenirPromptPluginConfigSerializer());
    }

    private static void m26251b(SouvenirPromptPluginConfig souvenirPromptPluginConfig, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "prompt_entry_point_analytics", souvenirPromptPluginConfig.promptAnalytics);
    }
}
