package com.facebook.graphql.enums;

/* compiled from: mDialogDisplayMap contained negative value for context */
public enum GraphQLPagePhotoSourceType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    PHOTOS_BY_PAGE,
    PHOTOS_OF_PAGE,
    PHOTOS_AT_PAGE;

    public static GraphQLPagePhotoSourceType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("PHOTOS_BY_PAGE")) {
            return PHOTOS_BY_PAGE;
        }
        if (str.equalsIgnoreCase("PHOTOS_OF_PAGE")) {
            return PHOTOS_OF_PAGE;
        }
        if (str.equalsIgnoreCase("PHOTOS_AT_PAGE")) {
            return PHOTOS_AT_PAGE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
