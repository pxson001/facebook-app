package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.location.places.internal.zzd;
import com.google.android.gms.location.places.internal.zze;
import com.google.android.gms.location.places.internal.zze.zza;
import com.google.android.gms.location.places.internal.zzj;
import com.google.android.gms.location.places.internal.zzk;

public class Places {
    public static final zzc<zze> f6467a = new zzc();
    public static final zzc<zzk> f6468b = new zzc();
    public static final Api<PlacesOptions> f6469c = new Api("Places.GEO_DATA_API", new zza(null), f6467a);
    public static final Api<PlacesOptions> f6470d = new Api("Places.PLACE_DETECTION_API", new zzk.zza(null), f6468b);
    public static final GeoDataApi f6471e = new zzd();
    public static final PlaceDetectionApi f6472f = new zzj();

    private Places() {
    }
}
