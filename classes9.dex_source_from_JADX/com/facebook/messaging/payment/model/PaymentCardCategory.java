package com.facebook.messaging.payment.model;

import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: id mismatch */
public enum PaymentCardCategory {
    DEBIT_CARD(Optional.of(Integer.valueOf(2131240085))),
    CREDIT_CARD(Optional.of(Integer.valueOf(2131240086))),
    UNKNOWN(Absent.INSTANCE);
    
    public final Optional<Integer> cardType;

    private PaymentCardCategory(Optional<Integer> optional) {
        this.cardType = optional;
    }

    public static PaymentCardCategory fromString(String str) {
        for (PaymentCardCategory paymentCardCategory : values()) {
            if (paymentCardCategory.name().equalsIgnoreCase(str)) {
                return paymentCardCategory;
            }
        }
        return UNKNOWN;
    }
}
