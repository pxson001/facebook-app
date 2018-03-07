package com.facebook.http.executors.liger;

import com.facebook.http.interfaces.ConnectionPrioritizerTrigger;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.proxygen.HTTPRequestHandler;
import com.facebook.proxygen.JniHandler;
import com.google.common.base.Preconditions;
import org.apache.http.conn.ConnectionReleaseTrigger;

/* compiled from: method/mobile.zeroHeaderRequest */
public class LigerConnectionStateChangeTrigger implements ConnectionPrioritizerTrigger, ConnectionReleaseTrigger {
    private HTTPRequestHandler f13586a;

    public LigerConnectionStateChangeTrigger(HTTPRequestHandler hTTPRequestHandler) {
        this.f13586a = (HTTPRequestHandler) Preconditions.checkNotNull(hTTPRequestHandler);
    }

    public final void mo1675a(RequestPriority requestPriority) {
        Preconditions.checkNotNull(requestPriority);
        HTTPRequestHandler hTTPRequestHandler = this.f13586a;
        int numericValue = requestPriority.getNumericValue();
        JniHandler jniHandler = hTTPRequestHandler.mDelegate;
        if (jniHandler != null) {
            jniHandler.changePriority(numericValue);
        }
    }

    public void releaseConnection() {
        throw new UnsupportedOperationException("Cannot perform release of this connection");
    }

    public void abortConnection() {
        this.f13586a.cancel();
    }
}
