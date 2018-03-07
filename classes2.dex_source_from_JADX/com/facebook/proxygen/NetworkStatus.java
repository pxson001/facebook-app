package com.facebook.proxygen;

/* compiled from: pt_BR */
public class NetworkStatus {
    private final long mActiveReadSeconds;
    private final long mActiveWriteSeconds;
    private final long mClosedConn;
    private final String mDNSReachability;
    private final long mDNSResolutionTime;
    private final long mDequeuedReq;
    private final String mDownloadBwQuality;
    private final long mEgressAvg;
    private final long mEgressMax;
    private final long mEgressWindowSize;
    private final long mEnqueuedReq;
    private final long mFinishedReq;
    private final long mFlowControlHit;
    private final long mInQueueReq;
    private final long mInflightConn;
    private final long mInflightReq;
    private final long mIngressAvg;
    private final long mIngressMax;
    private final long mIngressWindowSize;
    private final String mLatencyQuality;
    private final long mMayHaveIdledMS;
    private final boolean mMayHaveNetwork;
    private final long mOpenedConn;
    private final long[] mPriReqInflight;
    private final long mReadCount;
    private long mReqBwEgressAvg;
    private long mReqBwEgressMax;
    private long mReqBwEgressSize;
    private double mReqBwEgressStdDev;
    private long mReqBwIngressAvg;
    private long mReqBwIngressMax;
    private long mReqBwIngressSize;
    private double mReqBwIngressStdDev;
    private final long mRttAvg;
    private final long mRttMax;
    private final double mRttStdDev;
    private final String mUploadBwQuality;
    private final long mWriteCount;

    public NetworkStatus(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, double d, long j12, long j13, long j14, double d2, long j15, long j16, double d3, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long[] jArr, int i, long j26, long j27, long j28, boolean z, long j29, int i2, int i3, int i4) {
        this.mIngressWindowSize = j;
        this.mIngressAvg = j2;
        this.mIngressMax = j3;
        this.mEgressWindowSize = j4;
        this.mEgressAvg = j5;
        this.mEgressMax = j6;
        this.mReadCount = j7;
        this.mWriteCount = j8;
        this.mReqBwIngressSize = j9;
        this.mReqBwIngressAvg = j10;
        this.mReqBwIngressMax = j11;
        this.mReqBwIngressStdDev = d;
        this.mReqBwEgressSize = j12;
        this.mReqBwEgressAvg = j13;
        this.mReqBwEgressMax = j14;
        this.mReqBwEgressStdDev = d2;
        this.mRttAvg = j15;
        this.mRttMax = j16;
        this.mRttStdDev = d3;
        this.mOpenedConn = j17;
        this.mClosedConn = j18;
        this.mInflightConn = j19;
        this.mFlowControlHit = j20;
        this.mEnqueuedReq = j21;
        this.mDequeuedReq = j22;
        this.mFinishedReq = j23;
        this.mInflightReq = j24;
        this.mInQueueReq = j25;
        this.mPriReqInflight = jArr;
        this.mDNSReachability = describeDNSReachabilityResult(i);
        this.mDNSResolutionTime = j26;
        this.mActiveReadSeconds = j27;
        this.mActiveWriteSeconds = j28;
        this.mMayHaveNetwork = z;
        this.mMayHaveIdledMS = j29;
        this.mLatencyQuality = describeNetworkQuality(i2);
        this.mUploadBwQuality = describeNetworkQuality(i3);
        this.mDownloadBwQuality = describeNetworkQuality(i4);
    }

    private String describeDNSReachabilityResult(int i) {
        switch (i) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return "reachable";
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return "exp_client";
            case 3:
                return "exp_timeout";
            default:
                return "unknown";
        }
    }

    private String describeNetworkQuality(int i) {
        switch (i) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return "poor";
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return "moderate";
            case 3:
                return "good";
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return "excellent";
            default:
                return "unknown";
        }
    }

    public long getIngressWindowSize() {
        return this.mIngressWindowSize;
    }

    public long getIngressAvg() {
        return this.mIngressAvg;
    }

    public long getIngressMax() {
        return this.mIngressMax;
    }

    public long getEgressWindowSize() {
        return this.mEgressWindowSize;
    }

    public long getEgressAvg() {
        return this.mEgressAvg;
    }

    public long getEgressMax() {
        return this.mEgressMax;
    }

    public long getReadCount() {
        return this.mReadCount;
    }

    public long getWriteCount() {
        return this.mWriteCount;
    }

    public long getReqBwIngressSize() {
        return this.mReqBwIngressSize;
    }

    public long getReqBwIngressAvg() {
        return this.mReqBwIngressAvg;
    }

    public long getReqBwIngressMax() {
        return this.mReqBwIngressMax;
    }

    public double getReqBwIngressStdDev() {
        return this.mReqBwIngressStdDev;
    }

    public long getReqBwEgressSize() {
        return this.mReqBwEgressSize;
    }

    public long getReqBwEgressAvg() {
        return this.mReqBwEgressAvg;
    }

    public long getReqBwEgressMax() {
        return this.mReqBwEgressMax;
    }

    public double getReqBwEgressStdDev() {
        return this.mReqBwEgressStdDev;
    }

    public long getRttAvg() {
        return this.mRttAvg;
    }

    public long getRttMax() {
        return this.mRttMax;
    }

    public double getRttStdDev() {
        return this.mRttStdDev;
    }

    public long getOpenedConn() {
        return this.mOpenedConn;
    }

    public long getClosedConn() {
        return this.mClosedConn;
    }

    public long getInflightConn() {
        return this.mInflightConn;
    }

    public long getFlowControlHit() {
        return this.mFlowControlHit;
    }

    public long getEnqueuedReq() {
        return this.mEnqueuedReq;
    }

    public long getDequeuedReq() {
        return this.mDequeuedReq;
    }

    public long getFinishedReq() {
        return this.mFinishedReq;
    }

    public long getInflightReq() {
        return this.mInflightReq;
    }

    public long getInQueueReq() {
        return this.mInQueueReq;
    }

    public long[] getPriReqInflight() {
        return this.mPriReqInflight;
    }

    public String getDNSReachability() {
        return this.mDNSReachability;
    }

    public long getDNSResolutionTime() {
        return this.mDNSResolutionTime;
    }

    public long getActiveReadSeconds() {
        return this.mActiveReadSeconds;
    }

    public long getActiveWriteSeconds() {
        return this.mActiveWriteSeconds;
    }

    public boolean getMayHaveNetwork() {
        return this.mMayHaveNetwork;
    }

    public long getMayHaveIdledMS() {
        return this.mMayHaveIdledMS;
    }

    public String getLatencyQuality() {
        return this.mLatencyQuality;
    }

    public String getUploadBwQuality() {
        return this.mUploadBwQuality;
    }

    public String getDownloadBwQuality() {
        return this.mDownloadBwQuality;
    }
}
