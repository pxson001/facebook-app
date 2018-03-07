package com.facebook.graphql.enums;

/* compiled from: mLogoUrl */
public enum GraphQLMusicType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SONG,
    ALBUM,
    MUSICIAN,
    PLAYLIST,
    RADIO_STATION;

    public static GraphQLMusicType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("SONG")) {
            return SONG;
        }
        if (str.equalsIgnoreCase("ALBUM")) {
            return ALBUM;
        }
        if (str.equalsIgnoreCase("MUSICIAN")) {
            return MUSICIAN;
        }
        if (str.equalsIgnoreCase("PLAYLIST")) {
            return PLAYLIST;
        }
        if (str.equalsIgnoreCase("RADIO_STATION")) {
            return RADIO_STATION;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
