package com.facebook.push.mqtt.service;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$MqttClientStateChangeListener implements MultiBindIndexedProvider<MqttClientStateChangeListener>, Provider<Set<MqttClientStateChangeListener>> {
    private final InjectorLike f10723a;

    public STATICDI_MULTIBIND_PROVIDER$MqttClientStateChangeListener(InjectorLike injectorLike) {
        this.f10723a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f10723a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return ClientSubscriptionAutoSubscriber.m7773a((InjectorLike) injector);
            case 1:
                return MqttPushServiceManager.m11221a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
