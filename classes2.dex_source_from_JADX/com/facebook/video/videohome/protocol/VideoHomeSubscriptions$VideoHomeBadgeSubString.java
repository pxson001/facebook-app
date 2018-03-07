package com.facebook.video.videohome.protocol;

import com.facebook.graphql.query.TypedGraphQLSubscriptionString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: goodwill_daily_dialogue_good_morning */
public class VideoHomeSubscriptions$VideoHomeBadgeSubString extends TypedGraphQLSubscriptionString<VideoHomeSubscriptionsModels$VideoHomeBadgeSubModel> {
    public VideoHomeSubscriptions$VideoHomeBadgeSubString() {
        super(VideoHomeSubscriptionsModels$VideoHomeBadgeSubModel.class, false, "VideoHomeBadgeSub", "56f8f2e7eba9d7902b915d80ffc877dc", "video_home_badge_update_subscribe", "0", "10154439505321729", RegularImmutableSet.f688a);
    }

    public final String mo1605a(String str) {
        switch (str.hashCode()) {
            case 100358090:
                return "0";
            default:
                return str;
        }
    }
}
