package com.facebook.presence;

import com.facebook.mqtt.messages.MqttQOSLevel;
import com.facebook.push.mqtt.service.MqttPushServiceWrapper;

/* compiled from: image_block_image */
class ThreadPresenceManager$4 implements Runnable {
    final /* synthetic */ int f11191a;
    final /* synthetic */ byte[] f11192b;
    final /* synthetic */ ThreadPresenceManager f11193c;

    ThreadPresenceManager$4(ThreadPresenceManager threadPresenceManager, int i, byte[] bArr) {
        this.f11193c = threadPresenceManager;
        this.f11191a = i;
        this.f11192b = bArr;
    }

    public void run() {
        if (this.f11191a == 2) {
            this.f11193c.h.a("thread_presence_ack_post");
        } else {
            this.f11193c.h.a("thread_presence_post");
        }
        ((MqttPushServiceWrapper) this.f11193c.b.get()).a("/t_stp", this.f11192b, MqttQOSLevel.FIRE_AND_FORGET, null);
        Integer.valueOf(this.f11191a);
        Integer.valueOf(this.f11193c.r);
    }
}
