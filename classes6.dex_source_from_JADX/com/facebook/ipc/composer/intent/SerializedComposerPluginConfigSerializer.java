package com.facebook.ipc.composer.intent;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: life_event_types */
public class SerializedComposerPluginConfigSerializer extends JsonSerializer<SerializedComposerPluginConfig> {
    public final void m18288a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        SerializedComposerPluginConfig serializedComposerPluginConfig = (SerializedComposerPluginConfig) obj;
        if (serializedComposerPluginConfig == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m18287b(serializedComposerPluginConfig, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(SerializedComposerPluginConfig.class, new SerializedComposerPluginConfigSerializer());
    }

    private static void m18287b(SerializedComposerPluginConfig serializedComposerPluginConfig, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "persist_key", serializedComposerPluginConfig.mPersistenceKey);
        AutoGenJsonHelper.a(jsonGenerator, "data", serializedComposerPluginConfig.mData);
    }
}
