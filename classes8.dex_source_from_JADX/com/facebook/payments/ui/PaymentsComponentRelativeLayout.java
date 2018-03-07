package com.facebook.payments.ui;

import android.content.Context;
import com.facebook.widget.CustomRelativeLayout;
import javax.annotation.Nullable;

/* compiled from: subject_id */
public class PaymentsComponentRelativeLayout extends CustomRelativeLayout implements PaymentsComponentView {
    @Nullable
    public SimplePaymentsComponentCallback f1977a;

    public PaymentsComponentRelativeLayout(Context context) {
        super(context);
    }

    public void setPaymentsComponentCallback(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
        this.f1977a = simplePaymentsComponentCallback;
    }
}
