package com.facebook.graphql.enums;

/* compiled from: mediaFbIds */
public enum GraphQLCommerceProductVisibility {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    VISIBLE,
    MERCHANT_NOT_ENABLED,
    MERCHANT_NOT_APPROVED,
    PRODUCT_NOT_PUBLISHED,
    PRODUCT_IN_REVIEW,
    PRODUCT_PRICE_TOO_LOW,
    PRODUCT_REJECTED,
    MERCHANT_NOT_ONBOARDED;

    public static GraphQLCommerceProductVisibility fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("VISIBLE")) {
            return VISIBLE;
        }
        if (str.equalsIgnoreCase("MERCHANT_NOT_ENABLED")) {
            return MERCHANT_NOT_ENABLED;
        }
        if (str.equalsIgnoreCase("MERCHANT_NOT_APPROVED")) {
            return MERCHANT_NOT_APPROVED;
        }
        if (str.equalsIgnoreCase("PRODUCT_NOT_PUBLISHED")) {
            return PRODUCT_NOT_PUBLISHED;
        }
        if (str.equalsIgnoreCase("PRODUCT_IN_REVIEW")) {
            return PRODUCT_IN_REVIEW;
        }
        if (str.equalsIgnoreCase("PRODUCT_PRICE_TOO_LOW")) {
            return PRODUCT_PRICE_TOO_LOW;
        }
        if (str.equalsIgnoreCase("PRODUCT_REJECTED")) {
            return PRODUCT_REJECTED;
        }
        if (str.equalsIgnoreCase("MERCHANT_NOT_ONBOARDED")) {
            return MERCHANT_NOT_ONBOARDED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
