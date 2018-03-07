package com.facebook.katana.activity.nearby;

import com.facebook.common.util.TriState;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.maps.GoogleMapsV1Util;
import javax.inject.Provider;

@InjectorModule
/* compiled from: {fundraiser_campaign_id} */
public class Fb4aNearbyPlacesModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsNearbyPlacesEnabled
    static Boolean m31a(GoogleMapsV1Util googleMapsV1Util, Provider<TriState> provider) {
        if (provider.get() == TriState.YES) {
            return Boolean.valueOf(true);
        }
        return Boolean.valueOf(googleMapsV1Util.a());
    }
}
