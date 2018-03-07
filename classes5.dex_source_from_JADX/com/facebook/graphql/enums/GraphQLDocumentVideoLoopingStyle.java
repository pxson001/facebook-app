package com.facebook.graphql.enums;

/* compiled from: match_page_id */
public enum GraphQLDocumentVideoLoopingStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NO_LOOPING,
    LOOPING,
    LOOPING_WITH_CROSS_FADE;

    public static GraphQLDocumentVideoLoopingStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NO_LOOPING")) {
            return NO_LOOPING;
        }
        if (str.equalsIgnoreCase("LOOPING")) {
            return LOOPING;
        }
        if (str.equalsIgnoreCase("LOOPING_WITH_CROSS_FADE")) {
            return LOOPING_WITH_CROSS_FADE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
