package com.facebook.katana.activity.nearby;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.maps.GoogleMapsV1Util;

/* compiled from: {north} */
public class Boolean_IsNearbyPlacesEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m30b(InjectorLike injectorLike) {
        return Fb4aNearbyPlacesModule.m31a(GoogleMapsV1Util.b(injectorLike), IdBasedProvider.a(injectorLike, 718));
    }

    public Object get() {
        return Fb4aNearbyPlacesModule.m31a(GoogleMapsV1Util.b(this), IdBasedProvider.a(this, 718));
    }
}
