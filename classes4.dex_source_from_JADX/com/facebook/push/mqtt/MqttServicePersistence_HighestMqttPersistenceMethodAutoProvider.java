package com.facebook.push.mqtt;

import com.facebook.inject.AbstractProvider;
import com.facebook.push.mqtt.persistence.MqttServicePersistence;
import com.facebook.push.mqtt.persistence.STATICDI_MULTIBIND_PROVIDER$MqttPersistenceRequirement;

/* compiled from: has_phone_permissions */
public class MqttServicePersistence_HighestMqttPersistenceMethodAutoProvider extends AbstractProvider<MqttServicePersistence> {
    public Object get() {
        return MqttPushModule.m11159a(STATICDI_MULTIBIND_PROVIDER$MqttPersistenceRequirement.m11295a(this));
    }
}
