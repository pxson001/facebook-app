package com.facebook.graphql.mqtt;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionHandle;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: send_recent_vpvs_in_tail_loads */
public class GraphQLSubscriptionAnalytics {
    private static final Class<?> f5599a = GraphQLSubscriptionAnalytics.class;
    private final AnalyticsLogger f5600b;

    public static GraphQLSubscriptionAnalytics m9560b(InjectorLike injectorLike) {
        return new GraphQLSubscriptionAnalytics(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike));
    }

    @Inject
    public GraphQLSubscriptionAnalytics(AnalyticsLogger analyticsLogger) {
        this.f5600b = analyticsLogger;
    }

    public final void m9561a(GraphQLSubscriptionHandle graphQLSubscriptionHandle) {
        m9559a("graphql_subscriptions_receive", graphQLSubscriptionHandle);
    }

    public final void m9562b(GraphQLSubscriptionHandle graphQLSubscriptionHandle) {
        m9559a("graphql_subscriptions_subscribe", graphQLSubscriptionHandle);
    }

    public final void m9563c(GraphQLSubscriptionHandle graphQLSubscriptionHandle) {
        m9559a("graphql_subscriptions_unsubscribe", graphQLSubscriptionHandle);
    }

    private void m9559a(String str, GraphQLSubscriptionHandle graphQLSubscriptionHandle) {
        try {
            HoneyClientEventFast a = this.f5600b.mo535a(str, false);
            if (a.m17388a()) {
                a.m17385a("subscription", graphQLSubscriptionHandle.mo3114c().m11308q());
                a.m17385a("handle_type", graphQLSubscriptionHandle.mo3116e());
                if (graphQLSubscriptionHandle.mo3117f() != null) {
                    a.m17383a("query_params", graphQLSubscriptionHandle.mo3117f());
                }
                a.m17390b();
            }
        } catch (Throwable e) {
            BLog.a(f5599a, e, "GraphQL Subscription analytics encountered an error.", new Object[0]);
        }
    }
}
