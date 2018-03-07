package com.facebook.graphql.enums;

/* compiled from: margins */
public enum GraphQLEventNotificationSubscriptionLevel {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ALL,
    MOST_IMPORTANT,
    HOST_ONLY,
    UNSUBSCRIBED;

    public static GraphQLEventNotificationSubscriptionLevel fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ALL")) {
            return ALL;
        }
        if (str.equalsIgnoreCase("MOST_IMPORTANT")) {
            return MOST_IMPORTANT;
        }
        if (str.equalsIgnoreCase("HOST_ONLY")) {
            return HOST_ONLY;
        }
        if (str.equalsIgnoreCase("UNSUBSCRIBED")) {
            return UNSUBSCRIBED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
