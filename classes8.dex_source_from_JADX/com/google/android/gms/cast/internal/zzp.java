package com.google.android.gms.cast.internal;

import android.os.SystemClock;

public final class zzp {
    public static final Object f10181a = new Object();
    private static final zzl f10182f = new zzl("RequestTracker");
    private long f10183b;
    private long f10184c = -1;
    private long f10185d = 0;
    private zzo f10186e;

    public zzp(long j) {
        this.f10183b = j;
    }

    private void m11959c() {
        this.f10184c = -1;
        this.f10186e = null;
        this.f10185d = 0;
    }

    public final void m11960a() {
        synchronized (f10181a) {
            if (this.f10184c != -1) {
                m11959c();
            }
        }
    }

    public final void m11961a(long j, zzo com_google_android_gms_cast_internal_zzo) {
        synchronized (f10181a) {
            zzo com_google_android_gms_cast_internal_zzo2 = this.f10186e;
            this.f10184c = j;
            this.f10186e = com_google_android_gms_cast_internal_zzo;
            this.f10185d = SystemClock.elapsedRealtime();
        }
        if (com_google_android_gms_cast_internal_zzo2 != null) {
            com_google_android_gms_cast_internal_zzo2.mo647a();
        }
    }

    public final boolean m11962a(long j) {
        boolean z;
        synchronized (f10181a) {
            z = this.f10184c != -1 && this.f10184c == j;
        }
        return z;
    }

    public final boolean m11963a(long j, int i) {
        return m11964a(j, i, null);
    }

    public final boolean m11964a(long j, int i, Object obj) {
        boolean z = true;
        zzo com_google_android_gms_cast_internal_zzo = null;
        synchronized (f10181a) {
            if (this.f10184c == -1 || this.f10184c != j) {
                z = false;
            } else {
                f10182f.m11956b("request %d completed", Long.valueOf(this.f10184c));
                com_google_android_gms_cast_internal_zzo = this.f10186e;
                m11959c();
            }
        }
        if (com_google_android_gms_cast_internal_zzo != null) {
            com_google_android_gms_cast_internal_zzo.mo648a(i, obj);
        }
        return z;
    }

    public final boolean m11965b() {
        boolean z;
        synchronized (f10181a) {
            z = this.f10184c != -1;
        }
        return z;
    }

    public final boolean m11966b(long j, int i) {
        zzo com_google_android_gms_cast_internal_zzo;
        boolean z = true;
        synchronized (f10181a) {
            if (this.f10184c == -1 || j - this.f10185d < this.f10183b) {
                z = false;
                com_google_android_gms_cast_internal_zzo = null;
            } else {
                f10182f.m11956b("request %d timed out", Long.valueOf(this.f10184c));
                com_google_android_gms_cast_internal_zzo = this.f10186e;
                m11959c();
            }
        }
        if (com_google_android_gms_cast_internal_zzo != null) {
            com_google_android_gms_cast_internal_zzo.mo648a(i, null);
        }
        return z;
    }
}
