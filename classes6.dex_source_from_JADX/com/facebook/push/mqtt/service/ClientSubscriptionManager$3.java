package com.facebook.push.mqtt.service;

import com.google.common.collect.ImmutableList;

/* compiled from: soft */
class ClientSubscriptionManager$3 implements Runnable {
    final /* synthetic */ ImmutableList f4284a;
    final /* synthetic */ ImmutableList f4285b;
    final /* synthetic */ ClientSubscriptionManager f4286c;

    ClientSubscriptionManager$3(ClientSubscriptionManager clientSubscriptionManager, ImmutableList immutableList, ImmutableList immutableList2) {
        this.f4286c = clientSubscriptionManager;
        this.f4284a = immutableList;
        this.f4285b = immutableList2;
    }

    public void run() {
        this.f4286c.f.a(this.f4286c.m, this.f4284a, this.f4285b);
    }
}
