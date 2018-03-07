package com.facebook.graphql.enums;

/* compiled from: link_title */
public enum GraphQLTimelineAppCollectionStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    LIST,
    REVIEW_LIST,
    CONTACT_LIST,
    GRID,
    PHOTOS,
    MAP,
    ABOUT,
    NOTES,
    FEED;

    public static GraphQLTimelineAppCollectionStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("LIST")) {
            return LIST;
        }
        if (str.equalsIgnoreCase("REVIEW_LIST")) {
            return REVIEW_LIST;
        }
        if (str.equalsIgnoreCase("CONTACT_LIST")) {
            return CONTACT_LIST;
        }
        if (str.equalsIgnoreCase("GRID")) {
            return GRID;
        }
        if (str.equalsIgnoreCase("PHOTOS")) {
            return PHOTOS;
        }
        if (str.equalsIgnoreCase("MAP")) {
            return MAP;
        }
        if (str.equalsIgnoreCase("ABOUT")) {
            return ABOUT;
        }
        if (str.equalsIgnoreCase("NOTES")) {
            return NOTES;
        }
        if (str.equalsIgnoreCase("FEED")) {
            return FEED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
