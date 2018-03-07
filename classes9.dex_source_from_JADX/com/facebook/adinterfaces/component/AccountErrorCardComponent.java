package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.ui.AccountErrorCardViewController;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import javax.inject.Inject;

/* compiled from: _startActivityForIntent */
public class AccountErrorCardComponent implements AdInterfacesComponent<TextWithEntitiesView, BaseAdInterfacesData> {
    private AccountErrorCardViewController f21616a;

    public static AccountErrorCardComponent m22597b(InjectorLike injectorLike) {
        return new AccountErrorCardComponent(new AccountErrorCardViewController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike)));
    }

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        baseAdInterfacesData = baseAdInterfacesData;
        if (!AdInterfacesDataHelper.m22811g(baseAdInterfacesData)) {
            return false;
        }
        AdInterfacesStatus adInterfacesStatus = baseAdInterfacesData.f21748d;
        if (adInterfacesStatus == AdInterfacesStatus.INACTIVE || adInterfacesStatus == AdInterfacesStatus.NEVER_BOOSTED || adInterfacesStatus == AdInterfacesStatus.ACTIVE || adInterfacesStatus == AdInterfacesStatus.PAUSED || adInterfacesStatus == AdInterfacesStatus.EXTENDABLE || adInterfacesStatus == AdInterfacesStatus.FINISHED || adInterfacesStatus == AdInterfacesStatus.PENDING) {
            return true;
        }
        return false;
    }

    @Inject
    public AccountErrorCardComponent(AccountErrorCardViewController accountErrorCardViewController) {
        this.f21616a = accountErrorCardViewController;
    }

    public final int mo946a() {
        return 2130903116;
    }

    public final AdInterfacesViewController<TextWithEntitiesView, BaseAdInterfacesData> mo948b() {
        return this.f21616a;
    }

    public static AccountErrorCardComponent m22596a(InjectorLike injectorLike) {
        return m22597b(injectorLike);
    }

    public final ComponentType mo949c() {
        return ComponentType.ACCOUNT_ERROR_CARD;
    }
}
