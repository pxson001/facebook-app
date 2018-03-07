package com.facebook.graphql.enums;

/* compiled from: media_captions */
public enum GraphQLCommercePageType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    COMMERCE_PAGE_TYPE_NONE,
    COMMERCE_PAGE_TYPE_BUSINESS,
    COMMERCE_PAGE_TYPE_AGENT,
    COMMERCE_PAGE_TYPE_AIRLINE,
    COMMERCE_PAGE_TYPE_RIDE_SHARE,
    COMMERCE_PAGE_TYPE_BANK;

    public static GraphQLCommercePageType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("COMMERCE_PAGE_TYPE_NONE")) {
            return COMMERCE_PAGE_TYPE_NONE;
        }
        if (str.equalsIgnoreCase("COMMERCE_PAGE_TYPE_BUSINESS")) {
            return COMMERCE_PAGE_TYPE_BUSINESS;
        }
        if (str.equalsIgnoreCase("COMMERCE_PAGE_TYPE_AGENT")) {
            return COMMERCE_PAGE_TYPE_AGENT;
        }
        if (str.equalsIgnoreCase("COMMERCE_PAGE_TYPE_AIRLINE")) {
            return COMMERCE_PAGE_TYPE_AIRLINE;
        }
        if (str.equalsIgnoreCase("COMMERCE_PAGE_TYPE_RIDE_SHARE")) {
            return COMMERCE_PAGE_TYPE_RIDE_SHARE;
        }
        if (str.equalsIgnoreCase("COMMERCE_PAGE_TYPE_BANK")) {
            return COMMERCE_PAGE_TYPE_BANK;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
