package com.facebook.graphql.enums;

/* compiled from: matching_message */
public enum GraphQLDocumentVideoAutoplayStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    AUTOPLAY,
    NO_AUTOPLAY;

    public static GraphQLDocumentVideoAutoplayStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("AUTOPLAY")) {
            return AUTOPLAY;
        }
        if (str.equalsIgnoreCase("NO_AUTOPLAY")) {
            return NO_AUTOPLAY;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
