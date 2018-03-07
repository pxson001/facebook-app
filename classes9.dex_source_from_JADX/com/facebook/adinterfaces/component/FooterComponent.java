package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.ui.AdInterfacesFooterView;
import com.facebook.adinterfaces.ui.AdInterfacesFooterViewController;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: ^0[1-9]$ */
public class FooterComponent implements AdInterfacesComponent<AdInterfacesFooterView, AdInterfacesDataModel> {
    private AdInterfacesFooterViewController f21637a;

    private static FooterComponent m22665b(InjectorLike injectorLike) {
        return new FooterComponent(AdInterfacesFooterViewController.m24477a(injectorLike));
    }

    @Inject
    FooterComponent(AdInterfacesFooterViewController adInterfacesFooterViewController) {
        this.f21637a = adInterfacesFooterViewController;
    }

    public final int mo946a() {
        return 2130903118;
    }

    public final AdInterfacesViewController<AdInterfacesFooterView, AdInterfacesDataModel> mo948b() {
        return this.f21637a;
    }

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        if (!AdInterfacesDataHelper.m22811g(baseAdInterfacesData)) {
            return false;
        }
        AdInterfacesStatus adInterfacesStatus = baseAdInterfacesData.f21748d;
        if (adInterfacesStatus == AdInterfacesStatus.INACTIVE || adInterfacesStatus == AdInterfacesStatus.NEVER_BOOSTED || adInterfacesStatus == AdInterfacesStatus.PAUSED || adInterfacesStatus == AdInterfacesStatus.EXTENDABLE || adInterfacesStatus == AdInterfacesStatus.FINISHED || adInterfacesStatus == AdInterfacesStatus.PENDING) {
            return true;
        }
        return false;
    }

    public final ComponentType mo949c() {
        return ComponentType.FOOTER;
    }
}
