package com.facebook.orca.notify;

import com.facebook.messaging.notify.FailedToSendMessageNotification.FailureReason;
import com.facebook.messaging.notify.NewMessageNotification.PresenceLevel;

/* compiled from: not recognized */
public /* synthetic */ class DefaultMessagingNotificationHandler$11 {
    public static final /* synthetic */ int[] f6195a = new int[PresenceLevel.values().length];
    static final /* synthetic */ int[] f6196b = new int[DefaultMessagingNotificationHandler$CallResponseType.values().length];
    static final /* synthetic */ int[] f6197c = new int[FailureReason.values().length];

    static {
        try {
            f6197c[FailureReason.CAPTIVE_PORTAL.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f6197c[FailureReason.LONG_QUEUE_TIME.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f6197c[FailureReason.RESTRICTED_BACKGROUND_MODE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f6197c[FailureReason.MEDIA_UPLOAD_FILE_NOT_FOUND_LOW_DISK_SPACE.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f6197c[FailureReason.UNKNOWN.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f6196b[DefaultMessagingNotificationHandler$CallResponseType.ANSWER.ordinal()] = 1;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f6196b[DefaultMessagingNotificationHandler$CallResponseType.SHOW_INCALL.ordinal()] = 2;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f6196b[DefaultMessagingNotificationHandler$CallResponseType.DECLINE.ordinal()] = 3;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f6195a[PresenceLevel.IN_APP_ACTIVE_30S.ordinal()] = 1;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f6195a[PresenceLevel.IN_APP_ACTIVE_10S.ordinal()] = 2;
        } catch (NoSuchFieldError e10) {
        }
        try {
            f6195a[PresenceLevel.IN_APP_IDLE.ordinal()] = 3;
        } catch (NoSuchFieldError e11) {
        }
        try {
            f6195a[PresenceLevel.NOT_IN_APP.ordinal()] = 4;
        } catch (NoSuchFieldError e12) {
        }
    }
}
