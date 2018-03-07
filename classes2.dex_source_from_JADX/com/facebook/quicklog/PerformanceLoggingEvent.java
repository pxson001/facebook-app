package com.facebook.quicklog;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.lwperf.perfstats.PerfStats;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.util.TriState;
import com.facebook.quicklog.driver.analytics1.DefaultHoneyClientLogger;
import com.facebook.quicklog.driver.analytics1.HoneyQuickPerformanceEvent;
import com.facebook.quicklog.identifiers.DebugUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: reading_attachment_profile_image_height */
public class PerformanceLoggingEvent implements Poolable<PerformanceLoggingEvent>, Runnable {
    public static int f7927a = 255;
    public static int f7928b = 24;
    public static final ObjectPool<PerformanceLoggingEvent> f7929c = new C03401(500);
    public boolean f7930d;
    int f7931e = ((f7927a & 1) << f7928b);
    public int f7932f;
    public long f7933g;
    public long f7934h;
    public int f7935i;
    public int f7936j;
    public int f7937k;
    public int f7938l;
    public boolean f7939m;
    public boolean f7940n;
    public short f7941o;
    public short f7942p;
    public int f7943q;
    DefaultHoneyClientLogger f7944r;
    public PerfStats f7945s;
    public TriState f7946t;
    public TriState f7947u;
    public ArrayList<String> f7948v = new ArrayList();
    public ArrayList<String> f7949w = new ArrayList();
    public String f7950x;
    private PerformanceLoggingEvent f7951y;

    /* compiled from: reading_attachment_profile_image_height */
    final class C03401 extends ObjectPool<PerformanceLoggingEvent> {
        C03401(int i) {
            super(i);
        }

        final Poolable mo642a() {
            return new PerformanceLoggingEvent();
        }
    }

    public final void mo80a(Object obj) {
        this.f7951y = (PerformanceLoggingEvent) obj;
    }

    public final Object mo79a() {
        return this.f7951y;
    }

    public final void mo81b() {
        this.f7937k = 0;
        this.f7950x = null;
        this.f7948v.clear();
        this.f7949w.clear();
        this.f7951y = null;
        this.f7945s = null;
    }

    PerformanceLoggingEvent() {
        mo81b();
    }

    public void run() {
        String str;
        DefaultHoneyClientLogger defaultHoneyClientLogger = this.f7944r;
        HoneyAnalyticsEvent honeyQuickPerformanceEvent = new HoneyQuickPerformanceEvent(this, "perf");
        String str2 = "marker";
        short s = this.f7941o;
        if (s == (short) 3) {
            str = "client_fail";
        } else if (s == (short) 4) {
            str = "client_cancel";
        } else {
            str = "client_tti";
        }
        honeyQuickPerformanceEvent.m5090b(str2, str);
        if (this.f7950x != null) {
            honeyQuickPerformanceEvent.f3099c = this.f7950x;
        }
        honeyQuickPerformanceEvent.m5083a("value", this.f7935i);
        HoneyAnalyticsEvent honeyAnalyticsEvent = honeyQuickPerformanceEvent;
        honeyAnalyticsEvent.m5086a("connqual", ((FbDataConnectionManager) defaultHoneyClientLogger.f7968b.get()).m3801c());
        honeyAnalyticsEvent.m5090b("network_type", ((FbNetworkManager) defaultHoneyClientLogger.f7969c.get()).m3835k());
        honeyAnalyticsEvent.m5090b("network_subtype", ((FbNetworkManager) defaultHoneyClientLogger.f7969c.get()).m3836l());
        if (DefaultHoneyClientLogger.f7966d != null) {
            honeyAnalyticsEvent.m5090b("scenario", DefaultHoneyClientLogger.f7966d);
        }
        ((AnalyticsLogger) defaultHoneyClientLogger.f7967a.get()).mo531b(honeyAnalyticsEvent);
        f7929c.m4468a(this);
    }

    public final void m12522a(List<String> list) {
        if (list != null) {
            this.f7948v.addAll(list);
        }
    }

    public final void m12521a(String str) {
        this.f7949w.add(str);
    }

    final void m12524b(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.f7949w.addAll(list);
        }
    }

    final void m12519a(long j, long j2) {
        if (j < 0 || j2 < 0 || j2 < j) {
            this.f7936j = -1;
        } else {
            this.f7936j = (int) (j2 - j);
        }
    }

    final void m12518a(int i) {
        this.f7931e &= -16711681;
        this.f7931e |= (i & 255) << 16;
    }

    public final String m12525e() {
        return DebugUtils.a(this.f7937k);
    }
}
