package com.facebook.payments.paymentmethods.picker;

import com.facebook.payments.decorator.PaymentsDecoratorParams;
import com.facebook.payments.paymentmethods.model.PaymentMethod;

/* compiled from: bookmark_count_string */
public class PickerScreenStyleParamsBuilder {
    public PaymentsDecoratorParams f18814a;
    public PaymentMethod f18815b;

    public final PickerScreenStyleParamsBuilder m18826a(PaymentMethod paymentMethod) {
        this.f18815b = paymentMethod;
        return this;
    }

    public final PickerScreenStyleParams m18827c() {
        return new PickerScreenStyleParams(this);
    }
}
