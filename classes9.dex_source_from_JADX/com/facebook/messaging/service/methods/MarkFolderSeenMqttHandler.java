package com.facebook.messaging.service.methods;

import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.mqtt.model.thrift.FolderViewed;
import com.facebook.push.mqtt.service.MqttPushServiceClient;
import com.facebook.push.mqtt.service.MqttPushServiceClientManagerImpl;
import com.facebook.thrift.TSerializer;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import javax.inject.Inject;

/* compiled from: custom_voicemail_delete */
public class MarkFolderSeenMqttHandler {
    private final MqttPushServiceClientManagerImpl f16933a;

    @Inject
    public MarkFolderSeenMqttHandler(MqttPushServiceClientManagerImpl mqttPushServiceClientManagerImpl) {
        this.f16933a = mqttPushServiceClientManagerImpl;
    }

    public final OperationResult m16965a() {
        OperationResult a;
        MqttPushServiceClient a2 = this.f16933a.a();
        try {
            if (a2.b()) {
                Object a3 = new TSerializer(new Factory()).a(new FolderViewed(null, Boolean.valueOf(true)));
                Object obj = new byte[(a3.length + 1)];
                System.arraycopy(a3, 0, obj, 1, a3.length);
                if (a2.a("/t_mf_as", obj, 30000, 0)) {
                    a = OperationResult.a();
                    a2.f();
                } else {
                    a = OperationResult.a(ErrorCode.MQTT_SEND_FAILURE);
                    a2.f();
                }
            } else {
                a = OperationResult.a(ErrorCode.CONNECTION_FAILURE);
            }
        } catch (Throwable e) {
            a = OperationResult.a(ErrorCode.MQTT_SEND_FAILURE, e);
        } finally {
            a2.f();
        }
        return a;
    }
}
