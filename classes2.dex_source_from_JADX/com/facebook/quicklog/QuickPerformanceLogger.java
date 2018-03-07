package com.facebook.quicklog;

import com.facebook.base.lwperf.perfstats.PerfStats;
import com.facebook.common.util.TriState;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.Collection;
import java.util.Map;

@DoNotStrip
/* compiled from: upsell_seen_count */
public interface QuickPerformanceLogger {
    int mo436a();

    void mo437a(int i, int i2);

    void mo438a(int i, int i2, int i3, String str, long j, boolean z, boolean z2, PerfStats perfStats, TriState triState);

    void mo439a(int i, int i2, int i3, String str, String str2);

    void mo440a(int i, int i2, long j, boolean z);

    void mo441a(int i, int i2, String str);

    void mo442a(int i, int i2, String str, String str2);

    void mo443a(int i, int i2, Collection<? extends Object> collection);

    void mo444a(int i, int i2, Map<String, String> map);

    void mo445a(int i, int i2, short s);

    void mo446a(int i, int i2, short s, long j, TriState triState);

    void mo447a(int i, int i2, short s, String str, String str2);

    void mo448a(int i, String str);

    void mo449a(int i, String str, String str2);

    void mo450a(int i, String str, String str2, long j);

    void mo451a(int i, Collection<? extends Object> collection);

    void mo452a(int i, short s);

    void mo453a(int i, short s, int i2);

    void mo454a(int i, short s, long j);

    void mo455a(int i, short s, String str, int i2);

    void mo456a(int i, short s, String str, String str2);

    void mo457a(Object obj);

    void mo458a(short s);

    void mo459a(short s, String str);

    boolean mo460a(int i);

    boolean mo461a(int i, int i2, int i3);

    void mo462b(int i);

    void mo463b(int i, int i2);

    void mo464b(int i, int i2, String str);

    void mo465b(int i, int i2, String str, String str2);

    void mo466b(int i, int i2, short s);

    void mo467b(int i, String str, String str2);

    void mo468b(int i, short s);

    void mo469b(int i, short s, int i2);

    boolean mo470b();

    void mo471c(int i);

    boolean mo472c();

    boolean mo473c(int i, int i2);

    @DoNotStrip
    long currentMonotonicTimestamp();

    long mo475d(int i, int i2);

    void mo476d(int i);

    void mo477e(int i);

    void mo478e(int i, int i2);

    void mo479f(int i, int i2);

    boolean mo480f(int i);

    void mo481g(int i, int i2);

    boolean mo482h(int i, int i2);

    void mo483i(int i, int i2);

    boolean mo484j(int i, int i2);

    @DoNotStrip
    void markerCancel(int i, int i2);

    @DoNotStrip
    void markerEnd(int i, int i2, short s, long j);

    @DoNotStrip
    void markerNote(int i, int i2, short s, long j);

    @DoNotStrip
    void markerStart(int i, int i2, long j);
}
