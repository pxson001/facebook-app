package com.facebook.adspayments;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.adspayments.analytics.PaymentsFlowContext;
import com.facebook.adspayments.analytics.PaymentsFlowState;
import com.facebook.adspayments.analytics.PaymentsLogger;
import com.facebook.common.locale.Country;
import com.facebook.common.locale.Locales;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.paymentmethods.picker.SelectBillingCountryView.OnCountryChange;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.countryselector.CountrySelector;
import com.facebook.widget.countryselector.CountrySelector.OnCountrySelectListener;
import com.facebook.widget.countryselector.CountrySelectorProvider;
import com.facebook.widget.countryspinner.CountryCode;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Unexpected InterruptedException */
public class AdsBillingCountrySelectorView extends CustomLinearLayout {
    @Inject
    CountrySelectorProvider f23507a;
    @Inject
    PaymentsLogger f23508b;
    @Inject
    Locales f23509c;
    public TextView f23510d;
    public CountrySelector f23511e;

    private static <T extends View> void m25460a(Class<T> cls, T t) {
        m25461a((Object) t, t.getContext());
    }

    private static void m25461a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((AdsBillingCountrySelectorView) obj).m25459a((CountrySelectorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CountrySelectorProvider.class), PaymentsLogger.m3873a(injectorLike), Locales.a(injectorLike));
    }

    private void m25459a(CountrySelectorProvider countrySelectorProvider, PaymentsLogger paymentsLogger, Locales locales) {
        this.f23507a = countrySelectorProvider;
        this.f23508b = paymentsLogger;
        this.f23509c = locales;
    }

    public AdsBillingCountrySelectorView(Context context) {
        super(context);
        m25458a();
    }

    public AdsBillingCountrySelectorView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m25458a();
    }

    public AdsBillingCountrySelectorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m25458a();
    }

    private void m25458a() {
        m25460a(AdsBillingCountrySelectorView.class, (View) this);
        setContentView(2130903192);
        setOrientation(0);
        this.f23510d = (TextView) a(2131559445);
        this.f23511e = this.f23507a.m3342a(getContext(), false);
    }

    public final void m25463a(Country country, final OnCountryChange onCountryChange, final PaymentsFlowContext paymentsFlowContext) {
        this.f23510d.setText(country.b(this.f23509c.a()));
        this.f23511e.f3545u = new OnCountrySelectListener(this) {
            final /* synthetic */ AdsBillingCountrySelectorView f23504b;

            public final void m25456a(CountryCode countryCode) {
                onCountryChange.mo751a(Country.a(countryCode.f3547a));
                this.f23504b.f23510d.setText(countryCode.f3549c);
            }
        };
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AdsBillingCountrySelectorView f23506b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -68710639);
                this.f23506b.f23508b.m3878a(PaymentsFlowState.SELECT_COUNTRY_STATE, paymentsFlowContext);
                this.f23506b.f23511e.a(view);
                Logger.a(2, EntryType.UI_INPUT_END, 1660979730, a);
            }
        });
    }
}
