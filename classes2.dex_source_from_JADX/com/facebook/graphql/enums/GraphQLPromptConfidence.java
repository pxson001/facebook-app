package com.facebook.graphql.enums;

/* compiled from: network_info_app_backgrounded */
public enum GraphQLPromptConfidence {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    VERY_LOW,
    LOW,
    NEUTRAL,
    HIGH,
    VERY_HIGH;

    public static GraphQLPromptConfidence fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("VERY_LOW")) {
            return VERY_LOW;
        }
        if (str.equalsIgnoreCase("LOW")) {
            return LOW;
        }
        if (str.equalsIgnoreCase("NEUTRAL")) {
            return NEUTRAL;
        }
        if (str.equalsIgnoreCase("HIGH")) {
            return HIGH;
        }
        if (str.equalsIgnoreCase("VERY_HIGH")) {
            return VERY_HIGH;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
