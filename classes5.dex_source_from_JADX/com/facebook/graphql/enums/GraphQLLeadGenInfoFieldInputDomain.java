package com.facebook.graphql.enums;

/* compiled from: mSessionCookiesString */
public enum GraphQLLeadGenInfoFieldInputDomain {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    EMAIL,
    PHONE;

    public static GraphQLLeadGenInfoFieldInputDomain fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("EMAIL")) {
            return EMAIL;
        }
        if (str.equalsIgnoreCase("PHONE")) {
            return PHONE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
