package com.facebook.platform.perflogging;

import android.os.Process;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.TriState;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

/* compiled from: stickers_in_composer */
public class PlatformPerformanceUtility {
    public static ImmutableMap<String, String> m6027a(long j, MonotonicClock monotonicClock, AppStateManager appStateManager, boolean z) {
        boolean z2;
        long c;
        if (appStateManager.k() != TriState.YES) {
            Object obj;
            if (appStateManager.M > 0 || appStateManager.P > 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                z2 = true;
                c = appStateManager.c();
                if (j > 0) {
                    c -= monotonicClock.now() - j;
                }
                return new Builder().b("time_since_launch_ms", String.valueOf(c)).b("process_uptime", String.valueOf(m6026a())).b("maybe_cold_start", String.valueOf(z2)).b("scenario_first_run", String.valueOf(z)).b();
            }
        }
        z2 = false;
        c = appStateManager.c();
        if (j > 0) {
            c -= monotonicClock.now() - j;
        }
        return new Builder().b("time_since_launch_ms", String.valueOf(c)).b("process_uptime", String.valueOf(m6026a())).b("maybe_cold_start", String.valueOf(z2)).b("scenario_first_run", String.valueOf(z)).b();
    }

    private static long m6026a() {
        return Process.getElapsedCpuTime();
    }
}
