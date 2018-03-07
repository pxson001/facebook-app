package com.facebook.debug.tracer;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.debug.log.LogPrefixer;
import com.facebook.infer.annotation.IgnoreAllocations;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.TraceConfig;
import javax.annotation.Nullable;

/* compiled from: zero_rating2/clearable/default_optin/should_use_default_image_key */
public class Tracer {
    private static DefaultTracerConfigCallback f420a = new DefaultTracerConfigCallback();
    private static final ThreadLocal<ThreadState> f421b = new C00121();

    /* compiled from: zero_rating2/clearable/default_optin/should_use_default_image_key */
    final class C00121 extends ThreadLocal<ThreadState> {
        C00121() {
        }

        protected final Object initialValue() {
            return new ThreadState();
        }
    }

    /* compiled from: zero_rating2/clearable/default_optin/should_use_default_image_key */
    class ThreadState {
        public final LongStack f422a = new LongStack(20);
        public boolean f423b;
    }

    private Tracer() {
    }

    @IgnoreAllocations
    public static void m882a(String str) {
        m887c(str, null);
    }

    @IgnoreAllocations
    public static void m883a(String str, @Nullable Object obj) {
        m887c(str, new Object[]{obj});
    }

    public static void m887c(String str, @Nullable Object[] objArr) {
        ThreadState threadState = (ThreadState) f421b.get();
        if (!threadState.f423b) {
            if (threadState.f422a.m890a() >= 100) {
                BLog.c(Tracer.class, "Tracer stack overflow. There is probably a missing stopTracer somewhere.");
                threadState.f422a.m893c();
                threadState.f423b = true;
                return;
            }
            if (f420a.m889a()) {
                ThreadTrace threadTrace = (ThreadTrace) ThreadTrace.f426a.get();
                long a = (long) threadTrace.m904a(str, objArr, false);
                long b = threadTrace.m908b();
                threadState.f422a.m891a(a);
                threadState.f422a.m891a(b);
            } else {
                threadState.f422a.m891a((long) ThreadTrace.f427b);
                threadState.f422a.m891a(TracerClock.m909a());
            }
            if (TraceConfig.a(32)) {
                if (objArr != null) {
                    try {
                        str = StringFormatUtil.a(str, objArr);
                    } catch (Throwable e) {
                        BLog.c("Tracer", "Bad format string", e);
                    }
                }
                Systrace.a(32, str);
            }
        }
    }

    public static void m878a() {
        m877a(0, false);
    }

    public static void m880a(long j) {
        m877a(j, true);
    }

    public static long m884b() {
        return m877a(0, false) / 1000000;
    }

    private static long m877a(long j, boolean z) {
        Systrace.a(32);
        ThreadState threadState = (ThreadState) f421b.get();
        if (threadState.f423b) {
            return -1;
        }
        if (threadState.f422a.m890a() < 2) {
            BLog.c(Tracer.class, "Tracer stack underflow. There's an extra stopTracer somewhere.");
            threadState.f423b = true;
            return -1;
        }
        long a;
        long b = threadState.f422a.m892b();
        int b2 = (int) threadState.f422a.m892b();
        if (b2 != ThreadTrace.f427b) {
            a = ((ThreadTrace) ThreadTrace.f426a.get()).m905a(b2, j, z);
        } else {
            a = -1;
        }
        if (a == -1) {
            return TracerClock.m909a() - b;
        }
        return a;
    }

    public static void m885b(String str) {
        m888d(str, null);
    }

    public static void m888d(String str, Object[] objArr) {
        if (f420a.m889a()) {
            ((ThreadTrace) ThreadTrace.f426a.get()).m907a(str, objArr);
        }
    }

    public static void m881a(Class<?> cls) {
        m879a(3, LogPrefixer.a(cls));
    }

    public static void m886c(String str) {
        m879a(3, str);
    }

    private static void m879a(int i, String str) {
        int i2;
        ThreadTrace threadTrace = (ThreadTrace) ThreadTrace.f426a.get();
        for (i2 = threadTrace.f432g - 1; i2 >= 0; i2--) {
            TraceEvent traceEvent = threadTrace.f431f[i2];
            if (traceEvent != null) {
                i2 = traceEvent.f505b;
                break;
            }
        }
        i2 = ThreadTrace.f427b;
        threadTrace.m906a(i2, i, str);
    }
}
