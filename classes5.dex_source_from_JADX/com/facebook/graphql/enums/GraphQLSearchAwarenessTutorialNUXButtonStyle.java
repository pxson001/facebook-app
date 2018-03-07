package com.facebook.graphql.enums;

/* compiled from: live_viewer_count */
public enum GraphQLSearchAwarenessTutorialNUXButtonStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    DEFAULT,
    NEXT_BUTTON,
    HIDDEN_ON_FIRST_IMPRESSION;

    public static GraphQLSearchAwarenessTutorialNUXButtonStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("DEFAULT")) {
            return DEFAULT;
        }
        if (str.equalsIgnoreCase("NEXT_BUTTON")) {
            return NEXT_BUTTON;
        }
        if (str.equalsIgnoreCase("HIDDEN_ON_FIRST_IMPRESSION")) {
            return HIDDEN_ON_FIRST_IMPRESSION;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
