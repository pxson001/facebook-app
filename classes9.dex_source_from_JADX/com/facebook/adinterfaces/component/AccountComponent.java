package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.ui.AdInterfacesAccountView;
import com.facebook.adinterfaces.ui.AdInterfacesAccountViewController;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: _tab */
public class AccountComponent implements AdInterfacesComponent<AdInterfacesAccountView, AdInterfacesDataModel> {
    private AdInterfacesAccountViewController f21615a;

    public static AccountComponent m22591a(InjectorLike injectorLike) {
        return new AccountComponent(AdInterfacesAccountViewController.m24352b(injectorLike));
    }

    @Inject
    public AccountComponent(AdInterfacesAccountViewController adInterfacesAccountViewController) {
        this.f21615a = adInterfacesAccountViewController;
    }

    public final int mo946a() {
        return 2130903096;
    }

    public final AdInterfacesViewController<AdInterfacesAccountView, AdInterfacesDataModel> mo948b() {
        return this.f21615a;
    }

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        if (!AdInterfacesDataHelper.m22811g(baseAdInterfacesData)) {
            return false;
        }
        AdInterfacesStatus adInterfacesStatus = baseAdInterfacesData.f21748d;
        if (adInterfacesStatus == AdInterfacesStatus.INACTIVE || adInterfacesStatus == AdInterfacesStatus.NEVER_BOOSTED || adInterfacesStatus == AdInterfacesStatus.ACTIVE || adInterfacesStatus == AdInterfacesStatus.PAUSED || adInterfacesStatus == AdInterfacesStatus.EXTENDABLE || adInterfacesStatus == AdInterfacesStatus.FINISHED || adInterfacesStatus == AdInterfacesStatus.PENDING) {
            return true;
        }
        return false;
    }

    public final ComponentType mo949c() {
        return ComponentType.ACCOUNT;
    }
}
