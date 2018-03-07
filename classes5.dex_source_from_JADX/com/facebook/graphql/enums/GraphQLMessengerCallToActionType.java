package com.facebook.graphql.enums;

/* compiled from: mPlaceAttachmentRemoved */
public enum GraphQLMessengerCallToActionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    OPEN_NATIVE,
    OPEN_URL,
    OPEN_CANCEL_RIDE_MUTATION,
    POSTBACK,
    ACCOUNT_LINK;

    public static GraphQLMessengerCallToActionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("OPEN_NATIVE")) {
            return OPEN_NATIVE;
        }
        if (str.equalsIgnoreCase("OPEN_URL")) {
            return OPEN_URL;
        }
        if (str.equalsIgnoreCase("OPEN_CANCEL_RIDE_MUTATION")) {
            return OPEN_CANCEL_RIDE_MUTATION;
        }
        if (str.equalsIgnoreCase("POSTBACK")) {
            return POSTBACK;
        }
        if (str.equalsIgnoreCase("ACCOUNT_LINK")) {
            return ACCOUNT_LINK;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
