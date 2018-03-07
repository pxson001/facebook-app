package com.facebook.feedplugins.video;

import android.view.View;
import com.facebook.debug.fps.FrameRateBlameMarkers;
import com.facebook.feed.autoplay.VideoAutoplayVisibilityDecider;
import com.facebook.feed.ui.inlinevideoplayer.ScrollSpeedEstimator;
import com.facebook.feed.video.util.VideoUtils;
import com.facebook.feedplugins.attachments.video.AutoplayVisibilityRunnable;
import com.facebook.feedplugins.attachments.video.AutoplayVisibilityRunnableActivityListener;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.settings.AutoplayRolloutNuxHelper;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import javax.inject.Provider;

/* compiled from: pic */
public class RichVideoPlayerPartDefinition$InlineAutoplayVisibilityRunnable extends AutoplayVisibilityRunnable<RichVideoAttachmentView> {
    private final RichVideoPlayerPartDefinition$State f5014a;
    private final VideoAutoPlaySettingsChecker f5015b;
    private final VideoLoggingUtils f5016c;
    private final FrameRateBlameMarkers f5017d;
    private final AutoplayRolloutNuxHelper f5018e;

    public final void mo439a(View view) {
        RichVideoAttachmentView richVideoAttachmentView = (RichVideoAttachmentView) view;
        if (!RichVideoPlayerPartDefinition.b(richVideoAttachmentView)) {
            this.f5014a.f4980l.clear();
            boolean a = this.f5014a.f4977i.m5315a(this.f5014a.f4980l);
            if (!this.f5014a.f4979k.f) {
                VideoUtils.m5397a(this.f5014a.f4979k, this.f5014a.f4980l, this.f5015b, this.f5016c, this.f5014a.f4976h.f4962a.f4836e, this.f5014a.f4976h.f4962a.f4833b, this.f5014a.f4974f, this.f5014a.f4976h.f4962a.f4837f, this.f5014a.f4975g.c, this.f5014a.f4976h.f4962a);
            }
            if (a) {
                RichVideoPlayerPartDefinition.b(richVideoAttachmentView.getRichVideoPlayer(), this.f5014a, this.f5017d, EventTriggerType.BY_AUTOPLAY, new PlayPosition(this.f5014a.f4978j.mo420a(), this.f5014a.f4978j.mo420a()));
                if (!this.f5014a.f4975g.d) {
                    this.f5018e.a(richVideoAttachmentView);
                }
            }
        }
    }

    public final void mo440b(View view) {
        RichVideoAttachmentView richVideoAttachmentView = (RichVideoAttachmentView) view;
        if (!RichVideoPlayerPartDefinition.b(richVideoAttachmentView)) {
            this.f5014a.f4979k.b(false);
            if (m5399c(richVideoAttachmentView)) {
                RichVideoPlayerPartDefinition.b(richVideoAttachmentView.getRichVideoPlayer(), this.f5014a, this.f5017d, EventTriggerType.BY_AUTOPLAY);
            }
            this.f5014a.f4977i.m5322g();
        }
    }

    public RichVideoPlayerPartDefinition$InlineAutoplayVisibilityRunnable(RichVideoPlayerPartDefinition$State richVideoPlayerPartDefinition$State, VideoAutoplayVisibilityDecider videoAutoplayVisibilityDecider, Provider<ScrollSpeedEstimator> provider, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, VideoLoggingUtils videoLoggingUtils, FrameRateBlameMarkers frameRateBlameMarkers, AutoplayRolloutNuxHelper autoplayRolloutNuxHelper, AutoplayVisibilityRunnableActivityListener autoplayVisibilityRunnableActivityListener, int i) {
        super(autoplayVisibilityRunnableActivityListener, videoAutoplayVisibilityDecider, provider, i);
        this.f5014a = richVideoPlayerPartDefinition$State;
        this.f5015b = videoAutoPlaySettingsChecker;
        this.f5016c = videoLoggingUtils;
        this.f5017d = frameRateBlameMarkers;
        this.f5018e = autoplayRolloutNuxHelper;
        autoplayVisibilityRunnableActivityListener.a(this);
    }

    private static boolean m5399c(RichVideoAttachmentView richVideoAttachmentView) {
        return richVideoAttachmentView.getRichVideoPlayer().m14849o();
    }
}
