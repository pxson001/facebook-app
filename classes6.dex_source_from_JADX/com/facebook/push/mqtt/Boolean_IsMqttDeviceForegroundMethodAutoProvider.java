package com.facebook.push.mqtt;

import com.facebook.common.userinteraction.DeviceUserInteractionManager;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: speed_test_timeout_seconds */
public class Boolean_IsMqttDeviceForegroundMethodAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m6354b(InjectorLike injectorLike) {
        return MqttPushServiceModule.m6360a(DeviceUserInteractionManager.a(injectorLike));
    }

    public Object get() {
        return MqttPushServiceModule.m6360a(DeviceUserInteractionManager.a(this));
    }
}
