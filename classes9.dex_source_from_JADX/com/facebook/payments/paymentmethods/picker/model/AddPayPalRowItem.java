package com.facebook.payments.paymentmethods.picker.model;

import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParams;
import com.facebook.payments.picker.model.RowItem;
import com.facebook.payments.picker.model.RowType;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: bookmark and url are both null. */
public class AddPayPalRowItem implements RowItem {
    public final String f18834a;
    public final PaymentItemType f18835b;
    public final int f18836c;
    public final PickerScreenCommonParams f18837d;

    /* compiled from: bookmark and url are both null. */
    public class Builder {
        public String f18830a;
        public PaymentItemType f18831b;
        public int f18832c;
        public PickerScreenCommonParams f18833d;

        public final AddPayPalRowItem m18844e() {
            return new AddPayPalRowItem(this);
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public AddPayPalRowItem(Builder builder) {
        this.f18834a = builder.f18830a;
        this.f18835b = builder.f18831b;
        this.f18836c = builder.f18832c;
        this.f18837d = (PickerScreenCommonParams) Preconditions.checkNotNull(builder.f18833d);
    }

    public final RowType mo657a() {
        return RowType.ADD_PAYPAL;
    }
}
