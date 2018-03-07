package com.facebook.goodwill.composer;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: {com.facebook.katana.profile.id */
public class GoodwillFriendversaryCardComposerPluginConfigSerializer extends JsonSerializer<GoodwillFriendversaryCardComposerPluginConfig> {
    public final void m135a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GoodwillFriendversaryCardComposerPluginConfig goodwillFriendversaryCardComposerPluginConfig = (GoodwillFriendversaryCardComposerPluginConfig) obj;
        if (goodwillFriendversaryCardComposerPluginConfig == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m134b(goodwillFriendversaryCardComposerPluginConfig, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(GoodwillFriendversaryCardComposerPluginConfig.class, new GoodwillFriendversaryCardComposerPluginConfigSerializer());
    }

    private static void m134b(GoodwillFriendversaryCardComposerPluginConfig goodwillFriendversaryCardComposerPluginConfig, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "campaign_id", Long.valueOf(goodwillFriendversaryCardComposerPluginConfig.mCampaignId));
        AutoGenJsonHelper.a(jsonGenerator, "source", goodwillFriendversaryCardComposerPluginConfig.mSource);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "media_ids", goodwillFriendversaryCardComposerPluginConfig.mMediaIds);
    }
}
