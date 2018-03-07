package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.PlacesOptions.Builder;
import java.util.Locale;

public class zzk extends zzj<zzf> {
    private final PlacesParams f6574d;
    private final Locale f6575e = Locale.getDefault();

    public class zza extends com.google.android.gms.common.api.Api.zza<zzk, PlacesOptions> {
        private final String f6573a;

        public zza(String str) {
            this.f6573a = str;
        }

        private zzk m9095a(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, PlacesOptions placesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzk(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener, this.f6573a != null ? this.f6573a : context.getPackageName(), placesOptions == null ? new Builder().m8971a() : placesOptions);
        }

        public final /* synthetic */ zzb m9096a(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m9095a(context, looper, com_google_android_gms_common_internal_zzf, (PlacesOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public zzk(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, PlacesOptions placesOptions) {
        super(context, looper, 67, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        String str2 = null;
        if (com_google_android_gms_common_internal_zzf.a != null) {
            str2 = com_google_android_gms_common_internal_zzf.a().name;
        }
        this.f6574d = new PlacesParams(str, this.f6575e, str2, placesOptions.f6475a, placesOptions.f6476b);
    }

    protected final IInterface m9097a(IBinder iBinder) {
        zzf com_google_android_gms_location_places_internal_zzf;
        if (iBinder == null) {
            com_google_android_gms_location_places_internal_zzf = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
            com_google_android_gms_location_places_internal_zzf = (queryLocalInterface == null || !(queryLocalInterface instanceof zzf)) ? new zzf$zza$zza(iBinder) : (zzf) queryLocalInterface;
        }
        return com_google_android_gms_location_places_internal_zzf;
    }

    protected final String m9098g() {
        return "com.google.android.gms.location.places.PlaceDetectionApi";
    }

    protected final String m9099h() {
        return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
    }
}
