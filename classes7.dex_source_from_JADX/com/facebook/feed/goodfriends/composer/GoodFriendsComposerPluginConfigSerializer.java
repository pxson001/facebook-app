package com.facebook.feed.goodfriends.composer;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: animated_image_sizes */
public class GoodFriendsComposerPluginConfigSerializer extends JsonSerializer<GoodFriendsComposerPluginConfig> {
    public final void m22739a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GoodFriendsComposerPluginConfig goodFriendsComposerPluginConfig = (GoodFriendsComposerPluginConfig) obj;
        if (goodFriendsComposerPluginConfig == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m22738b(goodFriendsComposerPluginConfig, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(GoodFriendsComposerPluginConfig.class, new GoodFriendsComposerPluginConfigSerializer());
    }

    private static void m22738b(GoodFriendsComposerPluginConfig goodFriendsComposerPluginConfig, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "composer_hint", goodFriendsComposerPluginConfig.mComposerHint);
    }
}
