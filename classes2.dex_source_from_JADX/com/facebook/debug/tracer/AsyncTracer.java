package com.facebook.debug.tracer;

import com.facebook.systrace.Systrace;

/* compiled from: zero_rating2/carrier_manager_shortcut */
public class AsyncTracer {
    public final ThreadTrace f498a;
    public final int f499b;
    public final long f500c;
    private final String f501d;
    public long f502e = -1;

    public static AsyncTracer m1032a(String str) {
        return m1033b(str, null);
    }

    public static AsyncTracer m1033b(String str, Object[] objArr) {
        ThreadTrace threadTrace = (ThreadTrace) ThreadTrace.f426a.get();
        int a = threadTrace.m904a(str, objArr, true);
        String d = ((TraceEvent) threadTrace.f430e.get(a)).m1044d();
        AsyncTracer asyncTracer = new AsyncTracer(threadTrace, a, TracerClock.m909a(), d);
        Systrace.b(32, d, asyncTracer.f499b);
        return asyncTracer;
    }

    private AsyncTracer(ThreadTrace threadTrace, int i, long j, String str) {
        this.f498a = threadTrace;
        this.f499b = i;
        this.f500c = j;
        this.f501d = str;
    }

    public final void m1034a() {
        m1031a(0, false);
    }

    public final long m1035c() {
        return m1031a(0, false) / 1000000;
    }

    private long m1031a(long j, boolean z) {
        Systrace.c(32, this.f501d, this.f499b);
        long a = this.f498a.m905a(this.f499b, j, z);
        if (a == -1) {
            a = TracerClock.m909a() - this.f500c;
        }
        this.f502e = a;
        return a;
    }
}
