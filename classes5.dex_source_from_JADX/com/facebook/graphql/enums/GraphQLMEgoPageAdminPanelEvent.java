package com.facebook.graphql.enums;

/* compiled from: mReplacer */
public enum GraphQLMEgoPageAdminPanelEvent {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    IMPRESSION,
    VIEW,
    CLICK,
    XOUT,
    BID_GENERATION;

    public static GraphQLMEgoPageAdminPanelEvent fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("BID_GENERATION")) {
            return BID_GENERATION;
        }
        if (str.equalsIgnoreCase("IMPRESSION")) {
            return IMPRESSION;
        }
        if (str.equalsIgnoreCase("VIEW")) {
            return VIEW;
        }
        if (str.equalsIgnoreCase("CLICK")) {
            return CLICK;
        }
        if (str.equalsIgnoreCase("XOUT")) {
            return XOUT;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
