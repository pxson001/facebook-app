package com.facebook.maps;

import android.os.Bundle;
import com.facebook.config.application.FbAppType;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: websiteUri */
public class MapFragmentFactory {
    private final String f255a;
    public final GoogleMapsV1Util f256b;

    public static MapFragmentFactory m232b(InjectorLike injectorLike) {
        return new MapFragmentFactory(MapsModule.m280a((FbAppType) injectorLike.getInstance(FbAppType.class)), GoogleMapsV1Util.m213b(injectorLike));
    }

    @Inject
    public MapFragmentFactory(String str, GoogleMapsV1Util googleMapsV1Util) {
        this.f255a = (String) Preconditions.checkNotNull(str, "must provide a google map api key");
        this.f256b = googleMapsV1Util;
    }

    public final MapFragment m233a(boolean z) {
        if (this.f256b.m214a()) {
            String str = this.f255a;
            Bundle bundle = new Bundle();
            bundle.putString("apiKey", str);
            bundle.putBoolean("overlayShadowDrawingEnabled", z);
            MapFragment googleMapFragment = new GoogleMapFragment();
            googleMapFragment.g(bundle);
            return googleMapFragment;
        }
        throw new RuntimeException("map library not present");
    }
}
