package com.facebook.graphql.enums;

/* compiled from: mPicSquare */
public enum GraphQLMessengerInbox2MessageThreadReason {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    UNREAD,
    STALE,
    INJECTED,
    PENDING;

    public static GraphQLMessengerInbox2MessageThreadReason fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("INJECTED")) {
            return INJECTED;
        }
        if (str.equalsIgnoreCase("PENDING")) {
            return PENDING;
        }
        if (str.equalsIgnoreCase("STALE")) {
            return STALE;
        }
        if (str.equalsIgnoreCase("UNREAD")) {
            return UNREAD;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
