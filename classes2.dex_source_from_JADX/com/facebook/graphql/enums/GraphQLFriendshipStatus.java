package com.facebook.graphql.enums;

/* compiled from: m. */
public enum GraphQLFriendshipStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    CANNOT_REQUEST,
    ARE_FRIENDS,
    INCOMING_REQUEST,
    OUTGOING_REQUEST,
    CAN_REQUEST;

    public static GraphQLFriendshipStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("CANNOT_REQUEST")) {
            return CANNOT_REQUEST;
        }
        if (str.equalsIgnoreCase("ARE_FRIENDS")) {
            return ARE_FRIENDS;
        }
        if (str.equalsIgnoreCase("INCOMING_REQUEST")) {
            return INCOMING_REQUEST;
        }
        if (str.equalsIgnoreCase("OUTGOING_REQUEST")) {
            return OUTGOING_REQUEST;
        }
        if (str.equalsIgnoreCase("CAN_REQUEST")) {
            return CAN_REQUEST;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
