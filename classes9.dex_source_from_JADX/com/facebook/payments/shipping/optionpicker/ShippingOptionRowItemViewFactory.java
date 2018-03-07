package com.facebook.payments.shipping.optionpicker;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.payments.picker.RowItemViewFactory;
import com.facebook.payments.picker.model.RowItem;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;

/* compiled from: backstage_entered_publish_step */
public final class ShippingOptionRowItemViewFactory implements RowItemViewFactory {
    public final View mo651a(SimplePaymentsComponentCallback simplePaymentsComponentCallback, RowItem rowItem, View view, ViewGroup viewGroup) {
        switch (rowItem.mo657a()) {
            case SHIPPING_OPTION:
                return m18999a(simplePaymentsComponentCallback, (ShippingOptionRowItem) rowItem, view, viewGroup);
            default:
                throw new IllegalArgumentException("Illegal row type " + rowItem.mo657a());
        }
    }

    private static ShippingOptionRowItemView m18999a(SimplePaymentsComponentCallback simplePaymentsComponentCallback, ShippingOptionRowItem shippingOptionRowItem, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new ShippingOptionRowItemView(viewGroup.getContext());
        } else {
            ShippingOptionRowItemView shippingOptionRowItemView = (ShippingOptionRowItemView) view;
        }
        view.setPaymentsComponentCallback(simplePaymentsComponentCallback);
        view.f19037b.setVisibility(shippingOptionRowItem.f19034b ? 0 : 8);
        view.f19036a.setText(shippingOptionRowItem.f19033a);
        view.f19038c = shippingOptionRowItem.f19035c;
        return view;
    }
}
