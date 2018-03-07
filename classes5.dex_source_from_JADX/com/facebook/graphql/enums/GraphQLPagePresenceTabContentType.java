package com.facebook.graphql.enums;

/* compiled from: mDetailText */
public enum GraphQLPagePresenceTabContentType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    CUSTOM,
    REACTION_SURFACE;

    public static GraphQLPagePresenceTabContentType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("CUSTOM")) {
            return CUSTOM;
        }
        if (str.equalsIgnoreCase("REACTION_SURFACE")) {
            return REACTION_SURFACE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
