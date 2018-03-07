package com.facebook.presence;

import com.facebook.push.mqtt.persistence.MqttSubscriptionPersistence;
import com.facebook.push.mqtt.service.IProvideSubscribeTopics;
import com.facebook.push.mqtt.service.SubscribeTopic;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;

/* compiled from: high_score_user */
public class PresenceInvestigationTopic implements IProvideSubscribeTopics {
    public ImmutableMap<SubscribeTopic, MqttSubscriptionPersistence> get() {
        return ImmutableBiMap.b(new SubscribeTopic("/p_a_req", 0), MqttSubscriptionPersistence.APP_USE);
    }
}
