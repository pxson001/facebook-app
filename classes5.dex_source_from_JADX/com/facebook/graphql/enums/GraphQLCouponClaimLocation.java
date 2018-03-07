package com.facebook.graphql.enums;

/* compiled from: mcss_agree */
public enum GraphQLCouponClaimLocation {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    INSTORE_ONLY,
    INSTORE_AND_ONLINE,
    ONLINE_ONLY;

    public static GraphQLCouponClaimLocation fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("INSTORE_ONLY")) {
            return INSTORE_ONLY;
        }
        if (str.equalsIgnoreCase("INSTORE_AND_ONLINE")) {
            return INSTORE_AND_ONLINE;
        }
        if (str.equalsIgnoreCase("ONLINE_ONLY")) {
            return ONLINE_ONLY;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
