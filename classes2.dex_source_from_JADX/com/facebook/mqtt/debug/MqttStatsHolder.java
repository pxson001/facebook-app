package com.facebook.mqtt.debug;

import com.facebook.http.debug.ByteTransferCounter;
import com.fasterxml.jackson.annotation.JsonProperty;

/* compiled from: fetchedImage */
public final class MqttStatsHolder {
    @JsonProperty("count")
    public int count;
    @JsonProperty("totalData")
    public final ByteTransferCounter data = new ByteTransferCounter();
    @JsonProperty("topicName")
    public final String topicName;

    public MqttStatsHolder(String str) {
        this.topicName = str;
    }
}
