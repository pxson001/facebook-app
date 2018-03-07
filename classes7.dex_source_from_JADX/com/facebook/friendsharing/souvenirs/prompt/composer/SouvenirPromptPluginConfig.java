package com.facebook.friendsharing.souvenirs.prompt.composer;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.ipc.composer.intent.ComposerPluginConfig;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = SouvenirPromptPluginConfigDeserializer.class)
@Immutable
@JsonSerialize(using = SouvenirPromptPluginConfigSerializer.class)
/* compiled from: REMOVE_SELF */
public class SouvenirPromptPluginConfig implements ComposerPluginConfig {
    @JsonProperty("prompt_entry_point_analytics")
    final PromptAnalytics promptAnalytics;

    private SouvenirPromptPluginConfig() {
        this.promptAnalytics = null;
    }

    private SouvenirPromptPluginConfig(PromptAnalytics promptAnalytics) {
        this.promptAnalytics = promptAnalytics;
    }

    public static SouvenirPromptPluginConfig m26246a(PromptAnalytics promptAnalytics) {
        return new SouvenirPromptPluginConfig(promptAnalytics);
    }

    public final void m26247a() {
        Preconditions.checkState(this.promptAnalytics != null);
    }

    public final String m26248b() {
        return "SOUVENIR_PROMPT_PERSISTENCE_KEY";
    }
}
