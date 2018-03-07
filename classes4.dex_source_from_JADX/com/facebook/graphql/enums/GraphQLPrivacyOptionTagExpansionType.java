package com.facebook.graphql.enums;

/* compiled from: sms-takeover/nux?context=%s */
public enum GraphQLPrivacyOptionTagExpansionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    TAGGEES,
    FRIENDS_OF_TAGGEES;

    public static GraphQLPrivacyOptionTagExpansionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("TAGGEES")) {
            return TAGGEES;
        }
        if (str.equalsIgnoreCase("FRIENDS_OF_TAGGEES")) {
            return FRIENDS_OF_TAGGEES;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
