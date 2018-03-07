package com.facebook.proxygen;

import com.facebook.proxygen.utils.RequestDefragmentingOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.methods.HttpUriRequest;

/* compiled from: no_valid_engine */
public class HTTPRequestHandler {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private ArrayList<byte[]> mBodyBuffersPool = new ArrayList(20);
    public JniHandler mDelegate;
    private HandlerInterface mHandlerInterface = new HandlerInterface();

    /* compiled from: no_valid_engine */
    class HandlerInterface implements com.facebook.proxygen.utils.RequestDefragmentingOutputStream.HandlerInterface {
        public boolean sendRequestWithBodyAndEom(HttpEntityEnclosingRequest httpEntityEnclosingRequest, byte[] bArr, int i, int i2) {
            return HTTPRequestHandler.this.sendHeadersWithBodyAndEom((HttpUriRequest) httpEntityEnclosingRequest, bArr, i, i2);
        }

        public boolean sendHeaders(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
            return HTTPRequestHandler.this.sendHeaders((HttpUriRequest) httpEntityEnclosingRequest);
        }

        public boolean sendBody(byte[] bArr, int i, int i2) {
            return HTTPRequestHandler.sendBody(HTTPRequestHandler.this, bArr, i, i2);
        }

        public boolean sendEOM() {
            return HTTPRequestHandler.sendEOM(HTTPRequestHandler.this);
        }
    }

    public void execute(HttpUriRequest httpUriRequest) {
        if (sendHeaders(httpUriRequest)) {
            sendRequestBody(httpUriRequest);
            sendEOM(this);
        }
    }

    public void executeWithDefragmentation(HttpUriRequest httpUriRequest) {
        if (!(httpUriRequest instanceof HttpEntityEnclosingRequest) || ((HttpEntityEnclosingRequest) httpUriRequest).getEntity() == null) {
            sendHeadersWithBodyAndEom(httpUriRequest, EMPTY_BYTE_ARRAY, 0, 0);
            return;
        }
        HttpEntityEnclosingRequest httpEntityEnclosingRequest = (HttpEntityEnclosingRequest) httpUriRequest;
        HttpEntity entity = httpEntityEnclosingRequest.getEntity();
        byte[] acquireBodyBuffer = acquireBodyBuffer();
        try {
            OutputStream requestDefragmentingOutputStream = new RequestDefragmentingOutputStream(this.mHandlerInterface, httpEntityEnclosingRequest, acquireBodyBuffer);
            entity.writeTo(requestDefragmentingOutputStream);
            requestDefragmentingOutputStream.writeEomIfNecessary();
        } finally {
            releaseBodyBuffer(acquireBodyBuffer);
        }
    }

    private synchronized byte[] acquireBodyBuffer() {
        byte[] bArr;
        if (this.mBodyBuffersPool.isEmpty()) {
            bArr = new byte[4096];
        } else {
            bArr = (byte[]) this.mBodyBuffersPool.remove(this.mBodyBuffersPool.size() - 1);
        }
        return bArr;
    }

    private synchronized void releaseBodyBuffer(byte[] bArr) {
        if (this.mBodyBuffersPool.size() != 20) {
            this.mBodyBuffersPool.add(bArr);
        }
    }

    protected void sendRequestBody(HttpUriRequest httpUriRequest) {
        if (httpUriRequest instanceof HttpEntityEnclosingRequest) {
            try {
                processEntityRequest((HttpEntityEnclosingRequest) httpUriRequest);
            } catch (LigerNetworkException e) {
            } catch (IOException e2) {
                cancel();
                throw e2;
            }
        }
    }

    public void cancel() {
        JniHandler jniHandler = this.mDelegate;
        if (jniHandler != null) {
            jniHandler.cancel();
            this.mDelegate = null;
        }
    }

    private void processEntityRequest(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        HttpEntity entity = httpEntityEnclosingRequest.getEntity();
        if (entity != null) {
            CloseSuppressingOutputStream closeSuppressingOutputStream = new CloseSuppressingOutputStream(new AndroidBufferedOutputStream(new LigerBodyOutputStream(this)));
            try {
                entity.writeTo(closeSuppressingOutputStream);
                closeSuppressingOutputStream.flush();
            } finally {
                closeSuppressingOutputStream.reallyClose();
            }
        }
    }

    private boolean isChunkedRequest(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        Header firstHeader = httpEntityEnclosingRequest.getFirstHeader("Transfer-Encoding");
        if (firstHeader == null || !"chunked".equalsIgnoreCase(firstHeader.getValue())) {
            return false;
        }
        return true;
    }

    protected boolean sendHeaders(HttpUriRequest httpUriRequest) {
        JniHandler jniHandler = this.mDelegate;
        if (jniHandler != null) {
            return jniHandler.sendHeaders(httpUriRequest);
        }
        return false;
    }

    public static boolean sendBody(HTTPRequestHandler hTTPRequestHandler, byte[] bArr, int i, int i2) {
        JniHandler jniHandler = hTTPRequestHandler.mDelegate;
        if (jniHandler != null) {
            return jniHandler.sendBody(bArr, i, i2);
        }
        return false;
    }

    public static boolean sendEOM(HTTPRequestHandler hTTPRequestHandler) {
        JniHandler jniHandler = hTTPRequestHandler.mDelegate;
        if (jniHandler != null) {
            return jniHandler.sendEOM();
        }
        return false;
    }

    protected boolean sendHeadersWithBodyAndEom(HttpUriRequest httpUriRequest, byte[] bArr, int i, int i2) {
        JniHandler jniHandler = this.mDelegate;
        if (jniHandler != null) {
            return jniHandler.sendRequestWithBodyAndEom(httpUriRequest, bArr, i, i2);
        }
        return false;
    }
}
