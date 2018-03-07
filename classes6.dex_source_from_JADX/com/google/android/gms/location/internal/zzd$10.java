package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;

class zzd$10 extends zzd$zza {
    final /* synthetic */ PendingIntent f6385b;
    final /* synthetic */ zzd f6386c;

    zzd$10(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        this.f6386c = com_google_android_gms_location_internal_zzd;
        this.f6385b = pendingIntent;
        super(googleApiClient);
    }

    protected final void m8866b(zzb com_google_android_gms_common_api_Api_zzb) {
        zzl com_google_android_gms_location_internal_zzl = (zzl) com_google_android_gms_common_api_Api_zzb;
        zzg com_google_android_gms_location_internal_zzd_zzb = new zzd$zzb(this);
        PendingIntent pendingIntent = this.f6385b;
        zzk com_google_android_gms_location_internal_zzk = com_google_android_gms_location_internal_zzl.e;
        com_google_android_gms_location_internal_zzk.a.a();
        ((zzi) com_google_android_gms_location_internal_zzk.a.b()).mo472a(new LocationRequestUpdateData(1, 2, null, null, pendingIntent, null, com_google_android_gms_location_internal_zzd_zzb != null ? com_google_android_gms_location_internal_zzd_zzb.asBinder() : null));
    }
}
