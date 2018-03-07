package com.facebook.graphql.enums;

/* compiled from: mMobileReceivedBytes */
public enum GraphQLMessengerRetailItemStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    CANCELED;

    public static GraphQLMessengerRetailItemStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("CANCELED")) {
            return CANCELED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
