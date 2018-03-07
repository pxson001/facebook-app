package com.facebook.graphql.enums;

/* compiled from: media_question_type */
public enum GraphQLBeaconScanResultConfidenceLevel {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    CONFIDENCE_LOW,
    CONFIDENCE_MEDIUM,
    CONFIDENCE_HIGH;

    public static GraphQLBeaconScanResultConfidenceLevel fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("CONFIDENCE_LOW")) {
            return CONFIDENCE_LOW;
        }
        if (str.equalsIgnoreCase("CONFIDENCE_MEDIUM")) {
            return CONFIDENCE_MEDIUM;
        }
        if (str.equalsIgnoreCase("CONFIDENCE_HIGH")) {
            return CONFIDENCE_HIGH;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
