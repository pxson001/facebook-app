package com.facebook.notifications.connectioncontroller;

import android.content.Context;
import com.facebook.analytics.NavigationLogger;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.feed.environment.CanAddReactionComponentsImplProvider;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEventsImpl;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParamsImplProvider;
import com.facebook.reaction.feed.environment.HasReactionCardBackgroundImplProvider;
import com.facebook.reaction.feed.environment.ReactionFeedActionHandler;

/* compiled from: time_zone_long_name */
public class NotificationsConnectionEnvironmentProvider extends AbstractAssistedProvider<NotificationsConnectionEnvironment> {
    public final NotificationsConnectionEnvironment m1224a(Context context, FeedListType feedListType, BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, Runnable runnable, ReactionAnalyticsParams reactionAnalyticsParams, ReactionFeedActionHandler reactionFeedActionHandler, ReactionInteractionTracker reactionInteractionTracker, ReactionSession reactionSession, Delegate delegate) {
        return new NotificationsConnectionEnvironment(context, feedListType, baseFeedStoryMenuHelper, runnable, reactionAnalyticsParams, reactionFeedActionHandler, reactionInteractionTracker, reactionSession, delegate, (CanAddReactionComponentsImplProvider) getOnDemandAssistedProviderForStaticDi(CanAddReactionComponentsImplProvider.class), CanHandleHScrollPageChangedEventsImpl.a(this), (HasReactionAnalyticsParamsImplProvider) getOnDemandAssistedProviderForStaticDi(HasReactionAnalyticsParamsImplProvider.class), (HasReactionCardBackgroundImplProvider) getOnDemandAssistedProviderForStaticDi(HasReactionCardBackgroundImplProvider.class), NavigationLogger.a(this), NotificationsUtils.a(this));
    }
}
