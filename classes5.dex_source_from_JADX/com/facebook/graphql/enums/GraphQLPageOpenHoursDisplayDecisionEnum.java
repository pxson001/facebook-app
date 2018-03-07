package com.facebook.graphql.enums;

/* compiled from: mEndTime */
public enum GraphQLPageOpenHoursDisplayDecisionEnum {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SHOW_AVAILABLE,
    SHOW_UNAVAILABLE,
    SHOW_UNDETERMINED,
    NO_SHOW;

    public static GraphQLPageOpenHoursDisplayDecisionEnum fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("SHOW_AVAILABLE")) {
            return SHOW_AVAILABLE;
        }
        if (str.equalsIgnoreCase("SHOW_UNAVAILABLE")) {
            return SHOW_UNAVAILABLE;
        }
        if (str.equalsIgnoreCase("SHOW_UNDETERMINED")) {
            return SHOW_UNDETERMINED;
        }
        if (str.equalsIgnoreCase("NO_SHOW")) {
            return NO_SHOW;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
