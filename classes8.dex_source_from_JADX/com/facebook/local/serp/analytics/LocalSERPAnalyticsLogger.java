package com.facebook.local.serp.analytics;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: editRegistrationContactpoint */
public class LocalSERPAnalyticsLogger {
    private final AnalyticsLogger f14940a;

    @Inject
    public LocalSERPAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f14940a = analyticsLogger;
    }

    public final void m17400a(String str, Surface surface, String str2, String str3, @Nullable String str4, String str5, @Nullable String str6, String str7) {
        m17399a("local_serp_abandon", str, surface, str2, str3, str4, str5, str6, str7);
    }

    public final void m17401b(String str, Surface surface, String str2, String str3, @Nullable String str4, String str5, @Nullable String str6, String str7) {
        m17399a("local_serp_open", str, surface, str2, str3, str4, str5, str6, str7);
    }

    private void m17399a(String str, String str2, Surface surface, String str3, String str4, @Nullable String str5, String str6, @Nullable String str7, String str8) {
        AnalyticsLogger analyticsLogger = this.f14940a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "local_serp";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.f = str2;
        analyticsLogger.a(honeyClientEvent.b("reaction_session_id", str2).a("surface", surface).b("candidate_result_sid", str6).b("query", str3).b("results_vertical", str8).b("source", str4).b("search_ts_token", str5).b("typeahead_sid", str7));
    }
}
