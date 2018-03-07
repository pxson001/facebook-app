package com.facebook.graphql.enums;

/* compiled from: maxZoom */
public enum GraphQLDocumentListStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ORDERED,
    UNORDERED;

    public static GraphQLDocumentListStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ORDERED")) {
            return ORDERED;
        }
        if (str.equalsIgnoreCase("UNORDERED")) {
            return UNORDERED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
