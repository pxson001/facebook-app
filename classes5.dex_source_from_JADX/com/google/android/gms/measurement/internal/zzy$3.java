package com.google.android.gms.measurement.internal;

public class zzy$3 implements Runnable {
    final /* synthetic */ String f7116a;
    final /* synthetic */ String f7117b;
    final /* synthetic */ Object f7118c;
    final /* synthetic */ long f7119d;
    final /* synthetic */ zzy f7120e;

    public zzy$3(zzy com_google_android_gms_measurement_internal_zzy, String str, String str2, Object obj, long j) {
        this.f7120e = com_google_android_gms_measurement_internal_zzy;
        this.f7116a = str;
        this.f7117b = str2;
        this.f7118c = obj;
        this.f7119d = j;
    }

    public void run() {
        zzy.a(this.f7120e, this.f7116a, this.f7117b, this.f7118c, this.f7119d);
    }
}
