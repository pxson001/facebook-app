package com.facebook.katana.push.mqtt;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.katana.annotations.ForFbandroidApp;
import com.facebook.push.mqtt.persistence.MqttSubscriptionPersistence;
import com.facebook.push.mqtt.service.IProvideSubscribeTopics;
import com.facebook.push.mqtt.service.SubscribeTopic;
import com.google.common.collect.ImmutableMap;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: high_frequency_end_time */
public class FbandroidMqttPushModule extends AbstractLibraryModule {

    /* compiled from: high_frequency_end_time */
    final class C04981 implements IProvideSubscribeTopics {
        C04981() {
        }

        public final ImmutableMap<SubscribeTopic, MqttSubscriptionPersistence> get() {
            return ImmutableMap.of(new SubscribeTopic("/t_inbox", 0), MqttSubscriptionPersistence.APP_USE, new SubscribeTopic("/inbox", 0), MqttSubscriptionPersistence.APP_USE, new SubscribeTopic("/mobile_requests_count", 0), MqttSubscriptionPersistence.ALWAYS, new SubscribeTopic("/friend_requests_seen", 0), MqttSubscriptionPersistence.APP_USE);
        }
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    @ForFbandroidApp
    static IProvideSubscribeTopics m11196a() {
        return new C04981();
    }
}
