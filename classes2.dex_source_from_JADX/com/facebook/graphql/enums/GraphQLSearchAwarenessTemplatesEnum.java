package com.facebook.graphql.enums;

/* compiled from: profile_pic_swipe_size_param */
public enum GraphQLSearchAwarenessTemplatesEnum {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    TOOLTIP,
    LEARNING_NUX_SECOND_STEP,
    LEARNING_NUX_SERP_SUCCESS,
    FORMATTED_TOOLTIP,
    LEARNING_TYPEAHEAD_TOOLTIP;

    public static GraphQLSearchAwarenessTemplatesEnum fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("TOOLTIP")) {
            return TOOLTIP;
        }
        if (str.equalsIgnoreCase("LEARNING_NUX_SECOND_STEP")) {
            return LEARNING_NUX_SECOND_STEP;
        }
        if (str.equalsIgnoreCase("LEARNING_NUX_SERP_SUCCESS")) {
            return LEARNING_NUX_SERP_SUCCESS;
        }
        if (str.equalsIgnoreCase("FORMATTED_TOOLTIP")) {
            return FORMATTED_TOOLTIP;
        }
        if (str.equalsIgnoreCase("LEARNING_TYPEAHEAD_TOOLTIP")) {
            return LEARNING_TYPEAHEAD_TOOLTIP;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
