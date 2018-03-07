package com.facebook.graphql.enums;

/* compiled from: maybe */
public enum GraphQLDocumentAuthorStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    AUTO,
    TEXT,
    IMAGE;

    public static GraphQLDocumentAuthorStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("AUTO")) {
            return AUTO;
        }
        if (str.equalsIgnoreCase("TEXT")) {
            return TEXT;
        }
        if (str.equalsIgnoreCase("IMAGE")) {
            return IMAGE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
