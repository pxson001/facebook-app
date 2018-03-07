package com.facebook.graphql.enums;

/* compiled from: mListenerInfo */
public enum GraphQLNearbyFriendsNuxType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    DASHBOARD_UPSELL,
    NEARBY_FRIENDS_NUX,
    INFORMATIONAL_NUX;

    public static GraphQLNearbyFriendsNuxType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("DASHBOARD_UPSELL")) {
            return DASHBOARD_UPSELL;
        }
        if (str.equalsIgnoreCase("NEARBY_FRIENDS_NUX")) {
            return NEARBY_FRIENDS_NUX;
        }
        if (str.equalsIgnoreCase("INFORMATIONAL_NUX")) {
            return INFORMATIONAL_NUX;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
