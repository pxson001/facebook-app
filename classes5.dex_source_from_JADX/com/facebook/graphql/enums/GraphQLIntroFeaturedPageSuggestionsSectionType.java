package com.facebook.graphql.enums;

/* compiled from: mSessionSecret */
public enum GraphQLIntroFeaturedPageSuggestionsSectionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    CAUSES,
    INTERESTS,
    MOVIES,
    MUSIC,
    SPORTS,
    TV_SHOWS;

    public static GraphQLIntroFeaturedPageSuggestionsSectionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("CAUSES")) {
            return CAUSES;
        }
        if (str.equalsIgnoreCase("INTERESTS")) {
            return INTERESTS;
        }
        if (str.equalsIgnoreCase("MOVIES")) {
            return MOVIES;
        }
        if (str.equalsIgnoreCase("MUSIC")) {
            return MUSIC;
        }
        if (str.equalsIgnoreCase("SPORTS")) {
            return SPORTS;
        }
        if (str.equalsIgnoreCase("TV_SHOWS")) {
            return TV_SHOWS;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
