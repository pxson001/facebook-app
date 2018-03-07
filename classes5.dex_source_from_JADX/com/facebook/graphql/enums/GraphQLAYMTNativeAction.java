package com.facebook.graphql.enums;

/* compiled from: menu_info */
public enum GraphQLAYMTNativeAction {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ADD_PAGE_COVER_PHOTO,
    ADD_PAGE_PROFILE_PIC,
    CREATE_PAGE_POST,
    INVITE_FRIENDS_TO_LIKE_PAGE,
    MANAGE_ALL_PAGES,
    CREATE_BUSINESS_ACTIVITY_FEED_PERF_NOTIF,
    ADD_GROUP_ADMINS,
    ADD_GROUP_COVER_PHOTO,
    ADD_GROUP_MEMBERS,
    CREATE_GROUP_POLL,
    CREATE_GROUP_POST,
    WRITE_GROUP_DESCRIPTION;

    public static GraphQLAYMTNativeAction fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ADD_PAGE_COVER_PHOTO")) {
            return ADD_PAGE_COVER_PHOTO;
        }
        if (str.equalsIgnoreCase("ADD_PAGE_PROFILE_PIC")) {
            return ADD_PAGE_PROFILE_PIC;
        }
        if (str.equalsIgnoreCase("CREATE_PAGE_POST")) {
            return CREATE_PAGE_POST;
        }
        if (str.equalsIgnoreCase("INVITE_FRIENDS_TO_LIKE_PAGE")) {
            return INVITE_FRIENDS_TO_LIKE_PAGE;
        }
        if (str.equalsIgnoreCase("MANAGE_ALL_PAGES")) {
            return MANAGE_ALL_PAGES;
        }
        if (str.equalsIgnoreCase("CREATE_BUSINESS_ACTIVITY_FEED_PERF_NOTIF")) {
            return CREATE_BUSINESS_ACTIVITY_FEED_PERF_NOTIF;
        }
        if (str.equalsIgnoreCase("ADD_GROUP_ADMINS")) {
            return ADD_GROUP_ADMINS;
        }
        if (str.equalsIgnoreCase("ADD_GROUP_COVER_PHOTO")) {
            return ADD_GROUP_COVER_PHOTO;
        }
        if (str.equalsIgnoreCase("ADD_GROUP_MEMBERS")) {
            return ADD_GROUP_MEMBERS;
        }
        if (str.equalsIgnoreCase("CREATE_GROUP_POLL")) {
            return CREATE_GROUP_POLL;
        }
        if (str.equalsIgnoreCase("CREATE_GROUP_POST")) {
            return CREATE_GROUP_POST;
        }
        if (str.equalsIgnoreCase("WRITE_GROUP_DESCRIPTION")) {
            return WRITE_GROUP_DESCRIPTION;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
