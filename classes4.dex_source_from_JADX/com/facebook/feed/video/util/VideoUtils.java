package com.facebook.feed.video.util;

import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoDisplayedInfo;
import com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason;
import com.facebook.video.analytics.VideoPlaybackAnalyticsParams;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: phone_address_book_version_hash */
public class VideoUtils {
    public static void m5396a(VideoDisplayedInfo videoDisplayedInfo) {
        videoDisplayedInfo.b(false);
    }

    public static boolean m5398a(boolean z, GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus) {
        if (!z) {
            return false;
        }
        if (graphQLVideoBroadcastStatus == GraphQLVideoBroadcastStatus.LIVE_STOPPED || graphQLVideoBroadcastStatus == GraphQLVideoBroadcastStatus.SEAL_STARTED || graphQLVideoBroadcastStatus == GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            return true;
        }
        return false;
    }

    public static void m5397a(VideoDisplayedInfo videoDisplayedInfo, @Nullable Set<AutoPlayFailureReason> set, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, VideoLoggingUtils videoLoggingUtils, JsonNode jsonNode, String str, PlayerOrigin playerOrigin, boolean z, ChannelEligibility channelEligibility, VideoPlaybackAnalyticsParams videoPlaybackAnalyticsParams) {
        if (!videoDisplayedInfo.b()) {
            videoDisplayedInfo.a(set, videoAutoPlaySettingsChecker.c());
            videoLoggingUtils.a(videoDisplayedInfo, jsonNode, str, playerOrigin, z, channelEligibility, videoPlaybackAnalyticsParams);
            videoDisplayedInfo.b(true);
        }
    }
}
