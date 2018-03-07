package com.facebook.graphql.enums;

/* compiled from: m_jewel */
public enum GraphQLGraphSearchSpellerConfidence {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    DID_YOU_MEAN,
    INCLUDING,
    SHOWING;

    public static GraphQLGraphSearchSpellerConfidence fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("DID_YOU_MEAN")) {
            return DID_YOU_MEAN;
        }
        if (str.equalsIgnoreCase("INCLUDING")) {
            return INCLUDING;
        }
        if (str.equalsIgnoreCase("SHOWING")) {
            return SHOWING;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
