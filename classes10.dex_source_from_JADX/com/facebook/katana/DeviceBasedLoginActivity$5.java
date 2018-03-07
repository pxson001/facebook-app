package com.facebook.katana;

import com.facebook.katana.service.AppSession.LoginStatus;

/* compiled from: SEGMENT_UPLOADING_FAILURE */
/* synthetic */ class DeviceBasedLoginActivity$5 {
    static final /* synthetic */ int[] f24177a = new int[LoginStatus.values().length];

    static {
        try {
            f24177a[LoginStatus.STATUS_LOGGED_IN.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f24177a[LoginStatus.STATUS_LOGGING_IN.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
