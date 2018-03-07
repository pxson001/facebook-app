package com.facebook.graphql.enums;

/* compiled from: listImage */
public enum GraphQLTextAnnotationPresentationStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    REGULAR,
    LARGE,
    MEDIUM,
    EXTRA_LARGE;

    public static GraphQLTextAnnotationPresentationStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("REGULAR")) {
            return REGULAR;
        }
        if (str.equalsIgnoreCase("LARGE")) {
            return LARGE;
        }
        if (str.equalsIgnoreCase("MEDIUM")) {
            return MEDIUM;
        }
        if (str.equalsIgnoreCase("EXTRA_LARGE")) {
            return EXTRA_LARGE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
