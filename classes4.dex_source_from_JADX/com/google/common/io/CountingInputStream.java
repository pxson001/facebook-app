package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Beta
/* compiled from: seen = ? AND user_id = ? */
public final class CountingInputStream extends FilterInputStream {
    public long f2884a;
    private long f2885b = -1;

    public CountingInputStream(InputStream inputStream) {
        super((InputStream) Preconditions.checkNotNull(inputStream));
    }

    public final long m3146a() {
        return this.f2884a;
    }

    public final int read() {
        int read = this.in.read();
        if (read != -1) {
            this.f2884a++;
        }
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        int read = this.in.read(bArr, i, i2);
        if (read != -1) {
            this.f2884a += (long) read;
        }
        return read;
    }

    public final long skip(long j) {
        long skip = this.in.skip(j);
        this.f2884a += skip;
        return skip;
    }

    public final synchronized void mark(int i) {
        this.in.mark(i);
        this.f2885b = this.f2884a;
    }

    public final synchronized void reset() {
        if (!this.in.markSupported()) {
            throw new IOException("Mark not supported");
        } else if (this.f2885b == -1) {
            throw new IOException("Mark not set");
        } else {
            this.in.reset();
            this.f2884a = this.f2885b;
        }
    }
}
