package com.facebook.notifications.multirow;

import android.content.Context;
import com.facebook.analytics.NavigationLogger;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.logging.NotificationsLogger;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.feed.environment.CanAddReactionComponentsImplProvider;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEventsImpl;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParamsImplProvider;
import com.facebook.reaction.feed.environment.HasReactionCardBackgroundImplProvider;
import com.facebook.reaction.feed.environment.ReactionFeedActionHandler;

/* compiled from: custom_cta_switch_types_mobile */
public class NotificationsFeedEnvironmentProvider extends AbstractAssistedProvider<NotificationsFeedEnvironment> {
    public final NotificationsFeedEnvironment m18877a(Context context, FeedListType feedListType, BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, Runnable runnable, ReactionAnalyticsParams reactionAnalyticsParams, ReactionFeedActionHandler reactionFeedActionHandler, ReactionInteractionTracker reactionInteractionTracker, ReactionSession reactionSession, Delegate delegate, NotificationsFeedCollection notificationsFeedCollection) {
        return new NotificationsFeedEnvironment(context, feedListType, baseFeedStoryMenuHelper, runnable, reactionAnalyticsParams, reactionFeedActionHandler, reactionInteractionTracker, reactionSession, delegate, notificationsFeedCollection, (CanAddReactionComponentsImplProvider) getOnDemandAssistedProviderForStaticDi(CanAddReactionComponentsImplProvider.class), CanHandleHScrollPageChangedEventsImpl.m23142a((InjectorLike) this), (HasReactionAnalyticsParamsImplProvider) getOnDemandAssistedProviderForStaticDi(HasReactionAnalyticsParamsImplProvider.class), (HasReactionCardBackgroundImplProvider) getOnDemandAssistedProviderForStaticDi(HasReactionCardBackgroundImplProvider.class), GraphQLNotificationsContentProviderHelper.a(this), NavigationLogger.a(this), NotificationsLogger.a(this), NotificationsUtils.a(this), DefaultAndroidThreadUtil.a(this), ViewerContextManagerProvider.a(this));
    }
}
