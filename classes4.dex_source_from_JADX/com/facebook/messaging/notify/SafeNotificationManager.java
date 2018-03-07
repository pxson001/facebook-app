package com.facebook.messaging.notify;

import android.app.Notification;
import android.app.NotificationManager;
import javax.inject.Inject;

/* compiled from: is_mms */
public class SafeNotificationManager {
    private final NotificationManager f9955a;

    @Inject
    public SafeNotificationManager(NotificationManager notificationManager) {
        this.f9955a = notificationManager;
    }

    public final boolean m10331a(int i) {
        try {
            this.f9955a.cancel(i);
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public final boolean m10332a(int i, Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("notification cannot be null");
        }
        try {
            this.f9955a.notify(i, notification);
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }
}
