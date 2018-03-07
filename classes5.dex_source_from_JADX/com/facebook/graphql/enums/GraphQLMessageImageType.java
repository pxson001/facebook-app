package com.facebook.graphql.enums;

/* compiled from: mProductItemAttachment */
public enum GraphQLMessageImageType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    FILE_ATTACHMENT,
    MESSENGER_CAM,
    TRANSPARENT;

    public static GraphQLMessageImageType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("FILE_ATTACHMENT")) {
            return FILE_ATTACHMENT;
        }
        if (str.equalsIgnoreCase("MESSENGER_CAM")) {
            return MESSENGER_CAM;
        }
        if (str.equalsIgnoreCase("TRANSPARENT")) {
            return TRANSPARENT;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
