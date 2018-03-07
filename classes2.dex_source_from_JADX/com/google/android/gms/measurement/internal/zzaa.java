package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;

class zzaa {
    private final zznl f231a;
    private long f232b;

    public zzaa(zznl com_google_android_gms_internal_zznl) {
        zzx.m104a((Object) com_google_android_gms_internal_zznl);
        this.f231a = com_google_android_gms_internal_zznl;
    }

    public final void m450a() {
        this.f232b = this.f231a.mo12b();
    }

    public final boolean m451a(long j) {
        return this.f232b == 0 || this.f231a.mo12b() - this.f232b >= j;
    }

    public final void m452b() {
        this.f232b = 0;
    }
}
