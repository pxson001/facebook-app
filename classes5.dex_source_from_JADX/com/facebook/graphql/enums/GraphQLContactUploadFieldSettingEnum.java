package com.facebook.graphql.enums;

/* compiled from: mcss_unsure */
public enum GraphQLContactUploadFieldSettingEnum {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    MINIMAL,
    EXTENDED;

    public static GraphQLContactUploadFieldSettingEnum fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("MINIMAL")) {
            return MINIMAL;
        }
        if (str.equalsIgnoreCase("EXTENDED")) {
            return EXTENDED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
