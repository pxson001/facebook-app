package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

class zzz$5 implements Runnable {
    final /* synthetic */ UserAttributeParcel f7125a;
    final /* synthetic */ zzz f7126b;

    zzz$5(zzz com_google_android_gms_measurement_internal_zzz, UserAttributeParcel userAttributeParcel) {
        this.f7126b = com_google_android_gms_measurement_internal_zzz;
        this.f7125a = userAttributeParcel;
    }

    public void run() {
        zzl com_google_android_gms_measurement_internal_zzl = this.f7126b.b;
        if (com_google_android_gms_measurement_internal_zzl == null) {
            this.f7126b.l().b().a("Discarding data. Failed to set user attribute");
            return;
        }
        try {
            com_google_android_gms_measurement_internal_zzl.mo851a(this.f7125a, this.f7126b.f().a(this.f7126b.l().u()));
            zzz.p(this.f7126b);
        } catch (RemoteException e) {
            this.f7126b.l().b().a("Failed to send attribute to AppMeasurementService", e);
        }
    }
}
