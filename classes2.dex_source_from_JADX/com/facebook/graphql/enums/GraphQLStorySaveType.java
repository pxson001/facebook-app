package com.facebook.graphql.enums;

/* compiled from: network_usage_counters */
public enum GraphQLStorySaveType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    UNKONWN,
    LINK,
    VIDEO,
    PLACE,
    PAGE,
    MUSIC,
    BOOK,
    MOVIE,
    TV_SHOW,
    EVENT,
    POST,
    PHOTO,
    PHOTOS,
    PRODUCT,
    PROFILE,
    GENERIC,
    MESSAGE,
    LIST;

    public static GraphQLStorySaveType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("UNKONWN")) {
            return UNKONWN;
        }
        if (str.equalsIgnoreCase("LINK")) {
            return LINK;
        }
        if (str.equalsIgnoreCase("VIDEO")) {
            return VIDEO;
        }
        if (str.equalsIgnoreCase("PLACE")) {
            return PLACE;
        }
        if (str.equalsIgnoreCase("PAGE")) {
            return PAGE;
        }
        if (str.equalsIgnoreCase("MUSIC")) {
            return MUSIC;
        }
        if (str.equalsIgnoreCase("BOOK")) {
            return BOOK;
        }
        if (str.equalsIgnoreCase("MOVIE")) {
            return MOVIE;
        }
        if (str.equalsIgnoreCase("TV_SHOW")) {
            return TV_SHOW;
        }
        if (str.equalsIgnoreCase("EVENT")) {
            return EVENT;
        }
        if (str.equalsIgnoreCase("POST")) {
            return POST;
        }
        if (str.equalsIgnoreCase("PHOTO")) {
            return PHOTO;
        }
        if (str.equalsIgnoreCase("PHOTOS")) {
            return PHOTOS;
        }
        if (str.equalsIgnoreCase("PRODUCT")) {
            return PRODUCT;
        }
        if (str.equalsIgnoreCase("PROFILE")) {
            return PROFILE;
        }
        if (str.equalsIgnoreCase("MESSAGE")) {
            return MESSAGE;
        }
        if (str.equalsIgnoreCase("LIST")) {
            return LIST;
        }
        if (str.equalsIgnoreCase("GENERIC")) {
            return GENERIC;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
