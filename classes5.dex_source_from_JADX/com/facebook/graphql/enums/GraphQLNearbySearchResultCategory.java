package com.facebook.graphql.enums;

/* compiled from: mLightweightPlacePickerSessionId */
public enum GraphQLNearbySearchResultCategory {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    PLACES,
    TOPICS,
    TOPICS_AND_REGION,
    QUERIES,
    REGIONS_ONLY;

    public static GraphQLNearbySearchResultCategory fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("PLACES")) {
            return PLACES;
        }
        if (str.equalsIgnoreCase("TOPICS")) {
            return TOPICS;
        }
        if (str.equalsIgnoreCase("TOPICS_AND_REGION")) {
            return TOPICS_AND_REGION;
        }
        if (str.equalsIgnoreCase("QUERIES")) {
            return QUERIES;
        }
        if (str.equalsIgnoreCase("REGIONS_ONLY")) {
            return REGIONS_ONLY;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
