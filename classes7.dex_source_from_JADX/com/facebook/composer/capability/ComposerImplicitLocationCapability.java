package com.facebook.composer.capability;

import com.facebook.inject.Lazy;
import com.facebook.places.features.PlacesFeatures;
import javax.inject.Inject;

/* compiled from: createAllViewManagers */
public class ComposerImplicitLocationCapability {
    public final Lazy<PlacesFeatures> f16691a;

    @Inject
    public ComposerImplicitLocationCapability(Lazy<PlacesFeatures> lazy) {
        this.f16691a = lazy;
    }
}
