package com.facebook.graphql.enums;

/* compiled from: mUseViewLifecycleInFragment */
public enum GraphQLImageSizingStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    CONTAIN_FIT,
    COVER_FILL,
    COVER_FILL_CROPPED;

    public static GraphQLImageSizingStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("CONTAIN_FIT")) {
            return CONTAIN_FIT;
        }
        if (str.equalsIgnoreCase("COVER_FILL")) {
            return COVER_FILL;
        }
        if (str.equalsIgnoreCase("COVER_FILL_CROPPED")) {
            return COVER_FILL_CROPPED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
