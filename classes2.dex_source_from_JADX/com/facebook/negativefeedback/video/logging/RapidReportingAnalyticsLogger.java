package com.facebook.negativefeedback.video.logging;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import java.util.List;
import javax.inject.Inject;

/* compiled from: network_info_req_bw_egress_max */
public class RapidReportingAnalyticsLogger {
    private final AnalyticsLogger f12542a;

    @Inject
    public RapidReportingAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f12542a = analyticsLogger;
    }

    private void m18613a(HoneyClientEvent honeyClientEvent, String str) {
        honeyClientEvent.m5090b("graphql_token", str);
        this.f12542a.mo526a((HoneyAnalyticsEvent) honeyClientEvent);
    }

    public final void m18614a(String str) {
        m18613a(new HoneyClientEvent("fb4a_rapid_reporting_opened"), str);
    }

    public final void m18615a(String str, String str2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fb4a_rapid_reporting_selected_tag");
        honeyClientEvent.m5090b("tag", str2);
        m18613a(honeyClientEvent, str);
    }

    public final void m18618b(String str, String str2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fb4a_rapid_reporting_deselected_tag");
        honeyClientEvent.m5090b("tag", str2);
        m18613a(honeyClientEvent, str);
    }

    public final void m18616a(String str, List<String> list, String str2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fb4a_rapid_reporting_tapped_done");
        honeyClientEvent.m5086a("selected_tags", (Object) list);
        honeyClientEvent.m5090b("reason", str2);
        m18613a(honeyClientEvent, str);
    }

    public final void m18617b(String str) {
        m18613a(new HoneyClientEvent("fb4a_rapid_reporting_tapped_go_to_video"), str);
    }

    public final void m18619c(String str) {
        m18613a(new HoneyClientEvent("fb4a_rapid_reporting_visit_help_center"), str);
    }
}
