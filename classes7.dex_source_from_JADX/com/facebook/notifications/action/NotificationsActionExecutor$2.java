package com.facebook.notifications.action;

import com.facebook.graphql.enums.GraphQLNotifOptionClientActionType;
import com.facebook.graphql.enums.GraphQLNotifOptionRowSetDisplayStyle;

/* compiled from: no_crop */
/* synthetic */ class NotificationsActionExecutor$2 {
    static final /* synthetic */ int[] f8124a = new int[GraphQLNotifOptionClientActionType.values().length];
    static final /* synthetic */ int[] f8125b = new int[GraphQLNotifOptionRowSetDisplayStyle.values().length];

    static {
        try {
            f8125b[GraphQLNotifOptionRowSetDisplayStyle.SINGLE_SELECTOR.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f8124a[GraphQLNotifOptionClientActionType.OPEN_SUB_PAGE.ordinal()] = 1;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f8124a[GraphQLNotifOptionClientActionType.OPEN_ACTION_SHEET.ordinal()] = 2;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f8124a[GraphQLNotifOptionClientActionType.MODSUB.ordinal()] = 3;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f8124a[GraphQLNotifOptionClientActionType.UNSUB.ordinal()] = 4;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f8124a[GraphQLNotifOptionClientActionType.SERVER_ACTION.ordinal()] = 5;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f8124a[GraphQLNotifOptionClientActionType.OPEN_EVENT_SETTING.ordinal()] = 6;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f8124a[GraphQLNotifOptionClientActionType.OPEN_GROUP_SETTING.ordinal()] = 7;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f8124a[GraphQLNotifOptionClientActionType.OPEN_SOUNDS_SETTING.ordinal()] = 8;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f8124a[GraphQLNotifOptionClientActionType.OPEN_GROUP_DASHBOARD.ordinal()] = 9;
        } catch (NoSuchFieldError e10) {
        }
        try {
            f8124a[GraphQLNotifOptionClientActionType.OPEN_EVENT_DASHBOARD.ordinal()] = 10;
        } catch (NoSuchFieldError e11) {
        }
        try {
            f8124a[GraphQLNotifOptionClientActionType.OPEN_DEVICE_PUSH_SETTINGS.ordinal()] = 11;
        } catch (NoSuchFieldError e12) {
        }
        try {
            f8124a[GraphQLNotifOptionClientActionType.SHOW_MORE.ordinal()] = 12;
        } catch (NoSuchFieldError e13) {
        }
        try {
            f8124a[GraphQLNotifOptionClientActionType.HIDE.ordinal()] = 13;
        } catch (NoSuchFieldError e14) {
        }
    }
}
