package com.facebook.push.mqtt.service;

import com.facebook.debug.log.BLog;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: soft */
class ClientSubscriptionManager$1 implements Runnable {
    final /* synthetic */ ImmutableList f4281a;
    final /* synthetic */ ImmutableList f4282b;
    final /* synthetic */ ClientSubscriptionManager f4283c;

    ClientSubscriptionManager$1(ClientSubscriptionManager clientSubscriptionManager, ImmutableList immutableList, ImmutableList immutableList2) {
        this.f4283c = clientSubscriptionManager;
        this.f4281a = immutableList;
        this.f4282b = immutableList2;
    }

    public void run() {
        try {
            if (this.f4283c.m != null) {
                List a = ClientSubscriptionManager.a(this.f4281a);
                List a2 = Lists.a();
                int size = this.f4282b.size();
                for (int i = 0; i < size; i++) {
                    a2.add(((SubscribeTopic) this.f4282b.get(i)).a());
                }
                this.f4283c.m.a(this.f4283c.n, a, a2);
                return;
            }
            this.f4283c.e.a(this.f4283c.m, this.f4281a, this.f4282b);
        } catch (Throwable e) {
            BLog.b("ClientSubscriptionManager", "Ipc call failed", e);
        }
    }
}
