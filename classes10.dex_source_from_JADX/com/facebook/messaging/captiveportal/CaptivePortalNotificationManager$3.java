package com.facebook.messaging.captiveportal;

import android.app.Notification;

/* compiled from: thread.notif_disabled */
public class CaptivePortalNotificationManager$3 implements Runnable {
    final /* synthetic */ Notification f1687a;
    final /* synthetic */ CaptivePortalNotificationManager f1688b;

    public CaptivePortalNotificationManager$3(CaptivePortalNotificationManager captivePortalNotificationManager, Notification notification) {
        this.f1688b = captivePortalNotificationManager;
        this.f1687a = notification;
    }

    public void run() {
        if (this.f1688b.e.a(10011)) {
            this.f1688b.e.a(10011, this.f1687a);
        } else {
            this.f1688b.g.a("CaptivePortalNotificationManager", "Unable to safeCancelAndNotifyWithRetry");
        }
    }
}
