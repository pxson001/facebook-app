package com.facebook.push.mqtt.external;

/* compiled from: is_viewer_friend */
public enum PushStateEvent {
    SERVICE_STARTED(0),
    CHANNEL_CONNECTING(1),
    CHANNEL_CONNECTED(2),
    CHANNEL_DISCONNECTED(3),
    SERVICE_STOPPED(4),
    KEEPALIVE_SENT(5),
    UNKNOWN(6);
    
    private boolean mClockSkewDetected;
    private final int value;

    private PushStateEvent(int i) {
        this.value = i;
    }

    public static PushStateEvent fromValue(int i) {
        for (PushStateEvent pushStateEvent : values()) {
            if (pushStateEvent.value == i) {
                return pushStateEvent;
            }
        }
        return UNKNOWN;
    }

    public final int toValue() {
        return this.value;
    }

    public final void setClockSkewDetected(boolean z) {
        this.mClockSkewDetected = z;
    }

    public final boolean isClockSkewDetected() {
        return this.mClockSkewDetected;
    }
}
