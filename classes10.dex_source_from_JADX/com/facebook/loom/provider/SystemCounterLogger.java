package com.facebook.loom.provider;

import android.os.Debug;
import com.facebook.base.lwperf.perfstats.PerfStats;
import com.facebook.base.lwperf.perfstats.ProcIoStats;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: threadname */
public class SystemCounterLogger {
    public static PerfStats f1451a = new PerfStats();

    public static void m1453a(Map<Integer, WeakReference<Thread>> map) {
        NativeEventProvider.b();
        f1451a.m();
        m1451a(9240579, f1451a.g);
        m1451a(9240580, f1451a.i);
        m1451a(9240583, (long) f1451a.j());
        m1451a(9240584, (long) f1451a.k());
        m1451a(9240593, (long) Debug.getGlobalAllocCount());
        m1451a(9240594, (long) Debug.getGlobalAllocSize());
        m1451a(9240595, (long) Debug.getGlobalGcInvocationCount());
        for (Entry entry : map.entrySet()) {
            m1452a(((Integer) entry.getKey()).intValue(), (WeakReference) entry.getValue());
        }
    }

    private static void m1452a(int i, WeakReference<Thread> weakReference) {
        Thread thread = (Thread) weakReference.get();
        if (thread != null && thread.isAlive()) {
            int i2 = i;
            Logger.a(64, i2, EntryType.COUNTER, 9240582, ProcIoStats.a(ProcIoStats.b(i))[2]);
        }
    }

    public static void m1451a(int i, long j) {
        Logger.a(64, EntryType.COUNTER, i, j);
    }
}
