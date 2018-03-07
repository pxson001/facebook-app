package com.facebook.quicklog.ctscan;

import android.database.Observable;
import com.facebook.base.lwperf.perfstats.PerfStats;
import com.facebook.debug.log.BLog;
import com.facebook.perftestutils.logger.PerfTestLogger;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.quicklog.PerformanceLoggingEvent;
import com.facebook.quicklog.PerformanceLoggingEventVisitor;
import com.facebook.quicklog.QPLGenericListener;
import com.facebook.quicklog.QuickEvent;
import com.facebook.quicklog.QuickEventListener;
import com.facebook.quicklog.QuickPerformanceLoggerImpl;
import com.facebook.quicklog.identifiers.ActionId;
import com.facebook.quicklog.identifiers.DebugUtils;
import com.facebook.quicklog.module.StandardDebugAndTestConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: uploader_class is null or empty */
public class QPLVisitorForCTScan extends Observable<QPLGenericListener> implements PerformanceLoggingEventVisitor, QuickEventListener {
    public static final String f1584a = QuickPerformanceLoggerImpl.f1560a;
    private static QPLVisitorForCTScan f1585c = null;
    private final StandardDebugAndTestConfig f1586b;

    @DoNotStrip
    public static QPLVisitorForCTScan getInstance() {
        return f1585c;
    }

    @DoNotStrip
    public static QPLVisitorForCTScan create(StandardDebugAndTestConfig standardDebugAndTestConfig) {
        if (f1585c == null) {
            f1585c = new QPLVisitorForCTScan(standardDebugAndTestConfig);
        }
        return f1585c;
    }

    private QPLVisitorForCTScan(StandardDebugAndTestConfig standardDebugAndTestConfig) {
        this.f1586b = standardDebugAndTestConfig;
    }

    private void m3194b(PerformanceLoggingEvent performanceLoggingEvent) {
        if (performanceLoggingEvent == null || this.mObservers == null) {
            BLog.a(QPLVisitorForCTScan.class, "performanceLoggingEvent/mObservers cannot be null.");
            return;
        }
        synchronized (this.mObservers) {
            Iterator it = this.mObservers.iterator();
            while (it.hasNext()) {
                ((1) it.next()).onPerformanceLoggingEvent(performanceLoggingEvent);
            }
        }
    }

    @DoNotStrip
    public void dummy() {
        registerObserver(new 1(this));
    }

    private void m3195c(PerformanceLoggingEvent performanceLoggingEvent) {
        if (this.f1586b.m2933b() || !(this.mObservers == null || this.mObservers.isEmpty())) {
            String str = performanceLoggingEvent.f7950x;
            if (str == null) {
                str = DebugUtils.a(performanceLoggingEvent.f7937k);
            }
            Map hashMap = new HashMap();
            int i = 0;
            Object obj = null;
            for (String str2 : performanceLoggingEvent.f7948v) {
                i++;
                if (i % 2 == 0) {
                    hashMap.put(obj, str2);
                } else {
                    obj = str2;
                }
            }
            PerfStats perfStats = performanceLoggingEvent.f7945s;
            if (perfStats != null && perfStats.c) {
                hashMap.put("class_load_attempts", Integer.toString(perfStats.j()));
                hashMap.put("dex_queries", Integer.toString(perfStats.k()));
                hashMap.put("start_pri", Integer.toString(perfStats.e));
                hashMap.put("stop_pri", Integer.toString(perfStats.f));
                hashMap.put("ps_cpu_ms", Long.toString(perfStats.g));
                hashMap.put("ps_flt", Long.toString(perfStats.i));
                if (perfStats.l()) {
                    hashMap.put("th_cpu_ms", Long.toString(perfStats.h));
                    hashMap.put("th_flt", Long.toString(perfStats.j));
                }
            }
            if (performanceLoggingEvent.f7936j != -1) {
                hashMap.put("gc_ms", Integer.toString(performanceLoggingEvent.f7936j));
            }
            PerfTestLogger.a(f1584a, str, hashMap.toString(), performanceLoggingEvent.f7934h, (long) performanceLoggingEvent.f7935i, ActionId.a(performanceLoggingEvent.f7941o));
            m3194b(performanceLoggingEvent);
        }
    }

    public final void mo494a(PerformanceLoggingEvent performanceLoggingEvent) {
        m3195c(performanceLoggingEvent);
    }

    public final void mo489a(QuickEvent quickEvent) {
        if (quickEvent != null && this.mObservers != null && this.mObservers.size() != 0) {
            BLog.a(f1584a, "QPL markerStart - %d", new Object[]{Integer.valueOf(quickEvent.m1010i())});
            synchronized (this.mObservers) {
                Iterator it = this.mObservers.iterator();
                while (it.hasNext()) {
                    ((1) it.next()).mo489a(quickEvent);
                }
            }
        }
    }

    public final void mo490b(QuickEvent quickEvent) {
        if (quickEvent != null && this.mObservers != null && this.mObservers.size() != 0) {
            synchronized (this.mObservers) {
                Iterator it = this.mObservers.iterator();
                while (it.hasNext()) {
                    ((1) it.next()).mo490b(quickEvent);
                }
            }
        }
    }

    public final void mo491c(QuickEvent quickEvent) {
        if (quickEvent != null && this.mObservers != null && this.mObservers.size() != 0) {
            synchronized (this.mObservers) {
                Iterator it = this.mObservers.iterator();
                while (it.hasNext()) {
                    ((1) it.next()).mo491c(quickEvent);
                }
            }
        }
    }

    public final void mo492d(QuickEvent quickEvent) {
        if (quickEvent != null && this.mObservers != null && this.mObservers.size() != 0) {
            synchronized (this.mObservers) {
                Iterator it = this.mObservers.iterator();
                while (it.hasNext()) {
                    ((1) it.next()).mo492d(quickEvent);
                }
            }
        }
    }

    public final void mo493e(QuickEvent quickEvent) {
    }
}
