package com.facebook.graphql.enums;

/* compiled from: mFirstName */
public enum GraphQLPageInfoFieldStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    LINE,
    PARAGRAPH;

    public static GraphQLPageInfoFieldStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("LINE")) {
            return LINE;
        }
        if (str.equalsIgnoreCase("PARAGRAPH")) {
            return PARAGRAPH;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
