package com.facebook.graphql.enums;

/* compiled from: m_chain_friend_request */
public enum GraphQLGroupPostPermissionSetting {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    ADMIN_ONLY,
    ANYONE;

    public static GraphQLGroupPostPermissionSetting fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("ADMIN_ONLY")) {
            return ADMIN_ONLY;
        }
        if (str.equalsIgnoreCase("ANYONE")) {
            return ANYONE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
