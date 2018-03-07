package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import com.google.android.gms.measurement.internal.zzz.zza;

class zzz$zza$2 implements Runnable {
    final /* synthetic */ ComponentName f7131a;
    final /* synthetic */ zza f7132b;

    zzz$zza$2(zza com_google_android_gms_measurement_internal_zzz_zza, ComponentName componentName) {
        this.f7132b = com_google_android_gms_measurement_internal_zzz_zza;
        this.f7131a = componentName;
    }

    public void run() {
        zzz.a(this.f7132b.a, this.f7131a);
    }
}
