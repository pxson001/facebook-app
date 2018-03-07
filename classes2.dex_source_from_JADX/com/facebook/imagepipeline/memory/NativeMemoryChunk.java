package com.facebook.imagepipeline.memory;

import android.util.Log;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.nativecode.ImagePipelineNativeLoader;
import java.io.Closeable;

@DoNotStrip
/* compiled from: mByteBuffer for DeltaBuffer should not be null */
public class NativeMemoryChunk implements Closeable {
    private final long f15713a;
    public final int f15714b;
    private boolean f15715c;

    @DoNotStrip
    private static native long nativeAllocate(int i);

    @DoNotStrip
    private static native void nativeCopyFromByteArray(long j, byte[] bArr, int i, int i2);

    @DoNotStrip
    private static native void nativeCopyToByteArray(long j, byte[] bArr, int i, int i2);

    @DoNotStrip
    private static native void nativeFree(long j);

    @DoNotStrip
    private static native void nativeMemcpy(long j, long j2, int i);

    @DoNotStrip
    private static native byte nativeReadByte(long j);

    static {
        ImagePipelineNativeLoader.m22611a();
    }

    public NativeMemoryChunk(int i) {
        boolean z;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.a(z);
        this.f15714b = i;
        this.f15713a = nativeAllocate(this.f15714b);
        this.f15715c = false;
    }

    @VisibleForTesting
    public NativeMemoryChunk() {
        this.f15714b = 0;
        this.f15713a = 0;
        this.f15715c = true;
    }

    public synchronized void close() {
        if (!this.f15715c) {
            this.f15715c = true;
            nativeFree(this.f15713a);
        }
    }

    public final synchronized boolean m22397a() {
        return this.f15715c;
    }

    public final int m22398b() {
        return this.f15714b;
    }

    public final synchronized int m22395a(int i, byte[] bArr, int i2, int i3) {
        int a;
        Preconditions.a(bArr);
        Preconditions.b(!m22397a());
        a = m22391a(i, i3);
        m22392a(i, bArr.length, i2, a);
        nativeCopyFromByteArray(this.f15713a + ((long) i), bArr, i2, a);
        return a;
    }

    public final synchronized int m22399b(int i, byte[] bArr, int i2, int i3) {
        int a;
        Preconditions.a(bArr);
        Preconditions.b(!m22397a());
        a = m22391a(i, i3);
        m22392a(i, bArr.length, i2, a);
        nativeCopyToByteArray(this.f15713a + ((long) i), bArr, i2, a);
        return a;
    }

    public final synchronized byte m22394a(int i) {
        byte nativeReadByte;
        boolean z = true;
        synchronized (this) {
            boolean z2;
            if (m22397a()) {
                z2 = false;
            } else {
                z2 = true;
            }
            Preconditions.b(z2);
            if (i >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.a(z2);
            if (i >= this.f15714b) {
                z = false;
            }
            Preconditions.a(z);
            nativeReadByte = nativeReadByte(this.f15713a + ((long) i));
        }
        return nativeReadByte;
    }

    public final void m22396a(int i, NativeMemoryChunk nativeMemoryChunk, int i2, int i3) {
        Preconditions.a(nativeMemoryChunk);
        if (nativeMemoryChunk.f15713a == this.f15713a) {
            Log.w("NativeMemoryChunk", "Copying from NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(this)) + " to NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(nativeMemoryChunk)) + " which share the same address " + Long.toHexString(this.f15713a));
            Preconditions.a(false);
        }
        if (nativeMemoryChunk.f15713a < this.f15713a) {
            synchronized (nativeMemoryChunk) {
                synchronized (this) {
                    m22393b(i, nativeMemoryChunk, i2, i3);
                }
            }
            return;
        }
        synchronized (this) {
            synchronized (nativeMemoryChunk) {
                m22393b(i, nativeMemoryChunk, i2, i3);
            }
        }
    }

    public final long m22400c() {
        return this.f15713a;
    }

    private void m22393b(int i, NativeMemoryChunk nativeMemoryChunk, int i2, int i3) {
        boolean z;
        boolean z2 = true;
        if (m22397a()) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.b(z);
        if (nativeMemoryChunk.m22397a()) {
            z2 = false;
        }
        Preconditions.b(z2);
        m22392a(i, nativeMemoryChunk.f15714b, i2, i3);
        nativeMemcpy(nativeMemoryChunk.f15713a + ((long) i2), this.f15713a + ((long) i), i3);
    }

    protected void finalize() {
        if (!m22397a()) {
            Log.w("NativeMemoryChunk", "finalize: Chunk " + Integer.toHexString(System.identityHashCode(this)) + " still active. Underlying address = " + Long.toHexString(this.f15713a));
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }

    private int m22391a(int i, int i2) {
        return Math.min(Math.max(0, this.f15714b - i), i2);
    }

    private void m22392a(int i, int i2, int i3, int i4) {
        boolean z;
        boolean z2 = true;
        Preconditions.a(i4 >= 0);
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.a(z);
        if (i3 >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.a(z);
        if (i + i4 <= this.f15714b) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.a(z);
        if (i3 + i4 > i2) {
            z2 = false;
        }
        Preconditions.a(z2);
    }
}
