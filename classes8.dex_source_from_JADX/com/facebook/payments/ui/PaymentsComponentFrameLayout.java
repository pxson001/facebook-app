package com.facebook.payments.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: sublist_count */
public class PaymentsComponentFrameLayout extends CustomFrameLayout implements PaymentsComponentView {
    @Nullable
    private SimplePaymentsComponentCallback f1976a;

    public PaymentsComponentFrameLayout(Context context) {
        super(context);
    }

    public PaymentsComponentFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PaymentsComponentFrameLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setPaymentsComponentCallback(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
        this.f1976a = simplePaymentsComponentCallback;
    }
}
