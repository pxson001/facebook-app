package com.facebook.adinterfaces.ui;

import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: VIBRATION */
public class AdInterfacesBoostEventTargetingViewConroller extends AdInterfacesTargetingViewController<AdInterfacesBoostPostDataModel> {
    public static AdInterfacesBoostEventTargetingViewConroller m24471d(InjectorLike injectorLike) {
        return new AdInterfacesBoostEventTargetingViewConroller(AdInterfacesAudienceOptionsViewController.m24419b(injectorLike), AdInterfacesDataHelper.m22789a(injectorLike));
    }

    @Inject
    public AdInterfacesBoostEventTargetingViewConroller(AdInterfacesAudienceOptionsViewController adInterfacesAudienceOptionsViewController, AdInterfacesDataHelper adInterfacesDataHelper) {
        super(adInterfacesAudienceOptionsViewController, adInterfacesDataHelper);
    }

    public final void mo992a(AdInterfacesTargetingView adInterfacesTargetingView, AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo992a(adInterfacesTargetingView, adInterfacesCardLayout);
        m24455e(false);
    }

    protected final void mo993b(boolean z) {
        super.mo993b(z);
        ((AdInterfacesTargetingView) this.f22581e).setLocationSelectorDividerVisibility(8);
    }
}
