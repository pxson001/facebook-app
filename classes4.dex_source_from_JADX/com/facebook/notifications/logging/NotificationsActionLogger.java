package com.facebook.notifications.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: experiment_group_name */
public class NotificationsActionLogger {
    private final AnalyticsLogger f12614a;

    public static NotificationsActionLogger m13421b(InjectorLike injectorLike) {
        return new NotificationsActionLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NotificationsActionLogger(AnalyticsLogger analyticsLogger) {
        this.f12614a = analyticsLogger;
    }

    public final void m13422a(String str, String str2, String str3, GraphQLStory graphQLStory, int i) {
        FeedProps c = FeedProps.c(graphQLStory);
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "notifications";
        this.f12614a.a(honeyClientEvent.b("action", str2).b("source", str3).a("pos", i).a("seen_state", graphQLStory.au()).a("tracking_codes", TrackableFeedProps.a(c)));
    }
}
