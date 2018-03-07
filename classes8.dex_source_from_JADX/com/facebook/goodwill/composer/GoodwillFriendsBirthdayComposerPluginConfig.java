package com.facebook.goodwill.composer;

import android.support.annotation.Nullable;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.ipc.composer.intent.ComposerPluginConfig;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = GoodwillFriendsBirthdayComposerPluginConfigDeserializer.class)
@Immutable
@JsonSerialize(using = GoodwillFriendsBirthdayComposerPluginConfigSerializer.class)
/* compiled from: {offer_claim_id} */
public final class GoodwillFriendsBirthdayComposerPluginConfig implements ComposerPluginConfig {
    @Nullable
    @JsonProperty("composer_hint")
    final String mComposerHint;

    private GoodwillFriendsBirthdayComposerPluginConfig(String str) {
        this.mComposerHint = str;
        m108a();
    }

    private GoodwillFriendsBirthdayComposerPluginConfig() {
        this.mComposerHint = null;
    }

    public static GoodwillFriendsBirthdayComposerPluginConfig m107a(String str) {
        return new GoodwillFriendsBirthdayComposerPluginConfig(str);
    }

    public final String m109b() {
        return "GoodwillFriendsBirthdayComposerPluginConfig";
    }

    @Nullable
    @JsonIgnore
    public final String m110c() {
        return this.mComposerHint;
    }

    public final void m108a() {
        Preconditions.checkNotNull(m110c());
    }
}
