package com.facebook.adinterfaces;

import com.facebook.adinterfaces.ui.AdInterfacesNativePreviewViewController;
import com.facebook.adinterfaces.ui.AdInterfacesNativePreviewViewControllerProvider;
import com.facebook.adinterfaces.ui.preview.AdInterfacesBoostedComponentPreviewFetcher;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: accept_payload */
public class C2477x748f41fb extends AbstractProvider<AdInterfacesNativePreviewViewController> {
    public static AdInterfacesNativePreviewViewController m22445b(InjectorLike injectorLike) {
        return AdInterfacesModule.m22442a(AdInterfacesBoostedComponentPreviewFetcher.m25162b(injectorLike), (AdInterfacesNativePreviewViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AdInterfacesNativePreviewViewControllerProvider.class));
    }

    public Object get() {
        return AdInterfacesModule.m22442a(AdInterfacesBoostedComponentPreviewFetcher.m25162b(this), (AdInterfacesNativePreviewViewControllerProvider) getOnDemandAssistedProviderForStaticDi(AdInterfacesNativePreviewViewControllerProvider.class));
    }

    public static AdInterfacesNativePreviewViewController m22444a(InjectorLike injectorLike) {
        return C2477x748f41fb.m22445b(injectorLike);
    }
}
