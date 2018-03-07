package com.facebook.feedplugins.attachments.video;

import com.facebook.attachments.videos.ui.InlineVideoAttachmentView;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.feed.video.util.VideoUtils;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoDisplayedInfo;
import com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.engine.Constants.VideoMediaState;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import java.util.HashSet;
import java.util.Set;

/* compiled from: TEXT_FIELD */
public class InlineVideoController extends VideoViewController<InlineVideoAttachmentView> {
    public final InlineVideoPersistentState f22753a;
    private final AutoplayStateManager f22754b;
    public final VideoDisplayedInfo f22755c;
    public final VideoPlayerParams f22756d;
    public final VideoFeedStoryInfo f22757e;
    public final PlayerOrigin f22758f;
    public final VideoAutoPlaySettingsChecker f22759g;
    public final VideoLoggingUtils f22760h;
    private boolean f22761i = false;
    public final Set<AutoPlayFailureReason> f22762j;

    public final void m25362a(Object obj) {
        InlineVideoAttachmentView inlineVideoAttachmentView = (InlineVideoAttachmentView) obj;
        if (this.f22761i) {
            this.f22761i = false;
            this.f22753a.a(inlineVideoAttachmentView.a.getCurrentPosition());
            inlineVideoAttachmentView.a.a(this.f22753a.c(), VideoMediaState.PAUSED);
        }
    }

    public final void m25363b(Object obj) {
        InlineVideoAttachmentView inlineVideoAttachmentView = (InlineVideoAttachmentView) obj;
        if (!this.f22761i) {
            this.f22761i = true;
            Preconditions.a(this.f22754b);
            this.f22762j.clear();
            boolean a = this.f22754b.a(this.f22762j);
            if (!this.f22755c.f) {
                VideoUtils.a(this.f22755c, this.f22762j, this.f22759g, this.f22760h, this.f22756d.e, this.a, this.f22758f, this.f22756d.f, this.f22757e.c, this.f22756d);
            }
            if (a) {
                m25361c(inlineVideoAttachmentView);
            }
        }
    }

    public InlineVideoController(InlineVideoPersistentState inlineVideoPersistentState, VideoDisplayedInfo videoDisplayedInfo, VideoPlayerParams videoPlayerParams, VideoFeedStoryInfo videoFeedStoryInfo, PlayerOrigin playerOrigin, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, VideoLoggingUtils videoLoggingUtils) {
        super(videoPlayerParams.b);
        this.f22753a = inlineVideoPersistentState;
        this.f22754b = inlineVideoPersistentState.b();
        this.f22755c = videoDisplayedInfo;
        this.f22756d = videoPlayerParams;
        this.f22757e = videoFeedStoryInfo;
        this.f22758f = playerOrigin;
        this.f22759g = videoAutoPlaySettingsChecker;
        this.f22760h = videoLoggingUtils;
        this.f22762j = new HashSet();
    }

    @VisibleForTesting
    private void m25361c(InlineVideoAttachmentView inlineVideoAttachmentView) {
        this.f22753a.e = EventTriggerType.BY_AUTOPLAY;
        inlineVideoAttachmentView.a.setOriginalPlayReason(EventTriggerType.BY_AUTOPLAY);
        this.f22757e.b = EventTriggerType.BY_AUTOPLAY;
        inlineVideoAttachmentView.a.a(this.f22753a.c(), new PlayPosition(this.f22753a.a(), this.f22753a.a()));
    }
}
