package com.facebook.push.mqtt.service;

/* compiled from: time_to_first_sync */
public class ClientSubscriptionManager$10 implements Runnable {
    final /* synthetic */ ClientSubscriptionManager f1021a;

    public ClientSubscriptionManager$10(ClientSubscriptionManager clientSubscriptionManager) {
        this.f1021a = clientSubscriptionManager;
    }

    public void run() {
        this.f1021a.m = null;
        this.f1021a.l = false;
    }
}
