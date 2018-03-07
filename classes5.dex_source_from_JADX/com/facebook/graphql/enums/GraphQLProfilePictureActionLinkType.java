package com.facebook.graphql.enums;

/* compiled from: logo_uri */
public enum GraphQLProfilePictureActionLinkType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SINGLE_OVERLAY,
    SUGGESTED_OVERLAYS,
    UNIFIED_MEDIA_GALLERY,
    TEMPORARY,
    BIRTHDAY_WISHES;

    public static GraphQLProfilePictureActionLinkType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("SINGLE_OVERLAY")) {
            return SINGLE_OVERLAY;
        }
        if (str.equalsIgnoreCase("SUGGESTED_OVERLAYS")) {
            return SUGGESTED_OVERLAYS;
        }
        if (str.equalsIgnoreCase("UNIFIED_MEDIA_GALLERY")) {
            return UNIFIED_MEDIA_GALLERY;
        }
        if (str.equalsIgnoreCase("TEMPORARY")) {
            return TEMPORARY;
        }
        if (str.equalsIgnoreCase("BIRTHDAY_WISHES")) {
            return BIRTHDAY_WISHES;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
