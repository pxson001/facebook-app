package com.facebook.graphql.enums;

/* compiled from: mSessionKey */
public enum GraphQLLeadGenContextPageContentStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    LIST_STYLE,
    PARAGRAPH_STYLE;

    public static GraphQLLeadGenContextPageContentStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("LIST_STYLE")) {
            return LIST_STYLE;
        }
        if (str.equalsIgnoreCase("PARAGRAPH_STYLE")) {
            return PARAGRAPH_STYLE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
