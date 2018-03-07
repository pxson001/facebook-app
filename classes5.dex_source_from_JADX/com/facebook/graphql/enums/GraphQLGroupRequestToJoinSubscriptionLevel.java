package com.facebook.graphql.enums;

/* compiled from: mXedLocation */
public enum GraphQLGroupRequestToJoinSubscriptionLevel {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ON,
    OFF;

    public static GraphQLGroupRequestToJoinSubscriptionLevel fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ON")) {
            return ON;
        }
        if (str.equalsIgnoreCase("OFF")) {
            return OFF;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
