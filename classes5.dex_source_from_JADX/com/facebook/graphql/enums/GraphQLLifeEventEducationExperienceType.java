package com.facebook.graphql.enums;

/* compiled from: mSecondaryButtonOverrideBackOnly */
public enum GraphQLLifeEventEducationExperienceType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    HIGHSCHOOL,
    COLLEGE;

    public static GraphQLLifeEventEducationExperienceType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("HIGHSCHOOL")) {
            return HIGHSCHOOL;
        }
        if (str.equalsIgnoreCase("COLLEGE")) {
            return COLLEGE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
