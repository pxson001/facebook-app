package com.facebook.graphql.enums;

/* compiled from: mOptinDeclineButtonText */
public enum GraphQLMessengerInboxUnitUpdateStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ALL_UPDATE,
    NO_UPDATE;

    public static GraphQLMessengerInboxUnitUpdateStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ALL_UPDATE")) {
            return ALL_UPDATE;
        }
        if (str.equalsIgnoreCase("NO_UPDATE")) {
            return NO_UPDATE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
