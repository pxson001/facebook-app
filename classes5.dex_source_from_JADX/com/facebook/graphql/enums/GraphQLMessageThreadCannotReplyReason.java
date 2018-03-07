package com.facebook.graphql.enums;

/* compiled from: mPrimaryButtonText */
public enum GraphQLMessageThreadCannotReplyReason {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    BLOCKED,
    HAS_EMAIL_PARTICIPANT,
    OBJECT_ORIGINATED,
    READ_ONLY,
    VIEWER_NOT_SUBSCRIBED,
    RECIPIENTS_NOT_LOADABLE,
    RECIPIENTS_UNAVAILABLE,
    RECIPIENTS_INVALID,
    RECIPIENTS_INACTIVE_WORK_ACC,
    MONTAGE_NOT_AUTHOR;

    public static GraphQLMessageThreadCannotReplyReason fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("BLOCKED")) {
            return BLOCKED;
        }
        if (str.equalsIgnoreCase("HAS_EMAIL_PARTICIPANT")) {
            return HAS_EMAIL_PARTICIPANT;
        }
        if (str.equalsIgnoreCase("OBJECT_ORIGINATED")) {
            return OBJECT_ORIGINATED;
        }
        if (str.equalsIgnoreCase("READ_ONLY")) {
            return READ_ONLY;
        }
        if (str.equalsIgnoreCase("VIEWER_NOT_SUBSCRIBED")) {
            return VIEWER_NOT_SUBSCRIBED;
        }
        if (str.equalsIgnoreCase("RECIPIENTS_NOT_LOADABLE")) {
            return RECIPIENTS_NOT_LOADABLE;
        }
        if (str.equalsIgnoreCase("RECIPIENTS_UNAVAILABLE")) {
            return RECIPIENTS_UNAVAILABLE;
        }
        if (str.equalsIgnoreCase("RECIPIENTS_INVALID")) {
            return RECIPIENTS_INVALID;
        }
        if (str.equalsIgnoreCase("RECIPIENTS_INACTIVE_WORK_ACC")) {
            return RECIPIENTS_INACTIVE_WORK_ACC;
        }
        if (str.equalsIgnoreCase("MONTAGE_NOT_AUTHOR")) {
            return MONTAGE_NOT_AUTHOR;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
