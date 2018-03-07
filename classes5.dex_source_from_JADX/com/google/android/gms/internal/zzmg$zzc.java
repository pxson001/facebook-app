package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

public class zzmg$zzc extends zzmk {
    private WeakReference<zzmg> f6884b;

    public zzmg$zzc(zzmg com_google_android_gms_internal_zzmg) {
        this.f6884b = new WeakReference(com_google_android_gms_internal_zzmg);
    }

    public final void mo841a() {
        zzmg com_google_android_gms_internal_zzmg = (zzmg) this.f6884b.get();
        if (com_google_android_gms_internal_zzmg != null) {
            zzmg.p(com_google_android_gms_internal_zzmg);
        }
    }
}
