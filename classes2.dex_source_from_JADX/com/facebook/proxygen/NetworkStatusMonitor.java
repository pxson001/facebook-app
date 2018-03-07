package com.facebook.proxygen;

/* compiled from: ptr_auto_refresh */
public class NetworkStatusMonitor extends NativeHandleImpl {
    private AnalyticsLogger mAnalyticsLogger;
    private int mBandwidthSplitSize = 10000;
    private int mCacheDurationInSeconds = 2;
    private NetworkStatus mCacheStatus;
    private int mDNSPort;
    private boolean mDNSReachabilityEnabled;
    private String mDNSServer = "";
    private final EventBase mEventBase;
    private int mGoodDL = 250000;
    private int mGoodRtt = 50;
    private int mGoodUL = 50000;
    private String mHostname = "";
    private boolean mInitialized;
    private int mMaxPriority = 7;
    private int mModerateDL = 68750;
    private int mModerateRtt = 150;
    private int mModerateUL = 1375;
    private int mPoorDL = 18750;
    private int mPoorRtt = 1500;
    private int mPoorUL = 3750;
    private boolean mRadioMonitorEnabled;
    private int mReachabilityDefaultTimeoutMs;
    private int mReachabilityIntervalMs;

    private native void getNetworkStatusNative();

    public native void close();

    public native int getDownloadBandwidthQualityNative();

    public native int getLatencyQualityNative();

    public native Object getRadioData();

    public native int getUploadBandwidthQualityNative();

    public native void init(EventBase eventBase, int i, boolean z, String str, int i2, String str2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, AnalyticsLogger analyticsLogger, boolean z2);

    public native void setAppForegrounded(boolean z);

    protected native void setNetworkType(int i, int i2);

    public NetworkStatusMonitor(EventBase eventBase) {
        this.mEventBase = eventBase;
    }

    public void setAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.mAnalyticsLogger = analyticsLogger;
    }

    public void setRadioMonitorEnabled(boolean z) {
        this.mRadioMonitorEnabled = z;
    }

    public void setDNSReachabilityEnabled(boolean z) {
        this.mDNSReachabilityEnabled = z;
    }

    public boolean isDNSReachabilityEnabled() {
        return this.mDNSReachabilityEnabled;
    }

    public void setDNSServer(String str) {
        this.mDNSServer = str;
    }

    public void setDNSPort(int i) {
        this.mDNSPort = i;
    }

    public void setHostname(String str) {
        this.mHostname = str;
    }

    public void setDNSReachabilityIntervalMs(int i) {
        this.mReachabilityIntervalMs = i;
    }

    public void setDNSReachabilityDefaultTimeoutMs(int i) {
        this.mReachabilityDefaultTimeoutMs = i;
    }

    public void setMaxPriority(int i) {
        this.mMaxPriority = i;
    }

    public void setBandwidthSplitSize(int i) {
        this.mBandwidthSplitSize = i;
    }

    public void setCacheDuration(int i) {
        this.mCacheDurationInSeconds = i;
    }

    public void setQualityBenchmarks(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.mPoorRtt = i;
        this.mModerateRtt = i2;
        this.mGoodRtt = i3;
        this.mPoorUL = i4;
        this.mModerateUL = i5;
        this.mGoodUL = i6;
        this.mPoorDL = i7;
        this.mModerateDL = i8;
        this.mGoodDL = i9;
    }

    public void init(int i) {
        init(this.mEventBase, i, this.mDNSReachabilityEnabled, this.mDNSServer, this.mDNSPort, this.mHostname, this.mReachabilityIntervalMs, this.mReachabilityDefaultTimeoutMs, this.mMaxPriority, this.mBandwidthSplitSize, this.mCacheDurationInSeconds, this.mPoorRtt, this.mModerateRtt, this.mGoodRtt, this.mPoorUL, this.mModerateUL, this.mGoodUL, this.mPoorDL, this.mModerateDL, this.mGoodDL, this.mAnalyticsLogger, this.mRadioMonitorEnabled);
        this.mInitialized = true;
    }

    protected void finalize() {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    public NetworkStatus getNetworkStatus() {
        if (!this.mInitialized) {
            return null;
        }
        getNetworkStatusNative();
        return this.mCacheStatus;
    }

    public String getNetworkQualityString(int i) {
        switch (i) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return "POOR";
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return "MODERATE";
            case 3:
                return "GOOD";
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return "EXCELLENT";
            default:
                return "UNKNOWN";
        }
    }
}
