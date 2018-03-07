package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.ui.AdInterfacesInsightsReachViewController;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import com.facebook.adinterfaces.ui.SegmentedBarInfoView;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: ] to be first */
public class InsightsCardReachComponent implements AdInterfacesComponent<SegmentedBarInfoView, AdInterfacesBoostPostDataModel> {
    private AdInterfacesInsightsReachViewController f21641a;

    public static InsightsCardReachComponent m22684b(InjectorLike injectorLike) {
        return new InsightsCardReachComponent(new AdInterfacesInsightsReachViewController(AdInterfacesDataHelper.m22789a(injectorLike)));
    }

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        if (((AdInterfacesBoostPostDataModel) baseAdInterfacesData).f21780a.m23711j() == null) {
            return false;
        }
        return true;
    }

    @Inject
    InsightsCardReachComponent(AdInterfacesInsightsReachViewController adInterfacesInsightsReachViewController) {
        this.f21641a = adInterfacesInsightsReachViewController;
    }

    public final int mo946a() {
        return 2130903122;
    }

    public final AdInterfacesViewController<SegmentedBarInfoView, AdInterfacesBoostPostDataModel> mo948b() {
        return this.f21641a;
    }

    public final ComponentType mo949c() {
        return ComponentType.INSIGHTS_REACH;
    }
}
