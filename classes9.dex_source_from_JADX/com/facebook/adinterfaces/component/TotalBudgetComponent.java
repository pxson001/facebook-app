package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import com.facebook.adinterfaces.ui.BudgetOptionsView;
import com.facebook.adinterfaces.ui.TotalBudgetViewController;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: \d{4}[ ]?[A-Z]{2} */
public class TotalBudgetComponent implements AdInterfacesComponent<BudgetOptionsView, AdInterfacesBoostPostDataModel> {
    private TotalBudgetViewController f21647a;

    public static TotalBudgetComponent m22713a(InjectorLike injectorLike) {
        return new TotalBudgetComponent(TotalBudgetViewController.m25141b(injectorLike));
    }

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        baseAdInterfacesData = (AdInterfacesBoostPostDataModel) baseAdInterfacesData;
        if (!AdInterfacesDataHelper.m22811g(baseAdInterfacesData)) {
            return false;
        }
        AdInterfacesStatus adInterfacesStatus = baseAdInterfacesData.f21748d;
        if (adInterfacesStatus == AdInterfacesStatus.INACTIVE || adInterfacesStatus == AdInterfacesStatus.NEVER_BOOSTED || adInterfacesStatus == AdInterfacesStatus.ACTIVE || adInterfacesStatus == AdInterfacesStatus.EXTENDABLE || adInterfacesStatus == AdInterfacesStatus.PENDING) {
            return true;
        }
        return false;
    }

    @Inject
    public TotalBudgetComponent(TotalBudgetViewController totalBudgetViewController) {
        this.f21647a = totalBudgetViewController;
    }

    public final int mo946a() {
        return 2130903107;
    }

    public final AdInterfacesViewController<BudgetOptionsView, AdInterfacesBoostPostDataModel> mo948b() {
        return this.f21647a;
    }

    public final ComponentType mo949c() {
        return ComponentType.BUDGET;
    }
}
