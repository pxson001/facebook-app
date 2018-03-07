package com.facebook.payments.decorator;

import com.facebook.payments.ui.titlebar.PaymentsTitleBarStyle;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: target_query */
public enum PaymentsActivitySource {
    CHECKOUT(PaymentsTitleBarStyle.PAYMENTS_WHITE),
    OTHER(PaymentsTitleBarStyle.DEFAULT);
    
    private final PaymentsTitleBarStyle mTitleBarStyle;

    private PaymentsActivitySource(PaymentsTitleBarStyle paymentsTitleBarStyle) {
        this.mTitleBarStyle = paymentsTitleBarStyle;
    }

    public final PaymentsTitleBarStyle getTitleBarStyle() {
        return this.mTitleBarStyle;
    }
}
