package com.facebook.graphql.enums;

/* compiled from: media_owner_object */
public enum GraphQLBoostedComponentSpecElement {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    GENERIC,
    CREATIVE,
    CREATIVE_IMAGE,
    TARGETING,
    BUDGET,
    SCHEDULE,
    ACCOUNT,
    INSTAGRAM_PREVIEW;

    public static GraphQLBoostedComponentSpecElement fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("GENERIC")) {
            return GENERIC;
        }
        if (str.equalsIgnoreCase("CREATIVE")) {
            return CREATIVE;
        }
        if (str.equalsIgnoreCase("CREATIVE_IMAGE")) {
            return CREATIVE_IMAGE;
        }
        if (str.equalsIgnoreCase("TARGETING")) {
            return TARGETING;
        }
        if (str.equalsIgnoreCase("BUDGET")) {
            return BUDGET;
        }
        if (str.equalsIgnoreCase("SCHEDULE")) {
            return SCHEDULE;
        }
        if (str.equalsIgnoreCase("ACCOUNT")) {
            return ACCOUNT;
        }
        if (str.equalsIgnoreCase("INSTAGRAM_PREVIEW")) {
            return INSTAGRAM_PREVIEW;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
