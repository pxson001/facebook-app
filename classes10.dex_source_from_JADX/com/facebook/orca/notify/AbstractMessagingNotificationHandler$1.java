package com.facebook.orca.notify;

import com.facebook.messaging.notify.MessagingNotification.Type;

/* compiled from: notification_prefetch */
/* synthetic */ class AbstractMessagingNotificationHandler$1 {
    static final /* synthetic */ int[] f6181a = new int[Type.values().length];

    static {
        try {
            f6181a[Type.NEW_MESSAGE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f6181a[Type.LOGGED_OUT_MESSAGE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f6181a[Type.USER_LOGGED_OUT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f6181a[Type.FRIEND_INSTALL.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f6181a[Type.P2P_PAYMENT.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f6181a[Type.FAILED_TO_SEND.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f6181a[Type.READ_THREAD.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f6181a[Type.NEW_BUILD.ordinal()] = 8;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f6181a[Type.PROMOTION.ordinal()] = 9;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f6181a[Type.STALE.ordinal()] = 10;
        } catch (NoSuchFieldError e10) {
        }
        try {
            f6181a[Type.MESSAGE_REQUEST.ordinal()] = 11;
        } catch (NoSuchFieldError e11) {
        }
        try {
            f6181a[Type.TINCAN_MESSAGE_REQUEST.ordinal()] = 12;
        } catch (NoSuchFieldError e12) {
        }
        try {
            f6181a[Type.MULTIPLE_ACCOUNTS_NEW_MESSAGES.ordinal()] = 13;
        } catch (NoSuchFieldError e13) {
        }
        try {
            f6181a[Type.JOIN_REQUEST.ordinal()] = 14;
        } catch (NoSuchFieldError e14) {
        }
        try {
            f6181a[Type.SWITCH_TO_FB_ACCOUNT.ordinal()] = 15;
        } catch (NoSuchFieldError e15) {
        }
        try {
            f6181a[Type.INTERNAL.ordinal()] = 16;
        } catch (NoSuchFieldError e16) {
        }
        try {
            f6181a[Type.MISSED_CALL.ordinal()] = 17;
        } catch (NoSuchFieldError e17) {
        }
        try {
            f6181a[Type.INCOMING_CALL.ordinal()] = 18;
        } catch (NoSuchFieldError e18) {
        }
        try {
            f6181a[Type.RTC_CALLEE_READY.ordinal()] = 19;
        } catch (NoSuchFieldError e19) {
        }
        try {
            f6181a[Type.PRE_REG_PUSH.ordinal()] = 20;
        } catch (NoSuchFieldError e20) {
        }
    }
}
