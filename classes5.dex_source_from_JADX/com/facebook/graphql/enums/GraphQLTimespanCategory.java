package com.facebook.graphql.enums;

/* compiled from: link_icon_image */
public enum GraphQLTimespanCategory {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    WITHIN_MINUTES,
    WITHIN_HOUR,
    WITHIN_FEW_HOURS,
    WITHIN_A_DAY,
    LONGER_THAN_A_DAY,
    UNKNOWN;

    public static GraphQLTimespanCategory fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("WITHIN_MINUTES")) {
            return WITHIN_MINUTES;
        }
        if (str.equalsIgnoreCase("WITHIN_HOUR")) {
            return WITHIN_HOUR;
        }
        if (str.equalsIgnoreCase("WITHIN_FEW_HOURS")) {
            return WITHIN_FEW_HOURS;
        }
        if (str.equalsIgnoreCase("WITHIN_A_DAY")) {
            return WITHIN_A_DAY;
        }
        if (str.equalsIgnoreCase("LONGER_THAN_A_DAY")) {
            return LONGER_THAN_A_DAY;
        }
        if (str.equalsIgnoreCase("UNKNOWN")) {
            return UNKNOWN;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
