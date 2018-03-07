package com.facebook.graphql.enums;

/* compiled from: mSecondaryButtonStep */
public enum GraphQLLifeEventAPIIdentifier {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    MARRIED,
    ENGAGED,
    STARTED_JOB,
    GRADUATED,
    OTHER;

    public static GraphQLLifeEventAPIIdentifier fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("MARRIED")) {
            return MARRIED;
        }
        if (str.equalsIgnoreCase("ENGAGED")) {
            return ENGAGED;
        }
        if (str.equalsIgnoreCase("STARTED_JOB")) {
            return STARTED_JOB;
        }
        if (str.equalsIgnoreCase("GRADUATED")) {
            return GRADUATED;
        }
        if (str.equalsIgnoreCase("OTHER")) {
            return OTHER;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
