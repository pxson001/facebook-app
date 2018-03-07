package com.facebook.graphql.enums;

/* compiled from: m_unfriend_interstitial */
public enum GraphQLFriendsLocationsFeedType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NEARBY,
    TRAVELING,
    NEARBY_WHILE_TRAVELING,
    FRIENDS_VISITING_HOMETOWN,
    COMBINED,
    PULSE;

    public static GraphQLFriendsLocationsFeedType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("COMBINED")) {
            return COMBINED;
        }
        if (str.equalsIgnoreCase("NEARBY")) {
            return NEARBY;
        }
        if (str.equalsIgnoreCase("TRAVELING")) {
            return TRAVELING;
        }
        if (str.equalsIgnoreCase("NEARBY_WHILE_TRAVELING")) {
            return NEARBY_WHILE_TRAVELING;
        }
        if (str.equalsIgnoreCase("FRIENDS_VISITING_HOMETOWN")) {
            return FRIENDS_VISITING_HOMETOWN;
        }
        if (str.equalsIgnoreCase("PULSE")) {
            return PULSE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
