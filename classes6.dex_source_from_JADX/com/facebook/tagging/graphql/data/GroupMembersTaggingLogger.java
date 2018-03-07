package com.facebook.tagging.graphql.data;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import javax.inject.Inject;

/* compiled from: dest_address */
public class GroupMembersTaggingLogger {
    private final AnalyticsLogger f17432a;

    @Inject
    public GroupMembersTaggingLogger(AnalyticsLogger analyticsLogger) {
        this.f17432a = analyticsLogger;
    }

    public final void m25248a(boolean z, long j, String str, boolean z2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fb4a_tagging_group_members_query");
        honeyClientEvent.a("is_intent_mention", z);
        honeyClientEvent.a("wait_time", j);
        honeyClientEvent.b("query_string", str);
        honeyClientEvent.a("is_fallback_datasource", z2);
        this.f17432a.a(honeyClientEvent);
    }
}
