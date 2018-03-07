package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.ui.AdInterfacesBoostPostFooterViewController;
import com.facebook.adinterfaces.ui.AdInterfacesFooterView;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;

/* compiled from: _ft_ */
public class BoostPostFooterComponent implements AdInterfacesComponent<AdInterfacesFooterView, AdInterfacesBoostPostDataModel> {
    private AdInterfacesBoostPostFooterViewController f21625a;

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        baseAdInterfacesData = (AdInterfacesBoostPostDataModel) baseAdInterfacesData;
        if (!AdInterfacesDataHelper.m22811g(baseAdInterfacesData)) {
            return false;
        }
        AdInterfacesStatus adInterfacesStatus = baseAdInterfacesData.f21748d;
        if (adInterfacesStatus == AdInterfacesStatus.INACTIVE || adInterfacesStatus == AdInterfacesStatus.NEVER_BOOSTED || adInterfacesStatus == AdInterfacesStatus.ACTIVE || adInterfacesStatus == AdInterfacesStatus.PAUSED || adInterfacesStatus == AdInterfacesStatus.EXTENDABLE || adInterfacesStatus == AdInterfacesStatus.PENDING) {
            return true;
        }
        return false;
    }

    public BoostPostFooterComponent(AdInterfacesBoostPostFooterViewController adInterfacesBoostPostFooterViewController) {
        this.f21625a = adInterfacesBoostPostFooterViewController;
    }

    public final int mo946a() {
        return 2130903118;
    }

    public final AdInterfacesViewController<AdInterfacesFooterView, AdInterfacesBoostPostDataModel> mo948b() {
        return this.f21625a;
    }

    public final ComponentType mo949c() {
        return ComponentType.FOOTER;
    }
}
