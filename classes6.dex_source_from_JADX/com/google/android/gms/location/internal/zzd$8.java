package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;

class zzd$8 extends zzd$zza {
    final /* synthetic */ LocationRequest f6390b;
    final /* synthetic */ PendingIntent f6391c;
    final /* synthetic */ zzd f6392d;

    zzd$8(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
        this.f6392d = com_google_android_gms_location_internal_zzd;
        this.f6390b = locationRequest;
        this.f6391c = pendingIntent;
        super(googleApiClient);
    }

    protected final void m8868b(zzb com_google_android_gms_common_api_Api_zzb) {
        zzl com_google_android_gms_location_internal_zzl = (zzl) com_google_android_gms_common_api_Api_zzb;
        zzg com_google_android_gms_location_internal_zzd_zzb = new zzd$zzb(this);
        LocationRequest locationRequest = this.f6390b;
        PendingIntent pendingIntent = this.f6391c;
        zzk com_google_android_gms_location_internal_zzk = com_google_android_gms_location_internal_zzl.e;
        com_google_android_gms_location_internal_zzk.a.a();
        ((zzi) com_google_android_gms_location_internal_zzk.a.b()).mo472a(new LocationRequestUpdateData(1, 1, LocationRequestInternal.m8858a(locationRequest), null, pendingIntent, null, com_google_android_gms_location_internal_zzd_zzb != null ? com_google_android_gms_location_internal_zzd_zzb.asBinder() : null));
    }
}
