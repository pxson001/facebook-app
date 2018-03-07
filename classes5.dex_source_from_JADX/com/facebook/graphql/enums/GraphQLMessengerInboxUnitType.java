package com.facebook.graphql.enums;

/* compiled from: mOptinDeclineConfirmText */
public enum GraphQLMessengerInboxUnitType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ACTIVE_NOW,
    ALL_REMAINING_THREADS,
    CAMERA_ROLL,
    CONVERSATION_REQUESTS,
    CONVERSATION_STARTERS,
    EXTERNAL_URL,
    MESSAGE_THREADS,
    MOST_RECENT_THREADS,
    PHOTO_REMINDERS,
    PYMM,
    VIDEOS,
    GIFS,
    BYMM,
    FEATURED_STICKER_PACKS,
    RTC_RECOMMENDATION,
    MONTAGE_COMPOSER,
    BMR,
    MESSAGE_REQUEST_THREADS,
    ANNOUNCEMENT;

    public static GraphQLMessengerInboxUnitType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ACTIVE_NOW")) {
            return ACTIVE_NOW;
        }
        if (str.equalsIgnoreCase("ALL_REMAINING_THREADS")) {
            return ALL_REMAINING_THREADS;
        }
        if (str.equalsIgnoreCase("ANNOUNCEMENT")) {
            return ANNOUNCEMENT;
        }
        if (str.equalsIgnoreCase("BMR")) {
            return BMR;
        }
        if (str.equalsIgnoreCase("BYMM")) {
            return BYMM;
        }
        if (str.equalsIgnoreCase("CAMERA_ROLL")) {
            return CAMERA_ROLL;
        }
        if (str.equalsIgnoreCase("CONVERSATION_REQUESTS")) {
            return CONVERSATION_REQUESTS;
        }
        if (str.equalsIgnoreCase("CONVERSATION_STARTERS")) {
            return CONVERSATION_STARTERS;
        }
        if (str.equalsIgnoreCase("EXTERNAL_URL")) {
            return EXTERNAL_URL;
        }
        if (str.equalsIgnoreCase("FEATURED_STICKER_PACKS")) {
            return FEATURED_STICKER_PACKS;
        }
        if (str.equalsIgnoreCase("GIFS")) {
            return GIFS;
        }
        if (str.equalsIgnoreCase("MESSAGE_REQUEST_THREADS")) {
            return MESSAGE_REQUEST_THREADS;
        }
        if (str.equalsIgnoreCase("MESSAGE_THREADS")) {
            return MESSAGE_THREADS;
        }
        if (str.equalsIgnoreCase("MONTAGE_COMPOSER")) {
            return MONTAGE_COMPOSER;
        }
        if (str.equalsIgnoreCase("MOST_RECENT_THREADS")) {
            return MOST_RECENT_THREADS;
        }
        if (str.equalsIgnoreCase("PHOTO_REMINDERS")) {
            return PHOTO_REMINDERS;
        }
        if (str.equalsIgnoreCase("PYMM")) {
            return PYMM;
        }
        if (str.equalsIgnoreCase("RTC_RECOMMENDATION")) {
            return RTC_RECOMMENDATION;
        }
        if (str.equalsIgnoreCase("VIDEOS")) {
            return VIDEOS;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
