package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Throwables;
import com.facebook.common.internal.VisibleForTesting;
import java.io.InputStream;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: page/%s/contactinbox */
public class NativePooledByteBufferFactory {
    private final PooledByteStreams f10595a;
    private final NativeMemoryChunkPool f10596b;

    public NativePooledByteBufferFactory(NativeMemoryChunkPool nativeMemoryChunkPool, PooledByteStreams pooledByteStreams) {
        this.f10596b = nativeMemoryChunkPool;
        this.f10595a = pooledByteStreams;
    }

    public final NativePooledByteBuffer m15776a(InputStream inputStream) {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.f10596b);
        try {
            NativePooledByteBuffer a = m15775a(inputStream, nativePooledByteBufferOutputStream);
            return a;
        } finally {
            nativePooledByteBufferOutputStream.close();
        }
    }

    public final NativePooledByteBuffer m15778a(byte[] bArr) {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.f10596b, bArr.length);
        try {
            nativePooledByteBufferOutputStream.write(bArr, 0, bArr.length);
            NativePooledByteBuffer c = nativePooledByteBufferOutputStream.m22388c();
            nativePooledByteBufferOutputStream.close();
            return c;
        } catch (Throwable e) {
            throw Throwables.m15700b(e);
        } catch (Throwable th) {
            nativePooledByteBufferOutputStream.close();
        }
    }

    public final NativePooledByteBuffer m15777a(InputStream inputStream, int i) {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.f10596b, i);
        try {
            NativePooledByteBuffer a = m15775a(inputStream, nativePooledByteBufferOutputStream);
            return a;
        } finally {
            nativePooledByteBufferOutputStream.close();
        }
    }

    @VisibleForTesting
    private NativePooledByteBuffer m15775a(InputStream inputStream, NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream) {
        this.f10595a.m15787a(inputStream, nativePooledByteBufferOutputStream);
        return nativePooledByteBufferOutputStream.m22388c();
    }

    public final PooledByteBufferOutputStream m15779a() {
        return new NativePooledByteBufferOutputStream(this.f10596b);
    }

    public final PooledByteBufferOutputStream m15780a(int i) {
        return new NativePooledByteBufferOutputStream(this.f10596b, i);
    }
}
