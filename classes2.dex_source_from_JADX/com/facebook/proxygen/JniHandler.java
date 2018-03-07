package com.facebook.proxygen;

import com.facebook.proxygen.utils.Preconditions;
import javax.annotation.Nullable;
import org.apache.http.Header;
import org.apache.http.client.methods.HttpUriRequest;

/* compiled from: ptr_scroll_to_top */
public class JniHandler extends NativeHandleImpl implements HTTPResponseHandler, HTTPTransportCallback {
    private HTTPRequestHandler mRequestHandler;
    private HTTPResponseHandler mResponseHandler;
    @Nullable
    private HTTPTransportCallback mTransportCallback;

    private native void cancelNative();

    private native void changePriorityNative(int i);

    private native void closeNative();

    private native boolean sendBodyNative(byte[] bArr, int i, int i2);

    private native boolean sendEOMNative();

    private native boolean sendHeadersNative(HttpUriRequest httpUriRequest);

    private native boolean sendRequestWithBodyAndEOMNative(HttpUriRequest httpUriRequest, byte[] bArr, int i, int i2);

    private native void setEnabledCallbackFlagNative(int i);

    public JniHandler(HTTPRequestHandler hTTPRequestHandler, HTTPResponseHandler hTTPResponseHandler, @Nullable HTTPTransportCallback hTTPTransportCallback) {
        Preconditions.checkNotNull(hTTPRequestHandler);
        Preconditions.checkNotNull(hTTPResponseHandler);
        this.mRequestHandler = hTTPRequestHandler;
        this.mResponseHandler = hTTPResponseHandler;
        this.mTransportCallback = hTTPTransportCallback;
        this.mRequestHandler.mDelegate = this;
    }

    public JniHandler(HTTPRequestHandler hTTPRequestHandler, HTTPResponseHandler hTTPResponseHandler) {
        this(hTTPRequestHandler, hTTPResponseHandler, null);
    }

    public boolean sendHeaders(HttpUriRequest httpUriRequest) {
        return sendHeadersNative(httpUriRequest);
    }

    public boolean sendBody(byte[] bArr, int i, int i2) {
        return sendBodyNative(bArr, i, i2);
    }

    public boolean sendEOM() {
        return sendEOMNative();
    }

    public boolean sendRequestWithBodyAndEom(HttpUriRequest httpUriRequest, byte[] bArr, int i, int i2) {
        return sendRequestWithBodyAndEOMNative(httpUriRequest, bArr, i, i2);
    }

    public void cancel() {
        this.mRequestHandler.mDelegate = null;
        cancelNative();
    }

    public void changePriority(int i) {
        changePriorityNative(i);
    }

    public void onResponse(int i, String str, Header[] headerArr) {
        this.mResponseHandler.onResponse(i, str, headerArr);
    }

    public void onBody() {
        this.mResponseHandler.onBody();
    }

    public void onEOM() {
        this.mResponseHandler.onEOM();
        this.mRequestHandler.mDelegate = null;
    }

    public void onError(HTTPRequestError hTTPRequestError) {
        this.mResponseHandler.onError(hTTPRequestError);
        this.mRequestHandler.mDelegate = null;
    }

    public int getEnabledCallbackFlag() {
        if (this.mTransportCallback != null) {
            return this.mTransportCallback.getEnabledCallbackFlag();
        }
        return 0;
    }

    public void firstHeaderByteFlushed() {
        if (this.mTransportCallback != null) {
            this.mTransportCallback.firstHeaderByteFlushed();
        }
    }

    public void firstByteFlushed() {
        if (this.mTransportCallback != null) {
            this.mTransportCallback.firstByteFlushed();
        }
    }

    public void lastByteFlushed() {
        if (this.mTransportCallback != null) {
            this.mTransportCallback.lastByteFlushed();
        }
    }

    public void lastByteAcked(long j) {
        if (this.mTransportCallback != null) {
            this.mTransportCallback.lastByteAcked(j);
        }
    }

    public void headerBytesGenerated(long j, long j2) {
        if (this.mTransportCallback != null) {
            this.mTransportCallback.headerBytesGenerated(j, j2);
        }
    }

    public void headerBytesReceived(long j, long j2) {
        if (this.mTransportCallback != null) {
            this.mTransportCallback.headerBytesReceived(j, j2);
        }
    }

    public void bodyBytesGenerated(long j) {
        if (this.mTransportCallback != null) {
            this.mTransportCallback.bodyBytesGenerated(j);
        }
    }

    public void bodyBytesReceived(long j) {
        if (this.mTransportCallback != null) {
            this.mTransportCallback.bodyBytesReceived(j);
        }
    }

    protected void finalize() {
        try {
            closeNative();
        } finally {
            super.finalize();
        }
    }
}
