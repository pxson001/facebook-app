package com.facebook.graphql.enums;

/* compiled from: location_context */
public enum GraphQLReactionStoryAttachmentActionStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SEND_MESSAGE,
    OPEN_URL,
    VIEW_PROFILE,
    WRITE_ON_TIMELINE,
    VIEW_IN_APP_STORE,
    LIKE_STORY,
    RESPOND_TO_EVENT,
    LAUNCH_PLACETIP,
    PAGE_OPEN_STORE,
    PAGE_OPEN_COLLECTION,
    LIKE_PAGE_IN_ATTACHMENT,
    ADMIN_PAGE,
    LIKED_PAGE_OPTIONS;

    public static GraphQLReactionStoryAttachmentActionStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("SEND_MESSAGE")) {
            return SEND_MESSAGE;
        }
        if (str.equalsIgnoreCase("OPEN_URL")) {
            return OPEN_URL;
        }
        if (str.equalsIgnoreCase("VIEW_PROFILE")) {
            return VIEW_PROFILE;
        }
        if (str.equalsIgnoreCase("WRITE_ON_TIMELINE")) {
            return WRITE_ON_TIMELINE;
        }
        if (str.equalsIgnoreCase("VIEW_IN_APP_STORE")) {
            return VIEW_IN_APP_STORE;
        }
        if (str.equalsIgnoreCase("LIKE_STORY")) {
            return LIKE_STORY;
        }
        if (str.equalsIgnoreCase("RESPOND_TO_EVENT")) {
            return RESPOND_TO_EVENT;
        }
        if (str.equalsIgnoreCase("LAUNCH_PLACETIP")) {
            return LAUNCH_PLACETIP;
        }
        if (str.equalsIgnoreCase("PAGE_OPEN_STORE")) {
            return PAGE_OPEN_STORE;
        }
        if (str.equalsIgnoreCase("PAGE_OPEN_COLLECTION")) {
            return PAGE_OPEN_COLLECTION;
        }
        if (str.equalsIgnoreCase("LIKE_PAGE_IN_ATTACHMENT")) {
            return LIKE_PAGE_IN_ATTACHMENT;
        }
        if (str.equalsIgnoreCase("ADMIN_PAGE")) {
            return ADMIN_PAGE;
        }
        if (str.equalsIgnoreCase("LIKED_PAGE_OPTIONS")) {
            return LIKED_PAGE_OPTIONS;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
