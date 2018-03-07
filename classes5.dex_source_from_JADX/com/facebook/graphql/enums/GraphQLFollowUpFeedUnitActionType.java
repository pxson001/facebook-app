package com.facebook.graphql.enums;

/* compiled from: main_filter */
public enum GraphQLFollowUpFeedUnitActionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    LIKE,
    PAGE_LIKE,
    COMMENT,
    OUTBOUND_CLICK,
    SEND_REQUEST,
    SHARE,
    VIDEO_PLAY,
    PIVOT,
    PHOTO_CLICK,
    HOVER,
    AUTO_EXPAND,
    EVENT_JOIN,
    GROUP_LIKE,
    GROUP_JOIN,
    GROUP_VIEW_PERMALINK,
    SAVE,
    TIMELINE_PROFILE_PICTURE_CLICK,
    TOPIC_FEED_PIVOT;

    public static GraphQLFollowUpFeedUnitActionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("LIKE")) {
            return LIKE;
        }
        if (str.equalsIgnoreCase("PAGE_LIKE")) {
            return PAGE_LIKE;
        }
        if (str.equalsIgnoreCase("COMMENT")) {
            return COMMENT;
        }
        if (str.equalsIgnoreCase("OUTBOUND_CLICK")) {
            return OUTBOUND_CLICK;
        }
        if (str.equalsIgnoreCase("SEND_REQUEST")) {
            return SEND_REQUEST;
        }
        if (str.equalsIgnoreCase("SHARE")) {
            return SHARE;
        }
        if (str.equalsIgnoreCase("VIDEO_PLAY")) {
            return VIDEO_PLAY;
        }
        if (str.equalsIgnoreCase("PIVOT")) {
            return PIVOT;
        }
        if (str.equalsIgnoreCase("PHOTO_CLICK")) {
            return PHOTO_CLICK;
        }
        if (str.equalsIgnoreCase("HOVER")) {
            return HOVER;
        }
        if (str.equalsIgnoreCase("AUTO_EXPAND")) {
            return AUTO_EXPAND;
        }
        if (str.equalsIgnoreCase("EVENT_JOIN")) {
            return EVENT_JOIN;
        }
        if (str.equalsIgnoreCase("GROUP_LIKE")) {
            return GROUP_LIKE;
        }
        if (str.equalsIgnoreCase("GROUP_JOIN")) {
            return GROUP_JOIN;
        }
        if (str.equalsIgnoreCase("GROUP_VIEW_PERMALINK")) {
            return GROUP_VIEW_PERMALINK;
        }
        if (str.equalsIgnoreCase("SAVE")) {
            return SAVE;
        }
        if (str.equalsIgnoreCase("TIMELINE_PROFILE_PICTURE_CLICK")) {
            return TIMELINE_PROFILE_PICTURE_CLICK;
        }
        if (str.equalsIgnoreCase("TOPIC_FEED_PIVOT")) {
            return TOPIC_FEED_PIVOT;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
