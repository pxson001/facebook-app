package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.PlacesOptions.Builder;
import java.util.Locale;

public class zze extends zzj<zzg> {
    public final PlacesParams f6567d;
    private final Locale f6568e = Locale.getDefault();

    public class zza extends com.google.android.gms.common.api.Api.zza<zze, PlacesOptions> {
        private final String f6566a;

        public zza(String str) {
            this.f6566a = str;
        }

        private zze m9024a(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, PlacesOptions placesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zze(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener, this.f6566a != null ? this.f6566a : context.getPackageName(), placesOptions == null ? new Builder().m8971a() : placesOptions);
        }
    }

    public zze(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, PlacesOptions placesOptions) {
        super(context, looper, 65, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        String str2 = null;
        if (com_google_android_gms_common_internal_zzf.a != null) {
            str2 = com_google_android_gms_common_internal_zzf.a().name;
        }
        this.f6567d = new PlacesParams(str, this.f6568e, str2, placesOptions.f6475a, placesOptions.f6476b);
    }

    protected final IInterface m9026a(IBinder iBinder) {
        zzg com_google_android_gms_location_places_internal_zzg;
        if (iBinder == null) {
            com_google_android_gms_location_places_internal_zzg = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            com_google_android_gms_location_places_internal_zzg = (queryLocalInterface == null || !(queryLocalInterface instanceof zzg)) ? new zzg$zza$zza(iBinder) : (zzg) queryLocalInterface;
        }
        return com_google_android_gms_location_places_internal_zzg;
    }

    protected final String m9027g() {
        return "com.google.android.gms.location.places.GeoDataApi";
    }

    protected final String m9028h() {
        return "com.google.android.gms.location.places.internal.IGooglePlacesService";
    }
}
