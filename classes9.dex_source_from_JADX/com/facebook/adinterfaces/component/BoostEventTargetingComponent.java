package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.ui.AdInterfacesBoostEventTargetingViewConroller;
import com.facebook.adinterfaces.ui.BaseAdInterfacesViewController;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: _id DESC LIMIT 10 */
public class BoostEventTargetingComponent extends TargetingComponent<AdInterfacesBoostPostDataModel> {
    private final AdInterfacesBoostEventTargetingViewConroller f21624a;

    public static BoostEventTargetingComponent m22620a(InjectorLike injectorLike) {
        return new BoostEventTargetingComponent(AdInterfacesBoostEventTargetingViewConroller.m24471d(injectorLike));
    }

    @Inject
    public BoostEventTargetingComponent(AdInterfacesBoostEventTargetingViewConroller adInterfacesBoostEventTargetingViewConroller) {
        this.f21624a = adInterfacesBoostEventTargetingViewConroller;
    }

    public final BaseAdInterfacesViewController mo948b() {
        return this.f21624a;
    }
}
