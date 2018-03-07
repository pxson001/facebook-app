package com.google.android.gms.maps.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.model.internal.zza;

public interface zzc extends IInterface {
    ICameraUpdateFactoryDelegate mo695a();

    IMapViewDelegate mo696a(zzd com_google_android_gms_dynamic_zzd, GoogleMapOptions googleMapOptions);

    IStreetViewPanoramaViewDelegate mo697a(zzd com_google_android_gms_dynamic_zzd, StreetViewPanoramaOptions streetViewPanoramaOptions);

    void mo698a(zzd com_google_android_gms_dynamic_zzd);

    void mo699a(zzd com_google_android_gms_dynamic_zzd, int i);

    IMapFragmentDelegate mo700b(zzd com_google_android_gms_dynamic_zzd);

    zza mo701b();

    IStreetViewPanoramaFragmentDelegate mo702c(zzd com_google_android_gms_dynamic_zzd);
}
