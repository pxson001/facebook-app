package com.facebook.graphql.enums;

/* compiled from: link_style */
public enum GraphQLTimelineContactItemType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    PHONE,
    ADDRESS,
    EMAIL;

    public static GraphQLTimelineContactItemType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("PHONE")) {
            return PHONE;
        }
        if (str.equalsIgnoreCase("ADDRESS")) {
            return ADDRESS;
        }
        if (str.equalsIgnoreCase("EMAIL")) {
            return EMAIL;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
