package com.facebook.payments.paymentmethods.picker.model;

import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParams;
import com.facebook.payments.picker.model.RowItem;
import com.facebook.payments.picker.model.RowType;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: blurry_video */
public class PaymentMethodRowItem implements RowItem {
    public final PaymentMethod f18841a;
    public final boolean f18842b;
    public final PickerScreenCommonParams f18843c;

    public PaymentMethodRowItem(PaymentMethod paymentMethod, boolean z, PickerScreenCommonParams pickerScreenCommonParams) {
        this.f18841a = paymentMethod;
        this.f18842b = z;
        this.f18843c = pickerScreenCommonParams;
    }

    public final RowType mo657a() {
        return RowType.EXISTING_PAYMENT_METHOD;
    }
}
