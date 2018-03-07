package com.facebook.messaging.sms.abtest;

import java.util.Locale;

/* compiled from: is_edit_composer */
public enum ReadonlyModeNotificationType {
    CHATHEAD_SYSTEM_NOTIFICATIONS_OFF,
    CHATHEAD_SYSTEM_NOTIFICATIONS_ON,
    CHATHEAD_NOTIFICATIONS_ON,
    GENTLE_CHATHEAD_SYSTEM_NOTIFICATIONS_ON,
    GENTLE_CHATHEAD_NOTIFICATIONS_ON;

    public final String toString() {
        return name().toLowerCase(Locale.US);
    }
}
