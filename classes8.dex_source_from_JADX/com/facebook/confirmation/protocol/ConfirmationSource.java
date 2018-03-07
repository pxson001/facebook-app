package com.facebook.confirmation.protocol;

/* compiled from: instant_article_tracking_codes */
public enum ConfirmationSource {
    UNKNOWN,
    ANDROID_AUTO_SMS_API,
    ANDROID_DIALOG_API,
    MOBILE_CONF_EMAIL,
    MOBILE_SUBNO;

    public static ConfirmationSource safeValueOf(String str) {
        return str == null ? UNKNOWN : valueOf(str);
    }
}
