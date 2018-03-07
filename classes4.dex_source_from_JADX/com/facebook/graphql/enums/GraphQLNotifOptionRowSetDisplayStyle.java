package com.facebook.graphql.enums;

/* compiled from: method_context */
public enum GraphQLNotifOptionRowSetDisplayStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SWIPE_MENU,
    LONGPRESS_MENU,
    FLYOUT_MENU,
    CHEVRON_MENU,
    RICH_NOTIF_ACTIONS,
    ACTION_SHEET_MENU,
    SETTING_PAGE_SECTION,
    MENU_SECTION_WITH_INDEPENDENT_ROWS,
    SINGLE_SELECTOR,
    MULTI_SELECTOR,
    H_SCROLL,
    TOGGLE,
    MENU_SECTION_WITH_REMOVABLE_ROWS;

    public static GraphQLNotifOptionRowSetDisplayStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("SWIPE_MENU")) {
            return SWIPE_MENU;
        }
        if (str.equalsIgnoreCase("LONGPRESS_MENU")) {
            return LONGPRESS_MENU;
        }
        if (str.equalsIgnoreCase("FLYOUT_MENU")) {
            return FLYOUT_MENU;
        }
        if (str.equalsIgnoreCase("CHEVRON_MENU")) {
            return CHEVRON_MENU;
        }
        if (str.equalsIgnoreCase("RICH_NOTIF_ACTIONS")) {
            return RICH_NOTIF_ACTIONS;
        }
        if (str.equalsIgnoreCase("ACTION_SHEET_MENU")) {
            return ACTION_SHEET_MENU;
        }
        if (str.equalsIgnoreCase("SETTING_PAGE_SECTION")) {
            return SETTING_PAGE_SECTION;
        }
        if (str.equalsIgnoreCase("MENU_SECTION_WITH_INDEPENDENT_ROWS")) {
            return MENU_SECTION_WITH_INDEPENDENT_ROWS;
        }
        if (str.equalsIgnoreCase("SINGLE_SELECTOR")) {
            return SINGLE_SELECTOR;
        }
        if (str.equalsIgnoreCase("MULTI_SELECTOR")) {
            return MULTI_SELECTOR;
        }
        if (str.equalsIgnoreCase("H_SCROLL")) {
            return H_SCROLL;
        }
        if (str.equalsIgnoreCase("TOGGLE")) {
            return TOGGLE;
        }
        if (str.equalsIgnoreCase("MENU_SECTION_WITH_REMOVABLE_ROWS")) {
            return MENU_SECTION_WITH_REMOVABLE_ROWS;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
