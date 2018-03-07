package com.facebook.messaging.analytics.reliability;

/* compiled from: p2p_history_get_more_fail */
public enum NetworkChannel {
    MQTT("mqtt"),
    GRAPH("graph");
    
    public final String channelName;

    private NetworkChannel(String str) {
        this.channelName = str;
    }
}
