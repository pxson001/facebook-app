package com.facebook.proxygen.utils;

import com.facebook.proxygen.EventBase;

/* compiled from: publishReviewParams */
public class CircularEventLog {
    private EventBase mEventBase;
    public boolean mInitialized;
    private final int mRingSize;

    private native String[] getLogLines(EventBase eventBase);

    private native void init(EventBase eventBase, int i);

    public CircularEventLog(EventBase eventBase, int i) {
        this.mEventBase = eventBase;
        this.mRingSize = i;
    }

    public void init() {
        init(this.mEventBase, this.mRingSize);
        this.mInitialized = true;
    }

    public boolean isInitialized() {
        return this.mInitialized;
    }

    public String[] getLogLines() {
        Preconditions.checkState(this.mInitialized, "CircularEventLog was not initialized");
        return getLogLines(this.mEventBase);
    }
}
