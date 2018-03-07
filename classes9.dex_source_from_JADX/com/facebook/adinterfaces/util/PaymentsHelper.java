package com.facebook.adinterfaces.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import com.facebook.adinterfaces.AdInterfacesContext;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent;
import com.facebook.adinterfaces.logging.BoostedComponentLogger;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel;
import com.facebook.adinterfaces.ui.BudgetHelper;
import com.facebook.adspayments.AddNewPaymentMethodProvider;
import com.facebook.adspayments.BrazilianTaxIdActivity;
import com.facebook.adspayments.PrepayFlowFundingActivity;
import com.facebook.adspayments.adinterfaces.abtest.AdsPaymentsExperimentsHelper;
import com.facebook.adspayments.analytics.AdsPaymentsFlowContext;
import com.facebook.adspayments.analytics.PaymentsFlowContext;
import com.facebook.adspayments.analytics.StoredBalanceStatus;
import com.facebook.adspayments.utils.PickerScreenUtils;
import com.facebook.common.locale.Country;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.FbAppType;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.model.CurrencyAmount;
import com.facebook.payments.model.PaymentsFlowType;
import com.facebook.payments.paymentmethods.picker.PickerScreenActivity;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenFetcherParams;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenFetcherParamsBuilder;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: Unimplemented state */
public class PaymentsHelper {
    private static final Double f23349a = Double.valueOf(0.9d);
    private static final String f23350b = PaymentsHelper.class.toString();
    private static volatile PaymentsHelper f23351i;
    private final AddNewPaymentMethodProvider f23352c;
    private final AdInterfacesHelper f23353d;
    private final BoostedComponentLogger f23354e;
    private final AdsPaymentsExperimentsHelper f23355f;
    private FbAppType f23356g;
    private SecureContextHelper f23357h;

    public static com.facebook.adinterfaces.util.PaymentsHelper m25285a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f23351i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.adinterfaces.util.PaymentsHelper.class;
        monitor-enter(r1);
        r0 = f23351i;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m25291b(r0);	 Catch:{ all -> 0x0035 }
        f23351i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23351i;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.util.PaymentsHelper.a(com.facebook.inject.InjectorLike):com.facebook.adinterfaces.util.PaymentsHelper");
    }

    private static PaymentsHelper m25291b(InjectorLike injectorLike) {
        return new PaymentsHelper((AddNewPaymentMethodProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AddNewPaymentMethodProvider.class), AdInterfacesHelper.m25227a(injectorLike), BoostedComponentLogger.m22753a(injectorLike), AdsPaymentsExperimentsHelper.m25609b(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public PaymentsHelper(AddNewPaymentMethodProvider addNewPaymentMethodProvider, AdInterfacesHelper adInterfacesHelper, BoostedComponentLogger boostedComponentLogger, AdsPaymentsExperimentsHelper adsPaymentsExperimentsHelper, FbAppType fbAppType, SecureContextHelper secureContextHelper) {
        this.f23353d = adInterfacesHelper;
        this.f23352c = addNewPaymentMethodProvider;
        this.f23354e = boostedComponentLogger;
        this.f23355f = adsPaymentsExperimentsHelper;
        this.f23356g = fbAppType;
        this.f23357h = secureContextHelper;
    }

    private static String m25289a(AdAccountModel adAccountModel, BaseAdInterfacesData baseAdInterfacesData, FbAppType fbAppType) {
        return StringFormatUtil.a("https://m.facebook.com/ads/boosted_component/payment?ad_account_id=%s&entry_point=%s&app_id=%s", new Object[]{adAccountModel.m23146t(), baseAdInterfacesData.mo962b().getEntryPoint(), fbAppType.c()});
    }

    public final void m25297a(AdInterfacesContext adInterfacesContext, BaseAdInterfacesData baseAdInterfacesData, AdAccountModel adAccountModel, FragmentManager fragmentManager, Context context) {
        this.f23354e.m22777g(baseAdInterfacesData);
        PaymentsFlowContext a = m25286a(baseAdInterfacesData, adAccountModel);
        boolean z = true;
        if ((!StoredBalanceStatus.of(adAccountModel.m23152z()).isPUX() ? 1 : null) == null || BrazilianTaxIdActivity.f23556p.equals(m25295e(adAccountModel))) {
            z = false;
        }
        boolean z2 = z;
        Country e = m25295e(adAccountModel);
        this.f23355f.m25612a(a, z2, e);
        switch (this.f23355f.m25611a(z2, e)) {
            case SCREEN_INTERNATIONAL:
                m25298a(a, adInterfacesContext, adAccountModel, context, z2);
                return;
            case DIALOG_US:
                this.f23352c.m25337a(fragmentManager).m25336a(a, m25294d(adAccountModel), "add_payment_method_tag", 3);
                return;
            case BRAZILIAN_TAX_ID:
                this.f23357h.a(BrazilianTaxIdActivity.m25518a(context, a), 301, (Activity) ContextUtils.a(context, Activity.class));
                return;
            default:
                adInterfacesContext.m22429a(new IntentEvent(AdInterfacesHelper.m25226a(m25289a(adAccountModel, baseAdInterfacesData, this.f23356g)), 3, false));
                return;
        }
    }

    private static AdsPaymentsFlowContext m25286a(BaseAdInterfacesData baseAdInterfacesData, AdAccountModel adAccountModel) {
        return new AdsPaymentsFlowContext(baseAdInterfacesData.mo962b().name(), adAccountModel.m23146t(), PaymentsFlowType.PICKER_SCREEN, m25292b(baseAdInterfacesData, adAccountModel), !BudgetHelper.m25102b(baseAdInterfacesData), m25287a(adAccountModel));
    }

    public static StoredBalanceStatus m25287a(AdAccountModel adAccountModel) {
        return StoredBalanceStatus.of(adAccountModel.m23152z());
    }

    public final void m25296a(Context context, BaseAdInterfacesData baseAdInterfacesData, AdAccountModel adAccountModel, AdInterfacesContext adInterfacesContext) {
        m25290a(PrepayFlowFundingActivity.m25563a(context, m25286a(baseAdInterfacesData, adAccountModel), m25292b(baseAdInterfacesData, adAccountModel), null, m25294d(adAccountModel), true), adInterfacesContext);
    }

    public final void m25298a(PaymentsFlowContext paymentsFlowContext, AdInterfacesContext adInterfacesContext, AdAccountModel adAccountModel, Context context, boolean z) {
        m25290a(PickerScreenActivity.m18779a(context, m25288a(adAccountModel, paymentsFlowContext, context, z)), adInterfacesContext);
    }

    private static void m25290a(Intent intent, AdInterfacesContext adInterfacesContext) {
        adInterfacesContext.m22429a(new IntentEvent(intent, 10, true));
    }

    private PickerScreenParams m25288a(AdAccountModel adAccountModel, PaymentsFlowContext paymentsFlowContext, Context context, boolean z) {
        String string = context.getString(2131233857);
        PaymentMethodsPickerScreenFetcherParamsBuilder newBuilder = PaymentMethodsPickerScreenFetcherParams.newBuilder();
        newBuilder.f18850a = true;
        newBuilder = newBuilder;
        newBuilder.f18852c = m25294d(adAccountModel);
        return PickerScreenUtils.m25756a(string, paymentsFlowContext, newBuilder.m18855d(), z);
    }

    public static boolean m25293b(AdAccountModel adAccountModel) {
        if (adAccountModel == null || adAccountModel.m23151y() == null || adAccountModel.m23151y().m23103a() == null || adAccountModel.m23151y().m23105j() == null) {
            return false;
        }
        Long valueOf = Long.valueOf(Long.parseLong(adAccountModel.m23151y().m23103a().m23091a()));
        Long valueOf2 = Long.valueOf(Long.parseLong(adAccountModel.m23151y().m23105j().m23100a()));
        if (valueOf.compareTo(valueOf2) == 0) {
            return false;
        }
        if (valueOf.longValue() >= ((long) (((double) valueOf2.longValue()) * f23349a.doubleValue()))) {
            return true;
        }
        return false;
    }

    public static CurrencyAmount m25292b(BaseAdInterfacesData baseAdInterfacesData, AdAccountModel adAccountModel) {
        CurrencyQuantityModel currencyQuantityModel = baseAdInterfacesData.f21750f;
        return new CurrencyAmount(adAccountModel.m23139m().m23419a(), CurrencyAmount.a(currencyQuantityModel.m23421j(), Long.parseLong(currencyQuantityModel.m23422k())));
    }

    private Country m25294d(AdAccountModel adAccountModel) {
        return this.f23355f.m25616b(m25295e(adAccountModel));
    }

    @Nullable
    public static Country m25295e(AdAccountModel adAccountModel) {
        if (adAccountModel.m23136j() == null) {
            return null;
        }
        Object a = adAccountModel.m23136j().m23127a();
        if (StringUtil.a(a)) {
            return null;
        }
        return Country.a(a);
    }
}
