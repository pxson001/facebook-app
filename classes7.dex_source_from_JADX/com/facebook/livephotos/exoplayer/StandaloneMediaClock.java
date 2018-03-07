package com.facebook.livephotos.exoplayer;

import android.os.SystemClock;

/* compiled from: pages_admin_panel */
public final class StandaloneMediaClock implements MediaClock {
    public boolean f6875a;
    public long f6876b;
    public long f6877c;

    StandaloneMediaClock() {
    }

    public final void m8770c() {
        if (this.f6875a) {
            this.f6876b = m8767b(this.f6877c);
            this.f6875a = false;
        }
    }

    public final void m8769a(long j) {
        this.f6876b = j;
        this.f6877c = m8767b(j);
    }

    public final long mo382a() {
        return this.f6875a ? m8767b(this.f6877c) : this.f6876b;
    }

    public static long m8767b(long j) {
        return (SystemClock.elapsedRealtime() * 1000) - j;
    }
}
