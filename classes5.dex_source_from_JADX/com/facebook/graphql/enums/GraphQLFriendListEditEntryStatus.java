package com.facebook.graphql.enums;

/* compiled from: main_choices */
public enum GraphQLFriendListEditEntryStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    LIST_MEMBER,
    PRESELECTED_SUGGESTION,
    SUGGESTION,
    NON_LIST_MEMBER;

    public static GraphQLFriendListEditEntryStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("LIST_MEMBER")) {
            return LIST_MEMBER;
        }
        if (str.equalsIgnoreCase("PRESELECTED_SUGGESTION")) {
            return PRESELECTED_SUGGESTION;
        }
        if (str.equalsIgnoreCase("SUGGESTION")) {
            return SUGGESTION;
        }
        if (str.equalsIgnoreCase("NON_LIST_MEMBER")) {
            return NON_LIST_MEMBER;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
