package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.ui.AdInterfacesPromotionDetailsView;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import com.facebook.adinterfaces.ui.BoostPostPromotionDetailsViewController;

/* compiled from: \d{7} */
public class PromotionDetailsComponent implements AdInterfacesComponent<AdInterfacesPromotionDetailsView, AdInterfacesBoostPostDataModel> {
    private BoostPostPromotionDetailsViewController f21644a;

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

    public PromotionDetailsComponent(BoostPostPromotionDetailsViewController boostPostPromotionDetailsViewController) {
        this.f21644a = boostPostPromotionDetailsViewController;
    }

    public final int mo946a() {
        return 2130903131;
    }

    public final AdInterfacesViewController<AdInterfacesPromotionDetailsView, AdInterfacesBoostPostDataModel> mo948b() {
        return this.f21644a;
    }

    public final ComponentType mo949c() {
        return ComponentType.PROMOTION_DETAILS;
    }
}
