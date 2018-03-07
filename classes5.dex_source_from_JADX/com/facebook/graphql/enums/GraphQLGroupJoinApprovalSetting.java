package com.facebook.graphql.enums;

/* compiled from: m_find_friends */
public enum GraphQLGroupJoinApprovalSetting {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    ANYONE,
    ADMIN_ONLY,
    ADMIN_ONLY_ADD;

    public static GraphQLGroupJoinApprovalSetting fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("ANYONE")) {
            return ANYONE;
        }
        if (str.equalsIgnoreCase("ADMIN_ONLY")) {
            return ADMIN_ONLY;
        }
        if (str.equalsIgnoreCase("ADMIN_ONLY_ADD")) {
            return ADMIN_ONLY_ADD;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
