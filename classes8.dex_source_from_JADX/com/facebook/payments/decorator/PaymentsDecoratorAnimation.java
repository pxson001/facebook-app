package com.facebook.payments.decorator;

import com.facebook.payments.ui.titlebar.PaymentsTitleBarNavIconStyle;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: target_privacy_picker_visible */
public enum PaymentsDecoratorAnimation {
    MODAL_BOTTOM(PaymentsTitleBarNavIconStyle.CROSS),
    SLIDE_RIGHT(PaymentsTitleBarNavIconStyle.BACK_ARROW);
    
    private final PaymentsTitleBarNavIconStyle mTitleBarNavIconStyle;

    private PaymentsDecoratorAnimation(PaymentsTitleBarNavIconStyle paymentsTitleBarNavIconStyle) {
        this.mTitleBarNavIconStyle = paymentsTitleBarNavIconStyle;
    }

    public final PaymentsTitleBarNavIconStyle getTitleBarNavIconStyle() {
        return this.mTitleBarNavIconStyle;
    }
}
