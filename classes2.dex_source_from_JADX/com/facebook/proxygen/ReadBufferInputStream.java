package com.facebook.proxygen;

import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

/* compiled from: marauder_device_id */
public class ReadBufferInputStream extends InputStream {
    private final ReadBuffer mBuffer;
    private boolean mClosed;
    @Nullable
    private HttpNetworkException mNetworkException;

    public ReadBufferInputStream(ReadBuffer readBuffer) {
        this.mBuffer = readBuffer;
    }

    public synchronized int available() {
        return this.mBuffer.size();
    }

    public synchronized int read() {
        int i;
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        switch (read) {
            case -1:
                i = -1;
                break;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                i = bArr[0];
                break;
            default:
                throw new IllegalStateException("n=" + read);
        }
        return i;
    }

    public synchronized int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i, int i2) {
        int read;
        checkNotClosed();
        if (this.mNetworkException != null) {
            throw this.mNetworkException;
        }
        read = this.mBuffer.read(bArr, i, i2);
        while (read == 0) {
            try {
                ObjectDetour.a(this, 1000, -12380612);
            } catch (InterruptedException e) {
            }
            if (this.mNetworkException != null) {
                throw this.mNetworkException;
            }
            read = this.mBuffer.read(bArr, i, i2);
        }
        return read;
    }

    public synchronized void onBody() {
        ObjectDetour.c(this, 1269955325);
    }

    public synchronized void onEOM() {
        ObjectDetour.c(this, 312933750);
    }

    public synchronized void close() {
        if (!this.mClosed) {
            this.mBuffer.close();
            this.mClosed = true;
        }
    }

    public synchronized void setError(HttpNetworkException httpNetworkException) {
        this.mNetworkException = httpNetworkException;
        ObjectDetour.c(this, 117357904);
    }

    private void checkNotClosed() {
        if (this.mClosed) {
            throw new IOException("Buffer is Closed");
        }
    }

    public void reset() {
        throw new UnsupportedOperationException();
    }

    public long skip(long j) {
        throw new UnsupportedOperationException();
    }

    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    public boolean markSupported() {
        return false;
    }
}
