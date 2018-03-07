package com.facebook.graphql.enums;

/* compiled from: logSource= */
public enum GraphQLReactionCoreButtonGlyphAlignment {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    TOP,
    BOTTOM,
    START,
    END;

    public static GraphQLReactionCoreButtonGlyphAlignment fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("TOP")) {
            return TOP;
        }
        if (str.equalsIgnoreCase("BOTTOM")) {
            return BOTTOM;
        }
        if (str.equalsIgnoreCase("START")) {
            return START;
        }
        if (str.equalsIgnoreCase("END")) {
            return END;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
