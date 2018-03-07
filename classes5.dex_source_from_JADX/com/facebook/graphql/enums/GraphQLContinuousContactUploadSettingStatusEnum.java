package com.facebook.graphql.enums;

/* compiled from: mcss_disagree */
public enum GraphQLContinuousContactUploadSettingStatusEnum {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    DEFAULT,
    ON,
    OFF;

    public static GraphQLContinuousContactUploadSettingStatusEnum fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("DEFAULT")) {
            return DEFAULT;
        }
        if (str.equalsIgnoreCase("ON")) {
            return ON;
        }
        if (str.equalsIgnoreCase("OFF")) {
            return OFF;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
