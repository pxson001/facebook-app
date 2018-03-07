package com.facebook.video.videohome.adapter.viewholders;

import android.content.Context;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.graphql.calls.VideoChannelSetPinStateInputData.Surface;
import com.facebook.inject.Assisted;
import com.facebook.topics.data.VideoChannelPinStateMutator;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.channelfeed.ChannelFeedHeaderParamsFactory;
import com.facebook.video.channelfeed.InlineToChannelFeedTransitionManagerProvider;
import javax.inject.Inject;

/* compiled from: stopPlayout */
public class DefaultTopicClickListener {
    public final AbstractDisposableFutureCallback f2761a;
    public final ChannelFeedHeaderParamsFactory f2762b;
    public final Context f2763c;
    public final FullscreenTransitionListener f2764d;
    public final InlineToChannelFeedTransitionManagerProvider f2765e;
    public final String f2766f;
    public final VideoChannelPinStateMutator f2767g;
    public final PlayerOrigin f2768h;
    public final Surface f2769i;

    @Inject
    public DefaultTopicClickListener(@Assisted AbstractDisposableFutureCallback abstractDisposableFutureCallback, @Assisted Context context, @Assisted String str, @Assisted PlayerOrigin playerOrigin, @Assisted Surface surface, @Assisted FullscreenTransitionListener fullscreenTransitionListener, ChannelFeedHeaderParamsFactory channelFeedHeaderParamsFactory, InlineToChannelFeedTransitionManagerProvider inlineToChannelFeedTransitionManagerProvider, VideoChannelPinStateMutator videoChannelPinStateMutator) {
        this.f2761a = abstractDisposableFutureCallback;
        this.f2763c = context;
        this.f2766f = str;
        this.f2768h = playerOrigin;
        this.f2769i = surface;
        this.f2764d = fullscreenTransitionListener;
        this.f2762b = channelFeedHeaderParamsFactory;
        this.f2765e = inlineToChannelFeedTransitionManagerProvider;
        this.f2767g = videoChannelPinStateMutator;
    }
}
