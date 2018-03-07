package com.facebook.graphql.enums;

/* compiled from: m_friends */
public enum GraphQLGroupCategory {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    DECLINE_TO_STATE,
    FAMILY,
    ORGANIZATION,
    IDENTITY,
    PROFESSIONAL,
    INTEREST,
    GOAL,
    FORSALE,
    OTHER,
    COMPANY,
    NONE;

    public static GraphQLGroupCategory fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("DECLINE_TO_STATE")) {
            return DECLINE_TO_STATE;
        }
        if (str.equalsIgnoreCase("FAMILY")) {
            return FAMILY;
        }
        if (str.equalsIgnoreCase("ORGANIZATION")) {
            return ORGANIZATION;
        }
        if (str.equalsIgnoreCase("IDENTITY")) {
            return IDENTITY;
        }
        if (str.equalsIgnoreCase("PROFESSIONAL")) {
            return PROFESSIONAL;
        }
        if (str.equalsIgnoreCase("INTEREST")) {
            return INTEREST;
        }
        if (str.equalsIgnoreCase("GOAL")) {
            return GOAL;
        }
        if (str.equalsIgnoreCase("FORSALE")) {
            return FORSALE;
        }
        if (str.equalsIgnoreCase("OTHER")) {
            return OTHER;
        }
        if (str.equalsIgnoreCase("COMPANY")) {
            return COMPANY;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
