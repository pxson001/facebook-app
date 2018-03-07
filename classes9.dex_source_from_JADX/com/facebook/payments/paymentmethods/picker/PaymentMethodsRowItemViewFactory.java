package com.facebook.payments.paymentmethods.picker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.locale.Country;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.paymentmethods.picker.AddCardRowItemView.C21831;
import com.facebook.payments.paymentmethods.picker.AddPayPalRowItemView.C21841;
import com.facebook.payments.paymentmethods.picker.SelectBillingCountryView.C22061;
import com.facebook.payments.paymentmethods.picker.SelectBillingCountryView.C22072;
import com.facebook.payments.paymentmethods.picker.SelectBillingCountryView.OnCountryChange;
import com.facebook.payments.paymentmethods.picker.model.AddCardRowItem;
import com.facebook.payments.paymentmethods.picker.model.AddPayPalRowItem;
import com.facebook.payments.paymentmethods.picker.model.CountrySelectorRowItem;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodRowItem;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenFetcherParams;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenFetcherParamsBuilder;
import com.facebook.payments.picker.RowItemViewFactory;
import com.facebook.payments.picker.SimpleRowItemViewFactory;
import com.facebook.payments.picker.model.RowItem;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import javax.inject.Inject;

/* compiled from: bookmark_url */
public class PaymentMethodsRowItemViewFactory implements RowItemViewFactory {
    private final SimpleRowItemViewFactory f18764a;

    public static PaymentMethodsRowItemViewFactory m18769b(InjectorLike injectorLike) {
        return new PaymentMethodsRowItemViewFactory(SimpleRowItemViewFactory.m18891a(injectorLike));
    }

    @Inject
    public PaymentMethodsRowItemViewFactory(SimpleRowItemViewFactory simpleRowItemViewFactory) {
        this.f18764a = simpleRowItemViewFactory;
    }

    public final View mo651a(SimplePaymentsComponentCallback simplePaymentsComponentCallback, RowItem rowItem, View view, ViewGroup viewGroup) {
        switch (rowItem.mo657a()) {
            case COUNTRY_SELECTOR:
                return m18768a(simplePaymentsComponentCallback, (CountrySelectorRowItem) rowItem, view, viewGroup);
            case EXISTING_PAYMENT_METHOD:
                return PaymentMethodViewFactory.m18730a(simplePaymentsComponentCallback, (PaymentMethodRowItem) rowItem, view, viewGroup);
            case ADD_CARD:
                return mo1080a(simplePaymentsComponentCallback, (AddCardRowItem) rowItem, view, viewGroup);
            case ADD_PAYPAL:
                return mo1081a(simplePaymentsComponentCallback, (AddPayPalRowItem) rowItem, view, viewGroup);
            case HEADER:
            case SINGLE_ROW_DIVIDER:
            case SECURITY_FOOTER:
                return this.f18764a.mo651a(simplePaymentsComponentCallback, rowItem, view, viewGroup);
            default:
                throw new IllegalArgumentException("Illegal row type " + rowItem.mo657a());
        }
    }

    private View m18768a(final SimplePaymentsComponentCallback simplePaymentsComponentCallback, final CountrySelectorRowItem countrySelectorRowItem, View view, final ViewGroup viewGroup) {
        if (view == null) {
            view = new SelectBillingCountryView(viewGroup.getContext());
        } else {
            SelectBillingCountryView selectBillingCountryView = (SelectBillingCountryView) view;
        }
        view.setPaymentsComponentCallback(simplePaymentsComponentCallback);
        view.f18824e = countrySelectorRowItem;
        if (view.f18824e.f18839b) {
            view.setOrientation(1);
        } else {
            view.setOrientation(0);
            view.f18822c.setGravity(8388613);
        }
        view.f18822c.setText(view.f18824e.f18838a.a());
        OnCountryChange c21921 = new OnCountryChange(this) {
            final /* synthetic */ PaymentMethodsRowItemViewFactory f18762d;

            public final void mo751a(Country country) {
                this.f18762d.mo1082a(countrySelectorRowItem, country, simplePaymentsComponentCallback, viewGroup.getContext());
            }
        };
        view.f18823d.f3545u = new C22061(view, c21921);
        view.setOnClickListener(new C22072(view));
        return view;
    }

    protected void mo1082a(CountrySelectorRowItem countrySelectorRowItem, Country country, SimplePaymentsComponentCallback simplePaymentsComponentCallback, Context context) {
        PaymentMethodsPickerScreenFetcherParamsBuilder newBuilder = PaymentMethodsPickerScreenFetcherParams.newBuilder();
        newBuilder.f18850a = true;
        newBuilder = newBuilder;
        newBuilder.f18852c = country;
        Parcelable d = newBuilder.m18855d();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_reset_data", d);
        simplePaymentsComponentCallback.a(new PaymentsComponentAction(Action.RESET, bundle));
    }

    protected View mo1080a(SimplePaymentsComponentCallback simplePaymentsComponentCallback, AddCardRowItem addCardRowItem, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new AddCardRowItemView(viewGroup.getContext());
        } else {
            AddCardRowItemView addCardRowItemView = (AddCardRowItemView) view;
        }
        view.setPaymentsComponentCallback(simplePaymentsComponentCallback);
        view.f18716a.setOnClickListener(new C21831(view, addCardRowItem));
        return view;
    }

    protected View mo1081a(SimplePaymentsComponentCallback simplePaymentsComponentCallback, AddPayPalRowItem addPayPalRowItem, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new AddPayPalRowItemView(viewGroup.getContext());
        } else {
            AddPayPalRowItemView addPayPalRowItemView = (AddPayPalRowItemView) view;
        }
        view.setPaymentsComponentCallback(simplePaymentsComponentCallback);
        view.f18721c.setOnClickListener(new C21841(view, addPayPalRowItem));
        return view;
    }
}
