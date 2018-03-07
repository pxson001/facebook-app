package com.facebook.feedplugins.video;

import android.view.View;
import com.facebook.attachments.videos.ui.BaseVideoAttachmentView;
import com.facebook.attachments.videos.ui.FullscreenVideoAttachmentView;
import com.facebook.feed.environment.HasScrollListenerSupport.SimpleScrollListener;
import com.facebook.feed.video.util.VideoUtils;
import com.facebook.feedplugins.attachments.video.VideoAttachmentDelegate;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason;
import java.util.HashSet;
import javax.annotation.Nullable;

/* compiled from: forgot_password_click */
public class LogFullscreenVideoDisplayedPartDefinition$ScrollListener implements SimpleScrollListener {
    private final LogFullscreenVideoDisplayedPartDefinition f13044a;
    private final VideoAttachmentDelegate f13045b;
    private final HashSet<AutoPlayFailureReason> f13046c = new HashSet();
    private final ChannelEligibility f13047d;
    @Nullable
    public View f13048e;

    public LogFullscreenVideoDisplayedPartDefinition$ScrollListener(LogFullscreenVideoDisplayedPartDefinition logFullscreenVideoDisplayedPartDefinition, VideoAttachmentDelegate videoAttachmentDelegate, ChannelEligibility channelEligibility) {
        this.f13044a = logFullscreenVideoDisplayedPartDefinition;
        this.f13045b = videoAttachmentDelegate;
        this.f13047d = channelEligibility;
    }

    public final void m14737a() {
        if (this.f13048e instanceof FullscreenVideoAttachmentView) {
            int[] iArr = new int[2];
            ((FullscreenVideoAttachmentView) this.f13048e).getLocationInWindow(iArr);
            if (BaseVideoAttachmentView.a((float) iArr[1], this.f13045b.l, this.f13045b.m)) {
                this.f13046c.clear();
                this.f13044a.b.a(this.f13046c);
                VideoUtils.a(this.f13044a.d, this.f13046c, this.f13044a.b, this.f13044a.a, this.f13044a.e.e, this.f13044a.e.b, this.f13045b.k, this.f13044a.e.f, this.f13047d, this.f13044a.e);
                return;
            }
            VideoUtils.a(this.f13044a.d);
        }
    }
}
