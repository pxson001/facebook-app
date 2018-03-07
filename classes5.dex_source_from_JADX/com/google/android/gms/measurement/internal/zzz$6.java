package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

class zzz$6 implements Runnable {
    final /* synthetic */ zzz f7127a;

    zzz$6(zzz com_google_android_gms_measurement_internal_zzz) {
        this.f7127a = com_google_android_gms_measurement_internal_zzz;
    }

    public void run() {
        zzl com_google_android_gms_measurement_internal_zzl = this.f7127a.b;
        if (com_google_android_gms_measurement_internal_zzl == null) {
            this.f7127a.l().b().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            com_google_android_gms_measurement_internal_zzl.mo848a(this.f7127a.f().a(this.f7127a.l().u()));
            zzz.p(this.f7127a);
        } catch (RemoteException e) {
            this.f7127a.l().b().a("Failed to send app launch to AppMeasurementService", e);
        }
    }
}
