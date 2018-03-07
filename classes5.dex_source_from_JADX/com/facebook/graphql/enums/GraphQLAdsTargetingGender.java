package com.facebook.graphql.enums;

/* compiled from: member_add_undo */
public enum GraphQLAdsTargetingGender {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ALL,
    MALE,
    FEMALE;

    public static GraphQLAdsTargetingGender fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ALL")) {
            return ALL;
        }
        if (str.equalsIgnoreCase("MALE")) {
            return MALE;
        }
        if (str.equalsIgnoreCase("FEMALE")) {
            return FEMALE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
