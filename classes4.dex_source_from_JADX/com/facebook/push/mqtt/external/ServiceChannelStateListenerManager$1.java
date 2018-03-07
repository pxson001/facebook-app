package com.facebook.push.mqtt.external;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.facebook.push.mqtt.ipc.MqttChannelStateListener;

/* compiled from: gl_mtrack */
class ServiceChannelStateListenerManager$1 implements DeathRecipient {
    final /* synthetic */ IBinder f11035a;
    final /* synthetic */ ServiceChannelStateListenerManager f11036b;

    ServiceChannelStateListenerManager$1(ServiceChannelStateListenerManager serviceChannelStateListenerManager, IBinder iBinder) {
        this.f11036b = serviceChannelStateListenerManager;
        this.f11035a = iBinder;
    }

    public void binderDied() {
        this.f11036b.b((MqttChannelStateListener) this.f11036b.a.get(this.f11035a));
    }
}
