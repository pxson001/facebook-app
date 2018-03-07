package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

public class zze {
    private final long f6666a;
    private final int f6667b;
    private final SimpleArrayMap<String, Long> f6668c;

    public zze() {
        this.f6666a = 60000;
        this.f6667b = 10;
        this.f6668c = new SimpleArrayMap(10);
    }

    public zze(int i, long j) {
        this.f6666a = j;
        this.f6667b = i;
        this.f6668c = new SimpleArrayMap();
    }

    private void m12449a(long j, long j2) {
        for (int size = this.f6668c.size() - 1; size >= 0; size--) {
            if (j2 - ((Long) this.f6668c.c(size)).longValue() > j) {
                this.f6668c.d(size);
            }
        }
    }

    public final Long m12450a(String str) {
        Long l;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f6666a;
        synchronized (this) {
            while (this.f6668c.size() >= this.f6667b) {
                m12449a(j, elapsedRealtime);
                j /= 2;
                Log.w("ConnectionTracker", "The max capacity " + this.f6667b + " is not enough. Current durationThreshold is: " + j);
            }
            l = (Long) this.f6668c.put(str, Long.valueOf(elapsedRealtime));
        }
        return l;
    }

    public final boolean m12451b(String str) {
        boolean z;
        synchronized (this) {
            z = this.f6668c.remove(str) != null;
        }
        return z;
    }
}
