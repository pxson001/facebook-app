package com.facebook.graphql.enums;

/* compiled from: local_content */
public enum GraphQLRedSpaceUserAttributeType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SUGGESTED;

    public static GraphQLRedSpaceUserAttributeType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("SUGGESTED")) {
            return SUGGESTED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
