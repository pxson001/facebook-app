package com.facebook.graphql.enums;

/* compiled from: middle */
public enum GraphQLNotifOptionClientActionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    HIDE,
    UNSUB,
    MODSUB,
    SHOW_MORE,
    MARK_AS_READ,
    MARK_AS_UNREAD,
    SETTINGS,
    OPEN_SUB_PAGE,
    OPEN_ACTION_SHEET,
    SERVER_ACTION,
    TURN_OFF,
    REPORT_BUG,
    OPEN_GROUP_SETTING,
    OPEN_EVENT_SETTING,
    OPEN_GROUP_DASHBOARD,
    OPEN_EVENT_DASHBOARD,
    OPEN_DEVICE_PUSH_SETTINGS,
    OPEN_SOUNDS_SETTING;

    public static GraphQLNotifOptionClientActionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("HIDE")) {
            return HIDE;
        }
        if (str.equalsIgnoreCase("UNSUB")) {
            return UNSUB;
        }
        if (str.equalsIgnoreCase("MODSUB")) {
            return MODSUB;
        }
        if (str.equalsIgnoreCase("SHOW_MORE")) {
            return SHOW_MORE;
        }
        if (str.equalsIgnoreCase("MARK_AS_READ")) {
            return MARK_AS_READ;
        }
        if (str.equalsIgnoreCase("MARK_AS_UNREAD")) {
            return MARK_AS_UNREAD;
        }
        if (str.equalsIgnoreCase("SETTINGS")) {
            return SETTINGS;
        }
        if (str.equalsIgnoreCase("OPEN_SUB_PAGE")) {
            return OPEN_SUB_PAGE;
        }
        if (str.equalsIgnoreCase("OPEN_ACTION_SHEET")) {
            return OPEN_ACTION_SHEET;
        }
        if (str.equalsIgnoreCase("SERVER_ACTION")) {
            return SERVER_ACTION;
        }
        if (str.equalsIgnoreCase("TURN_OFF")) {
            return TURN_OFF;
        }
        if (str.equalsIgnoreCase("REPORT_BUG")) {
            return REPORT_BUG;
        }
        if (str.equalsIgnoreCase("OPEN_GROUP_SETTING")) {
            return OPEN_GROUP_SETTING;
        }
        if (str.equalsIgnoreCase("OPEN_EVENT_SETTING")) {
            return OPEN_EVENT_SETTING;
        }
        if (str.equalsIgnoreCase("OPEN_GROUP_DASHBOARD")) {
            return OPEN_GROUP_DASHBOARD;
        }
        if (str.equalsIgnoreCase("OPEN_EVENT_DASHBOARD")) {
            return OPEN_EVENT_DASHBOARD;
        }
        if (str.equalsIgnoreCase("OPEN_DEVICE_PUSH_SETTINGS")) {
            return OPEN_DEVICE_PUSH_SETTINGS;
        }
        if (str.equalsIgnoreCase("OPEN_SOUNDS_SETTING")) {
            return OPEN_SOUNDS_SETTING;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
