package com.facebook.messaging.analytics.search;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.collect.ImmutableList;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: p2p_enter_pin */
public class FilterSessionManager {
    private static final Class<?> f7661a = FilterSessionManager.class;
    private AnalyticsLogger f7662b;
    private Clock f7663c;
    public Set<String> f7664d = new LinkedHashSet();
    private String f7665e;
    public String f7666f;
    private int f7667g;
    private long f7668h;

    public static FilterSessionManager m7963b(InjectorLike injectorLike) {
        return new FilterSessionManager(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FilterSessionManager(AnalyticsLogger analyticsLogger, Clock clock) {
        this.f7662b = analyticsLogger;
        this.f7663c = clock;
    }

    public final void m7966a(String str, String str2) {
        if (this.f7666f != null) {
            BLog.a(f7661a, "Starting search session with one already ongoing");
        }
        this.f7668h = this.f7663c.a();
        this.f7664d.clear();
        this.f7667g = 0;
        this.f7665e = str;
        this.f7666f = SafeUUIDGenerator.a().toString();
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("search_session_started_by_user");
        honeyClientEvent.c = this.f7665e;
        honeyClientEvent = honeyClientEvent.b("surface", str2);
        honeyClientEvent.f = this.f7666f;
        this.f7662b.a(honeyClientEvent);
    }

    public final void m7967b() {
        m7960a(null);
    }

    private void m7960a(@Nullable ImmutableList<String> immutableList) {
        if (this.f7666f != null) {
            m7961a("search_session_ended_by_user", (ImmutableList) immutableList);
        } else {
            BLog.a(f7661a, "Tried to cancel a search session but no session is ongoing");
        }
    }

    public final void m7965a(String str, int i, String str2, String str3) {
        if (this.f7666f != null) {
            m7962a("search_session_ended_by_user", str, i, str2, str3, null);
        } else {
            BLog.a(f7661a, "Tried to terminate a search session but no session is ongoing");
        }
    }

    public final void m7964a(String str) {
        if (this.f7666f != null) {
            if (this.f7667g < 10) {
                this.f7664d.add(str);
            }
            this.f7667g++;
            return;
        }
        BLog.a(f7661a, "Tried to add a query string to a session but no session is ongoing");
    }

    private void m7961a(String str, ImmutableList<String> immutableList) {
        m7962a(str, null, 0, "", "", immutableList);
    }

    private void m7962a(String str, String str2, int i, String str3, String str4, @Nullable ImmutableList<String> immutableList) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = this.f7665e;
        honeyClientEvent = honeyClientEvent;
        String str5 = "search_terms";
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (String h : this.f7664d) {
            arrayNode.h(h);
        }
        honeyClientEvent = honeyClientEvent.a(str5, arrayNode).a("total_search_attempts", this.f7667g).a("total_search_duration", this.f7663c.a() - this.f7668h).b("section_name", str4).a("impression_list", immutableList);
        honeyClientEvent.f = this.f7666f;
        honeyClientEvent = honeyClientEvent;
        if (str2 != null) {
            honeyClientEvent.b("contact_type", str2).a("result_index", i).b("result_id", str3);
        }
        this.f7664d.clear();
        this.f7666f = null;
        this.f7662b.a(honeyClientEvent);
    }
}
