package com.facebook.payments.shipping.addresspicker;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.picker.RowItemViewFactory;
import com.facebook.payments.picker.SimpleRowItemViewFactory;
import com.facebook.payments.picker.model.RowItem;
import com.facebook.payments.shipping.model.ShippingAddressRowItem;
import com.facebook.payments.shipping.model.ShippingSource;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import javax.inject.Inject;

/* compiled from: backstage_whitelisted_friends */
public final class ShippingRowItemViewFactory implements RowItemViewFactory {
    private final SimpleRowItemViewFactory f18908a;

    public static ShippingRowItemViewFactory m18914b(InjectorLike injectorLike) {
        return new ShippingRowItemViewFactory(SimpleRowItemViewFactory.m18891a(injectorLike));
    }

    @Inject
    public ShippingRowItemViewFactory(SimpleRowItemViewFactory simpleRowItemViewFactory) {
        this.f18908a = simpleRowItemViewFactory;
    }

    public final View mo651a(SimplePaymentsComponentCallback simplePaymentsComponentCallback, RowItem rowItem, View view, ViewGroup viewGroup) {
        switch (rowItem.mo657a()) {
            case SHIPPING_ADDRESS:
                return m18913a(simplePaymentsComponentCallback, (ShippingAddressRowItem) rowItem, view, viewGroup);
            case ADD_SHIPPING_ADDRESS:
                return m18912a(simplePaymentsComponentCallback, (AddShippingAddressRowItem) rowItem, view, viewGroup);
            case SINGLE_ROW_DIVIDER:
            case SECURITY_FOOTER:
                return this.f18908a.mo651a(simplePaymentsComponentCallback, rowItem, view, viewGroup);
            default:
                throw new IllegalArgumentException("Illegal row type " + rowItem.mo657a());
        }
    }

    private static ShippingAddressRowItemView m18913a(SimplePaymentsComponentCallback simplePaymentsComponentCallback, ShippingAddressRowItem shippingAddressRowItem, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new ShippingAddressRowItemView(viewGroup.getContext());
        } else {
            ShippingAddressRowItemView shippingAddressRowItemView = (ShippingAddressRowItemView) view;
        }
        view.setPaymentsComponentCallback(simplePaymentsComponentCallback);
        view.f18892c = shippingAddressRowItem;
        if (view.f18892c.f18981a == ShippingSource.CHECKOUT && shippingAddressRowItem.f18985e) {
            view.f18891b.setVisibility(0);
        } else {
            view.f18891b.setVisibility(8);
        }
        view.f18890a.setHint(view.f18892c.f18986f.mo766f());
        view.f18890a.setText(shippingAddressRowItem.f18984d);
        return view;
    }

    private static AddShippingAddressRowItemView m18912a(SimplePaymentsComponentCallback simplePaymentsComponentCallback, AddShippingAddressRowItem addShippingAddressRowItem, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new AddShippingAddressRowItemView(viewGroup.getContext());
        } else {
            AddShippingAddressRowItemView addShippingAddressRowItemView = (AddShippingAddressRowItemView) view;
        }
        view.setPaymentsComponentCallback(simplePaymentsComponentCallback);
        view.f18888a = addShippingAddressRowItem;
        view.setOnClickListener(view);
        return view;
    }
}
