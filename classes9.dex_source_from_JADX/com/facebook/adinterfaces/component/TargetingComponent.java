package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.ui.AdInterfacesTargetingView;

/* compiled from: _isEnum_ */
abstract class TargetingComponent<D extends AdInterfacesDataModel> implements AdInterfacesComponent<AdInterfacesTargetingView, D> {
    TargetingComponent() {
    }

    public int mo946a() {
        return 2130903147;
    }

    public boolean mo947a(D d) {
        if (!AdInterfacesDataHelper.m22811g((BaseAdInterfacesData) d)) {
            return false;
        }
        AdInterfacesStatus adInterfacesStatus = d.f21748d;
        if (adInterfacesStatus == AdInterfacesStatus.INACTIVE || adInterfacesStatus == AdInterfacesStatus.NEVER_BOOSTED) {
            return true;
        }
        return false;
    }

    public final ComponentType mo949c() {
        return ComponentType.TARGETING;
    }
}
