package com.facebook.gametime.ui.reaction;

import android.content.Context;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.feed.environment.CanAddReactionComponentsImplProvider;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEventsImpl;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParamsImplProvider;
import com.facebook.reaction.feed.environment.HasReactionCardBackgroundImplProvider;
import com.facebook.reaction.feed.environment.ReactionFeedActionHandler;

/* compiled from: {thread_id} */
public class GametimeEnvironmentProvider extends AbstractAssistedProvider<GametimeEnvironment> {
    public final GametimeEnvironment m4a(Context context, FeedListType feedListType, BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, Runnable runnable, ReactionAnalyticsParams reactionAnalyticsParams, ReactionFeedActionHandler reactionFeedActionHandler, ReactionInteractionTracker reactionInteractionTracker, ReactionSession reactionSession, Delegate delegate, String str, GametimePlaySubscriber gametimePlaySubscriber) {
        return new GametimeEnvironment(context, feedListType, baseFeedStoryMenuHelper, runnable, reactionAnalyticsParams, reactionFeedActionHandler, reactionInteractionTracker, reactionSession, delegate, str, gametimePlaySubscriber, (CanAddReactionComponentsImplProvider) getOnDemandAssistedProviderForStaticDi(CanAddReactionComponentsImplProvider.class), CanHandleHScrollPageChangedEventsImpl.a(this), (HasReactionAnalyticsParamsImplProvider) getOnDemandAssistedProviderForStaticDi(HasReactionAnalyticsParamsImplProvider.class), (HasReactionCardBackgroundImplProvider) getOnDemandAssistedProviderForStaticDi(HasReactionCardBackgroundImplProvider.class));
    }
}
