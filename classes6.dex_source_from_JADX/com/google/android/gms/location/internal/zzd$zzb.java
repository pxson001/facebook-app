package com.google.android.gms.location.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlx.zzb;
import com.google.android.gms.location.internal.zzg.zza;

class zzd$zzb extends zza {
    private final zzb<Status> f6393a;

    public zzd$zzb(zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) {
        this.f6393a = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status;
    }

    public final void mo452a(FusedLocationProviderResult fusedLocationProviderResult) {
        this.f6393a.a(fusedLocationProviderResult.cp_());
    }
}
