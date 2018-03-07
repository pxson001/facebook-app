package com.facebook.graphql.enums;

/* compiled from: graphql_subscriptions_subscribe */
public enum GraphQLStoryTimestampStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    BACKDATED,
    CREATED,
    DELEGATE,
    NONE;

    public static GraphQLStoryTimestampStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("BACKDATED")) {
            return BACKDATED;
        }
        if (str.equalsIgnoreCase("CREATED")) {
            return CREATED;
        }
        if (str.equalsIgnoreCase("DELEGATE")) {
            return DELEGATE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
