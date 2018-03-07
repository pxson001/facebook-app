package com.facebook.orca.push.mqtt;

import com.facebook.mqtt.capabilities.MqttCapability;
import com.facebook.mqtt.capabilities.RequiredMqttCapabilities;
import java.util.EnumSet;

/* compiled from: flatbuffer_schema_id=10154690582226729 */
public class MqttAggressivelyNotifyCapabilities implements RequiredMqttCapabilities {
    public final EnumSet<MqttCapability> mo3495a() {
        return EnumSet.of(MqttCapability.MQTT_AGGRESSIVELY_NOTIFY);
    }
}
