package com.facebook.graphql.enums;

/* compiled from: mOnScrollChangedListener */
public enum GraphQLMessengerPlatformMediaType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    JPG,
    PNG,
    GIF,
    WEBP,
    MP4,
    WEBM;

    public static GraphQLMessengerPlatformMediaType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("JPG")) {
            return JPG;
        }
        if (str.equalsIgnoreCase("PNG")) {
            return PNG;
        }
        if (str.equalsIgnoreCase("GIF")) {
            return GIF;
        }
        if (str.equalsIgnoreCase("WEBP")) {
            return WEBP;
        }
        if (str.equalsIgnoreCase("MP4")) {
            return MP4;
        }
        if (str.equalsIgnoreCase("WEBM")) {
            return WEBM;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
