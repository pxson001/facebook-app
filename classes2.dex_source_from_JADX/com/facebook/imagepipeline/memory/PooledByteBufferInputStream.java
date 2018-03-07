package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: latency_based */
public class PooledByteBufferInputStream extends InputStream {
    @VisibleForTesting
    final NativePooledByteBuffer f17769a;
    @VisibleForTesting
    int f17770b;
    @VisibleForTesting
    int f17771c;

    public PooledByteBufferInputStream(NativePooledByteBuffer nativePooledByteBuffer) {
        boolean z;
        if (nativePooledByteBuffer.m15692c()) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.a(z);
        this.f17769a = (NativePooledByteBuffer) Preconditions.a(nativePooledByteBuffer);
        this.f17770b = 0;
        this.f17771c = 0;
    }

    public int available() {
        return this.f17769a.m15689a() - this.f17770b;
    }

    public void mark(int i) {
        this.f17771c = this.f17770b;
    }

    public boolean markSupported() {
        return true;
    }

    public int read() {
        if (available() <= 0) {
            return -1;
        }
        NativePooledByteBuffer nativePooledByteBuffer = this.f17769a;
        int i = this.f17770b;
        this.f17770b = i + 1;
        return nativePooledByteBuffer.m15688a(i) & 255;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new ArrayIndexOutOfBoundsException("length=" + bArr.length + "; regionStart=" + i + "; regionLength=" + i2);
        }
        int available = available();
        if (available <= 0) {
            return -1;
        }
        if (i2 <= 0) {
            return 0;
        }
        available = Math.min(available, i2);
        this.f17769a.m15690a(this.f17770b, bArr, i, available);
        this.f17770b += available;
        return available;
    }

    public void reset() {
        this.f17770b = this.f17771c;
    }

    public long skip(long j) {
        Preconditions.a(j >= 0);
        int min = Math.min((int) j, available());
        this.f17770b += min;
        return (long) min;
    }
}
