package com.facebook.adinterfaces.ui;

import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: V2_ANNOUNCEMENT */
public class AdInterfacesPageLikeTargetingViewController extends AdInterfacesTargetingViewController<AdInterfacesBoostedComponentDataModel> {
    public static AdInterfacesPageLikeTargetingViewController m24791d(InjectorLike injectorLike) {
        return new AdInterfacesPageLikeTargetingViewController(AdInterfacesAudienceOptionsViewController.m24419b(injectorLike), AdInterfacesDataHelper.m22789a(injectorLike));
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        super.mo983a((AdInterfacesBoostedComponentDataModel) baseAdInterfacesData);
    }

    @Inject
    public AdInterfacesPageLikeTargetingViewController(AdInterfacesAudienceOptionsViewController adInterfacesAudienceOptionsViewController, AdInterfacesDataHelper adInterfacesDataHelper) {
        super(adInterfacesAudienceOptionsViewController, adInterfacesDataHelper);
    }

    public final void mo992a(AdInterfacesTargetingView adInterfacesTargetingView, AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo992a(adInterfacesTargetingView, adInterfacesCardLayout);
        adInterfacesTargetingView.setLocationSelectorDividerVisibility(8);
        m24452d();
    }
}
