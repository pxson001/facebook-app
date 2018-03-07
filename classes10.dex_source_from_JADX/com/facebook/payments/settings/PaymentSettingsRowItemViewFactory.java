package com.facebook.payments.settings;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.payments.history.picker.ViewFullHistoryRowItem;
import com.facebook.payments.history.picker.ViewFullHistoryRowItemView;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsRowItemViewFactory;
import com.facebook.payments.picker.RowItemViewFactory;
import com.facebook.payments.picker.SimpleRowItemViewFactory;
import com.facebook.payments.picker.model.RowItem;
import com.facebook.payments.picker.model.RowType;
import com.facebook.payments.shipping.addresspicker.ShippingRowItemViewFactory;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import javax.inject.Inject;

/* compiled from: locked_privacy_education */
public final class PaymentSettingsRowItemViewFactory implements RowItemViewFactory {
    private final PaymentMethodsRowItemViewFactory f8433a;
    private final ShippingRowItemViewFactory f8434b;
    private final SimpleRowItemViewFactory f8435c;

    /* compiled from: locked_privacy_education */
    /* synthetic */ class C12551 {
        static final /* synthetic */ int[] f8432a = new int[RowType.values().length];

        static {
            try {
                f8432a[RowType.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8432a[RowType.SPACED_DOUBLE_ROW_DIVIDER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8432a[RowType.EXISTING_PAYMENT_METHOD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f8432a[RowType.ADD_CARD.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f8432a[RowType.ADD_PAYPAL.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f8432a[RowType.VIEW_FULL_HISTORY.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f8432a[RowType.ADD_SHIPPING_ADDRESS.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f8432a[RowType.SHIPPING_ADDRESS.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    @Inject
    public PaymentSettingsRowItemViewFactory(PaymentMethodsRowItemViewFactory paymentMethodsRowItemViewFactory, ShippingRowItemViewFactory shippingRowItemViewFactory, SimpleRowItemViewFactory simpleRowItemViewFactory) {
        this.f8433a = paymentMethodsRowItemViewFactory;
        this.f8434b = shippingRowItemViewFactory;
        this.f8435c = simpleRowItemViewFactory;
    }

    public final View m8359a(SimplePaymentsComponentCallback simplePaymentsComponentCallback, RowItem rowItem, View view, ViewGroup viewGroup) {
        switch (C12551.f8432a[rowItem.a().ordinal()]) {
            case 1:
            case 2:
                return this.f8435c.a(simplePaymentsComponentCallback, rowItem, view, viewGroup);
            case 3:
            case 4:
            case 5:
                return this.f8433a.a(simplePaymentsComponentCallback, rowItem, view, viewGroup);
            case 6:
                return m8358a((ViewFullHistoryRowItem) rowItem, view, viewGroup);
            case 7:
            case 8:
                return this.f8434b.a(simplePaymentsComponentCallback, rowItem, view, viewGroup);
            default:
                throw new IllegalArgumentException("Illegal row type " + rowItem.a());
        }
    }

    private static View m8358a(ViewFullHistoryRowItem viewFullHistoryRowItem, View view, ViewGroup viewGroup) {
        return view == null ? new ViewFullHistoryRowItemView(viewGroup.getContext()) : (ViewFullHistoryRowItemView) view;
    }
}
