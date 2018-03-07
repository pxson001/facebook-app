package com.facebook.graphql.enums;

/* compiled from: mLearnMoreUrl */
public enum GraphQLNotifOptionRenderType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SWIPE,
    CHEVRON,
    TODAY_RICH,
    NATIVE_SETTING;

    public static GraphQLNotifOptionRenderType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("SWIPE")) {
            return SWIPE;
        }
        if (str.equalsIgnoreCase("CHEVRON")) {
            return CHEVRON;
        }
        if (str.equalsIgnoreCase("TODAY_RICH")) {
            return TODAY_RICH;
        }
        if (str.equalsIgnoreCase("NATIVE_SETTING")) {
            return NATIVE_SETTING;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
