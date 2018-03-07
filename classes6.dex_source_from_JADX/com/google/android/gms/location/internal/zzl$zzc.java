package com.google.android.gms.location.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx.zzb;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.internal.zzj.zza;

public final class zzl$zzc extends zza {
    private zzb<LocationSettingsResult> f6405a;

    public zzl$zzc(zzb<LocationSettingsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_location_LocationSettingsResult) {
        zzx.b(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_location_LocationSettingsResult != null, "listener can't be null.");
        this.f6405a = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_location_LocationSettingsResult;
    }

    public final void mo484a(LocationSettingsResult locationSettingsResult) {
        this.f6405a.a(locationSettingsResult);
        this.f6405a = null;
    }
}
