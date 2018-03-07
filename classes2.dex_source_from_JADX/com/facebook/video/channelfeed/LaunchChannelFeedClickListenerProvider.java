package com.facebook.video.channelfeed;

import com.facebook.attachments.videos.ui.HasChannelFeedLauncherInfo;
import com.facebook.feed.analytics.vpvlogging.VpvEventHelper;
import com.facebook.feed.autoplay.VideoStoryPersistentState;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.video.channelfeed.LaunchChannelFeedClickListener.OnLaunchCallback;
import com.facebook.video.player.PlayerActivityManager;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: fetch_payment_cards */
public class LaunchChannelFeedClickListenerProvider extends AbstractAssistedProvider<LaunchChannelFeedClickListener> {
    public final LaunchChannelFeedClickListener m32391a(ChannelFeedParams channelFeedParams, VideoStoryPersistentState videoStoryPersistentState, AtomicReference<FullscreenTransitionListener> atomicReference, HasChannelFeedLauncherInfo hasChannelFeedLauncherInfo, OnLaunchCallback onLaunchCallback) {
        return new LaunchChannelFeedClickListener((InlineToChannelFeedTransitionManagerProvider) getOnDemandAssistedProviderForStaticDi(InlineToChannelFeedTransitionManagerProvider.class), PlayerActivityManager.m12995a((InjectorLike) this), VpvEventHelper.b(this), channelFeedParams, videoStoryPersistentState, atomicReference, hasChannelFeedLauncherInfo, onLaunchCallback);
    }
}
