package com.facebook.video.player.plugins;

import android.content.Context;
import com.facebook.common.android.AudioManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerManager;
import com.facebook.video.player.PlayerActivityManager;

/* compiled from: delete_contact */
public class PlaybackControllerProvider extends AbstractAssistedProvider<PlaybackController> {
    public final PlaybackController m14879a(Boolean bool, Boolean bool2, Boolean bool3, PlayerOrigin playerOrigin, Boolean bool4) {
        return new PlaybackController(bool, bool2, bool3, playerOrigin, bool4, (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(this), (Context) getInstance(Context.class), VideoPlayerManager.a(this), VideoLoggingUtils.a(this), Handler_ForUiThreadMethodAutoProvider.b(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), PlayerActivityManager.a(this), AudioManagerMethodAutoProvider.b(this), VideoLivePlaybackConfig.a(this));
    }
}
