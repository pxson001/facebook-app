package com.facebook.proxygen;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: mDeleteByTagsLock */
public class HTTPFlowStats {
    private final boolean mConnEstablished;
    private final long mDnsLatency;
    private final String mLocalAddr;
    private final int mLocalPort;
    private final boolean mNewConnection;
    private final String mProtocol;
    private final int mReqBodyBytes;
    private final int mReqHeaderBytes;
    private final int mReqHeaderCompBytes;
    private final boolean mReqSent;
    public final int mRspBodyBytes;
    public final long mRspBodyBytesTime;
    private final int mRspBodyCompBytes;
    private final int mRspHeaderBytes;
    private final int mRspHeaderCompBytes;
    private final boolean mRspReceived;
    private InetAddress mServerAddr = null;
    private final long mTcpLatency;
    private final long mTlsLatency;

    public HTTPFlowStats(String str, String str2, int i, boolean z, boolean z2, boolean z3, boolean z4, String str3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2, long j3, long j4) {
        if (!str.equals("")) {
            try {
                this.mServerAddr = InetAddress.getByName(str);
            } catch (UnknownHostException e) {
            }
        }
        this.mLocalAddr = str2;
        this.mLocalPort = i;
        this.mConnEstablished = z;
        this.mNewConnection = z2;
        this.mReqSent = z3;
        this.mRspReceived = z4;
        this.mProtocol = str3;
        this.mReqHeaderBytes = i2;
        this.mReqHeaderCompBytes = i3;
        this.mReqBodyBytes = i4;
        this.mRspHeaderBytes = i5;
        this.mRspHeaderCompBytes = i6;
        this.mRspBodyBytes = i7;
        this.mRspBodyCompBytes = i8;
        this.mDnsLatency = j;
        this.mTcpLatency = j2;
        this.mTlsLatency = j3;
        this.mRspBodyBytesTime = j4;
    }

    public InetAddress getServerAddress() {
        return this.mServerAddr;
    }

    public String getLocalAddress() {
        return this.mLocalAddr;
    }

    public int getLocalPort() {
        return this.mLocalPort;
    }

    public boolean getIsConnectionEstablished() {
        return this.mConnEstablished;
    }

    public boolean getIsNewConnection() {
        return this.mNewConnection;
    }

    public boolean getRequestSent() {
        return this.mReqSent;
    }

    public boolean getResponseReceived() {
        return this.mRspReceived;
    }

    public String getNegotiatedProtocol() {
        return this.mProtocol;
    }

    public int getRequestHeaderBytes() {
        return this.mReqHeaderBytes;
    }

    public int getRequestHeaderCompressedBytes() {
        return this.mReqHeaderCompBytes;
    }

    public int getRequestBodyBytes() {
        return this.mReqBodyBytes;
    }

    public int getResponseHeaderBytes() {
        return this.mRspHeaderBytes;
    }

    public int getResponseHeaderCompressedBytes() {
        return this.mRspHeaderCompBytes;
    }

    public int getResponseBodyBytes() {
        return this.mRspBodyBytes;
    }

    public int getResponseBodyCompressedBytes() {
        return this.mRspBodyCompBytes;
    }

    public long getDnsLatency() {
        return this.mDnsLatency;
    }

    public long getTcpLatency() {
        return this.mTcpLatency;
    }

    public long getTlsLatency() {
        return this.mTlsLatency;
    }

    public long getRspBodyBytesTime() {
        return this.mRspBodyBytesTime;
    }

    public boolean isSpdy() {
        return this.mProtocol.startsWith("SPDY");
    }
}
