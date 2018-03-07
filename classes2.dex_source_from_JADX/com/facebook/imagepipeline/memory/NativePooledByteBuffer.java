package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.PooledByteBuffer.ClosedException;
import java.io.Closeable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: page/%s/vistor_posts */
public class NativePooledByteBuffer implements Closeable {
    @GuardedBy("this")
    @VisibleForTesting
    CloseableReference<NativeMemoryChunk> f10559a;
    private final int f10560b;

    public NativePooledByteBuffer(CloseableReference<NativeMemoryChunk> closeableReference, int i) {
        boolean z;
        Preconditions.a(closeableReference);
        if (i < 0 || i > ((NativeMemoryChunk) closeableReference.m15682a()).f15714b) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.a(z);
        this.f10559a = closeableReference.m15683b();
        this.f10560b = i;
    }

    public final synchronized int m15689a() {
        m15687d();
        return this.f10560b;
    }

    public final synchronized byte m15688a(int i) {
        byte a;
        boolean z = true;
        synchronized (this) {
            boolean z2;
            m15687d();
            if (i >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.a(z2);
            if (i >= this.f10560b) {
                z = false;
            }
            Preconditions.a(z);
            a = ((NativeMemoryChunk) this.f10559a.m15682a()).m22394a(i);
        }
        return a;
    }

    public final synchronized void m15690a(int i, byte[] bArr, int i2, int i3) {
        m15687d();
        Preconditions.a(i + i3 <= this.f10560b);
        ((NativeMemoryChunk) this.f10559a.m15682a()).m22399b(i, bArr, i2, i3);
    }

    public final synchronized long m15691b() {
        m15687d();
        return ((NativeMemoryChunk) this.f10559a.m15682a()).m22400c();
    }

    public final synchronized boolean m15692c() {
        return !CloseableReference.m15679a(this.f10559a);
    }

    public synchronized void close() {
        CloseableReference.m15681c(this.f10559a);
        this.f10559a = null;
    }

    private synchronized void m15687d() {
        if (m15692c()) {
            throw new ClosedException();
        }
    }
}
