package com.facebook.video.videohome.environment;

import android.content.Context;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.ui.VideoFeedStoryMenuHelperProvider;
import com.facebook.feed.ui.inlinevideoplayer.plugins.LiveStatusTracker;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParamsImplProvider;
import com.facebook.video.videohome.autoplay.VideoHomeAutoDimmingManager;
import com.facebook.video.videohome.autoplay.VideoHomeCenteredAutoplayManager;
import com.facebook.video.videohome.data.VideoHomeReactionItemCollection;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager;

/* compiled from: start_time_millis */
public class VideoHomeEnvironmentImplProvider extends AbstractAssistedProvider<VideoHomeEnvironmentImpl> {
    public final VideoHomeEnvironmentImpl m2766a(Context context, FeedListType feedListType, BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, Runnable runnable, ReactionAnalyticsParams reactionAnalyticsParams, String str, Delegate delegate, VideoHomeReactionItemCollection videoHomeReactionItemCollection, LiveStatusTracker liveStatusTracker, CanFetchHScrollSubComponents canFetchHScrollSubComponents) {
        return new VideoHomeEnvironmentImpl(context, feedListType, baseFeedStoryMenuHelper, runnable, reactionAnalyticsParams, str, delegate, videoHomeReactionItemCollection, liveStatusTracker, canFetchHScrollSubComponents, VideoHomeCanHandlePageChangedEventsImpl.m2738b(this), VideoHomeCanHandleSectionReloadImpl.m2743a((InjectorLike) this), VideoHomeLoggingCanHandlePageChangedEventsImpl.m2780b(this), VideoHomeAutoplayCanHandlePageChangedEventsImpl.m2735b(this), VideoHomePrefetchCanHandlePageChangedEventsImpl.m2785b((InjectorLike) this), (HasReactionAnalyticsParamsImplProvider) getOnDemandAssistedProviderForStaticDi(HasReactionAnalyticsParamsImplProvider.class), (VideoHomeStoryKeyProvider) getOnDemandAssistedProviderForStaticDi(VideoHomeStoryKeyProvider.class), VideoHomeCenteredAutoplayManager.m2669a(this), VideoHomeAutoDimmingManager.m2664a(this), VideoHomeSessionManager.a(this), (VideoFeedStoryMenuHelperProvider) getOnDemandAssistedProviderForStaticDi(VideoFeedStoryMenuHelperProvider.class));
    }
}
