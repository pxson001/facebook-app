package com.facebook.graphql.enums;

/* compiled from: lower_bound */
public enum GraphQLPrivacyCheckupActionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    DELETE_APP_ONLY,
    DELETE_APP_AND_POSTS,
    CHANGE_PRIVACY;

    public static GraphQLPrivacyCheckupActionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("DELETE_APP_ONLY")) {
            return DELETE_APP_ONLY;
        }
        if (str.equalsIgnoreCase("DELETE_APP_AND_POSTS")) {
            return DELETE_APP_AND_POSTS;
        }
        if (str.equalsIgnoreCase("CHANGE_PRIVACY")) {
            return CHANGE_PRIVACY;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
