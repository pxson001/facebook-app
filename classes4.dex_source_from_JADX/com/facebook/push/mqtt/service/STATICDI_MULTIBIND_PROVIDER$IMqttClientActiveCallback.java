package com.facebook.push.mqtt.service;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.rtc.fbwebrtc.WebrtcMqttClientActiveCallback;
import com.facebook.rti.shared.skywalker.SkywalkerMqttClientActiveCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$IMqttClientActiveCallback implements MultiBindIndexedProvider<IMqttClientActiveCallback>, Provider<Set<IMqttClientActiveCallback>> {
    private final InjectorLike f10801a;

    private STATICDI_MULTIBIND_PROVIDER$IMqttClientActiveCallback(InjectorLike injectorLike) {
        this.f10801a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f10801a.getScopeAwareInjector(), this);
    }

    public static Set<IMqttClientActiveCallback> m11242a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$IMqttClientActiveCallback(injectorLike));
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return WebrtcMqttClientActiveCallback.m11281a((InjectorLike) injector);
            case 1:
                return SkywalkerMqttClientActiveCallback.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
