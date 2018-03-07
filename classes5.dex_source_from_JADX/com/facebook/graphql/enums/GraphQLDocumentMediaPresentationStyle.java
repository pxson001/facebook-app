package com.facebook.graphql.enums;

/* compiled from: max-width */
public enum GraphQLDocumentMediaPresentationStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ASPECT_FIT,
    FULL_SCREEN,
    ASPECT_FILL,
    ASPECT_FIT_ONLY,
    NON_INTERACTIVE;

    public static GraphQLDocumentMediaPresentationStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ASPECT_FIT")) {
            return ASPECT_FIT;
        }
        if (str.equalsIgnoreCase("FULL_SCREEN")) {
            return FULL_SCREEN;
        }
        if (str.equalsIgnoreCase("ASPECT_FILL")) {
            return ASPECT_FILL;
        }
        if (str.equalsIgnoreCase("ASPECT_FIT_ONLY")) {
            return ASPECT_FIT_ONLY;
        }
        if (str.equalsIgnoreCase("NON_INTERACTIVE")) {
            return NON_INTERACTIVE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
