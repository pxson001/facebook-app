package com.facebook.rtc.push.mqtt;

import com.facebook.device.DeviceConditionHelper;
import com.facebook.mqtt.capabilities.MqttCapability;
import com.facebook.mqtt.capabilities.RequiredMqttCapabilities;
import com.facebook.push.mqtt.capability.MqttVoipCapability;
import com.facebook.push.mqtt.capability.MqttVoipCapabilityImpl;
import java.util.EnumSet;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: flatbuffer */
public class VoipRequiredMqttCapabilities implements RequiredMqttCapabilities {
    private final Provider<Boolean> f23614a;
    private final Provider<Boolean> f23615b;
    private final DeviceConditionHelper f23616c;
    private MqttVoipCapabilityImpl f23617d;

    @Inject
    public VoipRequiredMqttCapabilities(Provider<Boolean> provider, Provider<Boolean> provider2, DeviceConditionHelper deviceConditionHelper, MqttVoipCapability mqttVoipCapability) {
        this.f23614a = provider;
        this.f23615b = provider2;
        this.f23616c = deviceConditionHelper;
        this.f23617d = mqttVoipCapability;
    }

    public final EnumSet<MqttCapability> mo3495a() {
        if (!((Boolean) this.f23614a.get()).booleanValue()) {
            return EnumSet.noneOf(MqttCapability.class);
        }
        if (((Boolean) this.f23615b.get()).booleanValue()) {
            return EnumSet.of(MqttCapability.VOIP, MqttCapability.VOIP_WEB, MqttCapability.ONE_ON_ONE_OVER_MULTIWAY);
        }
        return EnumSet.of(MqttCapability.VOIP, MqttCapability.VOIP_WEB);
    }
}
