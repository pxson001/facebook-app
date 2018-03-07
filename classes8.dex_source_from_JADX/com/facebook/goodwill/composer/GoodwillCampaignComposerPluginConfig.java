package com.facebook.goodwill.composer;

import android.support.annotation.Nullable;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.ipc.composer.intent.ComposerPluginConfig;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = GoodwillCampaignComposerPluginConfigDeserializer.class)
@Immutable
@JsonSerialize(using = GoodwillCampaignComposerPluginConfigSerializer.class)
/* compiled from: {redirect} */
public final class GoodwillCampaignComposerPluginConfig implements ComposerPluginConfig {
    @Nullable
    @JsonProperty("composer_hint")
    final String mComposerHint;
    @Nullable
    @JsonProperty("composer_title")
    final String mComposerTitle;

    private GoodwillCampaignComposerPluginConfig(String str, @Nullable String str2) {
        this.mComposerHint = str;
        this.mComposerTitle = str2;
        m52a();
    }

    private GoodwillCampaignComposerPluginConfig() {
        this.mComposerHint = null;
        this.mComposerTitle = null;
    }

    public static GoodwillCampaignComposerPluginConfig m51a(String str, String str2) {
        return new GoodwillCampaignComposerPluginConfig(str, str2);
    }

    public final String m53b() {
        return "GoodwillCampaignComposerPluginConfig";
    }

    @Nullable
    @JsonIgnore
    public final String m54c() {
        return this.mComposerHint;
    }

    @Nullable
    @JsonIgnore
    public final String m55d() {
        return this.mComposerTitle;
    }

    public final void m52a() {
    }
}
