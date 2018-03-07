package com.facebook.funnellogger;

/* compiled from: WWW_MOBILE_SETTINGS */
public enum Funnel$EndType {
    EXPLICIT("explicit"),
    TIMEOUT("timeout"),
    SESSION_END("session_end"),
    RESTART("restart"),
    ACTIONS_FULL("actions_full"),
    CORRUPTED("corrupted");
    
    private String mType;

    private Funnel$EndType(String str) {
        this.mType = str;
    }

    public final String tag() {
        return this.mType;
    }
}
