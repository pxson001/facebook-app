package com.facebook.analytics2.logger;

/* compiled from: tap_360_photo_view_in_vr */
public enum EventLogType {
    CLIENT_EVENT("client_event", "extra"),
    EXPERIMENT("experiment", "result");
    
    private final String mExtraJsonKey;
    private final String mProtocolValue;

    private EventLogType(String str, String str2) {
        this.mProtocolValue = str;
        this.mExtraJsonKey = str2;
    }

    public final String getProtocolValue() {
        return this.mProtocolValue;
    }

    final String getExtraJsonKey() {
        return this.mExtraJsonKey;
    }

    public final String toString() {
        return this.mProtocolValue;
    }
}
