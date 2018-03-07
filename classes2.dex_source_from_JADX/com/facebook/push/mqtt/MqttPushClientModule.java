package com.facebook.push.mqtt;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.push.mqtt.service.MqttBindTimeoutMs;

@InjectorModule
/* compiled from: mKeyFrames */
public class MqttPushClientModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @DisableMqttPushService
    public static Boolean m22164a() {
        return Boolean.valueOf(false);
    }

    @ProviderMethod
    @MqttBindTimeoutMs
    public static Long m22165b() {
        return Long.valueOf(10000);
    }
}
