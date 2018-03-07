package com.facebook.graphql.enums;

/* compiled from: member_request */
public enum GraphQLAdsApiPacingType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    STANDARD,
    DISABLED,
    DAY_PARTING,
    NO_PACING,
    PROBABILISTIC_PACING;

    public static GraphQLAdsApiPacingType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("STANDARD")) {
            return STANDARD;
        }
        if (str.equalsIgnoreCase("DISABLED")) {
            return DISABLED;
        }
        if (str.equalsIgnoreCase("DAY_PARTING")) {
            return DAY_PARTING;
        }
        if (str.equalsIgnoreCase("NO_PACING")) {
            return NO_PACING;
        }
        if (str.equalsIgnoreCase("PROBABILISTIC_PACING")) {
            return PROBABILISTIC_PACING;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
