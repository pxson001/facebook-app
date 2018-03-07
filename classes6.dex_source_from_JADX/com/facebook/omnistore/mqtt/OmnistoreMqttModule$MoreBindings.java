package com.facebook.omnistore.mqtt;

import com.facebook.inject.Bindings;
import com.facebook.inject.MultiBind;
import com.facebook.push.mqtt.external.MqttPushHandler;
import com.facebook.push.mqtt.persistence.AlwaysPersistentGkMqttPersistenceRequirement;
import com.facebook.push.mqtt.persistence.MqttPersistenceRequirement;
import com.facebook.push.mqtt.service.IProvideSubscribeTopics;
import com.facebook.push.mqtt.service.MqttTopicList;

@Bindings
/* compiled from: target_bit_rate */
interface OmnistoreMqttModule$MoreBindings {
    @MultiBind
    MqttPersistenceRequirement addAlwaysPersistentGkMqttPersistenceRequirement(AlwaysPersistentGkMqttPersistenceRequirement alwaysPersistentGkMqttPersistenceRequirement);

    @MultiBind
    MqttPushHandler getOmnistoreMqttPushHandler(OmnistoreMqttPushHandler omnistoreMqttPushHandler);

    @MqttTopicList
    @MultiBind
    IProvideSubscribeTopics getOmnistoreMqttTopics(OmnistoreMqttTopicsSetProvider omnistoreMqttTopicsSetProvider);
}
