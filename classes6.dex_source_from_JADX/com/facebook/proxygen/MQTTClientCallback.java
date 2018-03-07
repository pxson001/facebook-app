package com.facebook.proxygen;

/* compiled from: time_since_last_fetch */
public interface MQTTClientCallback {
    void onConnectFailure(MQTTClientError mQTTClientError);

    void onConnectSuccess(byte[] bArr);

    void onError(MQTTClientError mQTTClientError);

    void onPingRequestFailure(MQTTClientError mQTTClientError);

    void onPingRequestSent();

    void onPingResponse();

    void onPublish(String str, byte[] bArr, int i, int i2);

    void onPublishAck(int i);

    void onPublishAckFailure(MQTTClientError mQTTClientError);

    void onPublishFailure(int i, MQTTClientError mQTTClientError);

    void onPublishSent(String str, int i);

    void onSubscribeAck(int i);

    void onSubscribeFailure(int i, MQTTClientError mQTTClientError);

    void onUnsubscribeAck(int i);

    void onUnsubscribeFailure(int i, MQTTClientError mQTTClientError);
}
