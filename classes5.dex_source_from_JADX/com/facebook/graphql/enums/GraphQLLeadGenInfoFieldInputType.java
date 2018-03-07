package com.facebook.graphql.enums;

/* compiled from: mSelectionArgs= */
public enum GraphQLLeadGenInfoFieldInputType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    TEXT,
    INLINE_SELECT,
    SELECT,
    MESSENGER_CHECKBOX;

    public static GraphQLLeadGenInfoFieldInputType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("TEXT")) {
            return TEXT;
        }
        if (str.equalsIgnoreCase("INLINE_SELECT")) {
            return INLINE_SELECT;
        }
        if (str.equalsIgnoreCase("SELECT")) {
            return SELECT;
        }
        if (str.equalsIgnoreCase("MESSENGER_CHECKBOX")) {
            return MESSENGER_CHECKBOX;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
