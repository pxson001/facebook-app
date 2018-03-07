package com.facebook.adinterfaces;

import com.facebook.adinterfaces.component.BoostPostFooterComponent;
import com.facebook.adinterfaces.ui.AdInterfacesBoostPostFooterViewControllerProvider;
import com.facebook.adinterfaces.util.BoostPostBoostComponentMutationHelper;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890 */
public class C2488xa95e6eb5 extends AbstractProvider<BoostPostFooterComponent> {
    public static BoostPostFooterComponent m22519a(InjectorLike injectorLike) {
        return AdInterfacesModule.m22436a((AdInterfacesBoostPostFooterViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AdInterfacesBoostPostFooterViewControllerProvider.class), BoostPostBoostComponentMutationHelper.m25254a(injectorLike));
    }

    public Object get() {
        return AdInterfacesModule.m22436a((AdInterfacesBoostPostFooterViewControllerProvider) getOnDemandAssistedProviderForStaticDi(AdInterfacesBoostPostFooterViewControllerProvider.class), BoostPostBoostComponentMutationHelper.m25254a(this));
    }
}
