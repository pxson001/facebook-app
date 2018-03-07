package com.facebook.http.onion;

/* compiled from: diode_sticker */
public enum TorProxy$State {
    DISABLED(2131233715),
    REQUESTED(2131233718),
    STARTING(2131233716),
    ENABLED(2131233717),
    DISABLED_ERROR(2131233715);
    
    public int resId;

    private TorProxy$State(int i) {
        this.resId = i;
    }

    public final boolean isEnabled() {
        return this == ENABLED;
    }

    public final boolean isComplete() {
        return this == DISABLED || this == DISABLED_ERROR || this == ENABLED;
    }

    public final boolean isStarting() {
        return this == REQUESTED || this == STARTING;
    }
}
