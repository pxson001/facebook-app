package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.ResourceReleaser;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: TOURS_SIGHTSEEING */
public class PooledByteArrayBufferedInputStream extends InputStream {
    private final InputStream f13717a;
    private final byte[] f13718b;
    private final ResourceReleaser<byte[]> f13719c;
    private int f13720d = 0;
    private int f13721e = 0;
    private boolean f13722f = false;

    public PooledByteArrayBufferedInputStream(InputStream inputStream, byte[] bArr, ResourceReleaser<byte[]> resourceReleaser) {
        this.f13717a = (InputStream) Preconditions.a(inputStream);
        this.f13718b = (byte[]) Preconditions.a(bArr);
        this.f13719c = (ResourceReleaser) Preconditions.a(resourceReleaser);
    }

    public int read() {
        Preconditions.b(this.f13721e <= this.f13720d);
        m23064b();
        if (!m23063a()) {
            return -1;
        }
        byte[] bArr = this.f13718b;
        int i = this.f13721e;
        this.f13721e = i + 1;
        return bArr[i] & 255;
    }

    public int read(byte[] bArr, int i, int i2) {
        Preconditions.b(this.f13721e <= this.f13720d);
        m23064b();
        if (!m23063a()) {
            return -1;
        }
        int min = Math.min(this.f13720d - this.f13721e, i2);
        System.arraycopy(this.f13718b, this.f13721e, bArr, i, min);
        this.f13721e += min;
        return min;
    }

    public int available() {
        Preconditions.b(this.f13721e <= this.f13720d);
        m23064b();
        return (this.f13720d - this.f13721e) + this.f13717a.available();
    }

    public void close() {
        if (!this.f13722f) {
            this.f13722f = true;
            this.f13719c.a(this.f13718b);
            super.close();
        }
    }

    public long skip(long j) {
        Preconditions.b(this.f13721e <= this.f13720d);
        m23064b();
        int i = this.f13720d - this.f13721e;
        if (((long) i) >= j) {
            this.f13721e = (int) (((long) this.f13721e) + j);
            return j;
        }
        this.f13721e = this.f13720d;
        return ((long) i) + this.f13717a.skip(j - ((long) i));
    }

    private boolean m23063a() {
        if (this.f13721e < this.f13720d) {
            return true;
        }
        int read = this.f13717a.read(this.f13718b);
        if (read <= 0) {
            return false;
        }
        this.f13720d = read;
        this.f13721e = 0;
        return true;
    }

    private void m23064b() {
        if (this.f13722f) {
            throw new IOException("stream already closed");
        }
    }

    protected void finalize() {
        if (!this.f13722f) {
            FLog.b("PooledByteInputStream", "Finalized without closing");
            close();
        }
        super.finalize();
    }
}
