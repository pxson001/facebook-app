package com.facebook.graphql.enums;

/* compiled from: local_serp_thank_you_card_button */
public enum GraphQLReactionUnitCollapseState {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NOT_COLLAPSIBLE,
    COLLAPSED,
    COLLAPSIBLE;

    public static GraphQLReactionUnitCollapseState fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NOT_COLLAPSIBLE")) {
            return NOT_COLLAPSIBLE;
        }
        if (str.equalsIgnoreCase("COLLAPSED")) {
            return COLLAPSED;
        }
        if (str.equalsIgnoreCase("COLLAPSIBLE")) {
            return COLLAPSIBLE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
