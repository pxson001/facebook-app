package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Throwables;
import java.io.OutputStream;

/* compiled from: mByteBuffer for ExtraBuffer should not be null */
public abstract class PooledByteBufferOutputStream extends OutputStream {
    public abstract NativePooledByteBuffer mo2897a();

    public abstract int mo2898b();

    public void close() {
        try {
            super.close();
        } catch (Throwable e) {
            Throwables.m15700b(e);
        }
    }
}
