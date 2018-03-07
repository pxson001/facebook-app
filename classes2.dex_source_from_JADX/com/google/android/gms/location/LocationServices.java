package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.internal.zzd;
import com.google.android.gms.location.internal.zzf;
import com.google.android.gms.location.internal.zzl;
import com.google.android.gms.location.internal.zzq;

public class LocationServices {
    public static final Api<Object> f17838a = new Api("LocationServices.API", f17843f, f17842e);
    public static final FusedLocationProviderApi f17839b = new zzd();
    public static final GeofencingApi f17840c = new zzf();
    public static final SettingsApi f17841d = new zzq();
    public static final zzc<zzl> f17842e = new zzc();
    private static final zza<zzl, Object> f17843f = new C07221();

    final class C07221 extends zza<zzl, Object> {
        C07221() {
        }

        public final zzb mo2975a(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzl(context, looper, connectionCallbacks, onConnectionFailedListener, "locationServices", com_google_android_gms_common_internal_zzf);
        }
    }

    private LocationServices() {
    }

    public static zzl m25073a(GoogleApiClient googleApiClient) {
        boolean z = true;
        zzx.m113b(googleApiClient != null, "GoogleApiClient parameter is required.");
        zzl com_google_android_gms_location_internal_zzl = (zzl) googleApiClient.mo3046a(f17842e);
        if (com_google_android_gms_location_internal_zzl == null) {
            z = false;
        }
        zzx.m109a(z, (Object) "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return com_google_android_gms_location_internal_zzl;
    }
}
