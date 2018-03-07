package com.facebook.ipc.friendsharing.listeningto;

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
@JsonDeserialize(using = ListeningToComposerPluginConfigDeserializer.class)
@Immutable
@JsonSerialize(using = ListeningToComposerPluginConfigSerializer.class)
/* compiled from: unknown rating bar attribute =  */
public class ListeningToComposerPluginConfig implements ComposerPluginConfig {
    public static final String f1144a = ListeningToComposerPluginConfig.class.getSimpleName();
    @JsonProperty("artist_name")
    @Nullable
    final String mArtistName;
    @JsonProperty("composer_session_id")
    @Nullable
    final String mComposerSessionId;
    @JsonProperty("track_name")
    @Nullable
    final String mTrackName;

    private ListeningToComposerPluginConfig(String str, String str2, String str3) {
        this.mArtistName = str;
        this.mTrackName = str2;
        this.mComposerSessionId = str3;
        m1375a();
    }

    private ListeningToComposerPluginConfig() {
        this.mArtistName = null;
        this.mTrackName = null;
        this.mComposerSessionId = null;
    }

    public static ListeningToComposerPluginConfig m1374a(String str, String str2, String str3) {
        return new ListeningToComposerPluginConfig(str, str2, str3);
    }

    @Nullable
    public final String m1377c() {
        return this.mArtistName;
    }

    @Nullable
    public final String m1378d() {
        return this.mTrackName;
    }

    public final String m1376b() {
        return f1144a;
    }

    public final void m1375a() {
        Preconditions.checkNotNull(this.mArtistName);
        Preconditions.checkNotNull(this.mTrackName);
    }
}
