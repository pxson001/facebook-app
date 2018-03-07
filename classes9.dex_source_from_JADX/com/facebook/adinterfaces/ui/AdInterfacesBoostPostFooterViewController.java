package com.facebook.adinterfaces.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.abtest.ExperimentsForAdInterfacesModule;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel;
import com.facebook.adinterfaces.util.BoostMutationHelper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import java.math.BigDecimal;
import javax.inject.Inject;

/* compiled from: VI */
public class AdInterfacesBoostPostFooterViewController extends AdInterfacesFooterViewController<AdInterfacesBoostPostDataModel> {
    private BudgetHelper f22591a;
    private BoostMutationHelper f22592b;
    public QeAccessor f22593c;
    private boolean f22594d = false;
    private AdInterfacesBoostPostDataModel f22595e;

    public final /* bridge */ /* synthetic */ void mo982a(View view, AdInterfacesCardLayout adInterfacesCardLayout) {
        mo1005a((AdInterfacesFooterView) view, adInterfacesCardLayout);
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        baseAdInterfacesData = (AdInterfacesBoostPostDataModel) baseAdInterfacesData;
        super.mo983a(baseAdInterfacesData);
        this.f22595e = baseAdInterfacesData;
        this.f22594d = this.f22593c.a(ExperimentsForAdInterfacesModule.f21607d, false);
    }

    @Inject
    public AdInterfacesBoostPostFooterViewController(@Assisted BoostMutationHelper boostMutationHelper, BudgetHelper budgetHelper, AdInterfacesLegalUtil adInterfacesLegalUtil, QeAccessor qeAccessor) {
        super(adInterfacesLegalUtil);
        this.f22591a = budgetHelper;
        this.f22592b = boostMutationHelper;
        this.f22593c = qeAccessor;
    }

    protected final OnClickListener mo996b() {
        return this.f22592b.mo1052d(this.f22590c.getContext(), this.f22440b, this.f22595e);
    }

    protected final OnClickListener mo998c() {
        return this.f22592b.mo1049a(this.f22440b, this.f22595e);
    }

    protected final void mo999d() {
        int i;
        int i2;
        Object obj = this.f22595e.mo962b() == ObjectiveType.BOOST_EVENT ? 1 : null;
        AdInterfacesFooterView adInterfacesFooterView = this.f22590c;
        if (obj != null) {
            i = 2131233993;
        } else {
            i = 2131233990;
        }
        adInterfacesFooterView.setPauseAdButtonText(i);
        adInterfacesFooterView = this.f22590c;
        if (obj != null) {
            i = 2131233994;
        } else {
            i = 2131233991;
        }
        adInterfacesFooterView.setResumeAdButtonText(i);
        AdInterfacesFooterView adInterfacesFooterView2 = this.f22590c;
        if (obj != null) {
            i2 = 2131233992;
        } else {
            i2 = 2131234000;
        }
        adInterfacesFooterView2.setDeleteAdButtonText(i2);
    }

    protected final String mo995a(String str) {
        if (this.f22595e.mo962b() == ObjectiveType.BOOST_EVENT) {
            return this.f22590c.getContext().getString(2131233995);
        }
        if (str == null) {
            return this.f22590c.getContext().getString(2131234020);
        }
        return StringFormatUtil.formatStrLocaleSafe(this.f22590c.getContext().getString(2131233943), str);
    }

    protected final String mo994a(CurrencyQuantityModel currencyQuantityModel) {
        if (currencyQuantityModel == null) {
            return this.f22590c.getContext().getString(2131233983);
        }
        BigDecimal a = this.f22591a.m25109a(this.f22595e.f21780a.m23713l().m23668k(), currencyQuantityModel);
        if (a == null) {
            return this.f22590c.getContext().getString(2131233983);
        }
        return StringFormatUtil.formatStrLocaleSafe(this.f22590c.getContext().getString(2131233944), BudgetHelper.m25097a(currencyQuantityModel.m23421j(), a.longValue(), BudgetHelper.m25107g(this.f22589b)));
    }

    protected final OnClickListener mo1000e() {
        return this.f22592b.mo1051c(this.f22590c.getContext(), this.f22440b, this.f22595e);
    }

    protected final OnClickListener mo1001f() {
        return this.f22592b.mo1050b(this.f22590c.getContext(), this.f22440b, this.f22595e);
    }

    protected final OnClickListener mo1002g() {
        return this.f22592b.mo1048a(this.f22590c.getContext(), this.f22440b, this.f22595e);
    }

    protected final void mo997b(CurrencyQuantityModel currencyQuantityModel) {
        if (this.f22589b.f21748d == AdInterfacesStatus.INACTIVE || this.f22589b.f21748d == AdInterfacesStatus.NEVER_BOOSTED) {
            super.mo997b(currencyQuantityModel);
        } else if (currencyQuantityModel == null) {
            this.f22590c.setAddBudgetButtonText(mo994a(null));
        } else {
            this.f22590c.setAddBudgetButtonText(mo994a(currencyQuantityModel));
        }
    }

    protected final void mo1003h() {
        switch (this.f22589b.f21748d) {
            case INACTIVE:
                this.f22590c.setCreateAdButtonVisibility(0);
                this.f22590c.setAddBudgetButtonVisibility(8);
                this.f22590c.setResumeAdButtonVisibility(8);
                this.f22590c.setPauseAdButtonVisibility(8);
                this.f22590c.setDeleteAdButtonVisibility(8);
                return;
            case EXTENDABLE:
                this.f22590c.setCreateAdButtonVisibility(8);
                this.f22590c.setAddBudgetButtonVisibility(0);
                this.f22590c.setResumeAdButtonVisibility(8);
                this.f22590c.setPauseAdButtonVisibility(8);
                this.f22590c.setDeleteAdButtonVisibility(8);
                return;
            case FINISHED:
                this.f22590c.setCreateAdButtonVisibility(8);
                this.f22590c.setAddBudgetButtonVisibility(8);
                this.f22590c.setResumeAdButtonVisibility(8);
                this.f22590c.setPauseAdButtonVisibility(8);
                this.f22590c.setDeleteAdButtonVisibility(8);
                return;
            case PENDING:
            case ACTIVE:
                this.f22590c.setCreateAdButtonVisibility(8);
                this.f22590c.setAddBudgetButtonVisibility(0);
                this.f22590c.setResumeAdButtonVisibility(8);
                this.f22590c.setDeleteAdButtonVisibility(8);
                if (this.f22594d) {
                    this.f22590c.setPauseAdButtonVisibility(8);
                    return;
                } else {
                    this.f22590c.setPauseAdButtonVisibility(0);
                    return;
                }
            case PAUSED:
                this.f22590c.setCreateAdButtonVisibility(8);
                this.f22590c.setAddBudgetButtonVisibility(8);
                this.f22590c.setResumeAdButtonVisibility(0);
                this.f22590c.setPauseAdButtonVisibility(8);
                if (this.f22594d) {
                    this.f22590c.setDeleteAdButtonVisibility(8);
                    return;
                } else {
                    this.f22590c.setDeleteAdButtonVisibility(0);
                    return;
                }
            default:
                this.f22590c.setCreateAdButtonVisibility(8);
                this.f22590c.setAddBudgetButtonVisibility(8);
                this.f22590c.setResumeAdButtonVisibility(8);
                this.f22590c.setPauseAdButtonVisibility(8);
                this.f22590c.setDeleteAdButtonVisibility(8);
                return;
        }
    }
}
