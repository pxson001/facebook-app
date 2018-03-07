package com.facebook.graphql.enums;

/* compiled from: mEventId */
public enum GraphQLPageLeadGenInfoState {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    UNREAD,
    READ,
    RESPONDED;

    public static GraphQLPageLeadGenInfoState fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("UNREAD")) {
            return UNREAD;
        }
        if (str.equalsIgnoreCase("READ")) {
            return READ;
        }
        if (str.equalsIgnoreCase("RESPONDED")) {
            return RESPONDED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
