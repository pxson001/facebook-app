package com.facebook.graphql.enums;

/* compiled from: mAttemptCount */
public enum GraphQLPlaceOpenStatusType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    OPEN_NOW,
    OPEN_NOW_CLOSING_SOON,
    OPEN_SOON,
    OPEN_VERY_SOON,
    OPEN_LATER,
    OPEN_LATER_TOM,
    OPEN_SAMEDAY_NEXTWEEK,
    NO_STATUS,
    OPEN_ALWAYS,
    DAY_WORKING_HOURS;

    public static GraphQLPlaceOpenStatusType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("OPEN_NOW")) {
            return OPEN_NOW;
        }
        if (str.equalsIgnoreCase("OPEN_NOW_CLOSING_SOON")) {
            return OPEN_NOW_CLOSING_SOON;
        }
        if (str.equalsIgnoreCase("OPEN_SOON")) {
            return OPEN_SOON;
        }
        if (str.equalsIgnoreCase("OPEN_VERY_SOON")) {
            return OPEN_VERY_SOON;
        }
        if (str.equalsIgnoreCase("OPEN_LATER")) {
            return OPEN_LATER;
        }
        if (str.equalsIgnoreCase("OPEN_LATER_TOM")) {
            return OPEN_LATER_TOM;
        }
        if (str.equalsIgnoreCase("OPEN_SAMEDAY_NEXTWEEK")) {
            return OPEN_SAMEDAY_NEXTWEEK;
        }
        if (str.equalsIgnoreCase("NO_STATUS")) {
            return NO_STATUS;
        }
        if (str.equalsIgnoreCase("OPEN_ALWAYS")) {
            return OPEN_ALWAYS;
        }
        if (str.equalsIgnoreCase("DAY_WORKING_HOURS")) {
            return DAY_WORKING_HOURS;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
