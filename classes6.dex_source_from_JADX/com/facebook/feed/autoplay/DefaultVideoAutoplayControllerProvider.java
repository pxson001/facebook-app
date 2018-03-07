package com.facebook.feed.autoplay;

import android.view.View;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoDisplayedInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;

/* compiled from: nearLeft */
public class DefaultVideoAutoplayControllerProvider extends AbstractAssistedProvider<DefaultVideoAutoplayController> {
    public final <V extends View & VideoPlayerView> DefaultVideoAutoplayController<V> m15817a(String str, VideoStoryPersistentState videoStoryPersistentState, VideoDisplayedInfo videoDisplayedInfo, VideoPlayerParams videoPlayerParams, VideoFeedStoryInfo videoFeedStoryInfo, PlayerOrigin playerOrigin) {
        return new DefaultVideoAutoplayController(str, videoStoryPersistentState, videoDisplayedInfo, videoPlayerParams, videoFeedStoryInfo, playerOrigin, VideoAutoPlaySettingsChecker.a(this), VideoLoggingUtils.a(this));
    }
}
