package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.ui.AdInterfacesInsightsClicksViewController;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import com.facebook.adinterfaces.ui.SegmentedBarInfoView;
import javax.inject.Inject;

/* compiled from: ^.+/([0-9]+)/.+/([0-9]+).*$ */
public class InsightsCardClicksComponent implements AdInterfacesComponent<SegmentedBarInfoView, AdInterfacesBoostPostDataModel> {
    private AdInterfacesInsightsClicksViewController f21639a;

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel = (AdInterfacesBoostPostDataModel) baseAdInterfacesData;
        if (adInterfacesBoostPostDataModel == null || adInterfacesBoostPostDataModel.f21780a == null || adInterfacesBoostPostDataModel.f21780a.m23711j() == null) {
            return false;
        }
        return true;
    }

    @Inject
    public InsightsCardClicksComponent(AdInterfacesInsightsClicksViewController adInterfacesInsightsClicksViewController) {
        this.f21639a = adInterfacesInsightsClicksViewController;
    }

    public final int mo946a() {
        return 2130903122;
    }

    public final AdInterfacesViewController<SegmentedBarInfoView, AdInterfacesBoostPostDataModel> mo948b() {
        return this.f21639a;
    }

    public final ComponentType mo949c() {
        return ComponentType.INSIGHTS_CLICKS;
    }
}
