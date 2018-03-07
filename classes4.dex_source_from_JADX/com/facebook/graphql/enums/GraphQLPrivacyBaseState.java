package com.facebook.graphql.enums;

/* compiled from: small_audience_privacy_nux */
public enum GraphQLPrivacyBaseState {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    EVERYONE,
    FRIENDS,
    FRIENDS_OF_FRIENDS,
    SELF;

    public static GraphQLPrivacyBaseState fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("EVERYONE")) {
            return EVERYONE;
        }
        if (str.equalsIgnoreCase("FRIENDS")) {
            return FRIENDS;
        }
        if (str.equalsIgnoreCase("FRIENDS_OF_FRIENDS")) {
            return FRIENDS_OF_FRIENDS;
        }
        if (str.equalsIgnoreCase("SELF")) {
            return SELF;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
