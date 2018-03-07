package com.facebook.adinterfaces;

import com.facebook.adinterfaces.ui.AdInterfacesNativePreviewViewController;
import com.facebook.adinterfaces.ui.AdInterfacesNativePreviewViewControllerProvider;
import com.facebook.adinterfaces.ui.preview.AdInterfacesBoostEventPreviewFetcher;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: account */
public class C2476xfbb65f57 extends AbstractProvider<AdInterfacesNativePreviewViewController> {
    public static AdInterfacesNativePreviewViewController m22443a(InjectorLike injectorLike) {
        return AdInterfacesModule.m22441a(AdInterfacesBoostEventPreviewFetcher.m25160b(injectorLike), (AdInterfacesNativePreviewViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AdInterfacesNativePreviewViewControllerProvider.class));
    }

    public Object get() {
        return AdInterfacesModule.m22441a(AdInterfacesBoostEventPreviewFetcher.m25160b(this), (AdInterfacesNativePreviewViewControllerProvider) getOnDemandAssistedProviderForStaticDi(AdInterfacesNativePreviewViewControllerProvider.class));
    }
}
