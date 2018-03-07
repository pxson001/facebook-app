package com.facebook.graphql.enums;

/* compiled from: mStartDate */
public enum GraphQLInstantShoppingHeaderElementType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    CHECKOUT,
    SAVE,
    IMAGE;

    public static GraphQLInstantShoppingHeaderElementType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("CHECKOUT")) {
            return CHECKOUT;
        }
        if (str.equalsIgnoreCase("SAVE")) {
            return SAVE;
        }
        if (str.equalsIgnoreCase("IMAGE")) {
            return IMAGE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
