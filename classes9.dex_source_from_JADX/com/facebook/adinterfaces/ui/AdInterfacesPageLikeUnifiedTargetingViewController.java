package com.facebook.adinterfaces.ui;

import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: V2_ACTIVE_NOW_EMPTY_ITEM */
public class AdInterfacesPageLikeUnifiedTargetingViewController extends AdInterfacesUnifiedTargetingViewController<AdInterfacesBoostedComponentDataModel> {
    public static AdInterfacesPageLikeUnifiedTargetingViewController m24810d(InjectorLike injectorLike) {
        return new AdInterfacesPageLikeUnifiedTargetingViewController(AdInterfacesUnifiedAudienceOptionsViewController.m24949b(injectorLike), AdInterfacesDataHelper.m22789a(injectorLike));
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        super.mo983a((AdInterfacesBoostedComponentDataModel) baseAdInterfacesData);
    }

    @Inject
    public AdInterfacesPageLikeUnifiedTargetingViewController(AdInterfacesUnifiedAudienceOptionsViewController adInterfacesUnifiedAudienceOptionsViewController, AdInterfacesDataHelper adInterfacesDataHelper) {
        super(adInterfacesUnifiedAudienceOptionsViewController, adInterfacesDataHelper);
    }

    public final void mo1013a(AdInterfacesUnifiedTargetingView adInterfacesUnifiedTargetingView, AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo1013a(adInterfacesUnifiedTargetingView, adInterfacesCardLayout);
        adInterfacesUnifiedTargetingView.setLocationSelectorDividerVisibility(8);
        m24452d();
    }

    public static AdInterfacesPageLikeUnifiedTargetingViewController m24809b(InjectorLike injectorLike) {
        return m24810d(injectorLike);
    }
}
