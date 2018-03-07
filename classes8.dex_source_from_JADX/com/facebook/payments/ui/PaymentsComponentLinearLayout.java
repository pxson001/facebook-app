package com.facebook.payments.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: subtitle_style */
public class PaymentsComponentLinearLayout extends CustomLinearLayout implements PaymentsComponentView {
    @Nullable
    public SimplePaymentsComponentCallback f1954a;

    public PaymentsComponentLinearLayout(Context context) {
        super(context);
    }

    public PaymentsComponentLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PaymentsComponentLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setPaymentsComponentCallback(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
        this.f1954a = simplePaymentsComponentCallback;
    }

    public final void m2185a(PaymentsComponentAction paymentsComponentAction) {
        this.f1954a.mo79a(paymentsComponentAction);
    }
}
