package com.facebook.graphql.enums;

/* compiled from: match_words */
public enum GraphQLDocumentVideoControlStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    CONTROLS,
    NO_CONTROLS;

    public static GraphQLDocumentVideoControlStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("CONTROLS")) {
            return CONTROLS;
        }
        if (str.equalsIgnoreCase("NO_CONTROLS")) {
            return NO_CONTROLS;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
