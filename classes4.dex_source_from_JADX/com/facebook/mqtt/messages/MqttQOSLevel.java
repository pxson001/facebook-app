package com.facebook.mqtt.messages;

/* compiled from: hot_emoji_size */
public enum MqttQOSLevel {
    FIRE_AND_FORGET(0),
    ACKNOWLEDGED_DELIVERY(1),
    ASSURED_DELIVERY(2);
    
    private final int mValue;

    private MqttQOSLevel(int i) {
        this.mValue = i;
    }

    public final int getValue() {
        return this.mValue;
    }

    public static MqttQOSLevel fromInt(int i) {
        switch (i) {
            case 0:
                return FIRE_AND_FORGET;
            case 1:
                return ACKNOWLEDGED_DELIVERY;
            case 2:
                return ASSURED_DELIVERY;
            default:
                throw new IllegalArgumentException("Unknown QOS level " + i);
        }
    }
}
