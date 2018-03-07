package com.facebook.graphql.enums;

/* compiled from: mMinHeight */
public enum GraphQLMomentsAppMessengerInviteActionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    INTENT_POSTBACK,
    INSTALL;

    public static GraphQLMomentsAppMessengerInviteActionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("INTENT_POSTBACK")) {
            return INTENT_POSTBACK;
        }
        if (str.equalsIgnoreCase("INSTALL")) {
            return INSTALL;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
