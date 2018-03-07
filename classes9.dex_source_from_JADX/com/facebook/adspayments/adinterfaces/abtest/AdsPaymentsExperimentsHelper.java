package com.facebook.adspayments.adinterfaces.abtest;

import com.facebook.adspayments.BrazilianTaxIdActivity;
import com.facebook.adspayments.analytics.PaymentsFlowContext;
import com.facebook.adspayments.analytics.PaymentsLogEvent;
import com.facebook.adspayments.analytics.PaymentsLogger;
import com.facebook.common.locale.Country;
import com.facebook.common.locale.Locales;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.MoreObjects;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Unable to find newBuilder method */
public class AdsPaymentsExperimentsHelper {
    private final QeAccessor f23617a;
    private final Provider<TriState> f23618b;
    private final Provider<TriState> f23619c;
    private final Locales f23620d;
    private final PaymentsLogger f23621e;

    public static AdsPaymentsExperimentsHelper m25609b(InjectorLike injectorLike) {
        return new AdsPaymentsExperimentsHelper((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 629), IdBasedProvider.a(injectorLike, 628), Locales.a(injectorLike), PaymentsLogger.m3873a(injectorLike));
    }

    @Inject
    public AdsPaymentsExperimentsHelper(QeAccessor qeAccessor, Provider<TriState> provider, Provider<TriState> provider2, Locales locales, PaymentsLogger paymentsLogger) {
        this.f23617a = qeAccessor;
        this.f23618b = provider;
        this.f23619c = provider2;
        this.f23620d = locales;
        this.f23621e = paymentsLogger;
    }

    public final AdsPaymentsExperience m25611a(boolean z, @Nullable Country country) {
        if (m25610b()) {
            return AdsPaymentsExperience.M_SITE;
        }
        if (((TriState) this.f23618b.get()).asBoolean(true)) {
            return AdsPaymentsExperience.DIALOG_US;
        }
        if (z && m25614a(m25616b(country))) {
            return AdsPaymentsExperience.BRAZILIAN_TAX_ID;
        }
        return AdsPaymentsExperience.SCREEN_INTERNATIONAL;
    }

    public final boolean m25614a(Country country) {
        return BrazilianTaxIdActivity.f23556p.equals(country) && this.f23617a.a(Liveness.Live, ExperimentsForAdsPaymentsModule.f23623b, false);
    }

    public final Country m25616b(@Nullable Country country) {
        return (Country) MoreObjects.firstNonNull(country, Country.a(this.f23620d.a()));
    }

    private boolean m25610b() {
        return !((TriState) this.f23619c.get()).asBoolean(false);
    }

    public final boolean m25615a(PaymentItemType paymentItemType) {
        return paymentItemType == PaymentItemType.INVOICE && m25610b();
    }

    public final boolean m25613a() {
        return !m25610b() && this.f23617a.a(Liveness.Live, ExperimentsForAdsPaymentsModule.f23622a, false);
    }

    public final void m25612a(PaymentsFlowContext paymentsFlowContext, boolean z, Country country) {
        PaymentsLogEvent paymentsLogEvent = new PaymentsLogEvent("payments_android_initiate_ads_payments_flow", paymentsFlowContext);
        paymentsLogEvent.b("ads_payments_experience", m25611a(z, country).toString());
        this.f23621e.m3879a(paymentsLogEvent);
    }
}
