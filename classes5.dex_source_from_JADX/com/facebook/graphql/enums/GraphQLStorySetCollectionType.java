package com.facebook.graphql.enums;

/* compiled from: live */
public enum GraphQLStorySetCollectionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    FALLBACK,
    VIDEO_STORIES,
    FRIEND_VIDEO_STORIES,
    ARTICLE_STORIES,
    LINK_ONLY_STORIES,
    SALE_STORIES,
    PAGES_STORIES,
    GROUP_TOP_STORIES,
    MIXED_STORIES;

    public static GraphQLStorySetCollectionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("FALLBACK")) {
            return FALLBACK;
        }
        if (str.equalsIgnoreCase("VIDEO_STORIES")) {
            return VIDEO_STORIES;
        }
        if (str.equalsIgnoreCase("FRIEND_VIDEO_STORIES")) {
            return FRIEND_VIDEO_STORIES;
        }
        if (str.equalsIgnoreCase("ARTICLE_STORIES")) {
            return ARTICLE_STORIES;
        }
        if (str.equalsIgnoreCase("LINK_ONLY_STORIES")) {
            return LINK_ONLY_STORIES;
        }
        if (str.equalsIgnoreCase("SALE_STORIES")) {
            return SALE_STORIES;
        }
        if (str.equalsIgnoreCase("PAGES_STORIES")) {
            return PAGES_STORIES;
        }
        if (str.equalsIgnoreCase("GROUP_TOP_STORIES")) {
            return GROUP_TOP_STORIES;
        }
        if (str.equalsIgnoreCase("MIXED_STORIES")) {
            return MIXED_STORIES;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
