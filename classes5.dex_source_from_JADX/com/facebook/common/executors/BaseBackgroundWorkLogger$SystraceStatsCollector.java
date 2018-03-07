package com.facebook.common.executors;

import com.facebook.common.executors.BackgroundWorkLogger.StatsCollector;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMetadata;
import com.facebook.systrace.TraceConfig;

/* compiled from: start_time_sentence */
class BaseBackgroundWorkLogger$SystraceStatsCollector implements StatsCollector {
    private final String f2548a;
    private final Object f2549b;

    public BaseBackgroundWorkLogger$SystraceStatsCollector(String str, Object obj) {
        this.f2548a = str;
        this.f2549b = obj;
    }

    public final void m3669a() {
        if (TraceConfig.a(128)) {
            SystraceMetadata.c();
            Systrace.a(128, this.f2548a + "/" + this.f2549b.toString());
        }
    }

    public final void m3670a(boolean z) {
        Systrace.a(128);
    }
}
