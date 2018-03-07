package com.facebook.http.executors.liger;

import com.facebook.http.protocol.HttpWireCallback;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: TCP_OPEN */
class LigerHttpTransportCallback implements HTTPTransportCallback {
    HttpWireCallback f23326a;

    LigerHttpTransportCallback(HttpWireCallback httpWireCallback) {
        this.f23326a = httpWireCallback;
    }

    public int getEnabledCallbackFlag() {
        this.f23326a.a();
        return 64;
    }

    public void firstHeaderByteFlushed() {
    }

    public void firstByteFlushed() {
    }

    public void lastByteFlushed() {
    }

    public void lastByteAcked(long j) {
    }

    public void headerBytesGenerated(long j, long j2) {
    }

    public void headerBytesReceived(long j, long j2) {
    }

    public void bodyBytesGenerated(long j) {
        this.f23326a.a(j);
    }

    public void bodyBytesReceived(long j) {
    }
}
