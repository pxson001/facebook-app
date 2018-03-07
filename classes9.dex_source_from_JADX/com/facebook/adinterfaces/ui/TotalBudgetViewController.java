package com.facebook.adinterfaces.ui;

import android.content.res.Resources;
import android.text.Html;
import android.text.Spanned;
import android.util.Pair;
import android.view.inputmethod.InputMethodManager;
import com.facebook.adinterfaces.abtest.ExperimentsForAdInterfacesModule;
import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.logging.BoostedComponentLogger;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel.Builder;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.IntervalModel;
import com.facebook.adinterfaces.protocol.FetchBudgetRecommendationsMethod;
import com.facebook.adinterfaces.ui.BudgetHelper.BudgetTipType;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: Unknown operation type  */
public class TotalBudgetViewController extends BaseBudgetOptionsViewController<AdInterfacesBoostPostDataModel> {
    private QeAccessor f23174d;
    public AdInterfacesErrorReporter f23175e;
    private BudgetHelper f23176f;
    private final Resources f23177g;
    private final AdInterfacesDataHelper f23178h;
    private AdInterfacesStatus f23179i;
    private AdInterfacesBoostPostDataModel f23180j;

    public static TotalBudgetViewController m25141b(InjectorLike injectorLike) {
        return new TotalBudgetViewController(AdInterfacesDataHelper.m22789a(injectorLike), AdInterfacesErrorReporter.m22724a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), InputMethodManagerMethodAutoProvider.b(injectorLike), BudgetHelper.m25096a(injectorLike), TasksManager.b(injectorLike), FetchBudgetRecommendationsMethod.m24149b(injectorLike), (AdInterfacesSpinnerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AdInterfacesSpinnerAdapterProvider.class), DefaultAndroidThreadUtil.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), BoostedComponentLogger.m22753a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        baseAdInterfacesData = (AdInterfacesBoostPostDataModel) baseAdInterfacesData;
        super.mo983a(baseAdInterfacesData);
        this.f23180j = baseAdInterfacesData;
        this.f23179i = baseAdInterfacesData.f21748d;
    }

    public final void mo1026a(BudgetOptionsView budgetOptionsView, AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo1026a(budgetOptionsView, adInterfacesCardLayout);
        if (this.f23174d.a(Liveness.Live, ExposureLogging.Off, ExperimentsForAdInterfacesModule.f21614k, false)) {
            List arrayList = new ArrayList();
            arrayList.add(new Pair(Integer.valueOf(2131560209), Integer.valueOf(2131234130)));
            arrayList.add(new Pair(Integer.valueOf(2131560043), Integer.valueOf(2131234131)));
            arrayList.add(new Pair(Integer.valueOf(2131561812), Integer.valueOf(2131234132)));
            arrayList.add(new Pair(Integer.valueOf(2131561813), Integer.valueOf(2131234133)));
            arrayList.add(new Pair(Integer.valueOf(2131561142), Integer.valueOf(2131234134)));
            arrayList.add(new Pair(Integer.valueOf(2131560211), Integer.valueOf(2131234129)));
            this.f22440b.m22430a(adInterfacesCardLayout.m24583a(arrayList, "budget"));
        }
    }

    protected final BudgetTipType mo1029d() {
        if (this.f23053n.f21750f == null) {
            return BudgetTipType.NONE;
        }
        BigDecimal a = BudgetHelper.m25098a(this.f23053n.f21750f);
        Preconditions.checkNotNull(a);
        BigDecimal multiply = BudgetHelper.m25104d(this.f23053n).multiply(BigDecimal.valueOf((long) this.f23053n.f21753i));
        Preconditions.checkNotNull(multiply);
        BigDecimal f = BudgetHelper.m25106f(this.f23053n);
        if (a.compareTo(multiply) > 0) {
            return BudgetTipType.MAX;
        }
        if ((this.f23179i == AdInterfacesStatus.INACTIVE || this.f23179i == AdInterfacesStatus.NEVER_BOOSTED) && a.compareTo(f) < 0) {
            return BudgetTipType.MIN;
        }
        return BudgetTipType.NONE;
    }

    protected final String mo1030e() {
        BigDecimal valueOf;
        CurrencyQuantityModel v = AdInterfacesDataHelper.m22806e(this.f23053n).m23148v();
        switch (this.f23180j.f21748d) {
            case INACTIVE:
            case NEVER_BOOSTED:
                valueOf = BigDecimal.valueOf((long) this.f23053n.f21753i);
                break;
            default:
                valueOf = BigDecimal.valueOf(1);
                break;
        }
        return BudgetHelper.m25097a(v.m23421j(), BudgetHelper.m25098a(v).multiply(valueOf).longValue(), BudgetHelper.m25107g(this.f23053n));
    }

    protected final Spanned mo1031f() {
        CurrencyQuantityModel v = AdInterfacesDataHelper.m22806e(this.f23053n).m23148v();
        if (v == null || v.m23421j() <= 0 || v.m23422k() == null || this.f23053n.f21753i <= 0) {
            return null;
        }
        String a = BudgetHelper.m25097a(v.m23421j(), BudgetHelper.m25098a(AdInterfacesDataHelper.m22806e(this.f23053n).m23148v()).longValue(), BudgetHelper.m25107g(this.f23053n));
        String e = mo1030e();
        return Html.fromHtml(this.f23177g.getString(2131233905, new Object[]{a, e}));
    }

    protected final Spanned mo1032g() {
        CurrencyQuantityModel u = AdInterfacesDataHelper.m22806e(this.f23053n).m23147u();
        if (u == null || u.m23421j() <= 0 || u.m23422k() == null) {
            return null;
        }
        return Html.fromHtml(this.f23177g.getString(2131233904, new Object[]{BudgetHelper.m25097a(AdInterfacesDataHelper.m22806e(this.f23053n).m23147u().m23421j(), BudgetHelper.m25098a(AdInterfacesDataHelper.m22806e(this.f23053n).m23147u()).longValue(), BudgetHelper.m25107g(this.f23053n))}));
    }

    @Inject
    public TotalBudgetViewController(AdInterfacesDataHelper adInterfacesDataHelper, AdInterfacesErrorReporter adInterfacesErrorReporter, Resources resources, InputMethodManager inputMethodManager, BudgetHelper budgetHelper, TasksManager tasksManager, FetchBudgetRecommendationsMethod fetchBudgetRecommendationsMethod, AdInterfacesSpinnerAdapterProvider adInterfacesSpinnerAdapterProvider, DefaultAndroidThreadUtil defaultAndroidThreadUtil, GraphQLQueryExecutor graphQLQueryExecutor, BoostedComponentLogger boostedComponentLogger, QuickPerformanceLogger quickPerformanceLogger, QeAccessor qeAccessor) {
        super(resources, inputMethodManager, budgetHelper, tasksManager, fetchBudgetRecommendationsMethod, adInterfacesSpinnerAdapterProvider, defaultAndroidThreadUtil, graphQLQueryExecutor, adInterfacesErrorReporter, boostedComponentLogger, quickPerformanceLogger);
        this.f23175e = adInterfacesErrorReporter;
        this.f23176f = budgetHelper;
        this.f23177g = resources;
        this.f23178h = adInterfacesDataHelper;
        this.f23174d = qeAccessor;
    }

    protected final void mo1025a(AdInterfacesStatus adInterfacesStatus) {
        if (adInterfacesStatus == AdInterfacesStatus.INACTIVE || adInterfacesStatus == AdInterfacesStatus.NEVER_BOOSTED) {
            this.f23055p.setHeaderTitleResource(2131234003);
        } else {
            this.f23055p.setHeaderTitleResource(2131233983);
        }
    }

    protected final CharSequence mo1024a(CurrencyQuantityModel currencyQuantityModel) {
        if (this.f23179i == AdInterfacesStatus.INACTIVE || this.f23179i == AdInterfacesStatus.NEVER_BOOSTED) {
            return BudgetHelper.m25097a(currencyQuantityModel.m23421j(), BudgetHelper.m25098a(currencyQuantityModel).longValue(), BudgetHelper.m25107g(this.f23053n));
        }
        BigDecimal a = this.f23176f.m25109a(this.f23180j.f21780a.m23713l().m23668k(), currencyQuantityModel);
        if (a == null) {
            return null;
        }
        return BudgetHelper.m25097a(currencyQuantityModel.m23421j(), a.longValue(), BudgetHelper.m25107g(this.f23053n));
    }

    protected final CurrencyQuantityModel mo1028b(CurrencyQuantityModel currencyQuantityModel) {
        if (this.f23179i == AdInterfacesStatus.INACTIVE || this.f23179i == AdInterfacesStatus.NEVER_BOOSTED) {
            return currencyQuantityModel;
        }
        CurrencyQuantityModel currencyQuantityModel2;
        CurrencyQuantityModel k = this.f23180j.f21780a.m23713l().m23668k();
        BigDecimal a = BudgetHelper.m25098a(k);
        BigDecimal add = a.add(BudgetHelper.m25098a(currencyQuantityModel));
        if (add.compareTo(a) <= 0) {
            this.f23175e.m22726a(getClass(), "Total budget must be greater than the current budget");
            currencyQuantityModel2 = null;
        } else {
            Builder builder = new Builder();
            builder.f22124a = k.m23419a();
            builder = builder;
            builder.f22125b = k.m23421j();
            builder = builder;
            builder.f22126c = add.toString();
            currencyQuantityModel2 = builder.m23414a();
        }
        return currencyQuantityModel2;
    }

    protected final Spanned mo1023a(IntervalModel intervalModel) {
        return Html.fromHtml(this.f23177g.getString(2131233894, new Object[]{this.f23178h.m22822a(intervalModel.m23467a()), this.f23178h.m22822a(intervalModel.m23471j())}));
    }

    protected final Spanned mo1027b(IntervalModel intervalModel) {
        return Html.fromHtml(this.f23177g.getString(2131233895, new Object[]{this.f23178h.m22822a(intervalModel.m23467a()), this.f23178h.m22822a(intervalModel.m23471j())}));
    }
}
