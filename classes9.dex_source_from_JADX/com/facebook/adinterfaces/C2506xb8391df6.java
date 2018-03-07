package com.facebook.adinterfaces;

import com.facebook.adinterfaces.component.PromotionDetailsComponent;
import com.facebook.adinterfaces.ui.BoostPostPromotionDetailsViewControllerProvider;
import com.facebook.adinterfaces.util.BoostPostBoostComponentMutationHelper;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: a39dd9db1eebdcf38bfb5c8087547423 */
public class C2506xb8391df6 extends AbstractProvider<PromotionDetailsComponent> {
    public static PromotionDetailsComponent m22586a(InjectorLike injectorLike) {
        return AdInterfacesModule.m22439a((BoostPostPromotionDetailsViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BoostPostPromotionDetailsViewControllerProvider.class), BoostPostBoostComponentMutationHelper.m25254a(injectorLike));
    }

    public Object get() {
        return AdInterfacesModule.m22439a((BoostPostPromotionDetailsViewControllerProvider) getOnDemandAssistedProviderForStaticDi(BoostPostPromotionDetailsViewControllerProvider.class), BoostPostBoostComponentMutationHelper.m25254a(this));
    }
}
