package com.facebook.messaging.payment.value.input.picker;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsRowItemViewFactory;
import com.facebook.payments.picker.RowItemViewFactory;
import com.facebook.payments.picker.model.RowItem;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import javax.inject.Inject;

/* compiled from: eglMakeCurrent failed  */
public final class CommercePaymentMethodsPickerScreenRowItemViewFactory implements RowItemViewFactory {
    private final PaymentMethodsRowItemViewFactory f15832a;

    @Inject
    public CommercePaymentMethodsPickerScreenRowItemViewFactory(PaymentMethodsRowItemViewFactory paymentMethodsRowItemViewFactory) {
        this.f15832a = paymentMethodsRowItemViewFactory;
    }

    public final View mo651a(SimplePaymentsComponentCallback simplePaymentsComponentCallback, RowItem rowItem, View view, ViewGroup viewGroup) {
        switch (rowItem.mo657a()) {
            case COMMERCE_COMMERCE_SIMPLE_ADD_PAYMENT_METHOD:
                return m16022b(simplePaymentsComponentCallback, rowItem, view, viewGroup);
            default:
                return this.f15832a.mo651a(simplePaymentsComponentCallback, rowItem, view, viewGroup);
        }
    }

    private static View m16022b(SimplePaymentsComponentCallback simplePaymentsComponentCallback, RowItem rowItem, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new CommerceSimpleAddPaymentMethodRowItemView(viewGroup.getContext());
        } else {
            CommerceSimpleAddPaymentMethodRowItemView commerceSimpleAddPaymentMethodRowItemView = (CommerceSimpleAddPaymentMethodRowItemView) view;
        }
        view.setPaymentsComponentCallback(simplePaymentsComponentCallback);
        view.m16047a(rowItem);
        return view;
    }
}
