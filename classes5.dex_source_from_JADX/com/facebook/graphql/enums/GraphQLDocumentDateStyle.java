package com.facebook.graphql.enums;

/* compiled from: may_exceed_count */
public enum GraphQLDocumentDateStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    MONTH_AND_DAY,
    MONTH_AND_YEAR,
    MONTH_DAY_YEAR,
    YEAR,
    MONTH_DAY_YEAR_TIME,
    DAY_TIME,
    MONTH,
    MONTH_DAY_TIME;

    public static GraphQLDocumentDateStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("MONTH_AND_DAY")) {
            return MONTH_AND_DAY;
        }
        if (str.equalsIgnoreCase("MONTH_AND_YEAR")) {
            return MONTH_AND_YEAR;
        }
        if (str.equalsIgnoreCase("MONTH_DAY_YEAR")) {
            return MONTH_DAY_YEAR;
        }
        if (str.equalsIgnoreCase("YEAR")) {
            return YEAR;
        }
        if (str.equalsIgnoreCase("MONTH_DAY_YEAR_TIME")) {
            return MONTH_DAY_YEAR_TIME;
        }
        if (str.equalsIgnoreCase("DAY_TIME")) {
            return DAY_TIME;
        }
        if (str.equalsIgnoreCase("MONTH")) {
            return MONTH;
        }
        if (str.equalsIgnoreCase("MONTH_DAY_TIME")) {
            return MONTH_DAY_TIME;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
