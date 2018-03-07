package com.facebook.proxygen.utils;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.HttpEntityEnclosingRequest;

/* compiled from: no_op_count */
public class RequestDefragmentingOutputStream extends OutputStream {
    private final byte[] mBuffer;
    private boolean mClosed;
    private OutputStream mFallbackOutputStream;
    public final HandlerInterface mHandlerInterface;
    private int mPosition;
    private final HttpEntityEnclosingRequest mRequest;
    private final int mStreamingBufferSize;

    /* compiled from: no_op_count */
    public interface HandlerInterface {
        boolean sendBody(byte[] bArr, int i, int i2);

        boolean sendEOM();

        boolean sendHeaders(HttpEntityEnclosingRequest httpEntityEnclosingRequest);

        boolean sendRequestWithBodyAndEom(HttpEntityEnclosingRequest httpEntityEnclosingRequest, byte[] bArr, int i, int i2);
    }

    public RequestDefragmentingOutputStream(HandlerInterface handlerInterface, HttpEntityEnclosingRequest httpEntityEnclosingRequest, byte[] bArr) {
        this(handlerInterface, httpEntityEnclosingRequest, bArr, 8096);
    }

    RequestDefragmentingOutputStream(HandlerInterface handlerInterface, HttpEntityEnclosingRequest httpEntityEnclosingRequest, byte[] bArr, int i) {
        this.mHandlerInterface = handlerInterface;
        this.mRequest = httpEntityEnclosingRequest;
        this.mBuffer = bArr;
        this.mStreamingBufferSize = i;
    }

    public synchronized void write(int i) {
        checkStreamIsNotClosed();
        if (this.mFallbackOutputStream != null) {
            this.mFallbackOutputStream.write(i);
        } else if (canBufferMoreBytes(1)) {
            this.mBuffer[this.mPosition] = (byte) i;
            this.mPosition++;
        } else {
            fallbackToStreaming(new byte[]{(byte) i}, 0, 1);
        }
    }

    public synchronized void write(byte[] bArr) {
        checkStreamIsNotClosed();
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        checkStreamIsNotClosed();
        if (this.mFallbackOutputStream != null) {
            this.mFallbackOutputStream.write(bArr, i, i2);
        } else if (canBufferMoreBytes(i2)) {
            System.arraycopy(bArr, i, this.mBuffer, this.mPosition, i2);
            this.mPosition += i2;
        } else {
            fallbackToStreaming(bArr, i, i2);
        }
    }

    public synchronized void writeEomIfNecessary() {
        checkStreamIsNotClosed();
        this.mClosed = true;
        if (this.mFallbackOutputStream != null) {
            this.mFallbackOutputStream.flush();
            if (!this.mHandlerInterface.sendEOM()) {
                throw new IOException();
            }
        } else if (!this.mHandlerInterface.sendRequestWithBodyAndEom(this.mRequest, this.mBuffer, 0, this.mPosition)) {
            throw new IOException();
        }
    }

    private void checkStreamIsNotClosed() {
        if (this.mClosed) {
            throw new IOException("writeEomIfNecessary was already called on the stream");
        }
    }

    private boolean canBufferMoreBytes(int i) {
        return i <= this.mBuffer.length - this.mPosition;
    }

    private void fallbackToStreaming(byte[] bArr, int i, int i2) {
        if (this.mHandlerInterface.sendHeaders(this.mRequest)) {
            this.mFallbackOutputStream = new BufferedOutputStream(new FallbackOutputStream(this), this.mStreamingBufferSize);
            this.mFallbackOutputStream.write(this.mBuffer, 0, this.mPosition);
            this.mFallbackOutputStream.write(bArr, i, i2);
            return;
        }
        throw new IOException();
    }
}
