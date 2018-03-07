package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzz.zza;

class zzz$zza$1 implements Runnable {
    final /* synthetic */ zzl f7129a;
    final /* synthetic */ zza f7130b;

    zzz$zza$1(zza com_google_android_gms_measurement_internal_zzz_zza, zzl com_google_android_gms_measurement_internal_zzl) {
        this.f7130b = com_google_android_gms_measurement_internal_zzz_zza;
        this.f7129a = com_google_android_gms_measurement_internal_zzl;
    }

    public void run() {
        if (!this.f7130b.a.b()) {
            this.f7130b.a.l().l.a("Connected to service");
            zzz.a(this.f7130b.a, this.f7129a);
        }
    }
}
