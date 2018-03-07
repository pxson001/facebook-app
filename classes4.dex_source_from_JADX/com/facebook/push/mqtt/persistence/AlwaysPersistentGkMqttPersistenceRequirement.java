package com.facebook.push.mqtt.persistence;

import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: has_multisim_api */
public class AlwaysPersistentGkMqttPersistenceRequirement implements MqttPersistenceRequirement {
    private final Provider<Boolean> f10835a;

    @Inject
    public AlwaysPersistentGkMqttPersistenceRequirement(Provider<Boolean> provider) {
        this.f10835a = provider;
    }

    public final MqttServicePersistence mo827a() {
        return ((Boolean) this.f10835a.get()).booleanValue() ? MqttServicePersistence.ALWAYS : MqttServicePersistence.APP_USE;
    }
}
