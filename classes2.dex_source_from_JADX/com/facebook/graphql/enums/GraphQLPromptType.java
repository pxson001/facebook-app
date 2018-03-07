package com.facebook.graphql.enums;

/* compiled from: network_info_active_read_seconds */
public enum GraphQLPromptType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    MANUAL,
    CULTURAL,
    SPORTS_PREGAME,
    SPORTS,
    SPORTS_POSTGAME,
    GAMEFACE,
    SPORTS_NBA,
    SPORTS_NFL,
    SPORTS_MLB,
    LOCATION,
    EVENT,
    TV_SHOW,
    OG_MUSIC,
    CHECKIN,
    CLIPBOARD,
    SOUVENIR,
    PHOTO,
    PHOTO_AND_SLIDESHOW,
    MPS,
    AIRPORT,
    BIRTHDAY,
    FRIENDS_BIRTHDAY,
    MOVIE_HOLIDAY,
    MOVIE_EVERGREEN,
    FEED_STORY,
    TRENDING_SHARE,
    PHOTO_WEEKEND,
    DRAFT_RECOVERY;

    public static GraphQLPromptType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("MANUAL")) {
            return MANUAL;
        }
        if (str.equalsIgnoreCase("CULTURAL")) {
            return CULTURAL;
        }
        if (str.equalsIgnoreCase("SPORTS_PREGAME")) {
            return SPORTS_PREGAME;
        }
        if (str.equalsIgnoreCase("SPORTS")) {
            return SPORTS;
        }
        if (str.equalsIgnoreCase("SPORTS_POSTGAME")) {
            return SPORTS_POSTGAME;
        }
        if (str.equalsIgnoreCase("GAMEFACE")) {
            return GAMEFACE;
        }
        if (str.equalsIgnoreCase("SPORTS_NBA")) {
            return SPORTS_NBA;
        }
        if (str.equalsIgnoreCase("SPORTS_NFL")) {
            return SPORTS_NFL;
        }
        if (str.equalsIgnoreCase("SPORTS_MLB")) {
            return SPORTS_MLB;
        }
        if (str.equalsIgnoreCase("LOCATION")) {
            return LOCATION;
        }
        if (str.equalsIgnoreCase("EVENT")) {
            return EVENT;
        }
        if (str.equalsIgnoreCase("TV_SHOW")) {
            return TV_SHOW;
        }
        if (str.equalsIgnoreCase("OG_MUSIC")) {
            return OG_MUSIC;
        }
        if (str.equalsIgnoreCase("CHECKIN")) {
            return CHECKIN;
        }
        if (str.equalsIgnoreCase("CLIPBOARD")) {
            return CLIPBOARD;
        }
        if (str.equalsIgnoreCase("SOUVENIR")) {
            return SOUVENIR;
        }
        if (str.equalsIgnoreCase("PHOTO")) {
            return PHOTO;
        }
        if (str.equalsIgnoreCase("PHOTO_AND_SLIDESHOW")) {
            return PHOTO_AND_SLIDESHOW;
        }
        if (str.equalsIgnoreCase("PHOTO_WEEKEND")) {
            return PHOTO_WEEKEND;
        }
        if (str.equalsIgnoreCase("MPS")) {
            return MPS;
        }
        if (str.equalsIgnoreCase("AIRPORT")) {
            return AIRPORT;
        }
        if (str.equalsIgnoreCase("BIRTHDAY")) {
            return BIRTHDAY;
        }
        if (str.equalsIgnoreCase("FRIENDS_BIRTHDAY")) {
            return FRIENDS_BIRTHDAY;
        }
        if (str.equalsIgnoreCase("MOVIE_HOLIDAY")) {
            return MOVIE_HOLIDAY;
        }
        if (str.equalsIgnoreCase("MOVIE_EVERGREEN")) {
            return MOVIE_EVERGREEN;
        }
        if (str.equalsIgnoreCase("FEED_STORY")) {
            return FEED_STORY;
        }
        if (str.equalsIgnoreCase("DRAFT_RECOVERY")) {
            return DRAFT_RECOVERY;
        }
        if (str.equalsIgnoreCase("TRENDING_SHARE")) {
            return TRENDING_SHARE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
