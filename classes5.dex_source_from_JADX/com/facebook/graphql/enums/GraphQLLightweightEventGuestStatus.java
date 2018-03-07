package com.facebook.graphql.enums;

/* compiled from: mSecondaryButtonIntentUrl */
public enum GraphQLLightweightEventGuestStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    GOING,
    INVITED,
    DECLINED;

    public static GraphQLLightweightEventGuestStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("GOING")) {
            return GOING;
        }
        if (str.equalsIgnoreCase("INVITED")) {
            return INVITED;
        }
        if (str.equalsIgnoreCase("DECLINED")) {
            return DECLINED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
