package com.facebook.feedplugins.attachments.video;

import android.view.View;
import com.facebook.attachments.videos.ui.Inline360VideoAttachmentView;
import com.facebook.common.util.ContextUtils;
import com.facebook.debug.fps.FrameRateBlameMarkers;
import com.facebook.debug.log.BLog;
import com.facebook.feed.autoplay.VideoAutoplayVisibilityDecider;
import com.facebook.feed.ui.inlinevideoplayer.ScrollSpeedEstimator;
import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.feed.video.util.VideoUtils;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import javax.inject.Provider;

/* compiled from: TEXT_FIELD_ERROR */
public class Inline360VideoPartDefinition$Inline360AutoplayVisibilityRunnable extends AutoplayVisibilityRunnable<Inline360VideoAttachmentView> {
    private Inline360VideoPartDefinition$State f22732a;
    private VideoAutoPlaySettingsChecker f22733b;
    private VideoLoggingUtils f22734c;
    private final FrameRateBlameMarkers f22735d;

    public final void m25354a(View view) {
        boolean z;
        Inline360VideoAttachmentView inline360VideoAttachmentView = (Inline360VideoAttachmentView) view;
        FullScreenVideoPlayerHost fullScreenVideoPlayerHost = (FullScreenVideoPlayerHost) ContextUtils.a(inline360VideoAttachmentView.getContext(), FullScreenVideoPlayerHost.class);
        if (fullScreenVideoPlayerHost == null) {
            BLog.b("V360", "isFullScreenActive() Could not find FullScreenVideoPlayerHost");
            z = false;
        } else {
            z = fullScreenVideoPlayerHost.h();
        }
        if (!z) {
            this.f22732a.f22746i.clear();
            boolean a = this.f22732a.f22744g.a(this.f22732a.f22746i);
            if (!this.f22732a.f22743f.f) {
                VideoUtils.a(this.f22732a.f22743f, this.f22732a.f22746i, this.f22733b, this.f22734c, this.f22732a.f22742e.e, this.f22732a.f22742e.b, this.f22732a.f22740c.k, this.f22732a.f22742e.f, ChannelEligibility.WRONG_STORY_TYPE, this.f22732a.f22742e);
            }
            if (a) {
                Integer.valueOf(inline360VideoAttachmentView.hashCode());
                Inline360VideoPartDefinition.b(inline360VideoAttachmentView, this.f22732a, this.f22735d, EventTriggerType.BY_AUTOPLAY, new PlayPosition(this.f22732a.f22745h.a(), this.f22732a.f22745h.a()));
            }
        }
    }

    public final void m25355b(View view) {
        Inline360VideoAttachmentView inline360VideoAttachmentView = (Inline360VideoAttachmentView) view;
        this.f22732a.f22743f.b(false);
        if (m25353c(inline360VideoAttachmentView)) {
            Inline360VideoPartDefinition.b(inline360VideoAttachmentView, this.f22732a, this.f22735d, EventTriggerType.BY_AUTOPLAY);
        }
        this.f22732a.f22744g.g();
    }

    public Inline360VideoPartDefinition$Inline360AutoplayVisibilityRunnable(Inline360VideoPartDefinition$State inline360VideoPartDefinition$State, AutoplayVisibilityRunnableActivityListener autoplayVisibilityRunnableActivityListener, VideoAutoplayVisibilityDecider videoAutoplayVisibilityDecider, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, VideoLoggingUtils videoLoggingUtils, FrameRateBlameMarkers frameRateBlameMarkers, Provider<ScrollSpeedEstimator> provider) {
        super(autoplayVisibilityRunnableActivityListener, videoAutoplayVisibilityDecider, provider, 100);
        this.f22732a = inline360VideoPartDefinition$State;
        this.f22733b = videoAutoPlaySettingsChecker;
        this.f22734c = videoLoggingUtils;
        this.f22735d = frameRateBlameMarkers;
    }

    private static boolean m25353c(Inline360VideoAttachmentView inline360VideoAttachmentView) {
        return inline360VideoAttachmentView.getRichVideoPlayer().o();
    }
}
