package com.facebook.friendsnearby.mqtt;

import com.facebook.push.mqtt.persistence.MqttSubscriptionPersistence;
import com.facebook.push.mqtt.service.IProvideSubscribeTopics;
import com.facebook.push.mqtt.service.SubscribeTopic;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;

/* compiled from: hot_like_small */
public class FriendsNearbyMqttTopicsSet implements IProvideSubscribeTopics {
    public ImmutableMap<SubscribeTopic, MqttSubscriptionPersistence> get() {
        return ImmutableBiMap.b(new SubscribeTopic("/friends_locations", 0), MqttSubscriptionPersistence.APP_USE);
    }
}
