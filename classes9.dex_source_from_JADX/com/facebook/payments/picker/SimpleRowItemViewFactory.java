package com.facebook.payments.picker;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.picker.model.PickerSecurityRowItem;
import com.facebook.payments.picker.model.RowItem;
import com.facebook.payments.picker.model.RowType;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;

/* compiled from: battery_life */
public final class SimpleRowItemViewFactory implements RowItemViewFactory {
    public static SimpleRowItemViewFactory m18891a(InjectorLike injectorLike) {
        return new SimpleRowItemViewFactory();
    }

    public final View mo651a(SimplePaymentsComponentCallback simplePaymentsComponentCallback, RowItem rowItem, View view, ViewGroup viewGroup) {
        switch (rowItem.mo657a()) {
            case SECURITY_FOOTER:
                return m18889a((PickerSecurityRowItem) rowItem, simplePaymentsComponentCallback, view, viewGroup);
            case SINGLE_ROW_DIVIDER:
            case SPACED_DOUBLE_ROW_DIVIDER:
                return m18890a(rowItem, view, viewGroup);
            case HEADER:
                return m18892b(rowItem, view, viewGroup);
            default:
                throw new IllegalArgumentException("Illegal row type " + rowItem.mo657a());
        }
    }

    private static View m18889a(PickerSecurityRowItem pickerSecurityRowItem, SimplePaymentsComponentCallback simplePaymentsComponentCallback, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new PickerSecurityRowItemView(viewGroup.getContext());
        } else {
            PickerSecurityRowItemView pickerSecurityRowItemView = (PickerSecurityRowItemView) view;
        }
        view.setPaymentsComponentCallback(simplePaymentsComponentCallback);
        view.f18882a.setPaymentsComponentCallback(view.f18883b);
        view.f18882a.setText(pickerSecurityRowItem.f18886a);
        view.f18882a.setLearnMoreUri(Uri.parse("https://m.facebook.com/payer_protection"));
        return view;
    }

    private static View m18890a(RowItem rowItem, View view, ViewGroup viewGroup) {
        if (view != null) {
            return view;
        }
        if (rowItem.mo657a() == RowType.SINGLE_ROW_DIVIDER) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(2130906237, viewGroup, false);
        }
        if (rowItem.mo657a() == RowType.SPACED_DOUBLE_ROW_DIVIDER) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(2130906238, viewGroup, false);
        }
        throw new IllegalArgumentException("Invalid rowType provided for divider: " + rowItem.mo657a());
    }

    private static View m18892b(RowItem rowItem, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new HeaderItemView(viewGroup.getContext());
        } else {
            HeaderItemView headerItemView = (HeaderItemView) view;
        }
        view.m18887a(rowItem);
        return view;
    }
}
