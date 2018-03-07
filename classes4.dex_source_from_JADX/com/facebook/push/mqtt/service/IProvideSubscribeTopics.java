package com.facebook.push.mqtt.service;

import com.facebook.push.mqtt.persistence.MqttSubscriptionPersistence;
import com.google.common.collect.ImmutableMap;

/* compiled from: hot_like_medium */
public interface IProvideSubscribeTopics {
    ImmutableMap<SubscribeTopic, MqttSubscriptionPersistence> get();
}
