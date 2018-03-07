package com.facebook.graphql.enums;

/* compiled from: m_home */
public enum GraphQLGroupAdminType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    MODERATOR,
    ADMIN;

    public static GraphQLGroupAdminType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("MODERATOR")) {
            return MODERATOR;
        }
        if (str.equalsIgnoreCase("ADMIN")) {
            return ADMIN;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
