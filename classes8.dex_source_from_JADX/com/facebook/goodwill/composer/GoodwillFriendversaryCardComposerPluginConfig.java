package com.facebook.goodwill.composer;

import android.support.annotation.Nullable;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.ipc.composer.intent.ComposerPluginConfig;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = GoodwillFriendversaryCardComposerPluginConfigDeserializer.class)
@Immutable
@JsonSerialize(using = GoodwillFriendversaryCardComposerPluginConfigSerializer.class)
/* compiled from: {data} */
public class GoodwillFriendversaryCardComposerPluginConfig implements ComposerPluginConfig {
    @JsonProperty("campaign_id")
    final long mCampaignId;
    @Nullable
    @JsonProperty("media_ids")
    final List<String> mMediaIds;
    @JsonProperty("source")
    final String mSource;

    private GoodwillFriendversaryCardComposerPluginConfig(String str, String str2, List<String> list) {
        this.mCampaignId = Long.parseLong(str2);
        this.mSource = str;
        this.mMediaIds = list;
        m130a();
    }

    private GoodwillFriendversaryCardComposerPluginConfig() {
        this.mCampaignId = 0;
        this.mSource = null;
        this.mMediaIds = null;
    }

    public static GoodwillFriendversaryCardComposerPluginConfig m129a(String str, String str2) {
        return new GoodwillFriendversaryCardComposerPluginConfig(str, str2, null);
    }

    public final String m131b() {
        return "GoodwillFriendversaryCardComposerPluginConfig";
    }

    public final void m130a() {
        Preconditions.checkNotNull(this.mSource);
        Preconditions.checkArgument(this.mCampaignId != 0);
    }
}
