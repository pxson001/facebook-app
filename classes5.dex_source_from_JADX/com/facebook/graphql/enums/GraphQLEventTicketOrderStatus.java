package com.facebook.graphql.enums;

/* compiled from: map_style */
public enum GraphQLEventTicketOrderStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    RESERVED,
    PURCHASED,
    REFUNDED,
    FAILED,
    TIMED_OUT;

    public static GraphQLEventTicketOrderStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("RESERVED")) {
            return RESERVED;
        }
        if (str.equalsIgnoreCase("PURCHASED")) {
            return PURCHASED;
        }
        if (str.equalsIgnoreCase("REFUNDED")) {
            return REFUNDED;
        }
        if (str.equalsIgnoreCase("FAILED")) {
            return FAILED;
        }
        if (str.equalsIgnoreCase("TIMED_OUT")) {
            return TIMED_OUT;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
