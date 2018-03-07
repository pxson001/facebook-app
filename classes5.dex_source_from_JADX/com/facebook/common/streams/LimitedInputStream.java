package com.facebook.common.streams;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: aircraft_type_label */
public class LimitedInputStream extends FilterInputStream {
    private int f11119a;
    private int f11120b;

    public LimitedInputStream(InputStream inputStream, int i) {
        super(inputStream);
        if (inputStream == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("limit must be >= 0");
        } else {
            this.f11119a = i;
            this.f11120b = -1;
        }
    }

    public int read() {
        if (this.f11119a == 0) {
            return -1;
        }
        int read = this.in.read();
        if (read != -1) {
            this.f11119a--;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.f11119a == 0) {
            return -1;
        }
        int read = this.in.read(bArr, i, Math.min(i2, this.f11119a));
        if (read <= 0) {
            return read;
        }
        this.f11119a -= read;
        return read;
    }

    public long skip(long j) {
        long skip = this.in.skip(Math.min(j, (long) this.f11119a));
        this.f11119a = (int) (((long) this.f11119a) - skip);
        return skip;
    }

    public int available() {
        return Math.min(this.in.available(), this.f11119a);
    }

    public void mark(int i) {
        if (this.in.markSupported()) {
            this.in.mark(i);
            this.f11120b = this.f11119a;
        }
    }

    public void reset() {
        if (!this.in.markSupported()) {
            throw new IOException("mark is not supported");
        } else if (this.f11120b == -1) {
            throw new IOException("mark not set");
        } else {
            this.in.reset();
            this.f11119a = this.f11120b;
        }
    }
}
