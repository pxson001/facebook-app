package com.facebook.graphql.enums;

/* compiled from: m_friend_requests_page */
public enum GraphQLGroupContentRestrictionReason {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    CANNOT_SEE_CONTENT,
    CONNECTION_UNSAFE,
    LOGIN_APPROVALS_REQUIRED,
    INTERNAL_GROUPS_DISABLED,
    UNKNOWN;

    public static GraphQLGroupContentRestrictionReason fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("CANNOT_SEE_CONTENT")) {
            return CANNOT_SEE_CONTENT;
        }
        if (str.equalsIgnoreCase("CONNECTION_UNSAFE")) {
            return CONNECTION_UNSAFE;
        }
        if (str.equalsIgnoreCase("LOGIN_APPROVALS_REQUIRED")) {
            return LOGIN_APPROVALS_REQUIRED;
        }
        if (str.equalsIgnoreCase("INTERNAL_GROUPS_DISABLED")) {
            return INTERNAL_GROUPS_DISABLED;
        }
        if (str.equalsIgnoreCase("UNKNOWN")) {
            return UNKNOWN;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
