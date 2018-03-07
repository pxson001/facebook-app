package com.facebook.messaging.payment.value.input.picker;

import com.facebook.payments.paymentmethods.model.NewPaymentOption;
import com.facebook.payments.picker.model.RowItem;
import com.facebook.payments.picker.model.RowType;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: edit_dialog_open */
public class CommerceSimpleAddPaymentMethodRowItem implements RowItem {
    public final String f15847a;
    public final NewPaymentOption f15848b;
    public final int f15849c;

    public CommerceSimpleAddPaymentMethodRowItem(String str, NewPaymentOption newPaymentOption, int i) {
        this.f15847a = str;
        this.f15848b = newPaymentOption;
        this.f15849c = i;
    }

    public final RowType mo657a() {
        return RowType.COMMERCE_COMMERCE_SIMPLE_ADD_PAYMENT_METHOD;
    }
}
