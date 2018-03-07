package com.facebook.feed.photoreminder.composer;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.ipc.composer.intent.ComposerPluginConfig;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = PhotoReminderPluginConfigDeserializer.class)
@Immutable
@JsonSerialize(using = PhotoReminderPluginConfigSerializer.class)
/* compiled from: admin_panel_initialization */
public class PhotoReminderPluginConfig implements ComposerPluginConfig {
    @JsonProperty("prompt_entry_point_analytics")
    final PromptAnalytics mPromptAnalytics;

    private PhotoReminderPluginConfig(PromptAnalytics promptAnalytics) {
        this.mPromptAnalytics = promptAnalytics;
        m23025a();
    }

    private PhotoReminderPluginConfig() {
        this.mPromptAnalytics = null;
    }

    public static PhotoReminderPluginConfig m23024a(PromptAnalytics promptAnalytics) {
        return new PhotoReminderPluginConfig(promptAnalytics);
    }

    @JsonIgnore
    public final PromptAnalytics m23027c() {
        return this.mPromptAnalytics;
    }

    public final String m23026b() {
        return "PHOTO_REMINDER_PERSIST_KEY";
    }

    public final void m23025a() {
        Preconditions.checkNotNull(this.mPromptAnalytics);
    }
}
