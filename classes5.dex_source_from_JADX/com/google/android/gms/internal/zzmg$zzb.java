package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.internal.zzmg.zzd;
import java.lang.ref.WeakReference;

class zzmg$zzb implements DeathRecipient, zzd {
    private final WeakReference<zzmg$zze<?>> f6880a;
    private final WeakReference<zza> f6881b;
    private final WeakReference<IBinder> f6882c;

    public zzmg$zzb(zzmg$zze com_google_android_gms_internal_zzmg_zze, zza com_google_android_gms_common_api_zza, IBinder iBinder) {
        this.f6881b = new WeakReference(com_google_android_gms_common_api_zza);
        this.f6880a = new WeakReference(com_google_android_gms_internal_zzmg_zze);
        this.f6882c = new WeakReference(iBinder);
    }

    private void m12841a() {
        zzmg$zze com_google_android_gms_internal_zzmg_zze = (zzmg$zze) this.f6880a.get();
        zza com_google_android_gms_common_api_zza = (zza) this.f6881b.get();
        if (!(com_google_android_gms_common_api_zza == null || com_google_android_gms_internal_zzmg_zze == null)) {
            com_google_android_gms_internal_zzmg_zze.m12764b().intValue();
            com_google_android_gms_common_api_zza.m12144a();
        }
        IBinder iBinder = (IBinder) this.f6882c.get();
        if (this.f6882c != null) {
            iBinder.unlinkToDeath(this, 0);
        }
    }

    public final void m12842a(zzmg$zze<?> com_google_android_gms_internal_zzmg_zze_) {
        m12841a();
    }

    public void binderDied() {
        m12841a();
    }
}
