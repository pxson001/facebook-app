package com.google.android.gms.measurement.internal;

public abstract class zzw extends zzv {
    private boolean f160a;
    private boolean f161b;
    public boolean f162c;

    zzw(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
        zzt com_google_android_gms_measurement_internal_zzt2 = this.f54g;
        com_google_android_gms_measurement_internal_zzt2.f48v++;
    }

    protected abstract void mo24a();

    final boolean m302v() {
        return this.f160a && !this.f161b;
    }

    public final void m303x() {
        if (!m302v()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void m304y() {
        if (this.f160a) {
            throw new IllegalStateException("Can't initialize twice");
        }
        mo24a();
        zzt com_google_android_gms_measurement_internal_zzt = this.f54g;
        com_google_android_gms_measurement_internal_zzt.f49w++;
        this.f160a = true;
    }
}
