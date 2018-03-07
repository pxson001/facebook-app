package com.facebook.messaging.send.service;

import com.facebook.mqtt.model.thrift.TopicType;

/* compiled from: redirect_to_feed */
public enum MqttSendMessageProtocol {
    THRIFT(69, 70);
    
    private static String TOPIC_PREFIX;
    private int requestTopicType;
    private int responseTopicType;

    static {
        TOPIC_PREFIX = "/";
    }

    private MqttSendMessageProtocol(int i, int i2) {
        this.requestTopicType = i;
        this.responseTopicType = i2;
    }

    public final String getRequestTopic() {
        return TOPIC_PREFIX + ((String) TopicType.b.get(Integer.valueOf(this.requestTopicType)));
    }

    public final String getResponseTopic() {
        return TOPIC_PREFIX + ((String) TopicType.b.get(Integer.valueOf(this.responseTopicType)));
    }
}
