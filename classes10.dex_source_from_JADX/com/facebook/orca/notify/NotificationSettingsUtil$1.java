package com.facebook.orca.notify;

import com.facebook.messaging.model.threads.NotificationState;

/* compiled from: nmv */
/* synthetic */ class NotificationSettingsUtil$1 {
    static final /* synthetic */ int[] f6263a = new int[NotificationState.values().length];

    static {
        try {
            f6263a[NotificationState.Enabled.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f6263a[NotificationState.PermanentlyDisabled.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f6263a[NotificationState.TemporarilyMuted.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
