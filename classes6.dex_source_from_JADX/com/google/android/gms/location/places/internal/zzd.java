package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.location.places.zzl.zza;
import com.google.android.gms.location.places.zzl.zzc;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;

public class zzd implements GeoDataApi {
    public final PendingResult<AutocompletePredictionBuffer> mo492a(GoogleApiClient googleApiClient, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter) {
        final String str2 = str;
        final LatLngBounds latLngBounds2 = latLngBounds;
        final AutocompleteFilter autocompleteFilter2 = autocompleteFilter;
        return googleApiClient.a(new zza<zze>(this, Places.f6467a, googleApiClient) {
            final /* synthetic */ zzd f6565e;

            protected final void m9021b(zzb com_google_android_gms_common_api_Api_zzb) {
                zze com_google_android_gms_location_places_internal_zze = (zze) com_google_android_gms_common_api_Api_zzb;
                zzl com_google_android_gms_location_places_zzl = new zzl(this);
                String str = str2;
                LatLngBounds latLngBounds = latLngBounds2;
                AutocompleteFilter autocompleteFilter = autocompleteFilter2;
                zzx.a(str, "query == null");
                zzx.a(com_google_android_gms_location_places_zzl, "callback == null");
                ((zzg) com_google_android_gms_location_places_internal_zze.q()).mo515a(str, latLngBounds, autocompleteFilter == null ? new AutocompleteFilter(0, true, null) : autocompleteFilter, com_google_android_gms_location_places_internal_zze.f6567d, (zzi) com_google_android_gms_location_places_zzl);
            }
        });
    }

    public final PendingResult<PlaceBuffer> mo493a(GoogleApiClient googleApiClient, final String... strArr) {
        boolean z = strArr != null && strArr.length > 0;
        zzx.b(z);
        return googleApiClient.a(new zzc<zze>(this, Places.f6467a, googleApiClient) {
            final /* synthetic */ zzd f6561c;

            protected final void m9019b(zzb com_google_android_gms_common_api_Api_zzb) {
                zze com_google_android_gms_location_places_internal_zze = (zze) com_google_android_gms_common_api_Api_zzb;
                ((zzg) com_google_android_gms_location_places_internal_zze.q()).mo519b(Arrays.asList(strArr), com_google_android_gms_location_places_internal_zze.f6567d, new zzl(this, com_google_android_gms_location_places_internal_zze.d));
            }
        });
    }
}
