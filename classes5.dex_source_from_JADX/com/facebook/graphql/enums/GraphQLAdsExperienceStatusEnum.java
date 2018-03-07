package com.facebook.graphql.enums;

/* compiled from: member_list */
public enum GraphQLAdsExperienceStatusEnum {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    OFF,
    ACTIVE;

    public static GraphQLAdsExperienceStatusEnum fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("OFF")) {
            return OFF;
        }
        if (str.equalsIgnoreCase("ACTIVE")) {
            return ACTIVE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
