package com.facebook.api.feed.data;

/* compiled from: is_messenger_platform_bot */
public enum ViewPortShift {
    Perform,
    Avoid;

    public final boolean performShift() {
        return this == Perform;
    }

    public final boolean avoidShift() {
        return this == Avoid;
    }
}
