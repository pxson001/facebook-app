package com.facebook.video.videohome.adapter.viewholders;

import android.content.Context;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.graphql.calls.VideoChannelSetPinStateInputData.Surface;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.topics.data.VideoChannelPinStateMutator;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.channelfeed.ChannelFeedHeaderParamsFactory;
import com.facebook.video.channelfeed.InlineToChannelFeedTransitionManagerProvider;

/* compiled from: sticky_sys_tray_notifications */
public class DefaultTopicClickListenerProvider extends AbstractAssistedProvider<DefaultTopicClickListener> {
    public final DefaultTopicClickListener m2653a(AbstractDisposableFutureCallback abstractDisposableFutureCallback, Context context, String str, PlayerOrigin playerOrigin, Surface surface, FullscreenTransitionListener fullscreenTransitionListener) {
        return new DefaultTopicClickListener(abstractDisposableFutureCallback, context, str, playerOrigin, surface, fullscreenTransitionListener, ChannelFeedHeaderParamsFactory.m2263a((InjectorLike) this), (InlineToChannelFeedTransitionManagerProvider) getOnDemandAssistedProviderForStaticDi(InlineToChannelFeedTransitionManagerProvider.class), VideoChannelPinStateMutator.b(this));
    }
}
