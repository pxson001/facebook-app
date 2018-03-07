package com.facebook.mqtt.capabilities;

import com.facebook.inject.AbstractProvider;
import com.facebook.mqtt.capabilities.STATICDI_MULTIBIND_PROVIDER.RequiredMqttCapabilities;

/* compiled from: graphNotifsUpdateSeenStatePrams */
public class Long_MqttEndpointCapabilityMethodAutoProvider extends AbstractProvider<Long> {
    public Object get() {
        return MqttCapabilitiesModule.a(RequiredMqttCapabilities.a(this));
    }
}
