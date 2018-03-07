package com.facebook.analytics;

/* compiled from: tip */
public enum InteractionLogger$ContentFlags {
    UNDEFINED(0),
    NO_DATA(1),
    LOCAL_DATA(2),
    NETWORK_DATA(3);
    
    private final int mFlags;

    private InteractionLogger$ContentFlags(int i) {
        this.mFlags = i;
    }

    public final int getValue() {
        return this.mFlags;
    }
}
