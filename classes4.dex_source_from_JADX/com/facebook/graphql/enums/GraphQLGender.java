package com.facebook.graphql.enums;

/* compiled from: img_height */
public enum GraphQLGender {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    UNKNOWN,
    FEMALE,
    MALE;

    public static GraphQLGender fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("UNKNOWN")) {
            return UNKNOWN;
        }
        if (str.equalsIgnoreCase("FEMALE")) {
            return FEMALE;
        }
        if (str.equalsIgnoreCase("MALE")) {
            return MALE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
