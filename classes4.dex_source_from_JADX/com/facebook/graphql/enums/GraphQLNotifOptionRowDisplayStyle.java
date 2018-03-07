package com.facebook.graphql.enums;

/* compiled from: methodName */
public enum GraphQLNotifOptionRowDisplayStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    BASIC_MENU,
    SWIPE_MENU_OPTION,
    POPUP_MENU_OPTION,
    SLIDE_MENU_OPTION,
    CHEVRON_MENU_OPTION,
    PROFILE_IMAGE_OPTION,
    SELECTOR_MENU_OPTION,
    PROFILE_IMAGE_WITH_CHECK_OPTION,
    H_SCROLL_PROFILE,
    RADIO_BUTTON,
    SQUARE_RADIO_BUTTON,
    PLAIN_CHECK,
    BLUE_CIRCLE_BUTTON,
    ACTION_SHEET_OPTION,
    TOGGLE_ON,
    TOGGLE_OFF,
    WASH_TEXTS,
    TEXT_WITH_BUTTON;

    public static GraphQLNotifOptionRowDisplayStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("BASIC_MENU")) {
            return BASIC_MENU;
        }
        if (str.equalsIgnoreCase("SWIPE_MENU_OPTION")) {
            return SWIPE_MENU_OPTION;
        }
        if (str.equalsIgnoreCase("POPUP_MENU_OPTION")) {
            return POPUP_MENU_OPTION;
        }
        if (str.equalsIgnoreCase("SLIDE_MENU_OPTION")) {
            return SLIDE_MENU_OPTION;
        }
        if (str.equalsIgnoreCase("CHEVRON_MENU_OPTION")) {
            return CHEVRON_MENU_OPTION;
        }
        if (str.equalsIgnoreCase("PROFILE_IMAGE_OPTION")) {
            return PROFILE_IMAGE_OPTION;
        }
        if (str.equalsIgnoreCase("ACTION_SHEET_OPTION")) {
            return ACTION_SHEET_OPTION;
        }
        if (str.equalsIgnoreCase("PROFILE_IMAGE_WITH_CHECK_OPTION")) {
            return PROFILE_IMAGE_WITH_CHECK_OPTION;
        }
        if (str.equalsIgnoreCase("H_SCROLL_PROFILE")) {
            return H_SCROLL_PROFILE;
        }
        if (str.equalsIgnoreCase("SELECTOR_MENU_OPTION")) {
            return SELECTOR_MENU_OPTION;
        }
        if (str.equalsIgnoreCase("RADIO_BUTTON")) {
            return RADIO_BUTTON;
        }
        if (str.equalsIgnoreCase("SQUARE_RADIO_BUTTON")) {
            return SQUARE_RADIO_BUTTON;
        }
        if (str.equalsIgnoreCase("PLAIN_CHECK")) {
            return PLAIN_CHECK;
        }
        if (str.equalsIgnoreCase("BLUE_CIRCLE_BUTTON")) {
            return BLUE_CIRCLE_BUTTON;
        }
        if (str.equalsIgnoreCase("TOGGLE_ON")) {
            return TOGGLE_ON;
        }
        if (str.equalsIgnoreCase("TOGGLE_OFF")) {
            return TOGGLE_OFF;
        }
        if (str.equalsIgnoreCase("WASH_TEXTS")) {
            return WASH_TEXTS;
        }
        if (str.equalsIgnoreCase("TEXT_WITH_BUTTON")) {
            return TEXT_WITH_BUTTON;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
