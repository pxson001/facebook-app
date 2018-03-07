package com.facebook.push.mqtt.service;

import com.facebook.push.mqtt.persistence.MqttSubscriptionPersistence;
import com.google.common.base.Objects;

/* compiled from: snackbar */
public class MqttDynamicTopic {
    public final SubscribeTopic f4293a;
    public final MqttSubscriptionPersistence f4294b;
    public boolean f4295c = false;

    public MqttDynamicTopic(String str, int i, MqttSubscriptionPersistence mqttSubscriptionPersistence) {
        this.f4293a = new SubscribeTopic(str, i);
        this.f4294b = mqttSubscriptionPersistence;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttDynamicTopic)) {
            return false;
        }
        MqttDynamicTopic mqttDynamicTopic = (MqttDynamicTopic) obj;
        if (this.f4293a.equals(mqttDynamicTopic.f4293a) && this.f4294b == mqttDynamicTopic.f4294b && this.f4295c == mqttDynamicTopic.f4295c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f4293a, this.f4294b, Boolean.valueOf(this.f4295c)});
    }
}
