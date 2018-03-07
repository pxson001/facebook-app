package com.facebook.api.ufiservices.common;

/* compiled from: android_package_name */
public class NotificationSourceUtil {
    public static NotificationSource m18410a(String str) {
        if ("tap_notification_jewel".equals(str)) {
            return NotificationSource.JEWEL;
        }
        if ("tap_system_tray_notification".equals(str)) {
            return NotificationSource.PUSH;
        }
        return NotificationSource.UNKNOWN;
    }
}
