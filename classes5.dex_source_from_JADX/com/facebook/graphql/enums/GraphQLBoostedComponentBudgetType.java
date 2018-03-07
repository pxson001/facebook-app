package com.facebook.graphql.enums;

/* compiled from: media_picker */
public enum GraphQLBoostedComponentBudgetType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    DAILY_BUDGET,
    LIFETIME_BUDGET,
    MIXED_BUDGET;

    public static GraphQLBoostedComponentBudgetType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("DAILY_BUDGET")) {
            return DAILY_BUDGET;
        }
        if (str.equalsIgnoreCase("LIFETIME_BUDGET")) {
            return LIFETIME_BUDGET;
        }
        if (str.equalsIgnoreCase("MIXED_BUDGET")) {
            return MIXED_BUDGET;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
