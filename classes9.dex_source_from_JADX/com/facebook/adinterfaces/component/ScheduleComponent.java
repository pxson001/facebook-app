package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.ui.AdInterfacesScheduleView;
import com.facebook.adinterfaces.ui.AdInterfacesScheduleViewController;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: \d{6} */
public class ScheduleComponent implements AdInterfacesComponent<AdInterfacesScheduleView, AdInterfacesBoostedComponentDataModel> {
    AdInterfacesScheduleViewController f21645a;

    private static ScheduleComponent m22698b(InjectorLike injectorLike) {
        return new ScheduleComponent(AdInterfacesScheduleViewController.m24901b(injectorLike));
    }

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        baseAdInterfacesData = (AdInterfacesBoostedComponentDataModel) baseAdInterfacesData;
        if (!AdInterfacesDataHelper.m22811g(baseAdInterfacesData)) {
            return false;
        }
        AdInterfacesStatus adInterfacesStatus = baseAdInterfacesData.f21748d;
        if (adInterfacesStatus == AdInterfacesStatus.INACTIVE || adInterfacesStatus == AdInterfacesStatus.ACTIVE || adInterfacesStatus == AdInterfacesStatus.NEVER_BOOSTED || adInterfacesStatus == AdInterfacesStatus.PAUSED || adInterfacesStatus == AdInterfacesStatus.EXTENDABLE || adInterfacesStatus == AdInterfacesStatus.FINISHED || adInterfacesStatus == AdInterfacesStatus.PENDING) {
            return true;
        }
        return false;
    }

    @Inject
    ScheduleComponent(AdInterfacesScheduleViewController adInterfacesScheduleViewController) {
        this.f21645a = adInterfacesScheduleViewController;
    }

    public final int mo946a() {
        return 2130903140;
    }

    public final AdInterfacesViewController<AdInterfacesScheduleView, AdInterfacesBoostedComponentDataModel> mo948b() {
        return this.f21645a;
    }

    public final ComponentType mo949c() {
        return ComponentType.DURATION;
    }
}
