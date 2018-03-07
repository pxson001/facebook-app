package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.GeofencingRequest;

class zzf$1 extends zzf$zza {
    final /* synthetic */ GeofencingRequest f6394b;
    final /* synthetic */ PendingIntent f6395c;
    final /* synthetic */ zzf f6396d;

    zzf$1(zzf com_google_android_gms_location_internal_zzf, GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        this.f6396d = com_google_android_gms_location_internal_zzf;
        this.f6394b = geofencingRequest;
        this.f6395c = pendingIntent;
        super(googleApiClient);
    }

    protected final void m8873b(zzb com_google_android_gms_common_api_Api_zzb) {
        zzl com_google_android_gms_location_internal_zzl = (zzl) com_google_android_gms_common_api_Api_zzb;
        GeofencingRequest geofencingRequest = this.f6394b;
        PendingIntent pendingIntent = this.f6395c;
        com_google_android_gms_location_internal_zzl.o();
        zzx.a(geofencingRequest, "geofencingRequest can't be null.");
        zzx.a(pendingIntent, "PendingIntent must be specified.");
        zzx.a(this, "ResultHolder not provided.");
        ((zzi) com_google_android_gms_location_internal_zzl.q()).mo464a(geofencingRequest, pendingIntent, new zzl$zza(this));
    }
}
