package com.facebook.graphql.enums;

/* compiled from: media_reference_token */
public enum GraphQLAvailablePhotoCategoryEnum {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ALL,
    FOOD,
    PLACE,
    PEOPLE,
    INDOOR;

    public static GraphQLAvailablePhotoCategoryEnum fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ALL")) {
            return ALL;
        }
        if (str.equalsIgnoreCase("FOOD")) {
            return FOOD;
        }
        if (str.equalsIgnoreCase("PLACE")) {
            return PLACE;
        }
        if (str.equalsIgnoreCase("PEOPLE")) {
            return PEOPLE;
        }
        if (str.equalsIgnoreCase("INDOOR")) {
            return INDOOR;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
