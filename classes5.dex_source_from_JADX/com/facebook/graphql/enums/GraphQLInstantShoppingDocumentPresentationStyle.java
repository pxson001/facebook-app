package com.facebook.graphql.enums;

/* compiled from: mStartTime */
public enum GraphQLInstantShoppingDocumentPresentationStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    AUDIO_CONTROL_FLOATING,
    AUDIO_MUTED;

    public static GraphQLInstantShoppingDocumentPresentationStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("AUDIO_CONTROL_FLOATING")) {
            return AUDIO_CONTROL_FLOATING;
        }
        if (str.equalsIgnoreCase("AUDIO_MUTED")) {
            return AUDIO_MUTED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
