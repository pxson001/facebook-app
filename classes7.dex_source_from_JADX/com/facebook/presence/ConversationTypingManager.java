package com.facebook.presence;

import com.facebook.inject.Lazy;
import com.facebook.mqtt.messages.MqttQOSLevel;
import com.facebook.mqtt.model.thrift.TypingFromClientThrift;
import com.facebook.presence.TypingPresenceManager.TypingState;
import com.facebook.push.mqtt.service.ChannelConnectivityTracker;
import com.facebook.push.mqtt.service.MqttPushServiceWrapper;
import com.facebook.thrift.TException;
import com.facebook.thrift.TSerializer;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import javax.inject.Inject;

/* compiled from: image_sizes */
public class ConversationTypingManager implements TypingPresenceManager {
    private final Lazy<MqttPushServiceWrapper> f11166a;
    private final Lazy<ChannelConnectivityTracker> f11167b;

    @Inject
    public ConversationTypingManager(Lazy<MqttPushServiceWrapper> lazy, Lazy<ChannelConnectivityTracker> lazy2) {
        this.f11166a = lazy;
        this.f11167b = lazy2;
    }

    public final void mo616a(String str, TypingState typingState) {
        if (((ChannelConnectivityTracker) this.f11167b.get()).f()) {
            m13091a(str, typingState == TypingState.ACTIVE ? 1 : 0);
        }
    }

    private void m13091a(String str, int i) {
        try {
            Object a = new TSerializer(new Factory()).a(new TypingFromClientThrift(Long.valueOf(Long.parseLong(str)), null, Integer.valueOf(i)));
            Object obj = new byte[(a.length + 1)];
            System.arraycopy(a, 0, obj, 1, a.length);
            ((MqttPushServiceWrapper) this.f11166a.get()).a("/t_st", obj, MqttQOSLevel.FIRE_AND_FORGET, null);
        } catch (TException e) {
            new Object[1][0] = e.getMessage() != null ? e.getMessage() : "NULL";
        }
    }
}
