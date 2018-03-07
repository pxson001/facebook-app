package com.facebook.goodwill.composer;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: {notif_medium} */
public class GoodwillFriendsBirthdayComposerPluginConfigSerializer extends JsonSerializer<GoodwillFriendsBirthdayComposerPluginConfig> {
    public final void m114a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GoodwillFriendsBirthdayComposerPluginConfig goodwillFriendsBirthdayComposerPluginConfig = (GoodwillFriendsBirthdayComposerPluginConfig) obj;
        if (goodwillFriendsBirthdayComposerPluginConfig == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m113b(goodwillFriendsBirthdayComposerPluginConfig, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(GoodwillFriendsBirthdayComposerPluginConfig.class, new GoodwillFriendsBirthdayComposerPluginConfigSerializer());
    }

    private static void m113b(GoodwillFriendsBirthdayComposerPluginConfig goodwillFriendsBirthdayComposerPluginConfig, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "composer_hint", goodwillFriendsBirthdayComposerPluginConfig.mComposerHint);
    }
}
