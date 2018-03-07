package com.facebook.quickpromotion.push;

import com.facebook.push.mqtt.persistence.MqttSubscriptionPersistence;
import com.facebook.push.mqtt.service.IProvideSubscribeTopics;
import com.facebook.push.mqtt.service.SubscribeTopic;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;

/* compiled from: help_url */
public class QuickPromotionMqttTopicsSet implements IProvideSubscribeTopics {
    public ImmutableMap<SubscribeTopic, MqttSubscriptionPersistence> get() {
        return ImmutableBiMap.b(new SubscribeTopic("/quick_promotion_refresh", 0), MqttSubscriptionPersistence.ALWAYS);
    }
}
