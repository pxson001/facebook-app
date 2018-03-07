package com.facebook.push.mqtt.service;

import com.facebook.mqtt.messages.MqttQOSLevel;
import com.facebook.push.mqtt.service.response.JsonMqttResponseProcessor.Callback;
import com.facebook.push.mqtt.service.response.MqttResponse;
import com.facebook.push.mqtt.service.response.MqttResponseProcessor;
import com.facebook.sync.connection.SyncQueueTrackerImpl;
import com.fasterxml.jackson.databind.JsonNode;
import javax.annotation.Nullable;

/* compiled from: fetch_pages */
public interface MqttPushServiceClient {
    public static final PublishParams f11641a = new PublishParams(5000, 3000, 3000);

    int mo855a(String str, JsonNode jsonNode, MqttQOSLevel mqttQOSLevel, @Nullable MqttPublishListener mqttPublishListener);

    int mo856a(String str, byte[] bArr, MqttQOSLevel mqttQOSLevel, @Nullable MqttPublishListener mqttPublishListener);

    <T> MqttResponse<T> mo857a(String str, JsonNode jsonNode, MqttResponseProcessor<T> mqttResponseProcessor);

    <T> MqttResponse<T> mo858a(String str, JsonNode jsonNode, String str2, Callback<T> callback);

    <T> MqttResponse<T> mo859a(String str, byte[] bArr, MqttResponseProcessor<T> mqttResponseProcessor);

    void mo860a(SyncQueueTrackerImpl syncQueueTrackerImpl);

    boolean mo861a();

    boolean mo862a(long j);

    boolean mo863a(String str, JsonNode jsonNode, long j);

    boolean mo864a(String str, byte[] bArr, long j, long j2);

    boolean mo865a(String str, byte[] bArr, long j, long j2, @Nullable Integer num);

    boolean mo866b();

    ConnectionState mo867c();

    String mo868d();

    String mo869e();

    void mo870f();
}
