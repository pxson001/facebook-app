package com.facebook.greetingcards.verve.model;

/* compiled from: viewer_context_util_available_immediately */
public enum VMViewType {
    MEDIA("media"),
    RECT("rect"),
    LABEL("label"),
    BUTTON("button"),
    SEQUENCE("sequence"),
    GROUP("group"),
    PLACEHOLDER("placeholder"),
    UNKNOWN("unknown");
    
    private final String mViewType;

    private VMViewType(String str) {
        this.mViewType = str;
    }

    public final String toString() {
        return this.mViewType;
    }

    public static VMViewType fromString(String str) {
        if (str != null) {
            for (VMViewType vMViewType : values()) {
                if (str.equalsIgnoreCase(vMViewType.mViewType)) {
                    return vMViewType;
                }
            }
        }
        return UNKNOWN;
    }
}
