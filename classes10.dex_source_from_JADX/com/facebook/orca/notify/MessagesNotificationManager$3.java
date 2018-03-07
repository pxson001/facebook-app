package com.facebook.orca.notify;

/* compiled from: no_need_to_request_geofence */
class MessagesNotificationManager$3 implements Runnable {
    final /* synthetic */ MessagesNotificationManager f6239a;

    MessagesNotificationManager$3(MessagesNotificationManager messagesNotificationManager) {
        this.f6239a = messagesNotificationManager;
    }

    public void run() {
        MessagesNotificationManager.c(this.f6239a, "handleFolderCounts");
    }
}
