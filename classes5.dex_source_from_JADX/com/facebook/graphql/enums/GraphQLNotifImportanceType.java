package com.facebook.graphql.enums;

/* compiled from: mLegalDisclaimerText */
public enum GraphQLNotifImportanceType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    IMPORTANT,
    NOT_EVALUATED,
    NOT_IMPORTANT;

    public static GraphQLNotifImportanceType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("IMPORTANT")) {
            return IMPORTANT;
        }
        if (str.equalsIgnoreCase("NOT_EVALUATED")) {
            return NOT_EVALUATED;
        }
        if (str.equalsIgnoreCase("NOT_IMPORTANT")) {
            return NOT_IMPORTANT;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
