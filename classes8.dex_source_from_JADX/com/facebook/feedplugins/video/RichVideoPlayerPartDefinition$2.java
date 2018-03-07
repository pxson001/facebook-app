package com.facebook.feedplugins.video;

import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.feedplugins.attachments.video.InlineVideoPersistentState;
import com.facebook.feedplugins.attachments.video.SingleRunnableAutoplayPartDefinition.VideoViewControllerProvider;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoDisplayedInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;

/* compiled from: for_sale */
class RichVideoPlayerPartDefinition$2 implements VideoViewControllerProvider {
    final /* synthetic */ RichVideoPlayerPartDefinition f13085a;

    RichVideoPlayerPartDefinition$2(RichVideoPlayerPartDefinition richVideoPlayerPartDefinition) {
        this.f13085a = richVideoPlayerPartDefinition;
    }

    public final VideoViewController m14755a(InlineVideoPersistentState inlineVideoPersistentState, VideoDisplayedInfo videoDisplayedInfo, VideoPlayerParams videoPlayerParams, VideoFeedStoryInfo videoFeedStoryInfo, PlayerOrigin playerOrigin, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, VideoLoggingUtils videoLoggingUtils) {
        return new RichVideoController(inlineVideoPersistentState, videoDisplayedInfo, videoPlayerParams, videoFeedStoryInfo, playerOrigin, videoAutoPlaySettingsChecker, videoLoggingUtils, this.f13085a.g);
    }
}
