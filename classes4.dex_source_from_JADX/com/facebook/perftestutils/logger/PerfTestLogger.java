package com.facebook.perftestutils.logger;

import com.facebook.common.build.BuildConstants;
import com.facebook.debug.log.BLog;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: workUserSwitchCredentials */
public class PerfTestLogger {
    private static final AtomicBoolean f77a = new AtomicBoolean(false);

    @DoNotStrip
    public static void setLogBuffering(boolean z) {
        f77a.set(z);
    }

    public static void m86a(String str, String str2, String str3, long j, long j2, String str4) {
        if (BuildConstants.d() && f77a.get()) {
            if (BufferedPerfTestLogger.log(str, "Name: %s; Params: %s; Monotonic Timestamp (ms): %d; Elapsed (ms): %d; Action: %s", str2, str3, j, j2, str4)) {
                return;
            }
        }
        BLog.a(str, "Name: " + str2 + "; Params: " + str3 + "; Monotonic Timestamp (ms): " + j + "; Elapsed (ms): " + j2 + "; Action: " + str4);
    }

    public static void m85a(String str, String str2, String str3, long j, long j2) {
        if (BuildConstants.d() && f77a.get()) {
            if (BufferedPerfTestLogger.log(str, "Stopped Marker %s (%s); Monotonic Timestamp (ms): %d; Elapsed: %d ms", str2, str3, j, j2)) {
                return;
            }
        }
        BLog.a(str, "Stopped Marker %s (%s); Monotonic Timestamp (ms): %d; Elapsed: %d ms", new Object[]{str2, str3, Long.valueOf(j), Long.valueOf(j2)});
    }

    public static void m84a(String str, long j, long j2) {
        if (BuildConstants.l && f77a.get()) {
            if (BufferedPerfTestLogger.log(str, "Stopped sequence; Monotonic Timestamp (ms): %d; Total Elapsed: %d ms", j, j2)) {
                return;
            }
        }
        BLog.a(str, "Stopped sequence; Monotonic Timestamp (ms): %d; Total Elapsed: %d ms", new Object[]{Long.valueOf(j), Long.valueOf(j2)});
    }
}
