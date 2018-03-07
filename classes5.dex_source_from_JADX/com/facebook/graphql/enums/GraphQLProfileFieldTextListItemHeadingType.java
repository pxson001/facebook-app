package com.facebook.graphql.enums;

/* compiled from: logout_bar_menu */
public enum GraphQLProfileFieldTextListItemHeadingType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    HIGH,
    MEDIUM,
    LOW;

    public static GraphQLProfileFieldTextListItemHeadingType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("HIGH")) {
            return HIGH;
        }
        if (str.equalsIgnoreCase("MEDIUM")) {
            return MEDIUM;
        }
        if (str.equalsIgnoreCase("LOW")) {
            return LOW;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
