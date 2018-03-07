package com.facebook.omnistore.mqtt;

import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClockMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.push.mqtt.service.MqttPushServiceClientManagerImpl;

/* compiled from: target_height */
public class MessagePublisherAutoProvider extends AbstractProvider<MessagePublisher> {
    public /* bridge */ /* synthetic */ Object get() {
        return new MessagePublisher(MqttPushServiceClientManagerImpl.a(this), (MonotonicClock) RealtimeSinceBootClockMethodAutoProvider.a(this));
    }
}
