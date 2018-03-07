package com.facebook.graphql.enums;

/* compiled from: max_zoom */
public enum GraphQLDocumentElementMarginStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    AUTO,
    FULL_BLEED,
    COLUMN_WIDTH;

    public static GraphQLDocumentElementMarginStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("AUTO")) {
            return AUTO;
        }
        if (str.equalsIgnoreCase("FULL_BLEED")) {
            return FULL_BLEED;
        }
        if (str.equalsIgnoreCase("COLUMN_WIDTH")) {
            return COLUMN_WIDTH;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
