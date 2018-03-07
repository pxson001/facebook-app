package com.facebook.graphql.enums;

/* compiled from: media_store_id */
public enum GraphQLAudioAnnotationPlayMode {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    AMBIENT,
    ON_EXPAND,
    NORMAL;

    public static GraphQLAudioAnnotationPlayMode fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("AMBIENT")) {
            return AMBIENT;
        }
        if (str.equalsIgnoreCase("ON_EXPAND")) {
            return ON_EXPAND;
        }
        if (str.equalsIgnoreCase("NORMAL")) {
            return NORMAL;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
