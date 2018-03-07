package com.facebook.push;

/* compiled from: icon_count */
public enum PushSource {
    ADM,
    C2DM,
    NNA,
    MQTT,
    MQTT_PUSH,
    FBNS,
    MMS,
    FBNS_LITE,
    INTEGRATION_TEST,
    SMS_DEFAULT_APP,
    SMS_READONLY_MODE,
    TINCAN;

    public static boolean isPushNotification(String str) {
        boolean z = false;
        if (str != null) {
            try {
                z = isPushNotification(valueOf(str));
            } catch (IllegalArgumentException e) {
            }
        }
        return z;
    }

    public static boolean isPushNotification(PushSource pushSource) {
        return pushSource == ADM || pushSource == C2DM || pushSource == NNA || pushSource == MQTT_PUSH || pushSource == FBNS || pushSource == FBNS_LITE;
    }
}
