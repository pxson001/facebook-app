package com.facebook.graphql.enums;

/* compiled from: mImageUrl */
public enum GraphQLPageCallToActionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    BOOK_NOW,
    MAKE_RESERVATION,
    CALL_NOW,
    CHARITY_DONATE,
    CONTACT_US,
    DONATE_NOW,
    MESSAGE,
    OPEN_APP,
    PLAY_NOW,
    SHOP_NOW,
    SIGN_UP,
    WATCH_NOW,
    GET_OFFER,
    GET_OFFER_VIEW,
    REQUEST_QUOTE,
    BOOK_APPOINTMENT,
    LISTEN,
    EMAIL,
    LEARN_MORE;

    public static GraphQLPageCallToActionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("BOOK_NOW")) {
            return BOOK_NOW;
        }
        if (str.equalsIgnoreCase("MAKE_RESERVATION")) {
            return MAKE_RESERVATION;
        }
        if (str.equalsIgnoreCase("CALL_NOW")) {
            return CALL_NOW;
        }
        if (str.equalsIgnoreCase("CHARITY_DONATE")) {
            return CHARITY_DONATE;
        }
        if (str.equalsIgnoreCase("CONTACT_US")) {
            return CONTACT_US;
        }
        if (str.equalsIgnoreCase("DONATE_NOW")) {
            return DONATE_NOW;
        }
        if (str.equalsIgnoreCase("MESSAGE")) {
            return MESSAGE;
        }
        if (str.equalsIgnoreCase("OPEN_APP")) {
            return OPEN_APP;
        }
        if (str.equalsIgnoreCase("PLAY_NOW")) {
            return PLAY_NOW;
        }
        if (str.equalsIgnoreCase("SHOP_NOW")) {
            return SHOP_NOW;
        }
        if (str.equalsIgnoreCase("SIGN_UP")) {
            return SIGN_UP;
        }
        if (str.equalsIgnoreCase("WATCH_NOW")) {
            return WATCH_NOW;
        }
        if (str.equalsIgnoreCase("GET_OFFER")) {
            return GET_OFFER;
        }
        if (str.equalsIgnoreCase("GET_OFFER_VIEW")) {
            return GET_OFFER_VIEW;
        }
        if (str.equalsIgnoreCase("REQUEST_QUOTE")) {
            return REQUEST_QUOTE;
        }
        if (str.equalsIgnoreCase("BOOK_APPOINTMENT")) {
            return BOOK_APPOINTMENT;
        }
        if (str.equalsIgnoreCase("LISTEN")) {
            return LISTEN;
        }
        if (str.equalsIgnoreCase("EMAIL")) {
            return EMAIL;
        }
        if (str.equalsIgnoreCase("LEARN_MORE")) {
            return LEARN_MORE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
