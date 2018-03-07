package com.facebook.payments.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import com.facebook.widget.CustomViewGroup;
import javax.annotation.Nullable;

/* compiled from: subComponents */
public class PaymentsComponentViewGroup extends CustomViewGroup implements PaymentsComponentView {
    @Nullable
    private SimplePaymentsComponentCallback f1978a;

    public PaymentsComponentViewGroup(Context context) {
        super(context);
    }

    public PaymentsComponentViewGroup(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PaymentsComponentViewGroup(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setPaymentsComponentCallback(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
        this.f1978a = simplePaymentsComponentCallback;
    }

    public final void m2213a(Intent intent, int i) {
        this.f1978a.m1980a(intent, i);
    }

    public final void m2212a(Intent intent) {
        this.f1978a.mo82b(intent);
    }

    public final void m2215b(Intent intent, int i) {
        this.f1978a.m1985b(intent, i);
    }

    public final void m2214a(PaymentsComponentAction paymentsComponentAction) {
        this.f1978a.mo79a(paymentsComponentAction);
    }
}
