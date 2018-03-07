package com.facebook.aplacefor;

import android.content.Context;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.ui.VideoFeedStoryMenuHelperProvider;
import com.facebook.feed.ui.inlinevideoplayer.plugins.LiveStatusTracker;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.feed.ReactionItemCollection;
import com.facebook.reaction.feed.environment.CanAddReactionComponentsImplProvider;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParamsImplProvider;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.video.videohome.autoplay.VideoHomeAutoDimmingManager;
import com.facebook.video.videohome.autoplay.VideoHomeCenteredAutoplayManager;
import com.facebook.video.videohome.environment.VideoHomeAutoplayCanHandlePageChangedEventsImpl;
import com.facebook.video.videohome.environment.VideoHomeCanHandlePageChangedEventsImpl;
import com.facebook.video.videohome.environment.VideoHomeCanHandleSectionReloadImpl;
import com.facebook.video.videohome.environment.VideoHomeLoggingCanHandlePageChangedEventsImpl;
import com.facebook.video.videohome.environment.VideoHomePrefetchCanHandlePageChangedEventsImpl;
import com.facebook.video.videohome.environment.VideoHomeStoryKeyProvider;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager;
import com.facebook.video.videohome.utils.VideoHomeLiveUpdatesHelper;

/* compiled from: key_load_review_stories */
public class APlaceForEnvironmentProvider extends AbstractAssistedProvider<APlaceForEnvironment> {
    public final APlaceForEnvironment m12306a(Context context, FeedListType feedListType, BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, Runnable runnable, ReactionAnalyticsParams reactionAnalyticsParams, ReactionInteractionTracker reactionInteractionTracker, ReactionSession reactionSession, Delegate delegate, ReactionItemCollection reactionItemCollection, ReactionCardContainer reactionCardContainer) {
        return new APlaceForEnvironment(context, feedListType, baseFeedStoryMenuHelper, runnable, reactionAnalyticsParams, reactionInteractionTracker, reactionSession, delegate, reactionItemCollection, reactionCardContainer, VideoHomeCanHandlePageChangedEventsImpl.b(this), VideoHomeCanHandleSectionReloadImpl.a(this), VideoHomeLoggingCanHandlePageChangedEventsImpl.b(this), VideoHomeAutoplayCanHandlePageChangedEventsImpl.b(this), VideoHomePrefetchCanHandlePageChangedEventsImpl.b(this), (HasReactionAnalyticsParamsImplProvider) getOnDemandAssistedProviderForStaticDi(HasReactionAnalyticsParamsImplProvider.class), (VideoHomeStoryKeyProvider) getOnDemandAssistedProviderForStaticDi(VideoHomeStoryKeyProvider.class), VideoHomeCenteredAutoplayManager.a(this), VideoHomeAutoDimmingManager.a(this), VideoHomeSessionManager.a(this), (VideoFeedStoryMenuHelperProvider) getOnDemandAssistedProviderForStaticDi(VideoFeedStoryMenuHelperProvider.class), LiveStatusTracker.a(this), ReactionIntentLauncher.m24381a(this), (CanAddReactionComponentsImplProvider) getOnDemandAssistedProviderForStaticDi(CanAddReactionComponentsImplProvider.class), ReactionUtil.m22637a((InjectorLike) this), VideoHomeLiveUpdatesHelper.a(this));
    }
}
