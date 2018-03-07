package com.facebook.video.channelfeed;

import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.inject.Assisted;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.analytics.VideoChannelSessionManager;
import com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason;
import com.facebook.video.engine.VideoResolution;
import com.facebook.video.player.plugins.PlaybackController.State;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: surface=android_today */
public class ChannelFeedVideoController extends VideoViewController<ChannelFeedVideoAttachmentView> {
    private final Set<AutoPlayFailureReason> f2527a = new HashSet();
    private final VideoChannelSessionManager f2528b;
    private boolean f2529c = false;
    private ChannelFeedStoryPersistentState f2530d;

    public final void m2460a(Object obj) {
        ChannelFeedVideoAttachmentView channelFeedVideoAttachmentView = (ChannelFeedVideoAttachmentView) obj;
        boolean z = false;
        if (this.f2529c) {
            VideoResolution e;
            this.f2529c = false;
            this.f2530d.m2433a(channelFeedVideoAttachmentView.f2522f.getCurrentPositionMs());
            ChannelFeedStoryPersistentState channelFeedStoryPersistentState = this.f2530d;
            if (!channelFeedVideoAttachmentView.getRichVideoPlayer().o()) {
                z = true;
            }
            channelFeedStoryPersistentState.f2504f = z;
            this.f2530d.f2505g = channelFeedVideoAttachmentView.getRichVideoPlayer().p();
            if (channelFeedVideoAttachmentView.getRichVideoPlayer().u != null) {
                e = channelFeedVideoAttachmentView.getRichVideoPlayer().u.e();
            } else {
                e = VideoResolution.STANDARD_DEFINITION;
            }
            this.f2530d.f2506h = e;
            AutoplayStateManager b = this.f2530d.m2434b();
            if (channelFeedVideoAttachmentView.getRichVideoPlayer().getPlayerState() == State.PAUSED) {
                b.e();
            } else if (channelFeedVideoAttachmentView.getRichVideoPlayer().o()) {
                b.d();
                channelFeedVideoAttachmentView.m2456e();
            }
            channelFeedVideoAttachmentView.f2517a.a(channelFeedVideoAttachmentView.f2523g.a.e, PlayerType.CHANNEL_PLAYER.value, EventTriggerType.BY_USER.value, channelFeedVideoAttachmentView.f2522f.getCurrentPositionMs(), channelFeedVideoAttachmentView.f2524h, channelFeedVideoAttachmentView.f2525i.f2136p, channelFeedVideoAttachmentView.f2523g.a.f, channelFeedVideoAttachmentView.f2523g.a);
        }
    }

    public final void m2461b(Object obj) {
        ChannelFeedVideoAttachmentView channelFeedVideoAttachmentView = (ChannelFeedVideoAttachmentView) obj;
        if (!this.f2529c) {
            this.f2529c = true;
            if (!(this.f2530d == null || this.f2530d.f2503e || channelFeedVideoAttachmentView.f2524h.equals(this.f2528b.h))) {
                channelFeedVideoAttachmentView.f2517a.b(channelFeedVideoAttachmentView.f2523g.a.e, channelFeedVideoAttachmentView.f2524h, PlayerType.CHANNEL_PLAYER.value, channelFeedVideoAttachmentView.f2523g.a.f);
                this.f2530d.f2503e = true;
            }
            this.f2527a.clear();
            AutoplayStateManager b = this.f2530d.m2434b();
            if (b.a(this.f2527a)) {
                b.v = false;
                channelFeedVideoAttachmentView.m2452a(this.f2530d.m2432a(), this.f2530d.m2435c(), this.f2530d.f2506h);
            } else {
                channelFeedVideoAttachmentView.getRichVideoPlayer().a(this.f2530d.m2432a(), EventTriggerType.BY_PLAYER);
            }
            channelFeedVideoAttachmentView.m2457g();
        }
    }

    @Inject
    public ChannelFeedVideoController(@Assisted String str, @Assisted ChannelFeedStoryPersistentState channelFeedStoryPersistentState, VideoChannelSessionManager videoChannelSessionManager) {
        super(str);
        this.f2530d = channelFeedStoryPersistentState;
        this.f2528b = videoChannelSessionManager;
    }
}
