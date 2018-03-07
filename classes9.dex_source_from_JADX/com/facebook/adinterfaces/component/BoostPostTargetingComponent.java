package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.ui.AdInterfacesBoostPostTargetingViewController;
import com.facebook.adinterfaces.ui.AdInterfacesTargetingView;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: _display_name */
public class BoostPostTargetingComponent extends TargetingComponent<AdInterfacesBoostPostDataModel> {
    private AdInterfacesBoostPostTargetingViewController f21626a;

    public static BoostPostTargetingComponent m22626a(InjectorLike injectorLike) {
        return new BoostPostTargetingComponent(AdInterfacesBoostPostTargetingViewController.m24522d(injectorLike));
    }

    @Inject
    public BoostPostTargetingComponent(AdInterfacesBoostPostTargetingViewController adInterfacesBoostPostTargetingViewController) {
        this.f21626a = adInterfacesBoostPostTargetingViewController;
    }

    public final AdInterfacesViewController<AdInterfacesTargetingView, AdInterfacesBoostPostDataModel> mo948b() {
        return this.f21626a;
    }
}
