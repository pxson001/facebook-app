package com.facebook.productionprompts.composer;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.ipc.composer.intent.ComposerPluginConfig;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.productionprompts.model.ProductionPrompt;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = ProductionPromptsPluginConfigDeserializer.class)
@Immutable
@JsonSerialize(using = ProductionPromptsPluginConfigSerializer.class)
/* compiled from: request %d timed out */
public class ProductionPromptsPluginConfig implements ComposerPluginConfig {
    public static final String f4538a = ProductionPromptsPluginConfig.class.getSimpleName();
    @JsonProperty("is_prefilled")
    final boolean mIsPrefilled;
    @JsonProperty("prompt")
    final ProductionPrompt mPrompt;
    @JsonProperty("prompt_entry_point_analytics")
    @Nullable
    final PromptAnalytics mPromptAnalytics;

    private ProductionPromptsPluginConfig(ProductionPrompt productionPrompt, PromptAnalytics promptAnalytics, boolean z) {
        this.mPrompt = productionPrompt;
        this.mPromptAnalytics = promptAnalytics;
        this.mIsPrefilled = z;
        m4393a();
    }

    private ProductionPromptsPluginConfig() {
        this.mPrompt = null;
        this.mPromptAnalytics = null;
        this.mIsPrefilled = false;
    }

    public static ProductionPromptsPluginConfig m4392a(ProductionPrompt productionPrompt, PromptAnalytics promptAnalytics, boolean z) {
        return new ProductionPromptsPluginConfig(productionPrompt, promptAnalytics, z);
    }

    @JsonIgnore
    public final ProductionPrompt m4395c() {
        return this.mPrompt;
    }

    @Nullable
    public final PromptAnalytics m4396d() {
        return this.mPromptAnalytics;
    }

    public final String m4394b() {
        return f4538a;
    }

    public final void m4393a() {
        Preconditions.checkNotNull(m4395c());
    }
}
