package com.facebook.graphql.enums;

/* compiled from: mapImage */
public enum GraphQLEventVisibility {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    FRIENDS_OF_FRIENDS,
    FRIENDS_OF_GUESTS,
    GROUP,
    INVITE_ONLY,
    PAGE,
    USER_PUBLIC,
    COMMUNITY;

    public static GraphQLEventVisibility fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("FRIENDS_OF_FRIENDS")) {
            return FRIENDS_OF_FRIENDS;
        }
        if (str.equalsIgnoreCase("FRIENDS_OF_GUESTS")) {
            return FRIENDS_OF_GUESTS;
        }
        if (str.equalsIgnoreCase("GROUP")) {
            return GROUP;
        }
        if (str.equalsIgnoreCase("INVITE_ONLY")) {
            return INVITE_ONLY;
        }
        if (str.equalsIgnoreCase("PAGE")) {
            return PAGE;
        }
        if (str.equalsIgnoreCase("USER_PUBLIC")) {
            return USER_PUBLIC;
        }
        if (str.equalsIgnoreCase("COMMUNITY")) {
            return COMMUNITY;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
