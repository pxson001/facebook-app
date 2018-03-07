package com.facebook.graphql.enums;

/* compiled from: location_id */
public enum GraphQLReactionProfileBadgeType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    GOING,
    INTERESTED,
    MAYBE;

    public static GraphQLReactionProfileBadgeType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("GOING")) {
            return GOING;
        }
        if (str.equalsIgnoreCase("INTERESTED")) {
            return INTERESTED;
        }
        if (str.equalsIgnoreCase("MAYBE")) {
            return MAYBE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
