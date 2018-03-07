package com.facebook.adinterfaces;

import com.facebook.adinterfaces.component.BoostPostFooterComponent;
import com.facebook.adinterfaces.ui.AdInterfacesBoostPostFooterViewControllerProvider;
import com.facebook.adinterfaces.util.BoostPostMutationHelper;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789 */
public class BoostPostFooterComponentMethodAutoProvider extends AbstractProvider<BoostPostFooterComponent> {
    public static BoostPostFooterComponent m22517a(InjectorLike injectorLike) {
        return AdInterfacesModule.m22437a((AdInterfacesBoostPostFooterViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AdInterfacesBoostPostFooterViewControllerProvider.class), BoostPostMutationHelper.m25269a(injectorLike));
    }

    public Object get() {
        return AdInterfacesModule.m22437a((AdInterfacesBoostPostFooterViewControllerProvider) getOnDemandAssistedProviderForStaticDi(AdInterfacesBoostPostFooterViewControllerProvider.class), BoostPostMutationHelper.m25269a((InjectorLike) this));
    }
}
