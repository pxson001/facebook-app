package com.facebook.graphql.enums;

/* compiled from: mIsCheckin */
public enum GraphQLPageAdminReplyType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ACTIVITY_REPLY,
    COMMERCE_LINK,
    COMMERCE_UNLINK;

    public static GraphQLPageAdminReplyType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ACTIVITY_REPLY")) {
            return ACTIVITY_REPLY;
        }
        if (str.equalsIgnoreCase("COMMERCE_LINK")) {
            return COMMERCE_LINK;
        }
        if (str.equalsIgnoreCase("COMMERCE_UNLINK")) {
            return COMMERCE_UNLINK;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
