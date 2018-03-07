package com.google.android.gms.wearable.internal;

import com.google.android.gms.internal.zzlx.zzb;

public abstract class zzcd$zzb<T> extends zza {
    private zzb<T> f13391a;

    public zzcd$zzb(zzb<T> com_google_android_gms_internal_zzlx_zzb_T) {
        this.f13391a = com_google_android_gms_internal_zzlx_zzb_T;
    }

    public final void m13578a(T t) {
        zzb com_google_android_gms_internal_zzlx_zzb = this.f13391a;
        if (com_google_android_gms_internal_zzlx_zzb != null) {
            com_google_android_gms_internal_zzlx_zzb.a(t);
            this.f13391a = null;
        }
    }
}
