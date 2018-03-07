package com.facebook.graphql.enums;

/* compiled from: mOptinDeclineButtonConfirmText */
public enum GraphQLMessengerPYMMIconType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    DEFAULT_ICON,
    BIRTHDAY;

    public static GraphQLMessengerPYMMIconType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("DEFAULT_ICON")) {
            return DEFAULT_ICON;
        }
        if (str.equalsIgnoreCase("BIRTHDAY")) {
            return BIRTHDAY;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
