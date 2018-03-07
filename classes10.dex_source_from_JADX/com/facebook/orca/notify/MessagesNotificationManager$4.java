package com.facebook.orca.notify;

/* compiled from: no_need_to_request_geofence */
class MessagesNotificationManager$4 implements Runnable {
    final /* synthetic */ long f6240a;
    final /* synthetic */ MessagesNotificationManager f6241b;

    MessagesNotificationManager$4(MessagesNotificationManager messagesNotificationManager, long j) {
        this.f6241b = messagesNotificationManager;
        this.f6240a = j;
    }

    public void run() {
        MessagesNotificationManager.c(this.f6241b, "clearFuture:" + this.f6240a);
    }
}
