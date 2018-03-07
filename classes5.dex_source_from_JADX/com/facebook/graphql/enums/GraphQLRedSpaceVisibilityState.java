package com.facebook.graphql.enums;

/* compiled from: local_bounds */
public enum GraphQLRedSpaceVisibilityState {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NOT_REDSPACE_POST,
    REDSPACE_ONLY;

    public static GraphQLRedSpaceVisibilityState fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NOT_REDSPACE_POST")) {
            return NOT_REDSPACE_POST;
        }
        if (str.equalsIgnoreCase("REDSPACE_ONLY")) {
            return REDSPACE_ONLY;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
