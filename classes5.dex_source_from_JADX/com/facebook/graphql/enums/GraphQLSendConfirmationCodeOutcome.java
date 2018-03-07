package com.facebook.graphql.enums;

/* compiled from: live_video_broadcast_status_update_subscribe */
public enum GraphQLSendConfirmationCodeOutcome {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SUCCESS,
    UNKNOWN_ERROR,
    PHONE_NUMBER_ALREADY_VERIFIED,
    INVALID_PHONE_NUMBER,
    PHONE_USED_TOO_MUCH,
    PHONE_CALLING_TOO_MUCH,
    PHONE_CANNOT_REACH;

    public static GraphQLSendConfirmationCodeOutcome fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("SUCCESS")) {
            return SUCCESS;
        }
        if (str.equalsIgnoreCase("UNKNOWN_ERROR")) {
            return UNKNOWN_ERROR;
        }
        if (str.equalsIgnoreCase("PHONE_NUMBER_ALREADY_VERIFIED")) {
            return PHONE_NUMBER_ALREADY_VERIFIED;
        }
        if (str.equalsIgnoreCase("INVALID_PHONE_NUMBER")) {
            return INVALID_PHONE_NUMBER;
        }
        if (str.equalsIgnoreCase("PHONE_USED_TOO_MUCH")) {
            return PHONE_USED_TOO_MUCH;
        }
        if (str.equalsIgnoreCase("PHONE_CALLING_TOO_MUCH")) {
            return PHONE_CALLING_TOO_MUCH;
        }
        if (str.equalsIgnoreCase("PHONE_CANNOT_REACH")) {
            return PHONE_CANNOT_REACH;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
