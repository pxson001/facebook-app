package com.google.android.gms.location.internal;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

class zzd$1 extends zzd$zza {
    final /* synthetic */ LocationRequest f6387b;
    final /* synthetic */ LocationListener f6388c;
    final /* synthetic */ zzd f6389d;

    zzd$1(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
        this.f6389d = com_google_android_gms_location_internal_zzd;
        this.f6387b = locationRequest;
        this.f6388c = locationListener;
        super(googleApiClient);
    }

    protected final void m8867b(zzb com_google_android_gms_common_api_Api_zzb) {
        ((zzl) com_google_android_gms_common_api_Api_zzb).a(this.f6387b, this.f6388c, null, new zzd$zzb(this));
    }
}
