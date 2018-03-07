package com.facebook.messaging.captiveportal;

/* compiled from: thread.notif_disabled */
public class CaptivePortalNotificationManager$2 implements Runnable {
    final /* synthetic */ CaptivePortalNotificationManager f1686a;

    public CaptivePortalNotificationManager$2(CaptivePortalNotificationManager captivePortalNotificationManager) {
        this.f1686a = captivePortalNotificationManager;
    }

    public void run() {
        if (!this.f1686a.e.a(10011)) {
            this.f1686a.g.a("CaptivePortalNotificationManager", "Unable to safeCancelWithRetry");
        }
    }
}
