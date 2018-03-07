package com.facebook.quicklog.driver.analytics1;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.lwperf.perfstats.PerfStats;
import com.facebook.quicklog.PerformanceLoggingEvent;
import com.facebook.quicklog.identifiers.PerformanceEventFields;
import java.util.Iterator;

/* compiled from: reactors.count */
public class HoneyQuickPerformanceEvent extends HoneyClientEvent {
    public HoneyQuickPerformanceEvent(PerformanceLoggingEvent performanceLoggingEvent, String str) {
        Object obj;
        super(str);
        this.f3112e = performanceLoggingEvent.f7933g;
        this.f3102f = String.valueOf(performanceLoggingEvent.f7932f);
        m5083a("marker_id", performanceLoggingEvent.f7937k);
        m5083a("instance_id", performanceLoggingEvent.f7932f);
        m5083a("sample_rate", performanceLoggingEvent.f7938l);
        m5084a("time_since_boot_ms", performanceLoggingEvent.f7934h);
        m5083a("duration_ms", performanceLoggingEvent.f7935i);
        m5083a("action_id", (int) performanceLoggingEvent.f7941o);
        m5083a("duration_since_prev_action_ms", performanceLoggingEvent.f7943q);
        m5083a("prev_action_id", (int) performanceLoggingEvent.f7942p);
        PerfStats perfStats = performanceLoggingEvent.f7945s;
        if (perfStats != null && perfStats.c) {
            m5083a("start_pri", perfStats.e);
            m5083a("stop_pri", perfStats.f);
            m5084a("ps_cpu_ms", perfStats.g);
            m5084a("ps_flt", perfStats.i);
            if (perfStats.l()) {
                m5084a("th_cpu_ms", perfStats.h);
                m5084a("th_flt", perfStats.j);
            }
            m5083a("class_load_attempts", perfStats.j());
            m5083a("dex_queries", perfStats.k());
        }
        if (performanceLoggingEvent.f7947u == null || !performanceLoggingEvent.f7947u.isSet()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            m5087a("was_backgrounded", performanceLoggingEvent.f7947u.asBoolean(false));
        }
        if (performanceLoggingEvent.f7930d) {
            if (performanceLoggingEvent.f7946t == null || !performanceLoggingEvent.f7946t.isSet()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                m5087a("app_started_in_bg", performanceLoggingEvent.f7946t.asBoolean(false));
            }
        }
        m5090b("method", PerformanceEventFields.m12724a(performanceLoggingEvent.f7940n, performanceLoggingEvent.f7939m));
        if (performanceLoggingEvent.f7936j != -1) {
            m5083a("gc_ms", performanceLoggingEvent.f7936j);
        }
        Iterator it = performanceLoggingEvent.f7948v.iterator();
        while (it.hasNext()) {
            m5090b((String) it.next(), (String) it.next());
        }
    }
}
