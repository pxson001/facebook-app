package com.facebook.graphql.enums;

/* compiled from: isVoicemail */
public enum GraphQLSavedState {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NOT_SAVABLE,
    NOT_SAVED,
    SAVED,
    ARCHIVED;

    public static GraphQLSavedState fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NOT_SAVABLE")) {
            return NOT_SAVABLE;
        }
        if (str.equalsIgnoreCase("NOT_SAVED")) {
            return NOT_SAVED;
        }
        if (str.equalsIgnoreCase("SAVED")) {
            return SAVED;
        }
        if (str.equalsIgnoreCase("ARCHIVED")) {
            return ARCHIVED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
