package com.facebook.proxygen;

import com.facebook.jni.Countable;
import java.io.IOException;

/* compiled from: ptr_jump_without_ptr */
public class NativeReadBuffer extends Countable implements ReadBuffer {
    private boolean mClosed;
    private boolean mError;
    private boolean mInitialized;

    private native void nativeInit();

    private native int nativeRead(byte[] bArr, int i, int i2);

    private native int nativeSize();

    public int read(byte[] bArr, int i, int i2) {
        checkBufferInUsableState();
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Negative length or offset is not allowed");
        } else if (bArr == null || bArr.length < i + i2) {
            throw new IllegalArgumentException("Array null, or not large enough");
        } else if (i2 == 0) {
            return 0;
        } else {
            try {
                return nativeRead(bArr, i, i2);
            } catch (IOException e) {
                this.mError = true;
                throw e;
            }
        }
    }

    public void init() {
        if (this.mInitialized) {
            throw new IllegalStateException("Already initalized");
        }
        nativeInit();
        this.mInitialized = true;
    }

    public int size() {
        checkBufferInUsableState();
        return nativeSize();
    }

    public void close() {
        try {
            dispose();
        } finally {
            this.mClosed = true;
        }
    }

    private void checkBufferInUsableState() {
        if (!this.mInitialized) {
            throw new IllegalStateException("Buffer not initialized");
        } else if (this.mClosed) {
            throw new IllegalStateException("Buffer already closed");
        } else if (this.mError) {
            throw new IllegalStateException("Trying to read after error");
        }
    }
}
