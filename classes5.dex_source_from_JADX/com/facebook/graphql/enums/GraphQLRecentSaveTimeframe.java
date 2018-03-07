package com.facebook.graphql.enums;

/* compiled from: local_num_impressions */
public enum GraphQLRecentSaveTimeframe {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    PAST_WEEK,
    PAST_MONTH;

    public static GraphQLRecentSaveTimeframe fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("PAST_WEEK")) {
            return PAST_WEEK;
        }
        if (str.equalsIgnoreCase("PAST_MONTH")) {
            return PAST_MONTH;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
