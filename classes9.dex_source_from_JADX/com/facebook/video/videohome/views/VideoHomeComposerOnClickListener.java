package com.facebook.video.videohome.views;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.facecast.abtest.ExperimentsForFacecastAbtestModule;
import com.facebook.feed.util.composer.launch.FeedComposerLauncher;
import com.facebook.feed.util.composer.launch.FeedComposerLauncher.LauncherContext;
import com.facebook.feed.util.composer.launch.FeedComposerLauncherProvider;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.video.analytics.VideoAnalytics.ClickTarget;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.videohome.logging.VideoHomeLoggingUtils;
import com.google.common.base.Absent;
import javax.inject.Inject;

/* compiled from: show_presence */
public class VideoHomeComposerOnClickListener implements OnClickListener {
    public static final LauncherContext f3334a = new C03071();
    public final FeedComposerLauncherProvider f3335b;
    public final QeAccessor f3336c;
    private final VideoHomeLoggingUtils f3337d;
    public final Activity f3338e;

    /* compiled from: show_presence */
    final class C03071 implements LauncherContext {
        C03071() {
        }

        public final ComposerTargetData m3166a() {
            return ComposerTargetData.a;
        }

        public final String m3167b() {
            return "video_home";
        }

        public final ComposerSourceSurface m3168c() {
            return ComposerSourceSurface.VIDEO_HOME;
        }

        public final String m3169d() {
            return "videoHome";
        }

        public final Surface m3170e() {
            return Surface.VIDEO_HOME;
        }

        public final SimplePickerSource m3171f() {
            return SimplePickerSource.VIDEO_HOME;
        }

        public final ComposerType m3172g() {
            return ComposerType.STATUS;
        }
    }

    @Inject
    public VideoHomeComposerOnClickListener(@Assisted Activity activity, FeedComposerLauncherProvider feedComposerLauncherProvider, QeAccessor qeAccessor, VideoHomeLoggingUtils videoHomeLoggingUtils) {
        this.f3338e = activity;
        this.f3335b = feedComposerLauncherProvider;
        this.f3336c = qeAccessor;
        this.f3337d = videoHomeLoggingUtils;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -150537627);
        this.f3337d.a(PlayerOrigin.VIDEO_HOME, ClickTarget.GO_LIVE_BUTTON);
        FeedComposerLauncher a2 = this.f3335b.a(f3334a, FeedComposerLauncher.a);
        if (this.f3336c.a(ExperimentsForFacecastAbtestModule.q, false)) {
            a2.b(Absent.INSTANCE, this.f3338e);
        } else {
            a2.a(this.f3338e);
        }
        Logger.a(2, EntryType.UI_INPUT_END, -744159938, a);
    }
}
