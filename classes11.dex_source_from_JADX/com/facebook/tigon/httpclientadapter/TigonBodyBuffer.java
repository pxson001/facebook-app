package com.facebook.tigon.httpclientadapter;

import com.facebook.tigon.tigonapi.TigonDirectBufferRelease;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: notoken */
public class TigonBodyBuffer extends InputStream {
    private static final Class<TigonBodyBuffer> f4918a = TigonBodyBuffer.class;
    private final TigonDirectBufferRelease f4919b;
    private final ReentrantLock f4920c = new ReentrantLock();
    private final Condition f4921d = this.f4920c.newCondition();
    private final ArrayList<ByteBuffer> f4922e = new ArrayList();
    public volatile boolean f4923f = false;
    private Throwable f4924g = null;
    private int f4925h;
    public volatile boolean f4926i = false;
    public volatile boolean f4927j = false;

    public TigonBodyBuffer(TigonDirectBufferRelease tigonDirectBufferRelease, int i) {
        this.f4919b = tigonDirectBufferRelease;
        this.f4925h = i;
        Integer.valueOf(this.f4925h);
    }

    protected void finalize() {
        m6224a();
        int size = this.f4922e.size();
        for (int i = 0; i < size; i++) {
            m6218b((ByteBuffer) this.f4922e.get(i));
        }
        this.f4922e.clear();
        super.finalize();
    }

    public void close() {
        try {
            this.f4920c.lock();
            m6219c();
        } finally {
            this.f4920c.unlock();
            super.close();
            this.f4927j = true;
        }
    }

    private void m6219c() {
        if (this.f4924g != null) {
            throw new IOException(this.f4924g);
        }
    }

    public final void m6226a(ByteBuffer byteBuffer) {
        try {
            this.f4920c.lock();
            if (this.f4923f) {
                throw new IllegalStateException("Writing to closed buffer");
            }
            Preconditions.checkArgument(byteBuffer.remaining() == byteBuffer.capacity());
            if (byteBuffer.hasRemaining()) {
                this.f4922e.add(byteBuffer);
                this.f4921d.signalAll();
            }
            this.f4920c.unlock();
        } catch (Throwable th) {
            this.f4920c.unlock();
        }
    }

    public final void m6224a() {
        try {
            this.f4920c.lock();
            m6217b(null);
        } finally {
            this.f4920c.unlock();
        }
    }

    public final void m6225a(Throwable th) {
        try {
            this.f4920c.lock();
            m6217b(th);
        } finally {
            this.f4920c.unlock();
        }
    }

    private void m6217b(Throwable th) {
        Integer.valueOf(this.f4925h);
        this.f4923f = true;
        if (this.f4924g != null) {
            th = this.f4924g;
        }
        this.f4924g = th;
        this.f4921d.signalAll();
    }

    public int available() {
        try {
            this.f4920c.lock();
            int i = 0;
            for (int i2 = 0; i2 < this.f4922e.size(); i2++) {
                i += ((ByteBuffer) this.f4922e.get(i2)).remaining();
            }
            return i;
        } finally {
            this.f4920c.unlock();
        }
    }

    public int read() {
        try {
            this.f4920c.lock();
            m6220d();
            if (m6221e()) {
                m6219c();
                return -1;
            }
            int f = m6222f();
            this.f4920c.unlock();
            return f;
        } finally {
            this.f4920c.unlock();
        }
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            this.f4920c.lock();
            m6220d();
            if (m6221e()) {
                m6219c();
                return -1;
            } else if (i2 <= 0) {
                this.f4920c.unlock();
                return 0;
            } else {
                int i3;
                int i4 = i2;
                while (i4 > 0) {
                    ByteBuffer byteBuffer;
                    if (this.f4922e.isEmpty()) {
                        byteBuffer = null;
                    } else {
                        byteBuffer = (ByteBuffer) this.f4922e.get(0);
                    }
                    if (byteBuffer == null) {
                        break;
                    }
                    int min = Math.min(byteBuffer.remaining(), i4);
                    byteBuffer.get(bArr, i, min);
                    i3 = i4 - min;
                    i += min;
                    m6223g();
                    i4 = i3;
                }
                i3 = i2 - i4;
                this.f4920c.unlock();
                return i3;
            }
        } finally {
            this.f4920c.unlock();
        }
    }

    public long skip(long j) {
        try {
            this.f4920c.lock();
            if (j <= 0) {
                return 0;
            }
            long j2;
            long j3 = j;
            while (j3 > 0) {
                ByteBuffer byteBuffer;
                if (this.f4922e.isEmpty()) {
                    byteBuffer = null;
                } else {
                    byteBuffer = (ByteBuffer) this.f4922e.get(0);
                }
                if (byteBuffer == null) {
                    break;
                }
                int min = (int) Math.min((long) byteBuffer.remaining(), j3);
                byteBuffer.position(byteBuffer.position() + min);
                j2 = j3 - ((long) min);
                m6223g();
                j3 = j2;
            }
            if (j == j3) {
                m6219c();
            }
            j2 = j - j3;
            this.f4920c.unlock();
            return j2;
        } finally {
            this.f4920c.unlock();
        }
    }

    private void m6220d() {
        while (!this.f4923f && this.f4922e.isEmpty()) {
            Integer.valueOf(this.f4925h);
            this.f4926i = true;
            try {
                this.f4921d.awaitUninterruptibly();
                this.f4926i = false;
            } catch (Throwable th) {
                this.f4926i = false;
            }
        }
    }

    private boolean m6221e() {
        return this.f4923f && this.f4922e.isEmpty();
    }

    private int m6222f() {
        Preconditions.checkState(!this.f4922e.isEmpty());
        ByteBuffer byteBuffer = (ByteBuffer) this.f4922e.get(0);
        Preconditions.checkState(byteBuffer.hasRemaining());
        byte b = byteBuffer.get();
        m6223g();
        return b;
    }

    private void m6223g() {
        Preconditions.checkState(!this.f4922e.isEmpty());
        if (!((ByteBuffer) this.f4922e.get(0)).hasRemaining()) {
            m6218b((ByteBuffer) this.f4922e.remove(0));
        }
    }

    private void m6218b(ByteBuffer byteBuffer) {
        this.f4919b.releaseBodyBuffer(byteBuffer);
    }
}
