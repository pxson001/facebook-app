package com.facebook.placetips.bootstrap;

import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: max_runs */
public enum PresenceSourceType {
    POST_COMPOSE(3, 0, false),
    BLE(2, 0),
    GPS(1, 0),
    FORCE_OFF(Integer.MIN_VALUE, Integer.MAX_VALUE),
    INJECT(2147483646, Integer.MAX_VALUE);
    
    public final int foundPriority;
    public final boolean isPersistent;
    public final int nothingFoundPriority;

    private PresenceSourceType(int i, int i2) {
        this(r7, r8, i, i2, true);
    }

    private PresenceSourceType(int i, int i2, boolean z) {
        this.foundPriority = i;
        this.nothingFoundPriority = i2;
        this.isPersistent = z;
    }

    public final String getNameForAnalytics() {
        switch (1.a[ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return "composer";
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return "Bluetooth LE";
            default:
                return toString();
        }
    }
}
