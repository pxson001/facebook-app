package com.facebook.graphql.enums;

/* compiled from: map_points */
public enum GraphQLEventTicketProviderType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    UNKNOWN,
    NONE,
    PRIMARY,
    OFFICIAL,
    RESALE;

    public static GraphQLEventTicketProviderType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("UNKNOWN")) {
            return UNKNOWN;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("PRIMARY")) {
            return PRIMARY;
        }
        if (str.equalsIgnoreCase("OFFICIAL")) {
            return OFFICIAL;
        }
        if (str.equalsIgnoreCase("RESALE")) {
            return RESALE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
