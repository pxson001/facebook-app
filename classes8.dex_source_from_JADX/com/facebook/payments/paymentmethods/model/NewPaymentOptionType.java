package com.facebook.payments.paymentmethods.model;

import com.facebook.common.hasvalue.HasValue;
import com.facebook.common.hasvalue.HasValueUtil;
import com.facebook.infer.annotation.PrivacySource;
import com.google.common.base.MoreObjects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: suggested_member_order_param */
public enum NewPaymentOptionType implements HasValue<String> {
    NEW_CREDIT_CARD("new_cc"),
    NEW_MANUAL_TRANSFER("manual_transfer"),
    NEW_NET_BANKING("net_banking"),
    NEW_PAYPAL("paypal"),
    NEW_PAY_OVER_COUNTER("pay_over_counter"),
    UNKNOWN("unknown");
    
    private final String mValue;

    private NewPaymentOptionType(String str) {
        this.mValue = str;
    }

    @PrivacySource
    public static NewPaymentOptionType forValue(String str) {
        return (NewPaymentOptionType) MoreObjects.firstNonNull(HasValueUtil.a(values(), str), UNKNOWN);
    }

    public final String getValue() {
        return this.mValue;
    }
}
