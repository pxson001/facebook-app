package com.google.android.gms.location.internal;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.LocationServices$zza;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;

public class zzq$1 extends LocationServices$zza<LocationSettingsResult> {
    final /* synthetic */ LocationSettingsRequest f6406b;
    final /* synthetic */ String f6407c;
    final /* synthetic */ zzq f6408d;

    public zzq$1(zzq com_google_android_gms_location_internal_zzq, GoogleApiClient googleApiClient, LocationSettingsRequest locationSettingsRequest, String str) {
        this.f6408d = com_google_android_gms_location_internal_zzq;
        this.f6406b = locationSettingsRequest;
        this.f6407c = str;
        super(googleApiClient);
    }

    protected final void m8954b(zzb com_google_android_gms_common_api_Api_zzb) {
        zzl com_google_android_gms_location_internal_zzl = (zzl) com_google_android_gms_common_api_Api_zzb;
        LocationSettingsRequest locationSettingsRequest = this.f6406b;
        String str = this.f6407c;
        boolean z = true;
        com_google_android_gms_location_internal_zzl.o();
        zzx.b(locationSettingsRequest != null, "locationSettingsRequest can't be null nor empty.");
        if (this == null) {
            z = false;
        }
        zzx.b(z, "listener can't be null.");
        ((zzi) com_google_android_gms_location_internal_zzl.q()).mo469a(locationSettingsRequest, new zzl$zzc(this), str);
    }

    public final Result m8955c(Status status) {
        return new LocationSettingsResult(status);
    }
}
