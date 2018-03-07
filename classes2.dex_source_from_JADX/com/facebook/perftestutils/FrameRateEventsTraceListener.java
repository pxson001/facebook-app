package com.facebook.perftestutils;

import com.facebook.systrace.TraceConfig;
import com.facebook.systrace.TraceListener;

/* compiled from: user_certs */
public class FrameRateEventsTraceListener implements TraceListener {
    private static boolean f1467a = false;

    private FrameRateEventsTraceListener() {
    }

    public static void m2796c() {
        TraceConfig.a(new FrameRateEventsTraceListener());
    }

    public final void m2797a() {
        synchronized (FrameRateEventsTraceListener.class) {
            if (TraceConfig.a(262144) && !f1467a) {
                String property = System.getProperty("java.vm.version");
                if (property == null || property.startsWith("0.") || property.startsWith("1.")) {
                    FrameRateEventsTracer.a();
                    f1467a = true;
                } else {
                    throw new RuntimeException("ART not supported.");
                }
            }
        }
    }

    public final void m2798b() {
        synchronized (FrameRateEventsTraceListener.class) {
            if (f1467a) {
                FrameRateEventsTracer.b();
                f1467a = false;
            }
        }
    }
}
