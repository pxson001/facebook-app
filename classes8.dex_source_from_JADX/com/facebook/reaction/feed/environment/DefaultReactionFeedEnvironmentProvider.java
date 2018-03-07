package com.facebook.reaction.feed.environment;

import android.content.Context;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionInteractionTracker;

/* compiled from: back_button_action */
public class DefaultReactionFeedEnvironmentProvider extends AbstractAssistedProvider<DefaultReactionFeedEnvironment> {
    public final DefaultReactionFeedEnvironment m23149a(Context context, FeedListType feedListType, BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, Runnable runnable, ReactionAnalyticsParams reactionAnalyticsParams, ReactionFeedActionHandler reactionFeedActionHandler, ReactionInteractionTracker reactionInteractionTracker, ReactionSession reactionSession, Delegate delegate) {
        return new DefaultReactionFeedEnvironment(context, feedListType, baseFeedStoryMenuHelper, runnable, reactionAnalyticsParams, reactionFeedActionHandler, reactionInteractionTracker, reactionSession, delegate, (CanAddReactionComponentsImplProvider) getOnDemandAssistedProviderForStaticDi(CanAddReactionComponentsImplProvider.class), CanHandleHScrollPageChangedEventsImpl.m23142a((InjectorLike) this), (HasReactionAnalyticsParamsImplProvider) getOnDemandAssistedProviderForStaticDi(HasReactionAnalyticsParamsImplProvider.class), (HasReactionCardBackgroundImplProvider) getOnDemandAssistedProviderForStaticDi(HasReactionCardBackgroundImplProvider.class));
    }
}
