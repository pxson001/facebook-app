package com.google.android.gms.internal;

abstract class zzmi$zza {
    private final zzmh f6860a;

    protected zzmi$zza(zzmh com_google_android_gms_internal_zzmh) {
        this.f6860a = com_google_android_gms_internal_zzmh;
    }

    protected abstract void mo836a();

    public final void m12811a(zzmi com_google_android_gms_internal_zzmi) {
        com_google_android_gms_internal_zzmi.i.lock();
        try {
            if (com_google_android_gms_internal_zzmi.n == this.f6860a) {
                mo836a();
                com_google_android_gms_internal_zzmi.i.unlock();
            }
        } finally {
            com_google_android_gms_internal_zzmi.i.unlock();
        }
    }
}
