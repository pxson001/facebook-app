package com.facebook.graphql.executor;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.google.common.base.Throwables;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: requires_post_approval */
public class GraphQLQueryAnalyticsEventImpl implements GraphQLQueryAnalyticsEvent {
    private static final Class<?> f7210a = GraphQLQueryAnalyticsEventImpl.class;
    public final MonotonicClock f7211b;
    private final Clock f7212c;
    private final GraphQLQueryAnalyticsEventPool f7213d;
    private String f7214e;
    private HoneyClientEvent f7215f;
    public long f7216g;
    private long f7217h;

    public GraphQLQueryAnalyticsEventImpl(Clock clock, MonotonicClock monotonicClock, GraphQLQueryAnalyticsEventPool graphQLQueryAnalyticsEventPool) {
        this.f7211b = monotonicClock;
        this.f7212c = clock;
        this.f7213d = graphQLQueryAnalyticsEventPool;
    }

    final void m11679a(String str, @Nullable String str2, boolean z, boolean z2) {
        this.f7214e = z2 ? "mutation" : "read";
        long now = this.f7211b.now();
        this.f7216g = now;
        this.f7217h = now;
        this.f7215f = new HoneyClientEvent(z ? "batch_cache_access" : "cache_access");
        this.f7215f.m5090b("cache_name", str);
        this.f7215f.m5090b("query_type", this.f7214e);
        if (str2 != null) {
            this.f7215f.m5090b("policy_name", str2);
        }
        this.f7215f.m5087a("consistency_enabled", false);
        this.f7215f.m5087a("consistent_fields_changed_on_read", false);
    }

    public final void mo1465a(String str) {
        long now = this.f7211b.now();
        this.f7215f.m5084a(str + "_ms", now - this.f7217h);
        this.f7217h = now;
    }

    public final void mo1461a(long j) {
        this.f7215f.m5084a("disk_age_ms", this.f7212c.mo211a() - j);
    }

    public final void mo1470b(String str) {
        this.f7215f.m5084a(str + "_ms", this.f7211b.now() - this.f7216g);
    }

    public final void mo1468a(boolean z) {
        this.f7215f.m5087a("service_enabled", z);
    }

    public final void mo1466a(String str, String str2) {
        mo1465a(str);
        this.f7215f.m5090b(str + "_result", str2);
    }

    public final HoneyClientEvent mo1460a() {
        try {
            mo1470b("total");
            if (BLog.b(3)) {
                this.f7215f.m5104u();
            }
            HoneyClientEvent honeyClientEvent = this.f7215f;
            return honeyClientEvent;
        } finally {
            this.f7213d.m10498a(this);
        }
    }

    public final void mo1467a(String str, Throwable th) {
        mo1466a(str, Throwables.getRootCause(th).toString());
        BLog.b(f7210a, th, "error in step %s", new Object[]{str});
    }

    public final void mo1464a(Exception exception) {
        this.f7215f.m5090b("error_return", Throwables.getRootCause(exception).toString());
    }

    public final void mo1463a(GraphQLRequest graphQLRequest, Exception exception) {
        this.f7215f.m5090b("batch_error_return_" + graphQLRequest.m11600a(), Throwables.getRootCause(exception).toString());
    }

    public final void mo1462a(GraphQLRequest graphQLRequest) {
        mo1470b("batch_return_to_caller_" + graphQLRequest.m11600a());
    }

    public final void mo1469b() {
        this.f7215f.m5087a("consistency_enabled", true);
    }

    public final void mo1471c() {
        this.f7215f.m5087a("consistent_fields_changed_on_read", true);
    }

    public final void mo1472d() {
        this.f7215f.m5087a("subscription_rerun", true);
    }
}
