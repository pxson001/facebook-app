package com.facebook.notifications.multirow;

import android.support.v7.widget.LinearLayoutManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.notifications.logging.NotificationsLogger;
import com.facebook.notifications.logging.NotificationsLogger.Event;
import com.facebook.notifications.logging.NotificationsLogger.JewelNotificationEvent;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionSource;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;
import com.facebook.reaction.analytics.perflog.ReactionPerfLogger;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.today.abtest.TodayExperimentController;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: custom_cta_switch_from_linkout */
public class NotificationsFeedInteractionTracker extends ReactionInteractionTracker {
    private final GraphQLNotificationsContentProviderHelper f16119a;
    private final NotificationsFeedCollection f16120b;
    private final NotificationsLogger f16121c;
    private final NotificationsUtils f16122d;
    private final DefaultAndroidThreadUtil f16123e;
    private final TodayExperimentController f16124f;

    @Inject
    public NotificationsFeedInteractionTracker(@Assisted ReactionSession reactionSession, @Nullable @Assisted LinearLayoutManager linearLayoutManager, @Assisted NotificationsFeedCollection notificationsFeedCollection, AbstractFbErrorReporter abstractFbErrorReporter, GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, NotificationsLogger notificationsLogger, NotificationsUtils notificationsUtils, ReactionAnalyticsLogger reactionAnalyticsLogger, ReactionPerfLogger reactionPerfLogger, DefaultAndroidThreadUtil defaultAndroidThreadUtil, TodayExperimentController todayExperimentController) {
        super(reactionSession, linearLayoutManager, abstractFbErrorReporter, reactionAnalyticsLogger, reactionPerfLogger);
        this.f16119a = graphQLNotificationsContentProviderHelper;
        this.f16120b = notificationsFeedCollection;
        this.f16121c = notificationsLogger;
        this.f16122d = notificationsUtils;
        this.f16123e = defaultAndroidThreadUtil;
        this.f16124f = todayExperimentController;
    }

    public final void mo981a(String str, String str2, ReactionAttachmentIntent reactionAttachmentIntent) {
        super.mo981a(str, str2, reactionAttachmentIntent);
        m18954a(str, reactionAttachmentIntent.f18828a.name, reactionAttachmentIntent.f18829b);
    }

    public final void mo984a(String str, String str2, @Nullable UnitInteractionSource unitInteractionSource, UnitInteractionType unitInteractionType) {
        super.mo984a(str, str2, unitInteractionSource, unitInteractionType);
        m18954a(str, unitInteractionType.name, null);
    }

    private void m18954a(String str, final String str2, @Nullable final String str3) {
        NotificationsEdgeFields b = this.f16120b.m18845b(str);
        if (b != null && b.k() != null) {
            GraphQLStory k = this.f16124f.v() ? b.k() : this.f16119a.c(b.k().g());
            if (k != null) {
                m18953a(this, k, str2, str3);
            } else {
                this.f16123e.a(this.f16122d.a(b.k().c(), b.k().g()), new FutureCallback<GraphQLStory>(this) {
                    final /* synthetic */ NotificationsFeedInteractionTracker f16095c;

                    public void onSuccess(Object obj) {
                        NotificationsFeedInteractionTracker.m18953a(this.f16095c, (GraphQLStory) obj, str2, str3);
                    }

                    public void onFailure(Throwable th) {
                    }
                });
            }
        }
    }

    public static void m18953a(NotificationsFeedInteractionTracker notificationsFeedInteractionTracker, GraphQLStory graphQLStory, @Nullable String str, String str2) {
        boolean z = !GraphQLStorySeenState.SEEN_AND_READ.equals(graphQLStory.au());
        NotificationLogObject notificationLogObject = new NotificationLogObject();
        notificationLogObject.i = graphQLStory.k();
        notificationLogObject = notificationLogObject;
        notificationLogObject.j = true;
        NotificationLogObject notificationLogObject2 = notificationLogObject;
        notificationLogObject2.k = z;
        NotificationLogObject notificationLogObject3 = notificationLogObject2;
        notificationLogObject3.v = notificationsFeedInteractionTracker.f16120b.m18839a(graphQLStory.c());
        notificationLogObject3 = notificationLogObject3;
        NotificationsLogger notificationsLogger = notificationsFeedInteractionTracker.f16121c;
        if (notificationLogObject3 != null) {
            notificationsLogger.b.a(new JewelNotificationEvent(notificationsLogger, Event.graph_notification_click, notificationLogObject3).b("reaction_unit_interaction", str).b("reaction_destination_entity_id", str2));
        }
    }
}
