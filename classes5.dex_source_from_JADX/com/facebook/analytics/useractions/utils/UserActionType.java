package com.facebook.analytics.useractions.utils;

import java.util.Locale;

/* compiled from: throwback_media_attachments */
public enum UserActionType {
    SESSION_STARTED,
    BUTTON_CLICK,
    BACK_PRESSED;

    public final String toString() {
        return "user_actions_" + super.toString().toLowerCase(Locale.US);
    }

    public static UserActionType parseUserActionType(String str) {
        return valueOf(str.substring(13).toUpperCase(Locale.US));
    }
}
