package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.ui.AdInterfacesInsightsSummaryView;
import com.facebook.adinterfaces.ui.AdInterfacesInsightsSummaryViewController;
import com.facebook.adinterfaces.ui.AdInterfacesReactUtil;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: \v */
public class InsightsSummaryComponent implements AdInterfacesComponent<AdInterfacesInsightsSummaryView, AdInterfacesBoostPostDataModel> {
    private final AdInterfacesReactUtil f21642a;
    private final AdInterfacesInsightsSummaryViewController f21643b;

    public static InsightsSummaryComponent m22689a(InjectorLike injectorLike) {
        return new InsightsSummaryComponent(AdInterfacesReactUtil.m24849b(injectorLike), AdInterfacesInsightsSummaryViewController.m24668b(injectorLike));
    }

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        boolean z;
        AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel = (AdInterfacesBoostPostDataModel) baseAdInterfacesData;
        boolean z2;
        if (adInterfacesBoostPostDataModel.f21780a.m23711j() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        AdInterfacesStatus adInterfacesStatus = adInterfacesBoostPostDataModel.f21748d;
        if (adInterfacesStatus == AdInterfacesStatus.NEVER_BOOSTED || adInterfacesStatus == AdInterfacesStatus.INACTIVE || adInterfacesStatus == AdInterfacesStatus.ERROR || adInterfacesStatus == AdInterfacesStatus.REJECTED || !this.f21642a.m24851a()) {
            z = false;
        } else {
            z = true;
        }
        if (z || r0) {
            return false;
        }
        return true;
    }

    @Inject
    public InsightsSummaryComponent(AdInterfacesReactUtil adInterfacesReactUtil, AdInterfacesInsightsSummaryViewController adInterfacesInsightsSummaryViewController) {
        this.f21642a = adInterfacesReactUtil;
        this.f21643b = adInterfacesInsightsSummaryViewController;
    }

    public final int mo946a() {
        return 2130903123;
    }

    public final AdInterfacesViewController<AdInterfacesInsightsSummaryView, AdInterfacesBoostPostDataModel> mo948b() {
        return this.f21643b;
    }

    public final ComponentType mo949c() {
        return ComponentType.INSIGHTS_SUMMARY;
    }
}
