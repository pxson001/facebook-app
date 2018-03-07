package com.facebook.video.channelfeed;

import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: targeting_descriptors */
public class ChannelFeedFullscreenController extends VideoViewController<ChannelFeedVideoAttachmentView> {
    private final ChannelFeedFullscreenManager f2193a;

    public final /* bridge */ /* synthetic */ void m2195a(Object obj) {
    }

    public final void m2196b(Object obj) {
        this.f2193a.m2209a((ChannelFeedVideoAttachmentView) obj);
    }

    @Inject
    public ChannelFeedFullscreenController(@Assisted String str, ChannelFeedFullscreenManager channelFeedFullscreenManager) {
        super(str);
        this.f2193a = channelFeedFullscreenManager;
    }
}
