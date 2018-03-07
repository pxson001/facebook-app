package com.facebook.quicklog;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.quicklog.QuickPerformanceLogger.Builder;

@DoNotStrip
/* compiled from: upload_max_bytes */
public class QuickPerformanceLoggerProvider {
    private static QuickPerformanceLogger f1634a;
    private static Builder f1635b;

    public static void m3286a(QuickPerformanceLogger quickPerformanceLogger) {
        f1634a = quickPerformanceLogger;
    }

    @DoNotStrip
    public static QuickPerformanceLogger getQPLInstance() {
        if (f1634a != null) {
            return f1634a;
        }
        if (f1635b == null) {
            return null;
        }
        QuickPerformanceLogger a = f1635b.a();
        f1634a = a;
        return a;
    }
}
