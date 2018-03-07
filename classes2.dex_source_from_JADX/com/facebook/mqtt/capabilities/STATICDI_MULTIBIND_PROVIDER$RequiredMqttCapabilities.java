package com.facebook.mqtt.capabilities;

import com.facebook.contacts.protocol.push.mqtt.MqttAggressivelyNotifyCapabilities;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.push.mqtt.capability.MqttVoipCapabilityImpl;
import com.facebook.rtc.push.mqtt.VoipRequiredMqttCapabilities;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$RequiredMqttCapabilities implements MultiBindIndexedProvider<RequiredMqttCapabilities>, Provider<Set<RequiredMqttCapabilities>> {
    private final InjectorLike f23613a;

    private STATICDI_MULTIBIND_PROVIDER$RequiredMqttCapabilities(InjectorLike injectorLike) {
        this.f23613a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f23613a.getScopeAwareInjector(), this);
    }

    public static Set<RequiredMqttCapabilities> m32001a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$RequiredMqttCapabilities(injectorLike));
    }

    public final int size() {
        return 3;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new MqttAggressivelyNotifyCapabilities();
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new com.facebook.orca.push.mqtt.MqttAggressivelyNotifyCapabilities();
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return new VoipRequiredMqttCapabilities(IdBasedProvider.m1811a(injector, 4314), IdBasedProvider.m1811a(injector, 4306), DeviceConditionHelper.m5526a((InjectorLike) injector), MqttVoipCapabilityImpl.m32007a((InjectorLike) injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
