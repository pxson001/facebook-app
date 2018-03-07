package com.facebook.feed.goodfriends.composer;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.ipc.composer.intent.ComposerPluginConfig;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = GoodFriendsComposerPluginConfigDeserializer.class)
@Immutable
@JsonSerialize(using = GoodFriendsComposerPluginConfigSerializer.class)
/* compiled from: animationProgress */
public class GoodFriendsComposerPluginConfig implements ComposerPluginConfig {
    public static final String f19218a = GoodFriendsComposerPluginConfig.class.getSimpleName();
    @JsonProperty("composer_hint")
    final String mComposerHint;

    private GoodFriendsComposerPluginConfig(String str) {
        this.mComposerHint = str;
        m22733a();
    }

    private GoodFriendsComposerPluginConfig() {
        this.mComposerHint = null;
    }

    public static GoodFriendsComposerPluginConfig m22732a(String str) {
        return new GoodFriendsComposerPluginConfig(str);
    }

    @Nullable
    public final String m22735c() {
        return this.mComposerHint;
    }

    public final String m22734b() {
        return f19218a;
    }

    public final void m22733a() {
        Preconditions.checkNotNull(this.mComposerHint);
    }
}
