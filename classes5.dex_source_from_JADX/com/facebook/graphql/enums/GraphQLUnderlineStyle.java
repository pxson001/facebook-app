package com.facebook.graphql.enums;

/* compiled from: link_description */
public enum GraphQLUnderlineStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    SIMPLE_UNDERLINE;

    public static GraphQLUnderlineStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("SIMPLE_UNDERLINE")) {
            return SIMPLE_UNDERLINE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
