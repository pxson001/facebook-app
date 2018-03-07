package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: mByteBuffer should not be null. */
public class NativePooledByteBufferOutputStream extends PooledByteBufferOutputStream {
    private final NativeMemoryChunkPool f15710a;
    private CloseableReference<NativeMemoryChunk> f15711b;
    private int f15712c;

    public final /* synthetic */ NativePooledByteBuffer mo2897a() {
        return m22388c();
    }

    public NativePooledByteBufferOutputStream(NativeMemoryChunkPool nativeMemoryChunkPool, int i) {
        boolean z;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.a(z);
        this.f15710a = (NativeMemoryChunkPool) Preconditions.a(nativeMemoryChunkPool);
        this.f15712c = 0;
        this.f15711b = CloseableReference.m15676a(this.f15710a.mo2018a(i), this.f15710a);
    }

    public NativePooledByteBufferOutputStream(NativeMemoryChunkPool nativeMemoryChunkPool) {
        this(nativeMemoryChunkPool, nativeMemoryChunkPool.f10597g[0]);
    }

    public final NativePooledByteBuffer m22388c() {
        m22385d();
        return new NativePooledByteBuffer(this.f15711b, this.f15712c);
    }

    public final int mo2898b() {
        return this.f15712c;
    }

    public void write(int i) {
        write(new byte[]{(byte) i});
    }

    public void write(byte[] bArr, int i, int i2) {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new ArrayIndexOutOfBoundsException("length=" + bArr.length + "; regionStart=" + i + "; regionLength=" + i2);
        }
        m22385d();
        m22384a(this.f15712c + i2);
        ((NativeMemoryChunk) this.f15711b.m15682a()).m22395a(this.f15712c, bArr, i, i2);
        this.f15712c += i2;
    }

    public void close() {
        CloseableReference.m15681c(this.f15711b);
        this.f15711b = null;
        this.f15712c = -1;
        super.close();
    }

    @VisibleForTesting
    private void m22384a(int i) {
        m22385d();
        if (i > ((NativeMemoryChunk) this.f15711b.m15682a()).f15714b) {
            NativeMemoryChunk nativeMemoryChunk = (NativeMemoryChunk) this.f15710a.mo2018a(i);
            ((NativeMemoryChunk) this.f15711b.m15682a()).m22396a(0, nativeMemoryChunk, 0, this.f15712c);
            this.f15711b.close();
            this.f15711b = CloseableReference.m15676a(nativeMemoryChunk, this.f15710a);
        }
    }

    private void m22385d() {
        if (!CloseableReference.m15679a(this.f15711b)) {
            throw new InvalidStreamException();
        }
    }
}
