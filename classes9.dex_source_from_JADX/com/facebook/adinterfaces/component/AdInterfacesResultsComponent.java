package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.logging.BoostedComponentLogger;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.ui.AdInterfacesPromotionDetailsView;
import com.facebook.adinterfaces.ui.AdInterfacesReactUtil;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import com.facebook.adinterfaces.ui.BoostedComponentResultsViewController;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: _is_empty */
public class AdInterfacesResultsComponent implements AdInterfacesComponent<AdInterfacesPromotionDetailsView, AdInterfacesDataModel> {
    private final AdInterfacesReactUtil f21621a;
    private final BoostedComponentResultsViewController f21622b;

    public static AdInterfacesResultsComponent m22610b(InjectorLike injectorLike) {
        return new AdInterfacesResultsComponent(AdInterfacesReactUtil.m24849b(injectorLike), new BoostedComponentResultsViewController(AdInterfacesReactUtil.m24849b(injectorLike), BoostedComponentLogger.m22753a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 2360), AdInterfacesDataHelper.m22789a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike)));
    }

    @Inject
    public AdInterfacesResultsComponent(AdInterfacesReactUtil adInterfacesReactUtil, BoostedComponentResultsViewController boostedComponentResultsViewController) {
        this.f21621a = adInterfacesReactUtil;
        this.f21622b = boostedComponentResultsViewController;
    }

    public final int mo946a() {
        return 2130903134;
    }

    public final AdInterfacesViewController<AdInterfacesPromotionDetailsView, AdInterfacesDataModel> mo948b() {
        return this.f21622b;
    }

    public static AdInterfacesResultsComponent m22609a(InjectorLike injectorLike) {
        return m22610b(injectorLike);
    }

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        if (!AdInterfacesDataHelper.m22811g(baseAdInterfacesData)) {
            return false;
        }
        int i;
        AdInterfacesStatus adInterfacesStatus = baseAdInterfacesData.f21748d;
        int i2 = (adInterfacesStatus == AdInterfacesStatus.CREATING || adInterfacesStatus == AdInterfacesStatus.EXTENDABLE || adInterfacesStatus == AdInterfacesStatus.ACTIVE || adInterfacesStatus == AdInterfacesStatus.PENDING || adInterfacesStatus == AdInterfacesStatus.PAUSED) ? 1 : 0;
        if (adInterfacesStatus == AdInterfacesStatus.FINISHED && baseAdInterfacesData.mo962b() == ObjectiveType.BOOST_POST) {
            i = 1;
        } else {
            i = 0;
        }
        if ((i2 | i) == 0 || !this.f21621a.m24851a()) {
            return false;
        }
        return true;
    }

    public final ComponentType mo949c() {
        return ComponentType.RESULTS;
    }
}
