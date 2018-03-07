package com.facebook.omnistore.mqtt;

import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.push.mqtt.service.MqttPushServiceClientManagerImpl;
import javax.inject.Inject;

/* compiled from: mLoader= */
public class MessagePublisher {
    public final MonotonicClock mMonotonicClock;
    public final MqttPushServiceClientManagerImpl mMqttPushServiceClientManager;

    public static MessagePublisher m22137xa42df3f6(InjectorLike injectorLike) {
        return new MessagePublisher(MqttPushServiceClientManagerImpl.m22138a(injectorLike), RealtimeSinceBootClockMethodAutoProvider.m6582a(injectorLike));
    }

    @Inject
    public MessagePublisher(MqttPushServiceClientManagerImpl mqttPushServiceClientManagerImpl, MonotonicClock monotonicClock) {
        this.mMqttPushServiceClientManager = mqttPushServiceClientManagerImpl;
        this.mMonotonicClock = monotonicClock;
    }
}
