package com.facebook.graphql.enums;

/* compiled from: mCursor= */
public enum GraphQLPageProductTransactionPaymentTypeEnum {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    UNSPECIFIED,
    PAY_IN_PERSON,
    BANK_TRANSFER,
    CUSTOM,
    NATIVE;

    public static GraphQLPageProductTransactionPaymentTypeEnum fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("UNSPECIFIED")) {
            return UNSPECIFIED;
        }
        if (str.equalsIgnoreCase("PAY_IN_PERSON")) {
            return PAY_IN_PERSON;
        }
        if (str.equalsIgnoreCase("BANK_TRANSFER")) {
            return BANK_TRANSFER;
        }
        if (str.equalsIgnoreCase("CUSTOM")) {
            return CUSTOM;
        }
        if (str.equalsIgnoreCase("NATIVE")) {
            return NATIVE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
