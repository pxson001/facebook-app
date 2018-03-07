package com.facebook.graphql.enums;

/* compiled from: mapping */
public enum GraphQLEventPromotionStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    BANNER_IMAGE;

    public static GraphQLEventPromotionStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("BANNER_IMAGE")) {
            return BANNER_IMAGE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
