package com.facebook.graphql.enums;

/* compiled from: mTitle */
public enum GraphQLInstantArticlePublishStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    DRAFT,
    LIVE;

    public static GraphQLInstantArticlePublishStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("DRAFT")) {
            return DRAFT;
        }
        if (str.equalsIgnoreCase("LIVE")) {
            return LIVE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
