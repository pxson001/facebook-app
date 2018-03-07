package com.facebook.graphql.enums;

/* compiled from: mOptinDeclineButtonCancelText */
public enum GraphQLMessengerPayThemeAssetCompatibilityEnum {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ANDROID,
    IPHONE_4,
    IPHONE_5,
    IPHONE_6,
    IPHONE_6_PLUS,
    IPHONE;

    public static GraphQLMessengerPayThemeAssetCompatibilityEnum fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ANDROID")) {
            return ANDROID;
        }
        if (str.equalsIgnoreCase("IPHONE_4")) {
            return IPHONE_4;
        }
        if (str.equalsIgnoreCase("IPHONE_5")) {
            return IPHONE_5;
        }
        if (str.equalsIgnoreCase("IPHONE_6")) {
            return IPHONE_6;
        }
        if (str.equalsIgnoreCase("IPHONE_6_PLUS")) {
            return IPHONE_6_PLUS;
        }
        if (str.equalsIgnoreCase("IPHONE")) {
            return IPHONE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
