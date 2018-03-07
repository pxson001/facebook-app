package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzz.zza;

class zzz$zza$3 implements Runnable {
    final /* synthetic */ zzl f7133a;
    final /* synthetic */ zza f7134b;

    zzz$zza$3(zza com_google_android_gms_measurement_internal_zzz_zza, zzl com_google_android_gms_measurement_internal_zzl) {
        this.f7134b = com_google_android_gms_measurement_internal_zzz_zza;
        this.f7133a = com_google_android_gms_measurement_internal_zzl;
    }

    public void run() {
        if (!this.f7134b.a.b()) {
            this.f7134b.a.l().l.a("Connected to remote service");
            zzz.a(this.f7134b.a, this.f7133a);
        }
    }
}
