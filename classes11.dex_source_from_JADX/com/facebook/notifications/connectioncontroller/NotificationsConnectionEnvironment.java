package com.facebook.notifications.connectioncontroller;

import android.content.Context;
import android.os.Bundle;
import com.facebook.analytics.NavigationLogger;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.graphql.enums.GraphQLNotifHighlightState;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationStorySeenStateMutationFieldsModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationStorySeenStateMutationFieldsModel.Builder;
import com.facebook.notifications.server.NotificationsChangeSeenStateParams;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.feed.environment.CanAddReactionComponentsImplProvider;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEventsImpl;
import com.facebook.reaction.feed.environment.DefaultReactionFeedEnvironment;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParamsImplProvider;
import com.facebook.reaction.feed.environment.HasReactionCardBackgroundImplProvider;
import com.facebook.reaction.feed.environment.ReactionFeedActionHandler;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.today.common.HasNotifications;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: time_zone_short_name */
public class NotificationsConnectionEnvironment extends DefaultReactionFeedEnvironment implements HasNotifications {
    private final NavigationLogger f931m;
    private final NotificationsUtils f932n;

    @Inject
    public NotificationsConnectionEnvironment(@Assisted Context context, @Assisted FeedListType feedListType, @Nullable @Assisted BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, @Assisted Runnable runnable, @Nullable @Assisted ReactionAnalyticsParams reactionAnalyticsParams, @Assisted ReactionFeedActionHandler reactionFeedActionHandler, @Assisted ReactionInteractionTracker reactionInteractionTracker, @Assisted ReactionSession reactionSession, @Assisted Delegate delegate, CanAddReactionComponentsImplProvider canAddReactionComponentsImplProvider, CanHandleHScrollPageChangedEventsImpl canHandleHScrollPageChangedEventsImpl, HasReactionAnalyticsParamsImplProvider hasReactionAnalyticsParamsImplProvider, HasReactionCardBackgroundImplProvider hasReactionCardBackgroundImplProvider, NavigationLogger navigationLogger, NotificationsUtils notificationsUtils) {
        super(context, feedListType, baseFeedStoryMenuHelper, runnable, reactionAnalyticsParams, reactionFeedActionHandler, reactionInteractionTracker, reactionSession, delegate, canAddReactionComponentsImplProvider, canHandleHScrollPageChangedEventsImpl, hasReactionAnalyticsParamsImplProvider, hasReactionCardBackgroundImplProvider);
        this.f931m = navigationLogger;
        this.f932n = notificationsUtils;
    }

    @Nullable
    public final NotificationsEdgeFields m1216a(String str) {
        return null;
    }

    public final void m1219a(NotificationsEdgeFields notificationsEdgeFields) {
        NotificationsUtils notificationsUtils = this.f932n;
        Builder builder = new Builder();
        builder.a = notificationsEdgeFields.k().c();
        builder = builder;
        builder.b = GraphQLStorySeenState.SEEN_AND_READ;
        NotificationStorySeenStateMutationFieldsModel a = builder.a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("graphNotifsUpdateSeenStatePrams", new NotificationsChangeSeenStateParams(ImmutableList.of(notificationsEdgeFields.k().c()), GraphQLStorySeenState.SEEN_AND_READ));
        notificationsUtils.h.a(BlueServiceOperationFactoryDetour.a(notificationsUtils.b, "graphNotifUpdateSeenStateOnlyOnServer", bundle, -1481952910).a(), a);
    }

    public final boolean m1222a(String str, boolean z) {
        return false;
    }

    public final boolean m1221a(NotificationsEdgeFields notificationsEdgeFields, boolean z) {
        return false;
    }

    public final void m1220a(String str, ReactionUnitComponentFields reactionUnitComponentFields) {
    }

    public final void m1223b(String str) {
    }

    public final void m1217a() {
        this.f931m.a("tap_notification_jewel");
    }

    public final void m1218a(GraphQLStory graphQLStory, @Nullable GraphQLNotifHighlightState graphQLNotifHighlightState) {
    }
}
