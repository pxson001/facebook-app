package com.facebook.productionprompts.composer;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: report_map */
public class ProductionPromptsPluginConfigSerializer extends JsonSerializer<ProductionPromptsPluginConfig> {
    public final void m4400a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ProductionPromptsPluginConfig productionPromptsPluginConfig = (ProductionPromptsPluginConfig) obj;
        if (productionPromptsPluginConfig == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m4399b(productionPromptsPluginConfig, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ProductionPromptsPluginConfig.class, new ProductionPromptsPluginConfigSerializer());
    }

    private static void m4399b(ProductionPromptsPluginConfig productionPromptsPluginConfig, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "prompt", productionPromptsPluginConfig.mPrompt);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "prompt_entry_point_analytics", productionPromptsPluginConfig.mPromptAnalytics);
        AutoGenJsonHelper.a(jsonGenerator, "is_prefilled", Boolean.valueOf(productionPromptsPluginConfig.mIsPrefilled));
    }
}
