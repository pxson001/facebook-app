package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import com.facebook.adinterfaces.ui.BoostPostTargetingDescriptionViewController;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: \d{5}([ \-]\d{4})? */
public class TargetingDescriptionComponent implements AdInterfacesComponent<BetterTextView, AdInterfacesBoostPostDataModel> {
    private BoostPostTargetingDescriptionViewController f21646a;

    public static TargetingDescriptionComponent m22708a(InjectorLike injectorLike) {
        return new TargetingDescriptionComponent(new BoostPostTargetingDescriptionViewController());
    }

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        baseAdInterfacesData = (AdInterfacesBoostPostDataModel) baseAdInterfacesData;
        if (!AdInterfacesDataHelper.m22811g(baseAdInterfacesData)) {
            return false;
        }
        AdInterfacesStatus adInterfacesStatus = baseAdInterfacesData.f21748d;
        if (adInterfacesStatus == AdInterfacesStatus.ACTIVE || adInterfacesStatus == AdInterfacesStatus.NEVER_BOOSTED || adInterfacesStatus == AdInterfacesStatus.PAUSED || adInterfacesStatus == AdInterfacesStatus.EXTENDABLE || adInterfacesStatus == AdInterfacesStatus.FINISHED || adInterfacesStatus == AdInterfacesStatus.PENDING) {
            return true;
        }
        return false;
    }

    @Inject
    public TargetingDescriptionComponent(BoostPostTargetingDescriptionViewController boostPostTargetingDescriptionViewController) {
        this.f21646a = boostPostTargetingDescriptionViewController;
    }

    public final int mo946a() {
        return 2130903148;
    }

    public final AdInterfacesViewController<BetterTextView, AdInterfacesBoostPostDataModel> mo948b() {
        return this.f21646a;
    }

    public final ComponentType mo949c() {
        return ComponentType.TARGETING_DESCRIPTION;
    }
}
