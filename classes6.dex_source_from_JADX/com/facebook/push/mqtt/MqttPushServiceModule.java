package com.facebook.push.mqtt;

import com.facebook.common.userinteraction.DeviceUserInteractionManager;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.push.mqtt.annotations.IsMqttDeviceForeground;
import java.util.concurrent.TimeUnit;

@InjectorModule
/* compiled from: source_story_id */
public class MqttPushServiceModule extends AbstractLibraryModule {
    public static final long f4265a = TimeUnit.SECONDS.toMillis(10);

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsMqttDeviceForeground
    public static Boolean m6360a(DeviceUserInteractionManager deviceUserInteractionManager) {
        boolean z = deviceUserInteractionManager.f.a() || deviceUserInteractionManager.g.a() - deviceUserInteractionManager.h <= f4265a;
        return Boolean.valueOf(z);
    }
}
