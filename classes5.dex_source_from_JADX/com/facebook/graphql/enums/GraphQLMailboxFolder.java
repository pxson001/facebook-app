package com.facebook.graphql.enums;

/* compiled from: mProfilePictureUrls */
public enum GraphQLMailboxFolder {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    INBOX,
    SPAM,
    OTHER,
    PENDING,
    MONTAGE,
    HIDDEN,
    LEGACY;

    public static GraphQLMailboxFolder fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("INBOX")) {
            return INBOX;
        }
        if (str.equalsIgnoreCase("SPAM")) {
            return SPAM;
        }
        if (str.equalsIgnoreCase("OTHER")) {
            return OTHER;
        }
        if (str.equalsIgnoreCase("PENDING")) {
            return PENDING;
        }
        if (str.equalsIgnoreCase("MONTAGE")) {
            return MONTAGE;
        }
        if (str.equalsIgnoreCase("HIDDEN")) {
            return HIDDEN;
        }
        if (str.equalsIgnoreCase("LEGACY")) {
            return LEGACY;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
