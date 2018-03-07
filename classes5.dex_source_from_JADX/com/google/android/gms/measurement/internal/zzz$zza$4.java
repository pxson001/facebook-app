package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import com.google.android.gms.measurement.AppMeasurementService;
import com.google.android.gms.measurement.internal.zzz.zza;

class zzz$zza$4 implements Runnable {
    final /* synthetic */ zza f7135a;

    zzz$zza$4(zza com_google_android_gms_measurement_internal_zzz_zza) {
        this.f7135a = com_google_android_gms_measurement_internal_zzz_zza;
    }

    public void run() {
        zzz.a(this.f7135a.a, new ComponentName(this.f7135a.a.i(), AppMeasurementService.class));
    }
}
