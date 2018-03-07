package com.facebook.graphql.enums;

/* compiled from: low_engagement_deduplication_keys */
public enum GraphQLPrivateReplyStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ALREADY_REPLIED,
    EXPIRED,
    NOT_USER_CREATED,
    RECIPIENT_FILTER,
    REPLYABLE,
    CANNOT_MESSAGE;

    public static GraphQLPrivateReplyStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ALREADY_REPLIED")) {
            return ALREADY_REPLIED;
        }
        if (str.equalsIgnoreCase("CANNOT_MESSAGE")) {
            return CANNOT_MESSAGE;
        }
        if (str.equalsIgnoreCase("EXPIRED")) {
            return EXPIRED;
        }
        if (str.equalsIgnoreCase("NOT_USER_CREATED")) {
            return NOT_USER_CREATED;
        }
        if (str.equalsIgnoreCase("RECIPIENT_FILTER")) {
            return RECIPIENT_FILTER;
        }
        if (str.equalsIgnoreCase("REPLYABLE")) {
            return REPLYABLE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
