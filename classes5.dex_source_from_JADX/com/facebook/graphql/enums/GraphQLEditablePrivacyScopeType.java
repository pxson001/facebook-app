package com.facebook.graphql.enums;

/* compiled from: marketplace_id */
public enum GraphQLEditablePrivacyScopeType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    PRIVACY_FIELD,
    PROFILE_FIELD_POP,
    PROFILE_SECTION,
    ENT_CONTENT,
    TIMELINE_STORY,
    ENT_STORY,
    ENT_PAGE_RATING,
    POP_PER_APP;

    public static GraphQLEditablePrivacyScopeType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("PRIVACY_FIELD")) {
            return PRIVACY_FIELD;
        }
        if (str.equalsIgnoreCase("PROFILE_FIELD_POP")) {
            return PROFILE_FIELD_POP;
        }
        if (str.equalsIgnoreCase("PROFILE_SECTION")) {
            return PROFILE_SECTION;
        }
        if (str.equalsIgnoreCase("ENT_CONTENT")) {
            return ENT_CONTENT;
        }
        if (str.equalsIgnoreCase("TIMELINE_STORY")) {
            return TIMELINE_STORY;
        }
        if (str.equalsIgnoreCase("ENT_STORY")) {
            return ENT_STORY;
        }
        if (str.equalsIgnoreCase("ENT_PAGE_RATING")) {
            return ENT_PAGE_RATING;
        }
        if (str.equalsIgnoreCase("POP_PER_APP")) {
            return POP_PER_APP;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
