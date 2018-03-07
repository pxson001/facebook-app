package com.facebook.katana;

import com.facebook.katana.service.AppSession.LoginStatus;

/* compiled from: via_chat_bar_suggestions_section */
/* synthetic */ class FacebookAccountReceiver$2 {
    static final /* synthetic */ int[] f529a = new int[LoginStatus.values().length];

    static {
        try {
            f529a[LoginStatus.STATUS_LOGGING_IN.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f529a[LoginStatus.STATUS_LOGGED_IN.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f529a[LoginStatus.STATUS_LOGGED_OUT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f529a[LoginStatus.STATUS_LOGGING_OUT.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
