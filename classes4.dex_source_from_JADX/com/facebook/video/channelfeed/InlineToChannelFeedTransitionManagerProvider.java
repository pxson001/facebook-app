package com.facebook.video.channelfeed;

import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.video.channelfeed.abtest.ChannelFeedConfig;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager;

/* compiled from: original_sha256 */
public class InlineToChannelFeedTransitionManagerProvider extends AbstractAssistedProvider<InlineToChannelFeedTransitionManager> {
    public final InlineToChannelFeedTransitionManager m6349a(FullScreenVideoPlayerHost fullScreenVideoPlayerHost, ChannelFeedParams channelFeedParams) {
        return new InlineToChannelFeedTransitionManager(fullScreenVideoPlayerHost, channelFeedParams, ChannelFeedConfig.a(this), VideoHomeSessionManager.m4877a((InjectorLike) this));
    }
}
