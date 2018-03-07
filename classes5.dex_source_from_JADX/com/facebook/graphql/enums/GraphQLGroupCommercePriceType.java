package com.facebook.graphql.enums;

/* compiled from: m_friend_suggestions */
public enum GraphQLGroupCommercePriceType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    FIXED,
    NEGOTIABLE;

    public static GraphQLGroupCommercePriceType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("FIXED")) {
            return FIXED;
        }
        if (str.equalsIgnoreCase("NEGOTIABLE")) {
            return NEGOTIABLE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
