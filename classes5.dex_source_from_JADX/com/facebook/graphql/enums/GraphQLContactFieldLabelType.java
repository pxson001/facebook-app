package com.facebook.graphql.enums;

/* compiled from: me/interstitials/%s */
public enum GraphQLContactFieldLabelType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    MOBILE,
    HOME,
    WORK,
    HOME_FAX,
    WORK_FAX,
    OTHER;

    public static GraphQLContactFieldLabelType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("MOBILE")) {
            return MOBILE;
        }
        if (str.equalsIgnoreCase("HOME")) {
            return HOME;
        }
        if (str.equalsIgnoreCase("WORK")) {
            return WORK;
        }
        if (str.equalsIgnoreCase("HOME_FAX")) {
            return HOME_FAX;
        }
        if (str.equalsIgnoreCase("WORK_FAX")) {
            return WORK_FAX;
        }
        if (str.equalsIgnoreCase("OTHER")) {
            return OTHER;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
