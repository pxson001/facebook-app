package com.google.android.gms.measurement.internal;

public class zzy$4 implements Runnable {
    final /* synthetic */ String f7121a;
    final /* synthetic */ String f7122b;
    final /* synthetic */ long f7123c;
    final /* synthetic */ zzy f7124d;

    public zzy$4(zzy com_google_android_gms_measurement_internal_zzy, String str, String str2, long j) {
        this.f7124d = com_google_android_gms_measurement_internal_zzy;
        this.f7121a = str;
        this.f7122b = str2;
        this.f7123c = j;
    }

    public void run() {
        zzy.a(this.f7124d, this.f7121a, this.f7122b, null, this.f7123c);
    }
}
