package com.facebook.graphql.enums;

/* compiled from: mImplicitLocationDisabledByUser */
public enum GraphQLPageCallToActionActionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    MESSENGER,
    PHONE_CALL,
    WEBSITE,
    LEAD_GEN,
    EMAIL,
    FIRST_PARTY;

    public static GraphQLPageCallToActionActionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("MESSENGER")) {
            return MESSENGER;
        }
        if (str.equalsIgnoreCase("PHONE_CALL")) {
            return PHONE_CALL;
        }
        if (str.equalsIgnoreCase("WEBSITE")) {
            return WEBSITE;
        }
        if (str.equalsIgnoreCase("LEAD_GEN")) {
            return LEAD_GEN;
        }
        if (str.equalsIgnoreCase("EMAIL")) {
            return EMAIL;
        }
        if (str.equalsIgnoreCase("FIRST_PARTY")) {
            return FIRST_PARTY;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
