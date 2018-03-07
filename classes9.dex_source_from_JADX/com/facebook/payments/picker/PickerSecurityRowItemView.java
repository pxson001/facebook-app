package com.facebook.payments.picker;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.payments.picker.model.PickerSecurityRowItem;
import com.facebook.payments.ui.PaymentsComponentView;
import com.facebook.payments.ui.PaymentsSecurityInfoView;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.facebook.widget.CustomViewGroup;

/* compiled from: battery_status */
public class PickerSecurityRowItemView extends CustomViewGroup implements RowItemView<PickerSecurityRowItem>, PaymentsComponentView {
    public PaymentsSecurityInfoView f18882a = ((PaymentsSecurityInfoView) LayoutInflater.from(getContext()).inflate(2130907796, this, false));
    public SimplePaymentsComponentCallback f18883b;

    public PickerSecurityRowItemView(Context context) {
        super(context);
        addView(this.f18882a);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131429252);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131429269);
        setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
    }

    public void setPaymentsComponentCallback(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
        this.f18883b = simplePaymentsComponentCallback;
    }

    public final void mo658a() {
    }
}
