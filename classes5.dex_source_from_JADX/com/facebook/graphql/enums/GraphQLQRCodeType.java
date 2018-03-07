package com.facebook.graphql.enums;

/* compiled from: loggingId= */
public enum GraphQLQRCodeType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    PERSONAL_USER,
    PAGE,
    GROUP,
    EVENT,
    EVENT_TICKET;

    public static GraphQLQRCodeType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("PERSONAL_USER")) {
            return PERSONAL_USER;
        }
        if (str.equalsIgnoreCase("PAGE")) {
            return PAGE;
        }
        if (str.equalsIgnoreCase("GROUP")) {
            return GROUP;
        }
        if (str.equalsIgnoreCase("EVENT")) {
            return EVENT;
        }
        if (str.equalsIgnoreCase("EVENT_TICKET")) {
            return EVENT_TICKET;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
