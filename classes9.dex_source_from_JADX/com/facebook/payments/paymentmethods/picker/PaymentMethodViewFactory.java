package com.facebook.payments.paymentmethods.picker;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodRowItem;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;

/* compiled from: boosted_cta_mobile */
public class PaymentMethodViewFactory {
    public static View m18730a(SimplePaymentsComponentCallback simplePaymentsComponentCallback, PaymentMethodRowItem paymentMethodRowItem, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new PaymentMethodView(viewGroup.getContext());
        } else {
            PaymentMethodView paymentMethodView = (PaymentMethodView) view;
        }
        view.setPaymentsComponentCallback(simplePaymentsComponentCallback);
        view.m18728a(paymentMethodRowItem);
        return view;
    }
}
