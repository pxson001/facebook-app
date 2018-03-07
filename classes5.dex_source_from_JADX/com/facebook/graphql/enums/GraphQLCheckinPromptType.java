package com.facebook.graphql.enums;

/* compiled from: media_editor_review_and_suggest_module_v2 */
public enum GraphQLCheckinPromptType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    HOME_CREATION,
    ECHO_PROMPT,
    NONE;

    public static GraphQLCheckinPromptType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("HOME_CREATION")) {
            return HOME_CREATION;
        }
        if (str.equalsIgnoreCase("ECHO_PROMPT")) {
            return ECHO_PROMPT;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
