package com.facebook.graphql.enums;

/* compiled from: mark not set */
public enum GraphQLEventActionStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    DEFAULT_STYLE,
    SHARE_SEND,
    SEND,
    SHARE,
    INVITE;

    public static GraphQLEventActionStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("DEFAULT_STYLE")) {
            return DEFAULT_STYLE;
        }
        if (str.equalsIgnoreCase("SHARE_SEND")) {
            return SHARE_SEND;
        }
        if (str.equalsIgnoreCase("INVITE")) {
            return INVITE;
        }
        if (str.equalsIgnoreCase("SEND")) {
            return SEND;
        }
        if (str.equalsIgnoreCase("SHARE")) {
            return SHARE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
