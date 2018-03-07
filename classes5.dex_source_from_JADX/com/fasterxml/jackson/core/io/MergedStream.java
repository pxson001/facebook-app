package com.fasterxml.jackson.core.io;

import java.io.InputStream;

/* compiled from: collection_type_list */
public final class MergedStream extends InputStream {
    protected final IOContext f5947a;
    final InputStream f5948b;
    byte[] f5949c;
    int f5950d;
    final int f5951e;

    public MergedStream(IOContext iOContext, InputStream inputStream, byte[] bArr, int i, int i2) {
        this.f5947a = iOContext;
        this.f5948b = inputStream;
        this.f5949c = bArr;
        this.f5950d = i;
        this.f5951e = i2;
    }

    public final int available() {
        if (this.f5949c != null) {
            return this.f5951e - this.f5950d;
        }
        return this.f5948b.available();
    }

    public final void close() {
        m10754a();
        this.f5948b.close();
    }

    public final void mark(int i) {
        if (this.f5949c == null) {
            this.f5948b.mark(i);
        }
    }

    public final boolean markSupported() {
        return this.f5949c == null && this.f5948b.markSupported();
    }

    public final int read() {
        if (this.f5949c == null) {
            return this.f5948b.read();
        }
        byte[] bArr = this.f5949c;
        int i = this.f5950d;
        this.f5950d = i + 1;
        int i2 = bArr[i] & 255;
        if (this.f5950d < this.f5951e) {
            return i2;
        }
        m10754a();
        return i2;
    }

    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (this.f5949c == null) {
            return this.f5948b.read(bArr, i, i2);
        }
        int i3 = this.f5951e - this.f5950d;
        if (i2 > i3) {
            i2 = i3;
        }
        System.arraycopy(this.f5949c, this.f5950d, bArr, i, i2);
        this.f5950d += i2;
        if (this.f5950d < this.f5951e) {
            return i2;
        }
        m10754a();
        return i2;
    }

    public final void reset() {
        if (this.f5949c == null) {
            this.f5948b.reset();
        }
    }

    public final long skip(long j) {
        long j2;
        if (this.f5949c != null) {
            int i = this.f5951e - this.f5950d;
            if (((long) i) > j) {
                this.f5950d += (int) j;
                return j;
            }
            m10754a();
            j2 = ((long) i) + 0;
            j -= (long) i;
        } else {
            j2 = 0;
        }
        if (j > 0) {
            j2 += this.f5948b.skip(j);
        }
        return j2;
    }

    private void m10754a() {
        byte[] bArr = this.f5949c;
        if (bArr != null) {
            this.f5949c = null;
            if (this.f5947a != null) {
                this.f5947a.a(bArr);
            }
        }
    }
}
