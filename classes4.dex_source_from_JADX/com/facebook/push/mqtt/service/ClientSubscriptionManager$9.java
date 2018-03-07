package com.facebook.push.mqtt.service;

import android.os.RemoteException;
import com.facebook.push.mqtt.ipc.IMqttPushService;

/* compiled from: time_to_first_sync */
public class ClientSubscriptionManager$9 implements Runnable {
    final /* synthetic */ IMqttPushService f11052a;
    final /* synthetic */ ClientSubscriptionManager f11053b;

    public ClientSubscriptionManager$9(ClientSubscriptionManager clientSubscriptionManager, IMqttPushService iMqttPushService) {
        this.f11053b = clientSubscriptionManager;
        this.f11052a = iMqttPushService;
    }

    public void run() {
        ClientSubscriptionManager.a(this.f11053b, this.f11052a);
        try {
            if (((Boolean) this.f11053b.j.get()).booleanValue()) {
                this.f11052a.a(this.f11053b.n);
            }
            ClientSubscriptionManager.b(this.f11053b);
            this.f11053b.e.a(this.f11052a);
            this.f11053b.f.a(this.f11052a);
        } catch (RemoteException e) {
        }
    }
}
