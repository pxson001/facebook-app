package com.facebook.adinterfaces;

import com.facebook.adinterfaces.component.PromotionDetailsComponent;
import com.facebook.adinterfaces.ui.BoostPostPromotionDetailsViewControllerProvider;
import com.facebook.adinterfaces.util.BoostPostMutationHelper;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: a7f79724fd013ca9032de6d3f2f1adcd */
public class PromotionDetailsComponentMethodAutoProvider extends AbstractProvider<PromotionDetailsComponent> {
    public static PromotionDetailsComponent m22584a(InjectorLike injectorLike) {
        return AdInterfacesModule.m22440a((BoostPostPromotionDetailsViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BoostPostPromotionDetailsViewControllerProvider.class), BoostPostMutationHelper.m25269a(injectorLike));
    }

    public Object get() {
        return AdInterfacesModule.m22440a((BoostPostPromotionDetailsViewControllerProvider) getOnDemandAssistedProviderForStaticDi(BoostPostPromotionDetailsViewControllerProvider.class), BoostPostMutationHelper.m25269a((InjectorLike) this));
    }
}
