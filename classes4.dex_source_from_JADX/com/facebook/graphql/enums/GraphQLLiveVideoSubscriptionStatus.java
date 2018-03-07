package com.facebook.graphql.enums;

/* compiled from: img_hash */
public enum GraphQLLiveVideoSubscriptionStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ALL,
    SOME,
    OFF;

    public static GraphQLLiveVideoSubscriptionStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ALL")) {
            return ALL;
        }
        if (str.equalsIgnoreCase("SOME")) {
            return SOME;
        }
        if (str.equalsIgnoreCase("OFF")) {
            return OFF;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
