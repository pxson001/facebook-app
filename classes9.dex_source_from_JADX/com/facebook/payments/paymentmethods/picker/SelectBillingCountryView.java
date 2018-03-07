package com.facebook.payments.paymentmethods.picker;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.adspayments.analytics.PaymentsFlowState;
import com.facebook.adspayments.analytics.PaymentsLogger;
import com.facebook.common.locale.Country;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.paymentmethods.picker.model.CountrySelectorRowItem;
import com.facebook.payments.picker.RowItemView;
import com.facebook.payments.ui.PaymentsComponentLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.countryselector.CountrySelector;
import com.facebook.widget.countryselector.CountrySelector.OnCountrySelectListener;
import com.facebook.widget.countryselector.CountrySelectorProvider;
import com.facebook.widget.countryspinner.CountryCode;
import javax.inject.Inject;

/* compiled from: bookmarks/impression */
public class SelectBillingCountryView extends PaymentsComponentLinearLayout implements RowItemView<CountrySelectorRowItem> {
    @Inject
    public CountrySelectorProvider f18820a;
    @Inject
    public PaymentsLogger f18821b;
    public TextView f18822c = ((TextView) a(2131567397));
    public CountrySelector f18823d = this.f18820a.m3342a(getContext(), false);
    public CountrySelectorRowItem f18824e;

    /* compiled from: bookmarks/impression */
    public interface OnCountryChange {
        void mo751a(Country country);
    }

    /* compiled from: bookmarks/impression */
    public class C22061 implements OnCountrySelectListener {
        final /* synthetic */ OnCountryChange f18817a;
        final /* synthetic */ SelectBillingCountryView f18818b;

        public C22061(SelectBillingCountryView selectBillingCountryView, OnCountryChange onCountryChange) {
            this.f18818b = selectBillingCountryView;
            this.f18817a = onCountryChange;
        }

        public final void m18828a(CountryCode countryCode) {
            this.f18817a.mo751a(Country.a(countryCode.f3547a));
            this.f18818b.f18822c.setText(countryCode.f3549c);
        }
    }

    /* compiled from: bookmarks/impression */
    public class C22072 implements OnClickListener {
        final /* synthetic */ SelectBillingCountryView f18819a;

        public C22072(SelectBillingCountryView selectBillingCountryView) {
            this.f18819a = selectBillingCountryView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 287270230);
            this.f18819a.f18821b.m3878a(PaymentsFlowState.SELECT_COUNTRY_STATE, this.f18819a.f18824e.f18840c.m18791b());
            this.f18819a.f18823d.a(view);
            Logger.a(2, EntryType.UI_INPUT_END, 790106900, a);
        }
    }

    public static void m18829a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        SelectBillingCountryView selectBillingCountryView = (SelectBillingCountryView) obj;
        CountrySelectorProvider countrySelectorProvider = (CountrySelectorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CountrySelectorProvider.class);
        PaymentsLogger a = PaymentsLogger.m3873a(injectorLike);
        selectBillingCountryView.f18820a = countrySelectorProvider;
        selectBillingCountryView.f18821b = a;
    }

    public SelectBillingCountryView(Context context) {
        super(context);
        Class cls = SelectBillingCountryView.class;
        m18829a(this, getContext());
        setContentView(2130907057);
        CustomViewUtils.b(this, new ColorDrawable(getResources().getColor(2131361920)));
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131429272);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131429275);
        setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
    }

    public final void mo658a() {
    }
}
