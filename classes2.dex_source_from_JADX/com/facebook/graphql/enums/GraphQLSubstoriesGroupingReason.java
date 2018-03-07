package com.facebook.graphql.enums;

/* compiled from: group_feed_available_for_sale_type */
public enum GraphQLSubstoriesGroupingReason {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    CONTEXT,
    COMPACTNESS,
    POST_CHANNEL,
    BIRTHDAY;

    public static GraphQLSubstoriesGroupingReason fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("CONTEXT")) {
            return CONTEXT;
        }
        if (str.equalsIgnoreCase("COMPACTNESS")) {
            return COMPACTNESS;
        }
        if (str.equalsIgnoreCase("POST_CHANNEL")) {
            return POST_CHANNEL;
        }
        if (str.equalsIgnoreCase("BIRTHDAY")) {
            return BIRTHDAY;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
