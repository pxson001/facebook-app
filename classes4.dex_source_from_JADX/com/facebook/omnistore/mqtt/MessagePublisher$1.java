package com.facebook.omnistore.mqtt;

import com.facebook.omnistore.mqtt.MessagePublisher.FailedToPublishException;
import com.facebook.push.mqtt.service.MqttPushServiceClient;
import java.util.concurrent.Callable;

/* compiled from: fb_server_last_register_time */
public class MessagePublisher$1 implements Callable<Void> {
    final /* synthetic */ MessagePublisher this$0;
    final /* synthetic */ byte[] val$payload;
    final /* synthetic */ String val$topicName;

    public MessagePublisher$1(MessagePublisher messagePublisher, String str, byte[] bArr) {
        this.this$0 = messagePublisher;
        this.val$topicName = str;
        this.val$payload = bArr;
    }

    public Void call() {
        MqttPushServiceClient a = this.this$0.mMqttPushServiceClientManager.a();
        try {
            if (a.mo864a(this.val$topicName, this.val$payload, 60000, this.this$0.mMonotonicClock.now())) {
                return null;
            }
            throw new FailedToPublishException();
        } finally {
            a.mo870f();
        }
    }
}
