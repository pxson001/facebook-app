package com.facebook.graphql.enums;

/* compiled from: member_summary */
public enum GraphQLAdproLimitResetPeriod {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    DAY,
    WEEK,
    MONTH,
    LIFETIME,
    NA;

    public static GraphQLAdproLimitResetPeriod fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("DAY")) {
            return DAY;
        }
        if (str.equalsIgnoreCase("WEEK")) {
            return WEEK;
        }
        if (str.equalsIgnoreCase("MONTH")) {
            return MONTH;
        }
        if (str.equalsIgnoreCase("LIFETIME")) {
            return LIFETIME;
        }
        if (str.equalsIgnoreCase("NA")) {
            return NA;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
