package com.facebook.graphql.enums;

/* compiled from: opengl_version */
public enum GraphQLConnectionStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    RSVP,
    INTERESTED;

    public static GraphQLConnectionStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("RSVP")) {
            return RSVP;
        }
        if (str.equalsIgnoreCase("INTERESTED")) {
            return INTERESTED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
