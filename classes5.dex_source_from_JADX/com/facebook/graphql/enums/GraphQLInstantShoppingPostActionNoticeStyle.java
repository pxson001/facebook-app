package com.facebook.graphql.enums;

/* compiled from: mSortOrder= */
public enum GraphQLInstantShoppingPostActionNoticeStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NOTICE,
    CONFIRMATION;

    public static GraphQLInstantShoppingPostActionNoticeStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NOTICE")) {
            return NOTICE;
        }
        if (str.equalsIgnoreCase("CONFIRMATION")) {
            return CONFIRMATION;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
