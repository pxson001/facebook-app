package com.facebook.push.mqtt;

import com.facebook.inject.AbstractProvider;

/* compiled from: has_sms_contact_permissions */
public class Boolean_DisableMqttPushServiceMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return MqttPushClientModule.a();
    }
}
