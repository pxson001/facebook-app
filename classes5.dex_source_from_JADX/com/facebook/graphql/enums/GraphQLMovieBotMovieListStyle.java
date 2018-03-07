package com.facebook.graphql.enums;

/* compiled from: mMarketplaceId */
public enum GraphQLMovieBotMovieListStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    FLAT,
    GROUPED_BY_DATE;

    public static GraphQLMovieBotMovieListStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("FLAT")) {
            return FLAT;
        }
        if (str.equalsIgnoreCase("GROUPED_BY_DATE")) {
            return GROUPED_BY_DATE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
