package com.facebook.push.mqtt.service;

/* compiled from: social_context_entity_id */
/* synthetic */ class MqttBridgeConnectionStatusProviderImpl$1 {
    static final /* synthetic */ int[] f4287a = new int[ConnectionState.values().length];

    static {
        try {
            f4287a[ConnectionState.CONNECTED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f4287a[ConnectionState.CONNECTING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f4287a[ConnectionState.DISCONNECTED.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
