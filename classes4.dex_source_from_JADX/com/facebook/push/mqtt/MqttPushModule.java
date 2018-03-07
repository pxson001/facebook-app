package com.facebook.push.mqtt;

import android.os.Handler;
import com.facebook.common.executors.HandlerListeningExecutorServiceImpl;
import com.facebook.common.executors.WakingExecutorServiceProvider;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.push.mqtt.annotations.ForMqttThreadWakeup;
import com.facebook.push.mqtt.annotations.HighestMqttPersistence;
import com.facebook.push.mqtt.external.MqttThread;
import com.facebook.push.mqtt.persistence.MqttPersistenceRequirement;
import com.facebook.push.mqtt.persistence.MqttServicePersistence;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.Collections;
import java.util.Set;
import javax.inject.Singleton;

@InjectorModule
@Deprecated
/* compiled from: hours */
public class MqttPushModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @HighestMqttPersistence
    public static MqttServicePersistence m11159a(Set<MqttPersistenceRequirement> set) {
        Builder builder = ImmutableSet.builder();
        for (MqttPersistenceRequirement a : set) {
            builder.c(a.mo827a());
        }
        return builder.b().isEmpty() ? MqttServicePersistence.APP_USE : (MqttServicePersistence) Collections.max(builder.b());
    }

    @ProviderMethod
    @Singleton
    @MqttThread
    static ListeningScheduledExecutorService m11160a(Handler handler) {
        return new HandlerListeningExecutorServiceImpl(handler);
    }

    @ProviderMethod
    @Singleton
    @ForMqttThreadWakeup
    static ListeningScheduledExecutorService m11161a(WakingExecutorServiceProvider wakingExecutorServiceProvider, Handler handler) {
        return wakingExecutorServiceProvider.m8508a("Mqtt_Wakeup", handler);
    }
}
