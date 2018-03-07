package com.facebook.push.mqtt.service;

import java.util.List;

/* compiled from: time_to_first_sync */
public class ClientSubscriptionManager$4 implements Runnable {
    final /* synthetic */ List f10765a;
    final /* synthetic */ ClientSubscriptionManager f10766b;

    public ClientSubscriptionManager$4(ClientSubscriptionManager clientSubscriptionManager, List list) {
        this.f10766b = clientSubscriptionManager;
        this.f10765a = list;
    }

    public void run() {
        ClientSubscriptionManager.b(this.f10766b, this.f10765a);
    }
}
