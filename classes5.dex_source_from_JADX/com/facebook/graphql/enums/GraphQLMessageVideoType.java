package com.facebook.graphql.enums;

/* compiled from: mPrimaryButtonStep */
public enum GraphQLMessageVideoType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    FILE_ATTACHMENT,
    RECORDED_VIDEO,
    SPEAKING_STICKER;

    public static GraphQLMessageVideoType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("FILE_ATTACHMENT")) {
            return FILE_ATTACHMENT;
        }
        if (str.equalsIgnoreCase("RECORDED_VIDEO")) {
            return RECORDED_VIDEO;
        }
        if (str.equalsIgnoreCase("SPEAKING_STICKER")) {
            return SPEAKING_STICKER;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
