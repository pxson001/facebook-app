package com.facebook.graphql.enums;

/* compiled from: is_IS */
public enum GraphQLVideoStatusType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ENCODING,
    DELETED,
    ENCODED,
    SCRUB_FAILED,
    UPLOADING,
    OK,
    TOO_LONG,
    ENCODE_FAILED,
    UNPUBLISHED,
    SOFT_DELETED,
    UNDISCOVERABLE,
    THUMBNAIL_INVALID,
    UPLOAD_FAILED,
    UPLOADED;

    public static GraphQLVideoStatusType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ENCODING")) {
            return ENCODING;
        }
        if (str.equalsIgnoreCase("DELETED")) {
            return DELETED;
        }
        if (str.equalsIgnoreCase("ENCODED")) {
            return ENCODED;
        }
        if (str.equalsIgnoreCase("SCRUB_FAILED")) {
            return SCRUB_FAILED;
        }
        if (str.equalsIgnoreCase("UPLOADING")) {
            return UPLOADING;
        }
        if (str.equalsIgnoreCase("OK")) {
            return OK;
        }
        if (str.equalsIgnoreCase("TOO_LONG")) {
            return TOO_LONG;
        }
        if (str.equalsIgnoreCase("ENCODE_FAILED")) {
            return ENCODE_FAILED;
        }
        if (str.equalsIgnoreCase("UNPUBLISHED")) {
            return UNPUBLISHED;
        }
        if (str.equalsIgnoreCase("SOFT_DELETED")) {
            return SOFT_DELETED;
        }
        if (str.equalsIgnoreCase("UNDISCOVERABLE")) {
            return UNDISCOVERABLE;
        }
        if (str.equalsIgnoreCase("THUMBNAIL_INVALID")) {
            return THUMBNAIL_INVALID;
        }
        if (str.equalsIgnoreCase("UPLOAD_FAILED")) {
            return UPLOAD_FAILED;
        }
        if (str.equalsIgnoreCase("UPLOADED")) {
            return UPLOADED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
