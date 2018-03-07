package com.facebook.graphql.enums;

/* compiled from: mMinWidth */
public enum GraphQLMobilePaymentOption {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    CREDIT_CARD,
    PAYPAL;

    public static GraphQLMobilePaymentOption fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("CREDIT_CARD")) {
            return CREDIT_CARD;
        }
        if (str.equalsIgnoreCase("PAYPAL")) {
            return PAYPAL;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
