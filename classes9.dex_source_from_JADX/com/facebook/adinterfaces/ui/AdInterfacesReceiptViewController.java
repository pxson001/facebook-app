package com.facebook.adinterfaces.ui;

import android.text.method.LinkMovementMethod;
import android.view.View;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel;
import com.facebook.inject.InjectorLike;
import java.text.NumberFormat;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: User triggered OOM crash from Intern settings */
public class AdInterfacesReceiptViewController extends BaseAdInterfacesViewController<AdInterfacesReceiptView, AdInterfacesDataModel> {
    private final AdInterfacesLegalUtil f22892a;
    private BaseAdInterfacesData f22893b;
    private NumberFormat f22894c;

    private static AdInterfacesReceiptViewController m24855b(InjectorLike injectorLike) {
        return new AdInterfacesReceiptViewController(AdInterfacesLegalUtil.m24675a(injectorLike));
    }

    public final void mo982a(View view, @Nullable AdInterfacesCardLayout adInterfacesCardLayout) {
        AdInterfacesReceiptView adInterfacesReceiptView = (AdInterfacesReceiptView) view;
        super.mo982a(adInterfacesReceiptView, adInterfacesCardLayout);
        adInterfacesReceiptView.setLegalDisclaimerText(this.f22892a.m24678a());
        CurrencyQuantityModel currencyQuantityModel = this.f22893b.f21750f;
        String a = BudgetHelper.m25097a(currencyQuantityModel.m23421j(), BudgetHelper.m25098a(currencyQuantityModel).longValue(), this.f22894c);
        adInterfacesReceiptView.setBudgetSummaryText(adInterfacesReceiptView.getResources().getQuantityString(2131689579, this.f22893b.f21753i, new Object[]{a, Integer.valueOf(this.f22893b.f21753i)}));
        adInterfacesReceiptView.setLegalDisclaimerMovementMethod(LinkMovementMethod.getInstance());
    }

    @Inject
    public AdInterfacesReceiptViewController(AdInterfacesLegalUtil adInterfacesLegalUtil) {
        this.f22892a = adInterfacesLegalUtil;
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f22893b = baseAdInterfacesData;
        this.f22894c = BudgetHelper.m25107g(baseAdInterfacesData);
    }

    public static AdInterfacesReceiptViewController m24854a(InjectorLike injectorLike) {
        return m24855b(injectorLike);
    }
}
