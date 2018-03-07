package com.facebook.notifications.mqtt;

import com.facebook.push.mqtt.persistence.MqttSubscriptionPersistence;
import com.facebook.push.mqtt.service.IProvideSubscribeTopics;
import com.facebook.push.mqtt.service.SubscribeTopic;
import com.google.common.collect.ImmutableMap;

/* compiled from: hot_like_growing */
public class NotificationsMqttTopicsSet implements IProvideSubscribeTopics {
    public ImmutableMap<SubscribeTopic, MqttSubscriptionPersistence> get() {
        return ImmutableMap.of(new SubscribeTopic("/notifications_sync", 0), MqttSubscriptionPersistence.ALWAYS, new SubscribeTopic("/notifications_seen", 0), MqttSubscriptionPersistence.ALWAYS, new SubscribeTopic("/notifications_read", 0), MqttSubscriptionPersistence.ALWAYS);
    }
}
