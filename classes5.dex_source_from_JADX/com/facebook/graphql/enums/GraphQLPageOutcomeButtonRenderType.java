package com.facebook.graphql.enums;

/* compiled from: mEndDate */
public enum GraphQLPageOutcomeButtonRenderType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ICON_ONLY,
    ICON_AND_TEXT,
    TEXT;

    public static GraphQLPageOutcomeButtonRenderType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ICON_ONLY")) {
            return ICON_ONLY;
        }
        if (str.equalsIgnoreCase("ICON_AND_TEXT")) {
            return ICON_AND_TEXT;
        }
        if (str.equalsIgnoreCase("TEXT")) {
            return TEXT;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
