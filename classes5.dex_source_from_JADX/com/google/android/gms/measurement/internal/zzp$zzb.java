package com.google.android.gms.measurement.internal;

class zzp$zzb implements Runnable {
    private final zzp$zza f7086a;
    private final int f7087b;
    private final Throwable f7088c;
    private final byte[] f7089d;

    public zzp$zzb(zzp$zza com_google_android_gms_measurement_internal_zzp_zza, int i, Throwable th, byte[] bArr) {
        this.f7086a = com_google_android_gms_measurement_internal_zzp_zza;
        this.f7087b = i;
        this.f7088c = th;
        this.f7089d = bArr;
    }

    public void run() {
        this.f7086a.mo853a(this.f7087b, this.f7088c, this.f7089d);
    }
}
