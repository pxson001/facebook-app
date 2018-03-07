package com.facebook.messaging.sms.abtest;

import java.util.Locale;

/* compiled from: is_disk_recording_enabled */
public enum SmsOptinFlow {
    NO_OPTIN,
    OPTIN_FULL_MODE,
    OPTIN_READ_ONLY_OR_FULL_MODE;

    public final String toString() {
        return name().toLowerCase(Locale.US);
    }
}
