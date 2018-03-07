package com.facebook.video.channelfeed;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.device.ScreenUtil;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.graphql.calls.EntryPointInputVideoChannelEntryPoint;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.video.analytics.VideoChannelSessionManager;
import com.facebook.video.channelfeed.ChannelFeedVideoSectionController.VideoChannelLoadedCallback;
import com.facebook.video.channelfeed.abtest.ChannelFeedConfig;
import com.facebook.widget.listview.ScrollingViewProxy;
import java.util.concurrent.Executor;

/* compiled from: suggestionIds */
public class ChannelFeedVideoSectionControllerProvider extends AbstractAssistedProvider<ChannelFeedVideoSectionController> {
    public final ChannelFeedVideoSectionController m2498a(String str, String str2, EntryPointInputVideoChannelEntryPoint entryPointInputVideoChannelEntryPoint, boolean z, boolean z2, ScrollingViewProxy scrollingViewProxy, VideoChannelItemCollection videoChannelItemCollection, MultiRowAdapter multiRowAdapter, VideoChannelLoadedCallback videoChannelLoadedCallback, ChannelFeedLoadingCard channelFeedLoadingCard, boolean z3) {
        return new ChannelFeedVideoSectionController(str, str2, entryPointInputVideoChannelEntryPoint, z, z2, scrollingViewProxy, videoChannelItemCollection, multiRowAdapter, videoChannelLoadedCallback, channelFeedLoadingCard, z3, ChannelFeedConfig.a(this), ChannelFeedStoryUtil.m2436a((InjectorLike) this), (Clock) SystemClockMethodAutoProvider.a(this), ScreenUtil.a(this), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), VideoChannelSessionManager.a(this), VideoChannelLoader.m2572a((InjectorLike) this));
    }
}
