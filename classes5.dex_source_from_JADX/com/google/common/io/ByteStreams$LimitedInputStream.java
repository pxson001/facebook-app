package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: source_location */
final class ByteStreams$LimitedInputStream extends FilterInputStream {
    private long f7649a;
    private long f7650b = -1;

    ByteStreams$LimitedInputStream(InputStream inputStream, long j) {
        super(inputStream);
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkArgument(j >= 0, "limit must be non-negative");
        this.f7649a = j;
    }

    public final int available() {
        return (int) Math.min((long) this.in.available(), this.f7649a);
    }

    public final synchronized void mark(int i) {
        this.in.mark(i);
        this.f7650b = this.f7649a;
    }

    public final int read() {
        if (this.f7649a == 0) {
            return -1;
        }
        int read = this.in.read();
        if (read != -1) {
            this.f7649a--;
        }
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (this.f7649a == 0) {
            return -1;
        }
        int read = this.in.read(bArr, i, (int) Math.min((long) i2, this.f7649a));
        if (read != -1) {
            this.f7649a -= (long) read;
        }
        return read;
    }

    public final synchronized void reset() {
        if (!this.in.markSupported()) {
            throw new IOException("Mark not supported");
        } else if (this.f7650b == -1) {
            throw new IOException("Mark not set");
        } else {
            this.in.reset();
            this.f7649a = this.f7650b;
        }
    }

    public final long skip(long j) {
        long skip = this.in.skip(Math.min(j, this.f7649a));
        this.f7649a -= skip;
        return skip;
    }
}
