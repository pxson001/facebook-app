package com.facebook.graphql.enums;

/* compiled from: destroy_player */
public enum GraphQLCallToActionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    OPEN_LINK,
    LIKE_PAGE,
    SHOP_NOW,
    PLAY_GAME,
    INSTALL_APP,
    USE_APP,
    CALL,
    CALL_ME,
    INSTALL_MOBILE_APP,
    USE_MOBILE_APP,
    MOBILE_DOWNLOAD,
    BOOK_TRAVEL,
    LISTEN_MUSIC,
    WATCH_VIDEO,
    LEARN_MORE,
    SIGN_UP,
    DOWNLOAD,
    WATCH_MORE,
    NO_BUTTON,
    VISIT_PAGES_FEED,
    MISSED_CALL,
    CALL_NOW,
    APPLY_NOW,
    BUY_NOW,
    GET_OFFER,
    GET_OFFER_VIEW,
    BUY_TICKETS,
    UPDATE_APP,
    GET_DIRECTIONS,
    BUY,
    SEE_DETAILS,
    MESSAGE_PAGE,
    DONATE,
    SUBSCRIBE,
    SAY_THANKS,
    SELL_NOW,
    SHARE,
    DONATE_NOW,
    GET_QUOTE,
    CONTACT_US,
    ORDER_NOW,
    ADD_TO_CART,
    VIDEO_ANNOTATION,
    MOMENTS,
    DEPRECATED_45,
    RECORD_NOW,
    VOTE_NOW,
    UNLIKE_PAGE,
    BET_NOW,
    OPEN_MOVIES,
    INSTALL_FREE_MOBILE_APP,
    GIVE_FREE_RIDES,
    REGISTER_NOW,
    OPEN_MESSENGER_EXT;

    public static GraphQLCallToActionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        switch ((((Character.toUpperCase(str.charAt(0)) * 961) + (Character.toUpperCase(str.charAt(str.length() - 1)) * 31)) + str.length()) & 31) {
            case 1:
                if (str.equalsIgnoreCase("BOOK_TRAVEL")) {
                    return BOOK_TRAVEL;
                }
                if (str.equalsIgnoreCase("ORDER_NOW")) {
                    return ORDER_NOW;
                }
                if (str.equalsIgnoreCase("MOMENTS")) {
                    return MOMENTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 2:
                if (str.equalsIgnoreCase("VISIT_PAGES_FEED")) {
                    return VISIT_PAGES_FEED;
                }
                if (str.equalsIgnoreCase("GET_DIRECTIONS")) {
                    return GET_DIRECTIONS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 3:
                if (str.equalsIgnoreCase("GIVE_FREE_RIDES")) {
                    return GIVE_FREE_RIDES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 4:
                if (str.equalsIgnoreCase("SHOP_NOW")) {
                    return SHOP_NOW;
                }
                if (str.equalsIgnoreCase("INSTALL_APP")) {
                    return INSTALL_APP;
                }
                if (str.equalsIgnoreCase("SELL_NOW")) {
                    return SELL_NOW;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 5:
                if (str.equalsIgnoreCase("CALL_ME")) {
                    return CALL_ME;
                }
                if (str.equalsIgnoreCase("DONATE")) {
                    return DONATE;
                }
                if (str.equalsIgnoreCase("RECORD_NOW")) {
                    return RECORD_NOW;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 7:
                if (str.equalsIgnoreCase("VOTE_NOW")) {
                    return VOTE_NOW;
                }
                if (str.equalsIgnoreCase("REGISTER_NOW")) {
                    return REGISTER_NOW;
                }
                if (str.equalsIgnoreCase("OPEN_MOVIES")) {
                    return OPEN_MOVIES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 8:
                if (str.equalsIgnoreCase("DOWNLOAD")) {
                    return DOWNLOAD;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 9:
                if (str.equalsIgnoreCase("NO_BUTTON")) {
                    return NO_BUTTON;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 10:
                if (str.equalsIgnoreCase("SIGN_UP")) {
                    return SIGN_UP;
                }
                if (str.equalsIgnoreCase("SAY_THANKS")) {
                    return SAY_THANKS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 11:
                if (str.equalsIgnoreCase("INSTALL_MOBILE_APP")) {
                    return INSTALL_MOBILE_APP;
                }
                if (str.equalsIgnoreCase("SEE_DETAILS")) {
                    return SEE_DETAILS;
                }
                if (str.equalsIgnoreCase("GET_QUOTE")) {
                    return GET_QUOTE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 12:
                if (str.equalsIgnoreCase("USE_APP")) {
                    return USE_APP;
                }
                if (str.equalsIgnoreCase("MISSED_CALL")) {
                    return MISSED_CALL;
                }
                if (str.equalsIgnoreCase("BUY")) {
                    return BUY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 13:
                if (str.equalsIgnoreCase("OPEN_LINK")) {
                    return OPEN_LINK;
                }
                if (str.equalsIgnoreCase("OPEN_MESSENGER_EXT")) {
                    return OPEN_MESSENGER_EXT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 15:
                if (str.equalsIgnoreCase("UPDATE_APP")) {
                    return UPDATE_APP;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 16:
                if (str.equalsIgnoreCase("LIKE_PAGE")) {
                    return LIKE_PAGE;
                }
                if (str.equalsIgnoreCase("INSTALL_FREE_MOBILE_APP")) {
                    return INSTALL_FREE_MOBILE_APP;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 17:
                if (str.equalsIgnoreCase("LEARN_MORE")) {
                    return LEARN_MORE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 18:
                if (str.equalsIgnoreCase("BUY_NOW")) {
                    return BUY_NOW;
                }
                if (str.equalsIgnoreCase("BET_NOW")) {
                    return BET_NOW;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 19:
                if (str.equalsIgnoreCase("USE_MOBILE_APP")) {
                    return USE_MOBILE_APP;
                }
                if (str.equalsIgnoreCase("WATCH_VIDEO")) {
                    return WATCH_VIDEO;
                }
                if (str.equalsIgnoreCase("APPLY_NOW")) {
                    return APPLY_NOW;
                }
                if (str.equalsIgnoreCase("SHARE")) {
                    return SHARE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 20:
                if (str.equalsIgnoreCase("PLAY_GAME")) {
                    return PLAY_GAME;
                }
                if (str.equalsIgnoreCase("CALL_NOW")) {
                    return CALL_NOW;
                }
                if (str.equalsIgnoreCase("MESSAGE_PAGE")) {
                    return MESSAGE_PAGE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 21:
                if (str.equalsIgnoreCase("LISTEN_MUSIC")) {
                    return LISTEN_MUSIC;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 23:
                if (str.equalsIgnoreCase("SUBSCRIBE")) {
                    return SUBSCRIBE;
                }
                if (str.equalsIgnoreCase("DONATE_NOW")) {
                    return DONATE_NOW;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 24:
                if (str.equalsIgnoreCase("MOBILE_DOWNLOAD")) {
                    return MOBILE_DOWNLOAD;
                }
                if (str.equalsIgnoreCase("ADD_TO_CART")) {
                    return ADD_TO_CART;
                }
                if (str.equalsIgnoreCase("VIDEO_ANNOTATION")) {
                    return VIDEO_ANNOTATION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 26:
                if (str.equalsIgnoreCase("BUY_TICKETS")) {
                    return BUY_TICKETS;
                }
                if (str.equalsIgnoreCase("CONTACT_US")) {
                    return CONTACT_US;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 27:
                if (str.equalsIgnoreCase("CALL")) {
                    return CALL;
                }
                if (str.equalsIgnoreCase("UNLIKE_PAGE")) {
                    return UNLIKE_PAGE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 28:
                if (str.equalsIgnoreCase("WATCH_MORE")) {
                    return WATCH_MORE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 30:
                if (str.equalsIgnoreCase("GET_OFFER")) {
                    return GET_OFFER;
                }
                if (str.equalsIgnoreCase("GET_OFFER_VIEW")) {
                    return GET_OFFER_VIEW;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            default:
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
    }
}
