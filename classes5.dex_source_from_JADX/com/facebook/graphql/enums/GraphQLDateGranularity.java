package com.facebook.graphql.enums;

/* compiled from: mbasic_feed_share_like_chaining */
public enum GraphQLDateGranularity {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    YEAR,
    MONTH,
    DAY,
    HOUR,
    MIN;

    public static GraphQLDateGranularity fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("YEAR")) {
            return YEAR;
        }
        if (str.equalsIgnoreCase("MONTH")) {
            return MONTH;
        }
        if (str.equalsIgnoreCase("DAY")) {
            return DAY;
        }
        if (str.equalsIgnoreCase("HOUR")) {
            return HOUR;
        }
        if (str.equalsIgnoreCase("MIN")) {
            return MIN;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
