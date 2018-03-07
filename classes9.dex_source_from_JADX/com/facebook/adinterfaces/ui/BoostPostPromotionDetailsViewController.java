package com.facebook.adinterfaces.ui;

import android.content.res.Resources;
import android.view.View;
import com.facebook.adinterfaces.abtest.ExperimentsForAdInterfacesModule;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionInfoModel;
import com.facebook.adinterfaces.util.BoostMutationHelper;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import java.text.NumberFormat;
import javax.inject.Inject;

/* compiled from: Unsupported protocol version %d */
public class BoostPostPromotionDetailsViewController extends BaseAdInterfacesViewController<AdInterfacesPromotionDetailsView, AdInterfacesBoostPostDataModel> {
    public AdInterfacesBoostPostDataModel f23070a;
    public AdInterfacesPromotionDetailsView f23071b;
    private AdInterfacesDataHelper f23072c;
    public NumberFormat f23073d;
    private BoostMutationHelper f23074e;
    private final AdInterfacesReactUtil f23075f;
    public final QeAccessor f23076g;
    public String f23077h;
    public boolean f23078i;

    public final void mo982a(View view, AdInterfacesCardLayout adInterfacesCardLayout) {
        AdInterfacesPromotionDetailsView adInterfacesPromotionDetailsView = (AdInterfacesPromotionDetailsView) view;
        super.mo982a(adInterfacesPromotionDetailsView, adInterfacesCardLayout);
        this.f23071b = adInterfacesPromotionDetailsView;
        StoryPromotionInfoModel l = this.f23070a.f21780a.m23713l();
        adInterfacesPromotionDetailsView.setColumnsActive(false);
        if (!this.f23078i) {
            adInterfacesPromotionDetailsView.setColumnsActive(true);
            adInterfacesPromotionDetailsView.setSpentText(this.f23077h);
            adInterfacesPromotionDetailsView.setPaidReach(AdInterfacesDataHelper.m22797a(l.m23672o(), this.f23071b.getContext()));
        }
        Resources resources = adInterfacesPromotionDetailsView.getResources();
        if (this.f23078i) {
            adInterfacesPromotionDetailsView.m24846c(resources.getString(2131233960), this.f23077h);
        }
        String string = resources.getString(2131234003);
        String str = "";
        if (this.f23070a.f21780a.m23713l().m23668k() != null) {
            str = BudgetHelper.m25097a(this.f23070a.f21780a.m23713l().m23668k().m23421j(), BudgetHelper.m25098a(this.f23070a.f21780a.m23713l().m23668k()).longValue(), this.f23073d);
        }
        adInterfacesPromotionDetailsView.m24846c(string, str);
        adInterfacesPromotionDetailsView.m24846c(resources.getString(2131234001), AdInterfacesDataHelper.m22798a(this.f23070a.f21780a.m23713l().m23678u(), this.f23071b.getContext()));
        m25057a(adInterfacesPromotionDetailsView);
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel = (AdInterfacesBoostPostDataModel) baseAdInterfacesData;
        this.f23073d = BudgetHelper.m25107g(adInterfacesBoostPostDataModel);
        this.f23070a = adInterfacesBoostPostDataModel;
        this.f23078i = this.f23075f.m24851a();
        this.f23077h = BudgetHelper.m25097a(BudgetHelper.m25108h(this.f23070a), (long) this.f23070a.f21780a.m23713l().m23676s(), this.f23073d);
    }

    @Inject
    public BoostPostPromotionDetailsViewController(@Assisted BoostMutationHelper boostMutationHelper, AdInterfacesDataHelper adInterfacesDataHelper, AdInterfacesReactUtil adInterfacesReactUtil, QeAccessor qeAccessor) {
        this.f23072c = adInterfacesDataHelper;
        this.f23074e = boostMutationHelper;
        this.f23075f = adInterfacesReactUtil;
        this.f23076g = qeAccessor;
    }

    private void m25057a(AdInterfacesPromotionDetailsView adInterfacesPromotionDetailsView) {
        if (this.f23076g.a(ExperimentsForAdInterfacesModule.f21607d, false)) {
            switch (this.f23070a.f21748d) {
                case ACTIVE:
                case PENDING:
                    adInterfacesPromotionDetailsView.setActionButtonText(adInterfacesPromotionDetailsView.getResources().getString(2131233987));
                    adInterfacesPromotionDetailsView.setActionButtonVisibility(0);
                    adInterfacesPromotionDetailsView.setActionButtonListener(this.f23074e.mo1048a(adInterfacesPromotionDetailsView.getContext(), this.f22440b, this.f23070a));
                    return;
                case PAUSED:
                    adInterfacesPromotionDetailsView.setActionButtonText(adInterfacesPromotionDetailsView.getResources().getString(2131233989));
                    adInterfacesPromotionDetailsView.setActionButtonVisibility(0);
                    adInterfacesPromotionDetailsView.setActionButtonListener(this.f23074e.mo1049a(this.f22440b, this.f23070a));
                    return;
                default:
                    return;
            }
        }
    }

    public final void mo981a() {
        super.mo981a();
        this.f23071b = null;
    }
}
