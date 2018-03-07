package com.facebook.graphql.enums;

/* compiled from: media_set */
public enum GraphQLAutoplaySettingEffective {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ON,
    OFF,
    WIFI_ONLY;

    public static GraphQLAutoplaySettingEffective fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ON")) {
            return ON;
        }
        if (str.equalsIgnoreCase("OFF")) {
            return OFF;
        }
        if (str.equalsIgnoreCase("WIFI_ONLY")) {
            return WIFI_ONLY;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
