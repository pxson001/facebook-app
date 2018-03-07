package com.facebook.adinterfaces;

import com.facebook.adinterfaces.component.PromotionDetailsComponent;
import com.facebook.adinterfaces.ui.BoostPostPromotionDetailsViewControllerProvider;
import com.facebook.adinterfaces.util.BoostEventMutationHelper;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: a4018c8e50761838ec03138961ee7896 */
public class PromotionDetailsComponent_ForBoostEventMethodAutoProvider extends AbstractProvider<PromotionDetailsComponent> {
    public static PromotionDetailsComponent m22585a(InjectorLike injectorLike) {
        return AdInterfacesModule.m22438a((BoostPostPromotionDetailsViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BoostPostPromotionDetailsViewControllerProvider.class), BoostEventMutationHelper.m25246a(injectorLike));
    }

    public Object get() {
        return AdInterfacesModule.m22438a((BoostPostPromotionDetailsViewControllerProvider) getOnDemandAssistedProviderForStaticDi(BoostPostPromotionDetailsViewControllerProvider.class), BoostEventMutationHelper.m25246a(this));
    }
}
