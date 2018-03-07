package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.ui.AdInterfacesBoostPostTargetingViewController;
import com.facebook.adinterfaces.ui.AdInterfacesTargetingView;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import javax.inject.Inject;

/* compiled from: __android_exception */
public class EditTargetingComponent extends TargetingComponent<AdInterfacesBoostPostDataModel> {
    private AdInterfacesBoostPostTargetingViewController f21631a;

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
    public EditTargetingComponent(AdInterfacesBoostPostTargetingViewController adInterfacesBoostPostTargetingViewController) {
        this.f21631a = adInterfacesBoostPostTargetingViewController;
    }

    public final AdInterfacesViewController<AdInterfacesTargetingView, AdInterfacesBoostPostDataModel> mo948b() {
        return this.f21631a;
    }
}
