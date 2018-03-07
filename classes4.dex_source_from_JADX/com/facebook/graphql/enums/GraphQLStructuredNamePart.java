package com.facebook.graphql.enums;

/* compiled from: socialContext */
public enum GraphQLStructuredNamePart {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    FIRST,
    MIDDLE,
    LAST;

    public static GraphQLStructuredNamePart fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("first")) {
            return FIRST;
        }
        if (str.equalsIgnoreCase("middle")) {
            return MIDDLE;
        }
        if (str.equalsIgnoreCase("last")) {
            return LAST;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
