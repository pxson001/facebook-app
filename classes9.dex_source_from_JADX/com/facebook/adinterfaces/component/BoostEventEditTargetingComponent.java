package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.ui.AdInterfacesBoostEventTargetingViewConroller;
import com.facebook.adinterfaces.ui.AdInterfacesTargetingView;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import javax.inject.Inject;

/* compiled from: _input_has_error */
public class BoostEventEditTargetingComponent extends TargetingComponent<AdInterfacesBoostPostDataModel> {
    private AdInterfacesBoostEventTargetingViewConroller f21623a;

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        baseAdInterfacesData = (AdInterfacesBoostPostDataModel) baseAdInterfacesData;
        if (!AdInterfacesDataHelper.m22811g(baseAdInterfacesData)) {
            return false;
        }
        if (baseAdInterfacesData.f21748d == AdInterfacesStatus.ACTIVE || baseAdInterfacesData.f21748d == AdInterfacesStatus.EXTENDABLE || baseAdInterfacesData.f21748d == AdInterfacesStatus.PENDING || baseAdInterfacesData.f21748d == AdInterfacesStatus.PAUSED) {
            return true;
        }
        return false;
    }

    @Inject
    public BoostEventEditTargetingComponent(AdInterfacesBoostEventTargetingViewConroller adInterfacesBoostEventTargetingViewConroller) {
        this.f21623a = adInterfacesBoostEventTargetingViewConroller;
    }

    public final AdInterfacesViewController<AdInterfacesTargetingView, AdInterfacesBoostPostDataModel> mo948b() {
        return this.f21623a;
    }
}
