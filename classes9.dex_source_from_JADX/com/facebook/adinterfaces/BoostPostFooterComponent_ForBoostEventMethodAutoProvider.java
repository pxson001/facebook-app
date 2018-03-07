package com.facebook.adinterfaces;

import com.facebook.adinterfaces.component.BoostPostFooterComponent;
import com.facebook.adinterfaces.ui.AdInterfacesBoostPostFooterViewControllerProvider;
import com.facebook.adinterfaces.util.BoostEventMutationHelper;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: abcdefghijkmnopqrstxyz */
public class BoostPostFooterComponent_ForBoostEventMethodAutoProvider extends AbstractProvider<BoostPostFooterComponent> {
    public static BoostPostFooterComponent m22518a(InjectorLike injectorLike) {
        return AdInterfacesModule.m22435a((AdInterfacesBoostPostFooterViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AdInterfacesBoostPostFooterViewControllerProvider.class), BoostEventMutationHelper.m25246a(injectorLike));
    }

    public Object get() {
        return AdInterfacesModule.m22435a((AdInterfacesBoostPostFooterViewControllerProvider) getOnDemandAssistedProviderForStaticDi(AdInterfacesBoostPostFooterViewControllerProvider.class), BoostEventMutationHelper.m25246a(this));
    }
}
