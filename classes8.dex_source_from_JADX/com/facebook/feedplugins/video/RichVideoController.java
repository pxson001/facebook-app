package com.facebook.feedplugins.video;

import com.facebook.debug.fps.FrameRateBlameMarkers;
import com.facebook.debug.fps.frameblame.AutoPlayVideoBlameMarker;
import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.feed.video.util.VideoUtils;
import com.facebook.feedplugins.attachments.video.InlineVideoPersistentState;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoDisplayedInfo;
import com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import com.google.common.base.Preconditions;
import java.util.HashSet;
import java.util.Set;

/* compiled from: force_external_browser */
public class RichVideoController extends VideoViewController<RichVideoAttachmentView> {
    public final InlineVideoPersistentState f13073a;
    private final AutoplayStateManager f13074b;
    private final VideoDisplayedInfo f13075c;
    private final VideoPlayerParams f13076d;
    public final VideoFeedStoryInfo f13077e;
    private final PlayerOrigin f13078f;
    private final VideoAutoPlaySettingsChecker f13079g;
    private final VideoLoggingUtils f13080h;
    public final FrameRateBlameMarkers f13081i;
    public boolean f13082j = false;
    private boolean f13083k = false;
    private final Set<AutoPlayFailureReason> f13084l;

    public final void m14753a(Object obj) {
        RichVideoAttachmentView richVideoAttachmentView = (RichVideoAttachmentView) obj;
        if (this.f13083k) {
            this.f13083k = false;
            if (this.f13082j) {
                this.f13082j = false;
                this.f13081i.b(AutoPlayVideoBlameMarker.c());
            }
            this.f13073a.a(richVideoAttachmentView.getRichVideoPlayer().getCurrentPositionMs());
            richVideoAttachmentView.getRichVideoPlayer().b(this.f13073a.c());
        }
    }

    public final void m14754b(Object obj) {
        RichVideoAttachmentView richVideoAttachmentView = (RichVideoAttachmentView) obj;
        if (!this.f13083k) {
            this.f13083k = true;
            Preconditions.checkNotNull(this.f13074b);
            this.f13084l.clear();
            boolean a = this.f13074b.a(this.f13084l, this.f13073a.d);
            m14752b();
            if (a) {
                if (!this.f13082j) {
                    this.f13082j = true;
                    this.f13081i.a(AutoPlayVideoBlameMarker.c());
                }
                this.f13073a.e = EventTriggerType.BY_AUTOPLAY;
                richVideoAttachmentView.getRichVideoPlayer().setOriginalPlayReason(EventTriggerType.BY_AUTOPLAY);
                this.f13077e.b = EventTriggerType.BY_AUTOPLAY;
                richVideoAttachmentView.getRichVideoPlayer().setChannelEligibility(this.f13077e.c);
                richVideoAttachmentView.getRichVideoPlayer().a(this.f13073a.c(), this.f13073a.a());
            }
        }
    }

    public RichVideoController(InlineVideoPersistentState inlineVideoPersistentState, VideoDisplayedInfo videoDisplayedInfo, VideoPlayerParams videoPlayerParams, VideoFeedStoryInfo videoFeedStoryInfo, PlayerOrigin playerOrigin, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, VideoLoggingUtils videoLoggingUtils, FrameRateBlameMarkers frameRateBlameMarkers) {
        super(videoPlayerParams.b);
        this.f13073a = inlineVideoPersistentState;
        this.f13074b = inlineVideoPersistentState.b();
        this.f13075c = videoDisplayedInfo;
        this.f13076d = videoPlayerParams;
        this.f13077e = videoFeedStoryInfo;
        this.f13078f = playerOrigin;
        this.f13079g = videoAutoPlaySettingsChecker;
        this.f13080h = videoLoggingUtils;
        this.f13081i = frameRateBlameMarkers;
        this.f13084l = new HashSet();
    }

    private void m14752b() {
        if (!this.f13075c.f) {
            VideoUtils.a(this.f13075c, this.f13084l, this.f13079g, this.f13080h, this.f13076d.e, this.a, this.f13078f, this.f13076d.f, this.f13077e.c, this.f13076d);
        }
    }
}
