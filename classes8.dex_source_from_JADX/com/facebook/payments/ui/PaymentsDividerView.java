package com.facebook.payments.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.view.ViewGroup.LayoutParams;
import com.facebook.widget.CustomViewUtils;

/* compiled from: styleName */
public class PaymentsDividerView extends PaymentsComponentLinearLayout {
    public PaymentsDividerView(Context context) {
        super(context);
        setOrientation(1);
        setLayoutParams(new LayoutParams(-1, getResources().getDimensionPixelOffset(2131429259)));
        CustomViewUtils.b(this, new ColorDrawable(ContextCompat.b(getContext(), 2131362846)));
    }
}
