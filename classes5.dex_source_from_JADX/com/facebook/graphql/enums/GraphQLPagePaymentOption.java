package com.facebook.graphql.enums;

/* compiled from: mDisplayName */
public enum GraphQLPagePaymentOption {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    VISA,
    CASH_ONLY,
    MASTERCARD,
    AMEX,
    DISCOVER,
    CREDIT_CARDS;

    public static GraphQLPagePaymentOption fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("VISA")) {
            return VISA;
        }
        if (str.equalsIgnoreCase("CASH_ONLY")) {
            return CASH_ONLY;
        }
        if (str.equalsIgnoreCase("MASTERCARD")) {
            return MASTERCARD;
        }
        if (str.equalsIgnoreCase("AMEX")) {
            return AMEX;
        }
        if (str.equalsIgnoreCase("DISCOVER")) {
            return DISCOVER;
        }
        if (str.equalsIgnoreCase("CREDIT_CARDS")) {
            return CREDIT_CARDS;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
