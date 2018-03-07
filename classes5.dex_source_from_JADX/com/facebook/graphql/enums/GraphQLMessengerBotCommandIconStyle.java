package com.facebook.graphql.enums;

/* compiled from: mPrimaryButtonAction */
public enum GraphQLMessengerBotCommandIconStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SQUARE,
    CIRCLE;

    public static GraphQLMessengerBotCommandIconStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("SQUARE")) {
            return SQUARE;
        }
        if (str.equalsIgnoreCase("CIRCLE")) {
            return CIRCLE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
