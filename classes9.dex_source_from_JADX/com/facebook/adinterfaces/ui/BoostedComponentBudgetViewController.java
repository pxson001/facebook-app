package com.facebook.adinterfaces.ui;

import android.content.res.Resources;
import android.text.Html;
import android.text.Spanned;
import android.view.inputmethod.InputMethodManager;
import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.logging.BoostedComponentLogger;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.IntervalModel;
import com.facebook.adinterfaces.protocol.FetchBudgetRecommendationsMethod;
import com.facebook.adinterfaces.ui.BudgetHelper.BudgetTipType;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import javax.inject.Inject;

/* compiled from: Unsupported flow type */
public class BoostedComponentBudgetViewController extends BaseBudgetOptionsViewController<AdInterfacesDataModel> {
    private Resources f23080d;
    private AdInterfacesDataHelper f23081e;
    private AdInterfacesErrorReporter f23082f;

    /* compiled from: Unsupported flow type */
    public /* synthetic */ class C27101 {
        public static final /* synthetic */ int[] f23079a = new int[ObjectiveType.values().length];

        static {
            try {
                f23079a[ObjectiveType.PAGE_LIKE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23079a[ObjectiveType.PROMOTE_PRODUCT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23079a[ObjectiveType.LOCAL_AWARENESS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f23079a[ObjectiveType.PROMOTE_WEBSITE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f23079a[ObjectiveType.PROMOTE_CTA.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static BoostedComponentBudgetViewController m25065b(InjectorLike injectorLike) {
        return new BoostedComponentBudgetViewController(AdInterfacesDataHelper.m22789a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), InputMethodManagerMethodAutoProvider.b(injectorLike), BudgetHelper.m25096a(injectorLike), TasksManager.b(injectorLike), FetchBudgetRecommendationsMethod.m24149b(injectorLike), AdInterfacesErrorReporter.m22724a(injectorLike), (AdInterfacesSpinnerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AdInterfacesSpinnerAdapterProvider.class), DefaultAndroidThreadUtil.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), BoostedComponentLogger.m22753a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike));
    }

    public static BoostedComponentBudgetViewController m25064a(InjectorLike injectorLike) {
        return m25065b(injectorLike);
    }

    @Inject
    public BoostedComponentBudgetViewController(AdInterfacesDataHelper adInterfacesDataHelper, Resources resources, InputMethodManager inputMethodManager, BudgetHelper budgetHelper, TasksManager tasksManager, FetchBudgetRecommendationsMethod fetchBudgetRecommendationsMethod, AdInterfacesErrorReporter adInterfacesErrorReporter, AdInterfacesSpinnerAdapterProvider adInterfacesSpinnerAdapterProvider, DefaultAndroidThreadUtil defaultAndroidThreadUtil, GraphQLQueryExecutor graphQLQueryExecutor, BoostedComponentLogger boostedComponentLogger, QuickPerformanceLogger quickPerformanceLogger) {
        super(resources, inputMethodManager, budgetHelper, tasksManager, fetchBudgetRecommendationsMethod, adInterfacesSpinnerAdapterProvider, defaultAndroidThreadUtil, graphQLQueryExecutor, adInterfacesErrorReporter, boostedComponentLogger, quickPerformanceLogger);
        this.f23080d = resources;
        this.f23081e = adInterfacesDataHelper;
        this.f23082f = adInterfacesErrorReporter;
    }

    public final void mo1026a(BudgetOptionsView budgetOptionsView, AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo1026a(budgetOptionsView, adInterfacesCardLayout);
        adInterfacesCardLayout.m24585a(budgetOptionsView.getContext().getString(2131233885), 2130843649);
    }

    protected final void mo1025a(AdInterfacesStatus adInterfacesStatus) {
        int i;
        if (BudgetHelper.m25102b(this.f23053n)) {
            i = 2131234003;
        } else {
            i = 2131233986;
        }
        this.f23055p.setHeaderTitleResource(i);
    }

    protected final BudgetTipType mo1029d() {
        if (this.f23053n.f21750f == null) {
            return BudgetTipType.NONE;
        }
        BigDecimal a = BudgetHelper.m25098a(this.f23053n.f21750f);
        Preconditions.checkNotNull(a);
        BigDecimal d = BudgetHelper.m25104d(this.f23053n);
        BigDecimal e = BudgetHelper.m25105e(this.f23053n);
        if (BudgetHelper.m25102b(this.f23053n)) {
            BigDecimal valueOf = BigDecimal.valueOf((long) this.f23053n.f21753i);
            e = e.multiply(valueOf);
            d = d.multiply(valueOf);
        }
        Preconditions.checkNotNull(d);
        if (a.compareTo(d) > 0) {
            return BudgetTipType.MAX;
        }
        if (a.compareTo(e) < 0) {
            return BudgetTipType.MIN;
        }
        return BudgetTipType.NONE;
    }

    protected final String mo1030e() {
        CurrencyQuantityModel v = AdInterfacesDataHelper.m22806e(this.f23053n).m23148v();
        return BudgetHelper.m25097a(v.m23421j(), BudgetHelper.m25098a(v).longValue(), BudgetHelper.m25107g(this.f23053n));
    }

    protected final Spanned mo1031f() {
        CurrencyQuantityModel v = AdInterfacesDataHelper.m22806e(this.f23053n).m23148v();
        if (v == null || v.m23421j() <= 0 || v.m23422k() == null) {
            return null;
        }
        BigDecimal a = BudgetHelper.m25098a(v);
        if (BudgetHelper.m25102b(this.f23053n)) {
            a = a.multiply(BigDecimal.valueOf((long) this.f23053n.f21753i));
        }
        String a2 = BudgetHelper.m25097a(v.m23421j(), a.longValue(), BudgetHelper.m25107g(this.f23053n));
        return Html.fromHtml(this.f23080d.getString(2131233906, new Object[]{a2}));
    }

    protected final Spanned mo1032g() {
        CurrencyQuantityModel u = AdInterfacesDataHelper.m22806e(this.f23053n).m23147u();
        if (u == null || u.m23421j() <= 0 || u.m23422k() == null) {
            return null;
        }
        return Html.fromHtml(this.f23080d.getString(2131233904, new Object[]{BudgetHelper.m25097a(AdInterfacesDataHelper.m22806e(this.f23053n).m23147u().m23421j(), BudgetHelper.m25098a(AdInterfacesDataHelper.m22806e(this.f23053n).m23147u()).longValue(), BudgetHelper.m25107g(this.f23053n))}));
    }

    protected final CharSequence mo1024a(CurrencyQuantityModel currencyQuantityModel) {
        return BudgetHelper.m25097a(currencyQuantityModel.m23421j(), BudgetHelper.m25098a(currencyQuantityModel).longValue(), BudgetHelper.m25107g(this.f23053n));
    }

    protected final CurrencyQuantityModel mo1028b(CurrencyQuantityModel currencyQuantityModel) {
        return currencyQuantityModel;
    }

    protected final Spanned mo1023a(IntervalModel intervalModel) {
        int i;
        String str = "";
        switch (C27101.f23079a[this.f23053n.mo962b().ordinal()]) {
            case 1:
                i = 2131233896;
                break;
            case 2:
            case 3:
                i = 2131233894;
                break;
            case 4:
            case 5:
                i = 2131233898;
                break;
            default:
                i = 0;
                break;
        }
        int i2 = i;
        if (i2 != 0) {
            str = this.f23080d.getString(i2, new Object[]{this.f23081e.m22822a(intervalModel.m23467a()), this.f23081e.m22822a(intervalModel.m23471j())});
        } else {
            this.f23082f.m22726a(getClass(), "Unable to resolve reach string for objective " + this.f23053n.mo962b().name());
        }
        return Html.fromHtml(str);
    }

    protected final Spanned mo1027b(IntervalModel intervalModel) {
        int i;
        String str = "";
        switch (C27101.f23079a[this.f23053n.mo962b().ordinal()]) {
            case 1:
                i = 2131233897;
                break;
            case 2:
            case 3:
                i = 2131233895;
                break;
            case 4:
                i = 2131233899;
                break;
            default:
                i = 0;
                break;
        }
        int i2 = i;
        if (i2 != 0) {
            str = this.f23080d.getString(i2, new Object[]{this.f23081e.m22822a(intervalModel.m23467a()), this.f23081e.m22822a(intervalModel.m23471j())});
        }
        return Html.fromHtml(str);
    }
}
