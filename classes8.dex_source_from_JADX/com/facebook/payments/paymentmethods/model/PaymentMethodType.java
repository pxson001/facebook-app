package com.facebook.payments.paymentmethods.model;

import com.facebook.common.hasvalue.HasValue;
import com.facebook.common.hasvalue.HasValueUtil;
import com.facebook.infer.annotation.PrivacySource;
import com.google.common.base.MoreObjects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: subtype */
public enum PaymentMethodType implements HasValue<String> {
    CREDIT_CARD("cc", NewPaymentOptionType.NEW_CREDIT_CARD),
    PAYPAL_BILLING_AGREEMENT("paypal_ba", NewPaymentOptionType.NEW_PAYPAL),
    MANUAL_TRANSFER("manual_transfer", NewPaymentOptionType.NEW_MANUAL_TRANSFER),
    NET_BANKING("net_banking", NewPaymentOptionType.NEW_NET_BANKING),
    PAY_OVER_COUNTER("pay_over_counter", NewPaymentOptionType.NEW_PAY_OVER_COUNTER),
    UNKNOWN("unknown", NewPaymentOptionType.UNKNOWN);
    
    private final NewPaymentOptionType mNewPaymentOptionType;
    private final String mValue;

    private PaymentMethodType(String str, NewPaymentOptionType newPaymentOptionType) {
        this.mValue = str;
        this.mNewPaymentOptionType = newPaymentOptionType;
    }

    public static PaymentMethodType forValue(String str) {
        return (PaymentMethodType) MoreObjects.firstNonNull(HasValueUtil.a(values(), str), UNKNOWN);
    }

    @PrivacySource
    public final String getValue() {
        return this.mValue;
    }

    public final NewPaymentOptionType toNewPaymentOptionType() {
        return this.mNewPaymentOptionType;
    }
}
