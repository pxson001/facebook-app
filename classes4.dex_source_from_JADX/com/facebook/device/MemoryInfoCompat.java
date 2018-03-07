package com.facebook.device;

import android.app.ActivityManager.MemoryInfo;

/* compiled from: handleLogin */
public class MemoryInfoCompat {
    private final MemoryInfo f10907a;
    public final long f10908b;

    MemoryInfoCompat(MemoryInfo memoryInfo, long j) {
        this.f10907a = memoryInfo;
        this.f10908b = j;
    }

    public final long m11338a() {
        return this.f10907a.availMem;
    }

    public final long m11339b() {
        return this.f10908b;
    }

    public final long m11340c() {
        return this.f10907a.threshold;
    }

    public final boolean m11341d() {
        return this.f10907a.lowMemory;
    }
}
