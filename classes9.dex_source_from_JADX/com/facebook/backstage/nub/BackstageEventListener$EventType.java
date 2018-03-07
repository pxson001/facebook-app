package com.facebook.backstage.nub;

/* compiled from: request_nux_banner_impression_count */
public enum BackstageEventListener$EventType {
    SERVICE_STARTED,
    ACTION_CLOSE_SYSTEM_DIALOGS,
    ACTION_SCREEN_OFF,
    ACTION_SCREEN_ON,
    ACTION_USER_PRESENT,
    ACTION_HIDE;

    public static BackstageEventListener$EventType getEventType(String str) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -2128145023:
                if (str.equals("android.intent.action.SCREEN_OFF")) {
                    obj = 1;
                    break;
                }
                break;
            case -1454123155:
                if (str.equals("android.intent.action.SCREEN_ON")) {
                    obj = 3;
                    break;
                }
                break;
            case -403228793:
                if (str.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                    obj = null;
                    break;
                }
                break;
            case 823795052:
                if (str.equals("android.intent.action.USER_PRESENT")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return ACTION_CLOSE_SYSTEM_DIALOGS;
            case 1:
                return ACTION_SCREEN_OFF;
            case 2:
                return ACTION_USER_PRESENT;
            case 3:
                return ACTION_SCREEN_ON;
            default:
                throw new UnsupportedOperationException("Unknown intent name that is not registered.");
        }
    }
}
