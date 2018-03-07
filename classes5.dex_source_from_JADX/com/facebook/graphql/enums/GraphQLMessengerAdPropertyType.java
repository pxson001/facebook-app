package com.facebook.graphql.enums;

/* compiled from: mPrimaryButtonIntentUrl */
public enum GraphQLMessengerAdPropertyType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    OFFSITE_AD;

    public static GraphQLMessengerAdPropertyType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("OFFSITE_AD")) {
            return OFFSITE_AD;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
