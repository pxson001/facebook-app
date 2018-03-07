package com.facebook.proxygen.utils;

/* compiled from: proxygen_error */
public class TracerouteResult {
    private final TracerouteHop[] mHops;
    private final String mID;
    private final String mSource;

    /* compiled from: proxygen_error */
    public class TracerouteHop {
        public final int mDelay_ms;
        public final String mHost;
        public final boolean mLost;
        public final int mTtl;

        public TracerouteHop(boolean z, int i, String str, int i2) {
            this.mLost = z;
            this.mTtl = i;
            this.mHost = str;
            this.mDelay_ms = i2;
        }
    }

    public TracerouteResult(String str, TracerouteHop[] tracerouteHopArr, String str2) {
        this.mID = str;
        this.mHops = tracerouteHopArr;
        this.mSource = str2;
    }

    public String getID() {
        return this.mID;
    }

    public TracerouteHop[] getHops() {
        return this.mHops;
    }

    public String getSource() {
        return this.mSource;
    }
}
