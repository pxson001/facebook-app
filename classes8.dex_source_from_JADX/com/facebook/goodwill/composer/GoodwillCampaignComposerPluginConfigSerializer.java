package com.facebook.goodwill.composer;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: {ranking_data} */
public class GoodwillCampaignComposerPluginConfigSerializer extends JsonSerializer<GoodwillCampaignComposerPluginConfig> {
    public final void m59a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GoodwillCampaignComposerPluginConfig goodwillCampaignComposerPluginConfig = (GoodwillCampaignComposerPluginConfig) obj;
        if (goodwillCampaignComposerPluginConfig == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m58b(goodwillCampaignComposerPluginConfig, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(GoodwillCampaignComposerPluginConfig.class, new GoodwillCampaignComposerPluginConfigSerializer());
    }

    private static void m58b(GoodwillCampaignComposerPluginConfig goodwillCampaignComposerPluginConfig, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "composer_hint", goodwillCampaignComposerPluginConfig.mComposerHint);
        AutoGenJsonHelper.a(jsonGenerator, "composer_title", goodwillCampaignComposerPluginConfig.mComposerTitle);
    }
}
